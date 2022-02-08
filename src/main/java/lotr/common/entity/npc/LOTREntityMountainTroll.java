/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.ai.attributes.RangedAttribute
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.ai.LOTREntityAIRangedAttack;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTREntityTroll;
import lotr.common.entity.projectile.LOTREntityThrownRock;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class LOTREntityMountainTroll
extends LOTREntityTroll {
    public static IAttribute thrownRockDamage = new RangedAttribute("lotr.thrownRockDamage", 5.0, 0.0, 100.0).setDescription("LOTR Thrown Rock Damage");
    private EntityAIBase rangedAttackAI = this.getTrollRangedAttackAI();
    private EntityAIBase meleeAttackAI;
    private boolean canDropTrollTotem = true;

    public LOTREntityMountainTroll(World world) {
        super(world);
    }

    @Override
    public float getTrollScale() {
        return 1.6f;
    }

    @Override
    public EntityAIBase getTrollAttackAI() {
        this.meleeAttackAI = new LOTREntityAIAttackOnCollide(this, 1.8, false);
        return this.meleeAttackAI;
    }

    protected EntityAIBase getTrollRangedAttackAI() {
        return new LOTREntityAIRangedAttack(this, 1.2, 30, 60, 24.0f);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(21, (Object)0);
    }

    public boolean isThrowingRocks() {
        return this.dataWatcher.getWatchableObjectByte(21) == 1;
    }

    public void setThrowingRocks(boolean flag) {
        this.dataWatcher.updateObject(21, (Object)(flag ? (byte)1 : 0));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70.0);
        this.getEntityAttribute(npcAttackDamage).setBaseValue(7.0);
        this.getAttributeMap().registerAttribute(thrownRockDamage);
    }

    @Override
    protected boolean hasTrollName() {
        return false;
    }

    @Override
    protected boolean canTrollBeTickled(EntityPlayer entityplayer) {
        return false;
    }

    @Override
    public double getMeleeRange() {
        return 12.0;
    }

    @Override
    public void onAttackModeChange(LOTREntityNPC.AttackMode mode, boolean mounted) {
        if (mode == LOTREntityNPC.AttackMode.IDLE) {
            this.tasks.removeTask(this.meleeAttackAI);
            this.tasks.removeTask(this.rangedAttackAI);
            this.setThrowingRocks(false);
        }
        if (mode == LOTREntityNPC.AttackMode.MELEE) {
            this.tasks.removeTask(this.meleeAttackAI);
            this.tasks.removeTask(this.rangedAttackAI);
            this.tasks.addTask(3, this.meleeAttackAI);
            this.setThrowingRocks(false);
        }
        if (mode == LOTREntityNPC.AttackMode.RANGED) {
            this.tasks.removeTask(this.meleeAttackAI);
            this.tasks.removeTask(this.rangedAttackAI);
            this.tasks.addTask(3, this.rangedAttackAI);
            this.setThrowingRocks(true);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        EntityArrow template = new EntityArrow(this.worldObj, (EntityLivingBase)this, target, f * 1.5f, 0.5f);
        LOTREntityThrownRock rock = this.getThrownRock();
        rock.setLocationAndAngles(template.posX, template.posY, template.posZ, template.rotationYaw, template.rotationPitch);
        rock.motionX = template.motionX;
        rock.motionY = template.motionY + 0.6;
        rock.motionZ = template.motionZ;
        this.worldObj.spawnEntityInWorld((Entity)rock);
        this.playSound(this.getLivingSound(), this.getSoundVolume(), this.getSoundPitch() * 0.75f);
        this.swingItem();
    }

    protected LOTREntityThrownRock getThrownRock() {
        LOTREntityThrownRock rock = new LOTREntityThrownRock(this.worldObj, (EntityLivingBase)this);
        rock.setDamage((float)this.getEntityAttribute(thrownRockDamage).getAttributeValue());
        return rock;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("CanDropTrollTotem", this.canDropTrollTotem);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        if (nbt.hasKey("CanDropTrollTotem")) {
            this.setCanDropTrollTotem(nbt.getBoolean("CanDropTrollTotem"));
        }
    }

    @Override
    public void onTrollDeathBySun() {
        this.worldObj.playSoundAtEntity((Entity)this, "lotr:troll.transform", this.getSoundVolume(), this.getSoundPitch());
        this.worldObj.setEntityState((Entity)this, (byte)15);
        this.setDead();
    }

    @SideOnly(value=Side.CLIENT)
    @Override
    public void handleHealthUpdate(byte b) {
        if (b == 15) {
            super.handleHealthUpdate(b);
            for (int l = 0; l < 64; ++l) {
                LOTRMod.proxy.spawnParticle("largeStone", this.posX + this.rand.nextGaussian() * (double)this.width * 0.5, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + this.rand.nextGaussian() * (double)this.width * 0.5, 0.0, 0.0, 0.0);
            }
        } else {
            super.handleHealthUpdate(b);
        }
    }

    @Override
    public void dropFewItems(boolean flag, int i) {
        super.dropFewItems(flag, i);
        if (this.canDropTrollTotem) {
            this.dropTrollTotemPart(flag, i);
        }
    }

    protected void dropTrollTotemPart(boolean flag, int i) {
        int totemChance = 15 - i * 3;
        if (this.rand.nextInt(totemChance = Math.max(totemChance, 1)) == 0) {
            this.entityDropItem(new ItemStack(LOTRMod.trollTotem, 1, this.rand.nextInt(3)), 0.0f);
        }
    }

    public LOTREntityMountainTroll setCanDropTrollTotem(boolean flag) {
        this.canDropTrollTotem = flag;
        return this;
    }

    @Override
    protected LOTRAchievement getKillAchievement() {
        return LOTRAchievement.killMountainTroll;
    }

    @Override
    public float getAlignmentBonus() {
        return 4.0f;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer entityplayer) {
        return 7 + this.rand.nextInt(6);
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        return null;
    }
}

