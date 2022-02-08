/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.client.resources.IResourceManagerReloadListener
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package lotr.client.render.tileentity;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import lotr.common.tileentity.LOTRTileEntitySignCarved;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class LOTRRenderSignCarved
extends TileEntitySpecialRenderer
implements IResourceManagerReloadListener {
    private BufferedImage cachedBlockAtlasImage;
    private final Map<IIcon, Integer> iconAverageColors = new HashMap<IIcon, Integer>();
    private final Map<IIcon, Integer> iconContrastColors = new HashMap<IIcon, Integer>();

    public void onResourceManagerReload(IResourceManager resourceManager) {
        this.cachedBlockAtlasImage = null;
        this.iconAverageColors.clear();
        this.iconContrastColors.clear();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
        LOTRTileEntitySignCarved sign = (LOTRTileEntitySignCarved)tileentity;
        int meta = tileentity.getBlockMetadata();
        float rotation = (float)Direction.facingToDirection[meta] * 90.0f;
        float f1 = 0.6666667f;
        float f3 = 0.016666668f * f1;
        GL11.glDisable((int)32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d + 0.5f), (float)((float)d1 + 0.75f * f1), (float)((float)d2 + 0.5f));
        GL11.glRotatef((float)(-rotation), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)-0.3125f, (float)-0.4375f);
        GL11.glTranslatef((float)0.0f, (float)(0.5f * f1), (float)(-0.09f * f1));
        GL11.glScalef((float)f3, (float)(-f3), (float)f3);
        GL11.glNormal3f((float)0.0f, (float)0.0f, (float)(-1.0f * f3));
        GL11.glDepthMask((boolean)false);
        FontRenderer fontrenderer = this.func_147498_b();
        int color = this.getTextColor(sign, f);
        int signLines = sign.signText.length;
        int lineHeight = fontrenderer.FONT_HEIGHT + 1;
        int lineBase = -signLines * 5;
        if (signLines > 4) {
            lineBase = -((signLines - 1) * lineHeight) / 2;
        }
        for (int l = 0; l < signLines; ++l) {
            String s = sign.signText[l];
            if (l == sign.lineBeingEdited) {
                s = "> " + s + " <";
            }
            int lineX = -fontrenderer.getStringWidth(s) / 2;
            int lineY = lineBase + l * lineHeight;
            fontrenderer.drawString(s, lineX, lineY, color);
        }
        GL11.glDepthMask((boolean)true);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    protected int getTextColor(LOTRTileEntitySignCarved sign, float f) {
        return this.getContrastingColor(sign.getOnBlockIcon());
    }

    private int getContrastingColor(IIcon icon) {
        if (this.iconContrastColors.containsKey((Object)icon)) {
            return this.iconContrastColors.get((Object)icon);
        }
        int color = this.averageIconColor(icon);
        color = this.calculateContrast(icon, color);
        this.iconContrastColors.put(icon, color);
        return color;
    }

    private int calculateContrast(IIcon icon, int color) {
        Color c = new Color(color);
        float[] hsb = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        float h = hsb[0];
        float s = hsb[1];
        float b = hsb[2];
        b = b > 0.6f ? (b -= 0.6f) : (b += 0.4f);
        b = MathHelper.clamp_float((float)b, (float)0.0f, (float)1.0f);
        return Color.HSBtoRGB(h, s *= 0.5f, b);
    }

    private int averageIconColor(IIcon icon) {
        if (this.iconAverageColors.containsKey((Object)icon)) {
            return this.iconAverageColors.get((Object)icon);
        }
        if (this.cachedBlockAtlasImage == null) {
            this.cachedBlockAtlasImage = this.loadAndCacheBlockTextureAtlas();
        }
        int width = this.cachedBlockAtlasImage.getWidth();
        int height = this.cachedBlockAtlasImage.getHeight();
        int u0 = (int)Math.round((double)icon.getMinU() * (double)width);
        int u1 = (int)Math.round((double)icon.getMaxU() * (double)width);
        int v0 = (int)Math.round((double)icon.getMinV() * (double)height);
        int v1 = (int)Math.round((double)icon.getMaxV() * (double)height);
        int totalR = 0;
        int totalG = 0;
        int totalB = 0;
        int count = 0;
        for (int y = v0; y < v1; ++y) {
            for (int x = u0; x < u1; ++x) {
                int rgb = this.cachedBlockAtlasImage.getRGB(x, y);
                int r = rgb >> 16 & 0xFF;
                int g = rgb >> 8 & 0xFF;
                int b = rgb >> 0 & 0xFF;
                totalR += r;
                totalG += g;
                totalB += b;
                ++count;
            }
        }
        int avgR = totalR / count & 0xFF;
        int avgG = totalG / count & 0xFF;
        int avgB = totalB / count & 0xFF;
        int avgColor = 0xFF000000 | avgR << 16 | avgG << 8 | avgB << 0;
        this.iconAverageColors.put(icon, avgColor);
        return avgColor;
    }

    private BufferedImage loadAndCacheBlockTextureAtlas() {
        Minecraft mc = Minecraft.getMinecraft();
        mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        int mipmapLvl = 0;
        int width = GL11.glGetTexLevelParameteri((int)3553, (int)mipmapLvl, (int)4096);
        int height = GL11.glGetTexLevelParameteri((int)3553, (int)mipmapLvl, (int)4097);
        int pixelSize = width * height;
        BufferedImage atlasImage = new BufferedImage(width, height, 2);
        IntBuffer buffer = BufferUtils.createIntBuffer((int)pixelSize);
        int[] imgData = new int[pixelSize];
        GL11.glGetTexImage((int)3553, (int)0, (int)32993, (int)33639, (IntBuffer)buffer);
        buffer.get(imgData);
        atlasImage.setRGB(0, 0, width, height, imgData, 0, width);
        return atlasImage;
    }
}

