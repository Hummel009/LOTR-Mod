package lotr.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import lotr.client.fx.LOTREntityDeadMarshFace;
import lotr.client.gui.LOTRGuiMap;
import lotr.client.gui.LOTRGuiMenu;
import lotr.client.gui.LOTRGuiMessage;
import lotr.client.gui.LOTRGuiMiniquestTracker;
import lotr.client.gui.LOTRGuiNotificationDisplay;
import lotr.client.model.LOTRModelCompass;
import lotr.client.render.LOTRCloudRenderer;
import lotr.client.render.LOTRRenderNorthernLights;
import lotr.client.render.entity.LOTRNPCRendering;
import lotr.client.render.tileentity.LOTRTileEntityMobSpawnerRenderer;
import lotr.client.sound.LOTRAmbience;
import lotr.client.sound.LOTRMusicTicker;
import lotr.client.sound.LOTRMusicTrack;
import lotr.common.LOTRConfig;
import lotr.common.LOTRDate;
import lotr.common.LOTRDimension;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.LOTRPlayerData;
import lotr.common.LOTRSquadrons;
import lotr.common.LOTRTime;
import lotr.common.block.LOTRBlockLeavesBase;
import lotr.common.enchant.LOTREnchantment;
import lotr.common.enchant.LOTREnchantmentHelper;
import lotr.common.entity.LOTRInvasionStatus;
import lotr.common.entity.LOTRMountFunctions;
import lotr.common.entity.item.LOTREntityPortal;
import lotr.common.entity.npc.LOTREntityBalrog;
import lotr.common.entity.npc.LOTREntityBarrowWight;
import lotr.common.entity.npc.LOTREntityScrapTrader;
import lotr.common.entity.npc.LOTREntitySpiderBase;
import lotr.common.fac.LOTRAlignmentValues;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionBounties;
import lotr.common.fac.LOTRFactionRank;
import lotr.common.fac.LOTRFactionRelations;
import lotr.common.fellowship.LOTRFellowshipData;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBlowgun;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemOwnership;
import lotr.common.item.LOTRItemSpear;
import lotr.common.item.LOTRPoisonedDrinks;
import lotr.common.item.LOTRWeaponStats;
import lotr.common.quest.IPickpocketable;
import lotr.common.util.LOTRColorUtil;
import lotr.common.util.LOTRFunctions;
import lotr.common.util.LOTRLog;
import lotr.common.world.LOTRWorldChunkManager;
import lotr.common.world.LOTRWorldProvider;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenBarrowDowns;
import lotr.common.world.biome.LOTRBiomeGenDeadMarshes;
import lotr.common.world.biome.LOTRBiomeGenMirkwoodCorrupted;
import lotr.common.world.biome.LOTRBiomeGenMistyMountains;
import lotr.common.world.biome.LOTRBiomeGenMorgulVale;
import lotr.common.world.biome.LOTRBiomeGenUtumno;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.map.LOTRConquestGrid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.WorldEvent;

public class LOTRTickHandlerClient {
    private static final ResourceLocation portalOverlay = new ResourceLocation("lotr:misc/portal_overlay.png");
    private static final ResourceLocation elvenPortalOverlay = new ResourceLocation("lotr:misc/elvenportal_overlay.png");
    private static final ResourceLocation morgulPortalOverlay = new ResourceLocation("lotr:misc/morgulportal_overlay.png");
    private static final ResourceLocation mistOverlay = new ResourceLocation("lotr:misc/mist_overlay.png");
    private static final ResourceLocation frostOverlay = new ResourceLocation("lotr:misc/frost_overlay.png");
    private static final float[] frostRGBMiddle = new float[]{0.4f, 0.46f, 0.74f};
    private static final float[] frostRGBEdge = new float[]{1.0f, 1.0f, 1.0f};
    private static final ResourceLocation burnOverlay = new ResourceLocation("lotr:misc/burn_overlay.png");
    private static final ResourceLocation wightOverlay = new ResourceLocation("lotr:misc/wight.png");
    public static HashMap playersInPortals = new HashMap();
    public static HashMap playersInElvenPortals = new HashMap();
    public static HashMap playersInMorgulPortals = new HashMap();
    private LOTRAmbience ambienceTicker;
    public static int clientTick;
    public static float renderTick;
    private GuiScreen lastGuiOpen;
    private int mistTick;
    private int prevMistTick;
    private float mistFactor;
    private float sunGlare;
    private float prevSunGlare;
    private float rainFactor;
    private float prevRainFactor;
    private int alignmentXBase;
    private int alignmentYBase;
    private int alignmentXCurrent;
    private int alignmentYCurrent;
    private int alignmentXPrev;
    private int alignmentYPrev;
    private boolean firstAlignmentRender = true;
    public static int alignDrainTick;
    public static final int alignDrainTickMax = 200;
    public static int alignDrainNum;
    public static LOTRInvasionStatus watchedInvasion;
    public static LOTRGuiNotificationDisplay notificationDisplay;
    public static LOTRGuiMiniquestTracker miniquestTracker;
    private boolean wasHoldingBannerWithExistingProtection;
    private int bannerRepossessDisplayTick;
    private int frostTick;
    private int burnTick;
    private int drunkennessDirection = 1;
    private int newDate = 0;
    private float utumnoCamRoll = 0.0f;
    public boolean inUtumnoReturnPortal = false;
    public int utumnoReturnX;
    public int utumnoReturnZ;
    private double lastUtumnoReturnY = -1.0;
    private int prevWightLookTick = 0;
    private int wightLookTick = 0;
    public static boolean anyWightsViewed;
    private int prevWightNearTick = 0;
    private int wightNearTick = 0;
    private int prevBalrogNearTick = 0;
    private int balrogNearTick = 0;
    private float balrogFactor;
    public static int scrapTraderMisbehaveTick;
    private float[] storedLightTable;
    private int storedScrapID;
    private boolean addedClientPoisonEffect = false;
    private LOTRMusicTrack lastTrack = null;
    private int musicTrackTick = 0;
    public boolean cancelItemHighlight = false;
    private ItemStack lastHighlightedItemstack;
    private String highlightedItemstackName;

    public LOTRTickHandlerClient() {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        this.ambienceTicker = new LOTRAmbience();
        notificationDisplay = new LOTRGuiNotificationDisplay();
        miniquestTracker = new LOTRGuiMiniquestTracker();
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        block74: {
            GuiScreen guiscreen;
            Minecraft minecraft;
            block75: {
                EntityClientPlayerMP entityplayer;
                int i;
                WorldClient world;
                block76: {
                    block77: {
                        minecraft = Minecraft.getMinecraft();
                        entityplayer = minecraft.thePlayer;
                        world = minecraft.theWorld;
                        if (event.phase == TickEvent.Phase.START) {
                            ++clientTick;
                            if (LOTRConfig.fixRenderDistance && !FMLClientHandler.instance().hasOptifine()) {
                                GameSettings gs = Minecraft.getMinecraft().gameSettings;
                                int renderDistance = gs.renderDistanceChunks;
                                if (renderDistance > 16) {
                                    gs.renderDistanceChunks = renderDistance = 16;
                                    gs.saveOptions();
                                    LOTRLog.logger.info("LOTR: Render distance was above 16 - set to 16 to prevent a vanilla crash");
                                }
                            }
                            if (minecraft.entityRenderer != null && !(minecraft.entityRenderer instanceof LOTREntityRenderer)) {
                                minecraft.entityRenderer = new LOTREntityRenderer(minecraft, minecraft.getResourceManager());
                                ((IReloadableResourceManager)minecraft.getResourceManager()).registerReloadListener(minecraft.entityRenderer);
                                FMLLog.info("LOTR: Successfully replaced entityrenderer");
                            }
                        }
                        if (event.phase != TickEvent.Phase.END) break block74;
                        LOTRTileEntityMobSpawnerRenderer.onClientTick();
                        if (minecraft.currentScreen == null) {
                            this.lastGuiOpen = null;
                        }
                        if (FMLClientHandler.instance().hasOptifine()) {
                            int optifineSetting = 0;
                            try {
                                Object field = GameSettings.class.getField("ofTrees").get(minecraft.gameSettings);
                                if (field instanceof Integer) {
                                    optifineSetting = (Integer)field;
                                }
                            }
                            catch (Exception field) {
                                // empty catch block
                            }
                            boolean fancyGraphics = optifineSetting == 0 ? minecraft.gameSettings.fancyGraphics : (optifineSetting == 1 ? false : optifineSetting == 2);
                            LOTRBlockLeavesBase.setAllGraphicsLevels(fancyGraphics);
                        } else {
                            LOTRBlockLeavesBase.setAllGraphicsLevels(minecraft.gameSettings.fancyGraphics);
                        }
                        if (entityplayer == null || world == null) break block75;
                        if (LOTRConfig.checkUpdates) {
                        }
                        if (this.isGamePaused(minecraft)) break block76;
                        miniquestTracker.update(minecraft, entityplayer);
                        LOTRAlignmentTicker.updateAll(entityplayer, false);
                        if (alignDrainTick > 0 && --alignDrainTick <= 0) {
                            alignDrainNum = 0;
                        }
                        watchedInvasion.tick();
                        boolean isHoldingBannerWithExistingProtection = LOTRItemBanner.isHoldingBannerWithExistingProtection(entityplayer);
                        this.bannerRepossessDisplayTick = isHoldingBannerWithExistingProtection && !this.wasHoldingBannerWithExistingProtection ? 60 : --this.bannerRepossessDisplayTick;
                        this.wasHoldingBannerWithExistingProtection = isHoldingBannerWithExistingProtection;
                        EntityLivingBase viewer = minecraft.renderViewEntity;
                        i = MathHelper.floor_double(viewer.posX);
                        int j = MathHelper.floor_double(viewer.boundingBox.minY);
                        int k = MathHelper.floor_double(viewer.posZ);
                        BiomeGenBase biome = world.getBiomeGenForCoords(i, k);
                        LOTRBiome.updateWaterColor(i, j, k);
                        LOTRBiomeGenUtumno.updateFogColor(i, j, k);
                        LOTRCloudRenderer.updateClouds(world);
                        if (LOTRConfig.aurora) {
                            LOTRRenderNorthernLights.update(viewer);
                        }
                        LOTRSpeechClient.update();
                        LOTRKeyHandler.update();
                        LOTRAttackTiming.update();
                        this.prevMistTick = this.mistTick;
                        if (viewer.posY >= 72.0 && biome instanceof LOTRBiomeGenMistyMountains && biome != LOTRBiome.mistyMountainsFoothills && world.canBlockSeeTheSky(i, j, k) && world.getSavedLightValue(EnumSkyBlock.Block, i, j, k) < 7) {
                            if (this.mistTick < 80) {
                                ++this.mistTick;
                            }
                        } else if (this.mistTick > 0) {
                            --this.mistTick;
                        }
                        if (this.frostTick > 0) {
                            --this.frostTick;
                        }
                        if (this.burnTick > 0) {
                            --this.burnTick;
                        }
                        this.prevWightLookTick = this.wightLookTick;
                        if (anyWightsViewed) {
                            if (this.wightLookTick < 100) {
                                ++this.wightLookTick;
                            }
                        } else if (this.wightLookTick > 0) {
                            --this.wightLookTick;
                        }
                        this.prevWightNearTick = this.wightNearTick;
                        double wightRange = 32.0;
                        List nearbyWights = world.getEntitiesWithinAABB(LOTREntityBarrowWight.class, viewer.boundingBox.expand(wightRange, wightRange, wightRange));
                        if (!nearbyWights.isEmpty()) {
                            if (this.wightNearTick < 100) {
                                ++this.wightNearTick;
                            }
                        } else if (this.wightNearTick > 0) {
                            --this.wightNearTick;
                        }
                        this.prevBalrogNearTick = this.balrogNearTick;
                        double balrogRange = 24.0;
                        List nearbyBalrogs = world.getEntitiesWithinAABB(LOTREntityBalrog.class, viewer.boundingBox.expand(balrogRange, balrogRange, balrogRange));
                        if (!nearbyBalrogs.isEmpty()) {
                            if (this.balrogNearTick < 100) {
                                ++this.balrogNearTick;
                            }
                        } else if (this.balrogNearTick > 0) {
                            --this.balrogNearTick;
                        }
                        if (LOTRConfig.enableSunFlare && world.provider instanceof LOTRWorldProvider && !world.provider.hasNoSky) {
                            this.prevSunGlare = this.sunGlare;
                            MovingObjectPosition look = viewer.rayTrace(10000.0, renderTick);
                            boolean lookingAtSky = look == null || look.typeOfHit == MovingObjectPosition.MovingObjectType.MISS;
                            boolean biomeHasSun = true;
                            if (biome instanceof LOTRBiome) {
                                biomeHasSun = ((LOTRBiome)biome).hasSky();
                            }
                            float sunPitch = world.getCelestialAngle(renderTick) * 360.0f - 90.0f;
                            float sunYaw = 90.0f;
                            float yc = MathHelper.cos(((float)Math.toRadians(-sunYaw - 180.0f)));
                            float ys = MathHelper.sin(((float)Math.toRadians(-sunYaw - 180.0f)));
                            float pc = -MathHelper.cos(((float)Math.toRadians(-sunPitch)));
                            float ps = MathHelper.sin(((float)Math.toRadians(-sunPitch)));
                            Vec3 sunVec = Vec3.createVectorHelper(ys * pc, ps, yc * pc);
                            Vec3 lookVec = viewer.getLook(renderTick);
                            double cos = lookVec.dotProduct(sunVec) / (lookVec.lengthVector() * sunVec.lengthVector());
                            float cosThreshold = 0.95f;
                            float cQ = ((float)cos - cosThreshold) / (1.0f - cosThreshold);
                            cQ = Math.max(cQ, 0.0f);
                            float brightness = world.getSunBrightness(renderTick);
                            float brightnessThreshold = 0.7f;
                            float bQ = (brightness - brightnessThreshold) / (1.0f - brightnessThreshold);
                            float maxGlare = cQ * (bQ = Math.max(bQ, 0.0f));
                            if (maxGlare > 0.0f && lookingAtSky && !world.isRaining() && biomeHasSun) {
                                if (this.sunGlare < maxGlare) {
                                    this.sunGlare += 0.1f * maxGlare;
                                    this.sunGlare = Math.min(this.sunGlare, maxGlare);
                                } else if (this.sunGlare > maxGlare) {
                                    this.sunGlare -= 0.02f;
                                    this.sunGlare = Math.max(this.sunGlare, maxGlare);
                                }
                            } else {
                                if (this.sunGlare > 0.0f) {
                                    this.sunGlare -= 0.02f;
                                }
                                this.sunGlare = Math.max(this.sunGlare, 0.0f);
                            }
                        } else {
                            this.sunGlare = 0.0f;
                            this.prevSunGlare = 0.0f;
                        }
                        if (LOTRConfig.newWeather) {
                            this.prevRainFactor = this.rainFactor;
                            if (world.isRaining()) {
                                if (this.rainFactor < 1.0f) {
                                    this.rainFactor += 0.008333334f;
                                    this.rainFactor = Math.min(this.rainFactor, 1.0f);
                                }
                            } else if (this.rainFactor > 0.0f) {
                                this.rainFactor -= 0.0016666667f;
                                this.rainFactor = Math.max(this.rainFactor, 0.0f);
                            }
                        } else {
                            this.rainFactor = 0.0f;
                            this.prevRainFactor = 0.0f;
                        }
                        if (minecraft.gameSettings.particleSetting < 2) {
                            this.spawnEnvironmentFX(entityplayer, world);
                        }
                        LOTRClientProxy.customEffectRenderer.updateEffects();
                        if (minecraft.renderViewEntity.isPotionActive(Potion.confusion.id)) {
                            float drunkenness = minecraft.renderViewEntity.getActivePotionEffect(Potion.confusion).getDuration();
                            if ((drunkenness /= 20.0f) > 100.0f) {
                                drunkenness = 100.0f;
                            }
                            minecraft.renderViewEntity.rotationYaw += this.drunkennessDirection * drunkenness / 20.0f;
                            minecraft.renderViewEntity.rotationPitch += MathHelper.cos(minecraft.renderViewEntity.ticksExisted / 10.0f) * drunkenness / 20.0f;
                            if (world.rand.nextInt(100) == 0) {
                                this.drunkennessDirection *= -1;
                            }
                        }
                        if (LOTRDimension.getCurrentDimension(world) == LOTRDimension.UTUMNO) {
                            if (this.inUtumnoReturnPortal) {
                                if (this.utumnoCamRoll < 180.0f) {
                                    this.utumnoCamRoll += 5.0f;
                                    this.utumnoCamRoll = Math.min(this.utumnoCamRoll, 180.0f);
                                    LOTRReflectionClient.setCameraRoll(minecraft.entityRenderer, this.utumnoCamRoll);
                                }
                            } else if (this.utumnoCamRoll > 0.0f) {
                                this.utumnoCamRoll -= 5.0f;
                                this.utumnoCamRoll = Math.max(this.utumnoCamRoll, 0.0f);
                                LOTRReflectionClient.setCameraRoll(minecraft.entityRenderer, this.utumnoCamRoll);
                            }
                        } else if (this.utumnoCamRoll != 0.0f) {
                            this.utumnoCamRoll = 0.0f;
                            LOTRReflectionClient.setCameraRoll(minecraft.entityRenderer, this.utumnoCamRoll);
                        }
                        if (this.newDate > 0) {
                            --this.newDate;
                        }
                        this.ambienceTicker.updateAmbience(world, entityplayer);
                        if (scrapTraderMisbehaveTick <= 0) break block77;
                        if (--scrapTraderMisbehaveTick > 0) break block76;
                        world.provider.lightBrightnessTable = Arrays.copyOf(this.storedLightTable, this.storedLightTable.length);
                        Entity scrap = world.getEntityByID(this.storedScrapID);
                        if (scrap == null) break block76;
                        scrap.ignoreFrustumCheck = false;
                        break block76;
                    }
                    MovingObjectPosition target = minecraft.objectMouseOver;
                    if (target != null && target.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && target.entityHit instanceof LOTREntityScrapTrader) {
                        LOTREntityScrapTrader scrap = (LOTREntityScrapTrader)target.entityHit;
                        if (minecraft.currentScreen == null && world.rand.nextInt(50000) == 0) {
                            scrapTraderMisbehaveTick = 400;
                            scrap.ignoreFrustumCheck = true;
                            this.storedScrapID = scrap.getEntityId();
                            float[] lightTable = world.provider.lightBrightnessTable;
                            this.storedLightTable = Arrays.copyOf(lightTable, lightTable.length);
                            Arrays.fill(lightTable, 1.0E-7f);
                        }
                    }
                }
                if ((entityplayer.dimension == 0 || entityplayer.dimension == LOTRDimension.MIDDLE_EARTH.dimensionID) && playersInPortals.containsKey(entityplayer)) {
                    List portals = world.getEntitiesWithinAABB(LOTREntityPortal.class, entityplayer.boundingBox.expand(8.0, 8.0, 8.0));
                    boolean inPortal = false;
                    for (i = 0; i < portals.size(); ++i) {
                        LOTREntityPortal portal = (LOTREntityPortal)(portals.get(i));
                        if (!portal.boundingBox.intersectsWith(entityplayer.boundingBox)) continue;
                        inPortal = true;
                        break;
                    }
                    if (inPortal) {
                        i = (Integer)playersInPortals.get(entityplayer);
                        playersInPortals.put(entityplayer, ++i);
                        if (i >= 100) {
                            minecraft.getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("portal.trigger"), world.rand.nextFloat() * 0.4f + 0.8f));
                            playersInPortals.remove(entityplayer);
                        }
                    } else {
                        playersInPortals.remove(entityplayer);
                    }
                }
                this.updatePlayerInPortal(entityplayer, playersInElvenPortals, LOTRMod.elvenPortal);
                this.updatePlayerInPortal(entityplayer, playersInMorgulPortals, LOTRMod.morgulPortal);
                if (this.inUtumnoReturnPortal) {
                    entityplayer.setPosition(this.utumnoReturnX + 0.5, entityplayer.posY, this.utumnoReturnZ + 0.5);
                    if (this.lastUtumnoReturnY >= 0.0 && entityplayer.posY < this.lastUtumnoReturnY) {
                        entityplayer.setPosition(entityplayer.posX, this.lastUtumnoReturnY, entityplayer.posZ);
                    }
                    this.lastUtumnoReturnY = entityplayer.posY;
                } else {
                    this.lastUtumnoReturnY = -1.0;
                }
                this.inUtumnoReturnPortal = false;
            }
            LOTRClientProxy.musicHandler.update();
            if (LOTRConfig.displayMusicTrack) {
                LOTRMusicTrack nowPlaying = LOTRMusicTicker.currentTrack;
                if (nowPlaying != this.lastTrack) {
                    this.lastTrack = nowPlaying;
                    this.musicTrackTick = 200;
                }
                if (this.lastTrack != null && this.musicTrackTick > 0) {
                    --this.musicTrackTick;
                }
            }
            if ((guiscreen = minecraft.currentScreen) != null) {
                if (guiscreen instanceof GuiMainMenu && !(this.lastGuiOpen instanceof GuiMainMenu)) {
                    LOTRLevelData.needsLoad = true;
                    LOTRTime.needsLoad = true;
                    LOTRFellowshipData.needsLoad = true;
                    LOTRFactionBounties.needsLoad = true;
                    LOTRFactionRelations.needsLoad = true;
                    LOTRDate.resetWorldTimeInMenu();
                    LOTRConquestGrid.needsLoad = true;
                    LOTRSpeechClient.clearAll();
                    LOTRAttackTiming.reset();
                    LOTRGuiMenu.resetLastMenuScreen();
                    LOTRGuiMap.clearPlayerLocations();
                    LOTRCloudRenderer.resetClouds();
                    this.firstAlignmentRender = true;
                    watchedInvasion.clear();
                }
                this.lastGuiOpen = guiscreen;
            }
            anyWightsViewed = false;
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityClientPlayerMP clientPlayer;
        EntityPlayer player = event.player;
        if (event.phase == TickEvent.Phase.END && player instanceof EntityClientPlayerMP && (clientPlayer = (EntityClientPlayerMP)player).isRiding()) {
            LOTRMountFunctions.sendControlToServer(clientPlayer);
        }
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        Minecraft minecraft = Minecraft.getMinecraft();
        EntityClientPlayerMP entityplayer = minecraft.thePlayer;
        WorldClient world = minecraft.theWorld;
        if (event.phase == TickEvent.Phase.START) {
            GuiIngame guiIngame;
            renderTick = event.renderTickTime;
            if (this.cancelItemHighlight && (LOTRReflectionClient.getHighlightedItemTicks(guiIngame = minecraft.ingameGUI)) > 0) {
                LOTRReflectionClient.setHighlightedItemTicks(guiIngame, 0);
                this.cancelItemHighlight = false;
            }
        }
        if (event.phase == TickEvent.Phase.END) {
            if (entityplayer != null && world != null) {
                ScaledResolution resolution;
                if ((world.provider instanceof LOTRWorldProvider || LOTRConfig.alwaysShowAlignment) && Minecraft.isGuiEnabled()) {
                    this.alignmentXPrev = this.alignmentXCurrent;
                    this.alignmentYPrev = this.alignmentYCurrent;
                    this.alignmentXCurrent = this.alignmentXBase;
                    int yMove = (int)((this.alignmentYBase - -20) / 10.0f);
                    boolean alignmentOnscreen = (minecraft.currentScreen == null || minecraft.currentScreen instanceof LOTRGuiMessage) && !minecraft.gameSettings.keyBindPlayerList.getIsKeyPressed() && !minecraft.gameSettings.showDebugInfo;
                    this.alignmentYCurrent = alignmentOnscreen ? Math.min(this.alignmentYCurrent + yMove, this.alignmentYBase) : Math.max(this.alignmentYCurrent - yMove, -20);
                    this.renderAlignment(minecraft, renderTick);
                    if (LOTRConfig.enableOnscreenCompass && minecraft.currentScreen == null && !minecraft.gameSettings.showDebugInfo) {
                        GL11.glPushMatrix();
                        resolution = new ScaledResolution(minecraft, minecraft.displayWidth, minecraft.displayHeight);
                        int i = resolution.getScaledWidth();
                        resolution.getScaledHeight();
                        int compassX = i - 60;
                        int compassY = 40;
                        GL11.glTranslatef(compassX, compassY, 0.0f);
                        float rotation = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * event.renderTickTime;
                        rotation = 180.0f - rotation;
                        LOTRModelCompass.compassModel.render(1.0f, rotation);
                        GL11.glPopMatrix();
                        if (LOTRConfig.compassExtraInfo) {
                            BiomeGenBase biome;
                            GL11.glPushMatrix();
                            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                            float scale = 0.5f;
                            float invScale = 1.0f / scale;
                            compassX = (int)(compassX * invScale);
                            compassY = (int)(compassY * invScale);
                            GL11.glScalef(scale, scale, scale);
                            String coords = MathHelper.floor_double(entityplayer.posX) + ", " + MathHelper.floor_double(entityplayer.boundingBox.minY) + ", " + MathHelper.floor_double(entityplayer.posZ);
                            FontRenderer fontRenderer = minecraft.fontRenderer;
                            fontRenderer.drawString(coords, compassX - fontRenderer.getStringWidth(coords) / 2, compassY + 70, 16777215);
                            int playerX = MathHelper.floor_double(entityplayer.posX);
                            int playerZ = MathHelper.floor_double(entityplayer.posZ);
                            if (LOTRClientProxy.doesClientChunkExist(world, playerX, playerZ) && (biome = world.getBiomeGenForCoords(playerX, playerZ)) instanceof LOTRBiome) {
                                String biomeName = ((LOTRBiome)biome).getBiomeDisplayName();
                                fontRenderer.drawString(biomeName, compassX - fontRenderer.getStringWidth(biomeName) / 2, compassY - 70, 16777215);
                            }
                            GL11.glPopMatrix();
                        }
                    }
                }
                if (entityplayer.dimension == LOTRDimension.MIDDLE_EARTH.dimensionID && minecraft.currentScreen == null && this.newDate > 0) {
                    int halfMaxDate = 100;
                    float alpha;
                    alpha = this.newDate > halfMaxDate ? (float)(200 - this.newDate) / (float)halfMaxDate : (float)this.newDate / (float)halfMaxDate;
                    String date = LOTRDate.ShireReckoning.getShireDate().getDateName(true);
                    ScaledResolution resolution2 = new ScaledResolution(minecraft, minecraft.displayWidth, minecraft.displayHeight);
                    int i = resolution2.getScaledWidth();
                    int j = resolution2.getScaledHeight();
                    float scale = 1.5f;
                    float invScale = 1.0f / scale;
                    i = (int)(i * invScale);
                    j = (int)(j * invScale);
                    int x = (i - minecraft.fontRenderer.getStringWidth(date)) / 2;
                    int y = (j - minecraft.fontRenderer.FONT_HEIGHT) * 2 / 5;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glEnable(3042);
                    OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                    minecraft.fontRenderer.drawString(date, x, y, 16777215 + (LOTRClientProxy.getAlphaInt(alpha) << 24));
                    GL11.glDisable(3042);
                    GL11.glScalef(invScale, invScale, invScale);
                }
                if (LOTRConfig.displayMusicTrack && minecraft.currentScreen == null && this.lastTrack != null && this.musicTrackTick > 0) {
                    ArrayList<String> lines = new ArrayList<>();
                    lines.add(StatCollector.translateToLocal("lotr.music.nowPlaying"));
                    String title = this.lastTrack.getTitle();
                    lines.add(title);
                    if (!this.lastTrack.getAuthors().isEmpty()) {
                        String authors = "(";
                        int a = 0;
                        for (String auth : this.lastTrack.getAuthors()) {
                            authors = authors + auth;
                            if (a < this.lastTrack.getAuthors().size() - 1) {
                                authors = authors + ", ";
                            }
                            ++a;
                        }
                        authors = authors + ")";
                        lines.add(authors);
                    }
                    resolution = new ScaledResolution(minecraft, minecraft.displayWidth, minecraft.displayHeight);
                    int w = resolution.getScaledWidth();
                    int h = resolution.getScaledHeight();
                    int border = 20;
                    int x = w - border;
                    int y = h - border - lines.size() * minecraft.fontRenderer.FONT_HEIGHT;
                    float alpha = 1.0f;
                    if (this.musicTrackTick >= 140) {
                        alpha = (200 - this.musicTrackTick) / 60.0f;
                    } else if (this.musicTrackTick <= 60) {
                        alpha = this.musicTrackTick / 60.0f;
                    }
                    for (String line : lines) {
                        x = w - border - minecraft.fontRenderer.getStringWidth(line);
                        minecraft.fontRenderer.drawString(line, x, y, 16777215 + (LOTRClientProxy.getAlphaInt(alpha) << 24));
                        y += minecraft.fontRenderer.FONT_HEIGHT;
                    }
                }
            }
            notificationDisplay.updateWindow();
            if (LOTRConfig.enableQuestTracker && minecraft.currentScreen == null && !minecraft.gameSettings.showDebugInfo) {
                miniquestTracker.drawTracker(minecraft, entityplayer);
            }
        }
    }

    private void updatePlayerInPortal(EntityPlayer entityplayer, HashMap players, Block portalBlock) {
        if ((entityplayer.dimension == 0 || entityplayer.dimension == LOTRDimension.MIDDLE_EARTH.dimensionID) && players.containsKey(entityplayer)) {
            boolean inPortal;
            inPortal = entityplayer.worldObj.getBlock(MathHelper.floor_double(entityplayer.posX), MathHelper.floor_double(entityplayer.boundingBox.minY), MathHelper.floor_double(entityplayer.posZ)) == portalBlock;
            if (inPortal) {
                int i = (Integer)players.get(entityplayer);
                players.put(entityplayer, ++i);
                if (i >= entityplayer.getMaxInPortalTime()) {
                    Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("portal.trigger"), entityplayer.worldObj.rand.nextFloat() * 0.4f + 0.8f));
                    players.remove(entityplayer);
                }
            } else {
                players.remove(entityplayer);
            }
        }
    }

    private void spawnEnvironmentFX(EntityPlayer entityplayer, World world) {
        world.theProfiler.startSection("lotrEnvironmentFX");
        int i = MathHelper.floor_double(entityplayer.posX);
        int j = MathHelper.floor_double(entityplayer.boundingBox.minY);
        int k = MathHelper.floor_double(entityplayer.posZ);
        int range = 16;
        for (int l = 0; l < 1000; ++l) {
            int i1 = i + world.rand.nextInt(range) - world.rand.nextInt(range);
            int j1 = j + world.rand.nextInt(range) - world.rand.nextInt(range);
            int k1 = k + world.rand.nextInt(range) - world.rand.nextInt(range);
            Block block = world.getBlock(i1, j1, k1);
            int meta = world.getBlockMetadata(i1, j1, k1);
            if (block.getMaterial() == Material.water) {
                BiomeGenBase biome = world.getBiomeGenForCoords(i1, k1);
                if (biome instanceof LOTRBiomeGenMirkwoodCorrupted && world.rand.nextInt(20) == 0) {
                    LOTRMod.proxy.spawnParticle("mirkwoodWater", i1 + world.rand.nextFloat(), j1 + 0.75, k1 + world.rand.nextFloat(), 0.0, 0.05, 0.0);
                }
                if (biome instanceof LOTRBiomeGenMorgulVale && world.rand.nextInt(40) == 0) {
                    LOTRMod.proxy.spawnParticle("morgulWater", i1 + world.rand.nextFloat(), j1 + 0.75, k1 + world.rand.nextFloat(), 0.0, 0.05, 0.0);
                }
                if (biome instanceof LOTRBiomeGenDeadMarshes && world.rand.nextInt(800) == 0) {
                    world.spawnEntityInWorld(new LOTREntityDeadMarshFace(world, i1 + world.rand.nextFloat(), j1 + 0.25 - world.rand.nextFloat(), k1 + world.rand.nextFloat()));
                }
            }
            if (block.getMaterial() != Material.water || meta == 0 || (world.getBlock(i1, j1 - 1, k1)).getMaterial() != Material.water) continue;
            for (int i2 = i1 - 1; i2 <= i1 + 1; ++i2) {
                for (int k2 = k1 - 1; k2 <= k1 + 1; ++k2) {
                    Block adjBlock = world.getBlock(i2, j1 - 1, k2);
                    int adjMeta = world.getBlockMetadata(i2, j1 - 1, k2);
                    if (adjBlock.getMaterial() != Material.water || adjMeta != 0 || !world.isAirBlock(i2, j1, k2)) continue;
                    for (int l1 = 0; l1 < 2; ++l1) {
                        double d = i1 + 0.5 + (i2 - i1) * world.rand.nextFloat();
                        double d1 = j1 + world.rand.nextFloat() * 0.2f;
                        double d2 = k1 + 0.5 + (k2 - k1) * world.rand.nextFloat();
                        world.spawnParticle("explode", d, d1, d2, 0.0, 0.0, 0.0);
                    }
                }
            }
        }
        world.theProfiler.endSection();
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (event.world instanceof WorldClient) {
            LOTRClientProxy.customEffectRenderer.clearEffectsAndSetWorld(event.world);
        }
    }

    @SubscribeEvent
    public void onPreRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getMinecraft();
        WorldClient world = mc.theWorld;
        EntityClientPlayerMP entityplayer = mc.thePlayer;
        float partialTicks = event.partialTicks;
        GuiIngame guiIngame = mc.ingameGUI;
        if (world != null && entityplayer != null) {
            int width;
            int height;
            ScaledResolution resolution;
            boolean enchantingDisabled;
            if (event.type == RenderGameOverlayEvent.ElementType.ALL) {
                mc.theWorld.theProfiler.startSection("lotr_fixHighlightedItemName");
                ItemStack itemstack = LOTRReflectionClient.getHighlightedItemStack(guiIngame);
                if (itemstack != null && !itemstack.hasDisplayName() && !(LOTREnchantmentHelper.getEnchantList(itemstack)).isEmpty()) {
                    this.lastHighlightedItemstack = itemstack;
                    this.highlightedItemstackName = itemstack.hasDisplayName() ? itemstack.getDisplayName() : null;
                    itemstack.setStackDisplayName(LOTREnchantmentHelper.getFullEnchantedName(itemstack, itemstack.getDisplayName()));
                }
                mc.theWorld.theProfiler.endSection();
            }
            if (event.type == RenderGameOverlayEvent.ElementType.HELMET) {
                int i;
                if (this.sunGlare > 0.0f && mc.gameSettings.thirdPersonView == 0) {
                    float brightness = this.prevSunGlare + (this.sunGlare - this.prevSunGlare) * partialTicks;
                    this.renderOverlay(null, brightness *= 1.0f, mc, null);
                }
                if (playersInPortals.containsKey(entityplayer) && (i = ((Integer)playersInPortals.get(entityplayer))) > 0) {
                    this.renderOverlay(null, 0.1f + i / 100.0f * 0.6f, mc, portalOverlay);
                }
                if (playersInElvenPortals.containsKey(entityplayer) && (i = ((Integer)playersInElvenPortals.get(entityplayer))) > 0) {
                    this.renderOverlay(null, 0.1f + (float)i / (float)entityplayer.getMaxInPortalTime() * 0.6f, mc, elvenPortalOverlay);
                }
                if (playersInMorgulPortals.containsKey(entityplayer) && (i = ((Integer)playersInMorgulPortals.get(entityplayer))) > 0) {
                    this.renderOverlay(null, 0.1f + (float)i / (float)entityplayer.getMaxInPortalTime() * 0.6f, mc, morgulPortalOverlay);
                }
                if (LOTRConfig.enableMistyMountainsMist) {
                    float mistTickF = this.prevMistTick + (this.mistTick - this.prevMistTick) * partialTicks;
                    float mistFactorY = (float)entityplayer.posY / 256.0f;
                    this.mistFactor = (mistTickF /= 80.0f) * mistFactorY;
                    if (this.mistFactor > 0.0f) {
                        this.renderOverlay(null, this.mistFactor * 0.75f, mc, mistOverlay);
                    }
                } else {
                    this.mistFactor = 0.0f;
                }
                if (this.frostTick > 0) {
                    float frostAlpha = this.frostTick / 80.0f;
                    float frostAlphaEdge = (float)Math.sqrt(frostAlpha *= 0.9f);
                    this.renderOverlayWithVerticalGradients(frostRGBEdge, frostRGBMiddle, frostAlphaEdge, frostAlpha, mc);
                    this.renderOverlay(null, frostAlpha * 0.6f, mc, frostOverlay);
                }
                if (this.burnTick > 0) {
                    this.renderOverlay(null, this.burnTick / 40.0f * 0.6f, mc, burnOverlay);
                }
                if (this.wightLookTick > 0) {
                    this.renderOverlay(null, this.wightLookTick / 100.0f * 0.95f, mc, wightOverlay);
                }
            }
            if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR) {
                LOTREntitySpiderBase spider;
                if (LOTRConfig.meleeAttackMeter) {
                    LOTRAttackTiming.renderAttackMeter(event.resolution, partialTicks);
                }
                if (entityplayer.ridingEntity instanceof LOTREntitySpiderBase && (spider = (LOTREntitySpiderBase)entityplayer.ridingEntity).shouldRenderClimbingMeter()) {
                    mc.getTextureManager().bindTexture(GuiIngame.icons);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glDisable(3042);
                    mc.mcProfiler.startSection("spiderClimb");
                    resolution = event.resolution;
                    width = resolution.getScaledWidth();
                    height = resolution.getScaledHeight();
                    float charge = spider.getClimbFractionRemaining();
                    int x = width / 2 - 91;
                    int filled = (int)(charge * 183.0f);
                    int top = height - 32 + 3;
                    guiIngame.drawTexturedModalRect(x, top, 0, 84, 182, 5);
                    if (filled > 0) {
                        guiIngame.drawTexturedModalRect(x, top, 0, 89, filled, 5);
                    }
                    GL11.glEnable(3042);
                    mc.mcProfiler.endSection();
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                }
            }
            if (event.type == RenderGameOverlayEvent.ElementType.HEALTH && entityplayer.isPotionActive(LOTRPoisonedDrinks.killingPoison) && !entityplayer.isPotionActive(Potion.poison)) {
                entityplayer.addPotionEffect(new PotionEffect(Potion.poison.id, 20));
                this.addedClientPoisonEffect = true;
            }
            enchantingDisabled = !LOTRLevelData.clientside_thisServer_enchanting && world.provider instanceof LOTRWorldProvider;
            if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE && enchantingDisabled) {
                event.setCanceled(true);
                return;
            }
            if (event.type == RenderGameOverlayEvent.ElementType.ALL && enchantingDisabled && entityplayer.ridingEntity == null) {
                GuiIngameForge.left_height -= 6;
                GuiIngameForge.right_height -= 6;
            }
            if (event.type == RenderGameOverlayEvent.ElementType.ARMOR) {
                event.setCanceled(true);
                resolution = event.resolution;
                width = resolution.getScaledWidth();
                height = resolution.getScaledHeight();
                mc.mcProfiler.startSection("armor");
                GL11.glEnable(3042);
                int left = width / 2 - 91;
                int top = height - GuiIngameForge.left_height;
                int level = LOTRWeaponStats.getTotalArmorValue(mc.thePlayer);
                if (level > 0) {
                    for (int i = 1; i < 20; i += 2) {
                        if (i < level) {
                            guiIngame.drawTexturedModalRect(left, top, 34, 9, 9, 9);
                        } else if (i == level) {
                            guiIngame.drawTexturedModalRect(left, top, 25, 9, 9, 9);
                        } else if (i > level) {
                            guiIngame.drawTexturedModalRect(left, top, 16, 9, 9, 9);
                        }
                        left += 8;
                    }
                }
                GuiIngameForge.left_height += 10;
                GL11.glDisable(3042);
                mc.mcProfiler.endSection();
            }
        }
    }

    @SubscribeEvent
    public void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getMinecraft();
        WorldClient world = mc.theWorld;
        EntityClientPlayerMP entityplayer = mc.thePlayer;
        GuiIngame guiIngame = mc.ingameGUI;
        if (world != null && entityplayer != null) {
            if (event.type == RenderGameOverlayEvent.ElementType.ALL && this.lastHighlightedItemstack != null) {
                if (this.highlightedItemstackName != null) {
                    this.lastHighlightedItemstack.setStackDisplayName(this.highlightedItemstackName);
                } else {
                    this.lastHighlightedItemstack.func_135074_t();
                }
                this.lastHighlightedItemstack = null;
                this.highlightedItemstackName = null;
            }
            if (event.type == RenderGameOverlayEvent.ElementType.BOSSHEALTH && watchedInvasion.isActive()) {
                GL11.glEnable(3042);
                FontRenderer fr = mc.fontRenderer;
                ScaledResolution scaledresolution = event.resolution;
                int width = scaledresolution.getScaledWidth();
                int barWidth = 182;
                int remainingWidth = (int)(watchedInvasion.getHealth() * (barWidth - 2));
                int barHeight = 5;
                int barX = width / 2 - barWidth / 2;
                int barY = 12;
                if (LOTRTickHandlerClient.isBossActive()) {
                    barY += 20;
                }
                mc.getTextureManager().bindTexture(LOTRClientProxy.alignmentTexture);
                guiIngame.drawTexturedModalRect(barX, barY, 64, 64, barWidth, barHeight);
                if (remainingWidth > 0) {
                    float[] rgb = watchedInvasion.getRGB();
                    GL11.glColor4f(rgb[0], rgb[1], rgb[2], 1.0f);
                    guiIngame.drawTexturedModalRect(barX + 1, barY + 1, 65, 70, remainingWidth, barHeight - 2);
                }
                String s = watchedInvasion.getTitle();
                fr.drawStringWithShadow(s, width / 2 - fr.getStringWidth(s) / 2, barY - 10, 16777215);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                mc.getTextureManager().bindTexture(Gui.icons);
                GL11.glDisable(3042);
            }
            if (event.type == RenderGameOverlayEvent.ElementType.HEALTH && this.addedClientPoisonEffect) {
                entityplayer.removePotionEffectClient(Potion.poison.id);
                this.addedClientPoisonEffect = false;
            }
            if (event.type == RenderGameOverlayEvent.ElementType.TEXT && this.bannerRepossessDisplayTick > 0) {
                String text = StatCollector.translateToLocalFormatted("item.lotr.banner.toggleRepossess", GameSettings.getKeyDisplayString(mc.gameSettings.keyBindSneak.getKeyCode()));
                int fadeAtTick = 10;
                int opacity = (int)(this.bannerRepossessDisplayTick * 255.0f / fadeAtTick);
                if ((opacity = Math.min(opacity, 255)) > 0) {
                    ScaledResolution scaledresolution = event.resolution;
                    int width = scaledresolution.getScaledWidth();
                    int height = scaledresolution.getScaledHeight();
                    int y = height - 59;
                    y -= 12;
                    if (!mc.playerController.shouldDrawHUD()) {
                        y += 14;
                    }
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                    FontRenderer fr = mc.fontRenderer;
                    int x = (width - fr.getStringWidth(text)) / 2;
                    fr.drawString(text, x, y, 0xFFFFFF | opacity << 24);
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
        }
    }

    @SubscribeEvent
    public void onRenderDebugText(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.gameSettings.showDebugInfo && mc.theWorld != null && mc.thePlayer != null && mc.theWorld.getWorldChunkManager() instanceof LOTRWorldChunkManager) {
            mc.theWorld.theProfiler.startSection("lotrBiomeDisplay");
            LOTRWorldChunkManager chunkManager = (LOTRWorldChunkManager)mc.theWorld.getWorldChunkManager();
            int i = MathHelper.floor_double(mc.thePlayer.posX);
            int j = MathHelper.floor_double(mc.thePlayer.boundingBox.minY);
            int k = MathHelper.floor_double(mc.thePlayer.posZ);
            LOTRBiome biome = (LOTRBiome)mc.theWorld.getBiomeGenForCoords(i, k);
            LOTRBiomeVariant variant = chunkManager.getBiomeVariantAt(i, k);
            event.left.add(null);
            biome.addBiomeF3Info(event.left, mc.theWorld, variant, i, j, k);
            mc.theWorld.theProfiler.endSection();
        }
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        float f = event.partialTicks;
        if (LOTRConfig.aurora && LOTRDimension.getCurrentDimension(mc.theWorld) == LOTRDimension.MIDDLE_EARTH) {
            LOTRRenderNorthernLights.render(mc, mc.theWorld, f);
        }
        mc.entityRenderer.enableLightmap(f);
        RenderHelper.disableStandardItemLighting();
        LOTRClientProxy.customEffectRenderer.renderParticles(mc.renderViewEntity, f);
        mc.entityRenderer.disableLightmap(f);
        if (Minecraft.isGuiEnabled() && mc.entityRenderer.debugViewDirection == 0) {
            mc.mcProfiler.startSection("lotrSpeech");
            LOTRNPCRendering.renderAllNPCSpeeches(mc, mc.theWorld, f);
            mc.mcProfiler.endSection();
        }
    }

    @SubscribeEvent
    public void getItemTooltip(ItemTooltipEvent event) {
        int i;
        List<String> previousOwners;
        int armorProtect;
        String currentOwner;
        String squadron;
        ItemStack itemstack = event.itemStack;
        List tooltip = event.toolTip;
        EntityPlayer entityplayer = event.entityPlayer;
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        List<LOTREnchantment> enchantments = LOTREnchantmentHelper.getEnchantList(itemstack);
        if (!itemstack.hasDisplayName() && !enchantments.isEmpty()) {
            String name = (String)tooltip.get(0);
            name = LOTREnchantmentHelper.getFullEnchantedName(itemstack, name);
            tooltip.set(0, name);
        }
        if (itemstack.getItem() instanceof LOTRSquadrons.SquadronItem && !StringUtils.isNullOrEmpty(squadron = LOTRSquadrons.getSquadron(itemstack))) {
            ArrayList newTooltip = new ArrayList();
            newTooltip.add(tooltip.get(0));
            newTooltip.add(StatCollector.translateToLocalFormatted("item.lotr.generic.squadron", squadron));
            for (i = 1; i < tooltip.size(); ++i) {
                newTooltip.add(tooltip.get(i));
            }
            tooltip.clear();
            tooltip.addAll(newTooltip);
        }
        if (LOTRWeaponStats.isMeleeWeapon(itemstack)) {
            int dmgIndex = -1;
            for (int i2 = 0; i2 < tooltip.size(); ++i2) {
                String s = (String)tooltip.get(i2);
                if (!s.startsWith(EnumChatFormatting.BLUE.toString())) continue;
                dmgIndex = i2;
                break;
            }
            if (dmgIndex >= 0) {
                ArrayList newTooltip = new ArrayList();
                for (i = 0; i <= dmgIndex - 1; ++i) {
                    newTooltip.add(tooltip.get(i));
                }
                float meleeDamage = LOTRWeaponStats.getMeleeDamageBonus(itemstack);
                newTooltip.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("lotr.weaponstat.meleeDamage", Float.valueOf(meleeDamage)));
                float meleeSpeed = LOTRWeaponStats.getMeleeSpeed(itemstack);
                int pcSpeed = Math.round(meleeSpeed * 100.0f);
                newTooltip.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("lotr.weaponstat.meleeSpeed", pcSpeed));
                float reach = LOTRWeaponStats.getMeleeReachFactor(itemstack);
                int pcReach = Math.round(reach * 100.0f);
                newTooltip.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("lotr.weaponstat.reach", pcReach));
                int kb = LOTRWeaponStats.getTotalKnockback(itemstack);
                if (kb > 0) {
                    newTooltip.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("lotr.weaponstat.kb", kb));
                }
                for (int i3 = dmgIndex + 1; i3 < tooltip.size(); ++i3) {
                    newTooltip.add(tooltip.get(i3));
                }
                tooltip.clear();
                tooltip.addAll(newTooltip);
            }
        }
        if (LOTRWeaponStats.isRangedWeapon(itemstack)) {
            int kb;
            float damage;
            tooltip.add("");
            float drawSpeed = LOTRWeaponStats.getRangedSpeed(itemstack);
            if (drawSpeed > 0.0f) {
                int pcSpeed = Math.round(drawSpeed * 100.0f);
                tooltip.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted("lotr.weaponstat.rangedSpeed", pcSpeed));
            }
            if ((damage = LOTRWeaponStats.getRangedDamageFactor(itemstack, false)) > 0.0f) {
                int pcDamage = Math.round(damage * 100.0f);
                tooltip.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted("lotr.weaponstat.rangedDamage", pcDamage));
                if (itemstack.getItem() instanceof ItemBow || itemstack.getItem() instanceof LOTRItemCrossbow) {
                    float range = LOTRWeaponStats.getRangedDamageFactor(itemstack, true);
                    int pcRange = Math.round(range * 100.0f);
                    tooltip.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted("lotr.weaponstat.range", pcRange));
                }
            }
            if ((kb = LOTRWeaponStats.getRangedKnockback(itemstack)) > 0) {
                tooltip.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted("lotr.weaponstat.kb", kb));
            }
        }
        if (LOTRWeaponStats.isPoisoned(itemstack)) {
            tooltip.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted("lotr.weaponstat.poison"));
        }
        if ((armorProtect = LOTRWeaponStats.getArmorProtection(itemstack)) > 0) {
            tooltip.add("");
            int pcProtection = Math.round(armorProtect / 25.0f * 100.0f);
            tooltip.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("lotr.weaponstat.protection", armorProtect, pcProtection));
        }
        if (!enchantments.isEmpty()) {
            tooltip.add("");
            ArrayList<String> enchGood = new ArrayList<>();
            ArrayList<String> enchBad = new ArrayList<>();
            for (LOTREnchantment ench : enchantments) {
                String enchDesc = ench.getNamedFormattedDescription(itemstack);
                if (ench.isBeneficial()) {
                    enchGood.add(enchDesc);
                    continue;
                }
                enchBad.add(enchDesc);
            }
            tooltip.addAll(enchGood);
            tooltip.addAll(enchBad);
        }
        if (LOTRPoisonedDrinks.isDrinkPoisoned(itemstack) && LOTRPoisonedDrinks.canPlayerSeePoisoned(itemstack, entityplayer)) {
            tooltip.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocal("item.lotr.drink.poison"));
        }
        if ((currentOwner = LOTRItemOwnership.getCurrentOwner(itemstack)) != null) {
            tooltip.add("");
            String ownerFormatted = StatCollector.translateToLocalFormatted("item.lotr.generic.currentOwner", currentOwner);
            List ownerLines = fontRenderer.listFormattedStringToWidth(ownerFormatted, 150);
            for (int i4 = 0; i4 < ownerLines.size(); ++i4) {
                String line = (String)ownerLines.get(i4);
                if (i4 > 0) {
                    line = "  " + line;
                }
                tooltip.add(line);
            }
        }
        if (!(previousOwners = LOTRItemOwnership.getPreviousOwners(itemstack)).isEmpty()) {
            tooltip.add("");
            ArrayList<String> ownerLines = new ArrayList<>();
            if (previousOwners.size() == 1) {
                String ownerFormatted = EnumChatFormatting.ITALIC + StatCollector.translateToLocalFormatted("item.lotr.generic.previousOwner", previousOwners.get(0));
                ownerLines.addAll(fontRenderer.listFormattedStringToWidth(ownerFormatted, 150));
            } else {
                String beginList = EnumChatFormatting.ITALIC + StatCollector.translateToLocal("item.lotr.generic.previousOwnerList");
                ownerLines.add(beginList);
                for (String previousOwner : previousOwners) {
                    previousOwner = EnumChatFormatting.ITALIC + previousOwner;
                    ownerLines.addAll(fontRenderer.listFormattedStringToWidth(previousOwner, 150));
                }
            }
            for (int i5 = 0; i5 < ownerLines.size(); ++i5) {
                String line = ownerLines.get(i5);
                if (i5 > 0) {
                    line = "  " + line;
                }
                tooltip.add(line);
            }
        }
        if (IPickpocketable.Helper.isPickpocketed(itemstack)) {
            tooltip.add("");
            String owner = IPickpocketable.Helper.getOwner(itemstack);
            owner = StatCollector.translateToLocalFormatted("item.lotr.generic.stolen", owner);
            String wanter = IPickpocketable.Helper.getWanter(itemstack);
            wanter = StatCollector.translateToLocalFormatted("item.lotr.generic.stolenWanted", wanter);
            ArrayList robbedLines = new ArrayList(fontRenderer.listFormattedStringToWidth(owner, 200));
            robbedLines.addAll(fontRenderer.listFormattedStringToWidth(wanter, 200));
            for (int i6 = 0; i6 < robbedLines.size(); ++i6) {
                String line = (String)robbedLines.get(i6);
                if (i6 > 0) {
                    line = "  " + line;
                }
                tooltip.add(line);
            }
        }
        if (itemstack.getItem() == Item.getItemFromBlock(Blocks.monster_egg)) {
            tooltip.set(0, (Object)EnumChatFormatting.RED + (String)tooltip.get(0));
        }
        if (LOTRMod.isAprilFools()) {
            String name = (String)tooltip.get(0);
            name = name.replace("kebab", "gyros");
            name = name.replace("Kebab", "Gyros");
            tooltip.set(0, name);
        }
    }

    @SubscribeEvent
    public void onFOVUpdate(FOVUpdateEvent event) {
        EntityPlayerSP entityplayer = event.entity;
        float fov = event.newfov;
        ItemStack itemstack = entityplayer.getHeldItem();
        Item item = itemstack == null ? null : itemstack.getItem();
        float usage = -1.0f;
        if (entityplayer.isUsingItem()) {
            float maxDrawTime = 0.0f;
            if (item instanceof LOTRItemBow) {
                maxDrawTime = ((LOTRItemBow)item).getMaxDrawTime();
            } else if (item instanceof LOTRItemCrossbow) {
                maxDrawTime = ((LOTRItemCrossbow)item).getMaxDrawTime();
            } else if (item instanceof LOTRItemSpear) {
                maxDrawTime = ((LOTRItemSpear)item).getMaxDrawTime();
            } else if (item instanceof LOTRItemBlowgun) {
                maxDrawTime = ((LOTRItemBlowgun)item).getMaxDrawTime();
            }
            if (maxDrawTime > 0.0f) {
                int i = entityplayer.getItemInUseDuration();
                usage = i / maxDrawTime;
                usage = usage > 1.0f ? 1.0f : (usage *= usage);
            }
        }
        if (LOTRItemCrossbow.isLoaded(itemstack)) {
            usage = 1.0f;
        }
        if (usage >= 0.0f) {
            fov *= 1.0f - usage * 0.15f;
        }
        event.newfov = fov;
    }

    @SubscribeEvent
    public void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityLivingBase viewer = event.entity;
        WorldClient world = mc.theWorld;
        WorldProvider provider = world.provider;
        int i = MathHelper.floor_double(viewer.posX);
        int j = MathHelper.floor_double(viewer.boundingBox.minY);
        int k = MathHelper.floor_double(viewer.posZ);
        BiomeGenBase biome = world.getBiomeGenForCoords(i, k);
        float farPlane = event.farPlaneDistance;
        int fogMode = event.fogMode;
        if (provider instanceof LOTRWorldProvider) {
            float rain;
            LOTRBiome lotrbiome = (LOTRBiome)biome;
            float[] fogStartEnd = ((LOTRWorldProvider)provider).modifyFogIntensity(farPlane, fogMode);
            float fogStart = fogStartEnd[0];
            float fogEnd = fogStartEnd[1];
            if (LOTRConfig.newWeather && (lotrbiome.getEnableRain() || lotrbiome.getEnableSnow()) && (rain = this.prevRainFactor + (this.rainFactor - this.prevRainFactor) * renderTick) > 0.0f) {
                float rainOpacityStart = 0.95f;
                float rainOpacityEnd = 0.2f;
                fogStart -= fogStart * (rain * rainOpacityStart);
                fogEnd -= fogEnd * (rain * rainOpacityEnd);
            }
            if (this.mistFactor > 0.0f) {
                float mistOpacityStart = 0.95f;
                float mistOpacityEnd = 0.7f;
                fogStart -= fogStart * (this.mistFactor * mistOpacityStart);
                fogEnd -= fogEnd * (this.mistFactor * mistOpacityEnd);
            }
            float wightFactor = this.prevWightNearTick + (this.wightNearTick - this.prevWightNearTick) * renderTick;
            if ((wightFactor /= 100.0f) > 0.0f) {
                float wightOpacityStart = 0.97f;
                float wightOpacityEnd = 0.75f;
                fogStart -= fogStart * (wightFactor * wightOpacityStart);
                fogEnd -= fogEnd * (wightFactor * wightOpacityEnd);
            }
            if (lotrbiome instanceof LOTRBiomeGenBarrowDowns) {
                if (wightFactor > 0.0f) {
                    int sky0 = lotrbiome.getBaseSkyColorByTemp(i, j, k);
                    int sky1 = 9674385;
                    int clouds0 = 16777215;
                    int clouds1 = 11842740;
                    int fog0 = 16777215;
                    int fog1 = 10197915;
                    lotrbiome.biomeColors.setSky(LOTRColorUtil.lerpColors_I(sky0, sky1, wightFactor));
                    lotrbiome.biomeColors.setClouds(LOTRColorUtil.lerpColors_I(clouds0, clouds1, wightFactor));
                    lotrbiome.biomeColors.setFog(LOTRColorUtil.lerpColors_I(fog0, fog1, wightFactor));
                } else {
                    lotrbiome.biomeColors.resetSky();
                    lotrbiome.biomeColors.resetClouds();
                    lotrbiome.biomeColors.resetFog();
                }
            }
            this.balrogFactor = this.prevBalrogNearTick + (this.balrogNearTick - this.prevBalrogNearTick) * renderTick;
            this.balrogFactor /= 100.0f;
            if (this.balrogFactor > 0.0f) {
                float balrogOpacityStart = 0.98f;
                float balrogOpacityEnd = 0.75f;
                fogStart -= fogStart * (this.balrogFactor * balrogOpacityStart);
                fogEnd -= fogEnd * (this.balrogFactor * balrogOpacityEnd);
            }
            GL11.glFogf(2915, fogStart);
            GL11.glFogf(2916, fogEnd);
        }
    }

    @SubscribeEvent
    public void onFogColors(EntityViewRenderEvent.FogColors event) {
        Minecraft mc = Minecraft.getMinecraft();
        WorldClient world = mc.theWorld;
        WorldProvider provider = world.provider;
        if (provider instanceof LOTRWorldProvider) {
            float[] rgb = new float[]{event.red, event.green, event.blue};
            rgb = ((LOTRWorldProvider)provider).handleFinalFogColors(event.entity, event.renderPartialTicks, rgb);
            event.red = rgb[0];
            event.green = rgb[1];
            event.blue = rgb[2];
        }
        if (this.balrogFactor > 0.0f) {
            int shadowColor = 1114112;
            float[] rgb = new float[]{event.red, event.green, event.blue};
            rgb = LOTRColorUtil.lerpColors(rgb, shadowColor, this.balrogFactor);
            event.red = rgb[0];
            event.green = rgb[1];
            event.blue = rgb[2];
        }
    }

    private boolean isGamePaused(Minecraft mc) {
        return mc.isSingleplayer() && mc.currentScreen != null && mc.currentScreen.doesGuiPauseGame() && !mc.getIntegratedServer().getPublic();
    }

    private void renderOverlay(float[] rgb, float alpha, Minecraft mc, ResourceLocation texture) {
        ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int width = resolution.getScaledWidth();
        int height = resolution.getScaledHeight();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        if (rgb != null) {
            GL11.glColor4f(rgb[0], rgb[1], rgb[2], alpha);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
        }
        GL11.glDisable(3008);
        if (texture != null) {
            mc.getTextureManager().bindTexture(texture);
        } else {
            GL11.glDisable(3553);
        }
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, height, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV(width, height, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(width, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        if (texture == null) {
            GL11.glEnable(3553);
        }
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void renderOverlayWithVerticalGradients(float[] rgbEdge, float[] rgbCentre, float alphaEdge, float alphaCentre, Minecraft mc) {
        ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int width = resolution.getScaledWidth();
        int height = resolution.getScaledHeight();
        int heightThird = height / 3;
        int heightTwoThirds = height * 2 / 3;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glDisable(3008);
        GL11.glDisable(3553);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(rgbCentre[0], rgbCentre[1], rgbCentre[2], alphaCentre);
        tessellator.addVertex(0.0, heightThird, -90.0);
        tessellator.addVertex(width, heightThird, -90.0);
        tessellator.setColorRGBA_F(rgbEdge[0], rgbEdge[1], rgbEdge[2], alphaEdge);
        tessellator.addVertex(width, 0.0, -90.0);
        tessellator.addVertex(0.0, 0.0, -90.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(rgbCentre[0], rgbCentre[1], rgbCentre[2], alphaCentre);
        tessellator.addVertex(0.0, heightTwoThirds, -90.0);
        tessellator.addVertex(width, heightTwoThirds, -90.0);
        tessellator.setColorRGBA_F(rgbCentre[0], rgbCentre[1], rgbCentre[2], alphaCentre);
        tessellator.addVertex(width, heightThird, -90.0);
        tessellator.addVertex(0.0, heightThird, -90.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(rgbEdge[0], rgbEdge[1], rgbEdge[2], alphaEdge);
        tessellator.addVertex(0.0, height, -90.0);
        tessellator.addVertex(width, height, -90.0);
        tessellator.setColorRGBA_F(rgbCentre[0], rgbCentre[1], rgbCentre[2], alphaCentre);
        tessellator.addVertex(width, heightTwoThirds, -90.0);
        tessellator.addVertex(0.0, heightTwoThirds, -90.0);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void renderAlignment(Minecraft mc, float f) {
        EntityClientPlayerMP entityplayer = mc.thePlayer;
        LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
        LOTRFaction viewingFac = pd.getViewingFaction();
        ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int width = resolution.getScaledWidth();
        resolution.getScaledHeight();
        this.alignmentXBase = width / 2 + LOTRConfig.alignmentXOffset;
        this.alignmentYBase = 4 + LOTRConfig.alignmentYOffset;
        if (LOTRTickHandlerClient.isBossActive()) {
            this.alignmentYBase += 20;
        }
        if (watchedInvasion.isActive()) {
            this.alignmentYBase += 20;
        }
        if (this.firstAlignmentRender) {
            LOTRAlignmentTicker.updateAll(entityplayer, true);
            this.alignmentXPrev = this.alignmentXCurrent = this.alignmentXBase;
            this.alignmentYCurrent = -20;
            this.alignmentYPrev = -20;
            this.firstAlignmentRender = false;
        }
        float alignmentXF = this.alignmentXPrev + (this.alignmentXCurrent - this.alignmentXPrev) * f;
        float alignmentYF = this.alignmentYPrev + (this.alignmentYCurrent - this.alignmentYPrev) * f;
        boolean text = this.alignmentYCurrent == this.alignmentYBase;
        float alignment = LOTRAlignmentTicker.forFaction(viewingFac).getInterpolatedAlignment(f);
        LOTRTickHandlerClient.renderAlignmentBar(alignment, false, viewingFac, alignmentXF, alignmentYF, text, text, text, false);
        if (alignDrainTick > 0 && text) {
            float alpha = 1.0f;
            int fadeTick = 20;
            if (alignDrainTick < fadeTick) {
                alpha = (float)alignDrainTick / (float)fadeTick;
            }
            LOTRTickHandlerClient.renderAlignmentDrain(mc, (int)alignmentXF - 155, (int)alignmentYF + 2, alignDrainNum, alpha);
        }
    }

    public static void renderAlignmentBar(float alignment, boolean isOtherPlayer, LOTRFaction faction, float x, float y, boolean renderFacName, boolean renderValue, boolean renderLimits, boolean renderLimitValues) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityClientPlayerMP entityplayer = mc.thePlayer;
        LOTRPlayerData clientPD = LOTRLevelData.getData(entityplayer);
        LOTRFactionRank rank = faction.getRank(alignment);
        boolean pledged = clientPD.isPledgedTo(faction);
        LOTRAlignmentTicker ticker = LOTRAlignmentTicker.forFaction(faction);
        float alignMin = 0.0f;
        float alignMax = 0.0f;
        LOTRFactionRank rankMin = null;
        LOTRFactionRank rankMax = null;
        if (!rank.isDummyRank()) {
            alignMin = rank.alignment;
            rankMin = rank;
            LOTRFactionRank nextRank = faction.getRankAbove(rank);
            if (nextRank != null && !nextRank.isDummyRank() && nextRank != rank) {
                alignMax = nextRank.alignment;
                rankMax = nextRank;
            } else {
                alignMax = rank.alignment * 10.0f;
                rankMax = rank;
                while (alignment >= alignMax) {
                    alignMin = alignMax;
                    alignMax = alignMin * 10.0f;
                }
            }
        } else {
            LOTRFactionRank firstRank = faction.getFirstRank();
            float firstRankAlign = firstRank != null && !firstRank.isDummyRank() ? firstRank.alignment : 10.0f;
            if (Math.abs(alignment) < firstRankAlign) {
                alignMin = -firstRankAlign;
                alignMax = firstRankAlign;
                rankMin = LOTRFactionRank.RANK_ENEMY;
                rankMax = firstRank != null && !firstRank.isDummyRank() ? firstRank : LOTRFactionRank.RANK_NEUTRAL;
            } else if (alignment < 0.0f) {
                alignMax = -firstRankAlign;
                alignMin = alignMax * 10.0f;
                rankMin = rankMax = LOTRFactionRank.RANK_ENEMY;
                while (alignment <= alignMin) {
                    alignMin = (alignMax *= 10.0f) * 10.0f;
                }
            } else {
                alignMin = firstRankAlign;
                alignMax = alignMin * 10.0f;
                rankMin = rankMax = LOTRFactionRank.RANK_NEUTRAL;
                while (alignment >= alignMax) {
                    alignMin = alignMax;
                    alignMax = alignMin * 10.0f;
                }
            }
        }
        float ringProgress = (alignment - alignMin) / (alignMax - alignMin);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(LOTRClientProxy.alignmentTexture);
        int barWidth = 232;
        int barHeight = 14;
        int activeBarWidth = 220;
        float[] factionColors = faction.getFactionRGB();
        GL11.glColor4f(factionColors[0], factionColors[1], factionColors[2], 1.0f);
        LOTRTickHandlerClient.drawTexturedModalRect(x - barWidth / 2, y, 0, 14, barWidth, barHeight);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        LOTRTickHandlerClient.drawTexturedModalRect(x - barWidth / 2, y, 0, 0, barWidth, barHeight);
        float ringProgressAdj = (ringProgress - 0.5f) * 2.0f;
        int ringSize = 16;
        float ringX = x - ringSize / 2 + ringProgressAdj * activeBarWidth / 2.0f;
        float ringY = y + barHeight / 2 - ringSize / 2;
        int flashTick = ticker.flashTick;
        if (pledged) {
            LOTRTickHandlerClient.drawTexturedModalRect(ringX, ringY, 16 * Math.round(flashTick / 3), 212, ringSize, ringSize);
        } else {
            LOTRTickHandlerClient.drawTexturedModalRect(ringX, ringY, 16 * Math.round(flashTick / 3), 36, ringSize, ringSize);
        }
        if (faction.isPlayableAlignmentFaction()) {
            float alpha = 0.0f;
            boolean definedZone = false;
            if (faction.inControlZone(entityplayer)) {
                alpha = 1.0f;
                definedZone = faction.inDefinedControlZone(entityplayer);
            } else {
                alpha = faction.getControlZoneAlignmentMultiplier(entityplayer);
                definedZone = true;
            }
            if (alpha > 0.0f) {
                int arrowSize = 14;
                int y0 = definedZone ? 60 : 88;
                int y1 = definedZone ? 74 : 102;
                GL11.glEnable(3042);
                OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                GL11.glColor4f(factionColors[0], factionColors[1], factionColors[2], alpha);
                LOTRTickHandlerClient.drawTexturedModalRect(x - barWidth / 2 - arrowSize, y, 0, y1, arrowSize, arrowSize);
                LOTRTickHandlerClient.drawTexturedModalRect(x + barWidth / 2, y, arrowSize, y1, arrowSize, arrowSize);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
                LOTRTickHandlerClient.drawTexturedModalRect(x - barWidth / 2 - arrowSize, y, 0, y0, arrowSize, arrowSize);
                LOTRTickHandlerClient.drawTexturedModalRect(x + barWidth / 2, y, arrowSize, y0, arrowSize, arrowSize);
                GL11.glDisable(3042);
            }
        }
        FontRenderer fr = mc.fontRenderer;
        int textX = Math.round(x);
        int textY = Math.round(y + barHeight + 4.0f);
        if (renderLimits) {
            String sMin = rankMin.getShortNameWithGender(clientPD);
            String sMax = rankMax.getShortNameWithGender(clientPD);
            if (renderLimitValues) {
                sMin = StatCollector.translateToLocalFormatted("lotr.gui.factions.alignment.limits", sMin, LOTRAlignmentValues.formatAlignForDisplay(alignMin));
                sMax = StatCollector.translateToLocalFormatted("lotr.gui.factions.alignment.limits", sMax, LOTRAlignmentValues.formatAlignForDisplay(alignMax));
            }
            int limitsX = barWidth / 2 - 6;
            int xMin = Math.round(x - limitsX);
            int xMax = Math.round(x + limitsX);
            GL11.glPushMatrix();
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            LOTRTickHandlerClient.drawAlignmentText(fr, xMin * 2 - fr.getStringWidth(sMin) / 2, textY * 2, sMin, 1.0f);
            LOTRTickHandlerClient.drawAlignmentText(fr, xMax * 2 - fr.getStringWidth(sMax) / 2, textY * 2, sMax, 1.0f);
            GL11.glPopMatrix();
        }
        if (renderFacName) {
            String name = faction.factionName();
            LOTRTickHandlerClient.drawAlignmentText(fr, textX - fr.getStringWidth(name) / 2, textY, name, 1.0f);
        }
        if (renderValue) {
            String alignS;
            float alignAlpha;
            int numericalTick = ticker.numericalTick;
            if (numericalTick > 0) {
                alignS = LOTRAlignmentValues.formatAlignForDisplay(alignment);
                alignAlpha = LOTRFunctions.triangleWave(numericalTick, 0.7f, 1.0f, 30.0f);
                int fadeTick = 15;
                if (numericalTick < fadeTick) {
                    alignAlpha *= (float)numericalTick / (float)fadeTick;
                }
            } else {
                alignS = rank.getShortNameWithGender(clientPD);
                alignAlpha = 1.0f;
            }
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            LOTRTickHandlerClient.drawAlignmentText(fr, textX - fr.getStringWidth(alignS) / 2, textY + fr.FONT_HEIGHT + 3, alignS, alignAlpha);
            GL11.glDisable(3042);
        }
    }

    public static void renderAlignmentDrain(Minecraft mc, int x, int y, int numFactions) {
        LOTRTickHandlerClient.renderAlignmentDrain(mc, x, y, numFactions, 1.0f);
    }

    public static void renderAlignmentDrain(Minecraft mc, int x, int y, int numFactions, float alpha) {
        GL11.glEnable(3042);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
        mc.getTextureManager().bindTexture(LOTRClientProxy.alignmentTexture);
        LOTRTickHandlerClient.drawTexturedModalRect(x, y, 0, 128, 16, 16);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        String s = "-" + numFactions;
        FontRenderer fr = mc.fontRenderer;
        LOTRTickHandlerClient.drawBorderedText(fr, x + 8 - fr.getStringWidth(s) / 2, y + 8 - fr.FONT_HEIGHT / 2, s, 16777215, alpha);
        GL11.glDisable(3042);
    }

    public static void drawTexturedModalRect(double x, double y, int u, int v, int width, int height) {
        float f = 0.00390625f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0.0, y + height, 0.0, (u + 0) * f, (v + height) * f);
        tessellator.addVertexWithUV(x + width, y + height, 0.0, (u + width) * f, (v + height) * f);
        tessellator.addVertexWithUV(x + width, y + 0.0, 0.0, (u + width) * f, (v + 0) * f);
        tessellator.addVertexWithUV(x + 0.0, y + 0.0, 0.0, (u + 0) * f, (v + 0) * f);
        tessellator.draw();
    }

    public static void drawAlignmentText(FontRenderer f, int x, int y, String s, float alphaF) {
        LOTRTickHandlerClient.drawBorderedText(f, x, y, s, 16772620, alphaF);
    }

    public static void drawConquestText(FontRenderer f, int x, int y, String s, boolean cleanse, float alphaF) {
        LOTRTickHandlerClient.drawBorderedText(f, x, y, s, cleanse ? 16773846 : 14833677, alphaF);
    }

    public static void drawBorderedText(FontRenderer f, int x, int y, String s, int color, float alphaF) {
        int alpha = (int)(alphaF * 255.0f);
        alpha = MathHelper.clamp_int(alpha, 4, 255);
        f.drawString(s, x - 1, y - 1, 0 | (alpha <<= 24));
        f.drawString(s, x, y - 1, 0 | alpha);
        f.drawString(s, x + 1, y - 1, 0 | alpha);
        f.drawString(s, x + 1, y, 0 | alpha);
        f.drawString(s, x + 1, y + 1, 0 | alpha);
        f.drawString(s, x, y + 1, 0 | alpha);
        f.drawString(s, x - 1, y + 1, 0 | alpha);
        f.drawString(s, x - 1, y, 0 | alpha);
        f.drawString(s, x, y, color | alpha);
    }

    public void onFrostDamage() {
        this.frostTick = 80;
    }

    public void onBurnDamage() {
        this.burnTick = 40;
    }

    public void updateDate() {
        this.newDate = 200;
    }

    public float getWightLookFactor() {
        float f = this.prevWightLookTick + (this.wightLookTick - this.prevWightLookTick) * renderTick;
        return f /= 100.0f;
    }

    private static boolean isBossActive() {
        return BossStatus.bossName != null && BossStatus.statusBarTime > 0;
    }

    static {
        watchedInvasion = new LOTRInvasionStatus();
        scrapTraderMisbehaveTick = 0;
    }
}

