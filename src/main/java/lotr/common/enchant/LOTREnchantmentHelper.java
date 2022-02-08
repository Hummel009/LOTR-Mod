/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.ServerConfigurationManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.WeightedRandom
 *  net.minecraft.util.WeightedRandom$Item
 *  net.minecraft.world.World
 */
package lotr.common.enchant;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRConfig;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.enchant.LOTREnchantment;
import lotr.common.enchant.LOTREnchantmentBane;
import lotr.common.enchant.LOTREnchantmentDamage;
import lotr.common.enchant.LOTREnchantmentDurability;
import lotr.common.enchant.LOTREnchantmentKnockback;
import lotr.common.enchant.LOTREnchantmentLooting;
import lotr.common.enchant.LOTREnchantmentMeleeReach;
import lotr.common.enchant.LOTREnchantmentMeleeSpeed;
import lotr.common.enchant.LOTREnchantmentProtection;
import lotr.common.enchant.LOTREnchantmentProtectionFire;
import lotr.common.enchant.LOTREnchantmentProtectionSpecial;
import lotr.common.enchant.LOTREnchantmentRangedDamage;
import lotr.common.enchant.LOTREnchantmentRangedKnockback;
import lotr.common.enchant.LOTREnchantmentToolSpeed;
import lotr.common.enchant.LOTREnchantmentType;
import lotr.common.enchant.LOTREnchantmentWeaponSpecial;
import lotr.common.item.LOTRMaterial;
import lotr.common.network.LOTRPacketCancelItemHighlight;
import lotr.common.network.LOTRPacketHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

public class LOTREnchantmentHelper {
    private static Map<UUID, ItemStack[]> lastKnownPlayerInventories = new HashMap<UUID, ItemStack[]>();
    private static Random backupRand;

    private static NBTTagList getItemEnchantTags(ItemStack itemstack, boolean create) {
        NBTTagCompound itemData = itemstack.getTagCompound();
        NBTTagList tags = null;
        if (itemData != null && itemData.hasKey("LOTREnch")) {
            tags = itemData.getTagList("LOTREnch", 8);
        } else if (create) {
            if (itemData == null) {
                itemData = new NBTTagCompound();
                itemstack.setTagCompound(itemData);
            }
            tags = new NBTTagList();
            itemData.setTag("LOTREnch", (NBTBase)tags);
        }
        return tags;
    }

    private static NBTTagCompound getItemEnchantProgress(ItemStack itemstack, LOTREnchantment ench, boolean create) {
        NBTTagCompound itemData = itemstack.getTagCompound();
        if (itemData != null && itemData.hasKey("LOTREnchProgress")) {
            NBTTagList tags = itemData.getTagList("LOTREnchProgress", 10);
            for (int i = 0; i < tags.tagCount(); ++i) {
                NBTTagCompound enchData = tags.getCompoundTagAt(i);
                if (!enchData.getString("Name").equals(ench.enchantName)) continue;
                return enchData;
            }
            if (create) {
                NBTTagCompound enchData = new NBTTagCompound();
                enchData.setString("Name", ench.enchantName);
                tags.appendTag((NBTBase)enchData);
                return enchData;
            }
        } else if (create) {
            if (itemData == null) {
                itemData = new NBTTagCompound();
                itemstack.setTagCompound(itemData);
            }
            NBTTagList tags = new NBTTagList();
            itemData.setTag("LOTREnchProgress", (NBTBase)tags);
            NBTTagCompound enchData = new NBTTagCompound();
            enchData.setString("Name", ench.enchantName);
            tags.appendTag((NBTBase)enchData);
            return enchData;
        }
        return null;
    }

    public static boolean hasEnchant(ItemStack itemstack, LOTREnchantment ench) {
        NBTTagList tags = LOTREnchantmentHelper.getItemEnchantTags(itemstack, false);
        if (tags != null) {
            for (int i = 0; i < tags.tagCount(); ++i) {
                String s = tags.getStringTagAt(i);
                if (!s.equals(ench.enchantName)) continue;
                return true;
            }
        }
        return false;
    }

    public static void setHasEnchant(ItemStack itemstack, LOTREnchantment ench) {
        NBTTagList tags;
        if (!LOTREnchantmentHelper.hasEnchant(itemstack, ench) && (tags = LOTREnchantmentHelper.getItemEnchantTags(itemstack, true)) != null) {
            String enchName = ench.enchantName;
            tags.appendTag((NBTBase)new NBTTagString(enchName));
        }
    }

    public static void removeEnchant(ItemStack itemstack, LOTREnchantment ench) {
        NBTTagList tags = LOTREnchantmentHelper.getItemEnchantTags(itemstack, true);
        if (tags != null) {
            String enchName = ench.enchantName;
            for (int i = 0; i < tags.tagCount(); ++i) {
                String s = tags.getStringTagAt(i);
                if (!s.equals(enchName)) continue;
                tags.removeTag(i);
                break;
            }
        }
    }

    public static List<LOTREnchantment> getEnchantList(ItemStack itemstack) {
        ArrayList<LOTREnchantment> enchants = new ArrayList<LOTREnchantment>();
        NBTTagList tags = LOTREnchantmentHelper.getItemEnchantTags(itemstack, false);
        if (tags != null) {
            for (int i = 0; i < tags.tagCount(); ++i) {
                String s = tags.getStringTagAt(i);
                LOTREnchantment ench = LOTREnchantment.getEnchantmentByName(s);
                if (ench == null) continue;
                enchants.add(ench);
            }
        }
        return enchants;
    }

    public static void setEnchantList(ItemStack itemstack, List<LOTREnchantment> enchants) {
        LOTREnchantmentHelper.clearEnchants(itemstack);
        for (LOTREnchantment ench : enchants) {
            LOTREnchantmentHelper.setHasEnchant(itemstack, ench);
        }
    }

    public static void clearEnchants(ItemStack itemstack) {
        NBTTagCompound itemData = itemstack.getTagCompound();
        if (itemData != null && itemData.hasKey("LOTREnch")) {
            itemData.removeTag("LOTREnch");
        }
    }

    public static void clearEnchantsAndProgress(ItemStack itemstack) {
        LOTREnchantmentHelper.clearEnchants(itemstack);
        NBTTagCompound itemData = itemstack.getTagCompound();
        if (itemData != null && itemData.hasKey("LOTREnchProgress")) {
            itemData.removeTag("LOTREnchProgress");
        }
    }

    public static boolean checkEnchantCompatible(ItemStack itemstack, LOTREnchantment ench) {
        List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
        for (LOTREnchantment itemEnch : enchants) {
            if (itemEnch.isCompatibleWith(ench) && ench.isCompatibleWith(itemEnch)) continue;
            return false;
        }
        return true;
    }

    public static String getFullEnchantedName(ItemStack itemstack, String name) {
        List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
        enchants = Lists.reverse(enchants);
        for (LOTREnchantment ench : enchants) {
            name = StatCollector.translateToLocalFormatted((String)"lotr.enchant.nameFormat", (Object[])new Object[]{ench.getDisplayName(), name});
        }
        return name;
    }

    private static boolean hasAppliedRandomEnchants(ItemStack itemstack) {
        NBTTagCompound nbt = itemstack.getTagCompound();
        if (nbt != null && nbt.hasKey("LOTRRandomEnch")) {
            return nbt.getBoolean("LOTRRandomEnch");
        }
        return false;
    }

    private static void setAppliedRandomEnchants(ItemStack itemstack) {
        if (!itemstack.hasTagCompound()) {
            itemstack.setTagCompound(new NBTTagCompound());
        }
        itemstack.getTagCompound().setBoolean("LOTRRandomEnch", true);
    }

    private static boolean canApplyAnyEnchant(ItemStack itemstack) {
        for (LOTREnchantment ench : LOTREnchantment.allEnchantments) {
            if (!ench.canApply(itemstack, true)) continue;
            return true;
        }
        return false;
    }

    public static int getAnvilCost(ItemStack itemstack) {
        NBTTagCompound nbt = itemstack.getTagCompound();
        if (nbt != null && nbt.hasKey("LOTRRepairCost")) {
            return nbt.getInteger("LOTRRepairCost");
        }
        return 0;
    }

    public static void setAnvilCost(ItemStack itemstack, int cost) {
        if (!itemstack.hasTagCompound()) {
            itemstack.setTagCompound(new NBTTagCompound());
        }
        itemstack.getTagCompound().setInteger("LOTRRepairCost", cost);
    }

    public static boolean isReforgeable(ItemStack itemstack) {
        return !LOTREnchantmentHelper.getEnchantList(itemstack).isEmpty() || LOTREnchantmentHelper.canApplyAnyEnchant(itemstack);
    }

    public static void onEntityUpdate(EntityLivingBase entity) {
        Random rand = entity.getRNG();
        if (LOTRConfig.enchantingLOTR) {
            boolean init;
            if (entity instanceof EntityLiving && !(init = entity.getEntityData().getBoolean("LOTREnchantInit"))) {
                for (int i = 0; i < entity.getLastActiveItems().length; ++i) {
                    ItemStack itemstack = entity.getEquipmentInSlot(i);
                    LOTREnchantmentHelper.tryApplyRandomEnchantsForEntity(itemstack, rand);
                }
                entity.getEntityData().setBoolean("LOTREnchantInit", true);
            }
            if (entity instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayer = (EntityPlayerMP)entity;
                UUID playerID = entityplayer.getUniqueID();
                InventoryPlayer inv = entityplayer.inventory;
                ItemStack[] lastKnownInv = lastKnownPlayerInventories.get(playerID);
                if (lastKnownInv == null) {
                    lastKnownInv = new ItemStack[inv.getSizeInventory()];
                }
                for (int i = 0; i < inv.getSizeInventory(); ++i) {
                    ItemStack lastKnownItem;
                    ItemStack itemstack = inv.getStackInSlot(i);
                    if (ItemStack.areItemStacksEqual((ItemStack)itemstack, (ItemStack)(lastKnownItem = lastKnownInv[i]))) continue;
                    LOTREnchantmentHelper.tryApplyRandomEnchantsForEntity(itemstack, rand);
                    lastKnownInv[i] = lastKnownItem = itemstack == null ? null : itemstack.copy();
                }
                if (LOTREnchantmentHelper.tryApplyRandomEnchantsForEntity(inv.getItemStack(), rand)) {
                    entityplayer.updateHeldItem();
                }
                lastKnownPlayerInventories.put(playerID, lastKnownInv);
                if (lastKnownPlayerInventories.size() > 200) {
                    lastKnownPlayerInventories.clear();
                }
            }
        }
    }

    private static boolean tryApplyRandomEnchantsForEntity(ItemStack itemstack, Random rand) {
        if (itemstack != null && !LOTREnchantmentHelper.hasAppliedRandomEnchants(itemstack) && LOTREnchantmentHelper.canApplyAnyEnchant(itemstack)) {
            LOTREnchantmentHelper.applyRandomEnchantments(itemstack, rand, false, false);
            return true;
        }
        return false;
    }

    public static int getSkilfulWeight(LOTREnchantment ench) {
        int weight = ench.getEnchantWeight();
        double wd = weight;
        if (ench.isBeneficial()) {
            wd = Math.pow(wd, 0.3);
        }
        wd *= 100.0;
        if (!ench.isBeneficial()) {
            wd *= 0.15;
        }
        weight = (int)Math.round(wd);
        weight = Math.max(weight, 1);
        return weight;
    }

    public static void applyRandomEnchantments(ItemStack itemstack, Random random, boolean skilful, boolean keepBanes) {
        LOTREnchantment ench;
        if (!keepBanes) {
            LOTREnchantmentHelper.clearEnchantsAndProgress(itemstack);
        } else {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench2 : enchants) {
                if (ench2.persistsReforge()) continue;
                LOTREnchantmentHelper.removeEnchant(itemstack, ench2);
            }
        }
        if (itemstack.getItem() instanceof ItemSword && LOTRMaterial.getToolMaterialByName(((ItemSword)itemstack.getItem()).getToolMaterialName()) == LOTRMaterial.BARROW.toToolMaterial() && (ench = LOTREnchantment.baneWight).canApply(itemstack, false)) {
            LOTREnchantmentHelper.setHasEnchant(itemstack, ench);
        }
        if (itemstack.getItem() == LOTRMod.sting && (ench = LOTREnchantment.baneSpider).canApply(itemstack, false)) {
            LOTREnchantmentHelper.setHasEnchant(itemstack, ench);
        }
        int enchants = 0;
        float chance = random.nextFloat();
        if (skilful) {
            if (chance < 0.15f) {
                enchants = 2;
            } else if (chance < 0.8f) {
                enchants = 1;
            }
        } else if (chance < 0.1f) {
            enchants = 2;
        } else if (chance < 0.65f) {
            enchants = 1;
        }
        ArrayList<WeightedRandomEnchant> applicable = new ArrayList<WeightedRandomEnchant>();
        for (LOTREnchantment ench3 : LOTREnchantment.allEnchantments) {
            int weight;
            if (!ench3.canApply(itemstack, true) || ench3.isSkilful() && !skilful || (weight = ench3.getEnchantWeight()) <= 0) continue;
            weight = skilful ? LOTREnchantmentHelper.getSkilfulWeight(ench3) : (weight *= 100);
            if (weight > 0 && itemstack.getItem() instanceof ItemTool && !ench3.itemTypes.contains((Object)LOTREnchantmentType.TOOL) && !ench3.itemTypes.contains((Object)LOTREnchantmentType.BREAKABLE)) {
                weight /= 3;
                weight = Math.max(weight, 1);
            }
            WeightedRandomEnchant wre = new WeightedRandomEnchant(ench3, weight);
            applicable.add(wre);
        }
        if (!applicable.isEmpty()) {
            ArrayList<LOTREnchantment> chosenEnchants = new ArrayList<LOTREnchantment>();
            for (int l = 0; l < enchants && !applicable.isEmpty(); ++l) {
                WeightedRandomEnchant chosenWre = (WeightedRandomEnchant)WeightedRandom.getRandomItem((Random)random, applicable);
                LOTREnchantment chosenEnch = chosenWre.theEnchant;
                chosenEnchants.add(chosenEnch);
                applicable.remove((Object)chosenWre);
                ArrayList<WeightedRandomEnchant> nowIncompatibles = new ArrayList<WeightedRandomEnchant>();
                for (WeightedRandomEnchant wre : applicable) {
                    LOTREnchantment otherEnch = wre.theEnchant;
                    if (otherEnch.isCompatibleWith(chosenEnch)) continue;
                    nowIncompatibles.add(wre);
                }
                applicable.removeAll(nowIncompatibles);
            }
            for (LOTREnchantment ench4 : chosenEnchants) {
                if (!ench4.canApply(itemstack, false)) continue;
                LOTREnchantmentHelper.setHasEnchant(itemstack, ench4);
            }
        }
        if (!LOTREnchantmentHelper.getEnchantList(itemstack).isEmpty() || LOTREnchantmentHelper.canApplyAnyEnchant(itemstack)) {
            LOTREnchantmentHelper.setAppliedRandomEnchants(itemstack);
        }
    }

    public static float calcTradeValueFactor(ItemStack itemstack) {
        float value = 1.0f;
        List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
        for (LOTREnchantment ench : enchants) {
            value *= ench.getValueModifier();
            if (!ench.isSkilful()) continue;
            value *= 1.5f;
        }
        return value;
    }

    public static float calcBaseMeleeDamageBoost(ItemStack itemstack) {
        float damage = 0.0f;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentDamage)) continue;
                damage += ((LOTREnchantmentDamage)ench).getBaseDamageBoost();
            }
        }
        return damage;
    }

    public static float calcEntitySpecificDamage(ItemStack itemstack, EntityLivingBase entity) {
        float damage = 0.0f;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentDamage)) continue;
                damage += ((LOTREnchantmentDamage)ench).getEntitySpecificDamage(entity);
            }
        }
        return damage;
    }

    public static float calcMeleeSpeedFactor(ItemStack itemstack) {
        float speed = 1.0f;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentMeleeSpeed)) continue;
                speed *= ((LOTREnchantmentMeleeSpeed)ench).speedFactor;
            }
        }
        return speed;
    }

    public static float calcMeleeReachFactor(ItemStack itemstack) {
        float reach = 1.0f;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentMeleeReach)) continue;
                reach *= ((LOTREnchantmentMeleeReach)ench).reachFactor;
            }
        }
        return reach;
    }

    public static int calcExtraKnockback(ItemStack itemstack) {
        int kb = 0;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentKnockback)) continue;
                kb += ((LOTREnchantmentKnockback)ench).knockback;
            }
        }
        return kb;
    }

    public static boolean negateDamage(ItemStack itemstack, Random random) {
        if (itemstack != null) {
            if (random == null) {
                if (backupRand == null) {
                    backupRand = new Random();
                }
                random = backupRand;
            }
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                float durability;
                if (!(ench instanceof LOTREnchantmentDurability) || !((durability = ((LOTREnchantmentDurability)ench).durabilityFactor) > 1.0f)) continue;
                float inv = 1.0f / durability;
                if (!(random.nextFloat() > inv)) continue;
                return true;
            }
        }
        return false;
    }

    public static float calcToolEfficiency(ItemStack itemstack) {
        float speed = 1.0f;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentToolSpeed)) continue;
                speed *= ((LOTREnchantmentToolSpeed)ench).speedFactor;
            }
        }
        return speed;
    }

    public static boolean isSilkTouch(ItemStack itemstack) {
        return itemstack != null && LOTREnchantmentHelper.hasEnchant(itemstack, LOTREnchantment.toolSilk);
    }

    public static int calcLootingLevel(ItemStack itemstack) {
        int looting = 0;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentLooting)) continue;
                looting += ((LOTREnchantmentLooting)ench).lootLevel;
            }
        }
        return looting;
    }

    public static int calcCommonArmorProtection(ItemStack itemstack) {
        int protection = 0;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentProtection)) continue;
                protection += ((LOTREnchantmentProtection)ench).protectLevel;
            }
        }
        return protection;
    }

    public static int calcSpecialArmorSetProtection(ItemStack[] armor, DamageSource source) {
        int protection = 0;
        if (armor != null) {
            for (ItemStack itemstack : armor) {
                if (itemstack == null) continue;
                List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
                for (LOTREnchantment ench : enchants) {
                    if (!(ench instanceof LOTREnchantmentProtectionSpecial)) continue;
                    protection += ((LOTREnchantmentProtectionSpecial)ench).calcSpecialProtection(source);
                }
            }
        }
        return protection;
    }

    public static int getMaxFireProtectionLevel(ItemStack[] armor) {
        int max = 0;
        if (armor != null) {
            for (ItemStack itemstack : armor) {
                if (itemstack == null) continue;
                List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
                for (LOTREnchantment ench : enchants) {
                    int protection;
                    if (!(ench instanceof LOTREnchantmentProtectionFire) || (protection = ((LOTREnchantmentProtectionFire)ench).protectLevel) <= max) continue;
                    max = protection;
                }
            }
        }
        return max;
    }

    public static float calcRangedDamageFactor(ItemStack itemstack) {
        float damage = 1.0f;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentRangedDamage)) continue;
                damage *= ((LOTREnchantmentRangedDamage)ench).damageFactor;
            }
        }
        return damage;
    }

    public static int calcRangedKnockback(ItemStack itemstack) {
        int kb = 0;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (!(ench instanceof LOTREnchantmentRangedKnockback)) continue;
                kb += ((LOTREnchantmentRangedKnockback)ench).knockback;
            }
        }
        return kb;
    }

    public static int calcFireAspect(ItemStack itemstack) {
        int fire = 0;
        if (itemstack != null) {
            List<LOTREnchantment> enchants = LOTREnchantmentHelper.getEnchantList(itemstack);
            for (LOTREnchantment ench : enchants) {
                if (ench != LOTREnchantment.fire) continue;
                fire += LOTREnchantmentWeaponSpecial.getFireAmount();
            }
        }
        return fire;
    }

    public static int calcFireAspectForMelee(ItemStack itemstack) {
        if (itemstack != null && LOTREnchantmentType.MELEE.canApply(itemstack, false)) {
            return LOTREnchantmentHelper.calcFireAspect(itemstack);
        }
        return 0;
    }

    public static void onKillEntity(EntityPlayer entityplayer, EntityLivingBase target, DamageSource source) {
        if (source.getSourceOfDamage() == entityplayer) {
            ItemStack weapon = entityplayer.getHeldItem();
            Random rand = entityplayer.getRNG();
            if (weapon != null) {
                boolean progressChanged = false;
                boolean enchantsChanged = false;
                for (LOTREnchantment ench : LOTREnchantment.allEnchantments) {
                    boolean compatible;
                    if (!ench.canApply(weapon, false) || !(ench instanceof LOTREnchantmentBane)) continue;
                    LOTREnchantmentBane enchBane = (LOTREnchantmentBane)ench;
                    if (!enchBane.isAchievable || !enchBane.doesEntityKillCountTowardsBane(target, entityplayer.worldObj)) continue;
                    NBTTagCompound nbt = LOTREnchantmentHelper.getItemEnchantProgress(weapon, ench, true);
                    int killed = 0;
                    if (nbt.hasKey("Kills")) {
                        killed = nbt.getInteger("Kills");
                    }
                    nbt.setInteger("Kills", ++killed);
                    progressChanged = true;
                    int requiredKills = 0;
                    if (nbt.hasKey("KillsRequired")) {
                        requiredKills = nbt.getInteger("KillsRequired");
                    } else {
                        requiredKills = enchBane.getRandomKillsRequired(rand);
                        nbt.setInteger("KillsRequired", requiredKills);
                    }
                    if (killed < requiredKills || LOTREnchantmentHelper.hasEnchant(weapon, enchBane) || !(compatible = LOTREnchantmentHelper.checkEnchantCompatible(weapon, enchBane))) continue;
                    LOTREnchantmentHelper.setHasEnchant(weapon, enchBane);
                    enchantsChanged = true;
                    entityplayer.addChatMessage(enchBane.getEarnMessage(weapon));
                    for (Object obj : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                        EntityPlayer otherPlayer = (EntityPlayer)obj;
                        if (otherPlayer == entityplayer) continue;
                        otherPlayer.addChatMessage(enchBane.getEarnMessageWithName(entityplayer, weapon));
                    }
                    if (enchBane == LOTREnchantment.baneElf) {
                        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneElf);
                        continue;
                    }
                    if (enchBane == LOTREnchantment.baneOrc) {
                        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneOrc);
                        continue;
                    }
                    if (enchBane == LOTREnchantment.baneDwarf) {
                        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneDwarf);
                        continue;
                    }
                    if (enchBane == LOTREnchantment.baneWarg) {
                        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneWarg);
                        continue;
                    }
                    if (enchBane == LOTREnchantment.baneTroll) {
                        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneTroll);
                        continue;
                    }
                    if (enchBane == LOTREnchantment.baneSpider) {
                        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneSpider);
                        continue;
                    }
                    if (enchBane != LOTREnchantment.baneWight) continue;
                    LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.enchantBaneWight);
                }
                if (progressChanged && !enchantsChanged) {
                    LOTRPacketCancelItemHighlight pkt = new LOTRPacketCancelItemHighlight();
                    LOTRPacketHandler.networkWrapper.sendTo((IMessage)pkt, (EntityPlayerMP)entityplayer);
                }
            }
        }
    }

    private static NBTTagList getEntityEnchantTags(Entity entity, boolean create) {
        NBTTagCompound data = entity.getEntityData();
        NBTTagList tags = null;
        if (data != null && data.hasKey("LOTREnchEntity")) {
            tags = data.getTagList("LOTREnchEntity", 8);
        } else if (create) {
            tags = new NBTTagList();
            data.setTag("LOTREnchEntity", (NBTBase)tags);
        }
        return tags;
    }

    public static void setProjectileEnchantment(Entity entity, LOTREnchantment ench) {
        NBTTagList tags;
        if (!LOTREnchantmentHelper.hasProjectileEnchantment(entity, ench) && (tags = LOTREnchantmentHelper.getEntityEnchantTags(entity, true)) != null) {
            String enchName = ench.enchantName;
            tags.appendTag((NBTBase)new NBTTagString(enchName));
        }
    }

    public static boolean hasProjectileEnchantment(Entity entity, LOTREnchantment ench) {
        NBTTagList tags = LOTREnchantmentHelper.getEntityEnchantTags(entity, false);
        if (tags != null) {
            for (int i = 0; i < tags.tagCount(); ++i) {
                String s = tags.getStringTagAt(i);
                if (!s.equals(ench.enchantName)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean hasMeleeOrRangedEnchant(DamageSource source, LOTREnchantment ench) {
        ItemStack weapon;
        EntityLivingBase attackerLiving;
        Entity attacker = source.getEntity();
        Entity sourceEntity = source.getSourceOfDamage();
        if (attacker instanceof EntityLivingBase && (attackerLiving = (EntityLivingBase)attacker) == sourceEntity && (weapon = attackerLiving.getHeldItem()) != null && LOTREnchantmentType.MELEE.canApply(weapon, false) && LOTREnchantmentHelper.hasEnchant(weapon, ench)) {
            return true;
        }
        return sourceEntity != null && LOTREnchantmentHelper.hasProjectileEnchantment(sourceEntity, ench);
    }

    public static class WeightedRandomEnchant
    extends WeightedRandom.Item {
        public final LOTREnchantment theEnchant;

        public WeightedRandomEnchant(LOTREnchantment e, int weight) {
            super(weight);
            this.theEnchant = e;
        }
    }

}

