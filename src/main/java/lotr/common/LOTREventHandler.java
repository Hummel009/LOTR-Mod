/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  cpw.mods.fml.client.event.ConfigChangedEvent
 *  cpw.mods.fml.client.event.ConfigChangedEvent$OnConfigChangedEvent
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.IFuelHandler
 *  cpw.mods.fml.common.eventhandler.Event
 *  cpw.mods.fml.common.eventhandler.Event$Result
 *  cpw.mods.fml.common.eventhandler.EventBus
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  cpw.mods.fml.common.gameevent.PlayerEvent
 *  cpw.mods.fml.common.gameevent.PlayerEvent$ItemCraftedEvent
 *  cpw.mods.fml.common.gameevent.PlayerEvent$ItemSmeltedEvent
 *  cpw.mods.fml.common.gameevent.PlayerEvent$PlayerChangedDimensionEvent
 *  cpw.mods.fml.common.gameevent.PlayerEvent$PlayerLoggedInEvent
 *  cpw.mods.fml.common.gameevent.PlayerEvent$PlayerRespawnEvent
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.NetworkRegistry$TargetPoint
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  cpw.mods.fml.common.registry.GameRegistry
 *  net.minecraft.block.Block
 *  net.minecraft.block.Block$SoundType
 *  net.minecraft.block.BlockAnvil
 *  net.minecraft.block.BlockBed
 *  net.minecraft.block.BlockButton
 *  net.minecraft.block.BlockCake
 *  net.minecraft.block.BlockCauldron
 *  net.minecraft.block.BlockDoor
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockFenceGate
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockJukebox
 *  net.minecraft.block.BlockLever
 *  net.minecraft.block.BlockLog
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.BlockTrapDoor
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.block.BlockWorkbench
 *  net.minecraft.block.IGrowable
 *  net.minecraft.block.material.Material
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityHanging
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.item.EntityMinecartChest
 *  net.minecraft.entity.item.EntityMinecartTNT
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityCow
 *  net.minecraft.entity.passive.EntitySheep
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.passive.EntityWaterMob
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEnchantedBook
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.item.ItemHoe
 *  net.minecraft.item.ItemShears
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTUtil
 *  net.minecraft.network.NetHandlerPlayServer
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.PlayerProfileCache
 *  net.minecraft.server.management.ServerConfigurationManager
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.ChatComponentTranslation
 *  net.minecraft.util.ChatStyle
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntityDamageSourceIndirect
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.MovingObjectPosition$MovingObjectType
 *  net.minecraft.world.ChunkCoordIntPair
 *  net.minecraft.world.ChunkPosition
 *  net.minecraft.world.EnumSkyBlock
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.Teleporter
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.WorldType
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.common.UsernameCache
 *  net.minecraftforge.common.util.ForgeDirection
 *  net.minecraftforge.event.AnvilUpdateEvent
 *  net.minecraftforge.event.ServerChatEvent
 *  net.minecraftforge.event.entity.EntityJoinWorldEvent
 *  net.minecraftforge.event.entity.living.LivingAttackEvent
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingDropsEvent
 *  net.minecraftforge.event.entity.living.LivingEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent
 *  net.minecraftforge.event.entity.living.LivingSpawnEvent
 *  net.minecraftforge.event.entity.living.LivingSpawnEvent$CheckSpawn
 *  net.minecraftforge.event.entity.minecart.MinecartInteractEvent
 *  net.minecraftforge.event.entity.minecart.MinecartUpdateEvent
 *  net.minecraftforge.event.entity.player.ArrowNockEvent
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.entity.player.BonemealEvent
 *  net.minecraftforge.event.entity.player.EntityInteractEvent
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 *  net.minecraftforge.event.entity.player.FillBucketEvent
 *  net.minecraftforge.event.entity.player.PlayerEvent
 *  net.minecraftforge.event.entity.player.PlayerEvent$BreakSpeed
 *  net.minecraftforge.event.entity.player.PlayerEvent$HarvestCheck
 *  net.minecraftforge.event.entity.player.PlayerEvent$StartTracking
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$Action
 *  net.minecraftforge.event.entity.player.PlayerUseItemEvent
 *  net.minecraftforge.event.entity.player.PlayerUseItemEvent$Finish
 *  net.minecraftforge.event.entity.player.PlayerUseItemEvent$Stop
 *  net.minecraftforge.event.entity.player.UseHoeEvent
 *  net.minecraftforge.event.terraingen.SaplingGrowTreeEvent
 *  net.minecraftforge.event.world.BlockEvent
 *  net.minecraftforge.event.world.BlockEvent$BreakEvent
 *  net.minecraftforge.event.world.BlockEvent$HarvestDropsEvent
 *  net.minecraftforge.event.world.BlockEvent$PlaceEvent
 *  net.minecraftforge.event.world.ChunkDataEvent
 *  net.minecraftforge.event.world.ChunkDataEvent$Load
 *  net.minecraftforge.event.world.ChunkDataEvent$Save
 *  net.minecraftforge.event.world.ChunkWatchEvent
 *  net.minecraftforge.event.world.ChunkWatchEvent$UnWatch
 *  net.minecraftforge.event.world.ChunkWatchEvent$Watch
 *  net.minecraftforge.event.world.ExplosionEvent
 *  net.minecraftforge.event.world.ExplosionEvent$Detonate
 *  net.minecraftforge.event.world.WorldEvent
 *  net.minecraftforge.event.world.WorldEvent$Save
 *  net.minecraftforge.event.world.WorldEvent$Unload
 *  org.apache.commons.lang3.StringUtils
 */
package lotr.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.registry.GameRegistry;
import lotr.common.block.LOTRBlockArmorStand;
import lotr.common.block.LOTRBlockBarrel;
import lotr.common.block.LOTRBlockBookshelfStorage;
import lotr.common.block.LOTRBlockCommandTable;
import lotr.common.block.LOTRBlockCraftingTable;
import lotr.common.block.LOTRBlockEntJar;
import lotr.common.block.LOTRBlockFlowerPot;
import lotr.common.block.LOTRBlockGate;
import lotr.common.block.LOTRBlockGrapevine;
import lotr.common.block.LOTRBlockKebabStand;
import lotr.common.block.LOTRBlockMechanisedRail;
import lotr.common.block.LOTRBlockMug;
import lotr.common.block.LOTRBlockPlaceableFood;
import lotr.common.block.LOTRBlockPlate;
import lotr.common.block.LOTRBlockRottenLog;
import lotr.common.block.LOTRBlockSaplingBase;
import lotr.common.block.LOTRBlockUtumnoReturnPortalBase;
import lotr.common.block.LOTRBlockWeaponRack;
import lotr.common.block.LOTRVanillaSaplings;
import lotr.common.enchant.LOTREnchantment;
import lotr.common.enchant.LOTREnchantmentHelper;
import lotr.common.enchant.LOTREnchantmentWeaponSpecial;
import lotr.common.entity.LOTRBannerProtectable;
import lotr.common.entity.LOTREntityRegistry;
import lotr.common.entity.LOTRPlateFallingInfo;
import lotr.common.entity.LOTRRandomSkinEntity;
import lotr.common.entity.ai.LOTREntityAINearestAttackableTargetBasic;
import lotr.common.entity.animal.LOTREntityButterfly;
import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.entity.animal.LOTREntityZebra;
import lotr.common.entity.item.LOTREntityArrowPoisoned;
import lotr.common.entity.item.LOTREntityBanner;
import lotr.common.entity.npc.LOTREntityDorwinionGuard;
import lotr.common.entity.npc.LOTREntityEnt;
import lotr.common.entity.npc.LOTREntityGaladhrimWarden;
import lotr.common.entity.npc.LOTREntityHobbitBounder;
import lotr.common.entity.npc.LOTREntityHuornBase;
import lotr.common.entity.npc.LOTREntityMarshWraith;
import lotr.common.entity.npc.LOTREntityMirkwoodSpider;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTREntityOlogHai;
import lotr.common.entity.npc.LOTREntityOrc;
import lotr.common.entity.npc.LOTREntityRanger;
import lotr.common.entity.npc.LOTREntityRohanMan;
import lotr.common.entity.npc.LOTREntityTree;
import lotr.common.entity.npc.LOTREntityWargBombardier;
import lotr.common.entity.npc.LOTREntityWoodElfScout;
import lotr.common.entity.npc.LOTRMercenary;
import lotr.common.entity.npc.LOTRNPCMount;
import lotr.common.entity.npc.LOTRTradeable;
import lotr.common.entity.npc.LOTRUnitTradeable;
import lotr.common.entity.projectile.LOTREntityCrossbowBolt;
import lotr.common.entity.projectile.LOTREntityDart;
import lotr.common.entity.projectile.LOTREntityFishHook;
import lotr.common.entity.projectile.LOTREntitySpear;
import lotr.common.entity.projectile.LOTREntityThrowingAxe;
import lotr.common.fac.LOTRAlignmentValues;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionBounties;
import lotr.common.fac.LOTRFactionRelations;
import lotr.common.inventory.LOTRContainerCraftingTable;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemBrandingIron;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemDagger;
import lotr.common.item.LOTRItemDye;
import lotr.common.item.LOTRItemFeatherDyed;
import lotr.common.item.LOTRItemHaradRobes;
import lotr.common.item.LOTRItemHobbitPipe;
import lotr.common.item.LOTRItemLance;
import lotr.common.item.LOTRItemLeatherHat;
import lotr.common.item.LOTRItemMug;
import lotr.common.item.LOTRItemPartyHat;
import lotr.common.item.LOTRItemPouch;
import lotr.common.item.LOTRMaterial;
import lotr.common.item.LOTRPoisonedDrinks;
import lotr.common.item.LOTRWeaponStats;
import lotr.common.network.LOTRPacketEntityUUID;
import lotr.common.network.LOTRPacketHandler;
import lotr.common.network.LOTRPacketStopItemUse;
import lotr.common.network.LOTRPacketUtumnoKill;
import lotr.common.network.LOTRPacketWeaponFX;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.recipe.LOTRRecipePoisonWeapon;
import lotr.common.tileentity.LOTRTileEntityPlate;
import lotr.common.world.LOTRTeleporter;
import lotr.common.world.LOTRTeleporterUtumno;
import lotr.common.world.LOTRUtumnoLevel;
import lotr.common.world.LOTRWorldProvider;
import lotr.common.world.LOTRWorldProviderUtumno;
import lotr.common.world.LOTRWorldTypeMiddleEarth;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenDeadMarshes;
import lotr.common.world.biome.LOTRBiomeGenFangorn;
import lotr.common.world.biome.LOTRBiomeGenForodwaith;
import lotr.common.world.biome.LOTRBiomeGenMirkwoodCorrupted;
import lotr.common.world.biome.LOTRBiomeGenMorgulVale;
import lotr.common.world.biome.LOTRBiomeGenNearHarad;
import lotr.common.world.biome.LOTRBiomeGenShire;
import lotr.common.world.biome.variant.LOTRBiomeVariantStorage;
import lotr.common.world.structure2.LOTRStructureTimelapse;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.UsernameCache;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;
import net.minecraftforge.event.entity.minecart.MinecartUpdateEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.entity.player.PlayerEvent.StartTracking;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.WorldEvent;

public class LOTREventHandler
implements IFuelHandler {
    private LOTRItemBow proxyBowItemServer;
    private LOTRItemBow proxyBowItemClient;

    public LOTREventHandler() {
        FMLCommonHandler.instance().bus().register((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        MinecraftForge.TERRAIN_GEN_BUS.register((Object)this);
        GameRegistry.registerFuelHandler((IFuelHandler)this);
        new LOTRStructureTimelapse();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals("lotr")) {
            LOTRConfig.load();
        }
    }

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
        EntityPlayer entityplayer = event.player;
        ItemStack itemstack = event.crafting;
        IInventory craftingInventory = event.craftMatrix;
        if (!entityplayer.worldObj.isRemote) {
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Elven) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useElvenTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Uruk) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useUrukTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Rohirric) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useRohirricTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Gondorian) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useGondorianTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.WoodElven) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useWoodElvenTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Dwarven) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDwarvenTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Morgul) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useMorgulTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Dunlending) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDunlendingTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Angmar) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useAngmarTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.NearHarad) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useNearHaradTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.HighElven) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useHighElvenTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.BlueDwarven) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useBlueDwarvenTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Ranger) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useRangerTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.DolGuldur) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDolGuldurTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Gundabad) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useGundabadTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.HalfTroll) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useHalfTrollTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.DolAmroth) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDolAmrothTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Moredain) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useMoredainTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Tauredain) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useTauredainTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Dale) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDaleTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Dorwinion) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useDorwinionTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Hobbit) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useHobbitTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Rhun) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useRhunTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Rivendell) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useRivendellTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Umbar) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useUmbarTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Gulf) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useGulfTable);
            }
            if (entityplayer.openContainer instanceof LOTRContainerCraftingTable.Bree) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useBreeTable);
            }
            if (itemstack.getItem() == Items.saddle) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftSaddle);
            }
            if (itemstack.getItem() == LOTRMod.bronze) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftBronze);
            }
            if (itemstack.getItem() == LOTRMod.appleCrumbleItem) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftAppleCrumble);
            }
            if (itemstack.getItem() == LOTRMod.rabbitStew) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftRabbitStew);
            }
            if (itemstack.getItem() == LOTRMod.saltedFlesh) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftSaltedFlesh);
            }
            if (itemstack.getItem() == Item.getItemFromBlock((Block)LOTRMod.brick) && itemstack.getItemDamage() == 10) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftMithrilDwarvenBrick);
            }
            if (itemstack.getItem() == Item.getItemFromBlock((Block)LOTRMod.orcBomb)) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftOrcBomb);
            }
            if (itemstack.getItem() == LOTRMod.utumnoKey) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.craftUtumnoKey);
            }
        }
    }

    @SubscribeEvent
    public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
        EntityPlayer entityplayer = event.player;
        ItemStack itemstack = event.smelting;
        if (!entityplayer.worldObj.isRemote) {
            if (itemstack.getItem() == LOTRMod.bronze) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.alloyBronze);
            }
            if (itemstack.getItem() == LOTRMod.deerCooked) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.cookDeer);
            }
            if (itemstack.getItem() == LOTRMod.blueDwarfSteel) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.smeltBlueDwarfSteel);
            }
            if (itemstack.getItem() == LOTRMod.elfSteel) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.smeltElfSteel);
            }
            if (itemstack.getItem() == LOTRMod.dwarfSteel) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.smeltDwarfSteel);
            }
            if (itemstack.getItem() == LOTRMod.urukSteel) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.smeltUrukSteel);
            }
            if (itemstack.getItem() == LOTRMod.orcSteel) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.smeltOrcSteel);
            }
            if (itemstack.getItem() == LOTRMod.blackUrukSteel) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.smeltBlackUrukSteel);
            }
        }
    }

    public int getBurnTime(ItemStack itemstack) {
        Item item = itemstack.getItem();
        if (item instanceof ItemBlock && ((ItemBlock)item).field_150939_a instanceof LOTRBlockSaplingBase) {
            return 100;
        }
        if (item == LOTRMod.nauriteGem) {
            return 600;
        }
        if (item == Item.getItemFromBlock((Block)LOTRMod.blockOreStorage) && itemstack.getItemDamage() == 10) {
            return 6000;
        }
        if (item == LOTRMod.mallornStick) {
            return 100;
        }
        if (item instanceof ItemTool && ((ItemTool)item).func_150913_i() == LOTRMaterial.MALLORN.toToolMaterial()) {
            return 200;
        }
        if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals(LOTRMaterial.MALLORN.toToolMaterial().toString())) {
            return 200;
        }
        if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals(LOTRMaterial.MALLORN.toToolMaterial().toString())) {
            return 200;
        }
        if (item == Items.reeds || item == Item.getItemFromBlock((Block)LOTRMod.reeds) || item == Item.getItemFromBlock((Block)LOTRMod.driedReeds) || item == Item.getItemFromBlock((Block)LOTRMod.cornStalk)) {
            return 100;
        }
        return 0;
    }

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer entityplayer = event.player;
        World world = entityplayer.worldObj;
        if (!world.isRemote) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entityplayer;
            if (world.provider.terrainType instanceof LOTRWorldTypeMiddleEarth && entityplayermp.dimension == 0 && !LOTRLevelData.getData((EntityPlayer)entityplayermp).getTeleportedME()) {
                int dimension = LOTRDimension.MIDDLE_EARTH.dimensionID;
                LOTRTeleporter teleporter = new LOTRTeleporter(DimensionManager.getWorld((int)dimension), false);
                MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(entityplayermp, dimension, (Teleporter)teleporter);
                LOTRLevelData.getData((EntityPlayer)entityplayermp).setTeleportedME(true);
            }
            LOTRLevelData.sendLoginPacket(entityplayermp);
            LOTRLevelData.sendPlayerData(entityplayermp);
            LOTRLevelData.sendAlignmentToAllPlayersInWorld(entityplayer, world);
            LOTRLevelData.sendAllAlignmentsInWorldToPlayer(entityplayer, world);
            LOTRLevelData.sendShieldToAllPlayersInWorld((EntityPlayer)entityplayermp, world);
            LOTRLevelData.sendAllShieldsInWorldToPlayer((EntityPlayer)entityplayermp, world);
            LOTRDate.sendUpdatePacket(entityplayermp, false);
            LOTRFactionRelations.sendAllRelationsTo(entityplayermp);
            LOTRPlayerData pd = LOTRLevelData.getData((EntityPlayer)entityplayermp);
            pd.send35AlignmentChoice(entityplayermp, world);
            pd.updateFastTravelClockFromLastOnlineTime(entityplayermp, world);
        }
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        EntityPlayer entityplayer = event.player;
        if (!entityplayer.worldObj.isRemote) {
            LOTRLevelData.sendAlignmentToAllPlayersInWorld(entityplayer, entityplayer.worldObj);
            LOTRLevelData.sendAllAlignmentsInWorldToPlayer(entityplayer, entityplayer.worldObj);
            LOTRLevelData.sendShieldToAllPlayersInWorld(entityplayer, entityplayer.worldObj);
            LOTRLevelData.sendAllShieldsInWorldToPlayer(entityplayer, entityplayer.worldObj);
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        EntityPlayer entityplayer = event.player;
        World world = entityplayer.worldObj;
        if (!world.isRemote && entityplayer instanceof EntityPlayerMP && world instanceof WorldServer) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entityplayer;
            WorldServer worldserver = (WorldServer)world;
            ChunkCoordinates deathPoint = LOTRLevelData.getData((EntityPlayer)entityplayermp).getDeathPoint();
            int deathDimension = LOTRLevelData.getData((EntityPlayer)entityplayermp).getDeathDimension();
            if (deathDimension == LOTRDimension.MIDDLE_EARTH.dimensionID) {
                if (LOTRConfig.middleEarthRespawning) {
                    boolean hasBed;
                    double respawnThreshold;
                    ChunkCoordinates bedLocation = entityplayermp.getBedLocation(entityplayermp.dimension);
                    boolean bl = hasBed = bedLocation != null;
                    if (hasBed) {
                        hasBed = EntityPlayerMP.verifyRespawnCoordinates((World)worldserver, (ChunkCoordinates)bedLocation, (boolean)entityplayermp.isSpawnForced(entityplayermp.dimension)) != null;
                    }
                    ChunkCoordinates spawnLocation = hasBed ? bedLocation : worldserver.getSpawnPoint();
                    double d = respawnThreshold = hasBed ? (double)LOTRConfig.MERBedRespawnThreshold : (double)LOTRConfig.MERWorldRespawnThreshold;
                    if (deathPoint != null) {
                        boolean flag;
                        boolean bl2 = flag = (double)deathPoint.getDistanceSquaredToChunkCoordinates(spawnLocation) > respawnThreshold * respawnThreshold;
                        if (flag) {
                            double randomDistance = MathHelper.getRandomIntegerInRange((Random)worldserver.rand, (int)LOTRConfig.MERMinRespawn, (int)LOTRConfig.MERMaxRespawn);
                            float angle = worldserver.rand.nextFloat() * 3.1415927f * 2.0f;
                            int i = deathPoint.posX + (int)(randomDistance * (double)MathHelper.sin((float)angle));
                            int k = deathPoint.posZ + (int)(randomDistance * (double)MathHelper.cos((float)angle));
                            int j = LOTRMod.getTrueTopBlock((World)worldserver, i, k);
                            entityplayermp.setLocationAndAngles((double)i + 0.5, (double)j, (double)k + 0.5, entityplayermp.rotationYaw, entityplayermp.rotationPitch);
                            entityplayermp.playerNetServerHandler.setPlayerLocation((double)i + 0.5, (double)j, (double)k + 0.5, entityplayermp.rotationYaw, entityplayermp.rotationPitch);
                        }
                    }
                }
            } else if (deathDimension == LOTRDimension.UTUMNO.dimensionID) {
                LOTRTeleporterUtumno.newTeleporter(LOTRDimension.MIDDLE_EARTH.dimensionID).placeInPortal((Entity)entityplayermp, 0.0, 0.0, 0.0, 0.0f);
                entityplayermp.playerNetServerHandler.setPlayerLocation(entityplayermp.posX, entityplayermp.posY, entityplayermp.posZ, entityplayermp.rotationYaw, entityplayermp.rotationPitch);
            }
        }
    }

    @SubscribeEvent
    public void onBlockInteract(PlayerInteractEvent event) {
        Block block;
        int meta;
        EntityPlayer entityplayer = event.entityPlayer;
        World world = entityplayer.worldObj;
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        int i = event.x;
        int j = event.y;
        int k = event.z;
        int side = event.face;
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            ItemStack plateItem;
            int logFacing;
            LOTRTileEntityPlate plate;
            TileEntity tileentity;
            int cauldronMeta;
            boolean mightBeAbleToAlterWorld;
            block = world.getBlock(i, j, k);
            meta = world.getBlockMetadata(i, j, k);
            LOTRBannerProtection.Permission perm = LOTRBannerProtection.Permission.FULL;
            boolean bl = mightBeAbleToAlterWorld = entityplayer.isSneaking() && itemstack != null;
            if (!mightBeAbleToAlterWorld) {
                if (block instanceof BlockDoor || block instanceof BlockTrapDoor || block instanceof BlockFenceGate || block instanceof LOTRBlockGate) {
                    perm = LOTRBannerProtection.Permission.DOORS;
                } else if (block instanceof BlockWorkbench || block instanceof LOTRBlockCraftingTable || block instanceof BlockAnvil || block instanceof LOTRBlockCommandTable) {
                    perm = LOTRBannerProtection.Permission.TABLES;
                } else if (world.getTileEntity(i, j, k) instanceof IInventory) {
                    perm = block instanceof LOTRBlockBarrel || block instanceof LOTRBlockKebabStand ? LOTRBannerProtection.Permission.FOOD : LOTRBannerProtection.Permission.CONTAINERS;
                } else if (block instanceof LOTRBlockArmorStand) {
                    perm = LOTRBannerProtection.Permission.CONTAINERS;
                } else if (block instanceof LOTRBlockWeaponRack || block == Blocks.bookshelf) {
                    perm = LOTRBannerProtection.Permission.CONTAINERS;
                } else if (block instanceof BlockJukebox) {
                    perm = LOTRBannerProtection.Permission.CONTAINERS;
                } else if (block instanceof BlockEnderChest) {
                    perm = LOTRBannerProtection.Permission.PERSONAL_CONTAINERS;
                } else if (block instanceof LOTRBlockPlate || block instanceof BlockCake || block instanceof LOTRBlockPlaceableFood || block instanceof LOTRBlockMug || block instanceof LOTRBlockEntJar) {
                    perm = LOTRBannerProtection.Permission.FOOD;
                } else if (block instanceof BlockBed) {
                    perm = LOTRBannerProtection.Permission.BEDS;
                } else if (block instanceof BlockButton || block instanceof BlockLever) {
                    perm = LOTRBannerProtection.Permission.SWITCHES;
                }
            }
            if (!world.isRemote && LOTRBannerProtection.isProtected(world, i, j, k, LOTRBannerProtection.forPlayer(entityplayer, perm), true)) {
                event.setCanceled(true);
                if (block instanceof BlockDoor) {
                    world.markBlockForUpdate(i, j - 1, k);
                    world.markBlockForUpdate(i, j, k);
                    world.markBlockForUpdate(i, j + 1, k);
                }
                return;
            }
            if (block == Blocks.flower_pot && meta == 0 && itemstack != null && LOTRBlockFlowerPot.canAcceptPlant(itemstack)) {
                LOTRMod.proxy.placeFlowerInPot(world, i, j, k, side, itemstack);
                if (!entityplayer.capabilities.isCreativeMode) {
                    --itemstack.stackSize;
                }
                event.setCanceled(true);
                return;
            }
            if (itemstack != null && block == Blocks.cauldron && meta > 0) {
                LOTRItemMug.Vessel drinkVessel = null;
                for (LOTRItemMug.Vessel v : LOTRItemMug.Vessel.values()) {
                    if (v.getEmptyVesselItem() != itemstack.getItem()) continue;
                    drinkVessel = v;
                    break;
                }
                if (drinkVessel != null) {
                    LOTRMod.proxy.fillMugFromCauldron(world, i, j, k, side, itemstack);
                    --itemstack.stackSize;
                    ItemStack mugFill = new ItemStack(LOTRMod.mugWater);
                    LOTRItemMug.setVessel(mugFill, drinkVessel, true);
                    if (itemstack.stackSize <= 0) {
                        entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, mugFill);
                    } else if (!entityplayer.inventory.addItemStackToInventory(mugFill)) {
                        entityplayer.dropPlayerItemWithRandomChoice(mugFill, false);
                    }
                    event.setCanceled(true);
                    return;
                }
            }
            if (!world.isRemote && block instanceof LOTRBlockPlate && entityplayer.isSneaking() && (tileentity = world.getTileEntity(i, j, k)) instanceof LOTRTileEntityPlate && (plateItem = (plate = (LOTRTileEntityPlate)tileentity).getFoodItem()) != null) {
                ((LOTRBlockPlate)block).dropOnePlateItem(plate);
                --plateItem.stackSize;
                plate.setFoodItem(plateItem);
                event.setCanceled(true);
                return;
            }
            if (!world.isRemote && block instanceof LOTRBlockMechanisedRail && entityplayer.isSneaking() && ((LOTRBlockMechanisedRail)block).onShiftClickActivateFirst(world, i, j, k, entityplayer, side)) {
                event.setCanceled(true);
                return;
            }
            if (!world.isRemote && block instanceof BlockCauldron && itemstack != null && (cauldronMeta = BlockCauldron.func_150027_b((int)meta)) > 0) {
                boolean undyed = false;
                Item item = itemstack.getItem();
                if (LOTRRecipePoisonWeapon.poisonedToInput.containsKey((Object)item)) {
                    Item inputWeapon = LOTRRecipePoisonWeapon.poisonedToInput.get((Object)item);
                    itemstack.func_150996_a(inputWeapon);
                    undyed = true;
                } else if (item instanceof LOTRItemPouch && LOTRItemPouch.isPouchDyed(itemstack)) {
                    LOTRItemPouch.removePouchDye(itemstack);
                    undyed = true;
                } else if (item instanceof LOTRItemHobbitPipe && LOTRItemHobbitPipe.isPipeDyed(itemstack)) {
                    LOTRItemHobbitPipe.removePipeDye(itemstack);
                    undyed = true;
                } else if (item instanceof LOTRItemLeatherHat && (LOTRItemLeatherHat.isHatDyed(itemstack) || LOTRItemLeatherHat.isFeatherDyed(itemstack))) {
                    LOTRItemLeatherHat.removeHatAndFeatherDye(itemstack);
                    undyed = true;
                } else if (item instanceof LOTRItemFeatherDyed && LOTRItemFeatherDyed.isFeatherDyed(itemstack)) {
                    LOTRItemFeatherDyed.removeFeatherDye(itemstack);
                    undyed = true;
                } else if (item instanceof LOTRItemHaradRobes && LOTRItemHaradRobes.areRobesDyed(itemstack)) {
                    LOTRItemHaradRobes.removeRobeDye(itemstack);
                    undyed = true;
                } else if (item instanceof LOTRItemPartyHat && LOTRItemPartyHat.isHatDyed(itemstack)) {
                    LOTRItemPartyHat.removeHatDye(itemstack);
                    undyed = true;
                }
                if (undyed) {
                    ((BlockCauldron)block).func_150024_a(world, i, j, k, cauldronMeta - 1);
                    event.setCanceled(true);
                    return;
                }
            }
            if (!world.isRemote && itemstack != null && itemstack.getItem() == Items.dye && itemstack.getItemDamage() == 15 && block instanceof BlockLog && (logFacing = meta & 0xC) != 12) {
                boolean onInnerFace = false;
                if (logFacing == 0) {
                    onInnerFace = side == 0 || side == 1;
                } else if (logFacing == 4) {
                    onInnerFace = side == 4 || side == 5;
                } else if (logFacing == 8) {
                    boolean bl2 = onInnerFace = side == 2 || side == 3;
                }
                if (onInnerFace) {
                    world.setBlockMetadataWithNotify(i, j, k, meta |= 0xC, 3);
                    world.playAuxSFX(2005, i, j, k, 0);
                    if (!entityplayer.capabilities.isCreativeMode) {
                        --itemstack.stackSize;
                    }
                    event.setCanceled(true);
                    return;
                }
            }
            if (!world.isRemote && LOTRBlockGrapevine.isFullGrownGrapes(block, meta)) {
                LOTREntityDorwinionGuard.defendGrapevines(entityplayer, world, i, j, k);
            }
            if (block == Blocks.bookshelf && !entityplayer.isSneaking() && LOTRBlockBookshelfStorage.canOpenBookshelf(world, i, j, k, entityplayer) && !world.isRemote) {
                world.setBlock(i, j, k, LOTRMod.bookshelfStorage, 0, 3);
                boolean flag = LOTRMod.bookshelfStorage.onBlockActivated(world, i, j, k, entityplayer, side, 0.5f, 0.5f, 0.5f);
                if (!flag) {
                    world.setBlock(i, j, k, Blocks.bookshelf, 0, 3);
                }
                event.setCanceled(true);
                return;
            }
            if (block == Blocks.enchanting_table && !LOTRConfig.isEnchantingEnabled(world) && !world.isRemote) {
                LOTRLevelData.getData(entityplayer).sendMessageIfNotReceived(LOTRGuiMessageTypes.ENCHANTING);
                event.setCanceled(true);
                return;
            }
            if (block == Blocks.brewing_stand && !LOTRConfig.enablePotionBrewing) {
                event.setCanceled(true);
                return;
            }
            if (block == Blocks.ender_chest && LOTRDimension.getCurrentDimensionWithFallback(world) == LOTRDimension.UTUMNO && LOTRConfig.disableEnderChestsUtumno) {
                event.setCanceled(true);
                return;
            }
            if (!(block != Blocks.anvil || !LOTRConfig.isLOTREnchantingEnabled(world) && LOTRConfig.isEnchantingEnabled(world) || world.isRemote)) {
                entityplayer.openGui((Object)LOTRMod.instance, 53, world, i, j, k);
                event.setCanceled(true);
                return;
            }
        }
        if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
            block = world.getBlock(i, j, k);
            meta = world.getBlockMetadata(i, j, k);
            ForgeDirection dir = ForgeDirection.getOrientation((int)side);
            int i1 = i + dir.offsetX;
            int j1 = j + dir.offsetY;
            int k1 = k + dir.offsetZ;
            Block block1 = world.getBlock(i1, j1, k1);
            if (!world.isRemote && LOTRBannerProtection.isProtected(world, i1, j1, k1, LOTRBannerProtection.forPlayer(entityplayer, LOTRBannerProtection.Permission.FULL), true) && block1 instanceof BlockFire) {
                event.setCanceled(true);
                return;
            }
        }
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        if (!LOTRConfig.enchantingVanilla && (event.left != null && event.left.getItem() instanceof ItemEnchantedBook || event.right != null && event.right.getItem() instanceof ItemEnchantedBook)) {
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public void onHarvestCheck(HarvestCheck event) {
        EntityPlayer entityplayer = event.entityPlayer;
        Block block = event.block;
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if (itemstack != null && block instanceof BlockWeb && itemstack.getItem() instanceof ItemShears) {
            event.success = true;
        }
    }

    @SubscribeEvent
    public void getBlockDrops(BlockEvent.HarvestDropsEvent event) {
        ItemStack itemstack;
        EntityPlayer entityplayer = event.harvester;
        Block block = event.block;
        if (entityplayer != null && (itemstack = entityplayer.getCurrentEquippedItem()) != null && block instanceof BlockWeb && itemstack.getItem() instanceof ItemShears) {
            int meta = 0;
            Item item = Item.getItemFromBlock((Block)block);
            if (item != null && item.getHasSubtypes()) {
                meta = event.blockMetadata;
            }
            ItemStack silkDrop = new ItemStack(item, 1, meta);
            event.drops.clear();
            event.drops.add(silkDrop);
        }
    }

    @SubscribeEvent
    public void onBreakingSpeed(BreakSpeed event) {
        float baseDigSpeed;
        EntityPlayer entityplayer = event.entityPlayer;
        Block block = event.block;
        int meta = event.metadata;
        float speed = event.newSpeed;
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if (itemstack != null && (baseDigSpeed = itemstack.getItem().getDigSpeed(itemstack, block, meta)) > 1.0f) {
            speed *= LOTREnchantmentHelper.calcToolEfficiency(itemstack);
        }
        event.newSpeed = speed;
    }

    @SubscribeEvent
    public void onBlockBreaking(BreakSpeed event) {
        EntityPlayer entityplayer = event.entityPlayer;
        World world = entityplayer.worldObj;
        Block block = event.block;
        int i = event.x;
        int j = event.y;
        int k = event.z;
        if (block instanceof LOTRWorldProviderUtumno.UtumnoBlock && LOTRDimension.getCurrentDimensionWithFallback(world) == LOTRDimension.UTUMNO) {
            boolean canMine = false;
            ItemStack itemstack = entityplayer.getCurrentEquippedItem();
            if (itemstack != null && itemstack.getItem() == LOTRMod.utumnoPickaxe) {
                canMine = true;
                int levelFuzz = 2;
                for (int l = 0; l < LOTRUtumnoLevel.values().length - 1; ++l) {
                    LOTRUtumnoLevel levelUpper = LOTRUtumnoLevel.values()[l];
                    LOTRUtumnoLevel levelLower = LOTRUtumnoLevel.values()[l + 1];
                    if (j < levelLower.getHighestCorridorRoof() + levelFuzz || j > levelUpper.getLowestCorridorFloor() - levelFuzz) continue;
                    canMine = false;
                }
            }
            if (!canMine) {
                event.setCanceled(true);
                return;
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        List trees;
        EntityPlayer entityplayer = event.getPlayer();
        Block block = event.block;
        int meta = event.blockMetadata;
        World world = event.world;
        int i = event.x;
        int j = event.y;
        int k = event.z;
        if (!world.isRemote && LOTRBannerProtection.isProtected(world, i, j, k, LOTRBannerProtection.forPlayer(entityplayer, LOTRBannerProtection.Permission.FULL), true)) {
            event.setCanceled(true);
            return;
        }
        if (!(world.isRemote || entityplayer == null || entityplayer.capabilities.isCreativeMode || !block.isWood((IBlockAccess)world, i, j, k) || LOTRBlockRottenLog.isRottenWood(block) || (trees = world.getEntitiesWithinAABB(LOTREntityTree.class, AxisAlignedBB.getBoundingBox((double)i, (double)j, (double)k, (double)(i + 1), (double)(j + 1), (double)(k + 1)).expand(16.0, 16.0, 16.0))).isEmpty())) {
            boolean sentMessage = false;
            boolean penalty = false;
            for (int l = 0; l < trees.size(); ++l) {
                LOTREntityTree tree = (LOTREntityTree)trees.get(l);
                if (tree.hiredNPCInfo.isActive && tree.hiredNPCInfo.getHiringPlayer() == entityplayer) continue;
                tree.setAttackTarget((EntityLivingBase)entityplayer);
                if (tree instanceof LOTREntityEnt && !sentMessage) {
                    tree.sendSpeechBank(entityplayer, "ent/ent/defendTrees");
                    sentMessage = true;
                }
                if (!(world.getBiomeGenForCoords(i, k) instanceof LOTRBiomeGenFangorn) || penalty) continue;
                LOTRLevelData.getData(entityplayer).addAlignment(entityplayer, LOTRAlignmentValues.FANGORN_TREE_PENALTY, LOTRFaction.FANGORN, (double)i + 0.5, (double)j + 0.5, (double)k + 0.5);
                penalty = true;
            }
        }
        if (!world.isRemote && entityplayer != null) {
            if (LOTRBlockGrapevine.isFullGrownGrapes(block, meta)) {
                LOTREntityDorwinionGuard.defendGrapevines(entityplayer, world, i, j, k);
            } else {
                boolean grapesAbove = false;
                for (int j1 = 1; j1 <= 3; ++j1) {
                    int aboveMeta;
                    int j2 = j + j1;
                    Block above = world.getBlock(i, j2, k);
                    if (!LOTRBlockGrapevine.isFullGrownGrapes(above, aboveMeta = world.getBlockMetadata(i, j2, k))) continue;
                    grapesAbove = true;
                }
                if (grapesAbove) {
                    LOTREntityDorwinionGuard.defendGrapevines(entityplayer, world, i, j + 1, k);
                }
            }
        }
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
        EntityPlayer entityplayer = event.player;
        Block block = event.block;
        World world = event.world;
        int i = event.x;
        int j = event.y;
        int k = event.z;
        if (world.provider instanceof LOTRWorldProviderUtumno && LOTRUtumnoLevel.forY(j) == LOTRUtumnoLevel.FIRE && block == Blocks.ice) {
            world.setBlock(i, j, k, Blocks.air, 0, 3);
            LOTRWorldProviderUtumno.doEvaporateFX(world, i, j, k);
            return;
        }
    }

    @SubscribeEvent
    public void onArrowNock(ArrowNockEvent event) {
        EntityPlayer entityplayer = event.entityPlayer;
        World world = entityplayer.worldObj;
        ItemStack itemstack = event.result;
        if (itemstack != null && itemstack.getItem() instanceof ItemBow && !(itemstack.getItem() instanceof LOTRItemBow) && !(itemstack.getItem() instanceof LOTRItemCrossbow)) {
            if (!world.isRemote) {
                if (this.proxyBowItemServer == null) {
                    this.proxyBowItemServer = new LOTRItemBow(Item.ToolMaterial.WOOD);
                    event.result = this.proxyBowItemServer.onItemRightClick(itemstack, world, entityplayer);
                    this.proxyBowItemServer = null;
                    event.setCanceled(true);
                    return;
                }
            } else if (this.proxyBowItemClient == null) {
                this.proxyBowItemClient = new LOTRItemBow(Item.ToolMaterial.WOOD);
                event.result = this.proxyBowItemClient.onItemRightClick(itemstack, world, entityplayer);
                this.proxyBowItemClient = null;
                event.setCanceled(true);
                return;
            }
        }
    }

    @SubscribeEvent
    public void onItemUseStop(PlayerUseItemEvent.Stop event) {
        EntityPlayer entityplayer = event.entityPlayer;
        World world = entityplayer.worldObj;
        ItemStack itemstack = event.item;
        int usingTick = event.duration;
        if (itemstack != null && itemstack.getItem() instanceof ItemBow && !(itemstack.getItem() instanceof LOTRItemBow) && !(itemstack.getItem() instanceof LOTRItemCrossbow)) {
            if (!world.isRemote) {
                if (this.proxyBowItemServer == null) {
                    this.proxyBowItemServer = new LOTRItemBow(Item.ToolMaterial.WOOD);
                }
                this.proxyBowItemServer.onPlayerStoppedUsing(itemstack, world, entityplayer, usingTick);
                this.proxyBowItemServer = null;
                event.setCanceled(true);
                return;
            }
            if (this.proxyBowItemClient == null) {
                this.proxyBowItemClient = new LOTRItemBow(Item.ToolMaterial.WOOD);
            }
            this.proxyBowItemClient.onPlayerStoppedUsing(itemstack, world, entityplayer, usingTick);
            this.proxyBowItemClient = null;
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public void onItemUseFinish(PlayerUseItemEvent.Finish event) {
        EntityPlayer entityplayer = event.entityPlayer;
        World world = entityplayer.worldObj;
        ItemStack itemstack = event.item;
        ItemStack result = event.result;
        if (!world.isRemote && LOTRPoisonedDrinks.isDrinkPoisoned(itemstack)) {
            LOTRPoisonedDrinks.addPoisonEffect(entityplayer, itemstack);
        }
    }

    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event) {
        EntityPlayer entityplayer = event.entityPlayer;
        World world = event.world;
        Random rand = world.rand;
        int i = event.x;
        int j = event.y;
        int k = event.z;
        if (!world.isRemote) {
            BiomeGenBase biomegenbase;
            if (event.block instanceof LOTRBlockSaplingBase) {
                LOTRBlockSaplingBase sapling = (LOTRBlockSaplingBase)event.block;
                int meta = world.getBlockMetadata(i, j, k);
                if ((double)rand.nextFloat() < 0.45) {
                    sapling.incrementGrowth(world, i, j, k, rand);
                }
                if (sapling == LOTRMod.sapling4 && (meta & 7) == 1 && world.getBlock(i, j, k) == LOTRMod.wood4 && world.getBlockMetadata(i, j, k) == 1) {
                    LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.growBaobab);
                }
                event.setResult(Event.Result.ALLOW);
                return;
            }
            if (event.block.canSustainPlant((IBlockAccess)world, i, j, k, ForgeDirection.UP, (IPlantable)Blocks.tallgrass) && event.block instanceof IGrowable && (biomegenbase = world.getBiomeGenForCoords(i, k)) instanceof LOTRBiome) {
                LOTRBiome biome = (LOTRBiome)biomegenbase;
                block0: for (int attempts = 0; attempts < 128; ++attempts) {
                    int i1 = i;
                    int j1 = j + 1;
                    int k1 = k;
                    for (int subAttempts = 0; subAttempts < attempts / 16; ++subAttempts) {
                        Block below = world.getBlock(i1 += rand.nextInt(3) - 1, (j1 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2) - 1, k1 += rand.nextInt(3) - 1);
                        if (!(below instanceof IGrowable) || !below.canSustainPlant((IBlockAccess)world, i1, j1 - 1, k1, ForgeDirection.UP, (IPlantable)Blocks.tallgrass) || world.getBlock(i1, j1, k1).isNormalCube()) continue block0;
                    }
                    if (world.getBlock(i1, j1, k1).getMaterial() != Material.air) continue;
                    if (rand.nextInt(8) > 0) {
                        LOTRBiome.GrassBlockAndMeta obj = biome.getRandomGrass(rand);
                        Block block = obj.block;
                        int meta = obj.meta;
                        if (!block.canBlockStay(world, i1, j1, k1)) continue;
                        world.setBlock(i1, j1, k1, block, meta, 3);
                        continue;
                    }
                    biome.plantFlower(world, rand, i1, j1, k1);
                }
                event.setResult(Event.Result.ALLOW);
                return;
            }
        }
    }

    @SubscribeEvent
    public void onSaplingGrow(SaplingGrowTreeEvent event) {
        World world = event.world;
        int i = event.x;
        int j = event.y;
        int k = event.z;
        Block block = world.getBlock(i, j, k);
        if (block == Blocks.sapling) {
            LOTRVanillaSaplings.growTree(world, i, j, k, event.rand);
            event.setResult(Event.Result.DENY);
            return;
        }
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event) {
        EntityPlayer entityplayer = event.entityPlayer;
        World world = event.world;
        int i = event.x;
        int j = event.y;
        int k = event.z;
        Block block = world.getBlock(i, j, k);
        LOTRBlockGrapevine.hoeing = true;
        if (world.getBlock(i, j + 1, k).isAir((IBlockAccess)world, i, j + 1, k) && (block == LOTRMod.mudGrass || block == LOTRMod.mud)) {
            Block tilled = LOTRMod.mudFarmland;
            world.playSoundEffect((double)((float)i + 0.5f), (double)((float)j + 0.5f), (double)((float)k + 0.5f), tilled.stepSound.getStepResourcePath(), (tilled.stepSound.getVolume() + 1.0f) / 2.0f, tilled.stepSound.getPitch() * 0.8f);
            if (!world.isRemote) {
                world.setBlock(i, j, k, tilled);
            }
            event.setResult(Event.Result.ALLOW);
            return;
        }
        LOTRBlockGrapevine.hoeing = true;
    }

    @SubscribeEvent
    public void onFillBucket(FillBucketEvent event) {
        EntityPlayer entityplayer = event.entityPlayer;
        ItemStack itemstack = event.current;
        World world = event.world;
        MovingObjectPosition target = event.target;
        if (target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            int i = target.blockX;
            int j = target.blockY;
            int k = target.blockZ;
            if (!world.isRemote && LOTRBannerProtection.isProtected(world, i, j, k, LOTRBannerProtection.forPlayer(entityplayer, LOTRBannerProtection.Permission.FULL), true)) {
                event.setCanceled(true);
                return;
            }
            if (world.provider instanceof LOTRWorldProviderUtumno && LOTRUtumnoLevel.forY(j) == LOTRUtumnoLevel.FIRE && itemstack != null && itemstack.getItem() == Items.water_bucket) {
                LOTRWorldProviderUtumno.doEvaporateFX(world, i, j, k);
                event.result = new ItemStack(Items.bucket);
                event.setResult(Event.Result.ALLOW);
                return;
            }
        }
    }

    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        EntityPlayer entityplayer = event.entityPlayer;
        ItemStack itemstack = event.item.getEntityItem();
        if (!entityplayer.worldObj.isRemote) {
            if (itemstack.stackSize > 0) {
                for (int i = 0; i < entityplayer.inventory.getSizeInventory(); ++i) {
                    ItemStack itemInSlot = entityplayer.inventory.getStackInSlot(i);
                    if (itemInSlot == null || itemInSlot.getItem() != LOTRMod.pouch) continue;
                    LOTRItemPouch.tryAddItemToPouch(itemInSlot, itemstack, true);
                    if (itemstack.stackSize <= 0) break;
                }
                if (itemstack.stackSize <= 0) {
                    event.setResult(Event.Result.ALLOW);
                }
            }
            if (itemstack.getItem() == Item.getItemFromBlock((Block)LOTRMod.athelas)) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.findAthelas);
            }
            if (itemstack.getItem() == Item.getItemFromBlock((Block)LOTRMod.clover) && itemstack.getItemDamage() == 1) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.findFourLeafClover);
            }
            if (itemstack.getItem() == LOTRMod.kineArawHorn) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.getKineArawHorn);
            }
            if (LOTRConfig.enchantingAutoRemoveVanilla) {
                LOTREventHandler.dechant(itemstack, entityplayer);
            }
        }
    }

    private static boolean dechant(ItemStack itemstack, EntityPlayer entityplayer) {
        Item item;
        if (!entityplayer.capabilities.isCreativeMode && itemstack != null && itemstack.isItemEnchanted() && !((item = itemstack.getItem()) instanceof ItemFishingRod)) {
            itemstack.getTagCompound().removeTag("ench");
            return true;
        }
        return false;
    }

    @SubscribeEvent
    public void onWorldSave(WorldEvent.Save event) {
        World world = event.world;
        if (!world.isRemote && world.provider.dimensionId == 0) {
            LOTRTime.save();
        }
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        World world = event.world;
        if (world.provider instanceof LOTRWorldProvider) {
            LOTRBiomeVariantStorage.clearAllVariants(world);
        }
    }

    @SubscribeEvent
    public void onChunkDataLoad(ChunkDataEvent.Load event) {
        World world = event.world;
        Chunk chunk = event.getChunk();
        NBTTagCompound data = event.getData();
        if (!world.isRemote && world.provider instanceof LOTRWorldProvider) {
            LOTRBiomeVariantStorage.loadChunkVariants(world, chunk, data);
        }
    }

    @SubscribeEvent
    public void onChunkDataSave(ChunkDataEvent.Save event) {
        World world = event.world;
        Chunk chunk = event.getChunk();
        NBTTagCompound data = event.getData();
        if (!world.isRemote && world.provider instanceof LOTRWorldProvider) {
            LOTRBiomeVariantStorage.saveChunkVariants(world, chunk, data);
        }
    }

    @SubscribeEvent
    public void onChunkStartWatching(ChunkWatchEvent.Watch event) {
        EntityPlayerMP entityplayer = event.player;
        World world = entityplayer.worldObj;
        ChunkCoordIntPair chunkCoords = event.chunk;
        Chunk chunk = world.getChunkFromChunkCoords(chunkCoords.chunkXPos, chunkCoords.chunkZPos);
        if (!world.isRemote && world.provider instanceof LOTRWorldProvider) {
            LOTRBiomeVariantStorage.sendChunkVariantsToPlayer(world, chunk, entityplayer);
        }
    }

    @SubscribeEvent
    public void onChunkStopWatching(ChunkWatchEvent.UnWatch event) {
        EntityPlayerMP entityplayer = event.player;
        World world = entityplayer.worldObj;
        ChunkCoordIntPair chunkCoords = event.chunk;
        Chunk chunk = world.getChunkFromChunkCoords(chunkCoords.chunkXPos, chunkCoords.chunkZPos);
        if (!world.isRemote && world.provider instanceof LOTRWorldProvider) {
            LOTRBiomeVariantStorage.sendUnwatchToPlayer(world, chunk, entityplayer);
        }
    }

    @SubscribeEvent
    public void onEntitySpawnAttempt(LivingSpawnEvent.CheckSpawn event) {
        EntityLivingBase entity = event.entityLiving;
        World world = entity.worldObj;
        if (!world.isRemote && entity instanceof EntityMob && LOTRBannerProtection.isProtected(world, (Entity)entity, LOTRBannerProtection.anyBanner(), false)) {
            event.setResult(Event.Result.DENY);
            return;
        }
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        EntityCreature entitycreature;
        String s;
        Object obj;
        Entity entity = event.entity;
        World world = entity.worldObj;
        if (!world.isRemote && entity instanceof EntityXPOrb && !LOTRConfig.enchantingVanilla && world.provider instanceof LOTRWorldProvider) {
            event.setCanceled(true);
            return;
        }
        if (!world.isRemote && entity instanceof EntityCreature && (obj = LOTREntityRegistry.registeredNPCs.get(s = EntityList.getEntityString((Entity)(entitycreature = (EntityCreature)entity)))) != null) {
            LOTREntityRegistry.RegistryInfo info = (LOTREntityRegistry.RegistryInfo)obj;
            if (info.shouldTargetEnemies) {
                LOTREntityNPC.addTargetTasks(entitycreature, 100, LOTREntityAINearestAttackableTargetBasic.class);
            }
        }
        if (!world.isRemote && entity.getClass() == EntityFishHook.class && world.provider instanceof LOTRWorldProvider) {
            EntityFishHook oldFish = (EntityFishHook)entity;
            NBTTagCompound fishData = new NBTTagCompound();
            oldFish.writeToNBT(fishData);
            oldFish.setDead();
            LOTREntityFishHook newFish = new LOTREntityFishHook(world);
            newFish.readFromNBT(fishData);
            newFish.field_146042_b = oldFish.field_146042_b;
            if (newFish.field_146042_b != null) {
                newFish.field_146042_b.fishEntity = newFish;
                newFish.setPlayerID(newFish.field_146042_b.getEntityId());
            }
            world.spawnEntityInWorld((Entity)newFish);
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public void onStartTrackingEntity(StartTracking event) {
        Entity entity = event.target;
        EntityPlayer entityplayer = event.entityPlayer;
        if (!entity.worldObj.isRemote && entity instanceof LOTREntityNPC) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entityplayer;
            LOTREntityNPC npc = (LOTREntityNPC)entity;
            npc.onPlayerStartTracking(entityplayermp);
        }
        if (!entity.worldObj.isRemote && entity instanceof LOTRRandomSkinEntity) {
            LOTRPacketEntityUUID packet = new LOTRPacketEntityUUID(entity.getEntityId(), entity.getUniqueID());
            LOTRPacketHandler.networkWrapper.sendTo((IMessage)packet, (EntityPlayerMP)entityplayer);
        }
        if (!entity.worldObj.isRemote && entity instanceof LOTREntityBanner) {
            ((LOTREntityBanner)entity).sendBannerToPlayer(entityplayer, false, false);
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        int k;
        boolean flag;
        int k2;
        int j;
        int l;
        int i;
        EntityLivingBase entity = event.entityLiving;
        World world = entity.worldObj;
        if (!world.isRemote) {
            LOTREnchantmentHelper.onEntityUpdate(entity);
        }
        if (LOTRConfig.enchantingAutoRemoveVanilla && !world.isRemote && entity instanceof EntityPlayer && entity.ticksExisted % 60 == 0) {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            for (int l2 = 0; l2 < entityplayer.inventory.getSizeInventory(); ++l2) {
                ItemStack itemstack = entityplayer.inventory.getStackInSlot(l2);
                if (itemstack == null) continue;
                LOTREventHandler.dechant(itemstack, entityplayer);
            }
        }
        boolean inWater = entity.isInWater();
        if (!world.isRemote && LOTRMod.canSpawnMobs(world) && entity.isEntityAlive() && inWater && entity.ridingEntity == null) {
            flag = true;
            if (entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode) {
                flag = false;
            }
            if (entity instanceof EntityWaterMob || entity instanceof LOTREntityMarshWraith) {
                flag = false;
            }
            if (flag) {
                int i2 = MathHelper.floor_double((double)entity.posX);
                k2 = MathHelper.floor_double((double)entity.posZ);
                int j2 = world.getTopSolidOrLiquidBlock(i2, k2);
                while (world.getBlock(i2, j2 + 1, k2).getMaterial().isLiquid() || world.getBlock(i2, j2 + 1, k2).getMaterial().isSolid()) {
                    ++j2;
                }
                if ((double)j2 - entity.boundingBox.minY < 2.0 && world.getBlock(i2, j2, k2).getMaterial() == Material.water && world.getBiomeGenForCoords(i2, k2) instanceof LOTRBiomeGenDeadMarshes) {
                    double wraithRange = 12.0;
                    double wraithRangeSq = 144.0;
                    double wraithCheckRange = 15.0;
                    List nearbyWraiths = world.getEntitiesWithinAABB(LOTREntityMarshWraith.class, entity.boundingBox.expand(15.0, 15.0, 15.0));
                    boolean anyNearbyWraiths = false;
                    for (int l3 = 0; l3 < nearbyWraiths.size(); ++l3) {
                        LOTREntityMarshWraith wraith = (LOTREntityMarshWraith)nearbyWraiths.get(l3);
                        if (wraith.getAttackTarget() != entity || wraith.getDeathFadeTime() != 0) continue;
                        anyNearbyWraiths = true;
                        break;
                    }
                    if (!anyNearbyWraiths) {
                        LOTREntityMarshWraith wraith = new LOTREntityMarshWraith(world);
                        int i1 = i2 + MathHelper.getRandomIntegerInRange((Random)world.rand, (int)-3, (int)3);
                        int k1 = k2 + MathHelper.getRandomIntegerInRange((Random)world.rand, (int)-3, (int)3);
                        int j1 = world.getTopSolidOrLiquidBlock(i1, k1);
                        wraith.setLocationAndAngles((double)i1 + 0.5, (double)j1, (double)k1 + 0.5, world.rand.nextFloat() * 360.0f, 0.0f);
                        if (wraith.getDistanceSqToEntity((Entity)entity) <= 144.0) {
                            world.spawnEntityInWorld((Entity)wraith);
                            wraith.setAttackTarget(entity);
                            wraith.attackTargetUUID = entity.getUniqueID();
                            world.playSoundAtEntity((Entity)wraith, "lotr:wraith.spawn", 1.0f, 0.7f + world.rand.nextFloat() * 0.6f);
                        }
                    }
                }
            }
        }
        if (!world.isRemote && LOTRMod.canSpawnMobs(world) && entity.isEntityAlive() && world.isDaytime()) {
            int i3;
            float f = 0.0f;
            int bounders = 0;
            if (LOTRFaction.HOBBIT.isBadRelation(LOTRMod.getNPCFaction((Entity)entity))) {
                float health = entity.getMaxHealth() + (float)entity.getTotalArmorValue();
                f = health * 2.5f;
                i3 = (int)(health / 15.0f);
                bounders = 2 + world.rand.nextInt(i3 + 1);
            } else if (entity instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                float alignment = LOTRLevelData.getData(entityplayer).getAlignment(LOTRFaction.HOBBIT);
                if (!entityplayer.capabilities.isCreativeMode && alignment < 0.0f) {
                    f = -alignment;
                    int i4 = (int)(f / 50.0f);
                    bounders = 2 + world.rand.nextInt(i4 + 1);
                }
            }
            if (f > 0.0f) {
                List nearbyBounders;
                f = Math.min(f, 2000.0f);
                int chance = (int)(2000000.0f / f);
                bounders = Math.min(bounders, 5);
                i3 = MathHelper.floor_double((double)entity.posX);
                int k3 = MathHelper.floor_double((double)entity.posZ);
                int j3 = world.getTopSolidOrLiquidBlock(i3, k3);
                if (world.rand.nextInt(chance) == 0 && world.getBiomeGenForCoords(i3, k3) instanceof LOTRBiomeGenShire && (nearbyBounders = world.getEntitiesWithinAABB(LOTREntityHobbitBounder.class, entity.boundingBox.expand(12.0, 6.0, 12.0))).isEmpty()) {
                    boolean sentMessage = false;
                    boolean playedHorn = false;
                    block3: for (int l4 = 0; l4 < bounders; ++l4) {
                        LOTREntityHobbitBounder bounder = new LOTREntityHobbitBounder(world);
                        for (int l1 = 0; l1 < 32; ++l1) {
                            int j1;
                            int k1;
                            int i1 = i3 - world.rand.nextInt(12) + world.rand.nextInt(12);
                            if (!world.getBlock(i1, (j1 = world.getTopSolidOrLiquidBlock(i1, k1 = k3 - world.rand.nextInt(12) + world.rand.nextInt(12))) - 1, k1).isSideSolid((IBlockAccess)world, i1, j1 - 1, k1, ForgeDirection.UP) || world.getBlock(i1, j1, k1).isNormalCube() || world.getBlock(i1, j1 + 1, k1).isNormalCube()) continue;
                            bounder.setLocationAndAngles((double)i1 + 0.5, (double)j1, (double)k1 + 0.5, 0.0f, 0.0f);
                            if (!bounder.getCanSpawnHere() || !((double)entity.getDistanceToEntity((Entity)bounder) > 6.0)) continue;
                            bounder.onSpawnWithEgg(null);
                            world.spawnEntityInWorld((Entity)bounder);
                            bounder.setAttackTarget(entity);
                            if (!sentMessage && entity instanceof EntityPlayer) {
                                EntityPlayer entityplayer = (EntityPlayer)entity;
                                bounder.sendSpeechBank(entityplayer, bounder.getSpeechBank(entityplayer));
                                sentMessage = true;
                            }
                            if (playedHorn) continue block3;
                            world.playSoundAtEntity((Entity)bounder, "lotr:item.horn", 2.0f, 2.0f);
                            playedHorn = true;
                            continue block3;
                        }
                    }
                }
            }
        }
        if (!world.isRemote && entity.isEntityAlive() && inWater && entity.ridingEntity == null && entity.ticksExisted % 10 == 0) {
            BiomeGenBase biome;
            flag = true;
            if (entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode) {
                flag = false;
            }
            if (entity instanceof LOTREntityMirkwoodSpider) {
                flag = false;
            }
            if (flag && (biome = world.getBiomeGenForCoords(i = MathHelper.floor_double((double)entity.posX), k2 = MathHelper.floor_double((double)entity.posZ))) instanceof LOTRBiomeGenMirkwoodCorrupted) {
                entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 1));
                entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600, 1));
                entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 600));
                entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 600));
            }
        }
        if (!world.isRemote && entity.isEntityAlive() && inWater && entity.ridingEntity == null && entity.ticksExisted % 10 == 0) {
            BiomeGenBase biome;
            flag = true;
            if (entity instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                if (entityplayer.capabilities.isCreativeMode) {
                    flag = false;
                } else {
                    float level;
                    float alignment = LOTRLevelData.getData(entityplayer).getAlignment(LOTRFaction.MORDOR);
                    if (alignment > (level = 100.0f)) {
                        flag = false;
                    } else {
                        int chance = Math.round(level);
                        if ((float)world.rand.nextInt(chance = Math.max(chance, 1)) < alignment) {
                            flag = false;
                        }
                    }
                }
            }
            if (LOTRMod.getNPCFaction((Entity)entity).isGoodRelation(LOTRFaction.MORDOR)) {
                flag = false;
            }
            if (flag && (biome = world.getBiomeGenForCoords(i = MathHelper.floor_double((double)entity.posX), k2 = MathHelper.floor_double((double)entity.posZ))) instanceof LOTRBiomeGenMorgulVale) {
                entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 1));
                entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600, 1));
                entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 600));
                entity.addPotionEffect(new PotionEffect(Potion.poison.id, 100));
            }
        }
        if (!world.isRemote && entity.isEntityAlive() && entity.ticksExisted % 10 == 0) {
            IAttributeInstance speedAttribute;
            boolean wearingAllWoodElvenScout = true;
            for (i = 0; i < 4; ++i) {
                ItemStack armour = entity.getEquipmentInSlot(i + 1);
                if (armour != null && armour.getItem() instanceof ItemArmor && ((ItemArmor)armour.getItem()).getArmorMaterial() == LOTRMaterial.WOOD_ELVEN_SCOUT.toArmorMaterial()) continue;
                wearingAllWoodElvenScout = false;
                break;
            }
            if ((speedAttribute = entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed)).getModifier(LOTREntityWoodElfScout.scoutArmorSpeedBoost.getID()) != null) {
                speedAttribute.removeModifier(LOTREntityWoodElfScout.scoutArmorSpeedBoost);
            }
            if (wearingAllWoodElvenScout) {
                speedAttribute.applyModifier(LOTREntityWoodElfScout.scoutArmorSpeedBoost);
            }
        }
        if (!world.isRemote && entity.isEntityAlive()) {
            IAttributeInstance speedAttribute;
            ItemStack weapon = entity.getHeldItem();
            boolean lanceOnFoot = false;
            if (weapon != null && weapon.getItem() instanceof LOTRItemLance && entity.ridingEntity == null) {
                lanceOnFoot = true;
                if (entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode) {
                    lanceOnFoot = false;
                }
            }
            if ((speedAttribute = entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed)).getModifier(LOTRItemLance.lanceSpeedBoost_id) != null) {
                speedAttribute.removeModifier(LOTRItemLance.lanceSpeedBoost);
            }
            if (lanceOnFoot) {
                speedAttribute.applyModifier(LOTRItemLance.lanceSpeedBoost);
            }
        }
        if (!world.isRemote && entity.isEntityAlive() && entity.ticksExisted % 20 == 0) {
            flag = true;
            if (entity instanceof LOTREntityNPC && ((LOTREntityNPC)entity).isImmuneToFrost) {
                flag = false;
            }
            if (entity instanceof EntityPlayer) {
                boolean bl = flag = !((EntityPlayer)entity).capabilities.isCreativeMode;
            }
            if (flag) {
                i = MathHelper.floor_double((double)entity.posX);
                j = MathHelper.floor_double((double)entity.boundingBox.minY);
                k = MathHelper.floor_double((double)entity.posZ);
                BiomeGenBase biome = world.getBiomeGenForCoords(i, k);
                if (biome instanceof LOTRBiomeGenForodwaith && (world.canBlockSeeTheSky(i, j, k) || inWater) && world.getSavedLightValue(EnumSkyBlock.Block, i, j, k) < 10) {
                    int frostChance = 50;
                    int frostProtection = 0;
                    for (l = 0; l < 4; ++l) {
                        ItemStack armor = entity.getEquipmentInSlot(l + 1);
                        if (armor == null || !(armor.getItem() instanceof ItemArmor)) continue;
                        ItemArmor.ArmorMaterial material = ((ItemArmor)armor.getItem()).getArmorMaterial();
                        Item materialItem = material.func_151685_b();
                        if (materialItem == Items.leather) {
                            frostProtection += 50;
                            continue;
                        }
                        if (materialItem != LOTRMod.fur) continue;
                        frostProtection += 100;
                    }
                    frostChance += frostProtection;
                    if (world.isRaining()) {
                        frostChance /= 3;
                    }
                    if (inWater) {
                        frostChance /= 20;
                    }
                    if (world.rand.nextInt(frostChance = Math.max(frostChance, 1)) == 0) {
                        entity.attackEntityFrom(LOTRDamage.frost, 1.0f);
                    }
                }
            }
        }
        if (!world.isRemote && entity.isEntityAlive() && entity.ticksExisted % 20 == 0) {
            flag = true;
            if (entity instanceof LOTREntityNPC) {
                flag = true;
            }
            if (entity instanceof EntityPlayer) {
                boolean bl = flag = !((EntityPlayer)entity).capabilities.isCreativeMode;
            }
            if (entity instanceof LOTRBiomeGenNearHarad.ImmuneToHeat) {
                flag = false;
            }
            if (flag) {
                i = MathHelper.floor_double((double)entity.posX);
                j = MathHelper.floor_double((double)entity.boundingBox.minY);
                k = MathHelper.floor_double((double)entity.posZ);
                BiomeGenBase biome = world.getBiomeGenForCoords(i, k);
                if (biome instanceof LOTRBiomeGenNearHarad && !inWater && world.canBlockSeeTheSky(i, j, k) && world.isDaytime()) {
                    boolean attacked;
                    int burnChance = 50;
                    int burnProtection = 0;
                    for (l = 0; l < 4; ++l) {
                        ItemStack armour = entity.getEquipmentInSlot(l + 1);
                        if (armour == null || !(armour.getItem() instanceof ItemArmor)) continue;
                        ItemArmor.ArmorMaterial material = ((ItemArmor)armour.getItem()).getArmorMaterial();
                        if (material.customCraftingMaterial == Items.leather) {
                            burnProtection += 50;
                        }
                        if (material == LOTRMaterial.HARAD_ROBES.toArmorMaterial()) {
                            burnProtection += 400;
                        }
                        if (material != LOTRMaterial.HARAD_NOMAD.toArmorMaterial()) continue;
                        burnProtection += 200;
                    }
                    burnChance += burnProtection;
                    if (world.rand.nextInt(burnChance = Math.max(burnChance, 1)) == 0 && (attacked = entity.attackEntityFrom(DamageSource.onFire, 1.0f)) && entity instanceof EntityPlayerMP) {
                        LOTRDamage.doBurnDamage((EntityPlayerMP)entity);
                    }
                }
            }
        }
        if (world.isRemote) {
            LOTRPlateFallingInfo.getOrCreateFor((Entity)entity, true).update();
        }
    }

    @SubscribeEvent
    public void onMinecartUpdate(MinecartUpdateEvent event) {
        EntityMinecart minecart = event.minecart;
    }

    @SubscribeEvent
    public void onMinecartInteract(MinecartInteractEvent event) {
        EntityPlayer entityplayer = event.player;
        World world = entityplayer.worldObj;
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        EntityMinecart minecart = event.minecart;
        if (minecart instanceof EntityMinecartChest && itemstack != null && itemstack.getItem() instanceof LOTRItemPouch) {
            if (!world.isRemote) {
                int pouchSlot = entityplayer.inventory.currentItem;
                entityplayer.openGui((Object)LOTRMod.instance, LOTRCommonProxy.packGuiIDWithSlot(64, pouchSlot), world, minecart.getEntityId(), 0, 0);
            }
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event) {
        String playerName;
        UUID brandingPlayer;
        EntityPlayer entityplayer = event.entityPlayer;
        World world = entityplayer.worldObj;
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        Entity entity = event.target;
        if (!world.isRemote && (entity instanceof EntityHanging || entity instanceof LOTRBannerProtectable) && LOTRBannerProtection.isProtected(world, entity, LOTRBannerProtection.forPlayer(entityplayer, LOTRBannerProtection.Permission.FULL), true)) {
            event.setCanceled(true);
            return;
        }
        if ((entity instanceof EntityCow || entity instanceof LOTREntityZebra) && itemstack != null && LOTRItemMug.isItemEmptyDrink(itemstack)) {
            LOTRItemMug.Vessel vessel = LOTRItemMug.getVessel(itemstack);
            ItemStack milkItem = new ItemStack(LOTRMod.mugMilk);
            LOTRItemMug.setVessel(milkItem, vessel, true);
            if (!entityplayer.capabilities.isCreativeMode) {
                --itemstack.stackSize;
            }
            if (itemstack.stackSize <= 0 || entityplayer.capabilities.isCreativeMode) {
                entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, milkItem);
            } else if (!entityplayer.inventory.addItemStackToInventory(milkItem)) {
                entityplayer.dropPlayerItemWithRandomChoice(milkItem, false);
            }
            event.setCanceled(true);
            return;
        }
        if (entity instanceof EntityWolf) {
            int dyeType;
            EntityWolf wolf = (EntityWolf)entity;
            if (itemstack != null && LOTRMod.isOreNameEqual(itemstack, "bone") && itemstack.getItem() != Items.bone) {
                Item prevItem = itemstack.getItem();
                itemstack.func_150996_a(Items.bone);
                boolean flag = wolf.interact(entityplayer);
                itemstack.func_150996_a(prevItem);
                if (flag) {
                    event.setCanceled(true);
                    return;
                }
            }
            if (itemstack != null && (dyeType = LOTRItemDye.isItemDye(itemstack)) >= 0 && itemstack.getItem() != Items.dye) {
                Item prevItem = itemstack.getItem();
                int prevMeta = itemstack.getItemDamage();
                itemstack.func_150996_a(Items.dye);
                itemstack.setItemDamage(dyeType);
                boolean flag = wolf.interact(entityplayer);
                itemstack.func_150996_a(prevItem);
                itemstack.setItemDamage(prevMeta);
                if (flag) {
                    event.setCanceled(true);
                    return;
                }
            }
        }
        if (entity instanceof LOTRTradeable && ((LOTRTradeable)entity).canTradeWith(entityplayer)) {
            if (entity instanceof LOTRUnitTradeable) {
                entityplayer.openGui((Object)LOTRMod.instance, 24, world, entity.getEntityId(), 0, 0);
            } else {
                entityplayer.openGui((Object)LOTRMod.instance, 19, world, entity.getEntityId(), 0, 0);
            }
            event.setCanceled(true);
            return;
        }
        if (entity instanceof LOTRUnitTradeable && ((LOTRUnitTradeable)entity).canTradeWith(entityplayer)) {
            entityplayer.openGui((Object)LOTRMod.instance, 20, world, entity.getEntityId(), 0, 0);
            event.setCanceled(true);
            return;
        }
        if (entity instanceof LOTRMercenary && ((LOTRMercenary)entity).canTradeWith(entityplayer) && ((LOTREntityNPC)entity).hiredNPCInfo.getHiringPlayerUUID() == null) {
            entityplayer.openGui((Object)LOTRMod.instance, 58, world, entity.getEntityId(), 0, 0);
            event.setCanceled(true);
            return;
        }
        if (entity instanceof LOTREntityNPC) {
            LOTREntityNPC npc = (LOTREntityNPC)entity;
            if (npc.hiredNPCInfo.getHiringPlayer() == entityplayer) {
                entityplayer.openGui((Object)LOTRMod.instance, 21, world, entity.getEntityId(), 0, 0);
                event.setCanceled(true);
                return;
            }
            if (npc.hiredNPCInfo.isActive && entityplayer.capabilities.isCreativeMode && itemstack != null && itemstack.getItem() == Items.clock) {
                UUID hiringUUID;
                String playerName2;
                if (!world.isRemote && MinecraftServer.getServer().getConfigurationManager().func_152596_g(entityplayer.getGameProfile()) && (hiringUUID = npc.hiredNPCInfo.getHiringPlayerUUID()) != null && (playerName2 = LOTREventHandler.getUsernameWithoutWebservice(hiringUUID)) != null) {
                    ChatComponentText msg = new ChatComponentText("Hired unit belongs to " + playerName2);
                    msg.getChatStyle().setColor(EnumChatFormatting.GREEN);
                    entityplayer.addChatMessage((IChatComponent)msg);
                }
                event.setCanceled(true);
                return;
            }
        }
        if (!world.isRemote && entityplayer.capabilities.isCreativeMode && MinecraftServer.getServer().getConfigurationManager().func_152596_g(entityplayer.getGameProfile()) && itemstack != null && itemstack.getItem() == Items.clock && entity instanceof EntityLiving && (brandingPlayer = LOTRItemBrandingIron.getBrandingPlayer(entity)) != null && (playerName = LOTREventHandler.getUsernameWithoutWebservice(brandingPlayer)) != null) {
            ChatComponentText msg = new ChatComponentText("Entity was branded by " + playerName);
            msg.getChatStyle().setColor(EnumChatFormatting.GREEN);
            entityplayer.addChatMessage((IChatComponent)msg);
            event.setCanceled(true);
            return;
        }
        if (entity instanceof EntityVillager && !LOTRConfig.enableVillagerTrading) {
            event.setCanceled(true);
            return;
        }
    }

    public static String getUsernameWithoutWebservice(UUID player) {
        GameProfile profile = MinecraftServer.getServer().func_152358_ax().func_152652_a(player);
        if (profile != null && !StringUtils.isBlank((CharSequence)profile.getName())) {
            return profile.getName();
        }
        String cachedName = UsernameCache.getLastKnownUsername((UUID)player);
        if (cachedName != null && !StringUtils.isBlank((CharSequence)cachedName)) {
            return cachedName;
        }
        return player.toString();
    }

    @SubscribeEvent
    public void onLivingSetAttackTarget(LivingSetAttackTargetEvent event) {
        boolean sneaking = false;
        if (event.target instanceof LOTREntityRanger && ((LOTREntityRanger)event.target).isRangerSneaking()) {
            sneaking = true;
        }
        if (event.target instanceof LOTREntityGaladhrimWarden && ((LOTREntityGaladhrimWarden)event.target).isElfSneaking()) {
            sneaking = true;
        }
        if (event.target instanceof LOTREntityHuornBase && !((LOTREntityHuornBase)event.target).isHuornActive()) {
            sneaking = true;
        }
        if (event.target instanceof EntityPlayer) {
            boolean cloak;
            EntityPlayer entityplayer = (EntityPlayer)event.target;
            boolean bl = cloak = LOTRLevelData.getData((EntityPlayer)event.target).isPlayerWearingFull(entityplayer) == LOTRMaterial.HITHLAIN;
            if (cloak && entityplayer.getLastAttacker() != event.entityLiving && entityplayer.getDistanceSqToEntity((Entity)event.entityLiving) >= 64.0) {
                sneaking = true;
            }
        }
        if (event.entityLiving instanceof EntityLiving && sneaking) {
            ((EntityLiving)event.entityLiving).setAttackTarget(null);
        }
    }

    @SubscribeEvent
    public void onEntityAttackedByPlayer(AttackEntityEvent event) {
        Entity entity = event.target;
        World world = entity.worldObj;
        EntityPlayer entityplayer = event.entityPlayer;
        if (!world.isRemote && (entity instanceof EntityHanging || entity instanceof LOTRBannerProtectable) && LOTRBannerProtection.isProtected(world, entity, LOTRBannerProtection.forPlayer(entityplayer, LOTRBannerProtection.Permission.FULL), true)) {
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public void onLivingAttacked(LivingAttackEvent event) {
        EntityLivingBase entity = event.entityLiving;
        EntityLivingBase attacker = event.source.getEntity() instanceof EntityLivingBase ? (EntityLivingBase)event.source.getEntity() : null;
        World world = entity.worldObj;
        if (entity instanceof LOTRNPCMount && entity.riddenByEntity != null && attacker == entity.riddenByEntity) {
            this.cancelAttackEvent(event);
        }
        if (attacker instanceof EntityPlayer && !LOTRMod.canPlayerAttackEntity((EntityPlayer)attacker, entity, true)) {
            this.cancelAttackEvent(event);
        }
        if (attacker instanceof EntityCreature && !LOTRMod.canNPCAttackEntity((EntityCreature)attacker, entity, false)) {
            this.cancelAttackEvent(event);
        }
        if (event.source instanceof EntityDamageSourceIndirect) {
            ItemStack chestplate;
            Entity projectile = event.source.getSourceOfDamage();
            if (projectile instanceof EntityArrow || projectile instanceof LOTREntityCrossbowBolt || projectile instanceof LOTREntityDart) {
                boolean wearingAllGalvorn = true;
                for (int i = 0; i < 4; ++i) {
                    ItemStack armour = entity.getEquipmentInSlot(i + 1);
                    if (armour != null && armour.getItem() instanceof ItemArmor && ((ItemArmor)armour.getItem()).getArmorMaterial() == LOTRMaterial.GALVORN.toArmorMaterial()) continue;
                    wearingAllGalvorn = false;
                    break;
                }
                if (wearingAllGalvorn) {
                    if (!world.isRemote && entity instanceof EntityPlayer) {
                        ((EntityPlayer)entity).inventory.damageArmor(event.ammount);
                    }
                    this.cancelAttackEvent(event);
                }
            }
            if (!world.isRemote && entity instanceof EntityPlayer && attacker instanceof LOTREntityOrc && projectile instanceof LOTREntitySpear && (chestplate = entity.getEquipmentInSlot(3)) != null && chestplate.getItem() == LOTRMod.bodyMithril) {
                LOTRLevelData.getData((EntityPlayer)entity).addAchievement(LOTRAchievement.hitByOrcSpear);
            }
        }
    }

    private void cancelAttackEvent(LivingAttackEvent event) {
        event.setCanceled(true);
        DamageSource source = event.source;
        if (source instanceof EntityDamageSourceIndirect) {
            Entity entity = source.getSourceOfDamage();
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        EntityLivingBase entity = event.entityLiving;
        EntityLivingBase attacker = event.source.getEntity() instanceof EntityLivingBase ? (EntityLivingBase)event.source.getEntity() : null;
        World world = entity.worldObj;
        if (entity instanceof EntityPlayerMP && event.source == LOTRDamage.frost) {
            LOTRDamage.doFrostDamage((EntityPlayerMP)entity);
        }
        if (!world.isRemote) {
            ItemStack weapon;
            int defaultMaxHurtResTime = 20;
            int preMaxHurtResTime = entity.maxHurtResistantTime;
            int maxHurtResTime = 20;
            if (attacker != null && LOTRWeaponStats.isMeleeWeapon(weapon = attacker.getHeldItem())) {
                maxHurtResTime = LOTRWeaponStats.getAttackTimeWithBase(weapon, 20);
            }
            entity.maxHurtResistantTime = maxHurtResTime = Math.min(maxHurtResTime, 20);
            if (entity.hurtResistantTime == preMaxHurtResTime) {
                entity.hurtResistantTime = maxHurtResTime;
            }
        }
        if (attacker != null && event.source.getSourceOfDamage() == attacker) {
            ItemStack usingItem;
            EntityPlayerMP entityplayer;
            ItemStack weapon = attacker.getHeldItem();
            if (!world.isRemote && entity instanceof EntityPlayerMP && (entityplayer = (EntityPlayerMP)entity).isUsingItem() && (usingItem = entityplayer.getHeldItem()) != null && LOTRWeaponStats.isRangedWeapon(usingItem)) {
                entityplayer.clearItemInUse();
                LOTRPacketStopItemUse packet = new LOTRPacketStopItemUse();
                LOTRPacketHandler.networkWrapper.sendTo((IMessage)packet, entityplayer);
            }
            boolean wearingAllMorgul = true;
            for (int i = 0; i < 4; ++i) {
                ItemStack armour = entity.getEquipmentInSlot(i + 1);
                if (armour != null && armour.getItem() instanceof ItemArmor && ((ItemArmor)armour.getItem()).getArmorMaterial() == LOTRMaterial.MORGUL.toArmorMaterial()) continue;
                wearingAllMorgul = false;
                break;
            }
            if (wearingAllMorgul && !world.isRemote && weapon != null && weapon.isItemStackDamageable()) {
                int damage = weapon.getItemDamage();
                int maxDamage = weapon.getMaxDamage();
                float durability = 1.0f - (float)damage / (float)maxDamage;
                int newDamage = Math.round((1.0f - (durability *= 0.9f)) * (float)maxDamage);
                newDamage = Math.min(newDamage, maxDamage);
                weapon.damageItem(newDamage - damage, attacker);
            }
            if (weapon != null) {
                Item.ToolMaterial material = null;
                if (weapon.getItem() instanceof ItemTool) {
                    material = ((ItemTool)weapon.getItem()).func_150913_i();
                } else if (weapon.getItem() instanceof ItemSword) {
                    material = LOTRMaterial.getToolMaterialByName(((ItemSword)weapon.getItem()).getToolMaterialName());
                }
                if (material != null && material == LOTRMaterial.MORGUL.toToolMaterial() && !world.isRemote) {
                    entity.addPotionEffect(new PotionEffect(Potion.wither.id, 160));
                }
            }
        }
        if (event.source.getSourceOfDamage() instanceof LOTREntityArrowPoisoned && !world.isRemote) {
            LOTRItemDagger.applyStandardPoison(entity);
        }
        if (!world.isRemote) {
            if (LOTREnchantmentHelper.hasMeleeOrRangedEnchant(event.source, LOTREnchantment.fire)) {
                LOTRPacketWeaponFX packet = new LOTRPacketWeaponFX(LOTRPacketWeaponFX.Type.INFERNAL, (Entity)entity);
                LOTRPacketHandler.networkWrapper.sendToAllAround((IMessage)packet, LOTRPacketHandler.nearEntity((Entity)entity, 64.0));
            }
            if (LOTREnchantmentHelper.hasMeleeOrRangedEnchant(event.source, LOTREnchantment.chill)) {
                LOTREnchantmentWeaponSpecial.doChillAttack(entity);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {
        int i;
        EntityPlayer entityplayer;
        int k;
        Entity attacker;
        int j;
        EntityLivingBase entity = event.entityLiving;
        World world = entity.worldObj;
        DamageSource source = event.source;
        if (!world.isRemote && entity instanceof EntityPlayer) {
            entityplayer = (EntityPlayer)entity;
            i = MathHelper.floor_double((double)entityplayer.posX);
            j = MathHelper.floor_double((double)entityplayer.posY);
            k = MathHelper.floor_double((double)entityplayer.posZ);
            LOTRLevelData.getData(entityplayer).setDeathPoint(i, j, k);
            LOTRLevelData.getData(entityplayer).setDeathDimension(entityplayer.dimension);
        }
        if (!world.isRemote) {
            entityplayer = null;
            boolean creditHiredUnit = false;
            boolean byNearbyUnit = false;
            if (source.getEntity() instanceof EntityPlayer) {
                entityplayer = (EntityPlayer)source.getEntity();
            } else if (entity.func_94060_bK() instanceof EntityPlayer) {
                entityplayer = (EntityPlayer)entity.func_94060_bK();
            } else if (source.getEntity() instanceof LOTREntityNPC) {
                LOTREntityNPC npc = (LOTREntityNPC)source.getEntity();
                if (npc.hiredNPCInfo.isActive && npc.hiredNPCInfo.getHiringPlayer() != null) {
                    EntityPlayer hirer;
                    entityplayer = hirer = npc.hiredNPCInfo.getHiringPlayer();
                    creditHiredUnit = true;
                    double nearbyDist = 64.0;
                    boolean bl = byNearbyUnit = npc.getDistanceSqToEntity((Entity)entityplayer) <= nearbyDist * nearbyDist;
                }
            }
            if (entityplayer != null) {
                LOTRPlayerData playerData = LOTRLevelData.getData(entityplayer);
                final LOTRFaction entityFaction = LOTRMod.getNPCFaction((Entity)entity);
                float prevAlignment = playerData.getAlignment(entityFaction);
                List<LOTRFaction> forcedBonusFactions = null;
                if (entity instanceof LOTREntityNPC) {
                    forcedBonusFactions = ((LOTREntityNPC)entity).killBonusFactions;
                }
                boolean wasSelfDefenceAgainstAlliedUnit = false;
                if (!creditHiredUnit && prevAlignment > 0.0f && entity instanceof LOTREntityNPC) {
                    LOTREntityNPC npc = (LOTREntityNPC)entity;
                    if (npc.hiredNPCInfo.isActive && npc.hiredNPCInfo.wasAttackCommanded) {
                        wasSelfDefenceAgainstAlliedUnit = true;
                    }
                }
                LOTRAlignmentValues.AlignmentBonus alignmentBonus = null;
                if (!wasSelfDefenceAgainstAlliedUnit) {
                    if (entity instanceof LOTREntityNPC) {
                        LOTREntityNPC npc = (LOTREntityNPC)entity;
                        alignmentBonus = new LOTRAlignmentValues.AlignmentBonus(npc.getAlignmentBonus(), npc.getEntityClassName());
                        alignmentBonus.needsTranslation = true;
                        alignmentBonus.isCivilianKill = npc.isCivilianNPC();
                    } else {
                        String s = EntityList.getEntityString((Entity)entity);
                        Object obj = LOTREntityRegistry.registeredNPCs.get(s);
                        if (obj != null) {
                            LOTREntityRegistry.RegistryInfo info = (LOTREntityRegistry.RegistryInfo)obj;
                            alignmentBonus = info.alignmentBonus;
                            alignmentBonus.isCivilianKill = false;
                        }
                    }
                }
                if (creditHiredUnit || wasSelfDefenceAgainstAlliedUnit) {
                    // empty if block
                }
                if (alignmentBonus != null && alignmentBonus.bonus != 0.0f && (!creditHiredUnit || creditHiredUnit && byNearbyUnit)) {
                    alignmentBonus.isKill = true;
                    if (creditHiredUnit) {
                        alignmentBonus.killByHiredUnit = true;
                    }
                    playerData.addAlignment(entityplayer, alignmentBonus, entityFaction, forcedBonusFactions, (Entity)entity);
                }
                if (!creditHiredUnit) {
                    if (entityFaction.allowPlayer) {
                        boolean recordBountyKill;
                        LOTRFaction pledgeFac;
                        playerData.getFactionData(entityFaction).addNPCKill();
                        List<LOTRFaction> killBonuses = entityFaction.getBonusesForKilling();
                        for (LOTRFaction enemy : killBonuses) {
                            playerData.getFactionData(enemy).addEnemyKill();
                        }
                        if (!entityplayer.capabilities.isCreativeMode && (recordBountyKill = entityFaction.inDefinedControlZone(entityplayer, Math.max(entityFaction.getControlZoneReducedRange(), 50)))) {
                            LOTRFactionBounties.forFaction(entityFaction).forPlayer(entityplayer).recordNewKill();
                        }
                        if ((pledgeFac = playerData.getPledgeFaction()) != null && (pledgeFac == entityFaction || pledgeFac.isAlly(entityFaction))) {
                            playerData.onPledgeKill(entityplayer);
                        }
                    }
                    float newAlignment = playerData.getAlignment(entityFaction);
                    if (!wasSelfDefenceAgainstAlliedUnit && !entityplayer.capabilities.isCreativeMode && entityFaction != LOTRFaction.UNALIGNED) {
                        int sentSpeeches = 0;
                        int maxSpeeches = 5;
                        double range = 8.0;
                        List nearbyAlliedNPCs = world.selectEntitiesWithinAABB(EntityLiving.class, entity.boundingBox.expand(range, range, range), new IEntitySelector(){

                            public boolean isEntityApplicable(Entity entitySelect) {
                                if (entitySelect.isEntityAlive()) {
                                    LOTRFaction fac = LOTRMod.getNPCFaction(entitySelect);
                                    return fac.isGoodRelation(entityFaction);
                                }
                                return false;
                            }
                        });
                        for (int i2 = 0; i2 < nearbyAlliedNPCs.size(); ++i2) {
                            String speech;
                            LOTREntityNPC lotrnpc;
                            EntityLiving npc = (EntityLiving)nearbyAlliedNPCs.get(i2);
                            if (npc instanceof LOTREntityNPC) {
                                LOTREntityNPC lotrNPC = (LOTREntityNPC)npc;
                                if (lotrNPC.hiredNPCInfo.isActive && newAlignment > 0.0f || lotrNPC.hiredNPCInfo.isActive && lotrNPC.hiredNPCInfo.getHiringPlayer() == entityplayer) continue;
                            }
                            if (npc.getAttackTarget() != null) continue;
                            npc.setAttackTarget((EntityLivingBase)entityplayer);
                            if (!(npc instanceof LOTREntityNPC) || sentSpeeches >= maxSpeeches || (speech = (lotrnpc = (LOTREntityNPC)npc).getSpeechBank(entityplayer)) == null || !(lotrnpc.getDistanceSqToEntity((Entity)entityplayer) < range)) continue;
                            lotrnpc.sendSpeechBank(entityplayer, speech);
                            ++sentSpeeches;
                        }
                    }
                    if (!playerData.isSiegeActive()) {
                        List<LOTRMiniQuest> miniquests = playerData.getMiniQuests();
                        for (LOTRMiniQuest quest : miniquests) {
                            quest.onKill(entityplayer, entity);
                        }
                        if (entity instanceof EntityPlayer) {
                            EntityPlayer slainPlayer = (EntityPlayer)entity;
                            List<LOTRMiniQuest> slainMiniquests = LOTRLevelData.getData(slainPlayer).getMiniQuests();
                            for (LOTRMiniQuest quest : slainMiniquests) {
                                quest.onKilledByPlayer(slainPlayer, entityplayer);
                            }
                        }
                    }
                }
            }
        }
        if (!world.isRemote && source.getEntity() instanceof EntityPlayer) {
            entityplayer = (EntityPlayer)source.getEntity();
            LOTREnchantmentHelper.onKillEntity(entityplayer, entity, source);
        }
        if (!world.isRemote && source.getEntity() instanceof EntityPlayer && source.getSourceOfDamage() != null && source.getSourceOfDamage().getClass() == LOTREntitySpear.class && entity != (entityplayer = (EntityPlayer)source.getEntity()) && entityplayer.getDistanceSqToEntity((Entity)entity) >= 2500.0) {
            LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.useSpearFromFar);
        }
        if (!world.isRemote && entity instanceof LOTREntityButterfly && source.getEntity() instanceof EntityPlayer) {
            entityplayer = (EntityPlayer)source.getEntity();
            LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.killButterfly);
        }
        if (!world.isRemote && entity.getClass() == LOTREntityHorse.class && source.getEntity() instanceof EntityPlayer) {
            List rohirrimList;
            entityplayer = (EntityPlayer)source.getEntity();
            if (!entityplayer.capabilities.isCreativeMode && !(rohirrimList = world.getEntitiesWithinAABB(LOTREntityRohanMan.class, entityplayer.boundingBox.expand(16.0, 16.0, 16.0))).isEmpty()) {
                boolean sentMessage = false;
                boolean penalty = false;
                for (int l = 0; l < rohirrimList.size(); ++l) {
                    LOTREntityRohanMan rohirrim = (LOTREntityRohanMan)rohirrimList.get(l);
                    if (rohirrim.hiredNPCInfo.isActive && rohirrim.hiredNPCInfo.getHiringPlayer() == entityplayer) continue;
                    rohirrim.setAttackTarget((EntityLivingBase)entityplayer);
                    if (!sentMessage) {
                        rohirrim.sendSpeechBank(entityplayer, "rohan/warrior/avengeHorse");
                        sentMessage = true;
                    }
                    if (penalty) continue;
                    LOTRLevelData.getData(entityplayer).addAlignment(entityplayer, LOTRAlignmentValues.ROHAN_HORSE_PENALTY, LOTRFaction.ROHAN, (Entity)entity);
                    penalty = true;
                }
            }
        }
        if (!world.isRemote) {
            EntityPlayer attackingPlayer = null;
            LOTREntityNPC attackingHiredUnit = null;
            if (source.getEntity() instanceof EntityPlayer) {
                attackingPlayer = (EntityPlayer)source.getEntity();
            } else if (source.getEntity() instanceof LOTREntityNPC) {
                LOTREntityNPC npc = (LOTREntityNPC)source.getEntity();
                if (npc.hiredNPCInfo.isActive && npc.hiredNPCInfo.getHiringPlayer() != null) {
                    attackingPlayer = npc.hiredNPCInfo.getHiringPlayer();
                    attackingHiredUnit = npc;
                }
            }
            if (attackingPlayer != null) {
                boolean isFoe;
                boolean bl = isFoe = LOTRLevelData.getData(attackingPlayer).getAlignment(LOTRMod.getNPCFaction((Entity)entity)) < 0.0f;
                if (isFoe) {
                    if (attackingHiredUnit != null) {
                        if (attackingHiredUnit instanceof LOTREntityWargBombardier) {
                            LOTRLevelData.getData(attackingPlayer).addAchievement(LOTRAchievement.hireWargBombardier);
                        }
                        if (attackingHiredUnit instanceof LOTREntityOlogHai) {
                            LOTRLevelData.getData(attackingPlayer).addAchievement(LOTRAchievement.hireOlogHai);
                        }
                    } else {
                        LOTREntityThrowingAxe axe;
                        LOTREntityOrc orc;
                        if (attackingPlayer.isPotionActive(Potion.confusion.id)) {
                            LOTRLevelData.getData(attackingPlayer).addAchievement(LOTRAchievement.killWhileDrunk);
                        }
                        if (entity instanceof LOTREntityOrc && (orc = (LOTREntityOrc)entity).isOrcBombardier() && orc.npcItemsInv.getBomb() != null) {
                            LOTRLevelData.getData(attackingPlayer).addAchievement(LOTRAchievement.killBombardier);
                        }
                        if (source.getSourceOfDamage() instanceof LOTREntityCrossbowBolt) {
                            LOTRLevelData.getData(attackingPlayer).addAchievement(LOTRAchievement.useCrossbow);
                        }
                        if (source.getSourceOfDamage() instanceof LOTREntityThrowingAxe && (axe = (LOTREntityThrowingAxe)source.getSourceOfDamage()).getProjectileItem().getItem() == LOTRMod.throwingAxeDwarven) {
                            LOTRLevelData.getData(attackingPlayer).addAchievement(LOTRAchievement.useDwarvenThrowingAxe);
                        }
                    }
                }
            }
        }
        if (!world.isRemote && LOTRMod.getNPCFaction((Entity)entity) == LOTRFaction.UTUMNO && LOTRDimension.getCurrentDimensionWithFallback(world) == LOTRDimension.UTUMNO && (attacker = source.getEntity()) instanceof EntityPlayer) {
            i = MathHelper.floor_double((double)entity.posX);
            j = MathHelper.floor_double((double)entity.boundingBox.minY);
            k = MathHelper.floor_double((double)entity.posZ);
            int range = LOTRBlockUtumnoReturnPortalBase.RANGE;
            for (int i1 = -range; i1 <= range; ++i1) {
                for (int j1 = -range; j1 <= range; ++j1) {
                    for (int k1 = -range; k1 <= range; ++k1) {
                        int i2 = i + i1;
                        int j2 = j + j1;
                        int k2 = k + k1;
                        if (world.getBlock(i2, j2, k2) != LOTRMod.utumnoReturnPortalBase) continue;
                        int meta = world.getBlockMetadata(i2, j2, k2);
                        if (++meta >= LOTRBlockUtumnoReturnPortalBase.MAX_SACRIFICE) {
                            world.createExplosion(attacker, (double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, 0.0f, false);
                            world.setBlock(i2, j2, k2, LOTRMod.utumnoReturnPortal, 0, 3);
                        } else {
                            world.setBlockMetadataWithNotify(i2, j2, k2, meta, 3);
                        }
                        LOTRPacketUtumnoKill packet = new LOTRPacketUtumnoKill(entity.getEntityId(), i2, j2, k2);
                        LOTRPacketHandler.networkWrapper.sendToAllAround((IMessage)packet, new NetworkRegistry.TargetPoint(entity.dimension, (double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, 32.0));
                    }
                }
            }
        }
        if (!world.isRemote && entity instanceof EntityPlayer) {
            entityplayer = (EntityPlayer)entity;
            if (LOTREnchantmentHelper.hasMeleeOrRangedEnchant(source, LOTREnchantment.headhunting)) {
                ItemStack playerHead = new ItemStack(Items.skull, 1, 3);
                GameProfile profile = entityplayer.getGameProfile();
                NBTTagCompound profileData = new NBTTagCompound();
                NBTUtil.func_152460_a((NBTTagCompound)profileData, (GameProfile)profile);
                playerHead.setTagInfo("SkullOwner", (NBTBase)profileData);
                entityplayer.entityDropItem(playerHead, 0.0f);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        EntityLivingBase entity = event.entityLiving;
        Random rand = entity.getRNG();
        ArrayList drops = event.drops;
        int i = event.lootingLevel;
        boolean flag = event.recentlyHit;
        if (entity instanceof EntitySheep && LOTRConfig.dropMutton) {
            int meat = rand.nextInt(3) + rand.nextInt(1 + i);
            for (int l = 0; l < meat; ++l) {
                if (entity.isBurning()) {
                    entity.dropItem(LOTRMod.muttonCooked, 1);
                    continue;
                }
                entity.dropItem(LOTRMod.muttonRaw, 1);
            }
        }
    }

    @SubscribeEvent
    public void onExplosionDetonate(ExplosionEvent.Detonate event) {
        Explosion expl = event.explosion;
        World world = event.world;
        Entity exploder = expl.exploder;
        if (!world.isRemote && exploder != null) {
            LOTRBannerProtection.IFilter protectFilter = null;
            if (exploder instanceof LOTREntityNPC) {
                protectFilter = LOTRBannerProtection.anyBanner();
            } else if (exploder instanceof EntityMob) {
                protectFilter = LOTRBannerProtection.anyBanner();
            } else if (exploder instanceof EntityThrowable) {
                protectFilter = LOTRBannerProtection.forThrown((EntityThrowable)exploder);
            } else if (exploder instanceof EntityTNTPrimed) {
                protectFilter = LOTRBannerProtection.forTNT((EntityTNTPrimed)exploder);
            } else if (exploder instanceof EntityMinecartTNT) {
                protectFilter = LOTRBannerProtection.forTNTMinecart((EntityMinecartTNT)exploder);
            }
            if (protectFilter != null) {
                List<ChunkPosition> blockList = expl.affectedBlockPositions;
                ArrayList<ChunkPosition> removes = new ArrayList<ChunkPosition>();
                for (ChunkPosition blockPos : blockList) {
                    int i = blockPos.chunkPosX;
                    int j = blockPos.chunkPosY;
                    int k = blockPos.chunkPosZ;
                    if (!LOTRBannerProtection.isProtected(world, i, j, k, protectFilter, false)) continue;
                    removes.add(blockPos);
                }
                blockList.removeAll(removes);
            }
        }
    }

    @SubscribeEvent
    public void onServerChat(ServerChatEvent event) {
        PotionEffect nausea;
        LOTRTitle.PlayerTitle playerTitle;
        EntityPlayerMP entityplayer = event.player;
        String message = event.message;
        String username = event.username;
        ChatComponentTranslation chatComponent = event.component;
        if (LOTRConfig.drunkMessages && (nausea = entityplayer.getActivePotionEffect(Potion.confusion)) != null) {
            ChatComponentTranslation newComponent;
            int duration = nausea.getDuration();
            float chance = (float)duration / 4800.0f;
            chance = Math.min(chance, 1.0f);
            chance *= 0.4f;
            Random rand = entityplayer.getRNG();
            String key = chatComponent.getKey();
            Object[] formatArgs = chatComponent.getFormatArgs();
            for (int a = 0; a < formatArgs.length; ++a) {
                Object arg = formatArgs[a];
                String chatText = null;
                if (arg instanceof ChatComponentText) {
                    ChatComponentText componentText = (ChatComponentText)arg;
                    chatText = componentText.getUnformattedText();
                } else if (arg instanceof String) {
                    chatText = (String)arg;
                }
                if (chatText == null || !chatText.equals(message)) continue;
                String newText = LOTRDrunkenSpeech.getDrunkenSpeech(chatText, chance);
                if (arg instanceof String) {
                    formatArgs[a] = newText;
                    continue;
                }
                if (!(arg instanceof ChatComponentText)) continue;
                formatArgs[a] = new ChatComponentText(newText);
            }
            chatComponent = newComponent = new ChatComponentTranslation(key, formatArgs);
        }
        if (LOTRConfig.enableTitles && (playerTitle = LOTRLevelData.getData((EntityPlayer)entityplayer).getPlayerTitle()) != null) {
            ArrayList<Object> newFormatArgs = new ArrayList<Object>();
            for (Object arg : chatComponent.getFormatArgs()) {
                if (arg instanceof ChatComponentText) {
                    ChatComponentText componentText = (ChatComponentText)arg;
                    if (componentText.getUnformattedText().contains(username)) {
                        ChatComponentText usernameComponent = componentText;
                        IChatComponent titleComponent = playerTitle.getFullTitleComponent((EntityPlayer)entityplayer);
                        IChatComponent fullUsernameComponent = new ChatComponentText("").appendSibling(titleComponent).appendSibling((IChatComponent)usernameComponent);
                        newFormatArgs.add((Object)fullUsernameComponent);
                        continue;
                    }
                    newFormatArgs.add((Object)componentText);
                    continue;
                }
                newFormatArgs.add(arg);
            }
            ChatComponentTranslation newChatComponent = new ChatComponentTranslation(chatComponent.getKey(), newFormatArgs.toArray());
            newChatComponent.setChatStyle(chatComponent.getChatStyle().createShallowCopy());
            for (Object sibling : chatComponent.getSiblings()) {
                newChatComponent.appendSibling((IChatComponent)sibling);
            }
            chatComponent = newChatComponent;
        }
        event.component = chatComponent;
    }

}

