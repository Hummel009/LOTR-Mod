/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.NetworkRegistry$TargetPoint
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.command.IEntitySelector
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.EntitySenses
 *  net.minecraft.entity.ai.RandomPositionGenerator
 *  net.minecraft.entity.ai.attributes.BaseAttributeMap
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.ai.attributes.RangedAttribute
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.pathfinding.PathNavigate
 *  net.minecraft.server.management.PlayerManager
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.EnumSkyBlock
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.chunk.Chunk
 */
package lotr.common.entity.npc;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRBannerProtection;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRConfig;
import lotr.common.LOTRDimension;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.LOTRPlayerData;
import lotr.common.LOTRShields;
import lotr.common.entity.LOTREntities;
import lotr.common.entity.LOTREntityInvasionSpawner;
import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.entity.LOTREntityUtils;
import lotr.common.entity.LOTRMountFunctions;
import lotr.common.entity.LOTRRandomSkinEntity;
import lotr.common.entity.ai.LOTREntityAIBurningPanic;
import lotr.common.entity.ai.LOTREntityAIHiringPlayerHurtByTarget;
import lotr.common.entity.ai.LOTREntityAIHiringPlayerHurtTarget;
import lotr.common.entity.ai.LOTREntityAINPCHurtByTarget;
import lotr.common.entity.ai.LOTREntityAINearestAttackableTargetBasic;
import lotr.common.entity.ai.LOTRNPCTargetSelector;
import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.entity.item.LOTREntityArrowPoisoned;
import lotr.common.entity.item.LOTREntityTraderRespawn;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.entity.npc.LOTRBoss;
import lotr.common.entity.npc.LOTRBossInfo;
import lotr.common.entity.npc.LOTRCharacter;
import lotr.common.entity.npc.LOTREntityOrc;
import lotr.common.entity.npc.LOTREntityQuestInfo;
import lotr.common.entity.npc.LOTREntityWarg;
import lotr.common.entity.npc.LOTRFamilyInfo;
import lotr.common.entity.npc.LOTRHiredNPCInfo;
import lotr.common.entity.npc.LOTRInventoryHiredReplacedItems;
import lotr.common.entity.npc.LOTRInventoryNPCItems;
import lotr.common.entity.npc.LOTRMercenary;
import lotr.common.entity.npc.LOTRNPCMount;
import lotr.common.entity.npc.LOTRSpeech;
import lotr.common.entity.npc.LOTRTradeEntry;
import lotr.common.entity.npc.LOTRTradeable;
import lotr.common.entity.npc.LOTRTraderNPCInfo;
import lotr.common.entity.npc.LOTRTravellingTrader;
import lotr.common.entity.npc.LOTRTravellingTraderInfo;
import lotr.common.entity.npc.LOTRUnitTradeable;
import lotr.common.entity.projectile.LOTREntityCrossbowBolt;
import lotr.common.entity.projectile.LOTREntityPebble;
import lotr.common.entity.projectile.LOTREntityPlate;
import lotr.common.fac.LOTRFaction;
import lotr.common.inventory.LOTRContainerAnvil;
import lotr.common.inventory.LOTRContainerCoinExchange;
import lotr.common.inventory.LOTRContainerTrade;
import lotr.common.inventory.LOTRContainerUnitTrade;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemLeatherHat;
import lotr.common.item.LOTRItemModifierTemplate;
import lotr.common.item.LOTRItemOwnership;
import lotr.common.item.LOTRItemPartyHat;
import lotr.common.item.LOTRItemPouch;
import lotr.common.item.LOTRItemSpear;
import lotr.common.item.LOTRItemTrident;
import lotr.common.item.LOTRWeaponStats;
import lotr.common.network.LOTRPacketHandler;
import lotr.common.network.LOTRPacketNPCCombatStance;
import lotr.common.network.LOTRPacketNPCFX;
import lotr.common.network.LOTRPacketNPCIsEating;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.world.LOTRUtumnoLevel;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public abstract class LOTREntityNPC
extends EntityCreature
implements IRangedAttackMob,
LOTRRandomSkinEntity {
    public static IAttribute npcAttackDamage = new RangedAttribute("lotr.npcAttackDamage", 2.0, 0.0, Double.MAX_VALUE).setDescription("LOTR NPC Attack Damage");
    public static IAttribute npcAttackDamageExtra = new RangedAttribute("lotr.npcAttackDamageExtra", 0.0, 0.0, Double.MAX_VALUE).setDescription("LOTR NPC Extra Attack Damage");
    public static IAttribute npcAttackDamageDrunk = new RangedAttribute("lotr.npcAttackDamageDrunk", 4.0, 0.0, Double.MAX_VALUE).setDescription("LOTR NPC Drunken Attack Damage");
    public static IAttribute npcRangedAccuracy = new RangedAttribute("lotr.npcRangedAccuracy", 1.0, 0.0, Double.MAX_VALUE).setDescription("LOTR NPC Ranged Accuracy");
    public static IAttribute horseAttackSpeed = new RangedAttribute("lotr.horseAttackSpeed", 1.7, 0.0, Double.MAX_VALUE).setDescription("LOTR Horse Attack Speed");
    public static float MOUNT_RANGE_BONUS = 1.5f;
    protected float npcWidth = -1.0f;
    protected float npcHeight;
    private boolean loadingFromNBT = false;
    public boolean isPassive = false;
    public boolean isImmuneToFrost = false;
    protected boolean isChilly = false;
    protected boolean spawnsInDarkness = false;
    public boolean isNPCPersistent = false;
    public boolean liftSpawnRestrictions = false;
    private boolean isConquestSpawning = false;
    public boolean liftBannerRestrictions = false;
    private boolean addedBurningPanic = false;
    public List<LOTRFaction> killBonusFactions = new ArrayList<LOTRFaction>();
    private UUID invasionID = null;
    private boolean isTargetSeeker = false;
    public String npcLocationName;
    private boolean hasSpecificLocationName;
    public boolean spawnRidingHorse;
    protected boolean canBannerBearerSpawnRiding = false;
    private boolean ridingMount;
    public LOTRFamilyInfo familyInfo;
    public LOTREntityQuestInfo questInfo;
    public LOTRHiredNPCInfo hiredNPCInfo;
    public LOTRTraderNPCInfo traderNPCInfo;
    public LOTRTravellingTraderInfo travellingTraderInfo;
    public boolean isTraderEscort = false;
    private boolean shouldTraderRespawn = false;
    public LOTRBossInfo bossInfo;
    private boolean setInitialHome = false;
    private int initHomeX;
    private int initHomeY;
    private int initHomeZ;
    private int initHomeRange = -1;
    private AttackMode currentAttackMode = AttackMode.IDLE;
    private boolean firstUpdatedAttackMode = false;
    private UUID prevAttackTarget;
    private int combatCooldown;
    private boolean combatStance;
    private boolean prevCombatStance;
    public boolean clientCombatStance;
    public boolean clientIsEating;
    private int nearbyBannerFactor;
    public LOTRInventoryNPCItems npcItemsInv;
    public LOTRInventoryHiredReplacedItems hiredReplacedInv;
    private ItemStack[] festiveItems = new ItemStack[5];
    private Random festiveRand = new Random();
    private boolean initFestiveItems = false;
    public LOTRShields npcShield;
    public ResourceLocation npcCape;
    public int npcTalkTick = 0;
    private boolean hurtOnlyByPlates = true;
    private List<ItemStack> enpouchedDrops = new ArrayList<ItemStack>();
    private boolean enpouchNPCDrops = false;

    public LOTREntityNPC(World world) {
        super(world);
        if (this instanceof LOTRBoss || this instanceof LOTRCharacter) {
            this.isNPCPersistent = true;
        }
    }

    public final boolean isTrader() {
        return this instanceof LOTRTradeable || this instanceof LOTRUnitTradeable || this instanceof LOTRMercenary;
    }

    protected void entityInit() {
        super.entityInit();
        this.familyInfo = new LOTRFamilyInfo(this);
        this.questInfo = new LOTREntityQuestInfo(this);
        this.hiredNPCInfo = new LOTRHiredNPCInfo(this);
        this.traderNPCInfo = new LOTRTraderNPCInfo(this);
        if (this instanceof LOTRTravellingTrader) {
            this.travellingTraderInfo = new LOTRTravellingTraderInfo((LOTRTravellingTrader)((Object)this));
        }
        if (this instanceof LOTRBoss) {
            this.bossInfo = new LOTRBossInfo((LOTRBoss)((Object)this));
        }
        this.setupNPCGender();
        this.setupNPCName();
        this.npcItemsInv = new LOTRInventoryNPCItems(this);
        this.hiredReplacedInv = new LOTRInventoryHiredReplacedItems(this);
    }

    public void setupNPCGender() {
    }

    public void setupNPCName() {
    }

    public void startTraderVisiting(EntityPlayer entityplayer) {
        this.travellingTraderInfo.startVisiting(entityplayer);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(npcAttackDamage);
        this.getAttributeMap().registerAttribute(npcAttackDamageExtra);
        this.getAttributeMap().registerAttribute(npcAttackDamageDrunk);
        this.getAttributeMap().registerAttribute(npcRangedAccuracy);
        this.getAttributeMap().registerAttribute(horseAttackSpeed);
    }

    @Override
    public void setUniqueID(UUID uuid) {
        this.entityUniqueID = uuid;
    }

    public int addTargetTasks(boolean seekTargets) {
        return this.addTargetTasks(seekTargets, LOTREntityAINearestAttackableTargetBasic.class);
    }

    public int addTargetTasks(boolean seekTargets, Class<? extends LOTREntityAINearestAttackableTargetBasic> c) {
        this.targetTasks.taskEntries.clear();
        this.targetTasks.addTask(1, (EntityAIBase)new LOTREntityAIHiringPlayerHurtByTarget(this));
        this.targetTasks.addTask(2, (EntityAIBase)new LOTREntityAIHiringPlayerHurtTarget(this));
        this.targetTasks.addTask(3, (EntityAIBase)new LOTREntityAINPCHurtByTarget(this, false));
        this.isTargetSeeker = seekTargets;
        if (seekTargets) {
            return LOTREntityNPC.addTargetTasks(this, 4, c);
        }
        return 3;
    }

    public static int addTargetTasks(EntityCreature entity, int index, Class<? extends LOTREntityAINearestAttackableTargetBasic> c) {
        try {
            Constructor<? extends LOTREntityAINearestAttackableTargetBasic> constructor = c.getConstructor(EntityCreature.class, Class.class, Integer.TYPE, Boolean.TYPE, IEntitySelector.class);
            entity.targetTasks.addTask(index, (EntityAIBase)constructor.newInstance(new Object[]{entity, EntityPlayer.class, 0, true, null}));
            entity.targetTasks.addTask(index, (EntityAIBase)constructor.newInstance(new Object[]{entity, EntityLiving.class, 0, true, new LOTRNPCTargetSelector((EntityLiving)entity)}));
        }
        catch (Exception e) {
            FMLLog.severe((String)("Error adding LOTR target tasks to entity " + entity.toString()), (Object[])new Object[0]);
            e.printStackTrace();
        }
        return index;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderDist(double dist) {
        LOTRPlayerData data;
        EntityPlayer entityplayer = LOTRMod.proxy.getClientPlayer();
        if (entityplayer != null && !(data = LOTRLevelData.getData(entityplayer)).getMiniQuestsForEntity(this, true).isEmpty()) {
            return true;
        }
        return super.isInRangeToRenderDist(dist);
    }

    protected boolean shouldBurningPanic() {
        return true;
    }

    public IEntityLivingData initCreatureForHire(IEntityLivingData data) {
        this.spawnRidingHorse = false;
        return this.onSpawnWithEgg(data);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        if(!this.worldObj.isRemote) {
            if(this.spawnRidingHorse && (!(this instanceof LOTRBannerBearer) || this.canBannerBearerSpawnRiding)) {
                LOTRNPCMount mount = this.createMountToRide();
                EntityCreature livingMount = (EntityCreature) mount;
                livingMount.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                if(this.worldObj.func_147461_a(livingMount.boundingBox).isEmpty()) {
                    livingMount.onSpawnWithEgg(null);
                    this.worldObj.spawnEntityInWorld(livingMount);
                    this.mountEntity(livingMount);
                    if(!(mount instanceof LOTREntityNPC)) {
                        this.setRidingHorse(true);
                        mount.setBelongsToNPC(true);
                        LOTRMountFunctions.setNavigatorRangeFromNPC(mount, this);
                    }
                }
            }
            if(this.traderNPCInfo.getBuyTrades() != null && this.rand.nextInt(10000) == 0) {
                for(LOTRTradeEntry trade : this.traderNPCInfo.getBuyTrades()) {
                    trade.setCost(trade.getCost() * 100);
                }
                this.familyInfo.setName("Noah");
            }
        }
        return data;
    }

    public LOTRNPCMount createMountToRide() {
        return new LOTREntityHorse(this.worldObj);
    }

    public void setRidingHorse(boolean flag) {
        this.ridingMount = flag;
        double d = this.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
        d = flag ? (d *= 1.5) : (d /= 1.5);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(d);
    }

    public void onPlayerStartTracking(EntityPlayerMP entityplayer) {
        this.hiredNPCInfo.sendBasicData(entityplayer);
        this.familyInfo.sendData(entityplayer);
        this.questInfo.sendData(entityplayer);
        this.sendCombatStance(entityplayer);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public final String getCommandSenderName() {
        if (this.hasCustomNameTag()) {
            return super.getCommandSenderName();
        }
        String entityName = this.getEntityClassName();
        String npcName = this.getNPCName();
        if (LOTRMod.isAprilFools()) {
            npcName = "Gandalf";
        }
        return this.getNPCFormattedName(npcName, entityName);
    }

    public String getNPCFormattedName(String npcName, String entityName) {
        if (npcName.equals(entityName)) {
            return entityName;
        }
        return StatCollector.translateToLocalFormatted((String)"entity.lotr.generic.entityName", (Object[])new Object[]{npcName, entityName});
    }

    public String getEntityClassName() {
        return super.getCommandSenderName();
    }

    public String getNPCName() {
        return super.getCommandSenderName();
    }

    public LOTRFaction getFaction() {
        return LOTRFaction.UNALIGNED;
    }

    public LOTRFaction getHiringFaction() {
        return this.getFaction();
    }

    public LOTRFaction getInfluenceZoneFaction() {
        return this.getFaction();
    }

    public boolean isCivilianNPC() {
        return !this.isTargetSeeker && !(this instanceof LOTRUnitTradeable) && !(this instanceof LOTRMercenary) && !(this instanceof LOTRBoss);
    }

    public boolean generatesControlZone() {
        return true;
    }

    public boolean canBeFreelyTargetedBy(EntityLiving attacker) {
        return true;
    }

    public int getNPCTalkInterval() {
        return 40;
    }

    public boolean canNPCTalk() {
        return this.isEntityAlive() && this.npcTalkTick >= this.getNPCTalkInterval();
    }

    public void markNPCSpoken() {
        this.npcTalkTick = 0;
    }

    public final void setAttackTarget(EntityLivingBase target) {
        boolean speak = target != null && this.getEntitySenses().canSee((Entity)target) && this.rand.nextInt(3) == 0;
        this.setAttackTarget(target, speak);
    }

    public void setAttackTarget(EntityLivingBase target, boolean speak) {
        EntityLivingBase prevEntityTarget = this.getAttackTarget();
        super.setAttackTarget(target);
        this.hiredNPCInfo.onSetTarget(target, prevEntityTarget);
        if (target != null && !target.getUniqueID().equals(this.prevAttackTarget)) {
            this.prevAttackTarget = target.getUniqueID();
            if (!this.worldObj.isRemote) {
                EntityPlayer entityplayer;
                String speechBank;
                if (this.getAttackSound() != null) {
                    this.worldObj.playSoundAtEntity((Entity)this, this.getAttackSound(), this.getSoundVolume(), this.getSoundPitch());
                }
                if (target instanceof EntityPlayer && speak && (speechBank = this.getSpeechBank(entityplayer = (EntityPlayer)target)) != null) {
                    IEntitySelector selectorAttackingNPCs = new IEntitySelector(){

                        public boolean isEntityApplicable(Entity entity) {
                            if (entity instanceof LOTREntityNPC) {
                                LOTREntityNPC npc = (LOTREntityNPC)entity;
                                return npc.isAIEnabled() && npc.isEntityAlive() && npc.getAttackTarget() == entityplayer;
                            }
                            return false;
                        }
                    };
                    double range = 16.0;
                    List nearbyMobs = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(range, range, range), selectorAttackingNPCs);
                    if (nearbyMobs.size() <= 5) {
                        this.sendSpeechBank(entityplayer, speechBank);
                    }
                }
            }
        }
    }

    public String getAttackSound() {
        return null;
    }

    public int getTalkInterval() {
        return 200;
    }

    public boolean isChild() {
        return this.familyInfo.getAge() < 0;
    }

    public void changeNPCNameForMarriage(LOTREntityNPC spouse) {
    }

    public void createNPCChildName(LOTREntityNPC maleParent, LOTREntityNPC femaleParent) {
    }

    public boolean canDespawn() {
        return !this.isNPCPersistent && !this.shouldTraderRespawn && !this.hiredNPCInfo.isActive && !this.questInfo.anyActiveQuestPlayers();
    }

    protected final void setSize(float f, float f1) {
        boolean flag = this.npcWidth > 0.0f;
        this.npcWidth = f;
        this.npcHeight = f1;
        if (!flag) {
            this.rescaleNPC(1.0f);
        }
    }

    protected void rescaleNPC(float f) {
        super.setSize(this.npcWidth * f, this.npcHeight * f);
    }

    protected float getNPCScale() {
        return this.isChild() ? 0.5f : 1.0f;
    }

    public void onLivingUpdate() {
        double speedSq;
        super.onLivingUpdate();
        this.rescaleNPC(this.getNPCScale());
        this.updateCombat();
        if (this.ticksExisted % 10 == 0) {
            this.updateNearbyBanners();
        }
        this.familyInfo.onUpdate();
        this.questInfo.onUpdate();
        this.hiredNPCInfo.onUpdate();
        if (this instanceof LOTRTradeable) {
            this.traderNPCInfo.onUpdate();
        }
        if (this.travellingTraderInfo != null) {
            this.travellingTraderInfo.onUpdate();
        }
        if ((this instanceof LOTRTradeable || this instanceof LOTRUnitTradeable) && !this.worldObj.isRemote) {
            double dSqToInitHome;
            int preventKidnap;
            if (!this.setInitialHome) {
                if (this.hasHome()) {
                    this.initHomeX = this.getHomePosition().posX;
                    this.initHomeY = this.getHomePosition().posY;
                    this.initHomeZ = this.getHomePosition().posZ;
                    this.initHomeRange = (int)this.func_110174_bM();
                }
                this.setInitialHome = true;
            }
            if ((preventKidnap = LOTRConfig.preventTraderKidnap) > 0 && this.setInitialHome && this.initHomeRange > 0 && (dSqToInitHome = this.getDistanceSq((double)this.initHomeX + 0.5, (double)this.initHomeY + 0.5, (double)this.initHomeZ + 0.5)) > (double)(preventKidnap * preventKidnap)) {
                if (this.ridingEntity != null) {
                    this.mountEntity(null);
                }
                this.worldObj.getChunkFromBlockCoords(this.initHomeX, this.initHomeZ);
                this.setLocationAndAngles((double)this.initHomeX + 0.5, (double)this.initHomeY, (double)this.initHomeZ + 0.5, this.rotationYaw, this.rotationPitch);
            }
        }
        if (this.bossInfo != null) {
            this.bossInfo.onUpdate();
        }
        if (!this.worldObj.isRemote && !this.addedBurningPanic) {
            LOTREntityUtils.removeAITask(this, LOTREntityAIBurningPanic.class);
            if (this.shouldBurningPanic()) {
                this.tasks.addTask(0, (EntityAIBase)new LOTREntityAIBurningPanic(this, 1.5));
            }
            this.addedBurningPanic = true;
        }
        if (!this.worldObj.isRemote && this.isEntityAlive() && (this.isTrader() || this.hiredNPCInfo.isActive) && this.getAttackTarget() == null) {
            int bannerInterval;
            float healAmount = 0.0f;
            if (this.ticksExisted % 40 == 0) {
                healAmount += 1.0f;
            }
            if (this.hiredNPCInfo.isActive && this.nearbyBannerFactor > 0 && this.ticksExisted % (bannerInterval = 240 - this.nearbyBannerFactor * 40) == 0) {
                healAmount += 1.0f;
            }
            if (healAmount > 0.0f) {
                this.heal(healAmount);
                if (this.ridingEntity instanceof EntityLivingBase && !(this.ridingEntity instanceof LOTREntityNPC)) {
                    ((EntityLivingBase)this.ridingEntity).heal(healAmount);
                }
            }
        }
        if (!this.worldObj.isRemote && this.isEntityAlive() && this.getAttackTarget() == null) {
            boolean guiOpen = false;
            if (this instanceof LOTRTradeable || this instanceof LOTRUnitTradeable || this instanceof LOTRMercenary) {
                for (int i = 0; i < this.worldObj.playerEntities.size(); ++i) {
                    EntityPlayer entityplayer = (EntityPlayer)this.worldObj.playerEntities.get(i);
                    Container container = entityplayer.openContainer;
                    if (container instanceof LOTRContainerTrade && ((LOTRContainerTrade)container).theTraderNPC == this) {
                        guiOpen = true;
                        break;
                    }
                    if (container instanceof LOTRContainerUnitTrade && ((LOTRContainerUnitTrade)container).theLivingTrader == this) {
                        guiOpen = true;
                        break;
                    }
                    if (container instanceof LOTRContainerCoinExchange && ((LOTRContainerCoinExchange)container).theTraderNPC == this) {
                        guiOpen = true;
                        break;
                    }
                    if (!(container instanceof LOTRContainerAnvil) || ((LOTRContainerAnvil)container).theNPC != this) continue;
                    guiOpen = true;
                    break;
                }
            }
            if (this.hiredNPCInfo.isActive && this.hiredNPCInfo.isGuiOpen) {
                guiOpen = true;
            }
            if (this.questInfo.anyOpenOfferPlayers()) {
                guiOpen = true;
            }
            if (guiOpen) {
                this.getNavigator().clearPathEntity();
                if (this.ridingEntity instanceof LOTRNPCMount) {
                    ((EntityLiving)this.ridingEntity).getNavigator().clearPathEntity();
                }
            }
        }
        this.updateArmSwingProgress();
        if (this.npcTalkTick < this.getNPCTalkInterval()) {
            ++this.npcTalkTick;
        }
        if (!this.worldObj.isRemote && this.hasHome() && !this.isWithinHomeDistanceCurrentPosition()) {
            int homeX = this.getHomePosition().posX;
            int homeY = this.getHomePosition().posY;
            int homeZ = this.getHomePosition().posZ;
            int homeRange = (int)this.func_110174_bM();
            double maxDist = (double)homeRange + 128.0;
            double distToHome = this.getDistance((double)homeX + 0.5, (double)homeY + 0.5, (double)homeZ + 0.5);
            if (distToHome > maxDist) {
                this.detachHome();
            } else if (this.getAttackTarget() == null && this.getNavigator().noPath()) {
                this.detachHome();
                boolean goDirectlyHome = false;
                if (this.worldObj.blockExists(homeX, homeY, homeZ) && this.hiredNPCInfo.isGuardMode()) {
                    int guardRange = this.hiredNPCInfo.getGuardRange();
                    goDirectlyHome = distToHome < 16.0;
                }
                double homeSpeed = 1.3;
                if (goDirectlyHome) {
                    this.getNavigator().tryMoveToXYZ((double)homeX + 0.5, (double)homeY + 0.5, (double)homeZ + 0.5, homeSpeed);
                } else {
                    Vec3 path = null;
                    for (int l = 0; l < 16 && path == null; ++l) {
                        path = RandomPositionGenerator.findRandomTargetBlockTowards((EntityCreature)this, (int)8, (int)7, (Vec3)Vec3.createVectorHelper((double)homeX, (double)homeY, (double)homeZ));
                    }
                    if (path != null) {
                        this.getNavigator().tryMoveToXYZ(path.xCoord, path.yCoord, path.zCoord, homeSpeed);
                    }
                }
                this.setHomeArea(homeX, homeY, homeZ, homeRange);
            }
        }
        if (this.isChilly && (speedSq = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ) >= 0.01) {
            double d = this.posX + (double)(MathHelper.randomFloatClamp((Random)this.rand, (float)-0.3f, (float)0.3f) * this.width);
            double d1 = this.boundingBox.minY + (double)(MathHelper.randomFloatClamp((Random)this.rand, (float)0.2f, (float)0.7f) * this.height);
            double d2 = this.posZ + (double)(MathHelper.randomFloatClamp((Random)this.rand, (float)-0.3f, (float)0.3f) * this.width);
            LOTRMod.proxy.spawnParticle("chill", d, d1, d2, -this.motionX * 0.5, 0.0, -this.motionZ * 0.5);
        }
    }

    private void updateCombat() {
        EntityLivingBase entity;
        if (!this.worldObj.isRemote && this.getAttackTarget() != null && (!(entity = this.getAttackTarget()).isEntityAlive() || entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode)) {
            this.setAttackTarget(null);
        }
        boolean changedMounted = false;
        boolean changedAttackMode = false;
        if (!this.worldObj.isRemote) {
            boolean isRidingMountNow;
            boolean bl = isRidingMountNow = this.ridingEntity instanceof EntityLiving && this.ridingEntity.isEntityAlive() && !(this.ridingEntity instanceof LOTREntityNPC);
            if (this.ridingMount != isRidingMountNow) {
                this.setRidingHorse(isRidingMountNow);
                changedMounted = true;
            }
        }
        if (!this.worldObj.isRemote && !this.isChild()) {
            boolean carryingSpearWithBackup;
            ItemStack weapon = this.getEquipmentInSlot(0);
            boolean bl = carryingSpearWithBackup = weapon != null && weapon.getItem() instanceof LOTRItemSpear && this.npcItemsInv.getSpearBackup() != null;
            if (this.getAttackTarget() != null) {
                double d = this.getDistanceSqToEntity((Entity)this.getAttackTarget());
                if (d < this.getMeleeRangeSq() || carryingSpearWithBackup) {
                    if (this.currentAttackMode != AttackMode.MELEE) {
                        this.currentAttackMode = AttackMode.MELEE;
                        changedAttackMode = true;
                    }
                } else if (d < this.getMaxCombatRangeSq() && this.currentAttackMode != AttackMode.RANGED) {
                    this.currentAttackMode = AttackMode.RANGED;
                    changedAttackMode = true;
                }
            } else if (this.currentAttackMode != AttackMode.IDLE) {
                this.currentAttackMode = AttackMode.IDLE;
                changedAttackMode = true;
            }
            if (!this.firstUpdatedAttackMode) {
                this.firstUpdatedAttackMode = true;
                changedAttackMode = true;
            }
        }
        if (changedAttackMode || changedMounted) {
            this.onAttackModeChange(this.currentAttackMode, this.ridingMount);
        }
        if (!this.worldObj.isRemote) {
            boolean bl = this.prevCombatStance = this.combatCooldown > 0;
            if (this.getAttackTarget() != null) {
                this.combatCooldown = 40;
            } else if (this.combatCooldown > 0) {
                --this.combatCooldown;
            }
            boolean bl2 = this.combatStance = this.combatCooldown > 0;
            if (this.combatStance != this.prevCombatStance) {
                int x = MathHelper.floor_double((double)this.posX) >> 4;
                int z = MathHelper.floor_double((double)this.posZ) >> 4;
                PlayerManager playermanager = ((WorldServer)this.worldObj).getPlayerManager();
                List players = this.worldObj.playerEntities;
                for (Object obj : players) {
                    EntityPlayerMP entityplayer = (EntityPlayerMP)obj;
                    if (!playermanager.isPlayerWatchingChunk(entityplayer, x, z)) continue;
                    this.sendCombatStance(entityplayer);
                }
            }
        }
    }

    protected void onAttackModeChange(AttackMode mode, boolean mounted) {
    }

    public void refreshCurrentAttackMode() {
        this.onAttackModeChange(this.currentAttackMode, this.ridingMount);
    }

    protected AttackMode getCurrentAttackMode() {
        return this.currentAttackMode;
    }

    public double getMeleeRange() {
        double d = 4.0 + (double)(this.width * this.width);
        if (this.ridingMount) {
            d *= (double)MOUNT_RANGE_BONUS;
        }
        return d;
    }

    public final double getMeleeRangeSq() {
        double d = this.getMeleeRange();
        return d * d;
    }

    public final double getMaxCombatRange() {
        double d = this.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
        return d * 0.95;
    }

    public final double getMaxCombatRangeSq() {
        double d = this.getMaxCombatRange();
        return d * d;
    }

    public final boolean isAimingRanged() {
        Item item;
        ItemStack itemstack = this.getHeldItem();
        if (itemstack != null && !((item = itemstack.getItem()) instanceof LOTRItemSpear) && !(item instanceof LOTRItemTrident) && itemstack.getItemUseAction() == EnumAction.bow) {
            EntityLivingBase target = this.getAttackTarget();
            return target != null && this.getDistanceSqToEntity((Entity)target) < this.getMaxCombatRangeSq();
        }
        return false;
    }

    private void sendCombatStance(EntityPlayerMP entityplayer) {
        LOTRPacketNPCCombatStance packet = new LOTRPacketNPCCombatStance(this.getEntityId(), this.combatStance);
        LOTRPacketHandler.networkWrapper.sendTo((IMessage)packet, entityplayer);
    }

    public void sendIsEatingToWatchers() {
        int x = MathHelper.floor_double((double)this.posX) >> 4;
        int z = MathHelper.floor_double((double)this.posZ) >> 4;
        PlayerManager playermanager = ((WorldServer)this.worldObj).getPlayerManager();
        List players = this.worldObj.playerEntities;
        for (Object obj : players) {
            EntityPlayerMP entityplayer = (EntityPlayerMP)obj;
            if (!playermanager.isPlayerWatchingChunk(entityplayer, x, z)) continue;
            this.sendIsEatingPacket(entityplayer);
        }
    }

    private void sendIsEatingPacket(EntityPlayerMP entityplayer) {
        LOTRPacketNPCIsEating packet = new LOTRPacketNPCIsEating(this.getEntityId(), this.npcItemsInv.getIsEating());
        LOTRPacketHandler.networkWrapper.sendTo((IMessage)packet, entityplayer);
    }

    protected void fall(float f) {
        if (this.bossInfo != null) {
            f = this.bossInfo.onFall(f);
        }
        super.fall(f);
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        this.familyInfo.writeToNBT(nbt);
        this.questInfo.writeToNBT(nbt);
        this.hiredNPCInfo.writeToNBT(nbt);
        this.traderNPCInfo.writeToNBT(nbt);
        if (this.travellingTraderInfo != null) {
            this.travellingTraderInfo.writeToNBT(nbt);
        }
        if (this.bossInfo != null) {
            this.bossInfo.writeToNBT(nbt);
        }
        this.npcItemsInv.writeToNBT(nbt);
        this.hiredReplacedInv.writeToNBT(nbt);
        nbt.setInteger("NPCHomeX", this.getHomePosition().posX);
        nbt.setInteger("NPCHomeY", this.getHomePosition().posY);
        nbt.setInteger("NPCHomeZ", this.getHomePosition().posZ);
        nbt.setInteger("NPCHomeRadius", (int)this.func_110174_bM());
        nbt.setBoolean("NPCPersistent", this.isNPCPersistent);
        if (this.npcLocationName != null) {
            nbt.setString("NPCLocationName", this.npcLocationName);
        }
        nbt.setBoolean("SpecificLocationName", this.hasSpecificLocationName);
        nbt.setBoolean("HurtOnlyByPlates", this.hurtOnlyByPlates);
        nbt.setBoolean("RidingHorse", this.ridingMount);
        nbt.setBoolean("NPCPassive", this.isPassive);
        nbt.setBoolean("TraderEscort", this.isTraderEscort);
        nbt.setBoolean("TraderShouldRespawn", this.shouldTraderRespawn);
        if (!this.killBonusFactions.isEmpty()) {
            NBTTagList bonusTags = new NBTTagList();
            for (LOTRFaction f : this.killBonusFactions) {
                String fName = f.codeName();
                bonusTags.appendTag((NBTBase)new NBTTagString(fName));
            }
            nbt.setTag("BonusFactions", (NBTBase)bonusTags);
        }
        if (this.invasionID != null) {
            nbt.setString("InvasionID", this.invasionID.toString());
        }
        nbt.setBoolean("SetInitHome", this.setInitialHome);
        nbt.setInteger("InitHomeX", this.initHomeX);
        nbt.setInteger("InitHomeY", this.initHomeY);
        nbt.setInteger("InitHomeZ", this.initHomeZ);
        nbt.setInteger("InitHomeR", this.initHomeRange);
    }

    public void readEntityFromNBT(NBTTagCompound nbt) {
        this.loadingFromNBT = true;
        super.readEntityFromNBT(nbt);
        this.familyInfo.readFromNBT(nbt);
        this.questInfo.readFromNBT(nbt);
        this.hiredNPCInfo.readFromNBT(nbt);
        this.traderNPCInfo.readFromNBT(nbt);
        if (this.travellingTraderInfo != null) {
            this.travellingTraderInfo.readFromNBT(nbt);
        }
        if (this.bossInfo != null) {
            this.bossInfo.readFromNBT(nbt);
        }
        this.npcItemsInv.readFromNBT(nbt);
        this.hiredReplacedInv.readFromNBT(nbt);
        if (nbt.hasKey("NPCHomeRadius")) {
            int x = nbt.getInteger("NPCHomeX");
            int y = nbt.getInteger("NPCHomeY");
            int z = nbt.getInteger("NPCHomeZ");
            int r = nbt.getInteger("NPCHomeRadius");
            this.setHomeArea(x, y, z, r);
        }
        if (nbt.hasKey("NPCPersistent")) {
            this.isNPCPersistent = nbt.getBoolean("NPCPersistent");
        }
        if (nbt.hasKey("NPCLocationName")) {
            this.npcLocationName = nbt.getString("NPCLocationName");
        }
        this.hasSpecificLocationName = nbt.getBoolean("SpecificLocationName");
        this.hurtOnlyByPlates = nbt.getBoolean("HurtOnlyByPlates");
        this.ridingMount = nbt.getBoolean("RidingHorse");
        this.isPassive = nbt.getBoolean("NPCPassive");
        this.isTraderEscort = nbt.getBoolean("TraderEscort");
        this.shouldTraderRespawn = nbt.hasKey("TraderShouldRespawn") ? nbt.getBoolean("TraderShouldRespawn") : (this instanceof LOTRTradeable || this instanceof LOTRUnitTradeable ? (this instanceof LOTRTravellingTrader ? false : this.isNPCPersistent) : false);
        if (nbt.hasKey("BonusFactions")) {
            NBTTagList bonusTags = nbt.getTagList("BonusFactions", 8);
            for (int i = 0; i < bonusTags.tagCount(); ++i) {
                String fName = bonusTags.getStringTagAt(i);
                LOTRFaction f = LOTRFaction.forName(fName);
                if (f == null) continue;
                this.killBonusFactions.add(f);
            }
        }
        if (nbt.hasKey("InvasionID")) {
            String invID = nbt.getString("InvasionID");
            try {
                this.invasionID = UUID.fromString(invID);
            }
            catch (IllegalArgumentException e) {
                FMLLog.warning((String)"LOTR: Error loading NPC - %s is not a valid invasion UUID", (Object[])new Object[]{invID});
                e.printStackTrace();
            }
        }
        this.setInitialHome = nbt.getBoolean("SetInitHome");
        this.initHomeX = nbt.getInteger("InitHomeX");
        this.initHomeY = nbt.getInteger("InitHomeY");
        this.initHomeZ = nbt.getInteger("InitHomeZ");
        this.initHomeRange = nbt.getInteger("InitHomeR");
        this.loadingFromNBT = false;
    }

    public ItemStack getPickedResult(MovingObjectPosition target) {
        int id = LOTREntities.getEntityID((Entity)this);
        if (LOTREntities.spawnEggs.containsKey(id)) {
            return new ItemStack(LOTRMod.spawnEgg, 1, id);
        }
        return null;
    }

    public boolean attackEntityAsMob(Entity entity) {
        boolean flag;
        float damage = (float)this.getEntityAttribute(npcAttackDamage).getAttributeValue();
        float weaponDamage = 0.0f;
        ItemStack weapon = this.getEquipmentInSlot(0);
        if (weapon != null) {
            weaponDamage = LOTRWeaponStats.getMeleeDamageBonus(weapon) * 0.75f;
        }
        if (weaponDamage > 0.0f) {
            damage = weaponDamage;
        }
        damage += (float)this.getEntityAttribute(npcAttackDamageExtra).getAttributeValue();
        if (this.isDrunkard()) {
            damage += (float)this.getEntityAttribute(npcAttackDamageDrunk).getAttributeValue();
        }
        damage += (float)this.nearbyBannerFactor * 0.5f;
        int knockbackModifier = 0;
        if (entity instanceof EntityLivingBase) {
            damage += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)((EntityLivingBase)entity));
            knockbackModifier += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)((EntityLivingBase)entity));
        }
        if (flag = entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), damage)) {
            int fireAspectModifier;
            if (weapon != null && entity instanceof EntityLivingBase) {
                int weaponItemDamage = weapon.getItemDamage();
                weapon.getItem().hitEntity(weapon, (EntityLivingBase)entity, (EntityLivingBase)this);
                weapon.setItemDamage(weaponItemDamage);
            }
            if (knockbackModifier > 0) {
                entity.addVelocity((double)(-MathHelper.sin((float)(this.rotationYaw * 3.1415927f / 180.0f)) * (float)knockbackModifier * 0.5f), 0.1, (double)(MathHelper.cos((float)(this.rotationYaw * 3.1415927f / 180.0f)) * (float)knockbackModifier * 0.5f));
                this.motionX *= 0.6;
                this.motionZ *= 0.6;
            }
            if ((fireAspectModifier = EnchantmentHelper.getFireAspectModifier((EntityLivingBase)this)) > 0) {
                entity.setFire(fireAspectModifier * 4);
            }
            if (entity instanceof EntityLivingBase) {
                EnchantmentHelper.func_151384_a((EntityLivingBase)((EntityLivingBase)entity), (Entity)this);
            }
            EnchantmentHelper.func_151385_b((EntityLivingBase)this, (Entity)entity);
        }
        return flag;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.npcArrowAttack(target, f);
    }

    protected void npcArrowAttack(EntityLivingBase target, float f) {
        ItemStack heldItem = this.getHeldItem();
        float str = 1.3f + this.getDistanceToEntity(target) / 80.0f;
        float accuracy = (float) this.getEntityAttribute(npcRangedAccuracy).getAttributeValue();
        float poisonChance = this.getPoisonedArrowChance();
        EntityArrow arrow = this.rand.nextFloat() < poisonChance ? new LOTREntityArrowPoisoned(this.worldObj, this, target, str, accuracy) : new EntityArrow(this.worldObj, this, target, str *= LOTRItemBow.getLaunchSpeedFactor(heldItem), accuracy);
        if(heldItem != null) {
            LOTRItemBow.applyBowModifiers(arrow, heldItem);
        }
        this.playSound("random.bow", 1.0f, 1.0f / (this.rand.nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(arrow);
    }

    protected void npcCrossbowAttack(EntityLivingBase target, float f) {
        ItemStack heldItem = this.getHeldItem();
        float str = 1.0f + this.getDistanceToEntity((Entity)target) / 16.0f * 0.015f;
        boolean poison = this.rand.nextFloat() < this.getPoisonedArrowChance();
        ItemStack boltItem = poison ? new ItemStack(LOTRMod.crossbowBoltPoisoned) : new ItemStack(LOTRMod.crossbowBolt);
        LOTREntityCrossbowBolt bolt = new LOTREntityCrossbowBolt(this.worldObj, (EntityLivingBase)this, target, boltItem, str *= LOTRItemCrossbow.getCrossbowLaunchSpeedFactor(heldItem), 1.0f);
        if (heldItem != null) {
            LOTRItemCrossbow.applyCrossbowModifiers(bolt, heldItem);
        }
        this.playSound("lotr:item.crossbow", 1.0f, 1.0f / (this.rand.nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld((Entity)bolt);
    }

    protected float getPoisonedArrowChance() {
        return 0.0f;
    }

    public void onKillEntity(EntityLivingBase entity) {
        super.onKillEntity(entity);
        this.hiredNPCInfo.onKillEntity(entity);
        if (this.lootsExtraCoins() && !this.worldObj.isRemote && entity instanceof LOTREntityNPC && ((LOTREntityNPC)entity).canDropRares() && this.rand.nextInt(2) == 0) {
            int coins = this.getRandomCoinDropAmount();
            if ((coins = (int)((float)coins * MathHelper.randomFloatClamp((Random)this.rand, (float)1.0f, (float)3.0f))) > 0) {
                entity.dropItem(LOTRMod.silverCoin, coins);
            }
        }
    }

    public boolean lootsExtraCoins() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource damagesource, float f) {
        boolean flag;
        if (this.riddenByEntity != null && damagesource.getEntity() == this.riddenByEntity) {
            return false;
        }
        if (this.nearbyBannerFactor > 0) {
            int i = 12 - this.nearbyBannerFactor;
            float f1 = f * (float)i;
            f = f1 / 12.0f;
        }
        if ((flag = super.attackEntityFrom(damagesource, f)) && damagesource.getEntity() instanceof LOTREntityNPC) {
            LOTREntityNPC attacker = (LOTREntityNPC)damagesource.getEntity();
            if (attacker.hiredNPCInfo.isActive && attacker.hiredNPCInfo.getHiringPlayer() != null) {
                this.recentlyHit = 100;
                this.attackingPlayer = null;
            }
        }
        if (flag && !this.worldObj.isRemote && this.hurtOnlyByPlates) {
            this.hurtOnlyByPlates = damagesource.getSourceOfDamage() instanceof LOTREntityPlate;
        }
        if (flag && !this.worldObj.isRemote && this.isInvasionSpawned() && damagesource.getEntity() instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer)damagesource.getEntity();
            LOTREntityInvasionSpawner invasion = LOTREntityInvasionSpawner.locateInvasionNearby((Entity)this, this.invasionID);
            if (invasion != null) {
                invasion.setWatchingInvasion((EntityPlayerMP)entityplayer, true);
            }
        }
        return flag;
    }

    protected void damageEntity(DamageSource damagesource, float f) {
        super.damageEntity(damagesource, f);
        if (this.bossInfo != null) {
            this.bossInfo.onHurt(damagesource, f);
        }
    }

    public final boolean canPickUpLoot() {
        return false;
    }

    protected void dropFewItems(boolean flag, int i) {
        this.hiredReplacedInv.dropAllReplacedItems();
        this.dropNPCEquipment(flag, i);
        if (flag && this.canDropRares()) {
            int coinChance = 8 - i * 2;
            if (this.rand.nextInt(coinChance = Math.max(coinChance, 1)) == 0) {
                int coins = this.getRandomCoinDropAmount();
                this.dropItem(LOTRMod.silverCoin, coins *= MathHelper.getRandomIntegerInRange((Random)this.rand, (int)1, (int)(i + 1)));
            }
            int rareChance = 50 - i * 5;
            if (this.rand.nextInt(rareChance = Math.max(rareChance, 1)) == 0) {
                this.dropChestContents(LOTRChestContents.RARE_DROPS, 1, 1);
            }
        }
        if (flag && this.canDropRares()) {
            int modChance = 60;
            modChance -= i * 5;
            if (this.rand.nextInt(modChance = Math.max(modChance, 1)) == 0) {
                ItemStack modItem = LOTRItemModifierTemplate.getRandomCommonTemplate(this.rand);
                this.entityDropItem(modItem, 0.0f);
            }
        }
        if (this.getFaction() == LOTRFaction.UTUMNO && LOTRDimension.getCurrentDimensionWithFallback(this.worldObj) == LOTRDimension.UTUMNO) {
            LOTRUtumnoLevel level = LOTRUtumnoLevel.forY((int)this.posY);
            if (this.rand.nextInt(12) == 0) {
                int l;
                if (level == LOTRUtumnoLevel.ICE) {
                    ItemStack keypart = new ItemStack(LOTRMod.utumnoKey);
                    l = this.rand.nextInt(3);
                    if (l == 0) {
                        keypart.setItemDamage(2);
                    } else if (l == 1) {
                        keypart.setItemDamage(3);
                    } else if (l == 2) {
                        keypart.setItemDamage(4);
                    }
                    this.entityDropItem(keypart, 0.0f);
                } else if (level == LOTRUtumnoLevel.OBSIDIAN) {
                    ItemStack keypart = new ItemStack(LOTRMod.utumnoKey);
                    l = this.rand.nextInt(3);
                    if (l == 0) {
                        keypart.setItemDamage(5);
                    } else if (l == 1) {
                        keypart.setItemDamage(6);
                    } else if (l == 2) {
                        keypart.setItemDamage(7);
                    }
                    this.entityDropItem(keypart, 0.0f);
                }
            }
            if (level == LOTRUtumnoLevel.ICE && this.isChilly) {
                int chillChance = 30;
                chillChance -= i * 3;
                if (this.rand.nextInt(chillChance = Math.max(chillChance, 1)) == 0) {
                    int chills = 1;
                    if (i > 0) {
                        float x = MathHelper.randomFloatClamp((Random)this.rand, (float)0.0f, (float)((float)i * 0.667f));
                        while (x > 1.0f) {
                            x -= 1.0f;
                            ++chills;
                        }
                        if (this.rand.nextFloat() < x) {
                            ++chills;
                        }
                    }
                    for (int l = 0; l < chills; ++l) {
                        this.dropItem(LOTRMod.chilling, 1);
                    }
                }
            }
            if (level == LOTRUtumnoLevel.FIRE && this.canDropRares()) {
                int pickChance = 100;
                pickChance -= i * 20;
                if (this.rand.nextInt(pickChance = Math.max(pickChance, 1)) == 0) {
                    this.entityDropItem(new ItemStack(LOTRMod.utumnoPickaxe), 0.0f);
                }
            }
            if (this.rand.nextInt(20) == 0) {
                this.entityDropItem(new ItemStack(LOTRMod.mithrilNugget), 0.0f);
            }
        }
    }

    protected int getRandomCoinDropAmount() {
        return 1 + (int)Math.round(Math.pow(1.0 + Math.abs(this.rand.nextGaussian()), 3.0) * 0.25);
    }

    public void dropNPCEquipment(boolean flag, int i) {
        if (flag) {
            int j;
            int equipmentCount = 0;
            for (j = 0; j < 5; ++j) {
                if (this.getEquipmentInSlot(j) == null) continue;
                ++equipmentCount;
            }
            if (equipmentCount > 0) {
                for (j = 0; j < 5; ++j) {
                    boolean dropGuaranteed;
                    ItemStack equipmentDrop = this.getEquipmentInSlot(j);
                    if (equipmentDrop == null) continue;
                    boolean bl = dropGuaranteed = this.equipmentDropChances[j] >= 1.0f;
                    if (!dropGuaranteed) {
                        int chance = 20 * equipmentCount - i * 4 * equipmentCount;
                        if (this.rand.nextInt(chance = Math.max(chance, 1)) != 0) continue;
                    }
                    if (!dropGuaranteed) {
                        int dropDamage = MathHelper.floor_double((double)((float)equipmentDrop.getItem().getMaxDamage() * (0.5f + this.rand.nextFloat() * 0.25f)));
                        equipmentDrop.setItemDamage(dropDamage);
                    }
                    this.entityDropItem(equipmentDrop, 0.0f);
                    this.setCurrentItemOrArmor(j, null);
                }
            }
        }
    }

    protected void dropChestContents(LOTRChestContents itemPool, int min, int max) {
        InventoryBasic drops = new InventoryBasic("drops", false, max * 5);
        LOTRChestContents.fillInventory((IInventory)drops, this.rand, itemPool, MathHelper.getRandomIntegerInRange((Random)this.rand, (int)min, (int)max), true);
        for (int i = 0; i < drops.getSizeInventory(); ++i) {
            ItemStack item = drops.getStackInSlot(i);
            if (item == null) continue;
            this.entityDropItem(item, 0.0f);
        }
    }

    protected void dropNPCArrows(int i) {
        this.dropNPCAmmo(Items.arrow, i);
    }

    protected void dropNPCCrossbowBolts(int i) {
        this.dropNPCAmmo(LOTRMod.crossbowBolt, i);
    }

    protected void dropNPCAmmo(Item item, int i) {
        int ammo = this.rand.nextInt(3) + this.rand.nextInt(i + 1);
        for (int l = 0; l < ammo; ++l) {
            this.dropItem(item, 1);
        }
    }

    public final void dropEquipment(boolean flag, int i) {
    }

    public final EntityItem entityDropItem(ItemStack item, float offset) {
        return this.npcDropItem(item, offset, true, true);
    }

    public final EntityItem npcDropItem(ItemStack item, float offset, boolean enpouch, boolean applyOwnership) {
        if (applyOwnership && item != null && item.getItem() != null && item.getMaxStackSize() == 1) {
            LOTRItemOwnership.addPreviousOwner(item, this.getCommandSenderName());
        }
        if (enpouch && this.enpouchNPCDrops && item != null) {
            this.enpouchedDrops.add(item);
            return null;
        }
        return super.entityDropItem(item, offset);
    }

    public void onDeath(DamageSource damagesource) {
        EntityPlayer entityplayer;
        LOTREntityInvasionSpawner invasion;
        this.enpouchNPCDrops = true;
        this.hiredNPCInfo.onDeath(damagesource);
        if (this.travellingTraderInfo != null) {
            this.travellingTraderInfo.onDeath();
        }
        if (this.bossInfo != null) {
            this.bossInfo.onDeath(damagesource);
        }
        super.onDeath(damagesource);
        if (!this.worldObj.isRemote && this.recentlyHit > 0 && this.canDropRares() && LOTRMod.canDropLoot(this.worldObj) && this.rand.nextInt(60) == 0) {
            ItemStack pouch = this.createNPCPouchDrop();
            this.fillPouchFromListAndRetainUnfilled(pouch, this.enpouchedDrops);
            this.enpouchNPCDrops = false;
            this.entityDropItem(pouch, 0.0f);
        }
        this.enpouchNPCDrops = false;
        this.dropItemList(this.enpouchedDrops, false);
        if (!this.worldObj.isRemote && damagesource.getEntity() instanceof EntityPlayer) {
            LOTREntityPebble pebble;
            float size;
            float alignment;
            entityplayer = (EntityPlayer)damagesource.getEntity();
            if (this.hurtOnlyByPlates && damagesource.getSourceOfDamage() instanceof LOTREntityPlate) {
                if (LOTRLevelData.getData(entityplayer).getAlignment(this.getFaction()) < 0.0f) {
                    // empty if block
                }
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.killUsingOnlyPlates);
            }
            if (damagesource.getSourceOfDamage() instanceof LOTREntityPebble && (pebble = (LOTREntityPebble)damagesource.getSourceOfDamage()).isSling() && (size = this.width * this.width * this.height) > 5.0f && (alignment = LOTRLevelData.getData(entityplayer).getAlignment(this.getFaction())) < 0.0f) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.killLargeMobWithSlingshot);
            }
            if (this instanceof LOTREntityOrc) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.killOrc);
            }
            if (this instanceof LOTREntityWarg) {
                LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.killWarg);
            }
            if (this.getKillAchievement() != null) {
                LOTRLevelData.getData(entityplayer).addAchievement(this.getKillAchievement());
            }
        }
        if (!this.worldObj.isRemote && (this instanceof LOTRTradeable || this instanceof LOTRUnitTradeable) && this.shouldTraderRespawn) {
            LOTREntityTraderRespawn entity = new LOTREntityTraderRespawn(this.worldObj);
            entity.setLocationAndAngles(this.posX, this.boundingBox.minY + (double)(this.height / 2.0f), this.posZ, 0.0f, 0.0f);
            entity.copyTraderDataFrom(this);
            this.worldObj.spawnEntityInWorld((Entity)entity);
            entity.onSpawn();
        }
        this.questInfo.onDeath();
        if (!this.worldObj.isRemote && this.isInvasionSpawned() && (entityplayer = LOTRMod.getDamagingPlayerIncludingUnits(damagesource)) != null && (invasion = LOTREntityInvasionSpawner.locateInvasionNearby((Entity)this, this.invasionID)) != null) {
            invasion.addPlayerKill(entityplayer);
            if (damagesource.getEntity() == entityplayer) {
                invasion.setWatchingInvasion((EntityPlayerMP)entityplayer, true);
            }
        }
    }

    public ItemStack createNPCPouchDrop() {
        LOTRFaction faction;
        ItemStack pouch = new ItemStack(LOTRMod.pouch, 1, LOTRItemPouch.getRandomPouchSize(this.rand));
        if (this.rand.nextBoolean() && (faction = this.getFaction()) != null) {
            LOTRItemPouch.setPouchColor(pouch, faction.getFactionColor());
        }
        return pouch;
    }

    public void fillPouchFromListAndRetainUnfilled(ItemStack pouch, List<ItemStack> items) {
        ArrayList<ItemStack> pouchContents = new ArrayList<ItemStack>();
        while (!items.isEmpty()) {
            pouchContents.add(items.remove(0));
            if (pouchContents.size() < LOTRItemPouch.getCapacity(pouch)) continue;
        }
        for (ItemStack itemstack : pouchContents) {
            if (LOTRItemPouch.tryAddItemToPouch(pouch, itemstack, false)) continue;
            items.add(itemstack);
        }
    }

    public void dropItemList(List<ItemStack> items) {
        this.dropItemList(items, true);
    }

    public void dropItemList(List<ItemStack> items, boolean applyOwnership) {
        if (!items.isEmpty()) {
            for (ItemStack item : items) {
                this.npcDropItem(item, 0.0f, true, applyOwnership);
            }
        }
    }

    protected LOTRAchievement getKillAchievement() {
        return null;
    }

    public void setDead() {
        super.setDead();
        if (this.deathTime == 0 && this.ridingEntity != null) {
            this.ridingEntity.setDead();
        }
    }

    public boolean canDropRares() {
        return !this.hiredNPCInfo.isActive;
    }

    public float getAlignmentBonus() {
        return 0.0f;
    }

    protected int getExperiencePoints(EntityPlayer entityplayer) {
        return 4 + this.rand.nextInt(3);
    }

    public float getBlockPathWeight(int i, int j, int k) {
        if (this.liftSpawnRestrictions) {
            return 1.0f;
        }
        if (!this.isConquestSpawning || !this.conquestSpawnIgnoresDarkness()) {
            BiomeGenBase biome;
            if (this.spawnsInDarkness && (biome = this.worldObj.getBiomeGenForCoords(i, k)) instanceof LOTRBiome && ((LOTRBiome)biome).canSpawnHostilesInDay()) {
                return 1.0f;
            }
            if (this.spawnsInDarkness) {
                return 0.5f - this.worldObj.getLightBrightness(i, j, k);
            }
        }
        return 0.0f;
    }

    private boolean isValidLightLevelForDarkSpawn() {
        BiomeGenBase biome;
        int i = MathHelper.floor_double((double)this.posX);
        int j = MathHelper.floor_double((double)this.boundingBox.minY);
        int k = MathHelper.floor_double((double)this.posZ);
        if (this.spawnsInDarkness && (biome = this.worldObj.getBiomeGenForCoords(i, k)) instanceof LOTRBiome && ((LOTRBiome)biome).canSpawnHostilesInDay()) {
            return true;
        }
        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32)) {
            return false;
        }
        int l = this.worldObj.getBlockLightValue(i, j, k);
        if (this.worldObj.isThundering()) {
            int i1 = this.worldObj.skylightSubtracted;
            this.worldObj.skylightSubtracted = 10;
            l = this.worldObj.getBlockLightValue(i, j, k);
            this.worldObj.skylightSubtracted = i1;
        }
        return l <= this.rand.nextInt(8);
    }

    public void setConquestSpawning(boolean flag) {
        this.isConquestSpawning = flag;
    }

    protected boolean conquestSpawnIgnoresDarkness() {
        return true;
    }

    public boolean getCanSpawnHere() {
        if ((!this.spawnsInDarkness || this.liftSpawnRestrictions || this.isConquestSpawning && this.conquestSpawnIgnoresDarkness() || this.isValidLightLevelForDarkSpawn()) && super.getCanSpawnHere()) {
            if (!this.liftBannerRestrictions) {
                if (LOTRBannerProtection.isProtected(this.worldObj, (Entity)this, LOTRBannerProtection.forNPC((EntityLiving)this), false)) {
                    return false;
                }
                if (!this.isConquestSpawning && LOTREntityNPCRespawner.isSpawnBlocked(this)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int getSpawnCountValue() {
        if (this.isNPCPersistent || this.shouldTraderRespawn || this.hiredNPCInfo.isActive) {
            return 0;
        }
        int multiplier = 1;
        BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double((double)this.posX), MathHelper.floor_double((double)this.posZ));
        if (biome instanceof LOTRBiome) {
            multiplier = ((LOTRBiome)biome).spawnCountMultiplier();
        }
        return multiplier;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (!this.worldObj.isRemote && this.canNPCTalk()) {
            if (this.questInfo.interact(entityplayer)) {
                return true;
            }
            if (this.getAttackTarget() == null && this.speakTo(entityplayer)) {
                return true;
            }
        }
        return super.interact(entityplayer);
    }

    public void sendSpeechBank(EntityPlayer entityplayer, String speechBank) {
        this.sendSpeechBank(entityplayer, speechBank, null);
    }

    public void sendSpeechBank(EntityPlayer entityplayer, String speechBank, LOTRMiniQuest miniquest) {
        String location = null;
        String objective = null;
        if (this.npcLocationName != null) {
            location = !this.hasSpecificLocationName ? StatCollector.translateToLocalFormatted((String)this.npcLocationName, (Object[])new Object[]{this.getNPCName()}) : this.npcLocationName;
        }
        if (miniquest != null) {
            objective = miniquest.getProgressedObjectiveInSpeech();
        }
        this.sendSpeechBank(entityplayer, speechBank, location, objective);
    }

    public void sendSpeechBank(EntityPlayer entityplayer, String speechBank, String location, String objective) {
        LOTRSpeech.sendSpeech(entityplayer, this, LOTRSpeech.getRandomSpeechForPlayer(this, speechBank, entityplayer, location, objective));
        this.markNPCSpoken();
    }

    public void sendSpeechBankLine(EntityPlayer entityplayer, String speechBank, int i) {
        LOTRSpeech.sendSpeech(entityplayer, this, LOTRSpeech.getSpeechLineForPlayer(this, speechBank, i, entityplayer, null, null));
        this.markNPCSpoken();
    }

    public boolean isFriendlyAndAligned(EntityPlayer entityplayer) {
        return LOTRLevelData.getData(entityplayer).getAlignment(this.getFaction()) >= 0.0f && this.isFriendly(entityplayer);
    }

    public boolean isFriendly(EntityPlayer entityplayer) {
        return this.getAttackTarget() != entityplayer && this.attackingPlayer != entityplayer;
    }

    public String getSpeechBank(EntityPlayer entityplayer) {
        return null;
    }

    public boolean speakTo(EntityPlayer entityplayer) {
        String speechBank = this.getSpeechBank(entityplayer);
        if (this.rand.nextInt(8) == 0) {
            if (LOTRMod.isChristmas()) {
                speechBank = "special/christmas";
            } else if (LOTRMod.isNewYearsDay()) {
                speechBank = "special/newYear";
            } else if (LOTRMod.isAprilFools()) {
                speechBank = "special/aprilFool";
            } else if (LOTRMod.isHalloween()) {
                speechBank = "special/halloween";
            }
        }
        if (this.rand.nextInt(10000) == 0) {
            speechBank = "special/smilebc";
        }
        if (speechBank != null) {
            this.sendSpeechBank(entityplayer, speechBank);
            if (this.getTalkAchievement() != null) {
                LOTRLevelData.getData(entityplayer).addAchievement(this.getTalkAchievement());
            }
            return true;
        }
        return false;
    }

    protected LOTRAchievement getTalkAchievement() {
        return null;
    }

    public LOTRMiniQuest createMiniQuest() {
        return null;
    }

    public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
        return null;
    }

    public int getMiniquestColor() {
        return this.getFaction().getFactionColor();
    }

    public void onArtificalSpawn() {
    }

    public boolean isDrunkard() {
        return this.familyInfo.isDrunk();
    }

    public boolean canGetDrunk() {
        if (this.isChild()) {
            return false;
        }
        return !this.isTrader() && !this.isTraderEscort && !this.hiredNPCInfo.isActive;
    }

    public float getDrunkenSpeechFactor() {
        if (this.rand.nextInt(3) == 0) {
            return MathHelper.randomFloatClamp((Random)this.rand, (float)0.0f, (float)0.3f);
        }
        return 0.0f;
    }

    public boolean shouldRenderNPCHair() {
        return true;
    }

    public boolean shouldRenderNPCChest() {
        return !this.familyInfo.isMale() && !this.isChild() && this.getEquipmentInSlot(3) == null;
    }

    public boolean canReEquipHired(int slot, ItemStack itemstack) {
        return true;
    }

    public void setSpecificLocationName(String name) {
        this.npcLocationName = name;
        this.hasSpecificLocationName = true;
    }

    public boolean getHasSpecificLocationName() {
        return this.hasSpecificLocationName;
    }

    public void setShouldTraderRespawn(boolean flag) {
        this.shouldTraderRespawn = flag;
    }

    public void setPersistentAndTraderShouldRespawn() {
        this.isNPCPersistent = true;
        this.setShouldTraderRespawn(true);
    }

    public boolean shouldTraderRespawn() {
        return this.shouldTraderRespawn;
    }

    private void updateNearbyBanners() {
        if (this.getFaction() == LOTRFaction.UNALIGNED || this instanceof LOTRBannerBearer) {
            this.nearbyBannerFactor = 0;
        } else {
            double range = 16.0;
            List bannerBearers = this.worldObj.selectEntitiesWithinAABB(LOTRBannerBearer.class, this.boundingBox.expand(range, range, range), new IEntitySelector(){

                public boolean isEntityApplicable(Entity entity) {
                    EntityLivingBase living = (EntityLivingBase)entity;
                    return living != LOTREntityNPC.this && living.isEntityAlive() && LOTRMod.getNPCFaction((Entity)living) == LOTREntityNPC.this.getFaction();
                }
            });
            this.nearbyBannerFactor = Math.min(bannerBearers.size(), 5);
        }
    }

    public final ItemStack getEquipmentInSlot(int i) {
        if (this.worldObj.isRemote) {
            if (!this.initFestiveItems) {
                this.festiveRand.setSeed((long)this.getEntityId() * 341873128712L);
                if (LOTRMod.isHalloween()) {
                    if (this.festiveRand.nextInt(3) == 0) {
                        this.festiveItems[4] = this.festiveRand.nextInt(10) == 0 ? new ItemStack(Blocks.lit_pumpkin) : new ItemStack(Blocks.pumpkin);
                    }
                } else if (LOTRMod.isChristmas() && this.festiveRand.nextInt(3) == 0) {
                    ItemStack hat;
                    if (this.rand.nextBoolean()) {
                        hat = new ItemStack(LOTRMod.leatherHat);
                        LOTRItemLeatherHat.setHatColor(hat, 13378587);
                        LOTRItemLeatherHat.setFeatherColor(hat, 16777215);
                        this.festiveItems[4] = hat;
                    } else {
                        hat = new ItemStack(LOTRMod.partyHat);
                        float hue = this.rand.nextFloat();
                        LOTRItemPartyHat.setHatColor(hat, Color.HSBtoRGB(hue, 1.0f, 1.0f));
                    }
                    this.festiveItems[4] = hat;
                }
                this.initFestiveItems = true;
            }
            if (this.festiveItems[i] != null) {
                return this.festiveItems[i];
            }
        }
        return super.getEquipmentInSlot(i);
    }

    public final ItemStack func_130225_q(int i) {
        return this.getEquipmentInSlot(i + 1);
    }

    public boolean allowLeashing() {
        return false;
    }

    public void setCustomNameTag(String name) {
        if (this.canRenameNPC() || this.loadingFromNBT) {
            super.setCustomNameTag(name);
        }
    }

    public boolean canRenameNPC() {
        return false;
    }

    public void func_110163_bv() {
    }

    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }

    public void spawnHearts() {
        if (!this.worldObj.isRemote) {
            LOTRPacketNPCFX packet = new LOTRPacketNPCFX(this.getEntityId(), LOTRPacketNPCFX.FXType.HEARTS);
            LOTRPacketHandler.networkWrapper.sendToAllAround((IMessage)packet, LOTRPacketHandler.nearEntity((Entity)this, 32.0));
        } else {
            for (int i = 0; i < 8; ++i) {
                double d = this.rand.nextGaussian() * 0.02;
                double d1 = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d1, d2);
            }
        }
    }

    public void spawnSmokes() {
        if (!this.worldObj.isRemote) {
            LOTRPacketNPCFX packet = new LOTRPacketNPCFX(this.getEntityId(), LOTRPacketNPCFX.FXType.SMOKE);
            LOTRPacketHandler.networkWrapper.sendToAllAround((IMessage)packet, LOTRPacketHandler.nearEntity((Entity)this, 32.0));
        } else {
            for (int i = 0; i < 8; ++i) {
                double d = this.rand.nextGaussian() * 0.02;
                double d1 = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle("smoke", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d1, d2);
            }
        }
    }

    public void spawnFoodParticles() {
        if (this.getHeldItem() == null) {
            return;
        }
        if (!this.worldObj.isRemote) {
            LOTRPacketNPCFX packet = new LOTRPacketNPCFX(this.getEntityId(), LOTRPacketNPCFX.FXType.EATING);
            LOTRPacketHandler.networkWrapper.sendToAllAround((IMessage)packet, LOTRPacketHandler.nearEntity((Entity)this, 32.0));
        } else {
            for (int i = 0; i < 5; ++i) {
                Vec3 vec1 = Vec3.createVectorHelper((double)(((double)this.rand.nextFloat() - 0.5) * 0.1), (double)(Math.random() * 0.1 + 0.1), (double)0.0);
                vec1.rotateAroundX(-this.rotationPitch * 3.1415927f / 180.0f);
                vec1.rotateAroundY(-this.rotationYaw * 3.1415927f / 180.0f);
                Vec3 vec2 = Vec3.createVectorHelper((double)(((double)this.rand.nextFloat() - 0.5) * 0.3), (double)((double)(-this.rand.nextFloat()) * 0.6 - 0.3), (double)0.6);
                vec2.rotateAroundX(-this.rotationPitch * 3.1415927f / 180.0f);
                vec2.rotateAroundY(-this.rotationYaw * 3.1415927f / 180.0f);
                vec2 = vec2.addVector(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
                this.worldObj.spawnParticle("iconcrack_" + Item.getIdFromItem((Item)this.getHeldItem().getItem()), vec2.xCoord, vec2.yCoord, vec2.zCoord, vec1.xCoord, vec1.yCoord + 0.05, vec1.zCoord);
            }
        }
    }

    public ItemStack getHeldItemLeft() {
        if (this instanceof LOTRBannerBearer) {
            LOTRBannerBearer bannerBearer = (LOTRBannerBearer)((Object)this);
            return new ItemStack(LOTRMod.banner, 1, bannerBearer.getBannerType().bannerID);
        }
        if (this.isTrader()) {
            boolean showCoin = false;
            if (this.npcShield == null) {
                showCoin = true;
            } else if (!this.clientCombatStance && this.hiredNPCInfo.getHiringPlayerUUID() == null) {
                showCoin = true;
            }
            if (showCoin) {
                return new ItemStack(LOTRMod.silverCoin);
            }
        }
        return null;
    }

    public void playTradeSound() {
        this.playSound("lotr:event.trade", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f);
    }

    public boolean isInvasionSpawned() {
        return this.getInvasionID() != null;
    }

    public UUID getInvasionID() {
        return this.invasionID;
    }

    public void setInvasionID(UUID id) {
        this.invasionID = id;
    }

    protected static enum AttackMode {
        MELEE,
        RANGED,
        IDLE;

    }

}

