/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  org.apache.commons.lang3.StringUtils
 */
package lotr.common.world.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.LOTRPlayerData;
import lotr.common.fellowship.LOTRFellowship;
import lotr.common.fellowship.LOTRFellowshipClient;
import lotr.common.fellowship.LOTRFellowshipData;
import lotr.common.network.LOTRPacketCWPSharedHideClient;
import lotr.common.network.LOTRPacketCWPSharedUnlockClient;
import lotr.common.network.LOTRPacketCreateCWPClient;
import lotr.common.network.LOTRPacketDeleteCWPClient;
import lotr.common.network.LOTRPacketFellowship;
import lotr.common.network.LOTRPacketRenameCWPClient;
import lotr.common.network.LOTRPacketShareCWPClient;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRAbstractWaypoint;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import org.apache.commons.lang3.StringUtils;

public class LOTRCustomWaypoint
implements LOTRAbstractWaypoint {
    private String customName;
    private double mapX;
    private double mapY;
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private int ID;
    private List<UUID> sharedFellowshipIDs = new ArrayList<UUID>();
    private UUID sharingPlayer;
    private String sharingPlayerName;
    private boolean sharedUnlocked;
    private static final int SHARED_UNLOCK_RANGE = 1000;
    private boolean sharedHidden;

    public static LOTRCustomWaypoint createForPlayer(String name, EntityPlayer entityplayer) {
        LOTRPlayerData playerData = LOTRLevelData.getData(entityplayer);
        int cwpID = playerData.getNextCwpID();
        int i = MathHelper.floor_double((double)entityplayer.posX);
        int j = MathHelper.floor_double((double)entityplayer.boundingBox.minY);
        int k = MathHelper.floor_double((double)entityplayer.posZ);
        double mapX = LOTRWaypoint.worldToMapX(i);
        double mapY = LOTRWaypoint.worldToMapZ(k);
        LOTRCustomWaypoint cwp = new LOTRCustomWaypoint(name, mapX, mapY, i, j, k, cwpID);
        playerData.addCustomWaypoint(cwp);
        playerData.incrementNextCwpID();
        return cwp;
    }

    public LOTRCustomWaypoint(String name, double i, double j, int posX, int posY, int posZ, int id) {
        this.customName = name;
        this.mapX = i;
        this.mapY = j;
        this.xCoord = posX;
        this.yCoord = posY;
        this.zCoord = posZ;
        this.ID = id;
    }

    @Override
    public double getX() {
        return this.mapX;
    }

    @Override
    public double getY() {
        return this.mapY;
    }

    @Override
    public int getXCoord() {
        return this.xCoord;
    }

    @Override
    public int getYCoord(World world, int i, int k) {
        int j = this.yCoord;
        if (j < 0) {
            this.yCoord = LOTRMod.getTrueTopBlock(world, i, k);
        } else if (!this.isSafeBlock(world, i, j, k)) {
            int j1;
            int start;
            Block below = world.getBlock(i, j - 1, k);
            Block block = world.getBlock(i, j, k);
            Block above = world.getBlock(i, j + 1, k);
            boolean belowSafe = below.getMaterial().blocksMovement();
            boolean blockSafe = !block.isNormalCube((IBlockAccess)world, i, j, k);
            boolean aboveSafe = !above.isNormalCube((IBlockAccess)world, i, j + 1, k);
            boolean foundSafe = false;
            if (!belowSafe) {
                for (j1 = start = j - 1; j1 >= 1; --j1) {
                    if (!this.isSafeBlock(world, i, j1, k)) continue;
                    this.yCoord = j1;
                    foundSafe = true;
                    break;
                }
            }
            if (!(foundSafe || blockSafe && aboveSafe)) {
                for (j1 = start = aboveSafe ? j + 1 : j + 2; j1 <= world.getHeight() - 1; ++j1) {
                    if (!this.isSafeBlock(world, i, j1, k)) continue;
                    this.yCoord = j1;
                    foundSafe = true;
                    break;
                }
            }
            if (!foundSafe) {
                this.yCoord = LOTRMod.getTrueTopBlock(world, i, k);
            }
        }
        return this.yCoord;
    }

    private boolean isSafeBlock(World world, int i, int j, int k) {
        Block below = world.getBlock(i, j - 1, k);
        Block block = world.getBlock(i, j, k);
        Block above = world.getBlock(i, j + 1, k);
        if (below.getMaterial().blocksMovement() && !block.isNormalCube((IBlockAccess)world, i, j, k) && !above.isNormalCube((IBlockAccess)world, i, j + 1, k)) {
            if (block.getMaterial().isLiquid() || block.getMaterial() == Material.fire) {
                return false;
            }
            return !above.getMaterial().isLiquid() && above.getMaterial() != Material.fire;
        }
        return false;
    }

    @Override
    public int getYCoordSaved() {
        return this.yCoord;
    }

    @Override
    public int getZCoord() {
        return this.zCoord;
    }

    @Override
    public String getCodeName() {
        return this.customName;
    }

    @Override
    public String getDisplayName() {
        if (this.isShared()) {
            return StatCollector.translateToLocalFormatted((String)"lotr.waypoint.shared", (Object[])new Object[]{this.customName});
        }
        return StatCollector.translateToLocalFormatted((String)"lotr.waypoint.custom", (Object[])new Object[]{this.customName});
    }

    @Override
    public String getLoreText(EntityPlayer entityplayer) {
        boolean shared;
        boolean ownShared = !this.isShared() && !this.sharedFellowshipIDs.isEmpty();
        boolean bl = shared = this.isShared() && this.sharingPlayerName != null;
        if (ownShared || shared) {
            int numShared = this.sharedFellowshipIDs.size();
            int maxShow = 3;
            int numShown = 0;
            ArrayList<String> fsNames = new ArrayList<String>();
            for (int i = 0; i < 3 && i < this.sharedFellowshipIDs.size(); ++i) {
                UUID fsID = this.sharedFellowshipIDs.get(i);
                LOTRFellowshipClient fs = LOTRLevelData.getData(entityplayer).getClientFellowshipByID(fsID);
                if (fs == null) continue;
                fsNames.add(fs.getName());
                ++numShown;
            }
            String sharedFsNames = "";
            for (String s : fsNames) {
                sharedFsNames = sharedFsNames + "\n" + s;
            }
            if (numShared > numShown) {
                int numMore = numShared - numShown;
                sharedFsNames = sharedFsNames + "\n" + StatCollector.translateToLocalFormatted((String)"lotr.waypoint.custom.andMore", (Object[])new Object[]{numMore});
            }
            if (ownShared) {
                return StatCollector.translateToLocalFormatted((String)"lotr.waypoint.custom.info", (Object[])new Object[]{sharedFsNames});
            }
            if (shared) {
                return StatCollector.translateToLocalFormatted((String)"lotr.waypoint.shared.info", (Object[])new Object[]{this.sharingPlayerName, sharedFsNames});
            }
        }
        return null;
    }

    @Override
    public boolean hasPlayerUnlocked(EntityPlayer entityplayer) {
        if (this.isShared()) {
            return this.isSharedUnlocked();
        }
        return true;
    }

    @Override
    public LOTRAbstractWaypoint.WaypointLockState getLockState(EntityPlayer entityplayer) {
        boolean unlocked = this.hasPlayerUnlocked(entityplayer);
        if (this.isShared()) {
            return unlocked ? LOTRAbstractWaypoint.WaypointLockState.SHARED_CUSTOM_UNLOCKED : LOTRAbstractWaypoint.WaypointLockState.SHARED_CUSTOM_LOCKED;
        }
        return unlocked ? LOTRAbstractWaypoint.WaypointLockState.CUSTOM_UNLOCKED : LOTRAbstractWaypoint.WaypointLockState.CUSTOM_LOCKED;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    private LOTRWaypoint.Region getWorldPosRegion(World world) {
        BiomeGenBase biome = world.getBiomeGenForCoords(this.xCoord, this.zCoord);
        if (biome instanceof LOTRBiome) {
            return ((LOTRBiome)biome).getBiomeWaypoints();
        }
        return null;
    }

    public void rename(String newName) {
        this.customName = newName;
    }

    public static String validateCustomName(String name) {
        if (!StringUtils.isBlank((CharSequence)(name = StringUtils.trim((String)name)))) {
            return name;
        }
        return null;
    }

    public List<UUID> getSharedFellowshipIDs() {
        return this.sharedFellowshipIDs;
    }

    public void addSharedFellowship(LOTRFellowship fs) {
        this.addSharedFellowship(fs.getFellowshipID());
    }

    public void addSharedFellowship(UUID fsID) {
        if (!this.sharedFellowshipIDs.contains(fsID)) {
            this.sharedFellowshipIDs.add(fsID);
        }
    }

    public void removeSharedFellowship(LOTRFellowship fs) {
        this.removeSharedFellowship(fs.getFellowshipID());
    }

    public void removeSharedFellowship(UUID fsID) {
        if (this.sharedFellowshipIDs.contains(fsID)) {
            this.sharedFellowshipIDs.remove(fsID);
        }
    }

    public boolean hasSharedFellowship(LOTRFellowship fs) {
        return this.hasSharedFellowship(fs.getFellowshipID());
    }

    public boolean hasSharedFellowship(UUID fsID) {
        return this.sharedFellowshipIDs.contains(fsID);
    }

    public void validateFellowshipIDs(LOTRPlayerData ownerData) {
        UUID ownerUUID = ownerData.getPlayerUUID();
        HashSet<UUID> removeIDs = new HashSet<UUID>();
        for (UUID fsID : this.sharedFellowshipIDs) {
            LOTRFellowship fs = LOTRFellowshipData.getFellowship(fsID);
            if (fs != null && !fs.isDisbanded() && fs.containsPlayer(ownerUUID)) continue;
            removeIDs.add(fsID);
        }
        this.sharedFellowshipIDs.removeAll(removeIDs);
    }

    public void setSharedFellowshipIDs(List<UUID> fsIDs) {
        this.sharedFellowshipIDs = fsIDs;
    }

    public void setSharingPlayerID(UUID id) {
        UUID prev = this.sharingPlayer;
        this.sharingPlayer = id;
        if (!(MinecraftServer.getServer() == null || prev != null && prev.equals(this.sharingPlayer))) {
            this.sharingPlayerName = LOTRPacketFellowship.getPlayerUsername(this.sharingPlayer);
        }
    }

    public UUID getSharingPlayerID() {
        return this.sharingPlayer;
    }

    public boolean isShared() {
        return this.sharingPlayer != null;
    }

    public void setSharingPlayerName(String s) {
        this.sharingPlayerName = s;
    }

    public String getSharingPlayerName() {
        return this.sharingPlayerName;
    }

    public LOTRCustomWaypoint createCopyOfShared(UUID sharer) {
        LOTRCustomWaypoint copy = new LOTRCustomWaypoint(this.customName, this.mapX, this.mapY, this.xCoord, this.yCoord, this.zCoord, this.ID);
        copy.setSharingPlayerID(sharer);
        copy.setSharedFellowshipIDs(new ArrayList<UUID>(this.sharedFellowshipIDs));
        return copy;
    }

    public boolean isSharedUnlocked() {
        return this.sharedUnlocked;
    }

    public void setSharedUnlocked() {
        this.sharedUnlocked = true;
    }

    public boolean canUnlockShared(EntityPlayer entityplayer) {
        if (this.yCoord >= 0) {
            double unlockRangeSq;
            double distSq = entityplayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5);
            return distSq <= (unlockRangeSq = 1000000.0);
        }
        return false;
    }

    public boolean isSharedHidden() {
        return this.sharedHidden;
    }

    public void setSharedHidden(boolean flag) {
        this.sharedHidden = flag;
    }

    public List<UUID> getPlayersInAllSharedFellowships() {
        ArrayList<UUID> allPlayers = new ArrayList<UUID>();
        for (UUID fsID : this.sharedFellowshipIDs) {
            LOTRFellowship fs = LOTRFellowshipData.getFellowship(fsID);
            if (fs == null || fs.isDisbanded()) continue;
            List<UUID> fsPlayers = fs.getAllPlayerUUIDs();
            for (UUID player : fsPlayers) {
                if (player.equals(this.sharingPlayer) || allPlayers.contains(player)) continue;
                allPlayers.add(player);
            }
        }
        return allPlayers;
    }

    public LOTRPacketCreateCWPClient getClientPacket() {
        return new LOTRPacketCreateCWPClient(this.mapX, this.mapY, this.xCoord, this.yCoord, this.zCoord, this.ID, this.customName, this.sharedFellowshipIDs);
    }

    public LOTRPacketDeleteCWPClient getClientDeletePacket() {
        return new LOTRPacketDeleteCWPClient(this.ID);
    }

    public LOTRPacketRenameCWPClient getClientRenamePacket() {
        return new LOTRPacketRenameCWPClient(this.ID, this.customName);
    }

    public LOTRPacketShareCWPClient getClientAddFellowshipPacket(UUID fsID) {
        return new LOTRPacketShareCWPClient(this.ID, fsID, true);
    }

    public LOTRPacketShareCWPClient getClientRemoveFellowshipPacket(UUID fsID) {
        return new LOTRPacketShareCWPClient(this.ID, fsID, false);
    }

    public LOTRPacketCreateCWPClient getClientPacketShared() {
        return new LOTRPacketCreateCWPClient(this.mapX, this.mapY, this.xCoord, this.yCoord, this.zCoord, this.ID, this.customName, this.sharedFellowshipIDs).setSharingPlayer(this.sharingPlayer, this.sharingPlayerName, this.sharedUnlocked, this.sharedHidden);
    }

    public LOTRPacketDeleteCWPClient getClientDeletePacketShared() {
        return new LOTRPacketDeleteCWPClient(this.ID).setSharingPlayer(this.sharingPlayer);
    }

    public LOTRPacketRenameCWPClient getClientRenamePacketShared() {
        return new LOTRPacketRenameCWPClient(this.ID, this.customName).setSharingPlayer(this.sharingPlayer);
    }

    public LOTRPacketCWPSharedUnlockClient getClientSharedUnlockPacket() {
        return new LOTRPacketCWPSharedUnlockClient(this.ID, this.sharingPlayer);
    }

    public LOTRPacketCWPSharedHideClient getClientSharedHidePacket(boolean hide) {
        return new LOTRPacketCWPSharedHideClient(this.ID, this.sharingPlayer, hide);
    }

    public void writeToNBT(NBTTagCompound nbt, LOTRPlayerData pd) {
        nbt.setString("Name", this.customName);
        nbt.setDouble("XMap", this.mapX);
        nbt.setDouble("YMap", this.mapY);
        nbt.setInteger("XCoord", this.xCoord);
        nbt.setInteger("YCoord", this.yCoord);
        nbt.setInteger("ZCoord", this.zCoord);
        nbt.setInteger("ID", this.ID);
        this.validateFellowshipIDs(pd);
        if (!this.sharedFellowshipIDs.isEmpty()) {
            NBTTagList sharedFellowshipTags = new NBTTagList();
            for (UUID fsID : this.sharedFellowshipIDs) {
                NBTTagString tag = new NBTTagString(fsID.toString());
                sharedFellowshipTags.appendTag((NBTBase)tag);
            }
            nbt.setTag("SharedFellowships", (NBTBase)sharedFellowshipTags);
        }
    }

    public static LOTRCustomWaypoint readFromNBT(NBTTagCompound nbt, LOTRPlayerData pd) {
        String name = nbt.getString("Name");
        double x = 0.0;
        double y = 0.0;
        if (nbt.hasKey("XMap")) {
            x = nbt.getDouble("XMap");
        } else if (nbt.hasKey("X")) {
            x = nbt.getInteger("X");
        }
        if (nbt.hasKey("YMap")) {
            y = nbt.getDouble("YMap");
        } else if (nbt.hasKey("Y")) {
            y = nbt.getInteger("Y");
        }
        int xCoord = nbt.getInteger("XCoord");
        int zCoord = nbt.getInteger("ZCoord");
        int yCoord = nbt.hasKey("YCoord") ? nbt.getInteger("YCoord") : -1;
        int ID = nbt.getInteger("ID");
        LOTRCustomWaypoint cwp = new LOTRCustomWaypoint(name, x, y, xCoord, yCoord, zCoord, ID);
        cwp.sharedFellowshipIDs.clear();
        if (nbt.hasKey("SharedFellowships")) {
            NBTTagList sharedFellowshipTags = nbt.getTagList("SharedFellowships", 8);
            for (int i = 0; i < sharedFellowshipTags.tagCount(); ++i) {
                UUID fsID = UUID.fromString(sharedFellowshipTags.getStringTagAt(i));
                if (fsID == null) continue;
                cwp.sharedFellowshipIDs.add(fsID);
            }
        }
        cwp.validateFellowshipIDs(pd);
        return cwp;
    }
}

