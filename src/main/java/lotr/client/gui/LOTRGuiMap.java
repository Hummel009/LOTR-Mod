/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.google.common.math.IntMath
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.minecraft.MinecraftProfileTexture
 *  com.mojang.authlib.minecraft.MinecraftProfileTexture$Type
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderItem
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.resources.SkinManager
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.StatCollector
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.EmptyChunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.storage.WorldInfo
 *  org.apache.commons.lang3.StringUtils
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package lotr.client.gui;

import com.google.common.math.IntMath;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import lotr.client.LOTRClientProxy;
import lotr.client.LOTRKeyHandler;
import lotr.client.LOTRTextures;
import lotr.client.LOTRTickHandlerClient;
import lotr.client.gui.LOTRGuiButtonRedBook;
import lotr.client.gui.LOTRGuiFactions;
import lotr.client.gui.LOTRGuiFellowships;
import lotr.client.gui.LOTRGuiMapWidget;
import lotr.client.gui.LOTRGuiMenuBase;
import lotr.client.gui.LOTRGuiScrollPane;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRConfig;
import lotr.common.LOTRDimension;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.LOTRPlayerData;
import lotr.common.fac.LOTRAlignmentValues;
import lotr.common.fac.LOTRControlZone;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRank;
import lotr.common.fellowship.LOTRFellowshipClient;
import lotr.common.network.LOTRPacketCWPSharedHide;
import lotr.common.network.LOTRPacketClientMQEvent;
import lotr.common.network.LOTRPacketConquestGridRequest;
import lotr.common.network.LOTRPacketCreateCWP;
import lotr.common.network.LOTRPacketDeleteCWP;
import lotr.common.network.LOTRPacketFastTravel;
import lotr.common.network.LOTRPacketHandler;
import lotr.common.network.LOTRPacketIsOpRequest;
import lotr.common.network.LOTRPacketMapTp;
import lotr.common.network.LOTRPacketRenameCWP;
import lotr.common.network.LOTRPacketShareCWP;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRAbstractWaypoint;
import lotr.common.world.map.LOTRConquestGrid;
import lotr.common.world.map.LOTRConquestZone;
import lotr.common.world.map.LOTRCustomWaypoint;
import lotr.common.world.map.LOTRFixedStructures;
import lotr.common.world.map.LOTRRoads;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class LOTRGuiMap
extends LOTRGuiMenuBase {
    private static Map<UUID, PlayerLocationInfo> playerLocations = new HashMap<UUID, PlayerLocationInfo>();
    public static final ResourceLocation mapIconsTexture = new ResourceLocation("lotr:map/mapScreen.png");
    public static final ResourceLocation conquestTexture = new ResourceLocation("lotr:map/conquest.png");
    private static final ItemStack questBookIcon = new ItemStack(LOTRMod.redBook);
    public static final int BLACK = -16777216;
    public static final int BORDER_COLOR = -6156032;
    private static final int MIN_ZOOM = -3;
    private static final int MAX_ZOOM = 4;
    private static final int mapBorder = 30;
    private static boolean fullscreen = true;
    private static int mapWidth;
    private static int mapHeight;
    private static int mapXMin;
    private static int mapXMax;
    private static int mapYMin;
    private static int mapYMax;
    private static int mapXMin_W;
    private static int mapXMax_W;
    private static int mapYMin_W;
    private static int mapYMax_W;
    private static List<LOTRGuiMapWidget> mapWidgets;
    private LOTRGuiMapWidget widgetAddCWP;
    private LOTRGuiMapWidget widgetDelCWP;
    private LOTRGuiMapWidget widgetRenameCWP;
    private LOTRGuiMapWidget widgetToggleWPs;
    private LOTRGuiMapWidget widgetToggleCWPs;
    private LOTRGuiMapWidget widgetToggleHiddenSWPs;
    private LOTRGuiMapWidget widgetZoomIn;
    private LOTRGuiMapWidget widgetZoomOut;
    private LOTRGuiMapWidget widgetFullScreen;
    private LOTRGuiMapWidget widgetSepia;
    private LOTRGuiMapWidget widgetLabels;
    private LOTRGuiMapWidget widgetShareCWP;
    private LOTRGuiMapWidget widgetHideSWP;
    private LOTRGuiMapWidget widgetUnhideSWP;
    private float posX;
    private float posY;
    private int isMouseButtonDown;
    private int prevMouseX;
    private int prevMouseY;
    private boolean isMouseWithinMap;
    private int mouseXCoord;
    private int mouseZCoord;
    private float posXMove;
    private float posYMove;
    private float prevPosX;
    private float prevPosY;
    private static int zoomPower;
    private int prevZoomPower = zoomPower;
    private float zoomScale;
    private float zoomScaleStable;
    private float zoomExp;
    private static int zoomTicksMax;
    private int zoomTicks;
    public boolean enableZoomOutWPFading = true;
    private LOTRAbstractWaypoint selectedWaypoint;
    private static final int waypointSelectRange = 5;
    public static boolean showWP;
    public static boolean showCWP;
    public static boolean showHiddenSWP;
    private boolean hasOverlay;
    private String[] overlayLines;
    private GuiButton buttonOverlayFunction;
    private GuiTextField nameWPTextField;
    private boolean creatingWaypoint;
    private boolean creatingWaypointNew;
    private boolean deletingWaypoint;
    private boolean renamingWaypoint;
    private boolean sharingWaypoint;
    private boolean sharingWaypointNew;
    private LOTRGuiFellowships fellowshipDrawGUI;
    private LOTRFellowshipClient mouseOverRemoveSharedFellowship;
    private LOTRGuiScrollPane scrollPaneWPShares = new LOTRGuiScrollPane(9, 8);
    private List<UUID> displayedWPShareList;
    private static int maxDisplayedWPShares;
    private int displayedWPShares;
    public boolean isPlayerOp = false;
    private int tickCounter;
    private boolean hasControlZones = false;
    private LOTRFaction controlZoneFaction;
    private boolean mouseControlZone;
    private boolean mouseControlZoneReduced;
    private boolean isConquestGrid = false;
    private static final int conqBorderW = 8;
    private static final int conqBorderUp = 22;
    private static final int conqBorderDown = 54;
    private boolean loadingConquestGrid = false;
    private Map<LOTRFaction, List<LOTRConquestZone>> facConquestGrids = new HashMap<LOTRFaction, List<LOTRConquestZone>>();
    private Set<LOTRFaction> requestedFacGrids = new HashSet<LOTRFaction>();
    private Set<LOTRFaction> receivedFacGrids = new HashSet<LOTRFaction>();
    private int ticksUntilRequestFac = 40;
    private static final int REQUEST_FAC_WAIT = 40;
    private float highestViewedConqStr;
    private static final int conqKeyGrades = 10;
    public static final int CONQUEST_COLOR = 12255232;
    private static final int CONQUEST_COLOR_OPQ = -4521984;
    private static final int CONQUEST_COLOR_NO_EFFECT = 1973790;
    private static LOTRDimension.DimensionRegion currentRegion;
    private static LOTRDimension.DimensionRegion prevRegion;
    private static List<LOTRFaction> currentFactionList;
    private int currentFactionIndex = 0;
    private int prevFactionIndex = 0;
    private LOTRFaction conquestViewingFaction;
    private static Map<LOTRDimension.DimensionRegion, LOTRFaction> lastViewedRegions;
    private float currentFacScroll = 0.0f;
    private boolean isFacScrolling = false;
    private boolean wasMouseDown;
    private boolean mouseInFacScroll;
    private int facScrollWidth = 240;
    private int facScrollHeight = 14;
    private int facScrollX;
    private int facScrollY;
    private int facScrollBorder = 1;
    private int facScrollWidgetWidth = 17;
    private int facScrollWidgetHeight = 12;
    private GuiButton buttonConquestRegions;

    public static void addPlayerLocationInfo(GameProfile player, double x, double z) {
        if (player.isComplete()) {
            playerLocations.put(player.getId(), new PlayerLocationInfo(player, x, z));
        }
    }

    public static void clearPlayerLocations() {
        playerLocations.clear();
    }

    public LOTRGuiMap() {
        if (!LOTRGenLayerWorld.loadedBiomeImage()) {
            new LOTRGenLayerWorld();
        }
    }

    public LOTRGuiMap setConquestGrid() {
        this.isConquestGrid = true;
        return this;
    }

    public void setControlZone(LOTRFaction f) {
        this.hasControlZones = true;
        this.controlZoneFaction = f;
    }

    @Override
    public void initGui() {
        this.xSize = 256;
        this.ySize = 256;
        super.initGui();
        if (fullscreen) {
            int midX = this.width / 2;
            int d = 100;
            this.buttonMenuReturn.xPosition = midX - d - this.buttonMenuReturn.width;
            this.buttonMenuReturn.yPosition = 4;
        }
        if (this.isConquestGrid || this.hasControlZones) {
            this.buttonList.remove((Object)this.buttonMenuReturn);
        }
        this.setupMapWidgets();
        if (this.isConquestGrid) {
            this.loadingConquestGrid = true;
            this.setupMapDimensions();
            this.conquestViewingFaction = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getPledgeFaction();
            if (this.conquestViewingFaction == null) {
                this.conquestViewingFaction = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getViewingFaction();
            }
            prevRegion = currentRegion = this.conquestViewingFaction.factionRegion;
            currentFactionList = LOTRGuiMap.currentRegion.factionList;
            this.prevFactionIndex = this.currentFactionIndex = currentFactionList.indexOf((Object)this.conquestViewingFaction);
            lastViewedRegions.put(currentRegion, this.conquestViewingFaction);
            this.facScrollX = mapXMin;
            this.facScrollY = mapYMax + 8;
            this.setCurrentScrollFromFaction();
            this.buttonConquestRegions = new LOTRGuiButtonRedBook(200, mapXMax - 120, mapYMax + 5, 120, 20, "");
            this.buttonList.add(this.buttonConquestRegions);
        }
        if (this.hasControlZones) {
            this.setupMapDimensions();
            int[] zoneBorders = this.controlZoneFaction.calculateFullControlZoneWorldBorders();
            int xMin = zoneBorders[0];
            int xMax = zoneBorders[1];
            int zMin = zoneBorders[2];
            int zMax = zoneBorders[3];
            float x = (float)(xMin + xMax) / 2.0f;
            float z = (float)(zMin + zMax) / 2.0f;
            this.posX = x / (float)LOTRGenLayerWorld.scale + 810.0f;
            this.posY = z / (float)LOTRGenLayerWorld.scale + 730.0f;
            int zoneWidth = xMax - xMin;
            int zoneHeight = zMax - zMin;
            double mapZoneWidth = (double)zoneWidth / (double)LOTRGenLayerWorld.scale;
            double mapZoneHeight = (double)zoneHeight / (double)LOTRGenLayerWorld.scale;
            int zoomPowerWidth = MathHelper.floor_double((double)(Math.log((double)mapWidth / mapZoneWidth) / Math.log(2.0)));
            int zoomPowerHeight = MathHelper.floor_double((double)(Math.log((double)mapHeight / mapZoneHeight) / Math.log(2.0)));
            this.prevZoomPower = zoomPower = Math.min(zoomPowerWidth, zoomPowerHeight);
        } else if (this.mc.thePlayer != null) {
            this.posX = (float)(this.mc.thePlayer.posX / (double)LOTRGenLayerWorld.scale) + 810.0f;
            this.posY = (float)(this.mc.thePlayer.posZ / (double)LOTRGenLayerWorld.scale) + 730.0f;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.buttonOverlayFunction = new GuiButton(0, 0, 0, 160, 20, "");
        this.buttonOverlayFunction.visible = false;
        this.buttonOverlayFunction.enabled = false;
        this.buttonList.add(this.buttonOverlayFunction);
        this.nameWPTextField = new GuiTextField(this.fontRendererObj, mapXMin + mapWidth / 2 - 80, mapYMin + 50, 160, 20);
        this.fellowshipDrawGUI = new LOTRGuiFellowships();
        this.fellowshipDrawGUI.setWorldAndResolution(this.mc, this.width, this.height);
        if (this.mc.currentScreen == this) {
            LOTRPacketClientMQEvent packet = new LOTRPacketClientMQEvent(LOTRPacketClientMQEvent.ClientMQEvent.MAP);
            LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
        }
    }

    private void setupMapWidgets() {
        mapWidgets.clear();
        this.widgetAddCWP = new LOTRGuiMapWidget(-16, 6, 10, "addCWP", 0, 0);
        mapWidgets.add(this.widgetAddCWP);
        this.widgetDelCWP = new LOTRGuiMapWidget(-16, 20, 10, "delCWP", 10, 0);
        mapWidgets.add(this.widgetDelCWP);
        this.widgetRenameCWP = new LOTRGuiMapWidget(-16, 34, 10, "renameCWP", 0, 20);
        mapWidgets.add(this.widgetRenameCWP);
        this.widgetToggleWPs = new LOTRGuiMapWidget(-58, 6, 10, "toggleWPs", 80, 0);
        mapWidgets.add(this.widgetToggleWPs);
        this.widgetToggleCWPs = new LOTRGuiMapWidget(-44, 6, 10, "toggleCWPs", 90, 0);
        mapWidgets.add(this.widgetToggleCWPs);
        this.widgetToggleHiddenSWPs = new LOTRGuiMapWidget(-30, 6, 10, "toggleHiddenSWPs", 100, 0);
        mapWidgets.add(this.widgetToggleHiddenSWPs);
        this.widgetZoomIn = new LOTRGuiMapWidget(6, 6, 10, "zoomIn", 30, 0);
        mapWidgets.add(this.widgetZoomIn);
        this.widgetZoomOut = new LOTRGuiMapWidget(6, 20, 10, "zoomOut", 40, 0);
        mapWidgets.add(this.widgetZoomOut);
        this.widgetFullScreen = new LOTRGuiMapWidget(20, 6, 10, "fullScreen", 50, 0);
        mapWidgets.add(this.widgetFullScreen);
        this.widgetSepia = new LOTRGuiMapWidget(34, 6, 10, "sepia", 60, 0);
        mapWidgets.add(this.widgetSepia);
        this.widgetLabels = new LOTRGuiMapWidget(-72, 6, 10, "labels", 70, 0);
        mapWidgets.add(this.widgetLabels);
        this.widgetShareCWP = new LOTRGuiMapWidget(-16, 48, 10, "shareCWP", 10, 10);
        mapWidgets.add(this.widgetShareCWP);
        this.widgetHideSWP = new LOTRGuiMapWidget(-16, 20, 10, "hideSWP", 20, 0);
        mapWidgets.add(this.widgetHideSWP);
        this.widgetUnhideSWP = new LOTRGuiMapWidget(-16, 20, 10, "unhideSWP", 20, 10);
        mapWidgets.add(this.widgetUnhideSWP);
        if (this.isConquestGrid) {
            mapWidgets.clear();
            mapWidgets.add(this.widgetToggleWPs);
            mapWidgets.add(this.widgetToggleCWPs);
            mapWidgets.add(this.widgetToggleHiddenSWPs);
            mapWidgets.add(this.widgetZoomIn);
            mapWidgets.add(this.widgetZoomOut);
            mapWidgets.add(this.widgetLabels);
        }
    }

    private void setupMapDimensions() {
        if (this.isConquestGrid) {
            int windowWidth = 400;
            int windowHeight = 240;
            mapXMin = this.width / 2 - windowWidth / 2;
            mapXMax = this.width / 2 + windowWidth / 2;
            mapYMin = this.height / 2 - 16 - windowHeight / 2;
            mapYMax = mapYMin + windowHeight;
        } else if (fullscreen) {
            mapXMin = 30;
            mapXMax = this.width - 30;
            mapYMin = 30;
            mapYMax = this.height - 30;
        } else {
            int windowWidth = 312;
            mapXMin = this.width / 2 - windowWidth / 2;
            mapXMax = this.width / 2 + windowWidth / 2;
            mapYMin = this.guiTop;
            mapYMax = this.guiTop + 200;
        }
        mapWidth = mapXMax - mapXMin;
        mapHeight = mapYMax - mapYMin;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.tickCounter;
        if (this.zoomTicks > 0) {
            --this.zoomTicks;
        }
        if (this.creatingWaypointNew || this.renamingWaypoint || this.sharingWaypointNew) {
            this.nameWPTextField.updateCursorCounter();
        }
        this.handleMapKeyboardMovement();
        if (this.isConquestGrid) {
            this.updateCurrentDimensionAndFaction();
            if (this.ticksUntilRequestFac > 0) {
                --this.ticksUntilRequestFac;
            }
        }
    }

    private void updateCurrentDimensionAndFaction() {
        if (this.currentFactionIndex != this.prevFactionIndex) {
            this.conquestViewingFaction = currentFactionList.get(this.currentFactionIndex);
            this.ticksUntilRequestFac = 40;
        }
        this.prevFactionIndex = this.currentFactionIndex;
        if (currentRegion != prevRegion) {
            lastViewedRegions.put(prevRegion, this.conquestViewingFaction);
            currentFactionList = LOTRGuiMap.currentRegion.factionList;
            this.conquestViewingFaction = lastViewedRegions.containsKey((Object)currentRegion) ? lastViewedRegions.get((Object)currentRegion) : LOTRGuiMap.currentRegion.factionList.get(0);
            this.prevFactionIndex = this.currentFactionIndex = currentFactionList.indexOf((Object)this.conquestViewingFaction);
            this.ticksUntilRequestFac = 40;
        }
        prevRegion = currentRegion;
    }

    public void setupZoomVariables(float f) {
        this.zoomExp = zoomPower;
        if (this.zoomTicks > 0) {
            float progress = ((float)zoomTicksMax - ((float)this.zoomTicks - f)) / (float)zoomTicksMax;
            this.zoomExp = (float)this.prevZoomPower + (float)(zoomPower - this.prevZoomPower) * progress;
        }
        this.zoomScale = (float)Math.pow(2.0, this.zoomExp);
        this.zoomScaleStable = (float)Math.pow(2.0, this.zoomTicks == 0 ? zoomPower : Math.min(zoomPower, this.prevZoomPower));
    }

    public void drawScreen(int i, int j, float f) {
        String s;
        int y;
        boolean isSepia;
        int x;
        Tessellator tess = Tessellator.instance;
        this.zLevel = 0.0f;
        this.setupMapDimensions();
        this.setupZoomVariables(f);
        if (this.isConquestGrid) {
            this.loadingConquestGrid = !this.receivedFacGrids.contains((Object)this.conquestViewingFaction);
            this.highestViewedConqStr = 0.0f;
            this.setupConquestScrollBar(i, j);
            this.buttonConquestRegions.displayString = currentRegion.getRegionName();
            this.buttonConquestRegions.enabled = true;
            this.buttonConquestRegions.visible = true;
        }
        this.posX = this.prevPosX;
        this.posY = this.prevPosY;
        boolean bl = this.isMouseWithinMap = i >= mapXMin && i < mapXMax && j >= mapYMin && j < mapYMax;
        if (!this.hasOverlay && !this.isFacScrolling && this.zoomTicks == 0 && Mouse.isButtonDown((int)0)) {
            if ((this.isMouseButtonDown == 0 || this.isMouseButtonDown == 1) && this.isMouseWithinMap) {
                if (this.isMouseButtonDown == 0) {
                    this.isMouseButtonDown = 1;
                } else {
                    float x2 = (float)(i - this.prevMouseX) / this.zoomScale;
                    float y2 = (float)(j - this.prevMouseY) / this.zoomScale;
                    this.posX -= x2;
                    this.posY -= y2;
                    if (x2 != 0.0f || y2 != 0.0f) {
                        this.selectedWaypoint = null;
                    }
                }
                this.prevMouseX = i;
                this.prevMouseY = j;
            }
        } else {
            this.isMouseButtonDown = 0;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.posX += this.posXMove * f;
        this.posY += this.posYMove * f;
        boolean bl2 = isSepia = this.isConquestGrid || LOTRConfig.enableSepiaMap;
        if (this.isConquestGrid) {
            this.drawDefaultBackground();
        }
        if (fullscreen || this.isConquestGrid) {
            this.mc.getTextureManager().bindTexture(LOTRTextures.overlayTexture);
            if (this.conquestViewingFaction != null) {
                float[] cqColors = this.conquestViewingFaction.getFactionRGB();
                GL11.glColor4f((float)cqColors[0], (float)cqColors[1], (float)cqColors[2], (float)1.0f);
            } else {
                GL11.glColor4f((float)0.65f, (float)0.5f, (float)0.35f, (float)1.0f);
            }
            tess.startDrawingQuads();
            if (this.isConquestGrid) {
                int w = 8;
                int up = 22;
                int down = 54;
                tess.addVertexWithUV((double)(mapXMin - w), (double)(mapYMax + down), (double)this.zLevel, 0.0, 1.0);
                tess.addVertexWithUV((double)(mapXMax + w), (double)(mapYMax + down), (double)this.zLevel, 1.0, 1.0);
                tess.addVertexWithUV((double)(mapXMax + w), (double)(mapYMin - up), (double)this.zLevel, 1.0, 0.0);
                tess.addVertexWithUV((double)(mapXMin - w), (double)(mapYMin - up), (double)this.zLevel, 0.0, 0.0);
            } else {
                tess.addVertexWithUV(0.0, (double)this.height, (double)this.zLevel, 0.0, 1.0);
                tess.addVertexWithUV((double)this.width, (double)this.height, (double)this.zLevel, 1.0, 1.0);
                tess.addVertexWithUV((double)this.width, 0.0, (double)this.zLevel, 1.0, 0.0);
                tess.addVertexWithUV(0.0, 0.0, (double)this.zLevel, 0.0, 0.0);
            }
            tess.draw();
            int redW = this.isConquestGrid ? 2 : 4;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.renderGraduatedRects(mapXMin - 1, mapYMin - 1, mapXMax + 1, mapYMax + 1, -6156032, -16777216, redW);
        } else {
            this.drawDefaultBackground();
            this.renderGraduatedRects(mapXMin - 1, mapYMin - 1, mapXMax + 1, mapYMax + 1, -6156032, -16777216, 4);
        }
        this.setupScrollBars(i, j);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int oceanColor = LOTRTextures.getMapOceanColor(isSepia);
        LOTRGuiMap.drawRect((int)mapXMin, (int)mapYMin, (int)mapXMax, (int)mapYMax, (int)oceanColor);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (!this.isConquestGrid) {
            String title = StatCollector.translateToLocal((String)"lotr.gui.map.title");
            if (fullscreen) {
                this.drawCenteredString(title, this.width / 2, 10, 16777215);
            } else {
                this.drawCenteredString(title, this.width / 2, this.guiTop - 30, 16777215);
            }
        }
        if (this.hasControlZones && LOTRFaction.controlZonesEnabled((World)this.mc.theWorld)) {
            this.renderMapAndOverlay(isSepia, 1.0f, false);
            this.renderControlZone(i, j);
            GL11.glEnable((int)3042);
            this.renderMapAndOverlay(isSepia, 0.5f, true);
            GL11.glDisable((int)3042);
            String tooltip = null;
            if (this.mouseControlZone) {
                tooltip = StatCollector.translateToLocal((String)"lotr.gui.map.controlZoneFull");
            } else if (this.mouseControlZoneReduced) {
                tooltip = StatCollector.translateToLocal((String)"lotr.gui.map.controlZoneReduced");
            }
            if (tooltip != null) {
                int strWidth = this.mc.fontRenderer.getStringWidth(tooltip);
                int strHeight = this.mc.fontRenderer.FONT_HEIGHT;
                int rectX = i + 12;
                int rectY = j - 12;
                int border = 3;
                int rectWidth = strWidth + border * 2;
                int rectHeight = strHeight + border * 2;
                int mapBorder2 = 2;
                rectX = Math.max(rectX, mapXMin + mapBorder2);
                rectX = Math.min(rectX, mapXMax - mapBorder2 - rectWidth);
                rectY = Math.max(rectY, mapYMin + mapBorder2);
                rectY = Math.min(rectY, mapYMax - mapBorder2 - rectHeight);
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)300.0f);
                this.drawFancyRect(rectX, rectY, rectX + rectWidth, rectY + rectHeight);
                this.mc.fontRenderer.drawString(tooltip, rectX + border, rectY + border, 16777215);
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-300.0f);
            }
        } else {
            this.renderMapAndOverlay(isSepia, 1.0f, true);
            if (this.isConquestGrid && this.conquestViewingFaction != null) {
                this.requestConquestGridIfNeed(this.conquestViewingFaction);
                if (!this.loadingConquestGrid) {
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    this.setupMapClipping();
                    float alphaFunc = GL11.glGetFloat((int)3010);
                    GL11.glAlphaFunc((int)516, (float)0.005f);
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                    ArrayList allZones = (ArrayList)this.facConquestGrids.get((Object)this.conquestViewingFaction);
                    if (allZones == null) {
                        allZones = new ArrayList();
                    }
                    ArrayList<LOTRConquestZone> zonesInView = new ArrayList<LOTRConquestZone>();
                    this.highestViewedConqStr = 0.0f;
                    float mouseOverStr = 0.0f;
                    LOTRConquestZone mouseOverZone = null;
                    LOTRConquestGrid.ConquestEffective mouseOverEffect = null;
                    for (int pass = 0; pass <= 1; ++pass) {
                        if (pass == 1 && !(this.highestViewedConqStr > 0.0f)) continue;
                        ArrayList<LOTRConquestZone> zoneList = pass == 0 ? allZones : zonesInView;
                        for (LOTRConquestZone zone : zoneList) {
                            float strength = zone.getConquestStrength(this.conquestViewingFaction, (World)this.mc.theWorld);
                            int[] min = LOTRConquestGrid.getMinCoordsOnMap(zone);
                            int[] max = LOTRConquestGrid.getMaxCoordsOnMap(zone);
                            float[] minF = this.transformMapCoords(min[0], min[1]);
                            float[] maxF = this.transformMapCoords(max[0], max[1]);
                            float minX = minF[0];
                            float maxX = maxF[0];
                            float minY = minF[1];
                            float maxY = maxF[1];
                            if (!(maxX >= (float)mapXMin) || !(minX <= (float)mapXMax) || !(maxY >= (float)mapYMin) || !(minY <= (float)mapYMax)) continue;
                            if (pass == 0) {
                                if (strength > this.highestViewedConqStr) {
                                    this.highestViewedConqStr = strength;
                                }
                                zonesInView.add(zone);
                                continue;
                            }
                            if (pass != 1 || !(strength > 0.0f)) continue;
                            float strFrac = strength / this.highestViewedConqStr;
                            float strAlpha = strFrac = MathHelper.clamp_float((float)strFrac, (float)0.0f, (float)1.0f);
                            if (strength > 0.0f) {
                                strAlpha = Math.max(strAlpha, 0.1f);
                            }
                            LOTRConquestGrid.ConquestEffective effect = LOTRConquestGrid.getConquestEffectIn((World)this.mc.theWorld, zone, this.conquestViewingFaction);
                            int zoneColor = 0xBB0000 | Math.round(strAlpha * 255.0f) << 24;
                            if (effect == LOTRConquestGrid.ConquestEffective.EFFECTIVE) {
                                LOTRGuiMap.drawFloatRect(minX, minY, maxX, maxY, zoneColor);
                            } else {
                                int zoneColor2 = 0x1E1E1E | Math.round(strAlpha * 255.0f) << 24;
                                if (effect == LOTRConquestGrid.ConquestEffective.ALLY_BOOST) {
                                    float zoneYSize = maxY - minY;
                                    int strips = 8;
                                    for (int l = 0; l < strips; ++l) {
                                        float stripYSize = zoneYSize / (float)strips;
                                        LOTRGuiMap.drawFloatRect(minX, minY + stripYSize * (float)l, maxX, minY + stripYSize * (float)(l + 1), l % 2 == 0 ? zoneColor : zoneColor2);
                                    }
                                } else if (effect == LOTRConquestGrid.ConquestEffective.NO_EFFECT) {
                                    LOTRGuiMap.drawFloatRect(minX, minY, maxX, maxY, zoneColor2);
                                }
                            }
                            if (!((float)i >= minX) || !((float)i < maxX) || !((float)j >= minY) || !((float)j < maxY)) continue;
                            mouseOverStr = strength;
                            mouseOverZone = zone;
                            mouseOverEffect = effect;
                        }
                    }
                    GL11.glAlphaFunc((int)516, (float)alphaFunc);
                    if (mouseOverZone != null && i >= mapXMin && i < mapXMax && j >= mapYMin && j < mapYMax) {
                        int[] min = LOTRConquestGrid.getMinCoordsOnMap(mouseOverZone);
                        int[] max = LOTRConquestGrid.getMaxCoordsOnMap(mouseOverZone);
                        float[] minF = this.transformMapCoords(min[0], min[1]);
                        float[] maxF = this.transformMapCoords(max[0], max[1]);
                        float minX = minF[0];
                        float maxX = maxF[0];
                        float minY = minF[1];
                        float maxY = maxF[1];
                        LOTRGuiMap.drawFloatRect(minX - 1.0f, minY - 1.0f, maxX + 1.0f, minY, -16777216);
                        LOTRGuiMap.drawFloatRect(minX - 1.0f, maxY, maxX + 1.0f, maxY + 1.0f, -16777216);
                        LOTRGuiMap.drawFloatRect(minX - 1.0f, minY, minX, maxY, -16777216);
                        LOTRGuiMap.drawFloatRect(maxX, minY, maxX + 1.0f, maxY, -16777216);
                        LOTRGuiMap.drawFloatRect(minX - 2.0f, minY - 2.0f, maxX + 2.0f, minY - 1.0f, -4521984);
                        LOTRGuiMap.drawFloatRect(minX - 2.0f, maxY + 1.0f, maxX + 2.0f, maxY + 2.0f, -4521984);
                        LOTRGuiMap.drawFloatRect(minX - 2.0f, minY - 1.0f, minX - 1.0f, maxY + 1.0f, -4521984);
                        LOTRGuiMap.drawFloatRect(maxX + 1.0f, minY - 1.0f, maxX + 2.0f, maxY + 1.0f, -4521984);
                        String tooltip = LOTRAlignmentValues.formatConqForDisplay(mouseOverStr, false);
                        String subtip = null;
                        if (mouseOverEffect == LOTRConquestGrid.ConquestEffective.ALLY_BOOST) {
                            subtip = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.conquest.allyBoost", (Object[])new Object[]{this.conquestViewingFaction.factionName()});
                        } else if (mouseOverEffect == LOTRConquestGrid.ConquestEffective.NO_EFFECT) {
                            subtip = StatCollector.translateToLocal((String)"lotr.gui.map.conquest.noEffect");
                        }
                        int strWidth = this.mc.fontRenderer.getStringWidth(tooltip);
                        int subWidth = subtip == null ? 0 : this.mc.fontRenderer.getStringWidth(subtip);
                        int strHeight = this.mc.fontRenderer.FONT_HEIGHT;
                        float guiScale = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight).getScaleFactor();
                        float subScale = guiScale <= 2.0f ? guiScale : guiScale - 1.0f;
                        float subScaleRel = subScale / guiScale;
                        int rectX = i + 12;
                        int rectY = j - 12;
                        int border = 3;
                        int iconSize = 16;
                        int rectWidth = border * 2 + Math.max(strWidth + iconSize + border, (int)((float)subWidth * subScaleRel));
                        int rectHeight = Math.max(strHeight, iconSize) + border * 2;
                        if (subtip != null) {
                            rectHeight += border + (int)((float)strHeight * subScaleRel);
                        }
                        int mapBorder2 = 2;
                        rectX = Math.max(rectX, mapXMin + mapBorder2);
                        rectX = Math.min(rectX, mapXMax - mapBorder2 - rectWidth);
                        rectY = Math.max(rectY, mapYMin + mapBorder2);
                        rectY = Math.min(rectY, mapYMax - mapBorder2 - rectHeight);
                        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)300.0f);
                        this.drawFancyRect(rectX, rectY, rectX + rectWidth, rectY + rectHeight);
                        this.mc.getTextureManager().bindTexture(LOTRClientProxy.alignmentTexture);
                        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                        this.drawTexturedModalRect(rectX + border, rectY + border, 0, 228, iconSize, iconSize);
                        this.mc.fontRenderer.drawString(tooltip, rectX + iconSize + border * 2, rectY + border + (iconSize - strHeight) / 2, 16777215);
                        if (subtip != null) {
                            GL11.glPushMatrix();
                            GL11.glScalef((float)subScaleRel, (float)subScaleRel, (float)1.0f);
                            int subX = rectX + border;
                            int subY = rectY + border * 2 + iconSize;
                            this.mc.fontRenderer.drawString(subtip, Math.round((float)subX / subScaleRel), Math.round((float)subY / subScaleRel), 16777215);
                            GL11.glPopMatrix();
                        }
                        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-300.0f);
                    }
                    this.endMapClipping();
                    GL11.glDisable((int)3042);
                }
            }
        }
        this.zLevel += 50.0f;
        LOTRTextures.drawMapCompassBottomLeft(mapXMin + 12, mapYMax - 12, this.zLevel, 1.0);
        this.zLevel -= 50.0f;
        this.renderRoads();
        this.renderPlayers(i, j);
        if (!this.loadingConquestGrid) {
            this.renderMiniQuests((EntityPlayer)this.mc.thePlayer, i, j);
        }
        this.renderWaypoints(0, i, j);
        this.renderLabels();
        this.renderWaypoints(1, i, j);
        if (!this.loadingConquestGrid && this.selectedWaypoint != null && this.isWaypointVisible(this.selectedWaypoint)) {
            if (!this.hasOverlay) {
                this.renderWaypointTooltip(this.selectedWaypoint, true, i, j);
            }
        } else {
            this.selectedWaypoint = null;
        }
        if (this.isConquestGrid) {
            if (this.loadingConquestGrid) {
                LOTRGuiMap.drawRect((int)mapXMin, (int)mapYMin, (int)mapXMax, (int)mapYMax, (int)-1429949539);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                this.mc.getTextureManager().bindTexture(LOTRTextures.overlayTexture);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.2f);
                tess.startDrawingQuads();
                tess.addVertexWithUV((double)mapXMin, (double)mapYMax, 0.0, 0.0, 1.0);
                tess.addVertexWithUV((double)mapXMax, (double)mapYMax, 0.0, 1.0, 1.0);
                tess.addVertexWithUV((double)mapXMax, (double)mapYMin, 0.0, 1.0, 0.0);
                tess.addVertexWithUV((double)mapXMin, (double)mapYMin, 0.0, 0.0, 0.0);
                tess.draw();
                String loadText = "";
                LOTRConquestGrid.ConquestViewableQuery query = LOTRConquestGrid.canPlayerViewConquest((EntityPlayer)this.mc.thePlayer, this.conquestViewingFaction);
                if (query.result == LOTRConquestGrid.ConquestViewable.CAN_VIEW) {
                    loadText = StatCollector.translateToLocal((String)"lotr.gui.map.conquest.wait");
                    int ellipsis = 1 + this.tickCounter / 10 % 3;
                    for (int l = 0; l < ellipsis; ++l) {
                        loadText = loadText + ".";
                    }
                } else if (query.result == LOTRConquestGrid.ConquestViewable.UNPLEDGED) {
                    loadText = StatCollector.translateToLocal((String)"lotr.gui.map.conquest.noPledge");
                } else {
                    LOTRPlayerData pd = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer);
                    LOTRFaction pledgeFac = pd.getPledgeFaction();
                    LOTRFactionRank needRank = query.needRank;
                    String needAlign = LOTRAlignmentValues.formatAlignForDisplay(needRank.alignment);
                    String format = "";
                    if (query.result == LOTRConquestGrid.ConquestViewable.NEED_RANK) {
                        format = "lotr.gui.map.conquest.needRank";
                    }
                    loadText = StatCollector.translateToLocalFormatted((String)format, (Object[])new Object[]{pledgeFac.factionName(), needRank.getFullNameWithGender(pd), needAlign});
                }
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                int stringWidth = 250;
                String[] splitNewline = loadText.split(Pattern.quote("\\n"));
                ArrayList<String> loadLines = new ArrayList();
                for (String line : splitNewline) {
                    loadLines.addAll(this.fontRendererObj.listFormattedStringToWidth(line, stringWidth));
                }
                int stringX = mapXMin + mapWidth / 2;
                int stringY = (mapYMin + mapYMax) / 2 - loadLines.size() * this.fontRendererObj.FONT_HEIGHT / 2;
                for (String s2 : loadLines) {
                    this.drawCenteredString(s2, stringX, stringY, 3748142);
                    stringY += this.fontRendererObj.FONT_HEIGHT;
                }
                GL11.glDisable((int)3042);
            }
            this.mc.getTextureManager().bindTexture(conquestTexture);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.drawTexturedModalRect(mapXMin - 8, mapYMin - 22, 0, 0, mapWidth + 16, mapHeight + 22 + 54, 512);
        }
        this.zLevel = 100.0f;
        if (!this.hasOverlay) {
            if (this.isMiddleEarth() && this.selectedWaypoint != null) {
                this.zLevel += 500.0f;
                LOTRPlayerData pd = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer);
                boolean hasUnlocked = this.selectedWaypoint.hasPlayerUnlocked((EntityPlayer)this.mc.thePlayer);
                int ftSince = pd.getTimeSinceFT();
                int wpTimeThreshold = pd.getWaypointFTTime(this.selectedWaypoint, (EntityPlayer)this.mc.thePlayer);
                int timeRemaining = wpTimeThreshold - ftSince;
                boolean canFastTravel = hasUnlocked && timeRemaining <= 0;
                String notUnlocked = "If you can read this, something has gone hideously wrong";
                if (this.selectedWaypoint instanceof LOTRCustomWaypoint) {
                    LOTRCustomWaypoint cwp = (LOTRCustomWaypoint)this.selectedWaypoint;
                    if (cwp.isShared()) {
                        notUnlocked = StatCollector.translateToLocal((String)"lotr.gui.map.locked.shared");
                    }
                } else {
                    LOTRWaypoint wp = (LOTRWaypoint)this.selectedWaypoint;
                    notUnlocked = !wp.isCompatibleAlignment((EntityPlayer)this.mc.thePlayer) ? StatCollector.translateToLocal((String)"lotr.gui.map.locked.enemy") : StatCollector.translateToLocal((String)"lotr.gui.map.locked.region");
                }
                String conquestUnlock = pd.getPledgeFaction() == null ? "" : StatCollector.translateToLocalFormatted((String)"lotr.gui.map.locked.conquerable", (Object[])new Object[]{pd.getPledgeFaction().factionName()});
                String ftPrompt = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.fastTravel.prompt", (Object[])new Object[]{GameSettings.getKeyDisplayString((int)LOTRKeyHandler.keyBindingFastTravel.getKeyCode())});
                String ftMoreTime = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.fastTravel.moreTime", (Object[])new Object[]{LOTRLevelData.getHMSTime_Ticks(timeRemaining)});
                String ftWaitTime = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.fastTravel.waitTime", (Object[])new Object[]{LOTRLevelData.getHMSTime_Ticks(wpTimeThreshold)});
                if (fullscreen || this.isConquestGrid) {
                    if (!hasUnlocked) {
                        if (this.selectedWaypoint instanceof LOTRWaypoint && ((LOTRWaypoint)this.selectedWaypoint).isConquestUnlockable((EntityPlayer)this.mc.thePlayer)) {
                            this.renderFullscreenSubtitles(notUnlocked, conquestUnlock);
                        } else {
                            this.renderFullscreenSubtitles(notUnlocked);
                        }
                    } else if (canFastTravel) {
                        this.renderFullscreenSubtitles(ftPrompt, ftWaitTime);
                    } else {
                        this.renderFullscreenSubtitles(ftMoreTime, ftWaitTime);
                    }
                } else {
                    ArrayList<String> lines = new ArrayList<String>();
                    if (!hasUnlocked) {
                        lines.add(notUnlocked);
                        if (this.selectedWaypoint instanceof LOTRWaypoint && ((LOTRWaypoint)this.selectedWaypoint).isConquestUnlockable((EntityPlayer)this.mc.thePlayer)) {
                            lines.add(conquestUnlock);
                        }
                    } else if (canFastTravel) {
                        lines.add(ftPrompt);
                        lines.add(ftWaitTime);
                    } else {
                        lines.add(ftMoreTime);
                        lines.add(ftWaitTime);
                    }
                    int stringHeight = this.fontRendererObj.FONT_HEIGHT;
                    int rectWidth = mapWidth;
                    int border = 3;
                    int rectHeight = border + (stringHeight + border) * lines.size();
                    int x3 = mapXMin + mapWidth / 2 - rectWidth / 2;
                    int y3 = mapYMax + 10;
                    int strX = mapXMin + mapWidth / 2;
                    int strY = y3 + border;
                    this.drawFancyRect(x3, y3, x3 + rectWidth, y3 + rectHeight);
                    for (String s3 : lines) {
                        this.drawCenteredString(s3, strX, strY, 16777215);
                        strY += stringHeight + border;
                    }
                }
                this.zLevel -= 500.0f;
            } else if (this.isMouseWithinMap) {
                int biomePosZ_int;
                this.zLevel += 500.0f;
                float biomePosX = this.posX + (float)(i - mapXMin - mapWidth / 2) / this.zoomScale;
                float biomePosZ = this.posY + (float)(j - mapYMin - mapHeight / 2) / this.zoomScale;
                int biomePosX_int = MathHelper.floor_double((double)biomePosX);
                LOTRBiome biome = LOTRGenLayerWorld.getBiomeOrOcean(biomePosX_int, biomePosZ_int = MathHelper.floor_double((double)biomePosZ));
                if (biome.isHiddenBiome() && !LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).hasAchievement(biome.getBiomeAchievement())) {
                    biome = LOTRBiome.ocean;
                }
                this.mouseXCoord = Math.round((biomePosX - 810.0f) * (float)LOTRGenLayerWorld.scale);
                this.mouseZCoord = Math.round((biomePosZ - 730.0f) * (float)LOTRGenLayerWorld.scale);
                String biomeName = biome.getBiomeDisplayName();
                String coords = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.coords", (Object[])new Object[]{this.mouseXCoord, this.mouseZCoord});
                String teleport = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.tp", (Object[])new Object[]{GameSettings.getKeyDisplayString((int)LOTRKeyHandler.keyBindingMapTeleport.getKeyCode())});
                int stringHeight = this.fontRendererObj.FONT_HEIGHT;
                if (fullscreen || this.isConquestGrid) {
                    this.renderFullscreenSubtitles(biomeName, coords);
                    if (this.canTeleport()) {
                        GL11.glPushMatrix();
                        if (this.isConquestGrid) {
                            GL11.glTranslatef((float)((mapXMax - mapXMin) / 2 - 8 - this.fontRendererObj.getStringWidth(teleport) / 2), (float)0.0f, (float)0.0f);
                        } else {
                            GL11.glTranslatef((float)(this.width / 2 - 30 - this.fontRendererObj.getStringWidth(teleport) / 2), (float)0.0f, (float)0.0f);
                        }
                        this.renderFullscreenSubtitles(teleport);
                        GL11.glPopMatrix();
                    }
                } else {
                    int rectWidth = mapWidth;
                    int border = 3;
                    int rectHeight = border * 3 + stringHeight * 2;
                    if (this.canTeleport()) {
                        rectHeight += (stringHeight + border) * 2;
                    }
                    int x4 = mapXMin + mapWidth / 2 - rectWidth / 2;
                    int y4 = mapYMax + 10;
                    this.drawFancyRect(x4, y4, x4 + rectWidth, y4 + rectHeight);
                    int strX = mapXMin + mapWidth / 2;
                    int strY = y4 + border;
                    this.drawCenteredString(biomeName, strX, strY, 16777215);
                    this.drawCenteredString(coords, strX, strY += stringHeight + border, 16777215);
                    if (this.canTeleport()) {
                        this.drawCenteredString(teleport, strX, strY + (stringHeight + border) * 2, 16777215);
                    }
                }
                this.zLevel -= 500.0f;
            }
        }
        if (this.isConquestGrid) {
            s = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.conquest.title", (Object[])new Object[]{this.conquestViewingFaction.factionName()});
            x = mapXMin + mapWidth / 2;
            y = mapYMin - 14;
            LOTRTickHandlerClient.drawAlignmentText(this.fontRendererObj, x - this.fontRendererObj.getStringWidth(s) / 2, y, s, 1.0f);
            if (!this.loadingConquestGrid) {
                int keyBorder = 8;
                int keyWidth = 24;
                int keyHeight = 12;
                int iconSize = 16;
                int iconGap = keyBorder / 2;
                float guiScale = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight).getScaleFactor();
                float labelScale = guiScale <= 2.0f ? guiScale : guiScale - 1.0f;
                float labelScaleRel = labelScale / guiScale;
                this.mc.getTextureManager().bindTexture(LOTRClientProxy.alignmentTexture);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.drawTexturedModalRect(mapXMax - keyBorder - iconSize, mapYMax - keyBorder - iconSize, 0, 228, iconSize, iconSize);
                for (int pass = 0; pass <= 1; ++pass) {
                    for (int l = 0; l <= 10; ++l) {
                        float frac = (float)(10 - l) / 10.0f;
                        float strFrac = frac * this.highestViewedConqStr;
                        int x1 = mapXMax - keyBorder - iconSize - iconGap - l * keyWidth;
                        int x0 = x1 - keyWidth;
                        int y1 = mapYMax - keyBorder - (iconSize - keyHeight) / 2;
                        int y0 = y1 - keyHeight;
                        if (pass == 0) {
                            int color = 0xBB0000 | Math.round(frac * 255.0f) << 24;
                            LOTRGuiMap.drawRect((int)x0, (int)y0, (int)x1, (int)y1, (int)color);
                            continue;
                        }
                        if (pass != 1 || l % 2 != 0) continue;
                        String keyLabel = LOTRAlignmentValues.formatConqForDisplay(strFrac, false);
                        int strX = (int)((float)(x0 + keyWidth / 2) / labelScaleRel);
                        int strY = (int)((float)(y0 + keyHeight / 2) / labelScaleRel) - this.fontRendererObj.FONT_HEIGHT / 2;
                        GL11.glPushMatrix();
                        GL11.glScalef((float)labelScaleRel, (float)labelScaleRel, (float)1.0f);
                        this.drawCenteredString(keyLabel, strX, strY, 16777215);
                        GL11.glPopMatrix();
                    }
                }
            }
            if (this.hasConquestScrollBar()) {
                this.mc.getTextureManager().bindTexture(LOTRGuiFactions.factionsTexture);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.drawTexturedModalRect(this.facScrollX, this.facScrollY, 0, 128, this.facScrollWidth, this.facScrollHeight);
                int factions = currentFactionList.size();
                for (int index = 0; index < factions; ++index) {
                    LOTRFaction faction = currentFactionList.get(index);
                    float[] factionColors = faction.getFactionRGB();
                    float shade = 0.6f;
                    GL11.glColor4f((float)(factionColors[0] * shade), (float)(factionColors[1] * shade), (float)(factionColors[2] * shade), (float)1.0f);
                    float xMin = (float)index / (float)factions;
                    float xMax = (float)(index + 1) / (float)factions;
                    xMin = (float)(this.facScrollX + this.facScrollBorder) + xMin * (float)(this.facScrollWidth - this.facScrollBorder * 2);
                    xMax = (float)(this.facScrollX + this.facScrollBorder) + xMax * (float)(this.facScrollWidth - this.facScrollBorder * 2);
                    float yMin = this.facScrollY + this.facScrollBorder;
                    float yMax = this.facScrollY + this.facScrollHeight - this.facScrollBorder;
                    float minU = (float)(0 + this.facScrollBorder) / 256.0f;
                    float maxU = (float)(0 + this.facScrollWidth - this.facScrollBorder) / 256.0f;
                    float minV = (float)(128 + this.facScrollBorder) / 256.0f;
                    float maxV = (float)(128 + this.facScrollHeight - this.facScrollBorder) / 256.0f;
                    tess.startDrawingQuads();
                    tess.addVertexWithUV((double)xMin, (double)yMax, (double)this.zLevel, (double)minU, (double)maxV);
                    tess.addVertexWithUV((double)xMax, (double)yMax, (double)this.zLevel, (double)maxU, (double)maxV);
                    tess.addVertexWithUV((double)xMax, (double)yMin, (double)this.zLevel, (double)maxU, (double)minV);
                    tess.addVertexWithUV((double)xMin, (double)yMin, (double)this.zLevel, (double)minU, (double)minV);
                    tess.draw();
                }
                this.mc.getTextureManager().bindTexture(LOTRGuiFactions.factionsTexture);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                int scroll = (int)(this.currentFacScroll * (float)(this.facScrollWidth - this.facScrollBorder * 2 - this.facScrollWidgetWidth));
                this.drawTexturedModalRect(this.facScrollX + this.facScrollBorder + scroll, this.facScrollY + this.facScrollBorder, 0, 142, this.facScrollWidgetWidth, this.facScrollWidgetHeight);
            }
        }
        if (!this.hasOverlay && this.hasControlZones) {
            s = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.controlZones", (Object[])new Object[]{this.controlZoneFaction.factionName()});
            x = mapXMin + mapWidth / 2;
            y = mapYMin + 20;
            LOTRTickHandlerClient.drawAlignmentText(this.fontRendererObj, x - this.fontRendererObj.getStringWidth(s) / 2, y, s, 1.0f);
            if (!LOTRFaction.controlZonesEnabled((World)this.mc.theWorld)) {
                s = StatCollector.translateToLocal((String)"lotr.gui.map.controlZonesDisabled");
                LOTRTickHandlerClient.drawAlignmentText(this.fontRendererObj, x - this.fontRendererObj.getStringWidth(s) / 2, mapYMin + mapHeight / 2, s, 1.0f);
            }
        }
        boolean buttonVisible = this.buttonOverlayFunction.visible;
        this.buttonOverlayFunction.visible = false;
        super.drawScreen(i, j, f);
        this.buttonOverlayFunction.visible = buttonVisible;
        this.renderMapWidgets(i, j);
        if (this.hasOverlay) {
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)500.0f);
            int overlayBorder = 10;
            if (fullscreen) {
                overlayBorder = 40;
            }
            int rectX0 = mapXMin + overlayBorder;
            int rectY0 = mapYMin + overlayBorder;
            int rectX1 = mapXMax - overlayBorder;
            int rectY1 = mapYMax - overlayBorder;
            this.drawFancyRect(rectX0, rectY0, rectX1, rectY1);
            if (this.overlayLines != null) {
                int stringX = mapXMin + mapWidth / 2;
                int stringY = rectY0 + 3 + this.mc.fontRenderer.FONT_HEIGHT;
                int stringWidth = (int)((float)(mapWidth - overlayBorder * 2) * 0.75f);
                ArrayList<String> displayLines = new ArrayList();
                for (String s4 : this.overlayLines) {
                    displayLines.addAll(this.fontRendererObj.listFormattedStringToWidth(s4, stringWidth));
                }
                for (String s5 : displayLines) {
                    this.drawCenteredString(s5, stringX, stringY, 16777215);
                    stringY += this.mc.fontRenderer.FONT_HEIGHT;
                }
                stringY += this.mc.fontRenderer.FONT_HEIGHT;
                if (this.sharingWaypoint) {
                    this.fellowshipDrawGUI.clearMouseOverFellowship();
                    this.mouseOverRemoveSharedFellowship = null;
                    int iconWidth = 8;
                    int iconGap = 8;
                    int fullWidth = this.fellowshipDrawGUI.xSize + iconGap + iconWidth;
                    int fsX = mapXMin + mapWidth / 2 - fullWidth / 2;
                    int fsY = stringY;
                    this.scrollPaneWPShares.paneX0 = fsX;
                    this.scrollPaneWPShares.scrollBarX0 = fsX + fullWidth + 2 + 2;
                    this.scrollPaneWPShares.paneY0 = fsY;
                    this.scrollPaneWPShares.paneY1 = fsY + (this.mc.fontRenderer.FONT_HEIGHT + 5) * this.displayedWPShares;
                    this.scrollPaneWPShares.mouseDragScroll(i, j);
                    int[] sharesMinMax = this.scrollPaneWPShares.getMinMaxIndices(this.displayedWPShareList, this.displayedWPShares);
                    for (int index = sharesMinMax[0]; index <= sharesMinMax[1]; ++index) {
                        UUID fsID = this.displayedWPShareList.get(index);
                        LOTRFellowshipClient fs = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getClientFellowshipByID(fsID);
                        if (fs == null) continue;
                        this.fellowshipDrawGUI.drawFellowshipEntry(fs, fsX, fsY, i, j, false, fullWidth);
                        int iconRemoveX = fsX + this.fellowshipDrawGUI.xSize + iconGap;
                        int iconRemoveY = fsY;
                        boolean mouseOverRemove = false;
                        if (fs == this.fellowshipDrawGUI.getMouseOverFellowship()) {
                            boolean bl3 = mouseOverRemove = i >= iconRemoveX && i <= iconRemoveX + iconWidth && j >= iconRemoveY && j <= iconRemoveY + iconWidth;
                            if (mouseOverRemove) {
                                this.mouseOverRemoveSharedFellowship = fs;
                            }
                        }
                        this.mc.getTextureManager().bindTexture(LOTRGuiFellowships.iconsTextures);
                        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                        this.drawTexturedModalRect(iconRemoveX, iconRemoveY, 8, 16 + (mouseOverRemove ? 0 : iconWidth), iconWidth, iconWidth);
                        fsY = stringY += this.mc.fontRenderer.FONT_HEIGHT + 5;
                    }
                    if (this.scrollPaneWPShares.hasScrollBar) {
                        this.scrollPaneWPShares.drawScrollBar();
                    }
                }
                if (this.creatingWaypointNew || this.renamingWaypoint || this.sharingWaypointNew) {
                    this.nameWPTextField.xPosition = (rectX0 + rectX1) / 2 - this.nameWPTextField.width / 2;
                    this.nameWPTextField.yPosition = stringY;
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)this.zLevel);
                    this.nameWPTextField.drawTextBox();
                    GL11.glPopMatrix();
                    if (this.sharingWaypointNew && this.isFellowshipAlreadyShared(this.nameWPTextField.getText(), (LOTRCustomWaypoint)this.selectedWaypoint)) {
                        String alreadyShared = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.shareNew.already");
                        int sx = this.nameWPTextField.xPosition + this.nameWPTextField.width + 6;
                        int sy = this.nameWPTextField.yPosition + this.nameWPTextField.height / 2 - this.fontRendererObj.FONT_HEIGHT / 2;
                        this.fontRendererObj.drawString(alreadyShared, sx, sy, 16711680);
                    }
                    stringY += this.nameWPTextField.height + this.mc.fontRenderer.FONT_HEIGHT;
                }
                stringY += this.mc.fontRenderer.FONT_HEIGHT;
                if (this.buttonOverlayFunction.visible) {
                    this.buttonOverlayFunction.enabled = true;
                    if (this.creatingWaypointNew || this.renamingWaypoint) {
                        this.buttonOverlayFunction.enabled = this.isValidWaypointName(this.nameWPTextField.getText());
                    }
                    if (this.sharingWaypointNew) {
                        this.buttonOverlayFunction.enabled = this.isExistingUnsharedFellowshipName(this.nameWPTextField.getText(), (LOTRCustomWaypoint)this.selectedWaypoint);
                    }
                    this.buttonOverlayFunction.xPosition = stringX - this.buttonOverlayFunction.width / 2;
                    this.buttonOverlayFunction.yPosition = stringY;
                    if (this.sharingWaypoint) {
                        this.buttonOverlayFunction.yPosition = rectY1 - 3 - this.mc.fontRenderer.FONT_HEIGHT - this.buttonOverlayFunction.height;
                    }
                    this.buttonOverlayFunction.drawButton(this.mc, i, j);
                }
            }
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-500.0f);
        }
    }

    private void setupScrollBars(int i, int j) {
        int n = maxDisplayedWPShares = fullscreen ? 8 : 5;
        if (this.selectedWaypoint != null && this.hasOverlay && this.sharingWaypoint) {
            this.displayedWPShareList = ((LOTRCustomWaypoint)this.selectedWaypoint).getSharedFellowshipIDs();
            this.displayedWPShares = this.displayedWPShareList.size();
            this.scrollPaneWPShares.hasScrollBar = false;
            if (this.displayedWPShares > maxDisplayedWPShares) {
                this.displayedWPShares = maxDisplayedWPShares;
                this.scrollPaneWPShares.hasScrollBar = true;
            }
        } else {
            this.displayedWPShareList = null;
            this.displayedWPShares = 0;
            this.scrollPaneWPShares.hasScrollBar = false;
            this.scrollPaneWPShares.mouseDragScroll(i, j);
        }
    }

    public void renderMapAndOverlay(boolean sepia, float alpha, boolean overlay) {
        mapXMin_W = mapXMin;
        mapXMax_W = mapXMax;
        mapYMin_W = mapYMin;
        mapYMax_W = mapYMax;
        float mapScaleX = (float)mapWidth / this.zoomScale;
        float mapScaleY = (float)mapHeight / this.zoomScale;
        double minU = (double)(this.posX - mapScaleX / 2.0f) / (double)LOTRGenLayerWorld.imageWidth;
        double maxU = (double)(this.posX + mapScaleX / 2.0f) / (double)LOTRGenLayerWorld.imageWidth;
        double minV = (double)(this.posY - mapScaleY / 2.0f) / (double)LOTRGenLayerWorld.imageHeight;
        double maxV = (double)(this.posY + mapScaleY / 2.0f) / (double)LOTRGenLayerWorld.imageHeight;
        if (minU < 0.0) {
            mapXMin_W = mapXMin + (int)Math.round((0.0 - minU) * (double)LOTRGenLayerWorld.imageWidth * (double)this.zoomScale);
            minU = 0.0;
            if (maxU < 0.0) {
                maxU = 0.0;
                mapXMax_W = mapXMin_W;
            }
        }
        if (maxU > 1.0) {
            mapXMax_W = mapXMax - (int)Math.round((maxU - 1.0) * (double)LOTRGenLayerWorld.imageWidth * (double)this.zoomScale);
            maxU = 1.0;
            if (minU > 1.0) {
                minU = 1.0;
                mapXMin_W = mapXMax_W;
            }
        }
        if (minV < 0.0) {
            mapYMin_W = mapYMin + (int)Math.round((0.0 - minV) * (double)LOTRGenLayerWorld.imageHeight * (double)this.zoomScale);
            minV = 0.0;
            if (maxV < 0.0) {
                maxV = 0.0;
                mapYMax_W = mapYMin_W;
            }
        }
        if (maxV > 1.0) {
            mapYMax_W = mapYMax - (int)Math.round((maxV - 1.0) * (double)LOTRGenLayerWorld.imageHeight * (double)this.zoomScale);
            maxV = 1.0;
            if (minV > 1.0) {
                minV = 1.0;
                mapYMin_W = mapYMax_W;
            }
        }
        LOTRTextures.drawMap((EntityPlayer)this.mc.thePlayer, sepia, mapXMin_W, mapXMax_W, mapYMin_W, mapYMax_W, this.zLevel, minU, maxU, minV, maxV, alpha);
        if (overlay && !LOTRGuiMap.isOSRS()) {
            LOTRTextures.drawMapOverlay((EntityPlayer)this.mc.thePlayer, mapXMin, mapXMax, mapYMin, mapYMax, this.zLevel, minU, maxU, minV, maxV);
        }
    }

    private void renderGraduatedRects(int x1, int y1, int x2, int y2, int c1, int c2, int w) {
        float[] rgb1 = new Color(c1).getColorComponents(null);
        float[] rgb2 = new Color(c2).getColorComponents(null);
        for (int l = w - 1; l >= 0; --l) {
            float f = (float)l / (float)(w - 1);
            float r = rgb1[0] + (rgb2[0] - rgb1[0]) * f;
            float g = rgb1[1] + (rgb2[1] - rgb1[1]) * f;
            float b = rgb1[2] + (rgb2[2] - rgb1[2]) * f;
            int color = new Color(r, g, b).getRGB() + -16777216;
            LOTRGuiMap.drawRect((int)(x1 - l), (int)(y1 - l), (int)(x2 + l), (int)(y2 + l), (int)color);
        }
    }

    private void renderMapWidgets(int mouseX, int mouseY) {
        this.widgetAddCWP.visible = !this.hasOverlay && this.isMiddleEarth();
        this.widgetAddCWP.setTexVIndex(this.canCreateWaypointAtPosition() ? 0 : 1);
        this.widgetDelCWP.visible = !this.hasOverlay && this.isMiddleEarth() && this.selectedWaypoint instanceof LOTRCustomWaypoint && !((LOTRCustomWaypoint)this.selectedWaypoint).isShared();
        this.widgetRenameCWP.visible = !this.hasOverlay && this.isMiddleEarth() && this.selectedWaypoint instanceof LOTRCustomWaypoint && !((LOTRCustomWaypoint)this.selectedWaypoint).isShared();
        this.widgetToggleWPs.visible = !this.hasOverlay;
        this.widgetToggleWPs.setTexVIndex(showWP ? 0 : 1);
        this.widgetToggleCWPs.visible = !this.hasOverlay;
        this.widgetToggleCWPs.setTexVIndex(showCWP ? 0 : 1);
        this.widgetToggleHiddenSWPs.visible = !this.hasOverlay;
        this.widgetToggleHiddenSWPs.setTexVIndex(showHiddenSWP ? 1 : 0);
        this.widgetZoomIn.visible = !this.hasOverlay;
        this.widgetZoomIn.setTexVIndex(zoomPower < 4 ? 0 : 1);
        this.widgetZoomOut.visible = !this.hasOverlay;
        this.widgetZoomOut.setTexVIndex(zoomPower > -3 ? 0 : 1);
        this.widgetFullScreen.visible = !this.hasOverlay;
        this.widgetSepia.visible = !this.hasOverlay;
        this.widgetLabels.visible = !this.hasOverlay;
        this.widgetShareCWP.visible = !this.hasOverlay && this.isMiddleEarth() && this.selectedWaypoint instanceof LOTRCustomWaypoint && !((LOTRCustomWaypoint)this.selectedWaypoint).isShared();
        this.widgetHideSWP.visible = !this.hasOverlay && this.isMiddleEarth() && this.selectedWaypoint instanceof LOTRCustomWaypoint && ((LOTRCustomWaypoint)this.selectedWaypoint).isShared() && !((LOTRCustomWaypoint)this.selectedWaypoint).isSharedHidden();
        this.widgetUnhideSWP.visible = !this.hasOverlay && this.isMiddleEarth() && this.selectedWaypoint instanceof LOTRCustomWaypoint && ((LOTRCustomWaypoint)this.selectedWaypoint).isShared() && ((LOTRCustomWaypoint)this.selectedWaypoint).isSharedHidden();
        LOTRGuiMapWidget mouseOverWidget = null;
        for (LOTRGuiMapWidget widget : mapWidgets) {
            if (!widget.visible) continue;
            this.mc.getTextureManager().bindTexture(mapIconsTexture);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.drawTexturedModalRect(mapXMin + widget.getMapXPos(mapWidth), mapYMin + widget.getMapYPos(mapHeight), widget.getTexU(), widget.getTexV(), widget.width, widget.width);
            if (!widget.isMouseOver(mouseX - mapXMin, mouseY - mapYMin, mapWidth, mapHeight)) continue;
            mouseOverWidget = widget;
        }
        if (mouseOverWidget != null) {
            float z = this.zLevel;
            int stringWidth = 200;
            List desc = this.fontRendererObj.listFormattedStringToWidth(mouseOverWidget.getTranslatedName(), stringWidth);
            this.func_146283_a(desc, mouseX, mouseY);
            GL11.glDisable((int)2896);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.zLevel = z;
        }
    }

    private boolean canCreateWaypointAtPosition() {
        int minY = LOTRConfig.getCustomWaypointMinY((World)this.mc.theWorld);
        return minY < 0 || this.mc.thePlayer.boundingBox.minY >= (double)minY;
    }

    private void renderFullscreenSubtitles(String ... lines) {
        int strX = mapXMin + mapWidth / 2;
        int strY = mapYMax + 7;
        if (this.isConquestGrid) {
            strY = mapYMax + 26;
        }
        int border = this.fontRendererObj.FONT_HEIGHT + 3;
        if (lines.length == 1) {
            strY += border / 2;
        }
        for (String s : lines) {
            this.drawCenteredString(s, strX, strY, 16777215);
            strY += border;
        }
    }

    private void renderPlayers(int mouseX, int mouseY) {
        String mouseOverPlayerName = null;
        double mouseOverPlayerX = 0.0;
        double mouseOverPlayerY = 0.0;
        double distanceMouseOverPlayer = Double.MAX_VALUE;
        int iconWidthHalf = 4;
        HashMap<UUID, PlayerLocationInfo> playersToRender = new HashMap<UUID, PlayerLocationInfo>();
        playersToRender.putAll(playerLocations);
        if (this.isMiddleEarth()) {
            playersToRender.put(this.mc.thePlayer.getUniqueID(), new PlayerLocationInfo(this.mc.thePlayer.getGameProfile(), this.mc.thePlayer.posX, this.mc.thePlayer.posZ));
        }
        for (Map.Entry entry : playersToRender.entrySet()) {
            int playerY;
            float[] pos;
            int playerX;
            double playerPosZ;
            double playerPosX;
            UUID player = (UUID)entry.getKey();
            PlayerLocationInfo info = (PlayerLocationInfo)entry.getValue();
            GameProfile profile = info.profile;
            String playerName = profile.getName();
            double distToPlayer = this.renderPlayerIcon(profile, playerName, playerX = Math.round((pos = this.transformCoords(playerPosX = info.posX, playerPosZ = info.posZ))[0]), playerY = Math.round(pos[1]), mouseX, mouseY);
            if (!(distToPlayer <= (double)(iconWidthHalf + 3)) || !(distToPlayer <= distanceMouseOverPlayer)) continue;
            mouseOverPlayerName = playerName;
            mouseOverPlayerX = playerX;
            mouseOverPlayerY = playerY;
            distanceMouseOverPlayer = distToPlayer;
        }
        if (mouseOverPlayerName != null && !this.hasOverlay && !this.loadingConquestGrid) {
            int strWidth = this.mc.fontRenderer.getStringWidth(mouseOverPlayerName);
            int strHeight = this.mc.fontRenderer.FONT_HEIGHT;
            int rectX = (int)Math.round(mouseOverPlayerX);
            int rectY = (int)Math.round(mouseOverPlayerY);
            rectY += iconWidthHalf + 3;
            int border = 3;
            int rectWidth = strWidth + border * 2;
            rectX -= rectWidth / 2;
            int rectHeight = strHeight + border * 2;
            int mapBorder2 = 2;
            rectX = Math.max(rectX, mapXMin + mapBorder2);
            rectX = Math.min(rectX, mapXMax - mapBorder2 - rectWidth);
            rectY = Math.max(rectY, mapYMin + mapBorder2);
            rectY = Math.min(rectY, mapYMax - mapBorder2 - rectHeight);
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)300.0f);
            this.drawFancyRect(rectX, rectY, rectX + rectWidth, rectY + rectHeight);
            this.mc.fontRenderer.drawString(mouseOverPlayerName, rectX + border, rectY + border, 16777215);
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-300.0f);
        }
    }

    private double renderPlayerIcon(GameProfile profile, String playerName, double playerX, double playerY, int mouseX, int mouseY) {
        Tessellator tessellator = Tessellator.instance;
        int iconWidthHalf = 4;
        int iconBorder = iconWidthHalf + 1;
        playerX = Math.max((double)(mapXMin + iconBorder), playerX);
        playerX = Math.min((double)(mapXMax - iconBorder - 1), playerX);
        playerY = Math.max((double)(mapYMin + iconBorder), playerY);
        playerY = Math.min((double)(mapYMax - iconBorder - 1), playerY);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        ResourceLocation skin = AbstractClientPlayer.locationStevePng;
        if (profile.getId().equals(this.mc.thePlayer.getUniqueID())) {
            skin = this.mc.thePlayer.getLocationSkin();
        } else {
            MinecraftProfileTexture.Type type;
            Map map = this.mc.func_152342_ad().func_152788_a(profile);
            if (map.containsKey((Object)(type = MinecraftProfileTexture.Type.SKIN))) {
                skin = this.mc.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get((Object)type), type);
            }
        }
        this.mc.getTextureManager().bindTexture(skin);
        double iconMinU = 0.125;
        double iconMaxU = 0.25;
        double iconMinV = 0.25;
        double iconMaxV = 0.5;
        double playerX_d = playerX + 0.5;
        double playerY_d = playerY + 0.5;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(playerX_d - (double)iconWidthHalf, playerY_d + (double)iconWidthHalf, (double)this.zLevel, iconMinU, iconMaxV);
        tessellator.addVertexWithUV(playerX_d + (double)iconWidthHalf, playerY_d + (double)iconWidthHalf, (double)this.zLevel, iconMaxU, iconMaxV);
        tessellator.addVertexWithUV(playerX_d + (double)iconWidthHalf, playerY_d - (double)iconWidthHalf, (double)this.zLevel, iconMaxU, iconMinV);
        tessellator.addVertexWithUV(playerX_d - (double)iconWidthHalf, playerY_d - (double)iconWidthHalf, (double)this.zLevel, iconMinU, iconMinV);
        tessellator.draw();
        iconMinU = 0.625;
        iconMaxU = 0.75;
        iconMinV = 0.25;
        iconMaxV = 0.5;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(playerX_d - (double)iconWidthHalf - 0.5, playerY_d + (double)iconWidthHalf + 0.5, (double)this.zLevel, iconMinU, iconMaxV);
        tessellator.addVertexWithUV(playerX_d + (double)iconWidthHalf + 0.5, playerY_d + (double)iconWidthHalf + 0.5, (double)this.zLevel, iconMaxU, iconMaxV);
        tessellator.addVertexWithUV(playerX_d + (double)iconWidthHalf + 0.5, playerY_d - (double)iconWidthHalf - 0.5, (double)this.zLevel, iconMaxU, iconMinV);
        tessellator.addVertexWithUV(playerX_d - (double)iconWidthHalf - 0.5, playerY_d - (double)iconWidthHalf - 0.5, (double)this.zLevel, iconMinU, iconMinV);
        tessellator.draw();
        double dx = playerX - (double)mouseX;
        double dy = playerY - (double)mouseY;
        double distToPlayer = Math.sqrt(dx * dx + dy * dy);
        return distToPlayer;
    }

    private void renderMiniQuests(EntityPlayer entityplayer, int mouseX, int mouseY) {
        if (this.hasOverlay) {
            return;
        }
        LOTRMiniQuest mouseOverQuest = null;
        int mouseOverQuestX = 0;
        int mouseOverQuestY = 0;
        double distanceMouseOverQuest = Double.MAX_VALUE;
        List<LOTRMiniQuest> quests = LOTRLevelData.getData(entityplayer).getActiveMiniQuests();
        for (LOTRMiniQuest quest : quests) {
            ChunkCoordinates location = quest.getLastLocation();
            if (location == null) continue;
            float[] pos = this.transformCoords(location.posX, location.posZ);
            int questX = Math.round(pos[0]);
            int questY = Math.round(pos[1]);
            float scale = 0.5f;
            float invScale = 1.0f / scale;
            IIcon icon = questBookIcon.getIconIndex();
            int iconWidthHalf = icon.getIconWidth() / 2;
            iconWidthHalf = (int)((float)iconWidthHalf * scale);
            int iconBorder = iconWidthHalf + 1;
            questX = Math.max(mapXMin + iconBorder, questX);
            questX = Math.min(mapXMax - iconBorder - 1, questX);
            questY = Math.max(mapYMin + iconBorder, questY);
            questY = Math.min(mapYMax - iconBorder - 1, questY);
            int iconX = Math.round((float)questX * invScale);
            int iconY = Math.round((float)questY * invScale);
            GL11.glScalef((float)scale, (float)scale, (float)scale);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2884);
            renderItem.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), questBookIcon, iconX -= iconWidthHalf, iconY -= iconWidthHalf);
            GL11.glDisable((int)2896);
            GL11.glEnable((int)3008);
            GL11.glScalef((float)invScale, (float)invScale, (float)invScale);
            double dx = questX - mouseX;
            double dy = questY - mouseY;
            double distToQuest = Math.sqrt(dx * dx + dy * dy);
            if (!(distToQuest <= (double)(iconWidthHalf + 3)) || !(distToQuest <= distanceMouseOverQuest)) continue;
            mouseOverQuest = quest;
            mouseOverQuestX = questX;
            mouseOverQuestY = questY;
            distanceMouseOverQuest = distToQuest;
        }
        if (mouseOverQuest != null && !this.hasOverlay) {
            String name = mouseOverQuest.entityName;
            int stringWidth = this.mc.fontRenderer.getStringWidth(name);
            int stringHeight = this.mc.fontRenderer.FONT_HEIGHT;
            int x = mouseOverQuestX;
            int y = mouseOverQuestY;
            y += 7;
            int border = 3;
            int rectWidth = stringWidth + border * 2;
            x -= rectWidth / 2;
            int rectHeight = stringHeight + border * 2;
            int mapBorder2 = 2;
            x = Math.max(x, mapXMin + mapBorder2);
            x = Math.min(x, mapXMax - mapBorder2 - rectWidth);
            y = Math.max(y, mapYMin + mapBorder2);
            y = Math.min(y, mapYMax - mapBorder2 - rectHeight);
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)300.0f);
            this.drawFancyRect(x, y, x + rectWidth, y + rectHeight);
            this.mc.fontRenderer.drawString(name, x + border, y + border, 16777215);
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-300.0f);
        }
    }

    private void renderControlZone(int mouseX, int mouseY) {
        List<LOTRControlZone> controlZones;
        this.mouseControlZone = false;
        this.mouseControlZoneReduced = false;
        LOTRFaction faction = this.controlZoneFaction;
        if (faction.factionDimension == LOTRDimension.MIDDLE_EARTH && !(controlZones = faction.getControlZones()).isEmpty()) {
            Tessellator tessellator = Tessellator.instance;
            this.setupMapClipping();
            GL11.glDisable((int)3553);
            for (int pass = 0; pass <= 2; ++pass) {
                int color = 16711680;
                if (pass == 1) {
                    color = 5570560;
                }
                if (pass == 0) {
                    color = 16733525;
                }
                for (LOTRControlZone zone : controlZones) {
                    float dx;
                    float[] trans;
                    float dy;
                    float rScaled;
                    float radius = zone.radius;
                    if (pass == 2) {
                        radius -= 1.0f;
                    }
                    if (pass == 0) {
                        radius = zone.radius + this.controlZoneFaction.getControlZoneReducedRange();
                    }
                    float radiusWorld = LOTRWaypoint.mapToWorldR(radius);
                    tessellator.startDrawing(9);
                    tessellator.setColorOpaque_I(color);
                    int sides = 100;
                    for (int l = sides - 1; l >= 0; --l) {
                        float angle = (float)l / (float)sides * 2.0f * 3.1415927f;
                        double x = zone.xCoord;
                        double z = zone.zCoord;
                        float[] trans2 = this.transformCoords(x += (double)(MathHelper.cos((float)angle) * radiusWorld), z += (double)(MathHelper.sin((float)angle) * radiusWorld));
                        tessellator.addVertex((double)trans2[0], (double)trans2[1], (double)this.zLevel);
                    }
                    tessellator.draw();
                    if (this.mouseControlZone && this.mouseControlZoneReduced || !((dx = (float)mouseX - (trans = this.transformCoords(zone.xCoord, zone.zCoord))[0]) * dx + (dy = (float)mouseY - trans[1]) * dy <= (rScaled = radius * this.zoomScale) * rScaled)) continue;
                    if (pass >= 1) {
                        this.mouseControlZone = true;
                        continue;
                    }
                    if (pass != 0) continue;
                    this.mouseControlZoneReduced = true;
                }
            }
            GL11.glEnable((int)3553);
            this.endMapClipping();
        }
    }

    private void renderRoads() {
        if (!showWP && !showCWP || !LOTRFixedStructures.hasMapFeatures((World)this.mc.theWorld)) {
            return;
        }
        this.renderRoads(this.hasMapLabels());
    }

    public void renderRoads(boolean labels) {
        float roadZoomlerp = (this.zoomExp - -3.3f) / 2.2f;
        roadZoomlerp = Math.min(roadZoomlerp, 1.0f);
        if (!this.enableZoomOutWPFading) {
            roadZoomlerp = 1.0f;
        }
        if (roadZoomlerp > 0.0f) {
            Iterator<LOTRRoads> roadIterator = LOTRRoads.getAllRoadsForDisplay();
            while (roadIterator.hasNext()) {
                LOTRRoads road = roadIterator.next();
                int interval = Math.round(400.0f / this.zoomScaleStable);
                interval = Math.max(interval, 1);
                for (int i = 0; i < road.roadPoints.length; i += interval) {
                    int clip;
                    LOTRRoads.RoadPoint point = road.roadPoints[i];
                    float[] pos = this.transformCoords(point.x, point.z);
                    float x = pos[0];
                    float y = pos[1];
                    if (x >= (float)mapXMin && x < (float)mapXMax && y >= (float)mapYMin && y < (float)mapYMax) {
                        double roadWidth = 1.0;
                        int roadColor = 0;
                        float roadAlpha = roadZoomlerp;
                        if (LOTRGuiMap.isOSRS()) {
                            roadWidth = 3.0 * (double)this.zoomScale;
                            roadColor = 6575407;
                            roadAlpha = 1.0f;
                        }
                        double roadWidthLess1 = roadWidth - 1.0;
                        GL11.glDisable((int)3553);
                        GL11.glEnable((int)3042);
                        GL11.glBlendFunc((int)770, (int)771);
                        Tessellator tessellator = Tessellator.instance;
                        tessellator.startDrawingQuads();
                        tessellator.setColorRGBA_I(roadColor, (int)(roadAlpha * 255.0f));
                        tessellator.addVertex((double)x - roadWidthLess1, (double)y + roadWidth, (double)this.zLevel);
                        tessellator.addVertex((double)x + roadWidth, (double)y + roadWidth, (double)this.zLevel);
                        tessellator.addVertex((double)x + roadWidth, (double)y - roadWidthLess1, (double)this.zLevel);
                        tessellator.addVertex((double)x - roadWidthLess1, (double)y - roadWidthLess1, (double)this.zLevel);
                        tessellator.draw();
                        GL11.glDisable((int)3042);
                        GL11.glEnable((int)3553);
                    }
                    if (!labels || !(x >= (float)(mapXMin - (clip = 200))) || !(x <= (float)(mapXMax + clip)) || !(y >= (float)(mapYMin - clip)) || !(y <= (float)(mapYMax + clip))) continue;
                    float zoomlerp = (this.zoomExp - -1.0f) / 4.0f;
                    float scale = zoomlerp = Math.min(zoomlerp, 1.0f);
                    String name = road.getDisplayName();
                    int nameWidth = this.fontRendererObj.getStringWidth(name);
                    int nameInterval = (int)((float)(nameWidth * 2 + 100) * 200.0f / this.zoomScaleStable);
                    if (i % nameInterval >= interval) continue;
                    boolean endNear = false;
                    double dMax = ((double)nameWidth / 2.0 + 25.0) * (double)scale;
                    double dMaxSq = dMax * dMax;
                    for (LOTRRoads.RoadPoint end : road.endpoints) {
                        float endY;
                        float dy;
                        float[] endPos = this.transformCoords(end.x, end.z);
                        float endX = endPos[0];
                        float dx = x - endX;
                        double dSq = dx * dx + (dy = y - (endY = endPos[1])) * dy;
                        if (!(dSq < dMaxSq)) continue;
                        endNear = true;
                    }
                    if (endNear || !(zoomlerp > 0.0f)) continue;
                    this.setupMapClipping();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)x, (float)y, (float)0.0f);
                    GL11.glScalef((float)scale, (float)scale, (float)scale);
                    LOTRRoads.RoadPoint nextPoint = road.roadPoints[Math.min(i + 1, road.roadPoints.length - 1)];
                    LOTRRoads.RoadPoint prevPoint = road.roadPoints[Math.max(i - 1, 0)];
                    double grad = (nextPoint.z - prevPoint.z) / (nextPoint.x - prevPoint.x);
                    float angle = (float)Math.atan(grad);
                    angle = (float)Math.toDegrees(angle);
                    if (Math.abs(angle) > 90.0f) {
                        angle += 180.0f;
                    }
                    GL11.glRotatef((float)angle, (float)0.0f, (float)0.0f, (float)1.0f);
                    float alpha = zoomlerp;
                    int alphaI = LOTRClientProxy.getAlphaInt(alpha *= 0.8f);
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    int strX = -nameWidth / 2;
                    int strY = -15;
                    this.fontRendererObj.drawString(name, strX + 1, strY + 1, 0 + (alphaI << 24));
                    this.fontRendererObj.drawString(name, strX, strY, 16777215 + (alphaI << 24));
                    GL11.glDisable((int)3042);
                    GL11.glPopMatrix();
                    this.endMapClipping();
                }
            }
        }
    }

    private boolean isWaypointVisible(LOTRAbstractWaypoint wp) {
        if (wp instanceof LOTRCustomWaypoint) {
            LOTRCustomWaypoint cwp = (LOTRCustomWaypoint)wp;
            if (cwp.isShared() && cwp.isSharedHidden() && !showHiddenSWP) {
                return false;
            }
            return showCWP;
        }
        return showWP;
    }

    private void renderWaypoints(int pass, int mouseX, int mouseY) {
        if (!showWP && !showCWP && !showHiddenSWP || !LOTRFixedStructures.hasMapFeatures((World)this.mc.theWorld)) {
            return;
        }
        this.renderWaypoints(LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getAllAvailableWaypoints(), pass, mouseX, mouseY, this.hasMapLabels(), false);
    }

    public void renderWaypoints(List<LOTRAbstractWaypoint> waypoints, int pass, int mouseX, int mouseY, boolean labels, boolean overrideToggles) {
        this.setupMapClipping();
        LOTRAbstractWaypoint mouseOverWP = null;
        double distanceMouseOverWP = Double.MAX_VALUE;
        float wpZoomlerp = (this.zoomExp - -3.3f) / 2.2f;
        wpZoomlerp = Math.min(wpZoomlerp, 1.0f);
        if (!this.enableZoomOutWPFading) {
            wpZoomlerp = 1.0f;
        }
        if (wpZoomlerp > 0.0f) {
            for (LOTRAbstractWaypoint waypoint : waypoints) {
                double distToWP;
                boolean shared;
                double dy;
                double dx;
                boolean unlocked = this.mc.thePlayer != null && this.mc.thePlayer.worldObj != null && waypoint.hasPlayerUnlocked((EntityPlayer)this.mc.thePlayer);
                boolean hidden = waypoint.isHidden();
                boolean custom = waypoint instanceof LOTRCustomWaypoint;
                boolean bl = shared = waypoint instanceof LOTRCustomWaypoint && ((LOTRCustomWaypoint)waypoint).isShared();
                if (!this.isWaypointVisible(waypoint) && !overrideToggles || hidden && !unlocked) continue;
                float[] pos = this.transformCoords(waypoint.getXCoord(), waypoint.getZCoord());
                float x = pos[0];
                float y = pos[1];
                int clip = 200;
                if (!(x >= (float)(mapXMin - clip)) || !(x <= (float)(mapXMax + clip)) || !(y >= (float)(mapYMin - clip)) || !(y <= (float)(mapYMax + clip))) continue;
                if (pass == 0) {
                    float wpAlpha = wpZoomlerp;
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    if (LOTRGuiMap.isOSRS()) {
                        float osScale = 0.33f;
                        GL11.glPushMatrix();
                        GL11.glScalef((float)0.33f, (float)0.33f, (float)1.0f);
                        this.mc.getTextureManager().bindTexture(LOTRTextures.osrsTexture);
                        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                        this.drawTexturedModalRectFloat(x / 0.33f - 8.0f, y / 0.33f - 8.0f, 0, 0, 15.0f, 15.0f);
                        GL11.glPopMatrix();
                    } else {
                        LOTRAbstractWaypoint.WaypointLockState state = this.mc.thePlayer != null ? waypoint.getLockState((EntityPlayer)this.mc.thePlayer) : LOTRAbstractWaypoint.WaypointLockState.STANDARD_UNLOCKED;
                        this.mc.getTextureManager().bindTexture(mapIconsTexture);
                        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)wpAlpha);
                        this.drawTexturedModalRectFloat(x - 2.0f, y - 2.0f, state.iconU, state.iconV, 4.0f, 4.0f);
                    }
                    GL11.glDisable((int)3042);
                    if (labels) {
                        float zoomlerp = (this.zoomExp - -1.0f) / 4.0f;
                        if ((zoomlerp = Math.min(zoomlerp, 1.0f)) > 0.0f) {
                            GL11.glPushMatrix();
                            GL11.glTranslatef((float)x, (float)y, (float)0.0f);
                            float scale = zoomlerp;
                            GL11.glScalef((float)scale, (float)scale, (float)scale);
                            float alpha = zoomlerp;
                            int alphaI = (int)((alpha *= 0.8f) * 255.0f);
                            alphaI = MathHelper.clamp_int((int)alphaI, (int)4, (int)255);
                            GL11.glEnable((int)3042);
                            GL11.glBlendFunc((int)770, (int)771);
                            String s = waypoint.getDisplayName();
                            int strX = -this.fontRendererObj.getStringWidth(s) / 2;
                            int strY = -15;
                            this.fontRendererObj.drawString(s, strX + 1, strY + 1, 0 + (alphaI << 24));
                            this.fontRendererObj.drawString(s, strX, strY, 16777215 + (alphaI << 24));
                            GL11.glDisable((int)3042);
                            GL11.glPopMatrix();
                        }
                    }
                }
                if (pass != 1 || waypoint == this.selectedWaypoint || !(x >= (float)(mapXMin - 2)) || !(x <= (float)(mapXMax + 2)) || !(y >= (float)(mapYMin - 2)) || !(y <= (float)(mapYMax + 2)) || !((distToWP = Math.sqrt((dx = (double)(x - (float)mouseX)) * dx + (dy = (double)(y - (float)mouseY)) * dy)) <= 5.0) || !(distToWP <= distanceMouseOverWP)) continue;
                mouseOverWP = waypoint;
                distanceMouseOverWP = distToWP;
            }
        }
        if (pass == 1 && mouseOverWP != null && !this.hasOverlay && !this.loadingConquestGrid) {
            this.renderWaypointTooltip(mouseOverWP, false, mouseX, mouseY);
        }
        this.endMapClipping();
    }

    private void renderWaypointTooltip(LOTRAbstractWaypoint waypoint, boolean selected, int mouseX, int mouseY) {
        String name = waypoint.getDisplayName();
        int wpX = waypoint.getXCoord();
        int wpZ = waypoint.getZCoord();
        int wpY = waypoint.getYCoordSaved();
        String coords = wpY >= 0 ? StatCollector.translateToLocalFormatted((String)"lotr.gui.map.coordsY", (Object[])new Object[]{wpX, wpY, wpZ}) : StatCollector.translateToLocalFormatted((String)"lotr.gui.map.coords", (Object[])new Object[]{wpX, wpZ});
        String loreText = waypoint.getLoreText((EntityPlayer)this.mc.thePlayer);
        float guiScale = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight).getScaleFactor();
        float loreScale = guiScale - 1.0f;
        if (guiScale <= 2.0f) {
            loreScale = guiScale;
        }
        float loreScaleRel = loreScale / guiScale;
        float loreScaleRelInv = 1.0f / loreScaleRel;
        int loreFontHeight = MathHelper.ceiling_double_int((double)((float)this.fontRendererObj.FONT_HEIGHT * loreScaleRel));
        float[] pos = this.transformCoords(wpX, wpZ);
        int rectX = Math.round(pos[0]);
        int rectY = Math.round(pos[1]);
        rectY += 5;
        int border = 3;
        int stringHeight = this.fontRendererObj.FONT_HEIGHT;
        int innerRectWidth = this.fontRendererObj.getStringWidth(name);
        if (selected) {
            innerRectWidth = Math.max(innerRectWidth, this.fontRendererObj.getStringWidth(coords));
            if (loreText != null) {
                innerRectWidth += 50;
                innerRectWidth = Math.round((float)innerRectWidth * (loreScaleRel / 0.66667f));
            }
        }
        int rectWidth = innerRectWidth + border * 2;
        rectX -= rectWidth / 2;
        int rectHeight = border * 2 + stringHeight;
        if (selected) {
            rectHeight += border + stringHeight;
            if (loreText != null) {
                rectHeight += border;
                rectHeight += this.fontRendererObj.listFormattedStringToWidth(loreText, (int)((float)innerRectWidth * loreScaleRelInv)).size() * loreFontHeight;
                rectHeight += border;
            }
        }
        int mapBorder2 = 2;
        rectX = Math.max(rectX, mapXMin + mapBorder2);
        rectX = Math.min(rectX, mapXMax - mapBorder2 - rectWidth);
        rectY = Math.max(rectY, mapYMin + mapBorder2);
        rectY = Math.min(rectY, mapYMax - mapBorder2 - rectHeight);
        int stringX = rectX + rectWidth / 2;
        int stringY = rectY + border;
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)300.0f);
        this.drawFancyRect(rectX, rectY, rectX + rectWidth, rectY + rectHeight);
        this.drawCenteredString(name, stringX, stringY, 16777215);
        stringY += this.fontRendererObj.FONT_HEIGHT + border;
        if (selected) {
            this.drawCenteredString(coords, stringX, stringY, 16777215);
            stringY += this.fontRendererObj.FONT_HEIGHT + border * 2;
            if (loreText != null) {
                GL11.glPushMatrix();
                GL11.glScalef((float)loreScaleRel, (float)loreScaleRel, (float)1.0f);
                List loreLines = this.fontRendererObj.listFormattedStringToWidth(loreText, (int)((float)innerRectWidth * loreScaleRelInv));
                for (int l = 0; l < loreLines.size(); ++l) {
                    String line = (String)loreLines.get(l);
                    this.drawCenteredString(line, (int)((float)stringX * loreScaleRelInv), (int)((float)stringY * loreScaleRelInv), 16777215);
                    stringY += loreFontHeight;
                }
                GL11.glPopMatrix();
            }
        }
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-300.0f);
    }

    private void renderLabels() {
        LOTRMapLabels[] allLabels;
        if (!this.hasMapLabels()) {
            return;
        }
        this.setupMapClipping();
        for (LOTRMapLabels label : allLabels = LOTRMapLabels.allMapLabels()) {
            float[] pos = this.transformMapCoords(label.posX, label.posY);
            float x = pos[0];
            float y = pos[1];
            float zoomlerp = (this.zoomExp - label.minZoom) / (label.maxZoom - label.minZoom);
            if (!(zoomlerp > 0.0f) || !(zoomlerp < 1.0f)) continue;
            float alpha = (0.5f - Math.abs(zoomlerp - 0.5f)) / 0.5f;
            alpha *= 0.7f;
            if (LOTRGuiMap.isOSRS()) {
                if (alpha < 0.3f) continue;
                alpha = 1.0f;
            }
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x, (float)y, (float)0.0f);
            float scale = this.zoomScale * label.scale;
            GL11.glScalef((float)scale, (float)scale, (float)scale);
            if (!LOTRGuiMap.isOSRS()) {
                GL11.glRotatef((float)label.angle, (float)0.0f, (float)0.0f, (float)1.0f);
            }
            int alphaI = (int)(alpha * 255.0f);
            alphaI = MathHelper.clamp_int((int)alphaI, (int)4, (int)255);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            float alphaFunc = GL11.glGetFloat((int)3010);
            GL11.glAlphaFunc((int)516, (float)0.01f);
            String s = label.getDisplayName();
            int strX = -this.fontRendererObj.getStringWidth(s) / 2;
            int strY = -this.fontRendererObj.FONT_HEIGHT / 2;
            if (LOTRGuiMap.isOSRS()) {
                if (label.scale > 2.5f) {
                    this.fontRendererObj.drawString(s, strX + 1, strY + 1, 0 + (alphaI << 24));
                    this.fontRendererObj.drawString(s, strX, strY, 16755200 + (alphaI << 24));
                } else {
                    this.fontRendererObj.drawString(s, strX + 1, strY + 1, 0 + (alphaI << 24));
                    this.fontRendererObj.drawString(s, strX, strY, 16777215 + (alphaI << 24));
                }
            } else {
                this.fontRendererObj.drawString(s, strX, strY, 16777215 + (alphaI << 24));
            }
            GL11.glAlphaFunc((int)516, (float)alphaFunc);
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
        this.endMapClipping();
    }

    private void setupMapClipping() {
        ScaledResolution sr = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        int scale = sr.getScaleFactor();
        GL11.glEnable((int)3089);
        GL11.glScissor((int)(mapXMin * scale), (int)((this.height - mapYMax) * scale), (int)(mapWidth * scale), (int)(mapHeight * scale));
    }

    private void endMapClipping() {
        GL11.glDisable((int)3089);
    }

    private float[] transformCoords(float x, float z) {
        x = x / (float)LOTRGenLayerWorld.scale + 810.0f;
        z = z / (float)LOTRGenLayerWorld.scale + 730.0f;
        return this.transformMapCoords(x, z);
    }

    private float[] transformCoords(double x, double z) {
        return this.transformCoords((float)x, (float)z);
    }

    private float[] transformMapCoords(float x, float z) {
        x -= this.posX;
        z -= this.posY;
        x *= this.zoomScale;
        z *= this.zoomScale;
        return new float[]{x += (float)(mapXMin + mapWidth / 2), z += (float)(mapYMin + mapHeight / 2)};
    }

    private void drawFancyRect(int x1, int y1, int x2, int y2) {
        LOTRGuiMap.drawRect((int)x1, (int)y1, (int)x2, (int)y2, (int)-1073741824);
        this.drawHorizontalLine(x1 - 1, x2, y1 - 1, -6156032);
        this.drawHorizontalLine(x1 - 1, x2, y2, -6156032);
        this.drawVerticalLine(x1 - 1, y1 - 1, y2, -6156032);
        this.drawVerticalLine(x2, y1 - 1, y2, -6156032);
    }

    private boolean isValidWaypointName(String name) {
        return !StringUtils.isBlank((CharSequence)name);
    }

    private LOTRFellowshipClient getFellowshipByName(String name) {
        String fsName = StringUtils.strip((String)name);
        return LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getClientFellowshipByName(fsName);
    }

    private boolean isExistingFellowshipName(String name) {
        LOTRFellowshipClient fs = this.getFellowshipByName(name);
        return fs != null;
    }

    private boolean isExistingUnsharedFellowshipName(String name, LOTRCustomWaypoint waypoint) {
        LOTRFellowshipClient fs = this.getFellowshipByName(name);
        return fs != null && !waypoint.hasSharedFellowship(fs.getFellowshipID());
    }

    private boolean isFellowshipAlreadyShared(String name, LOTRCustomWaypoint waypoint) {
        return this.isExistingFellowshipName(name) && !this.isExistingUnsharedFellowshipName(name, waypoint);
    }

    @Override
    protected void keyTyped(char c, int i) {
        if (this.hasOverlay) {
            if (this.creatingWaypointNew && this.nameWPTextField.textboxKeyTyped(c, i)) {
                return;
            }
            if (this.renamingWaypoint && this.nameWPTextField.textboxKeyTyped(c, i)) {
                return;
            }
            if (this.sharingWaypointNew && this.nameWPTextField.textboxKeyTyped(c, i)) {
                return;
            }
            if (i == 1 || i == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
                if (this.creatingWaypointNew) {
                    this.openOverlayCreate();
                } else if (this.sharingWaypointNew) {
                    this.openOverlayShare();
                } else {
                    this.closeOverlay();
                }
                return;
            }
        } else {
            if (!this.loadingConquestGrid) {
                LOTRPlayerData pd = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer);
                if (i == LOTRKeyHandler.keyBindingFastTravel.getKeyCode() && this.isMiddleEarth() && this.selectedWaypoint != null && this.selectedWaypoint.hasPlayerUnlocked((EntityPlayer)this.mc.thePlayer) && pd.getTimeSinceFT() >= pd.getWaypointFTTime(this.selectedWaypoint, (EntityPlayer)this.mc.thePlayer)) {
                    LOTRPacketFastTravel packet = new LOTRPacketFastTravel(this.selectedWaypoint);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.mc.thePlayer.closeScreen();
                    return;
                }
                if (this.selectedWaypoint == null && i == LOTRKeyHandler.keyBindingMapTeleport.getKeyCode() && this.isMouseWithinMap && this.canTeleport()) {
                    LOTRPacketMapTp packet = new LOTRPacketMapTp(this.mouseXCoord, this.mouseZCoord);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.mc.thePlayer.closeScreen();
                    return;
                }
            }
            if (this.hasControlZones && (i == 1 || i == this.mc.gameSettings.keyBindInventory.getKeyCode())) {
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new LOTRGuiFactions());
                return;
            }
            super.keyTyped(c, i);
        }
    }

    private void closeOverlay() {
        this.hasOverlay = false;
        this.overlayLines = null;
        this.creatingWaypoint = false;
        this.creatingWaypointNew = false;
        this.deletingWaypoint = false;
        this.renamingWaypoint = false;
        this.sharingWaypoint = false;
        this.sharingWaypointNew = false;
        this.buttonOverlayFunction.visible = false;
        this.buttonOverlayFunction.enabled = false;
        this.nameWPTextField.setText("");
    }

    private void openOverlayCreate() {
        this.closeOverlay();
        this.hasOverlay = true;
        this.creatingWaypoint = true;
        int numWaypoints = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getCustomWaypoints().size();
        int maxWaypoints = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getMaxCustomWaypoints();
        int remaining = maxWaypoints - numWaypoints;
        if (remaining <= 0) {
            this.overlayLines = new String[]{StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.allUsed.1", (Object[])new Object[]{maxWaypoints}), "", StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.allUsed.2")};
        } else {
            this.overlayLines = new String[]{StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.create.1", (Object[])new Object[]{numWaypoints, maxWaypoints}), "", StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.create.2", (Object[])new Object[0])};
            this.buttonOverlayFunction.visible = true;
            this.buttonOverlayFunction.displayString = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.create.button");
        }
    }

    private void openOverlayCreateNew() {
        this.closeOverlay();
        this.hasOverlay = true;
        this.creatingWaypointNew = true;
        this.overlayLines = new String[]{StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.createNew.1")};
        this.buttonOverlayFunction.visible = true;
        this.buttonOverlayFunction.displayString = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.createNew.button");
    }

    private void openOverlayDelete() {
        this.closeOverlay();
        this.hasOverlay = true;
        this.deletingWaypoint = true;
        this.overlayLines = new String[]{StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.delete.1", (Object[])new Object[]{this.selectedWaypoint.getDisplayName()})};
        this.buttonOverlayFunction.visible = true;
        this.buttonOverlayFunction.displayString = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.delete.button");
    }

    private void openOverlayRename() {
        this.closeOverlay();
        this.hasOverlay = true;
        this.renamingWaypoint = true;
        this.overlayLines = new String[]{StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.rename.1", (Object[])new Object[]{this.selectedWaypoint.getDisplayName()})};
        this.buttonOverlayFunction.visible = true;
        this.buttonOverlayFunction.displayString = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.rename.button");
    }

    private void openOverlayShare() {
        this.closeOverlay();
        this.hasOverlay = true;
        this.sharingWaypoint = true;
        this.overlayLines = new String[]{StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.share.1", (Object[])new Object[]{this.selectedWaypoint.getDisplayName()})};
        this.buttonOverlayFunction.visible = true;
        this.buttonOverlayFunction.displayString = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.share.button");
    }

    private void openOverlayShareNew() {
        this.closeOverlay();
        this.hasOverlay = true;
        this.sharingWaypointNew = true;
        this.overlayLines = new String[]{StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.shareNew.1", (Object[])new Object[]{this.selectedWaypoint.getDisplayName()})};
        this.buttonOverlayFunction.visible = true;
        this.buttonOverlayFunction.displayString = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.shareNew.button");
    }

    protected void mouseClicked(int i, int j, int k) {
        Object packet;
        LOTRGuiMapWidget mouseWidget = null;
        for (LOTRGuiMapWidget widget : mapWidgets) {
            if (!widget.isMouseOver(i - mapXMin, j - mapYMin, mapWidth, mapHeight)) continue;
            mouseWidget = widget;
            break;
        }
        if (this.hasOverlay && (this.creatingWaypointNew || this.renamingWaypoint || this.sharingWaypointNew)) {
            this.nameWPTextField.mouseClicked(i, j, k);
        }
        if (this.hasOverlay && k == 0 && this.sharingWaypoint && this.mouseOverRemoveSharedFellowship != null) {
            String fsName = this.mouseOverRemoveSharedFellowship.getName();
            packet = new LOTRPacketShareCWP((LOTRCustomWaypoint)this.selectedWaypoint, fsName, false);
            LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
            return;
        }
        if (!this.hasOverlay && k == 0 && this.isMiddleEarth() && this.selectedWaypoint instanceof LOTRCustomWaypoint) {
            LOTRCustomWaypoint cwp = (LOTRCustomWaypoint)this.selectedWaypoint;
            if (!cwp.isShared()) {
                if (mouseWidget == this.widgetDelCWP) {
                    this.openOverlayDelete();
                    return;
                }
                if (mouseWidget == this.widgetRenameCWP) {
                    this.openOverlayRename();
                    return;
                }
                if (mouseWidget == this.widgetShareCWP) {
                    this.openOverlayShare();
                    return;
                }
            } else {
                if (mouseWidget == this.widgetHideSWP) {
                    packet = new LOTRPacketCWPSharedHide(cwp, true);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.selectedWaypoint = null;
                    return;
                }
                if (mouseWidget == this.widgetUnhideSWP) {
                    packet = new LOTRPacketCWPSharedHide(cwp, false);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    return;
                }
            }
        }
        if (!this.hasOverlay && k == 0 && this.isMiddleEarth() && mouseWidget == this.widgetAddCWP && this.canCreateWaypointAtPosition()) {
            this.openOverlayCreate();
            return;
        }
        if (!this.hasOverlay && k == 0) {
            if (mouseWidget == this.widgetToggleWPs) {
                showWP = !showWP;
                LOTRClientProxy.sendClientInfoPacket(null, null);
                return;
            }
            if (mouseWidget == this.widgetToggleCWPs) {
                showCWP = !showCWP;
                LOTRClientProxy.sendClientInfoPacket(null, null);
                return;
            }
            if (mouseWidget == this.widgetToggleHiddenSWPs) {
                showHiddenSWP = !showHiddenSWP;
                LOTRClientProxy.sendClientInfoPacket(null, null);
                return;
            }
            if (this.zoomTicks == 0) {
                if (mouseWidget == this.widgetZoomIn && zoomPower < 4) {
                    this.zoomIn();
                    return;
                }
                if (mouseWidget == this.widgetZoomOut && zoomPower > -3) {
                    this.zoomOut();
                    return;
                }
            }
            if (mouseWidget == this.widgetFullScreen) {
                fullscreen = !fullscreen;
                ScaledResolution sr = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
                this.setWorldAndResolution(this.mc, sr.getScaledWidth(), sr.getScaledHeight());
                return;
            }
            if (mouseWidget == this.widgetSepia) {
                LOTRConfig.toggleSepia();
                return;
            }
            if (mouseWidget == this.widgetLabels) {
                this.toggleMapLabels();
                return;
            }
        }
        if (!this.hasOverlay && !this.loadingConquestGrid && k == 0 && this.isMouseWithinMap) {
            this.selectedWaypoint = null;
            double distanceSelectedWP = Double.MAX_VALUE;
            List<LOTRAbstractWaypoint> waypoints = LOTRLevelData.getData((EntityPlayer)this.mc.thePlayer).getAllAvailableWaypoints();
            for (LOTRAbstractWaypoint waypoint : waypoints) {
                float x;
                float dx;
                float dy;
                float y;
                double distToWP;
                float[] pos;
                boolean unlocked = waypoint.hasPlayerUnlocked((EntityPlayer)this.mc.thePlayer);
                boolean hidden = waypoint.isHidden();
                if (!this.isWaypointVisible(waypoint) || hidden && !unlocked || !((distToWP = Math.sqrt((dx = (x = (pos = this.transformCoords(waypoint.getXCoord(), waypoint.getZCoord()))[0]) - (float)i) * dx + (dy = (y = pos[1]) - (float)j) * dy)) <= 5.0) || !(distToWP <= distanceSelectedWP)) continue;
                this.selectedWaypoint = waypoint;
                distanceSelectedWP = distToWP;
            }
        }
        super.mouseClicked(i, j, k);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.enabled) {
            if (button == this.buttonOverlayFunction) {
                if (this.creatingWaypoint) {
                    this.openOverlayCreateNew();
                } else if (this.creatingWaypointNew && this.isValidWaypointName(this.nameWPTextField.getText())) {
                    String waypointName = this.nameWPTextField.getText();
                    LOTRPacketCreateCWP packet = new LOTRPacketCreateCWP(waypointName);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.closeOverlay();
                } else if (this.deletingWaypoint) {
                    LOTRPacketDeleteCWP packet = new LOTRPacketDeleteCWP((LOTRCustomWaypoint)this.selectedWaypoint);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.closeOverlay();
                    this.selectedWaypoint = null;
                } else if (this.renamingWaypoint && this.isValidWaypointName(this.nameWPTextField.getText())) {
                    String newName = this.nameWPTextField.getText();
                    LOTRPacketRenameCWP packet = new LOTRPacketRenameCWP((LOTRCustomWaypoint)this.selectedWaypoint, newName);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.closeOverlay();
                } else if (this.sharingWaypoint) {
                    this.openOverlayShareNew();
                } else if (this.sharingWaypointNew && this.isExistingUnsharedFellowshipName(this.nameWPTextField.getText(), (LOTRCustomWaypoint)this.selectedWaypoint)) {
                    String fsName = this.nameWPTextField.getText();
                    LOTRPacketShareCWP packet = new LOTRPacketShareCWP((LOTRCustomWaypoint)this.selectedWaypoint, fsName, true);
                    LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
                    this.openOverlayShare();
                }
            } else if (button == this.buttonConquestRegions) {
                List<LOTRDimension.DimensionRegion> regionList = LOTRDimension.MIDDLE_EARTH.dimensionRegions;
                if (!regionList.isEmpty()) {
                    int i = regionList.indexOf((Object)currentRegion);
                    ++i;
                    i = IntMath.mod((int)i, (int)regionList.size());
                    currentRegion = regionList.get(i);
                    this.updateCurrentDimensionAndFaction();
                    this.setCurrentScrollFromFaction();
                }
            } else {
                super.actionPerformed(button);
            }
        }
    }

    private void handleMapKeyboardMovement() {
        this.prevPosX += this.posXMove;
        this.prevPosY += this.posYMove;
        this.posXMove = 0.0f;
        this.posYMove = 0.0f;
        if (!this.hasOverlay) {
            float move = 12.0f / (float)Math.pow(this.zoomScale, 0.800000011920929);
            if (this.isKeyDownAndNotMouse(this.mc.gameSettings.keyBindLeft) || Keyboard.isKeyDown((int)203)) {
                this.posXMove -= move;
            }
            if (this.isKeyDownAndNotMouse(this.mc.gameSettings.keyBindRight) || Keyboard.isKeyDown((int)205)) {
                this.posXMove += move;
            }
            if (this.isKeyDownAndNotMouse(this.mc.gameSettings.keyBindForward) || Keyboard.isKeyDown((int)200)) {
                this.posYMove -= move;
            }
            if (this.isKeyDownAndNotMouse(this.mc.gameSettings.keyBindBack) || Keyboard.isKeyDown((int)208)) {
                this.posYMove += move;
            }
            if (this.posXMove != 0.0f || this.posYMove != 0.0f) {
                this.selectedWaypoint = null;
            }
        }
    }

    private boolean isKeyDownAndNotMouse(KeyBinding keybinding) {
        return keybinding.getKeyCode() >= 0 && GameSettings.isKeyDown((KeyBinding)keybinding);
    }

    public void handleMouseInput() {
        super.handleMouseInput();
        int k = Mouse.getEventDWheel();
        if (this.isConquestGrid && this.hasConquestScrollBar() && this.mouseInFacScroll && k != 0) {
            if (k < 0) {
                this.currentFactionIndex = Math.min(this.currentFactionIndex + 1, Math.max(0, currentFactionList.size() - 1));
            } else if (k > 0) {
                this.currentFactionIndex = Math.max(this.currentFactionIndex - 1, 0);
            }
            this.setCurrentScrollFromFaction();
            return;
        }
        if (!this.hasOverlay && this.zoomTicks == 0) {
            if (k < 0 && zoomPower > -3) {
                this.zoomOut();
                return;
            }
            if (k > 0 && zoomPower < 4) {
                this.zoomIn();
                return;
            }
        }
        if (this.hasOverlay && k != 0) {
            k = Integer.signum(k);
            if (this.scrollPaneWPShares.hasScrollBar && this.scrollPaneWPShares.mouseOver) {
                int l = this.displayedWPShareList.size() - this.displayedWPShares;
                this.scrollPaneWPShares.mouseWheelScroll(k, l);
                return;
            }
        }
    }

    private void zoomOut() {
        this.zoom(-1);
    }

    private void zoomIn() {
        this.zoom(1);
    }

    private void zoom(int boost) {
        this.prevZoomPower = zoomPower;
        zoomPower += boost;
        this.zoomTicks = zoomTicksMax;
        this.selectedWaypoint = null;
    }

    public void setCWPProtectionMessage(IChatComponent message) {
        this.closeOverlay();
        this.hasOverlay = true;
        this.creatingWaypoint = false;
        this.creatingWaypointNew = false;
        String protection = StatCollector.translateToLocalFormatted((String)"lotr.gui.map.customWaypoint.protected.1", (Object[])new Object[]{message.getFormattedText()});
        String warning = StatCollector.translateToLocal((String)"lotr.gui.map.customWaypoint.protected.2");
        this.overlayLines = new String[]{protection, "", warning};
    }

    private boolean canTeleport() {
        if (!this.isMiddleEarth()) {
            return false;
        }
        if (this.loadingConquestGrid) {
            return false;
        }
        int chunkX = MathHelper.floor_double((double)this.mc.thePlayer.posX) >> 4;
        int chunkZ = MathHelper.floor_double((double)this.mc.thePlayer.posZ) >> 4;
        if (this.mc.theWorld.getChunkProvider().provideChunk(chunkX, chunkZ) instanceof EmptyChunk) {
            return false;
        }
        this.requestIsOp();
        return this.isPlayerOp;
    }

    private void requestIsOp() {
        if (this.mc.isSingleplayer()) {
            IntegratedServer server = this.mc.getIntegratedServer();
            this.isPlayerOp = server.worldServers[0].getWorldInfo().areCommandsAllowed() && server.getServerOwner().equalsIgnoreCase(this.mc.thePlayer.getGameProfile().getName());
        } else {
            LOTRPacketIsOpRequest packet = new LOTRPacketIsOpRequest();
            LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
        }
    }

    private boolean isMiddleEarth() {
        return this.mc.thePlayer.dimension == LOTRDimension.MIDDLE_EARTH.dimensionID;
    }

    private void requestConquestGridIfNeed(LOTRFaction conqFac) {
        if (!this.requestedFacGrids.contains((Object)conqFac) && this.ticksUntilRequestFac <= 0) {
            this.requestedFacGrids.add(conqFac);
            LOTRPacketConquestGridRequest packet = new LOTRPacketConquestGridRequest(conqFac);
            LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
        }
    }

    public void receiveConquestGrid(LOTRFaction conqFac, List<LOTRConquestZone> allZones) {
        if (this.isConquestGrid) {
            this.receivedFacGrids.add(conqFac);
            this.facConquestGrids.put(conqFac, allZones);
        }
    }

    private boolean hasConquestScrollBar() {
        return this.isConquestGrid && currentFactionList.size() > 1;
    }

    private void setupConquestScrollBar(int i, int j) {
        boolean isMouseDown = Mouse.isButtonDown((int)0);
        int i1 = this.facScrollX;
        int j1 = this.facScrollY;
        int i2 = i1 + this.facScrollWidth;
        int j2 = j1 + this.facScrollHeight;
        boolean bl = this.mouseInFacScroll = i >= i1 && j >= j1 && i < i2 && j < j2;
        if (!this.wasMouseDown && isMouseDown && this.mouseInFacScroll) {
            this.isFacScrolling = true;
        }
        if (!isMouseDown) {
            this.isFacScrolling = false;
        }
        this.wasMouseDown = isMouseDown;
        if (this.isFacScrolling) {
            this.currentFacScroll = ((float)(i - i1) - (float)this.facScrollWidgetWidth / 2.0f) / ((float)(i2 - i1) - (float)this.facScrollWidgetWidth);
            this.currentFacScroll = MathHelper.clamp_float((float)this.currentFacScroll, (float)0.0f, (float)1.0f);
            this.currentFactionIndex = Math.round(this.currentFacScroll * (float)(currentFactionList.size() - 1));
        }
    }

    private void setCurrentScrollFromFaction() {
        this.currentFacScroll = (float)this.currentFactionIndex / (float)(currentFactionList.size() - 1);
    }

    private boolean hasMapLabels() {
        if (this.isConquestGrid) {
            return LOTRConfig.mapLabelsConquest;
        }
        return LOTRConfig.mapLabels;
    }

    private void toggleMapLabels() {
        if (this.isConquestGrid) {
            LOTRConfig.toggleMapLabelsConquest();
        } else {
            LOTRConfig.toggleMapLabels();
        }
    }

    public void setFakeMapProperties(float x, float y, float scale, float scaleExp, float scaleStable) {
        this.posX = x;
        this.posY = y;
        this.zoomScale = scale;
        this.zoomExp = scaleExp;
        this.zoomScaleStable = scaleStable;
    }

    public static int[] setFakeStaticProperties(int w, int h, int xmin, int xmax, int ymin, int ymax) {
        int[] ret = new int[]{mapWidth, mapHeight, mapXMin, mapXMax, mapYMin, mapYMax};
        mapWidth = w;
        mapHeight = h;
        mapXMin = xmin;
        mapXMax = xmax;
        mapYMin = ymin;
        mapYMax = ymax;
        return ret;
    }

    private static boolean isOSRS() {
        return LOTRConfig.osrsMap;
    }

    static {
        mapWidgets = new ArrayList<LOTRGuiMapWidget>();
        zoomPower = 0;
        zoomTicksMax = 6;
        showWP = true;
        showCWP = true;
        showHiddenSWP = false;
        lastViewedRegions = new HashMap<LOTRDimension.DimensionRegion, LOTRFaction>();
    }

    private static class PlayerLocationInfo {
        public GameProfile profile;
        public double posX;
        public double posZ;

        public PlayerLocationInfo(GameProfile p, double x, double z) {
            this.profile = p;
            this.posX = x;
            this.posZ = z;
        }
    }

}

