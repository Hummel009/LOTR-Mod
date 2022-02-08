/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package lotr.client.gui;

import java.util.List;
import lotr.client.LOTRTextures;
import lotr.client.gui.LOTRGuiMap;
import lotr.common.world.map.LOTRAbstractWaypoint;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class LOTRGuiRendererMap {
    private static final ResourceLocation vignetteTexture = new ResourceLocation("textures/misc/vignette.png");
    public double prevMapX;
    public double mapX;
    public double prevMapY;
    public double mapY;
    public float zoomExp;
    public float zoomStable;
    private boolean sepia = false;

    public void setSepia(boolean flag) {
        this.sepia = flag;
    }

    public void updateTick() {
        this.prevMapX = this.mapX;
        this.prevMapY = this.mapY;
    }

    public void renderMap(GuiScreen gui, LOTRGuiMap mapGui, float f) {
        this.renderMap(gui, mapGui, f, 0, 0, gui.width, gui.height);
    }

    public void renderMap(GuiScreen gui, LOTRGuiMap mapGui, float f, int x0, int y0, int x1, int y1) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int oceanColor = LOTRTextures.getMapOceanColor(this.sepia);
        GuiScreen.drawRect((int)x0, (int)y0, (int)x1, (int)y1, (int)oceanColor);
        float zoom = (float)Math.pow(2.0, this.zoomExp);
        double mapPosX = this.prevMapX + (this.mapX - this.prevMapX) * (double)f;
        double mapPosY = this.prevMapY + (this.mapY - this.prevMapY) * (double)f;
        mapGui.setFakeMapProperties((float)mapPosX, (float)mapPosY, zoom, this.zoomExp, this.zoomStable);
        int[] statics = LOTRGuiMap.setFakeStaticProperties(x1 - x0, y1 - y0, x0, x1, y0, y1);
        mapGui.enableZoomOutWPFading = false;
        mapGui.renderMapAndOverlay(this.sepia, 1.0f, true);
        mapGui.renderRoads(false);
        mapGui.renderWaypoints(LOTRWaypoint.listAllWaypoints(), 0, 0, 0, false, true);
        LOTRGuiMap.setFakeStaticProperties(statics[0], statics[1], statics[2], statics[3], statics[4], statics[5]);
    }

    public void renderVignette(GuiScreen gui, double zLevel) {
        this.renderVignette(gui, zLevel, 0, 0, gui.width, gui.height);
    }

    public void renderVignette(GuiScreen gui, double zLevel, int x0, int y0, int x1, int y1) {
        GL11.glEnable((int)3042);
        OpenGlHelper.glBlendFunc((int)771, (int)769, (int)1, (int)0);
        float alpha = 1.0f;
        GL11.glColor4f((float)alpha, (float)alpha, (float)alpha, (float)1.0f);
        gui.mc.getTextureManager().bindTexture(vignetteTexture);
        double u0 = (double)x0 / (double)gui.width;
        double u1 = (double)x1 / (double)gui.width;
        double v0 = (double)y0 / (double)gui.height;
        double v1 = (double)y1 / (double)gui.height;
        double z = zLevel;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)x0, (double)y1, z, u0, v1);
        tessellator.addVertexWithUV((double)x1, (double)y1, z, u1, v1);
        tessellator.addVertexWithUV((double)x1, (double)y0, z, u1, v0);
        tessellator.addVertexWithUV((double)x0, (double)y0, z, u0, v0);
        tessellator.draw();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
    }

    public void renderVignettes(GuiScreen gui, double zLevel, int count) {
        for (int l = 0; l < count; ++l) {
            this.renderVignette(gui, zLevel);
        }
    }

    public void renderVignettes(GuiScreen gui, double zLevel, int count, int x0, int y0, int x1, int y1) {
        for (int l = 0; l < count; ++l) {
            this.renderVignette(gui, zLevel, x0, y0, x1, y1);
        }
    }
}

