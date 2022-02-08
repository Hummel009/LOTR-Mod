/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.entity.DataWatcher
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.MovingObjectPosition$MovingObjectType
 *  net.minecraft.world.World
 */
package lotr.common.entity.projectile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityMountainTroll;
import lotr.common.entity.npc.LOTREntityTroll;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class LOTREntityThrownRock
extends EntityThrowable {
    private int rockRotation;
    private float damage;

    public LOTREntityThrownRock(World world) {
        super(world);
        this.setSize(4.0f, 4.0f);
    }

    public LOTREntityThrownRock(World world, EntityLivingBase entityliving) {
        super(world, entityliving);
        this.setSize(4.0f, 4.0f);
    }

    public LOTREntityThrownRock(World world, double d, double d1, double d2) {
        super(world, d, d1, d2);
        this.setSize(4.0f, 4.0f);
    }

    public void setDamage(float f) {
        this.damage = f;
    }

    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)0);
    }

    public boolean getSpawnsTroll() {
        return this.dataWatcher.getWatchableObjectByte(16) == 1;
    }

    public void setSpawnsTroll(boolean flag) {
        this.dataWatcher.updateObject(16, (Object)(flag ? (byte)1 : 0));
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.inGround) {
            ++this.rockRotation;
            if (this.rockRotation > 60) {
                this.rockRotation = 0;
            }
            this.rotationPitch = (float)this.rockRotation / 60.0f * 360.0f;
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setFloat("RockDamage", this.damage);
        nbt.setBoolean("Troll", this.getSpawnsTroll());
    }

    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setDamage(nbt.getFloat("RockDamage"));
        this.setSpawnsTroll(nbt.getBoolean("Troll"));
    }

    protected void onImpact(MovingObjectPosition m) {
        if (!this.worldObj.isRemote) {
            boolean flag = false;
            if (m.entityHit != null && m.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), this.damage)) {
                flag = true;
            }
            if (m.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                flag = true;
            }
            if (flag) {
                if (this.getSpawnsTroll()) {
                    LOTREntityTroll troll = new LOTREntityTroll(this.worldObj);
                    if (this.rand.nextInt(3) == 0) {
                        troll = new LOTREntityMountainTroll(this.worldObj).setCanDropTrollTotem(false);
                    }
                    troll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0f, 0.0f);
                    troll.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld((Entity)troll);
                }
                this.worldObj.setEntityState((Entity)this, (byte)15);
                int drops = 1 + this.rand.nextInt(3);
                for (int l = 0; l < drops; ++l) {
                    this.dropItem(Item.getItemFromBlock((Block)Blocks.cobblestone), 1);
                }
                this.playSound("lotr:troll.rockSmash", 2.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
                this.setDead();
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte b) {
        if (b == 15) {
            for (int l = 0; l < 32; ++l) {
                LOTRMod.proxy.spawnParticle("largeStone", this.posX + this.rand.nextGaussian() * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + this.rand.nextGaussian() * (double)this.width, 0.0, 0.0, 0.0);
            }
        } else {
            super.handleHealthUpdate(b);
        }
    }

    protected float func_70182_d() {
        return 0.75f;
    }

    protected float getGravityVelocity() {
        return 0.1f;
    }
}

