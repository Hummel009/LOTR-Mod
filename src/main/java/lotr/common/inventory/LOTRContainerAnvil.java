/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.ICrafting
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.inventory.InventoryCraftResult
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEnchantedBook
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.item.ItemShears
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.ChatAllowedCharacters
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  org.apache.commons.lang3.StringUtils
 */
package lotr.common.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRConfig;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.enchant.LOTREnchantment;
import lotr.common.enchant.LOTREnchantmentCombining;
import lotr.common.enchant.LOTREnchantmentHelper;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTREntityScrapTrader;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTradeEntry;
import lotr.common.entity.npc.LOTRTradeable;
import lotr.common.entity.npc.LOTRTraderNPCInfo;
import lotr.common.inventory.LOTRSlotAnvilOutput;
import lotr.common.inventory.OddmentCollectorNameMischief;
import lotr.common.item.AnvilNameColorProvider;
import lotr.common.item.LOTRItemBlowgun;
import lotr.common.item.LOTRItemChisel;
import lotr.common.item.LOTRItemCoin;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemEnchantment;
import lotr.common.item.LOTRItemModifierTemplate;
import lotr.common.item.LOTRItemOwnership;
import lotr.common.item.LOTRItemThrowingAxe;
import lotr.common.item.LOTRMaterial;
import lotr.common.recipe.LOTRRecipePoisonWeapon;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

public class LOTRContainerAnvil
extends Container {
    public IInventory invOutput;
    public IInventory invInput;
    public final EntityPlayer thePlayer;
    public final World theWorld;
    public final boolean isTrader;
    private int xCoord;
    private int yCoord;
    private int zCoord;
    public LOTREntityNPC theNPC;
    public LOTRTradeable theTrader;
    public int materialCost;
    public int reforgeCost;
    public int engraveOwnerCost;
    private String repairedItemName;
    private long lastReforgeTime = -1L;
    public static final int maxReforgeTime = 40;
    public int clientReforgeTime;
    private boolean doneMischief;
    public boolean isSmithScrollCombine;

    private LOTRContainerAnvil(EntityPlayer entityplayer, boolean trader) {
        this.thePlayer = entityplayer;
        this.theWorld = entityplayer.worldObj;
        this.isTrader = trader;
        this.invOutput = new InventoryCraftResult();
        this.invInput = new InventoryBasic("Repair", true, this.isTrader ? 2 : 3){

            public void markDirty() {
                super.markDirty();
                LOTRContainerAnvil.this.onCraftMatrixChanged((IInventory)this);
            }
        };
        this.addSlotToContainer(new Slot(this.invInput, 0, 27, 58));
        this.addSlotToContainer(new Slot(this.invInput, 1, 76, 47));
        if (!this.isTrader) {
            this.addSlotToContainer(new Slot(this.invInput, 2, 76, 70));
        }
        this.addSlotToContainer((Slot)new LOTRSlotAnvilOutput(this, this.invOutput, 0, 134, 58));
        for (int j1 = 0; j1 < 3; ++j1) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot((IInventory)entityplayer.inventory, i1 + j1 * 9 + 9, 8 + i1 * 18, 116 + j1 * 18));
            }
        }
        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlotToContainer(new Slot((IInventory)entityplayer.inventory, i1, 8 + i1 * 18, 174));
        }
    }

    public LOTRContainerAnvil(EntityPlayer entityplayer, int i, int j, int k) {
        this(entityplayer, false);
        this.xCoord = i;
        this.yCoord = j;
        this.zCoord = k;
    }

    public LOTRContainerAnvil(EntityPlayer entityplayer, LOTREntityNPC npc) {
        this(entityplayer, true);
        this.theNPC = npc;
        this.theTrader = (LOTRTradeable)((Object)npc);
    }

    public void onCraftMatrixChanged(IInventory inv) {
        super.onCraftMatrixChanged(inv);
        if (inv == this.invInput) {
            this.updateRepairOutput();
        }
    }

    private void updateRepairOutput() {
        ItemStack inputItem = this.invInput.getStackInSlot(0);
        this.materialCost = 0;
        this.reforgeCost = 0;
        this.engraveOwnerCost = 0;
        this.isSmithScrollCombine = false;
        int baseAnvilCost = 0;
        int repairCost = 0;
        int combineCost = 0;
        int renameCost = 0;
        if (inputItem == null) {
            this.invOutput.setInventorySlotContents(0, null);
            this.materialCost = 0;
        } else {
            int oneItemRepair;
            LOTREnchantmentCombining.CombineRecipe scrollCombine;
            boolean repairing;
            String nameToApply;
            boolean costRename;
            ItemStack inputCopy = inputItem.copy();
            ItemStack combinerItem = this.invInput.getStackInSlot(1);
            ItemStack materialItem = this.isTrader ? null : this.invInput.getStackInSlot(2);
            Map inputEnchants = EnchantmentHelper.getEnchantments((ItemStack)inputCopy);
            boolean enchantingWithBook = false;
            List<LOTREnchantment> inputModifiers = LOTREnchantmentHelper.getEnchantList(inputCopy);
            baseAnvilCost = LOTREnchantmentHelper.getAnvilCost(inputItem) + (combinerItem == null ? 0 : LOTREnchantmentHelper.getAnvilCost(combinerItem));
            this.materialCost = 0;
            String previousDisplayName = inputCopy.getDisplayName();
            String defaultItemName = inputCopy.getItem().getItemStackDisplayName(inputCopy);
            String formattedNameToApply = nameToApply = this.repairedItemName;
            ArrayList<EnumChatFormatting> colorsToApply = new ArrayList<EnumChatFormatting>();
            colorsToApply.addAll(LOTRContainerAnvil.getAppliedFormattingCodes(inputCopy.getDisplayName()));
            boolean alteringNameColor = false;
            if (LOTRContainerAnvil.costsToRename(inputItem) && combinerItem != null) {
                if (combinerItem.getItem() instanceof AnvilNameColorProvider) {
                    boolean isDifferentColor;
                    AnvilNameColorProvider nameColorProvider = (AnvilNameColorProvider)combinerItem.getItem();
                    EnumChatFormatting newColor = nameColorProvider.getAnvilNameColor();
                    boolean bl = isDifferentColor = !colorsToApply.contains((Object)newColor);
                    if (isDifferentColor) {
                        for (EnumChatFormatting ecf : EnumChatFormatting.values()) {
                            if (!ecf.isColor()) continue;
                            while (colorsToApply.contains((Object)ecf)) {
                                colorsToApply.remove((Object)ecf);
                            }
                        }
                        colorsToApply.add(newColor);
                        alteringNameColor = true;
                    }
                } else if (combinerItem.getItem() == Items.flint && !colorsToApply.isEmpty()) {
                    colorsToApply.clear();
                    alteringNameColor = true;
                }
                if (alteringNameColor) {
                    ++renameCost;
                }
            }
            if (!colorsToApply.isEmpty()) {
                if (StringUtils.isBlank((CharSequence)formattedNameToApply)) {
                    formattedNameToApply = defaultItemName;
                }
                formattedNameToApply = LOTRContainerAnvil.applyFormattingCodes(formattedNameToApply, colorsToApply);
            }
            boolean nameChange = false;
            if (formattedNameToApply != null && !formattedNameToApply.equals(previousDisplayName)) {
                if (StringUtils.isBlank((CharSequence)formattedNameToApply) || formattedNameToApply.equals(defaultItemName)) {
                    if (inputCopy.hasDisplayName()) {
                        inputCopy.func_135074_t();
                        if (!LOTRContainerAnvil.stripFormattingCodes(previousDisplayName).equals(LOTRContainerAnvil.stripFormattingCodes(formattedNameToApply))) {
                            nameChange = true;
                        }
                    }
                } else {
                    inputCopy.setStackDisplayName(formattedNameToApply);
                    if (!LOTRContainerAnvil.stripFormattingCodes(previousDisplayName).equals(LOTRContainerAnvil.stripFormattingCodes(formattedNameToApply))) {
                        nameChange = true;
                    }
                }
            }
            if (nameChange && (costRename = LOTRContainerAnvil.costsToRename(inputItem))) {
                ++renameCost;
            }
            if (this.isTrader && (scrollCombine = LOTREnchantmentCombining.getCombinationResult(inputItem, combinerItem)) != null) {
                this.invOutput.setInventorySlotContents(0, scrollCombine.createOutputItem());
                this.materialCost = scrollCombine.cost;
                this.reforgeCost = 0;
                this.engraveOwnerCost = 0;
                this.isSmithScrollCombine = true;
                return;
            }
            boolean combining = false;
            if (combinerItem != null) {
                boolean bl = enchantingWithBook = combinerItem.getItem() == Items.enchanted_book && Items.enchanted_book.func_92110_g(combinerItem).tagCount() > 0;
                if (enchantingWithBook && !LOTRConfig.enchantingVanilla) {
                    this.invOutput.setInventorySlotContents(0, null);
                    this.materialCost = 0;
                    return;
                }
                LOTREnchantment combinerItemEnchant = null;
                if (combinerItem.getItem() instanceof LOTRItemEnchantment) {
                    combinerItemEnchant = ((LOTRItemEnchantment)combinerItem.getItem()).theEnchant;
                } else if (combinerItem.getItem() instanceof LOTRItemModifierTemplate) {
                    combinerItemEnchant = LOTRItemModifierTemplate.getModifier(combinerItem);
                }
                if (!enchantingWithBook && combinerItemEnchant == null) {
                    if (inputCopy.isItemStackDamageable() && inputCopy.getItem() == combinerItem.getItem()) {
                        int inputUseLeft = inputItem.getMaxDamage() - inputItem.getItemDamageForDisplay();
                        int combinerUseLeft = combinerItem.getMaxDamage() - combinerItem.getItemDamageForDisplay();
                        int restoredUses = combinerUseLeft + inputCopy.getMaxDamage() * 12 / 100;
                        int newUsesLeft = inputUseLeft + restoredUses;
                        int newDamage = inputCopy.getMaxDamage() - newUsesLeft;
                        if ((newDamage = Math.max(newDamage, 0)) < inputCopy.getItemDamage()) {
                            inputCopy.setItemDamage(newDamage);
                            int restoredUses1 = inputCopy.getMaxDamage() - inputUseLeft;
                            int restoredUses2 = inputCopy.getMaxDamage() - combinerUseLeft;
                            combineCost += Math.max(0, Math.min(restoredUses1, restoredUses2) / 100);
                        }
                        combining = true;
                    } else if (!alteringNameColor) {
                        this.invOutput.setInventorySlotContents(0, null);
                        this.materialCost = 0;
                        return;
                    }
                }
                HashMap outputEnchants = new HashMap(inputEnchants);
                if (LOTRConfig.enchantingVanilla) {
                    Map combinerEnchants = EnchantmentHelper.getEnchantments((ItemStack)combinerItem);
                    for (Object obj : combinerEnchants.keySet()) {
                        int combinerEnchLevel;
                        int combinerEnchID = (Integer)obj;
                        Enchantment combinerEnch = Enchantment.enchantmentsList[combinerEnchID];
                        int inputEnchLevel = 0;
                        if (outputEnchants.containsKey(combinerEnchID)) {
                            inputEnchLevel = (Integer)outputEnchants.get(combinerEnchID);
                        }
                        int combinedEnchLevel = inputEnchLevel == (combinerEnchLevel = ((Integer)combinerEnchants.get(combinerEnchID)).intValue()) ? ++combinerEnchLevel : Math.max(combinerEnchLevel, inputEnchLevel);
                        combinerEnchLevel = combinedEnchLevel;
                        int levelsAdded = combinerEnchLevel - inputEnchLevel;
                        boolean canApply = combinerEnch.canApply(inputItem);
                        if (this.thePlayer.capabilities.isCreativeMode || inputItem.getItem() == Items.enchanted_book) {
                            canApply = true;
                        }
                        for (Object objIn : outputEnchants.keySet()) {
                            int inputEnchID = (Integer)objIn;
                            Enchantment inputEnch = Enchantment.enchantmentsList[inputEnchID];
                            if (inputEnchID == combinerEnchID || combinerEnch.canApplyTogether(inputEnch) && inputEnch.canApplyTogether(combinerEnch)) continue;
                            canApply = false;
                            combineCost += levelsAdded;
                        }
                        if (!canApply) continue;
                        combinerEnchLevel = Math.min(combinerEnchLevel, combinerEnch.getMaxLevel());
                        outputEnchants.put(combinerEnchID, combinerEnchLevel);
                        int costPerLevel = 0;
                        int enchWeight = combinerEnch.getWeight();
                        if (enchWeight == 1) {
                            costPerLevel = 8;
                        } else if (enchWeight == 2) {
                            costPerLevel = 4;
                        } else if (enchWeight == 5) {
                            costPerLevel = 2;
                        } else if (enchWeight == 10) {
                            costPerLevel = 1;
                        }
                        combineCost += costPerLevel * levelsAdded;
                    }
                } else {
                    outputEnchants.clear();
                }
                EnchantmentHelper.setEnchantments((Map)outputEnchants, (ItemStack)inputCopy);
                int maxMods = 3;
                ArrayList<LOTREnchantment> outputMods = new ArrayList<LOTREnchantment>();
                outputMods.addAll(inputModifiers);
                List<LOTREnchantment> combinerMods = LOTREnchantmentHelper.getEnchantList(combinerItem);
                if (combinerItemEnchant != null) {
                    Item item;
                    combinerMods.add(combinerItemEnchant);
                    if (combinerItemEnchant == LOTREnchantment.fire && LOTRRecipePoisonWeapon.poisonedToInput.containsKey((Object)(item = inputCopy.getItem()))) {
                        Item unpoisoned = LOTRRecipePoisonWeapon.poisonedToInput.get((Object)item);
                        inputCopy.func_150996_a(unpoisoned);
                    }
                }
                for (LOTREnchantment combinerMod : combinerMods) {
                    boolean canApply = combinerMod.canApply(inputItem, false);
                    if (canApply) {
                        for (LOTREnchantment mod : outputMods) {
                            if (mod.isCompatibleWith(combinerMod) && combinerMod.isCompatibleWith(mod)) continue;
                            canApply = false;
                        }
                    }
                    int numOutputMods = 0;
                    for (LOTREnchantment mod : outputMods) {
                        if (mod.bypassAnvilLimit()) continue;
                        ++numOutputMods;
                    }
                    if (!combinerMod.bypassAnvilLimit() && numOutputMods >= maxMods) {
                        canApply = false;
                    }
                    if (!canApply) continue;
                    outputMods.add(combinerMod);
                    if (!combinerMod.isBeneficial()) continue;
                    combineCost += Math.max(1, (int)combinerMod.getValueModifier());
                }
                LOTREnchantmentHelper.setEnchantList(inputCopy, outputMods);
            }
            if (combineCost > 0) {
                combining = true;
            }
            int numEnchants = 0;
            for (Object obj : inputEnchants.keySet()) {
                int enchID = (Integer)obj;
                Enchantment ench = Enchantment.enchantmentsList[enchID];
                int enchLevel = (Integer)inputEnchants.get(enchID);
                ++numEnchants;
                int costPerLevel = 0;
                int enchWeight = ench.getWeight();
                if (enchWeight == 1) {
                    costPerLevel = 8;
                } else if (enchWeight == 2) {
                    costPerLevel = 4;
                } else if (enchWeight == 5) {
                    costPerLevel = 2;
                } else if (enchWeight == 10) {
                    costPerLevel = 1;
                }
                baseAnvilCost += numEnchants + enchLevel * costPerLevel;
            }
            if (enchantingWithBook && !inputCopy.getItem().isBookEnchantable(inputCopy, combinerItem)) {
                inputCopy = null;
            }
            for (LOTREnchantment mod : inputModifiers) {
                if (!mod.isBeneficial()) continue;
                baseAnvilCost += Math.max(1, (int)mod.getValueModifier());
            }
            if (inputCopy.isItemStackDamageable()) {
                boolean canRepair = false;
                int availableMaterials = 0;
                if (this.isTrader) {
                    canRepair = this.getTraderMaterialPrice(inputItem) > 0.0f;
                    availableMaterials = Integer.MAX_VALUE;
                } else {
                    boolean bl = canRepair = materialItem != null && this.isRepairMaterial(inputItem, materialItem);
                    if (materialItem != null) {
                        availableMaterials = materialItem.stackSize - combineCost - renameCost;
                    }
                }
                oneItemRepair = Math.min(inputCopy.getItemDamageForDisplay(), inputCopy.getMaxDamage() / 4);
                if (canRepair && availableMaterials > 0 && oneItemRepair > 0) {
                    if ((availableMaterials -= baseAnvilCost) > 0) {
                        int usedMaterials;
                        for (usedMaterials = 0; oneItemRepair > 0 && usedMaterials < availableMaterials; ++usedMaterials) {
                            int newDamage = inputCopy.getItemDamageForDisplay() - oneItemRepair;
                            inputCopy.setItemDamage(newDamage);
                            oneItemRepair = Math.min(inputCopy.getItemDamageForDisplay(), inputCopy.getMaxDamage() / 4);
                        }
                        repairCost += usedMaterials;
                    } else if (!nameChange && !combining) {
                        repairCost = 1;
                        int newDamage = inputCopy.getItemDamageForDisplay() - oneItemRepair;
                        inputCopy.setItemDamage(newDamage);
                    }
                }
            }
            boolean bl = repairing = repairCost > 0;
            if (combining || repairing) {
                this.materialCost = baseAnvilCost;
                this.materialCost += combineCost + repairCost;
            } else {
                this.materialCost = 0;
            }
            this.materialCost += renameCost;
            if (inputCopy != null) {
                int nextAnvilCost = LOTREnchantmentHelper.getAnvilCost(inputItem);
                if (combinerItem != null) {
                    int combinerAnvilCost = LOTREnchantmentHelper.getAnvilCost(combinerItem);
                    nextAnvilCost = Math.max(nextAnvilCost, combinerAnvilCost);
                }
                if (combining) {
                    nextAnvilCost += 2;
                } else if (repairing) {
                    ++nextAnvilCost;
                }
                nextAnvilCost = Math.max(nextAnvilCost, 0);
                if (nextAnvilCost > 0) {
                    LOTREnchantmentHelper.setAnvilCost(inputCopy, nextAnvilCost);
                }
            }
            if (LOTREnchantmentHelper.isReforgeable(inputItem)) {
                ItemStack reforgeCopy;
                this.reforgeCost = 2;
                if (inputItem.getItem() instanceof ItemArmor) {
                    this.reforgeCost = 3;
                }
                if (inputItem.isItemStackDamageable() && (oneItemRepair = Math.min((reforgeCopy = inputItem.copy()).getItemDamageForDisplay(), reforgeCopy.getMaxDamage() / 4)) > 0) {
                    int usedMaterials = 0;
                    while (oneItemRepair > 0) {
                        int newDamage = reforgeCopy.getItemDamageForDisplay() - oneItemRepair;
                        reforgeCopy.setItemDamage(newDamage);
                        oneItemRepair = Math.min(reforgeCopy.getItemDamageForDisplay(), reforgeCopy.getMaxDamage() / 4);
                        ++usedMaterials;
                    }
                    this.reforgeCost += usedMaterials;
                }
                this.engraveOwnerCost = 2;
            } else {
                this.reforgeCost = 0;
                this.engraveOwnerCost = 0;
            }
            if (this.isRepairMaterial(inputItem, new ItemStack(Items.string))) {
                int stringFactor = 3;
                this.materialCost *= stringFactor;
                this.reforgeCost *= stringFactor;
                this.engraveOwnerCost *= stringFactor;
            }
            if (this.isTrader) {
                boolean isCommonRenameOnly = nameChange && this.materialCost == 0;
                float materialPrice = this.getTraderMaterialPrice(inputItem);
                if (materialPrice > 0.0f) {
                    this.materialCost = Math.round((float)this.materialCost * materialPrice);
                    this.materialCost = Math.max(this.materialCost, 1);
                    this.reforgeCost = Math.round((float)this.reforgeCost * materialPrice);
                    this.reforgeCost = Math.max(this.reforgeCost, 1);
                    this.engraveOwnerCost = Math.round((float)this.engraveOwnerCost * materialPrice);
                    this.engraveOwnerCost = Math.max(this.engraveOwnerCost, 1);
                    if (this.theTrader instanceof LOTREntityScrapTrader) {
                        this.materialCost = MathHelper.ceiling_float_int((float)((float)this.materialCost * 0.5f));
                        this.materialCost = Math.max(this.materialCost, 1);
                        this.reforgeCost = MathHelper.ceiling_float_int((float)((float)this.reforgeCost * 0.5f));
                        this.reforgeCost = Math.max(this.reforgeCost, 1);
                        this.engraveOwnerCost = MathHelper.ceiling_float_int((float)((float)this.engraveOwnerCost * 0.5f));
                        this.engraveOwnerCost = Math.max(this.engraveOwnerCost, 1);
                    }
                } else if (!isCommonRenameOnly) {
                    this.invOutput.setInventorySlotContents(0, null);
                    this.materialCost = 0;
                    this.reforgeCost = 0;
                    this.engraveOwnerCost = 0;
                    return;
                }
            }
            if (combining || repairing || nameChange || alteringNameColor) {
                this.invOutput.setInventorySlotContents(0, inputCopy);
            } else {
                this.invOutput.setInventorySlotContents(0, null);
                this.materialCost = 0;
            }
            this.detectAndSendChanges();
        }
    }

    private static boolean costsToRename(ItemStack itemstack) {
        Item item = itemstack.getItem();
        if (item instanceof ItemSword || item instanceof ItemTool) {
            return true;
        }
        if (item instanceof ItemArmor && ((ItemArmor)item).damageReduceAmount > 0) {
            return true;
        }
        return item instanceof ItemBow || item instanceof LOTRItemCrossbow || item instanceof LOTRItemThrowingAxe || item instanceof LOTRItemBlowgun;
    }

    private static List<EnumChatFormatting> getAppliedFormattingCodes(String name) {
        ArrayList<EnumChatFormatting> colors = new ArrayList<EnumChatFormatting>();
        for (EnumChatFormatting color : EnumChatFormatting.values()) {
            String formatCode = color.toString();
            if (!name.startsWith(formatCode)) continue;
            colors.add(color);
        }
        return colors;
    }

    public static String stripFormattingCodes(String name) {
        for (EnumChatFormatting color : EnumChatFormatting.values()) {
            String formatCode = color.toString();
            if (!name.startsWith(formatCode)) continue;
            name = name.substring(formatCode.length());
        }
        return name;
    }

    private static String applyFormattingCodes(String name, List<EnumChatFormatting> colors) {
        for (EnumChatFormatting color : colors) {
            name = (Object)color + name;
        }
        return name;
    }

    public List<EnumChatFormatting> getActiveItemNameFormatting() {
        ItemStack inputItem = this.invInput.getStackInSlot(0);
        ItemStack resultItem = this.invOutput.getStackInSlot(0);
        if (resultItem != null) {
            return LOTRContainerAnvil.getAppliedFormattingCodes(resultItem.getDisplayName());
        }
        if (inputItem != null) {
            return LOTRContainerAnvil.getAppliedFormattingCodes(inputItem.getDisplayName());
        }
        return new ArrayList<EnumChatFormatting>();
    }

    public boolean isRepairMaterial(ItemStack inputItem, ItemStack materialItem) {
        ItemArmor.ArmorMaterial armorMaterial;
        ItemArmor armor;
        if (inputItem.getItem().getIsRepairable(inputItem, materialItem)) {
            return true;
        }
        Item item = inputItem.getItem();
        if (item == Items.bow && LOTRMod.rohanBow.getIsRepairable(inputItem, materialItem)) {
            return true;
        }
        if (item instanceof ItemFishingRod && materialItem.getItem() == Items.string) {
            return true;
        }
        if (item instanceof ItemShears && materialItem.getItem() == Items.iron_ingot) {
            return true;
        }
        if (item instanceof LOTRItemChisel && materialItem.getItem() == Items.iron_ingot) {
            return true;
        }
        if (item instanceof ItemEnchantedBook && materialItem.getItem() == Items.paper) {
            return true;
        }
        Item.ToolMaterial material = null;
        if (item instanceof ItemTool) {
            material = Item.ToolMaterial.valueOf((String)((ItemTool)item).getToolMaterialName());
        } else if (item instanceof ItemSword) {
            material = Item.ToolMaterial.valueOf((String)((ItemSword)item).getToolMaterialName());
        }
        if (material == Item.ToolMaterial.WOOD || material == LOTRMaterial.MOREDAIN_WOOD.toToolMaterial()) {
            return LOTRMod.isOreNameEqual(materialItem, "plankWood");
        }
        if (material == LOTRMaterial.MALLORN.toToolMaterial()) {
            return materialItem.getItem() == Item.getItemFromBlock((Block)LOTRMod.planks) && materialItem.getItemDamage() == 1;
        }
        if (material == LOTRMaterial.MALLORN_MACE.toToolMaterial()) {
            return materialItem.getItem() == Item.getItemFromBlock((Block)LOTRMod.wood) && materialItem.getItemDamage() == 1;
        }
        if (item instanceof ItemArmor && (armorMaterial = (armor = (ItemArmor)item).getArmorMaterial()) == LOTRMaterial.BONE.toArmorMaterial()) {
            return LOTRMod.isOreNameEqual(materialItem, "bone");
        }
        return false;
    }

    private float getTraderMaterialPrice(ItemStack inputItem) {
        float materialPrice = 0.0f;
        LOTRTradeEntry[] sellTrades = this.theNPC.traderNPCInfo.getSellTrades();
        if (sellTrades != null) {
            for (LOTRTradeEntry trade : sellTrades) {
                ItemStack tradeItem = trade.createTradeItem();
                if (!this.isRepairMaterial(inputItem, tradeItem)) continue;
                materialPrice = (float)trade.getCost() / (float)trade.createTradeItem().stackSize;
                break;
            }
        }
        if (materialPrice <= 0.0f) {
            LOTRTradeEntries sellPool = this.theTrader.getSellPool();
            for (LOTRTradeEntry trade : sellPool.tradeEntries) {
                ItemStack tradeItem = trade.createTradeItem();
                if (!this.isRepairMaterial(inputItem, tradeItem)) continue;
                materialPrice = (float)trade.getCost() / (float)trade.createTradeItem().stackSize;
                break;
            }
        }
        if (materialPrice <= 0.0f && (this.isRepairMaterial(inputItem, new ItemStack(LOTRMod.mithril)) || this.isRepairMaterial(inputItem, new ItemStack(LOTRMod.mithrilMail))) && this.theTrader instanceof LOTREntityDwarf) {
            materialPrice = 200.0f;
        }
        return materialPrice;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting crafting = (ICrafting)this.crafters.get(i);
            crafting.sendProgressBarUpdate((Container)this, 0, this.materialCost);
            crafting.sendProgressBarUpdate((Container)this, 1, this.reforgeCost);
            crafting.sendProgressBarUpdate((Container)this, 3, this.engraveOwnerCost);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int i, int j) {
        if (i == 0) {
            this.materialCost = j;
        }
        if (i == 1) {
            this.reforgeCost = j;
        }
        if (i == 2) {
            this.clientReforgeTime = 40;
        }
        if (i == 3) {
            this.engraveOwnerCost = j;
        }
    }

    public boolean hasMaterialOrCoinAmount(int cost) {
        if (this.isTrader) {
            return LOTRItemCoin.getInventoryValue(this.thePlayer, false) >= cost;
        }
        ItemStack inputItem = this.invInput.getStackInSlot(0);
        ItemStack materialItem = this.invInput.getStackInSlot(2);
        if (materialItem != null) {
            return this.isRepairMaterial(inputItem, materialItem) && materialItem.stackSize >= cost;
        }
        return false;
    }

    public void takeMaterialOrCoinAmount(int cost) {
        if (this.isTrader) {
            if (!this.theWorld.isRemote) {
                LOTRItemCoin.takeCoins(cost, this.thePlayer);
                this.detectAndSendChanges();
                this.theNPC.playTradeSound();
            }
        } else {
            ItemStack materialItem = this.invInput.getStackInSlot(2);
            if (materialItem != null) {
                materialItem.stackSize -= cost;
                if (materialItem.stackSize <= 0) {
                    this.invInput.setInventorySlotContents(2, null);
                } else {
                    this.invInput.setInventorySlotContents(2, materialItem);
                }
            }
        }
    }

    public void onContainerClosed(EntityPlayer entityplayer) {
        super.onContainerClosed(entityplayer);
        if (!this.theWorld.isRemote) {
            for (int i = 0; i < this.invInput.getSizeInventory(); ++i) {
                ItemStack itemstack = this.invInput.getStackInSlotOnClosing(i);
                if (itemstack == null) continue;
                entityplayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
            if (this.doneMischief && this.isTrader && this.theNPC instanceof LOTREntityScrapTrader) {
                this.theNPC.sendSpeechBank(entityplayer, ((LOTREntityScrapTrader)this.theNPC).getSmithSpeechBank());
            }
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer) {
        if (this.isTrader) {
            return this.theNPC != null && (double)entityplayer.getDistanceToEntity((Entity)this.theNPC) <= 12.0 && this.theNPC.isEntityAlive() && this.theNPC.getAttackTarget() == null && this.theTrader.canTradeWith(entityplayer);
        }
        return this.theWorld.getBlock(this.xCoord, this.yCoord, this.zCoord) == Blocks.anvil && entityplayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 64.0;
    }

    public ItemStack slotClick(int slotNo, int j, int k, EntityPlayer entityplayer) {
        ItemStack resultCopy;
        ItemStack resultItem = this.invOutput.getStackInSlot(0);
        resultItem = ItemStack.copyItemStack((ItemStack)resultItem);
        boolean changed = false;
        if (resultItem != null && slotNo == this.getSlotFromInventory((IInventory)this.invOutput, (int)0).slotNumber && !this.theWorld.isRemote && this.isTrader && this.theNPC instanceof LOTREntityScrapTrader && (changed = this.applyMischief(resultCopy = resultItem.copy()))) {
            this.invOutput.setInventorySlotContents(0, resultCopy);
        }
        ItemStack slotClickResult = super.slotClick(slotNo, j, k, entityplayer);
        if (changed) {
            this.doneMischief = true;
            if (this.invOutput.getStackInSlot(0) != null) {
                this.invOutput.setInventorySlotContents(0, resultItem.copy());
            }
        }
        return slotClickResult;
    }

    public ItemStack transferStackInSlot(EntityPlayer entityplayer, int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(i);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            int inputSize = this.invInput.getSizeInventory();
            if (i == inputSize) {
                if (!this.mergeItemStack(itemstack1, inputSize + 1, inputSize + 37, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (i >= inputSize + 1 ? i >= inputSize + 1 && i < inputSize + 37 && !this.mergeItemStack(itemstack1, 0, inputSize, false) : !this.mergeItemStack(itemstack1, inputSize + 1, inputSize + 37, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(entityplayer, itemstack1);
        }
        return itemstack;
    }

    public void updateItemName(String name) {
        List<EnumChatFormatting> colors = LOTRContainerAnvil.getAppliedFormattingCodes(name);
        name = LOTRContainerAnvil.stripFormattingCodes(name);
        this.repairedItemName = name = ChatAllowedCharacters.filerAllowedCharacters((String)name);
        ItemStack itemstack = this.invOutput.getStackInSlot(0);
        if (itemstack != null) {
            if (StringUtils.isBlank((CharSequence)this.repairedItemName)) {
                itemstack.func_135074_t();
            } else {
                itemstack.setStackDisplayName(this.repairedItemName);
            }
            if (!colors.isEmpty()) {
                itemstack.setStackDisplayName(LOTRContainerAnvil.applyFormattingCodes(itemstack.getDisplayName(), colors));
            }
        }
        this.updateRepairOutput();
    }

    public void reforgeItem() {
        ItemStack inputItem;
        long curTime = System.currentTimeMillis();
        if ((this.lastReforgeTime < 0L || curTime - this.lastReforgeTime >= 2000L) && (inputItem = this.invInput.getStackInSlot(0)) != null && this.reforgeCost > 0 && this.hasMaterialOrCoinAmount(this.reforgeCost)) {
            boolean changed;
            int cost = this.reforgeCost;
            if (inputItem.isItemStackDamageable()) {
                inputItem.setItemDamage(0);
            }
            LOTREnchantmentHelper.applyRandomEnchantments(inputItem, this.theWorld.rand, true, true);
            LOTREnchantmentHelper.setAnvilCost(inputItem, 0);
            if (this.isTrader && this.theNPC instanceof LOTREntityScrapTrader && (changed = this.applyMischief(inputItem))) {
                this.doneMischief = true;
            }
            this.invInput.setInventorySlotContents(0, inputItem);
            this.takeMaterialOrCoinAmount(cost);
            this.playAnvilSound();
            this.lastReforgeTime = curTime;
            ((EntityPlayerMP)this.thePlayer).sendProgressBarUpdate((Container)this, 2, 0);
            if (!this.isTrader) {
                LOTRLevelData.getData(this.thePlayer).addAchievement(LOTRAchievement.reforge);
            }
        }
    }

    public boolean canEngraveNewOwner(ItemStack itemstack, EntityPlayer entityplayer) {
        String currentOwner = LOTRItemOwnership.getCurrentOwner(itemstack);
        if (currentOwner == null) {
            return true;
        }
        return !currentOwner.equals(entityplayer.getCommandSenderName());
    }

    public void engraveOwnership() {
        ItemStack inputItem = this.invInput.getStackInSlot(0);
        if (inputItem != null && this.engraveOwnerCost > 0 && this.hasMaterialOrCoinAmount(this.engraveOwnerCost)) {
            boolean changed;
            int cost = this.engraveOwnerCost;
            LOTRItemOwnership.setCurrentOwner(inputItem, this.thePlayer.getCommandSenderName());
            if (this.isTrader && this.theNPC instanceof LOTREntityScrapTrader && (changed = this.applyMischief(inputItem))) {
                this.doneMischief = true;
            }
            this.invInput.setInventorySlotContents(0, inputItem);
            this.takeMaterialOrCoinAmount(cost);
            this.playAnvilSound();
            LOTRLevelData.getData(this.thePlayer).addAchievement(LOTRAchievement.engraveOwnership);
        }
    }

    private boolean applyMischief(ItemStack itemstack) {
        boolean changed = false;
        Random rand = this.theWorld.rand;
        if (rand.nextFloat() < 0.8f) {
            String name = itemstack.getDisplayName();
            if ((name = OddmentCollectorNameMischief.garbleName(name, rand)).equals(itemstack.getItem().getItemStackDisplayName(itemstack))) {
                itemstack.func_135074_t();
            } else {
                itemstack.setStackDisplayName(name);
            }
            changed = true;
        }
        if (rand.nextFloat() < 0.2f) {
            LOTREnchantmentHelper.applyRandomEnchantments(itemstack, rand, false, true);
            changed = true;
        }
        return changed;
    }

    public void playAnvilSound() {
        if (!this.theWorld.isRemote) {
            int i;
            int j;
            int k;
            if (this.isTrader) {
                i = MathHelper.floor_double((double)this.theNPC.posX);
                j = MathHelper.floor_double((double)this.theNPC.posY);
                k = MathHelper.floor_double((double)this.theNPC.posZ);
            } else {
                i = this.xCoord;
                j = this.yCoord;
                k = this.zCoord;
            }
            this.theWorld.playAuxSFX(1021, i, j, k, 0);
        }
    }

}

