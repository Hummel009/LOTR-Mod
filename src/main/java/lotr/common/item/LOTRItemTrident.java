/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.stats.StatBase
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.MovingObjectPosition$MovingObjectType
 *  net.minecraft.world.World
 *  net.minecraftforge.common.FishingHooks
 *  net.minecraftforge.common.FishingHooks$FishableCategory
 */
package lotr.common.item;

import java.util.Random;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.projectile.LOTRFishing;
import lotr.common.item.LOTRItemPolearm;
import lotr.common.item.LOTRMaterial;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.FishingHooks;

public class LOTRItemTrident
extends LOTRItemPolearm {
    public LOTRItemTrident(LOTRMaterial material) {
        this(material.toToolMaterial());
    }

    public LOTRItemTrident(Item.ToolMaterial material) {
        super(material);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.bow;
    }

    public int getMaxItemUseDuration(ItemStack itemstack) {
        return 72000;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
        return itemstack;
    }

    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer entityplayer, int useTick) {
        int k;
        int i;
        int j;
        int usageTime = this.getMaxItemUseDuration(itemstack) - useTick;
        if (usageTime <= 5) {
            return;
        }
        entityplayer.swingItem();
        MovingObjectPosition m = this.getMovingObjectPositionFromPlayer(world, entityplayer, true);
        if (m != null && m.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.canFishAt(world, i = m.blockX, j = m.blockY, k = m.blockZ)) {
            for (int l = 0; l < 20; ++l) {
                double d = (float)i + world.rand.nextFloat();
                double d1 = (float)j + world.rand.nextFloat();
                double d2 = (float)k + world.rand.nextFloat();
                String s = world.rand.nextBoolean() ? "bubble" : "splash";
                world.spawnParticle(s, d, d1, d2, 0.0, (double)(world.rand.nextFloat() * 0.2f), 0.0);
            }
            if (!world.isRemote) {
                entityplayer.addExhaustion(0.06f);
                if (world.rand.nextInt(3) == 0) {
                    world.playSoundEffect((double)i + 0.5, (double)j + 0.5, (double)k + 0.5, "random.splash", 0.5f, 1.0f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.4f);
                    itemstack.damageItem(1, (EntityLivingBase)entityplayer);
                    if (world.rand.nextInt(3) == 0) {
                        float chance = world.rand.nextFloat();
                        int luck = EnchantmentHelper.func_151386_g((EntityLivingBase)entityplayer);
                        int speed = EnchantmentHelper.func_151387_h((EntityLivingBase)entityplayer);
                        LOTRFishing.FishResult result = LOTRFishing.getFishResult(world.rand, chance, luck, speed, false);
                        EntityItem fish = new EntityItem(world, (double)i + 0.5, (double)j + 0.5, (double)k + 0.5, result.fishedItem);
                        double d = entityplayer.posX - fish.posX;
                        double d1 = entityplayer.posY - fish.posY;
                        double d2 = entityplayer.posZ - fish.posZ;
                        double dist = MathHelper.sqrt_double((double)(d * d + d1 * d1 + d2 * d2));
                        double motion = 0.1;
                        fish.motionX = d * motion;
                        fish.motionY = d1 * motion + (double)MathHelper.sqrt_double((double)dist) * 0.08;
                        fish.motionZ = d2 * motion;
                        world.spawnEntityInWorld((Entity)fish);
                        entityplayer.addStat(result.category.stat, 1);
                        world.spawnEntityInWorld((Entity)new EntityXPOrb(world, fish.posX, fish.posY, fish.posZ, world.rand.nextInt(3) + 1));
                        if (result.category == FishingHooks.FishableCategory.FISH && this == LOTRMod.dunlendingTrident) {
                            LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDunlendingTrident);
                        }
                    }
                }
            }
        }
    }

    private boolean canFishAt(World world, int i, int j, int k) {
        double d = (double)i + 0.5;
        double d1 = (double)j + 0.5;
        double d2 = (double)k + 0.5;
        double d3 = 0.125;
        AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox((double)(d - d3), (double)(d1 - d3), (double)(d2 - d3), (double)(d + d3), (double)(d1 + d3), (double)(d2 + d3));
        int range = 5;
        for (int l = 0; l < range; ++l) {
            double d5 = boundingBox.minY + (boundingBox.maxY - boundingBox.minY) * (double)(l + 0) / (double)range - d3 + d3;
            double d6 = boundingBox.minY + (boundingBox.maxY - boundingBox.minY) * (double)(l + 1) / (double)range - d3 + d3;
            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)boundingBox.minX, (double)d5, (double)boundingBox.minZ, (double)boundingBox.maxX, (double)d6, (double)boundingBox.maxZ);
            if (!world.isAABBInMaterial(aabb, Material.water)) continue;
            return true;
        }
        return false;
    }
}

