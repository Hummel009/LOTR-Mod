/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.common.eventhandler.EventBus
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.AbstractTexture
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.texture.ITextureObject
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraft.client.resources.IReloadableResourceManager
 *  net.minecraft.client.resources.IResource
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.client.resources.IResourceManagerReloadListener
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.event.TextureStitchEvent
 *  net.minecraftforge.client.event.TextureStitchEvent$Pre
 *  net.minecraftforge.common.MinecraftForge
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.opengl.GL11
 */
package lotr.client;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import lotr.client.gui.LOTRGuiMap;
import lotr.client.render.LOTRBufferedImageIcon;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRConfig;
import lotr.common.LOTRDimension;
import lotr.common.LOTRLevelData;
import lotr.common.util.LOTRColorUtil;
import lotr.common.util.LOTRCommonIcons;
import lotr.common.util.LOTRLog;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeDecorator;
import lotr.common.world.biome.LOTRBiomeGenMordor;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public class LOTRTextures
implements IResourceManagerReloadListener {
    private static Minecraft mc = Minecraft.getMinecraft();
    public static ResourceLocation missingTexture = mc.getTextureManager().getDynamicTextureLocation("lotr.missingSkin", TextureUtil.missingTexture);
    private static ResourceLocation mapTexture;
    private static ResourceLocation sepiaMapTexture;
    public static ResourceLocation overlayTexture;
    public static ResourceLocation mapTerrain;
    public static final ResourceLocation osrsTexture;
    public static final int OSRS_WATER = 6453158;
    public static final int OSRS_GRASS = 5468426;
    public static final int OSRS_BEACH = 9279778;
    public static final int OSRS_HILL = 6575407;
    public static final int OSRS_MOUNTAIN = 14736861;
    public static final int OSRS_MOUNTAIN_EDGE = 9005125;
    public static final int OSRS_SNOW = 14215139;
    public static final int OSRS_TUNDRA = 9470587;
    public static final int OSRS_SAND = 13548147;
    public static final int OSRS_TREE = 2775058;
    public static final int OSRS_WILD = 3290677;
    public static final int OSRS_PATH = 6575407;
    public static final int OSRS_KINGDOM_COLOR = 16755200;
    private static ResourceLocation particleTextures;
    private static ResourceLocation newWaterParticles;
    private static int newWaterU;
    private static int newWaterV;
    private static int newWaterWidth;
    private static int newWaterHeight;
    private static Map<ResourceLocation, ResourceLocation> eyesTextures;
    private static Map<ResourceLocation, Integer> averagedPageColors;

    public static void load() {
        IResourceManager resMgr = mc.getResourceManager();
        TextureManager texMgr = mc.getTextureManager();
        LOTRTextures textures = new LOTRTextures();
        textures.onResourceManagerReload(resMgr);
        ((IReloadableResourceManager)resMgr).registerReloadListener((IResourceManagerReloadListener)textures);
        MinecraftForge.EVENT_BUS.register((Object)textures);
        TextureMap texMapBlocks = (TextureMap)texMgr.getTexture(TextureMap.locationBlocksTexture);
        TextureMap texMapItems = (TextureMap)texMgr.getTexture(TextureMap.locationItemsTexture);
        textures.preTextureStitch(new TextureStitchEvent.Pre(texMapBlocks));
        textures.preTextureStitch(new TextureStitchEvent.Pre(texMapItems));
    }

    public void onResourceManagerReload(IResourceManager resourceManager) {
        LOTRTextures.loadMapTextures();
        LOTRTextures.replaceWaterParticles();
        eyesTextures.clear();
        averagedPageColors.clear();
    }

    @SubscribeEvent
    public void preTextureStitch(TextureStitchEvent.Pre event) {
        TextureMap map = event.map;
        if (map.getTextureType() == 0) {
            LOTRCommonIcons.iconEmptyBlock = LOTRTextures.generateIconEmpty(map);
            LOTRCommonIcons.iconStoneSnow = map.registerIcon("stone_snow");
        }
        if (map.getTextureType() == 1) {
            LOTRCommonIcons.iconEmptyItem = LOTRTextures.generateIconEmpty(map);
            LOTRCommonIcons.iconMeleeWeapon = map.registerIcon("lotr:slotMelee");
            LOTRCommonIcons.iconBomb = map.registerIcon("lotr:slotBomb");
        }
    }

    public static void drawMap(EntityPlayer entityplayer, double x0, double x1, double y0, double y1, double z, double minU, double maxU, double minV, double maxV) {
        LOTRTextures.drawMap(entityplayer, LOTRConfig.enableSepiaMap, x0, x1, y0, y1, z, minU, maxU, minV, maxV, 1.0f);
    }

    public static void drawMap(EntityPlayer entityplayer, boolean sepia, double x0, double x1, double y0, double y1, double z, double minU, double maxU, double minV, double maxV, float alpha) {
        boolean meneltarma;
        Tessellator tessellator = Tessellator.instance;
        mc.getTextureManager().bindTexture(LOTRTextures.getMapTexture(entityplayer, sepia));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x0, y1, z, minU, maxV);
        tessellator.addVertexWithUV(x1, y1, z, maxU, maxV);
        tessellator.addVertexWithUV(x1, y0, z, maxU, minV);
        tessellator.addVertexWithUV(x0, y0, z, minU, minV);
        tessellator.draw();
        boolean bl = meneltarma = entityplayer != null && LOTRLevelData.getData(entityplayer).hasAchievement(LOTRAchievement.enterMeneltarma);
        if (!meneltarma) {
            double mtX = LOTRWaypoint.MENELTARMA_SUMMIT.getX();
            double mtY = LOTRWaypoint.MENELTARMA_SUMMIT.getY();
            int mtW = 20;
            double mtMinU = (mtX - (double)mtW) / (double)LOTRGenLayerWorld.imageWidth;
            double mtMaxU = (mtX + (double)mtW) / (double)LOTRGenLayerWorld.imageWidth;
            double mtMinV = (mtY - (double)mtW) / (double)LOTRGenLayerWorld.imageHeight;
            double mtMaxV = (mtY + (double)mtW) / (double)LOTRGenLayerWorld.imageHeight;
            if (minU <= mtMaxU && maxU >= mtMinU && minV <= mtMaxV && maxV >= mtMinV) {
                GL11.glDisable((int)3553);
                int oceanColor = LOTRTextures.getMapOceanColor(sepia);
                mtMinU = Math.max(mtMinU, minU);
                mtMaxU = Math.min(mtMaxU, maxU);
                mtMinV = Math.max(mtMinV, minV);
                mtMaxV = Math.min(mtMaxV, maxV);
                double ratioX = (x1 - x0) / (maxU - minU);
                double ratioY = (y1 - y0) / (maxV - minV);
                double mtX0 = x0 + (mtMinU - minU) * ratioX;
                double mtX1 = x0 + (mtMaxU - minU) * ratioX;
                double mtY0 = y0 + (mtMinV - minV) * ratioY;
                double mtY1 = y0 + (mtMaxV - minV) * ratioY;
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(oceanColor);
                tessellator.addVertexWithUV(mtX0, mtY1, z, mtMinU, mtMaxV);
                tessellator.addVertexWithUV(mtX1, mtY1, z, mtMaxU, mtMaxV);
                tessellator.addVertexWithUV(mtX1, mtY0, z, mtMaxU, mtMinV);
                tessellator.addVertexWithUV(mtX0, mtY0, z, mtMinU, mtMinV);
                tessellator.draw();
                GL11.glEnable((int)3553);
            }
        }
    }

    public static void drawMapOverlay(EntityPlayer entityplayer, double x0, double x1, double y0, double y1, double z, double minU, double maxU, double minV, double maxV) {
        Tessellator tessellator = Tessellator.instance;
        mc.getTextureManager().bindTexture(overlayTexture);
        GL11.glEnable((int)3042);
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.2f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x0, y1, z, 0.0, 1.0);
        tessellator.addVertexWithUV(x1, y1, z, 1.0, 1.0);
        tessellator.addVertexWithUV(x1, y0, z, 1.0, 0.0);
        tessellator.addVertexWithUV(x0, y0, z, 0.0, 0.0);
        tessellator.draw();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
    }

    public static void drawMapCompassBottomLeft(double x, double y, double z, double scale) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        mc.getTextureManager().bindTexture(LOTRGuiMap.mapIconsTexture);
        int width = 32;
        int height = 32;
        double x0 = x;
        double x1 = x + (double)width * scale;
        double y0 = y - (double)height * scale;
        double y1 = y;
        int texU = 224;
        int texV = 200;
        float u0 = (float)texU / 256.0f;
        float u1 = (float)(texU + width) / 256.0f;
        float v0 = (float)texV / 256.0f;
        float v1 = (float)(texV + height) / 256.0f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x0, y1, z, (double)u0, (double)v1);
        tessellator.addVertexWithUV(x1, y1, z, (double)u1, (double)v1);
        tessellator.addVertexWithUV(x1, y0, z, (double)u1, (double)v0);
        tessellator.addVertexWithUV(x0, y0, z, (double)u0, (double)v0);
        tessellator.draw();
    }

    private static ResourceLocation getMapTexture(EntityPlayer entityplayer, boolean sepia) {
        return LOTRConfig.osrsMap || sepia ? sepiaMapTexture : mapTexture;
    }

    public static int getMapOceanColor(boolean sepia) {
        if (LOTRConfig.osrsMap) {
            return -10324058;
        }
        int ocean = LOTRBiome.ocean.color;
        if (sepia) {
            ocean = LOTRTextures.getSepia(ocean);
        }
        return ocean;
    }

    public static void loadMapTextures() {
        mapTexture = new ResourceLocation("lotr:map/map.png");
        try {
            BufferedImage mapImage = ImageIO.read(mc.getResourceManager().getResource(mapTexture).getInputStream());
            sepiaMapTexture = LOTRTextures.convertToSepia(mapImage, new ResourceLocation("lotr:map_sepia"));
        }
        catch (IOException e) {
            FMLLog.severe((String)"Failed to generate LOTR sepia map", (Object[])new Object[0]);
            e.printStackTrace();
            sepiaMapTexture = mapTexture;
        }
    }

    private static ResourceLocation convertToSepia(BufferedImage srcImage, ResourceLocation resourceLocation) {
        int mapWidth = srcImage.getWidth();
        int mapHeight = srcImage.getHeight();
        int[] colors = srcImage.getRGB(0, 0, mapWidth, mapHeight, null, 0, mapWidth);
        for (int i = 0; i < colors.length; ++i) {
            int color = colors[i];
            if (LOTRConfig.osrsMap) {
                Integer biomeID = LOTRDimension.MIDDLE_EARTH.colorsToBiomeIDs.get(color);
                if (biomeID == null) {
                    color = LOTRTextures.getMapOceanColor(true);
                } else {
                    LOTRBiome biome = LOTRDimension.MIDDLE_EARTH.biomeList[biomeID];
                    color = biome.heightBaseParameter < 0.0f ? 6453158 : (biome.heightBaseParameter > 0.8f ? 14736861 : (biome.heightBaseParameter > 0.4f ? 6575407 : (biome instanceof LOTRBiomeGenMordor ? 3290677 : (biome.decorator.treesPerChunk > 1 ? 2775058 : (biome.temperature < 0.3f ? (biome.temperature < 0.2f ? 14215139 : 9470587) : (biome.rainfall < 0.2f ? 13548147 : 5468426))))));
                }
            } else {
                color = LOTRTextures.getSepia(color);
            }
            colors[i] = color;
        }
        BufferedImage newMapImage = new BufferedImage(mapWidth, mapHeight, 2);
        newMapImage.setRGB(0, 0, mapWidth, mapHeight, colors, 0, mapWidth);
        if (LOTRConfig.osrsMap) {
            BufferedImage temp = newMapImage;
            newMapImage = new BufferedImage(mapWidth, mapHeight, 2);
            for (int i = 0; i < mapWidth; ++i) {
                for (int j = 0; j < mapHeight; ++j) {
                    int range;
                    int y1;
                    int rgb1;
                    int y;
                    int total;
                    int x1;
                    int x;
                    int rgb = temp.getRGB(i, j);
                    if (rgb == 5468426) {
                        range = 8;
                        int water = 0;
                        total = 0;
                        for (x = -range; x < range; ++x) {
                            for (y = -range; y < range; ++y) {
                                x1 = i + x;
                                y1 = y + j;
                                if (x1 < 0 || x1 >= mapWidth || y1 < 0 || y1 >= mapHeight) continue;
                                rgb1 = temp.getRGB(x1, y1);
                                if (rgb1 == 6453158) {
                                    ++water;
                                }
                                ++total;
                            }
                        }
                        if (water > 0) {
                            float ratio = (float)water / (float)total;
                            rgb = LOTRColorUtil.lerpColors_I(5468426, 9279778, ratio * 2.0f);
                        }
                    } else if (rgb == 14736861) {
                        range = 8;
                        int edge = 0;
                        total = 0;
                        for (x = -range; x < range; ++x) {
                            for (y = -range; y < range; ++y) {
                                x1 = i + x;
                                y1 = y + j;
                                if (x1 < 0 || x1 >= mapWidth || y1 < 0 || y1 >= mapHeight) continue;
                                rgb1 = temp.getRGB(x1, y1);
                                if (rgb1 != 14736861) {
                                    ++edge;
                                }
                                ++total;
                            }
                        }
                        if (edge > 0) {
                            float ratio = (float)edge / (float)total;
                            rgb = LOTRColorUtil.lerpColors_I(14736861, 9005125, ratio * 1.5f);
                        }
                    }
                    newMapImage.setRGB(i, j, rgb | 0xFF000000);
                }
            }
        }
        LOTRTextures.mc.renderEngine.loadTexture(resourceLocation, (ITextureObject)new DynamicTexture(newMapImage));
        return resourceLocation;
    }

    private static int getSepia(int rgb) {
        Color color = new Color(rgb);
        int alpha = rgb >> 24 & 0xFF;
        float[] colors = color.getColorComponents(null);
        float r = colors[0];
        float g = colors[1];
        float b = colors[2];
        float newR = r * 0.79f + g * 0.39f + b * 0.26f;
        float newG = r * 0.52f + g * 0.35f + b * 0.19f;
        float newB = r * 0.35f + g * 0.26f + b * 0.15f;
        newR = Math.min(Math.max(0.0f, newR), 1.0f);
        newG = Math.min(Math.max(0.0f, newG), 1.0f);
        newB = Math.min(Math.max(0.0f, newB), 1.0f);
        int sepia = new Color(newR, newG, newB).getRGB();
        return sepia |= alpha << 24;
    }

    public static void replaceWaterParticles() {
        try {
            IResourceManager resMgr = mc.getResourceManager();
            IResource loadedParticles = resMgr.getResource(particleTextures);
            BufferedImage particles = ImageIO.read(loadedParticles.getInputStream());
            BufferedImage waterParticles = ImageIO.read(resMgr.getResource(newWaterParticles).getInputStream());
            int[] rgb = waterParticles.getRGB(0, 0, waterParticles.getWidth(), waterParticles.getHeight(), null, 0, waterParticles.getWidth());
            particles.setRGB(newWaterU, newWaterV, newWaterWidth, newWaterHeight, rgb, 0, newWaterWidth);
            TextureManager textureManager = mc.getTextureManager();
            textureManager.bindTexture(particleTextures);
            AbstractTexture texture = (AbstractTexture)textureManager.getTexture(particleTextures);
            TextureUtil.uploadTextureImageAllocate((int)texture.getGlTextureId(), (BufferedImage)particles, (boolean)false, (boolean)false);
        }
        catch (IOException e) {
            FMLLog.severe((String)"Failed to replace rain particles", (Object[])new Object[0]);
            e.printStackTrace();
        }
    }

    public static ResourceLocation getEyesTexture(ResourceLocation skin, int[][] eyesCoords, int eyeWidth, int eyeHeight) {
        ResourceLocation eyes = eyesTextures.get((Object)skin);
        if (eyes == null) {
            try {
                BufferedImage skinImage = ImageIO.read(mc.getResourceManager().getResource(skin).getInputStream());
                int skinWidth = skinImage.getWidth();
                int skinHeight = skinImage.getHeight();
                BufferedImage eyesImage = new BufferedImage(skinWidth, skinHeight, 2);
                for (int[] eyePos : eyesCoords) {
                    int eyeX = eyePos[0];
                    int eyeY = eyePos[1];
                    for (int i = eyeX; i < eyeX + eyeWidth; ++i) {
                        for (int j = eyeY; j < eyeY + eyeHeight; ++j) {
                            int rgb = skinImage.getRGB(i, j);
                            eyesImage.setRGB(i, j, rgb);
                        }
                    }
                }
                eyes = LOTRTextures.mc.renderEngine.getDynamicTextureLocation(skin.toString() + "_eyes_" + eyeWidth + "_" + eyeHeight, new DynamicTexture(eyesImage));
            }
            catch (IOException e) {
                LOTRLog.logger.error("Failed to generate eyes skin");
                e.printStackTrace();
                eyes = missingTexture;
            }
            eyesTextures.put(skin, eyes);
        }
        return eyes;
    }

    private static IIcon generateIconEmpty(TextureMap textureMap) {
		String iconName = "textures/blocks/LOTR_EMPTY_ICON";
		int size = 16;
		BufferedImage iconImage = new BufferedImage(size, size, 2);
		for (int i = 0; i < iconImage.getWidth(); ++i) {
			for (int j = 0; j < iconImage.getHeight(); ++j) {
				int rgb = 0;
				int alpha = 0;
				iconImage.setRGB(i, j, rgb |= alpha);
			}
		}
		LOTRBufferedImageIcon icon = new LOTRBufferedImageIcon(iconName, iconImage);
		icon.setIconWidth(iconImage.getWidth());
		icon.setIconHeight(iconImage.getHeight());
		textureMap.setTextureEntry(iconName, icon);
		return icon;
	}

    public static int computeAverageFactionPageColor(ResourceLocation texture, int u0, int v0, int u1, int v1) {
        if (!averagedPageColors.containsKey((Object)texture)) {
            int avgColor = 0;
            try {
                BufferedImage pageImage = ImageIO.read(mc.getResourceManager().getResource(texture).getInputStream());
                long totalR = 0L;
                long totalG = 0L;
                long totalB = 0L;
                long totalA = 0L;
                int count = 0;
                for (int u = u0; u < u1; ++u) {
                    for (int v = v0; v < v1; ++v) {
                        int rgb = pageImage.getRGB(u, v);
                        Color color = new Color(rgb);
                        totalR += (long)color.getRed();
                        totalG += (long)color.getGreen();
                        totalB += (long)color.getBlue();
                        totalA += (long)color.getAlpha();
                        ++count;
                    }
                }
                int avgR = (int)(totalR / (long)count);
                int avgG = (int)(totalG / (long)count);
                int avgB = (int)(totalB / (long)count);
                int avgA = (int)(totalA / (long)count);
                avgColor = new Color(avgR, avgG, avgB, avgA).getRGB();
            }
            catch (IOException e) {
                FMLLog.severe((String)"LOTR: Failed to generate average page colour", (Object[])new Object[0]);
                e.printStackTrace();
                avgColor = 0;
            }
            averagedPageColors.put(texture, avgColor);
            return avgColor;
        }
        return averagedPageColors.get((Object)texture);
    }

    public static int findContrastingColor(int text, int bg) {
        Color cText = new Color(text);
        Color cBg = new Color(bg);
        float[] hsbText = Color.RGBtoHSB(cText.getRed(), cText.getGreen(), cText.getBlue(), null);
        float[] hsbBg = Color.RGBtoHSB(cBg.getRed(), cBg.getGreen(), cBg.getBlue(), null);
        float bText = hsbText[2];
        float bBg = hsbBg[2];
        float limit = 0.4f;
        if (Math.abs(bText - bBg) < limit) {
            bText = bBg > 0.66f ? bBg - limit : bBg + limit;
        }
        return Color.HSBtoRGB(hsbText[0], hsbText[1], bText);
    }

    static {
        overlayTexture = new ResourceLocation("lotr:map/mapOverlay.png");
        mapTerrain = new ResourceLocation("lotr:map/terrain.png");
        osrsTexture = new ResourceLocation("lotr:map/osrs.png");
        particleTextures = new ResourceLocation("textures/particle/particles.png");
        newWaterParticles = new ResourceLocation("lotr:misc/waterParticles.png");
        newWaterU = 0;
        newWaterV = 8;
        newWaterWidth = 64;
        newWaterHeight = 8;
        eyesTextures = new HashMap<ResourceLocation, ResourceLocation>();
        averagedPageColors = new HashMap<ResourceLocation, Integer>();
    }
}

