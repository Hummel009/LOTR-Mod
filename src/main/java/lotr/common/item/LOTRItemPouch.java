/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockChest
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryEnderChest
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityEnderChest
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.StatCollector
 *  net.minecraft.world.World
 */
package lotr.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRCreativeTabs;
import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockChest;
import lotr.common.block.LOTRBlockSpawnerChest;
import lotr.common.inventory.LOTRContainerChestWithPouch;
import lotr.common.inventory.LOTRContainerPouch;
import lotr.common.inventory.LOTRInventoryPouch;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class LOTRItemPouch
extends Item {
    private static int POUCH_COLOR = 10841676;
    @SideOnly(value=Side.CLIENT)
    private IIcon[] pouchIcons;
    @SideOnly(value=Side.CLIENT)
    private IIcon[] pouchIconsOpen;
    @SideOnly(value=Side.CLIENT)
    private IIcon[] overlayIcons;
    @SideOnly(value=Side.CLIENT)
    private IIcon[] overlayIconsOpen;
    private static String[] pouchTypes = new String[]{"small", "medium", "large"};

    public LOTRItemPouch() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setCreativeTab((CreativeTabs)LOTRCreativeTabs.tabMisc);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (!world.isRemote) {
            entityplayer.openGui((Object)LOTRMod.instance, 15, world, entityplayer.inventory.currentItem, 0, 0);
        }
        return itemstack;
    }

    public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int side, float hitX, float hitY, float hitZ) {
        IInventory chest = LOTRItemPouch.getChestInvAt(entityplayer, world, i, j, k);
        if (chest != null) {
            LOTRMod.proxy.usePouchOnChest(entityplayer, world, i, j, k, side, itemstack, entityplayer.inventory.currentItem);
            return true;
        }
        return false;
    }

    public static boolean isHoldingPouch(EntityPlayer entityplayer, int slot) {
        return entityplayer.inventory.getStackInSlot(slot) != null && entityplayer.inventory.getStackInSlot(slot).getItem() instanceof LOTRItemPouch;
    }

    public static IInventory getChestInvAt(EntityPlayer entityplayer, World world, int i, int j, int k) {
        InventoryEnderChest enderInv;
        Block block = world.getBlock(i, j, k);
        if (block instanceof LOTRBlockSpawnerChest) {
            return null;
        }
        TileEntity te = world.getTileEntity(i, j, k);
        if (block instanceof BlockChest) {
            return ((BlockChest)block).func_149951_m(world, i, j, k);
        }
        if (block instanceof LOTRBlockChest) {
            return ((LOTRBlockChest)block).getModChestAt(world, i, j, k);
        }
        if (block instanceof BlockEnderChest && !world.getBlock(i, j + 1, k).isNormalCube() && (enderInv = entityplayer.getInventoryEnderChest()) != null && te instanceof TileEntityEnderChest) {
            TileEntityEnderChest enderChest = (TileEntityEnderChest)te;
            if (!world.isRemote) {
                enderInv.func_146031_a(enderChest);
            }
            return enderInv;
        }
        return null;
    }

    public static int getCapacity(ItemStack itemstack) {
        return LOTRItemPouch.getCapacityForMeta(itemstack.getItemDamage());
    }

    public static int getCapacityForMeta(int i) {
        return (i + 1) * 9;
    }

    public static int getMaxPouchCapacity() {
        return LOTRItemPouch.getCapacityForMeta(pouchTypes.length - 1);
    }

    public static int getRandomPouchSize(Random random) {
        float f = random.nextFloat();
        if (f < 0.6f) {
            return 0;
        }
        if (f < 0.9f) {
            return 1;
        }
        return 2;
    }

    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IIconRegister iconregister) {
        this.pouchIcons = new IIcon[pouchTypes.length];
        this.pouchIconsOpen = new IIcon[pouchTypes.length];
        this.overlayIcons = new IIcon[pouchTypes.length];
        this.overlayIconsOpen = new IIcon[pouchTypes.length];
        for (int i = 0; i < pouchTypes.length; ++i) {
            this.pouchIcons[i] = iconregister.registerIcon(this.getIconString() + "_" + pouchTypes[i]);
            this.pouchIconsOpen[i] = iconregister.registerIcon(this.getIconString() + "_" + pouchTypes[i] + "_open");
            this.overlayIcons[i] = iconregister.registerIcon(this.getIconString() + "_" + pouchTypes[i] + "_overlay");
            this.overlayIconsOpen[i] = iconregister.registerIcon(this.getIconString() + "_" + pouchTypes[i] + "_open_overlay");
        }
    }

    @SideOnly(value=Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    public int getRenderPasses(int meta) {
        return 2;
    }

    public IIcon getIcon(ItemStack itemstack, int pass) {
        Container container;
        int meta;
        boolean open = false;
        EntityPlayer entityplayer = LOTRMod.proxy.getClientPlayer();
        if (entityplayer != null && ((container = entityplayer.openContainer) instanceof LOTRContainerPouch || container instanceof LOTRContainerChestWithPouch) && itemstack == entityplayer.getHeldItem()) {
            open = true;
        }
        if ((meta = itemstack.getItemDamage()) >= this.pouchIcons.length) {
            meta = 0;
        }
        if (open) {
            return pass > 0 ? this.overlayIconsOpen[meta] : this.pouchIconsOpen[meta];
        }
        return pass > 0 ? this.overlayIcons[meta] : this.pouchIcons[meta];
    }

    @SideOnly(value=Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemstack, int pass) {
        if (pass == 0) {
            return LOTRItemPouch.getPouchColor(itemstack);
        }
        return 16777215;
    }

    public static int getPouchColor(ItemStack itemstack) {
        int dye = LOTRItemPouch.getSavedDyeColor(itemstack);
        if (dye != -1) {
            return dye;
        }
        return POUCH_COLOR;
    }

    private static int getSavedDyeColor(ItemStack itemstack) {
        if (itemstack.getTagCompound() != null && itemstack.getTagCompound().hasKey("PouchColor")) {
            return itemstack.getTagCompound().getInteger("PouchColor");
        }
        return -1;
    }

    public static boolean isPouchDyed(ItemStack itemstack) {
        return LOTRItemPouch.getSavedDyeColor(itemstack) != -1;
    }

    public static void setPouchColor(ItemStack itemstack, int i) {
        if (itemstack.getTagCompound() == null) {
            itemstack.setTagCompound(new NBTTagCompound());
        }
        itemstack.getTagCompound().setInteger("PouchColor", i);
    }

    public static void removePouchDye(ItemStack itemstack) {
        if (itemstack.getTagCompound() != null) {
            itemstack.getTagCompound().removeTag("PouchColor");
        }
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        return super.getUnlocalizedName() + "." + itemstack.getItemDamage();
    }

    @SideOnly(value=Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag) {
        int slots = LOTRItemPouch.getCapacity(itemstack);
        int slotsFull = 0;
        LOTRInventoryPouch pouchInv = new LOTRInventoryPouch(itemstack);
        for (int i = 0; i < pouchInv.getSizeInventory(); ++i) {
            ItemStack slotItem = pouchInv.getStackInSlot(i);
            if (slotItem == null) continue;
            ++slotsFull;
        }
        list.add(StatCollector.translateToLocalFormatted((String)"item.lotr.pouch.slots", (Object[])new Object[]{slotsFull, slots}));
        if (LOTRItemPouch.isPouchDyed(itemstack)) {
            list.add(StatCollector.translateToLocal((String)"item.lotr.pouch.dyed"));
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < pouchTypes.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public static boolean tryAddItemToPouch(ItemStack pouch, ItemStack itemstack, boolean requireMatchInPouch) {
        if (itemstack != null && itemstack.stackSize > 0) {
            LOTRInventoryPouch pouchInv = new LOTRInventoryPouch(pouch);
            for (int i = 0; i < pouchInv.getSizeInventory() && itemstack.stackSize > 0; ++i) {
                int difference;
                ItemStack itemInSlot = pouchInv.getStackInSlot(i);
                if (itemInSlot != null ? itemInSlot.stackSize >= itemInSlot.getMaxStackSize() || itemInSlot.getItem() != itemstack.getItem() || !itemInSlot.isStackable() || itemInSlot.getHasSubtypes() && itemInSlot.getItemDamage() != itemstack.getItemDamage() || !ItemStack.areItemStackTagsEqual((ItemStack)itemInSlot, (ItemStack)itemstack) : requireMatchInPouch) continue;
                if (itemInSlot == null) {
                    pouchInv.setInventorySlotContents(i, itemstack);
                    return true;
                }
                int maxStackSize = itemInSlot.getMaxStackSize();
                if (pouchInv.getInventoryStackLimit() < maxStackSize) {
                    maxStackSize = pouchInv.getInventoryStackLimit();
                }
                if ((difference = maxStackSize - itemInSlot.stackSize) > itemstack.stackSize) {
                    difference = itemstack.stackSize;
                }
                itemstack.stackSize -= difference;
                itemInSlot.stackSize += difference;
                pouchInv.setInventorySlotContents(i, itemInSlot);
                if (itemstack.stackSize > 0) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean restockPouches(EntityPlayer player) {
		InventoryPlayer inv = player.inventory;
		List<Integer> pouchSlots = new ArrayList<>();
		List<Integer> itemSlots = new ArrayList<>();
		for (int i = 0; i < inv.mainInventory.length; i++) {
			ItemStack itemstack = inv.getStackInSlot(i);
			if (itemstack != null) {
				if (itemstack.getItem() instanceof LOTRItemPouch) {
					pouchSlots.add(i);
				} else {
					itemSlots.add(i);
				}
			}
		}
		boolean movedAny = false;
		for (Integer integer : itemSlots) {
			int j = integer;
			ItemStack itemstack = inv.getStackInSlot(j);
			for (Integer integer2 : pouchSlots) {
				int p = integer2;
				ItemStack pouch = inv.getStackInSlot(p);
				int stackSizeBefore = itemstack.stackSize;
				tryAddItemToPouch(pouch, itemstack, true);
				if (itemstack.stackSize != stackSizeBefore) {
					movedAny = true;
				}
				if (itemstack.stackSize <= 0) {
					inv.setInventorySlotContents(j, null);
				}
			}
		}
		return movedAny;
	}
}

