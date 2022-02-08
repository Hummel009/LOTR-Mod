/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.IMessageHandler
 *  cpw.mods.fml.common.network.simpleimpl.MessageContext
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.world.EnumDifficulty
 */
package lotr.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import net.minecraft.world.EnumDifficulty;

public class LOTRPacketLogin
implements IMessage {
    public int ringPortalX;
    public int ringPortalY;
    public int ringPortalZ;
    public int ftCooldownMax;
    public int ftCooldownMin;
    public EnumDifficulty difficulty;
    public boolean difficultyLocked;
    public boolean alignmentZones;
    public boolean feastMode;
    public boolean fellowshipCreation;
    public boolean enchanting;
    public boolean enchantingLOTR;
    public boolean strictFactionTitleRequirements;
    public boolean conquestDecay;
    public int customWaypointMinY;

    public void toBytes(ByteBuf data) {
        data.writeInt(this.ringPortalX);
        data.writeInt(this.ringPortalY);
        data.writeInt(this.ringPortalZ);
        data.writeInt(this.ftCooldownMax);
        data.writeInt(this.ftCooldownMin);
        int diff = this.difficulty == null ? -1 : this.difficulty.getDifficultyId();
        data.writeByte(diff);
        data.writeBoolean(this.difficultyLocked);
        data.writeBoolean(this.alignmentZones);
        data.writeBoolean(this.feastMode);
        data.writeBoolean(this.fellowshipCreation);
        data.writeBoolean(this.enchanting);
        data.writeBoolean(this.enchantingLOTR);
        data.writeBoolean(this.strictFactionTitleRequirements);
        data.writeBoolean(this.conquestDecay);
        data.writeInt(this.customWaypointMinY);
    }

    public void fromBytes(ByteBuf data) {
        this.ringPortalX = data.readInt();
        this.ringPortalY = data.readInt();
        this.ringPortalZ = data.readInt();
        this.ftCooldownMax = data.readInt();
        this.ftCooldownMin = data.readInt();
        byte diff = data.readByte();
        this.difficulty = diff >= 0 ? EnumDifficulty.getDifficultyEnum((int)diff) : null;
        this.difficultyLocked = data.readBoolean();
        this.alignmentZones = data.readBoolean();
        this.feastMode = data.readBoolean();
        this.fellowshipCreation = data.readBoolean();
        this.enchanting = data.readBoolean();
        this.enchantingLOTR = data.readBoolean();
        this.strictFactionTitleRequirements = data.readBoolean();
        this.conquestDecay = data.readBoolean();
        this.customWaypointMinY = data.readInt();
    }

    public static class Handler
    implements IMessageHandler<LOTRPacketLogin, IMessage> {
        public IMessage onMessage(LOTRPacketLogin packet, MessageContext context) {
            if (!LOTRMod.proxy.isSingleplayer()) {
                LOTRLevelData.destroyAllPlayerData();
            }
            LOTRLevelData.middleEarthPortalX = packet.ringPortalX;
            LOTRLevelData.middleEarthPortalY = packet.ringPortalY;
            LOTRLevelData.middleEarthPortalZ = packet.ringPortalZ;
            LOTRLevelData.setWaypointCooldown(packet.ftCooldownMax, packet.ftCooldownMin);
            EnumDifficulty diff = packet.difficulty;
            if (diff != null) {
                LOTRLevelData.setSavedDifficulty(diff);
                LOTRMod.proxy.setClientDifficulty(diff);
            } else {
                LOTRLevelData.setSavedDifficulty(null);
            }
            LOTRLevelData.setDifficultyLocked(packet.difficultyLocked);
            LOTRLevelData.setEnableAlignmentZones(packet.alignmentZones);
            LOTRLevelData.clientside_thisServer_feastMode = packet.feastMode;
            LOTRLevelData.clientside_thisServer_fellowshipCreation = packet.fellowshipCreation;
            LOTRLevelData.clientside_thisServer_enchanting = packet.enchanting;
            LOTRLevelData.clientside_thisServer_enchantingLOTR = packet.enchantingLOTR;
            LOTRLevelData.clientside_thisServer_strictFactionTitleRequirements = packet.strictFactionTitleRequirements;
            LOTRLevelData.clientside_thisServer_customWaypointMinY = packet.customWaypointMinY;
            return null;
        }
    }

}

