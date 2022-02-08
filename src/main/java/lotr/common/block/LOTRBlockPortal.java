/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.BlockContainer
 *  net.minecraft.block.BlockPortal
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.Teleporter
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.WorldServer
 *  net.minecraftforge.common.DimensionManager
 */
package lotr.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Random;
import lotr.common.LOTRConfig;
import lotr.common.LOTRDimension;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.fac.LOTRFaction;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public abstract class LOTRBlockPortal
extends BlockContainer {
    private LOTRFaction[] portalFactions;
    private Class teleporterClass;

    public LOTRBlockPortal(LOTRFaction[] factions, Class c) {
        super(Material.portal);
        this.portalFactions = factions;
        this.teleporterClass = c;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k) {
        float f = 0.0625f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int i, int j, int k, int side) {
        return side != 0 ? false : super.shouldSideBeRendered(world, i, j, k, side);
    }

    public void addCollisionBoxesToList(World world, int i, int j, int k, AxisAlignedBB aabb, List list, Entity entity) {
    }

    public abstract void setPlayerInPortal(EntityPlayer var1);

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
        if (!LOTRConfig.enablePortals) {
            return;
        }
        if (this.canUsePortal(entity)) {
            if (entity.ridingEntity == null && entity.riddenByEntity == null) {
                if (entity instanceof EntityPlayer) {
                    this.setPlayerInPortal((EntityPlayer)entity);
                } else {
                    this.transferEntity(entity, world);
                }
            }
        } else if (!world.isRemote) {
            entity.setFire(4);
            entity.attackEntityFrom(DamageSource.inFire, 2.0f);
            world.playSoundAtEntity(entity, "random.fizz", 0.5f, 1.5f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.5f);
        }
    }

    private boolean canUsePortal(Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            if (player.capabilities.isCreativeMode) {
                return true;
            }
            for (LOTRFaction faction : this.portalFactions) {
                if (!(LOTRLevelData.getData(player).getAlignment(faction) >= 1.0f)) continue;
                return true;
            }
        } else {
            for (LOTRFaction faction : this.portalFactions) {
                if (LOTRMod.getNPCFaction(entity).isBadRelation(faction) || entity.ridingEntity != null || entity.riddenByEntity != null || entity.timeUntilPortal != 0) continue;
                return true;
            }
        }
        return false;
    }

    public Teleporter getPortalTeleporter(WorldServer world) {
        for(Teleporter obj : world.customTeleporters) {
            if(!this.teleporterClass.isInstance(obj)) continue;
            return obj;
        }
        Teleporter teleporter = null;
        try {
            teleporter = (Teleporter) this.teleporterClass.getConstructor(WorldServer.class).newInstance(world);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        world.customTeleporters.add(teleporter);
        return teleporter;
    }

    private void transferEntity(Entity entity, World world) {
        if (!world.isRemote) {
            int dimension = 0;
            if (entity.dimension == 0) {
                dimension = LOTRDimension.MIDDLE_EARTH.dimensionID;
            } else if (entity.dimension == LOTRDimension.MIDDLE_EARTH.dimensionID) {
                dimension = 0;
            }
            LOTRMod.transferEntityToDimension(entity, dimension, this.getPortalTeleporter(DimensionManager.getWorld((int)dimension)));
        }
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int quantityDropped(Random par1Random) {
        return 0;
    }

    public int getRenderType() {
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int i, int j, int k, Random random) {
        if (random.nextInt(100) == 0) {
            world.playSound((double)i + 0.5, (double)j + 0.5, (double)k + 0.5, "portal.portal", 0.5f, random.nextFloat() * 0.4f + 0.8f, false);
        }
    }

    public void onBlockAdded(World world, int i, int j, int k) {
        if (world.provider.dimensionId != 0 && world.provider.dimensionId != LOTRDimension.MIDDLE_EARTH.dimensionID) {
            world.setBlockToAir(i, j, k);
        }
    }

    public abstract boolean isValidPortalLocation(World var1, int var2, int var3, int var4, boolean var5);

    @SideOnly(value=Side.CLIENT)
    public Item getItem(World world, int i, int j, int k) {
        return Item.getItemById((int)0);
    }

    @SideOnly(value=Side.CLIENT)
    public IIcon getIcon(int i, int j) {
        return Blocks.portal.getIcon(i, j);
    }

    @SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
    }
}

