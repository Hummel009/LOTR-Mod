/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.IMessageHandler
 *  cpw.mods.fml.common.network.simpleimpl.MessageContext
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.EntityPlayer
 */
package lotr.common.network;

import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lotr.common.LOTRCommonProxy;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.LOTRPlayerData;
import lotr.common.world.map.LOTRCustomWaypoint;
import net.minecraft.entity.player.EntityPlayer;

public class LOTRPacketCreateCWPClient
implements IMessage {
    private double mapX;
    private double mapY;
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private int cwpID;
    private String name;
    private List<UUID> sharedFellowshipIDs;
    private UUID sharingPlayer;
    private String sharingPlayerName;
    private boolean sharedUnlocked;
    private boolean sharedHidden;

    public LOTRPacketCreateCWPClient() {
    }

    public LOTRPacketCreateCWPClient(double xm, double ym, int xc, int yc, int zc, int id, String s, List<UUID> fsIDs) {
        this.mapX = xm;
        this.mapY = ym;
        this.xCoord = xc;
        this.yCoord = yc;
        this.zCoord = zc;
        this.cwpID = id;
        this.name = s;
        this.sharedFellowshipIDs = fsIDs;
    }

    public LOTRPacketCreateCWPClient setSharingPlayer(UUID player, String name, boolean unlocked, boolean hidden) {
        this.sharingPlayer = player;
        this.sharingPlayerName = name;
        this.sharedUnlocked = unlocked;
        this.sharedHidden = hidden;
        return this;
    }

    public void toBytes(ByteBuf data) {
        data.writeDouble(this.mapX);
        data.writeDouble(this.mapY);
        data.writeInt(this.xCoord);
        data.writeInt(this.yCoord);
        data.writeInt(this.zCoord);
        data.writeInt(this.cwpID);
        byte[] nameBytes = this.name.getBytes(Charsets.UTF_8);
        data.writeShort(nameBytes.length);
        data.writeBytes(nameBytes);
        boolean sharedFellowships = this.sharedFellowshipIDs != null;
        data.writeBoolean(sharedFellowships);
        if (sharedFellowships) {
            data.writeShort(this.sharedFellowshipIDs.size());
            for (UUID fsID : this.sharedFellowshipIDs) {
                data.writeLong(fsID.getMostSignificantBits());
                data.writeLong(fsID.getLeastSignificantBits());
            }
        }
        boolean shared = this.sharingPlayer != null;
        data.writeBoolean(shared);
        if (shared) {
            data.writeLong(this.sharingPlayer.getMostSignificantBits());
            data.writeLong(this.sharingPlayer.getLeastSignificantBits());
            byte[] usernameBytes = this.sharingPlayerName.getBytes(Charsets.UTF_8);
            data.writeByte(usernameBytes.length);
            data.writeBytes(usernameBytes);
            data.writeBoolean(this.sharedUnlocked);
            data.writeBoolean(this.sharedHidden);
        }
    }

    public void fromBytes(ByteBuf data) {
        boolean shared;
        this.mapX = data.readDouble();
        this.mapY = data.readDouble();
        this.xCoord = data.readInt();
        this.yCoord = data.readInt();
        this.zCoord = data.readInt();
        this.cwpID = data.readInt();
        short nameLength = data.readShort();
        this.name = data.readBytes((int)nameLength).toString(Charsets.UTF_8);
        this.sharedFellowshipIDs = new ArrayList<UUID>();
        boolean sharedFellowships = data.readBoolean();
        if (sharedFellowships) {
            int sharedLength = data.readShort();
            for (int l = 0; l < sharedLength; ++l) {
                UUID fsID = new UUID(data.readLong(), data.readLong());
                this.sharedFellowshipIDs.add(fsID);
            }
        }
        if (shared = data.readBoolean()) {
            this.sharingPlayer = new UUID(data.readLong(), data.readLong());
            byte usernameLength = data.readByte();
            this.sharingPlayerName = data.readBytes((int)usernameLength).toString(Charsets.UTF_8);
            this.sharedUnlocked = data.readBoolean();
            this.sharedHidden = data.readBoolean();
        }
    }

    public static class Handler
    implements IMessageHandler<LOTRPacketCreateCWPClient, IMessage> {
        public IMessage onMessage(LOTRPacketCreateCWPClient packet, MessageContext context) {
            EntityPlayer entityplayer = LOTRMod.proxy.getClientPlayer();
            LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
            LOTRCustomWaypoint cwp = new LOTRCustomWaypoint(packet.name, packet.mapX, packet.mapY, packet.xCoord, packet.yCoord, packet.zCoord, packet.cwpID);
            if (packet.sharedFellowshipIDs != null) {
                cwp.setSharedFellowshipIDs(packet.sharedFellowshipIDs);
            }
            if (packet.sharingPlayer != null) {
                if (!LOTRMod.proxy.isSingleplayer()) {
                    cwp.setSharingPlayerID(packet.sharingPlayer);
                    cwp.setSharingPlayerName(packet.sharingPlayerName);
                    if (packet.sharedUnlocked) {
                        cwp.setSharedUnlocked();
                    }
                    cwp.setSharedHidden(packet.sharedHidden);
                    pd.addOrUpdateSharedCustomWaypoint(cwp);
                }
            } else if (!LOTRMod.proxy.isSingleplayer()) {
                pd.addCustomWaypoint(cwp);
            }
            return null;
        }
    }

}

