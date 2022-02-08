/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIBossJumpAttack;
import lotr.common.entity.ai.LOTREntityAIRangedAttack;
import lotr.common.entity.npc.LOTRBoss;
import lotr.common.entity.npc.LOTRBossInfo;
import lotr.common.entity.npc.LOTREntityMountainTroll;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTREntityTroll;
import lotr.common.entity.projectile.LOTREntityThrownRock;
import lotr.common.item.LOTRItemBossTrophy;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class LOTREntityMountainTrollChieftain
extends LOTREntityMountainTroll
implements LOTRBoss {
    private static final int SPAWN_TIME = 100;
    private int trollDeathTick;
    private int healAmount;

    public LOTREntityMountainTrollChieftain(World world) {
        super(world);
        this.tasks.addTask(2, (EntityAIBase)new LOTREntityAIBossJumpAttack(this, 1.5, 0.03f));
    }

    @Override
    public float getTrollScale() {
        return 2.0f;
    }

    @Override
    protected EntityAIBase getTrollRangedAttackAI() {
        return new LOTREntityAIRangedAttack(this, 1.2, 20, 50, 24.0f);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(22, (short)0);
        this.dataWatcher.addObject(23, (int)-1);
        this.dataWatcher.addObject(24, (byte)2);
    }

    @Override
    public boolean hasTwoHeads() {
        return true;
    }

    public int getTrollSpawnTick() {
        return this.dataWatcher.getWatchableObjectShort(22);
    }

    public void setTrollSpawnTick(int i) {
        this.dataWatcher.updateObject(22, ((short)i));
    }

    public int getHealingEntityID() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public void setHealingEntityID(int i) {
        this.dataWatcher.updateObject(23, (Object)i);
    }

    public int getTrollArmorLevel() {
        return this.dataWatcher.getWatchableObjectByte(24);
    }

    public void setTrollArmorLevel(int i) {
        this.dataWatcher.updateObject(24, (Object)((byte)i));
    }

    @Override
    public int getTotalArmorValue() {
        return 12;
    }

    public float getArmorLevelChanceModifier() {
        int i = 3 - this.getTrollArmorLevel();
        if (i < 1) {
            i = 1;
        }
        return i;
    }

    @Override
    public float getBaseChanceModifier() {
        return this.bossInfo.getHealthChanceModifier() * this.getArmorLevelChanceModifier();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2);
        this.getEntityAttribute(npcAttackDamage).setBaseValue(8.0);
        this.getEntityAttribute(thrownRockDamage).setBaseValue(8.0);
    }

    public float getSpawningOffset(float f) {
        float f1 = ((float)this.getTrollSpawnTick() + f) / 100.0f;
        f1 = Math.min(f1, 1.0f);
        return (1.0f - f1) * -5.0f;
    }

    @Override
    public void onLivingUpdate() {
        double d1;
        double d2;
        LOTREntityThrownRock rock;
        super.onLivingUpdate();
        if (this.getTrollSpawnTick() < 100) {
            if (!this.worldObj.isRemote) {
                this.setTrollSpawnTick(this.getTrollSpawnTick() + 1);
                if (this.getTrollSpawnTick() == 100) {
                    this.bossInfo.doJumpAttack(1.5);
                }
            } else {
                for (int l = 0; l < 32; ++l) {
                    double d = this.posX + this.rand.nextGaussian() * (double)this.width * 0.5;
                    d1 = this.posY + this.rand.nextDouble() * (double)this.height + (double)this.getSpawningOffset(0.0f);
                    d2 = this.posZ + this.rand.nextGaussian() * (double)this.width * 0.5;
                    LOTRMod.proxy.spawnParticle("mtcSpawn", d, d1, d2, 0.0, 0.0, 0.0);
                }
            }
        }
        if (this.worldObj.isRemote && this.getTrollArmorLevel() == 0) {
            for (int i = 0; i < 4; ++i) {
                this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
            }
        }
        if (!(this.worldObj.isRemote || this.getTrollBurnTime() < 0 && this.trollDeathTick <= 0)) {
            if (this.trollDeathTick == 0) {
                this.worldObj.playSoundAtEntity((Entity)this, "lotr:troll.transform", this.getSoundVolume(), this.getSoundPitch());
            }
            if (this.trollDeathTick % 5 == 0) {
                this.worldObj.setEntityState((Entity)this, (byte)15);
            }
            if (this.trollDeathTick % 10 == 0) {
                this.playSound(this.getLivingSound(), this.getSoundVolume() * 2.0f, 0.8f);
            }
            ++this.trollDeathTick;
            this.rotationYaw += 60.0f * (this.rand.nextFloat() - 0.5f);
            this.rotationYawHead += 60.0f * (this.rand.nextFloat() - 0.5f);
            this.rotationPitch += 60.0f * (this.rand.nextFloat() - 0.5f);
            this.limbSwingAmount += 60.0f * (this.rand.nextFloat() - 0.5f);
            if (this.trollDeathTick >= 200) {
                this.setDead();
            }
        }
        if (!this.worldObj.isRemote && this.getHealth() < this.getMaxHealth()) {
            List nearbyTrolls;
            LOTREntityTroll troll;
            float f = this.getBaseChanceModifier();
            f *= 0.02f;
            if (this.rand.nextFloat() < f && !(nearbyTrolls = this.worldObj.getEntitiesWithinAABB(LOTREntityTroll.class, this.boundingBox.expand(24.0, 8.0, 24.0))).isEmpty() && !((troll = (LOTREntityTroll)nearbyTrolls.get(this.rand.nextInt(nearbyTrolls.size()))) instanceof LOTREntityMountainTrollChieftain) && troll.isEntityAlive()) {
                this.setHealingEntityID(troll.getEntityId());
                this.healAmount = 8 + this.rand.nextInt(3);
            }
        }
        if (this.getHealingEntityID() != -1) {
            Entity entity = this.worldObj.getEntityByID(this.getHealingEntityID());
            if (entity != null && entity instanceof LOTREntityTroll && entity.isEntityAlive()) {
                if (!this.worldObj.isRemote) {
                    if (this.ticksExisted % 20 == 0) {
                        this.heal(3.0f);
                        entity.attackEntityFrom(DamageSource.generic, 3.0f);
                        --this.healAmount;
                        if (!entity.isEntityAlive() || this.getHealth() >= this.getMaxHealth() || this.healAmount <= 0) {
                            this.setHealingEntityID(-1);
                        }
                    }
                } else {
                    double d = entity.posX;
                    d1 = entity.posY + (double)entity.height / 2.0;
                    d2 = entity.posZ;
                    double d3 = this.posX - d;
                    double d4 = this.posY + (double)this.height / 2.0 - d1;
                    double d5 = this.posZ - d2;
                    LOTRMod.proxy.spawnParticle("mtcHeal", d, d1, d2, d3 /= 30.0, d4 /= 30.0, d5 /= 30.0);
                }
            } else if (!this.worldObj.isRemote) {
                this.setHealingEntityID(-1);
            }
        }
        if (!this.worldObj.isRemote && this.getHealth() < this.getMaxHealth() && this.rand.nextInt(50) == 0 && !this.isThrowingRocks() && (rock = this.getThrownRock()).getSpawnsTroll()) {
            rock.setLocationAndAngles(this.posX, this.posY + (double)this.height, this.posZ, 0.0f, 0.0f);
            rock.motionX = 0.0;
            rock.motionY = 1.5;
            rock.motionZ = 0.0;
            this.worldObj.spawnEntityInWorld((Entity)rock);
            this.swingItem();
        }
        if (!this.worldObj.isRemote) {
            float f = this.getBaseChanceModifier();
            f *= 0.05f;
            if (this.rand.nextFloat() < f) {
                this.bossInfo.doTargetedJumpAttack(1.5);
            }
        }
    }

    protected boolean isMovementBlocked() {
        if (this.getTrollSpawnTick() < 100 || this.trollDeathTick > 0) {
            return true;
        }
        return super.isMovementBlocked();
    }

    @Override
    public void onJumpAttackFall() {
        this.worldObj.setEntityState((Entity)this, (byte)20);
        this.playSound("lotr:troll.rockSmash", 1.5f, 0.75f);
    }

    @SideOnly(value=Side.CLIENT)
    @Override
    public void handleHealthUpdate(byte b) {
        if (b == 20) {
            for (int i = 0; i < 360; i += 2) {
                float angle = (float)Math.toRadians(i);
                double distance = 2.0;
                double d = distance * (double)MathHelper.sin((float)angle);
                double d1 = distance * (double)MathHelper.cos((float)angle);
                LOTRMod.proxy.spawnParticle("largeStone", this.posX + d, this.boundingBox.minY + 0.1, this.posZ + d1, d * 0.2, 0.2, d1 * 0.2);
            }
        } else if (b == 21) {
            for (int i = 0; i < 64; ++i) {
                LOTRMod.proxy.spawnParticle("mtcArmor", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, 0.0, 0.0, 0.0);
            }
        } else {
            super.handleHealthUpdate(b);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("TrollSpawnTick", this.getTrollSpawnTick());
        nbt.setInteger("TrollDeathTick", this.trollDeathTick);
        nbt.setInteger("TrollArmorLevel", this.getTrollArmorLevel());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setTrollSpawnTick(nbt.getInteger("TrollSpawnTick"));
        this.trollDeathTick = nbt.getInteger("TrollDeathTick");
        if (nbt.hasKey("TrollArmorLevel")) {
            this.setTrollArmorLevel(nbt.getInteger("TrollArmorLevel"));
        }
    }

    @Override
    protected LOTREntityThrownRock getThrownRock() {
        LOTREntityThrownRock rock = super.getThrownRock();
        float f = this.getBaseChanceModifier();
        f *= 0.4f;
        int maxNearbyTrolls = 5;
        List nearbyTrolls = this.worldObj.getEntitiesWithinAABB(LOTREntityTroll.class, this.boundingBox.expand(24.0, 8.0, 24.0));
        float nearbyModifier = (float)(maxNearbyTrolls - nearbyTrolls.size()) / (float)maxNearbyTrolls;
        f *= nearbyModifier;
        if (this.rand.nextFloat() < f) {
            rock.setSpawnsTroll(true);
        }
        return rock;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float f) {
        if (this.getTrollSpawnTick() < 100 || this.trollDeathTick > 0) {
            return false;
        }
        if (LOTRMod.getDamagingPlayerIncludingUnits(damagesource) == null && f > 1.0f) {
            f = 1.0f;
        }
        boolean flag = super.attackEntityFrom(damagesource, f);
        return flag;
    }

    @Override
    protected void damageEntity(DamageSource damagesource, float f) {
        super.damageEntity(damagesource, f);
        if (!this.worldObj.isRemote && this.getTrollArmorLevel() > 0 && this.getHealth() <= 0.0f) {
            this.setTrollArmorLevel(this.getTrollArmorLevel() - 1);
            if (this.getTrollArmorLevel() == 0) {
                double speed = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(speed *= 1.5);
            }
            double maxHealth = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(maxHealth *= 2.0);
            this.setHealth(this.getMaxHealth());
            this.worldObj.setEntityState((Entity)this, (byte)21);
        }
    }

    @Override
    public void dropFewItems(boolean flag, int i) {
        int dropped;
        super.dropFewItems(flag, i);
        int drops = 3 + this.rand.nextInt(4) + this.rand.nextInt(i * 2 + 1);
        for (int j = 0; j < drops; ++j) {
            this.dropTrollItems(flag, i);
        }
        int bones = MathHelper.getRandomIntegerInRange((Random)this.rand, (int)4, (int)8) + this.rand.nextInt(i * 3 + 1);
        for (int j = 0; j < bones; ++j) {
            this.dropItem(LOTRMod.trollBone, 1);
        }
        for (int coins = MathHelper.getRandomIntegerInRange((Random)this.rand, (int)50, (int)(100 + i * 100)); coins > 0; coins -= dropped) {
            dropped = Math.min(20, coins);
            this.dropItem(LOTRMod.silverCoin, dropped);
        }
        this.dropChestContents(LOTRChestContents.TROLL_HOARD, 5, 8 + i * 3);
        this.entityDropItem(new ItemStack(LOTRMod.bossTrophy, 1, LOTRItemBossTrophy.TrophyType.MOUNTAIN_TROLL_CHIEFTAIN.trophyID), 0.0f);
        float swordChance = 0.3f;
        swordChance += (float)i * 0.1f;
        if (this.rand.nextFloat() < swordChance) {
            this.dropItem(LOTRMod.swordGondolin, 1);
        }
        float armorChance = 0.2f;
        armorChance += (float)i * 0.05f;
        if (this.rand.nextFloat() < armorChance) {
            this.dropItem(LOTRMod.helmetGondolin, 1);
        }
        if (this.rand.nextFloat() < armorChance) {
            this.dropItem(LOTRMod.bodyGondolin, 1);
        }
        if (this.rand.nextFloat() < armorChance) {
            this.dropItem(LOTRMod.legsGondolin, 1);
        }
        if (this.rand.nextFloat() < armorChance) {
            this.dropItem(LOTRMod.bootsGondolin, 1);
        }
    }

    @Override
    protected void dropTrollTotemPart(boolean flag, int i) {
    }

    @Override
    public LOTRAchievement getBossKillAchievement() {
        return LOTRAchievement.killMountainTrollChieftain;
    }

    @Override
    public float getAlignmentBonus() {
        return 50.0f;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer entityplayer) {
        return 100;
    }
}

