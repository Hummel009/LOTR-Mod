/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.ICommand
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.command.PlayerNotFoundException
 *  net.minecraft.command.WrongUsageException
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.JsonToNBT
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTException
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.PlayerProfileCache
 *  net.minecraft.server.management.ServerConfigurationManager
 *  org.apache.commons.lang3.StringUtils
 */
package lotr.common.command;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRPlayerData;
import lotr.common.fellowship.LOTRFellowship;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.ServerConfigurationManager;
import org.apache.commons.lang3.StringUtils;

public class LOTRCommandFellowship
extends CommandBase {
    public String getCommandName() {
        return "fellowship";
    }

    public int getRequiredPermissionLevel() {
        return 3;
    }

    public String getCommandUsage(ICommandSender sender) {
        return "commands.lotr.fellowship.usage";
    }

    private UUID getPlayerIDByName(ICommandSender sender, String username) {
        try {
            EntityPlayerMP entityplayer = LOTRCommandFellowship.getPlayer((ICommandSender)sender, (String)username);
            if (entityplayer != null) {
                return entityplayer.getUniqueID();
            }
        }
        catch (PlayerNotFoundException entityplayer) {
            // empty catch block
        }
        GameProfile profile = MinecraftServer.getServer().func_152358_ax().func_152655_a(username);
        if (profile != null) {
            return profile.getId();
        }
        return null;
    }

    public static String[] fixArgsForFellowship(String[] args, int startIndex, boolean autocompleting) {
        if (args[startIndex].startsWith("\"")) {
            int endIndex = startIndex;
            boolean foundEnd = false;
            while (!foundEnd) {
                if (args[endIndex].endsWith("\"")) {
                    foundEnd = true;
                    continue;
                }
                if (endIndex >= args.length - 1) {
                    if (autocompleting) break;
                    throw new WrongUsageException("commands.lotr.fellowship.edit.nameError", new Object[0]);
                }
                ++endIndex;
            }
            String fsName = "";
            for (int i = startIndex; i <= endIndex; ++i) {
                if (i > startIndex) {
                    fsName = fsName + " ";
                }
                fsName = fsName + args[i];
            }
            if (!autocompleting || foundEnd) {
                fsName = fsName.replace("\"", "");
            }
            int diff = endIndex - startIndex;
            String[] argsNew = new String[args.length - diff];
            for (int i = 0; i < argsNew.length; ++i) {
                argsNew[i] = i < startIndex ? args[i] : (i == startIndex ? fsName : args[i + diff]);
            }
            return argsNew;
        }
        if (!autocompleting) {
            throw new WrongUsageException("commands.lotr.fellowship.edit.nameError", new Object[0]);
        }
        return args;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length >= 3 && args[0].equals("create")) {
            args = LOTRCommandFellowship.fixArgsForFellowship(args, 2, false);
            String playerName = args[1];
            String fsName = args[2];
            if (fsName == null) {
                throw new WrongUsageException("commands.lotr.fellowship.edit.notFound", new Object[]{playerName, fsName});
            }
            UUID playerID = this.getPlayerIDByName(sender, playerName);
            if (playerID == null) throw new PlayerNotFoundException();
            LOTRPlayerData playerData = LOTRLevelData.getData(playerID);
            LOTRFellowship fellowship = playerData.getFellowshipByName(fsName);
            if (fellowship != null) throw new WrongUsageException("commands.lotr.fellowship.create.exists", new Object[]{playerName, fsName});
            playerData.createFellowship(fsName, false);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.create", (Object[])new Object[]{playerName, fsName});
            return;
        }
        if (!args[0].equals("option")) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
        if ((args = LOTRCommandFellowship.fixArgsForFellowship(args, 2, false)).length < 4) throw new PlayerNotFoundException();
        String ownerName = args[1];
        String fsName = args[2];
        if (fsName == null) {
            throw new WrongUsageException("commands.lotr.fellowship.edit.notFound", new Object[]{ownerName, fsName});
        }
        String option = args[3];
        UUID ownerID = this.getPlayerIDByName(sender, ownerName);
        if (ownerID == null) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
        LOTRPlayerData ownerData = LOTRLevelData.getData(ownerID);
        LOTRFellowship fellowship = ownerData.getFellowshipByName(fsName);
        if (fellowship == null || !fellowship.isOwner(ownerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.notFound", new Object[]{ownerName, fsName});
        if (option.equals("disband")) {
            ownerData.disbandFellowship(fellowship);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.disband", (Object[])new Object[]{ownerName, fsName});
            return;
        }
        if (option.equals("rename")) {
            String newName = "";
            int startIndex = 4;
            if (args[startIndex].startsWith("\"")) {
                int endIndex = startIndex;
                while (!args[endIndex].endsWith("\"")) {
                    if (++endIndex < args.length) continue;
                    throw new WrongUsageException("commands.lotr.fellowship.rename.error", new Object[0]);
                }
                for (int i = startIndex; i <= endIndex; ++i) {
                    if (i > startIndex) {
                        newName = newName + " ";
                    }
                    newName = newName + args[i];
                }
                newName = newName.replace("\"", "");
            }
            if (StringUtils.isBlank((CharSequence)newName)) throw new WrongUsageException("commands.lotr.fellowship.rename.error", new Object[0]);
            ownerData.renameFellowship(fellowship, newName);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.rename", (Object[])new Object[]{ownerName, fsName, newName});
            return;
        }
        if (option.equals("icon")) {
            String iconData = LOTRCommandFellowship.func_147178_a((ICommandSender)sender, (String[])args, (int)4).getUnformattedText();
            if (iconData.equals("clear")) {
                ownerData.setFellowshipIcon(fellowship, null);
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.icon", (Object[])new Object[]{ownerName, fsName, "[none]"});
                return;
            }
            ItemStack itemstack = null;
            try {
                NBTBase nbt = JsonToNBT.func_150315_a((String)iconData);
                if (!(nbt instanceof NBTTagCompound)) {
                    LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.icon.tagError", (Object[])new Object[]{"Not a valid tag"});
                    return;
                }
                NBTTagCompound compound = (NBTTagCompound)nbt;
                itemstack = ItemStack.loadItemStackFromNBT((NBTTagCompound)compound);
            }
            catch (NBTException nbtexception) {
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.icon.tagError", (Object[])new Object[]{nbtexception.getMessage()});
                return;
            }
            if (itemstack != null) {
                ownerData.setFellowshipIcon(fellowship, itemstack);
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.icon", (Object[])new Object[]{ownerName, fsName, itemstack.getDisplayName()});
                return;
            }
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.icon.tagError", (Object[])new Object[]{"No item"});
            return;
        }
        if (option.equals("pvp") || option.equals("hired-ff")) {
            boolean prevent;
            String setting = args[4];
            if (setting.equals("prevent")) {
                prevent = true;
            } else {
                if (!setting.equals("allow")) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
                prevent = false;
            }
            if (option.equals("pvp")) {
                ownerData.setFellowshipPreventPVP(fellowship, prevent);
                if (prevent) {
                    LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.pvp.prevent", (Object[])new Object[]{ownerName, fsName});
                    return;
                } else {
                    LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.pvp.allow", (Object[])new Object[]{ownerName, fsName});
                }
                return;
            }
            if (!option.equals("hired-ff")) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
            ownerData.setFellowshipPreventHiredFF(fellowship, prevent);
            if (prevent) {
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.hiredFF.prevent", (Object[])new Object[]{ownerName, fsName});
                return;
            } else {
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.hiredFF.allow", (Object[])new Object[]{ownerName, fsName});
            }
            return;
        }
        if (option.equals("map-show")) {
            boolean show;
            String setting = args[4];
            if (setting.equals("on")) {
                show = true;
            } else {
                if (!setting.equals("off")) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
                show = false;
            }
            ownerData.setFellowshipShowMapLocations(fellowship, show);
            if (show) {
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.mapShow.on", (Object[])new Object[]{ownerName, fsName});
                return;
            } else {
                LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.mapShow.off", (Object[])new Object[]{ownerName, fsName});
            }
            return;
        }
        if (args.length < 3) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
        String playerName = args[4];
        UUID playerID = this.getPlayerIDByName(sender, playerName);
        if (playerID == null) throw new PlayerNotFoundException();
        LOTRPlayerData playerData = LOTRLevelData.getData(playerID);
        if (option.equals("invite")) {
            if (fellowship.containsPlayer(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.alreadyIn", new Object[]{ownerName, fsName, playerName});
            ownerData.invitePlayerToFellowship(fellowship, playerID);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.invite", (Object[])new Object[]{ownerName, fsName, playerName});
            return;
        }
        if (option.equals("add")) {
            if (fellowship.containsPlayer(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.alreadyIn", new Object[]{ownerName, fsName, playerName});
            ownerData.invitePlayerToFellowship(fellowship, playerID);
            playerData.acceptFellowshipInvite(fellowship);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.add", (Object[])new Object[]{ownerName, fsName, playerName});
            return;
        }
        if (option.equals("remove")) {
            if (!fellowship.hasMember(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.notMember", new Object[]{ownerName, fsName, playerName});
            ownerData.removePlayerFromFellowship(fellowship, playerID);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.remove", (Object[])new Object[]{ownerName, fsName, playerName});
            return;
        }
        if (option.equals("transfer")) {
            if (!fellowship.hasMember(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.notMember", new Object[]{ownerName, fsName, playerName});
            ownerData.transferFellowship(fellowship, playerID);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.transfer", (Object[])new Object[]{ownerName, fsName, playerName});
            return;
        }
        if (option.equals("op")) {
            if (!fellowship.hasMember(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.notMember", new Object[]{ownerName, fsName, playerName});
            if (fellowship.isAdmin(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.alreadyOp", new Object[]{ownerName, fsName, playerName});
            ownerData.setFellowshipAdmin(fellowship, playerID, true);
            LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.op", (Object[])new Object[]{ownerName, fsName, playerName});
            return;
        }
        if (!option.equals("deop")) throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
        if (!fellowship.hasMember(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.notMember", new Object[]{ownerName, fsName, playerName});
        if (!fellowship.isAdmin(playerID)) throw new WrongUsageException("commands.lotr.fellowship.edit.notOp", new Object[]{ownerName, fsName, playerName});
        ownerData.setFellowshipAdmin(fellowship, playerID, false);
        LOTRCommandFellowship.func_152373_a((ICommandSender)sender, (ICommand)this, (String)"commands.lotr.fellowship.deop", (Object[])new Object[]{ownerName, fsName, playerName});
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (!sender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName())) {
            return null;
        }
        if (args.length == 1) {
            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])new String[]{"create", "option"});
        }
        if (args.length == 2) {
            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])MinecraftServer.getServer().getAllUsernames());
        }
        if (args.length > 2) {
            String function = args[0];
            if (function.equals("create")) {
                return null;
            }
            if (function.equals("option")) {
                String[] argsOriginal = Arrays.copyOf(args, args.length);
                String ownerName = (args = LOTRCommandFellowship.fixArgsForFellowship(args, 2, true))[1];
                UUID ownerID = this.getPlayerIDByName(sender, ownerName);
                if (ownerID != null) {
                    LOTRFellowship fellowship;
                    LOTRPlayerData playerData = LOTRLevelData.getData(ownerID);
                    String fsName = args[2];
                    if (args.length == 3) {
                        return LOTRCommandFellowship.listFellowshipsMatchingLastWord(args, argsOriginal, 2, playerData, true);
                    }
                    if (fsName != null && (fellowship = playerData.getFellowshipByName(fsName)) != null) {
                        if (args.length == 4) {
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])new String[]{"invite", "add", "remove", "transfer", "op", "deop", "disband", "rename", "icon", "pvp", "hired-ff", "map-show"});
                        }
                        String option = args[3];
                        if (option.equals("invite") || option.equals("add")) {
                            GameProfile[] players;
                            ArrayList<String> notInFellowshipNames = new ArrayList<String>();
                            for (GameProfile playerProfile : players = MinecraftServer.getServer().getConfigurationManager().func_152600_g()) {
                                UUID playerID = playerProfile.getId();
                                if (fellowship.containsPlayer(playerID)) continue;
                                notInFellowshipNames.add(playerProfile.getName());
                            }
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])notInFellowshipNames.toArray(new String[0]));
                        }
                        if (option.equals("remove") || option.equals("transfer")) {
                            ArrayList<String> memberNames = new ArrayList<String>();
                            for (UUID playerID : fellowship.getMemberUUIDs()) {
                                GameProfile playerProfile = MinecraftServer.getServer().func_152358_ax().func_152652_a(playerID);
                                if (playerProfile == null || playerProfile.getName() == null) continue;
                                memberNames.add(playerProfile.getName());
                            }
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])memberNames.toArray(new String[0]));
                        }
                        if (option.equals("op")) {
                            ArrayList<String> notAdminNames = new ArrayList<String>();
                            for (UUID playerID : fellowship.getMemberUUIDs()) {
                                GameProfile playerProfile;
                                if (fellowship.isAdmin(playerID) || (playerProfile = MinecraftServer.getServer().func_152358_ax().func_152652_a(playerID)) == null || playerProfile.getName() == null) continue;
                                notAdminNames.add(playerProfile.getName());
                            }
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])notAdminNames.toArray(new String[0]));
                        }
                        if (option.equals("deop")) {
                            ArrayList<String> adminNames = new ArrayList<String>();
                            for (UUID playerID : fellowship.getMemberUUIDs()) {
                                GameProfile playerProfile;
                                if (!fellowship.isAdmin(playerID) || (playerProfile = MinecraftServer.getServer().func_152358_ax().func_152652_a(playerID)) == null || playerProfile.getName() == null) continue;
                                adminNames.add(playerProfile.getName());
                            }
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])adminNames.toArray(new String[0]));
                        }
                        if (option.equals("pvp") || option.equals("hired-ff")) {
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])new String[]{"prevent", "allow"});
                        }
                        if (option.equals("map-show")) {
                            return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])args, (String[])new String[]{"on", "off"});
                        }
                    }
                }
            }
        }
        return null;
    }

    public static List<String> listFellowshipsMatchingLastWord(String[] argsFixed, String[] argsOriginal, int fsNameIndex, LOTRPlayerData playerData, boolean leadingOnly) {
        String fsName = argsFixed[fsNameIndex];
        List<String> allFellowshipNames = leadingOnly ? playerData.listAllLeadingFellowshipNames() : playerData.listAllFellowshipNames();
        ArrayList<String> autocompletes = new ArrayList<String>();
        for (String nextFsName : allFellowshipNames) {
            String autocompFsName = "\"" + nextFsName + "\"";
            if (!autocompFsName.toLowerCase().startsWith(fsName.toLowerCase())) continue;
            if (argsOriginal.length > argsFixed.length) {
                int diff = argsOriginal.length - argsFixed.length;
                for (int j = 0; j < diff; ++j) {
                    autocompFsName = autocompFsName.substring(autocompFsName.indexOf(" ") + 1);
                }
            }
            if (autocompFsName.indexOf(" ") >= 0) {
                autocompFsName = autocompFsName.substring(0, autocompFsName.indexOf(" "));
            }
            autocompletes.add(autocompFsName);
        }
        return LOTRCommandFellowship.getListOfStringsMatchingLastWord((String[])argsOriginal, (String[])autocompletes.toArray(new String[0]));
    }

    public boolean isUsernameIndex(String[] args, int i) {
        String option;
        if (args.length >= 5 && args[0].equals("option") && ((option = args[3]).equals("invite") || option.equals("add") || option.equals("remove") || option.equals("transfer"))) {
            return i == 4;
        }
        return false;
    }
}

