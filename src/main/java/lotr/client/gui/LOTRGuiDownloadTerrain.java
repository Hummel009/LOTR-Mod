/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiDownloadTerrain
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.util.StatCollector
 *  org.lwjgl.opengl.GL11
 */
package lotr.client.gui;

import lotr.client.gui.LOTRGuiMap;
import lotr.client.gui.LOTRGuiRendererMap;
import lotr.common.LOTRDimension;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class LOTRGuiDownloadTerrain
extends GuiDownloadTerrain {
    private LOTRGuiMap mapGui = new LOTRGuiMap();
    private LOTRGuiRendererMap mapRenderer = new LOTRGuiRendererMap();
    private static final int mapBorder = 40;
    private static final float MAP_ZOOM = -0.3f;
    private int tickCounter;

    public LOTRGuiDownloadTerrain(NetHandlerPlayClient handler) {
        super(handler);
        this.mapRenderer.setSepia(true);
    }

    public void setWorldAndResolution(Minecraft mc, int i, int j) {
        super.setWorldAndResolution(mc, i, j);
        this.mapGui.setWorldAndResolution(mc, i, j);
    }

    public void updateScreen() {
        super.updateScreen();
        ++this.tickCounter;
    }

    public void drawScreen(int i, int j, float f) {
        int dimension = this.mc.thePlayer.dimension;
        if (dimension == LOTRDimension.MIDDLE_EARTH.dimensionID) {
            this.drawBackground(0);
            GL11.glEnable((int)3008);
            GL11.glEnable((int)3042);
            OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
            this.mapRenderer.prevMapX = this.mapRenderer.mapX = (double)LOTRWaypoint.worldToMapX(this.mc.thePlayer.posX);
            this.mapRenderer.prevMapY = this.mapRenderer.mapY = (double)LOTRWaypoint.worldToMapZ(this.mc.thePlayer.posZ);
            this.mapRenderer.zoomExp = -0.3f;
            this.mapRenderer.zoomStable = (float)Math.pow(2.0, -0.30000001192092896);
            int x0 = 0;
            int x1 = this.width;
            int y0 = 40;
            int y1 = this.height - 40;
            this.mapRenderer.renderMap((GuiScreen)this, this.mapGui, f, x0, y0, x1, y1);
            this.mapRenderer.renderVignettes((GuiScreen)this, this.zLevel, 1, x0, y0, x1, y1);
            GL11.glDisable((int)3042);
            String s = StatCollector.translateToLocal((String)"lotr.loading.enterME");
            this.drawCenteredString(this.fontRendererObj, s, this.width / 2, this.height / 2 - 50, 16777215);
        } else if (dimension == LOTRDimension.UTUMNO.dimensionID) {
            LOTRGuiDownloadTerrain.drawRect((int)0, (int)0, (int)this.width, (int)this.height, (int)-16777216);
            GL11.glEnable((int)3042);
            float alpha = 1.0f - (float)this.tickCounter / 120.0f;
            int alphaI = (int)(alpha * 255.0f);
            if (alphaI > 4) {
                String s = StatCollector.translateToLocal((String)"lotr.loading.enterUtumno");
                this.drawCenteredString(this.fontRendererObj, s, this.width / 2, this.height / 2 - 50, alphaI << 24 | 0xFFFFFF);
            }
            GL11.glDisable((int)3042);
        } else {
            super.drawScreen(i, j, f);
        }
    }
}

