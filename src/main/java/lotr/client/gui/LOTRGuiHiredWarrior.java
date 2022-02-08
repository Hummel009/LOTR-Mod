/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.StatCollector
 *  net.minecraft.util.StringUtils
 *  org.lwjgl.opengl.GL11
 */
package lotr.client.gui;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import java.util.List;
import lotr.client.gui.LOTRGuiButtonLeftRight;
import lotr.client.gui.LOTRGuiButtonOptions;
import lotr.client.gui.LOTRGuiHiredNPC;
import lotr.client.gui.LOTRGuiSlider;
import lotr.common.LOTRSquadrons;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRHiredNPCInfo;
import lotr.common.network.LOTRPacketHandler;
import lotr.common.network.LOTRPacketNPCSquadron;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

public class LOTRGuiHiredWarrior
extends LOTRGuiHiredNPC {
    private static String[] pageTitles = new String[]{"overview", "options"};
    public static final int XP_COLOR = 16733440;
    private GuiButton buttonLeft;
    private GuiButton buttonRight;
    private LOTRGuiButtonOptions buttonOpenInv;
    private LOTRGuiButtonOptions buttonTeleport;
    private LOTRGuiButtonOptions buttonGuardMode;
    private LOTRGuiSlider sliderGuardRange;
    private GuiTextField squadronNameField;
    private boolean updatePage;
    private boolean sendSquadronUpdate = false;

    public LOTRGuiHiredWarrior(LOTREntityNPC npc) {
        super(npc);
    }

    @Override
    public void initGui() {
        super.initGui();
        int midX = this.guiLeft + this.xSize / 2;
        if (this.page == 0) {
            this.buttonOpenInv = new LOTRGuiButtonOptions(0, midX - 80, this.guiTop + 142, 160, 20, StatCollector.translateToLocal((String)"lotr.gui.warrior.openInv"));
            this.buttonList.add(this.buttonOpenInv);
        } else if (this.page == 1) {
            this.buttonTeleport = new LOTRGuiButtonOptions(0, midX - 80, this.guiTop + 180, 160, 20, StatCollector.translateToLocal((String)"lotr.gui.warrior.teleport"));
            this.buttonList.add(this.buttonTeleport);
            this.buttonGuardMode = new LOTRGuiButtonOptions(1, midX - 80, this.guiTop + 50, 160, 20, StatCollector.translateToLocal((String)"lotr.gui.warrior.guardMode"));
            this.buttonList.add(this.buttonGuardMode);
            this.sliderGuardRange = new LOTRGuiSlider(2, midX - 80, this.guiTop + 74, 160, 20, StatCollector.translateToLocal((String)"lotr.gui.warrior.guardRange"));
            this.buttonList.add(this.sliderGuardRange);
            this.sliderGuardRange.setMinMaxValues(LOTRHiredNPCInfo.GUARD_RANGE_MIN, LOTRHiredNPCInfo.GUARD_RANGE_MAX);
            this.sliderGuardRange.setSliderValue(this.theNPC.hiredNPCInfo.getGuardRange());
            this.squadronNameField = new GuiTextField(this.fontRendererObj, midX - 80, this.guiTop + 130, 160, 20);
            this.squadronNameField.setMaxStringLength(LOTRSquadrons.SQUADRON_LENGTH_MAX);
            String squadron = this.theNPC.hiredNPCInfo.getSquadron();
            if (!StringUtils.isNullOrEmpty((String)squadron)) {
                this.squadronNameField.setText(squadron);
            }
        }
        this.buttonLeft = new LOTRGuiButtonLeftRight(1000, true, this.guiLeft - 160, this.guiTop + 50, "");
        this.buttonRight = new LOTRGuiButtonLeftRight(1001, false, this.guiLeft + this.xSize + 40, this.guiTop + 50, "");
        this.buttonList.add(this.buttonLeft);
        this.buttonList.add(this.buttonRight);
        this.buttonLeft.displayString = this.page == 0 ? pageTitles[pageTitles.length - 1] : pageTitles[this.page - 1];
        this.buttonRight.displayString = this.page == pageTitles.length - 1 ? pageTitles[0] : pageTitles[this.page + 1];
        this.buttonLeft.displayString = StatCollector.translateToLocal((String)("lotr.gui.warrior." + this.buttonLeft.displayString));
        this.buttonRight.displayString = StatCollector.translateToLocal((String)("lotr.gui.warrior." + this.buttonRight.displayString));
    }

    protected void actionPerformed(GuiButton button) {
        if (button instanceof LOTRGuiSlider) {
            return;
        }
        if (button.enabled) {
            if (button instanceof LOTRGuiButtonLeftRight) {
                if (button == this.buttonLeft) {
                    --this.page;
                    if (this.page < 0) {
                        this.page = pageTitles.length - 1;
                    }
                } else if (button == this.buttonRight) {
                    ++this.page;
                    if (this.page >= pageTitles.length) {
                        this.page = 0;
                    }
                }
                this.buttonList.clear();
                this.updatePage = true;
            } else {
                this.sendActionPacket(button.id);
            }
        }
    }

    @Override
    public void drawScreen(int i, int j, float f) {
        super.drawScreen(i, j, f);
        if (this.page == 0) {
            int midX = this.guiLeft + this.xSize / 2;
            String s = StatCollector.translateToLocalFormatted((String)"lotr.gui.warrior.health", (Object[])new Object[]{Math.round(this.theNPC.getHealth()), Math.round(this.theNPC.getMaxHealth())});
            this.fontRendererObj.drawString(s, midX - this.fontRendererObj.getStringWidth(s) / 2, this.guiTop + 50, 4210752);
            s = this.theNPC.hiredNPCInfo.getStatusString();
            this.fontRendererObj.drawString(s, midX - this.fontRendererObj.getStringWidth(s) / 2, this.guiTop + 62, 4210752);
            s = StatCollector.translateToLocalFormatted((String)"lotr.gui.warrior.level", (Object[])new Object[]{this.theNPC.hiredNPCInfo.xpLevel});
            this.fontRendererObj.drawString(s, midX - this.fontRendererObj.getStringWidth(s) / 2, this.guiTop + 80, 4210752);
            float lvlProgress = this.theNPC.hiredNPCInfo.getProgressToNextLevel();
            String curLevel = (Object)EnumChatFormatting.BOLD + String.valueOf(this.theNPC.hiredNPCInfo.xpLevel);
            String nextLevel = (Object)EnumChatFormatting.BOLD + String.valueOf(this.theNPC.hiredNPCInfo.xpLevel + 1);
            String xpCurLevel = String.valueOf(LOTRHiredNPCInfo.totalXPForLevel(this.theNPC.hiredNPCInfo.xpLevel));
            String xpNextLevel = String.valueOf(LOTRHiredNPCInfo.totalXPForLevel(this.theNPC.hiredNPCInfo.xpLevel + 1));
            LOTRGuiHiredWarrior.drawRect((int)(midX - 36), (int)(this.guiTop + 96), (int)(midX + 36), (int)(this.guiTop + 102), (int)-16777216);
            LOTRGuiHiredWarrior.drawRect((int)(midX - 35), (int)(this.guiTop + 97), (int)(midX + 35), (int)(this.guiTop + 101), (int)-10658467);
            LOTRGuiHiredWarrior.drawRect((int)(midX - 35), (int)(this.guiTop + 97), (int)(midX - 35 + (int)(lvlProgress * 70.0f)), (int)(this.guiTop + 101), (int)-43776);
            GL11.glPushMatrix();
            float scale = 0.67f;
            GL11.glScalef((float)scale, (float)scale, (float)1.0f);
            this.fontRendererObj.drawString(curLevel, Math.round(((float)(midX - 38) - (float)this.fontRendererObj.getStringWidth(curLevel) * scale) / scale), (int)((float)(this.guiTop + 94) / scale), 4210752);
            this.fontRendererObj.drawString(nextLevel, Math.round((float)(midX + 38) / scale), (int)((float)(this.guiTop + 94) / scale), 4210752);
            this.fontRendererObj.drawString(xpCurLevel, Math.round(((float)(midX - 38) - (float)this.fontRendererObj.getStringWidth(xpCurLevel) * scale) / scale), (int)((float)(this.guiTop + 101) / scale), 4210752);
            this.fontRendererObj.drawString(xpNextLevel, Math.round((float)(midX + 38) / scale), (int)((float)(this.guiTop + 101) / scale), 4210752);
            GL11.glPopMatrix();
            s = StatCollector.translateToLocalFormatted((String)"lotr.gui.warrior.xp", (Object[])new Object[]{this.theNPC.hiredNPCInfo.xp});
            this.fontRendererObj.drawString(s, midX - this.fontRendererObj.getStringWidth(s) / 2, this.guiTop + 110, 4210752);
            s = StatCollector.translateToLocalFormatted((String)"lotr.gui.warrior.kills", (Object[])new Object[]{this.theNPC.hiredNPCInfo.mobKills});
            this.fontRendererObj.drawString(s, midX - this.fontRendererObj.getStringWidth(s) / 2, this.guiTop + 122, 4210752);
        }
        if (this.page == 1) {
            String s = StatCollector.translateToLocal((String)"lotr.gui.warrior.squadron");
            this.fontRendererObj.drawString(s, this.squadronNameField.xPosition, this.squadronNameField.yPosition - this.fontRendererObj.FONT_HEIGHT - 3, 4210752);
            this.squadronNameField.drawTextBox();
        }
    }

    @Override
    public void updateScreen() {
        if (this.updatePage) {
            this.initGui();
            this.updatePage = false;
        }
        super.updateScreen();
        if (this.page == 1) {
            this.buttonTeleport.setState(this.theNPC.hiredNPCInfo.teleportAutomatically);
            this.buttonTeleport.enabled = !this.theNPC.hiredNPCInfo.isGuardMode();
            this.buttonGuardMode.setState(this.theNPC.hiredNPCInfo.isGuardMode());
            this.sliderGuardRange.visible = this.theNPC.hiredNPCInfo.isGuardMode();
            if (this.sliderGuardRange.dragging) {
                int i = this.sliderGuardRange.getSliderValue();
                this.theNPC.hiredNPCInfo.setGuardRange(i);
                this.sendActionPacket(this.sliderGuardRange.id, i);
            }
            this.squadronNameField.updateCursorCounter();
        }
    }

    @Override
    protected void keyTyped(char c, int i) {
        if (this.page == 1 && this.squadronNameField != null && this.squadronNameField.getVisible() && this.squadronNameField.textboxKeyTyped(c, i)) {
            this.theNPC.hiredNPCInfo.setSquadron(this.squadronNameField.getText());
            this.sendSquadronUpdate = true;
            return;
        }
        super.keyTyped(c, i);
    }

    protected void mouseClicked(int i, int j, int k) {
        super.mouseClicked(i, j, k);
        if (this.page == 1 && this.squadronNameField != null) {
            this.squadronNameField.mouseClicked(i, j, k);
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.sendSquadronUpdate) {
            String squadron = this.theNPC.hiredNPCInfo.getSquadron();
            LOTRPacketNPCSquadron packet = new LOTRPacketNPCSquadron(this.theNPC, squadron);
            LOTRPacketHandler.networkWrapper.sendToServer((IMessage)packet);
        }
    }
}

