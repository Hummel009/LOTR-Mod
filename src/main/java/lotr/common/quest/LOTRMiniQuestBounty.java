/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.ServerConfigurationManager
 *  net.minecraft.util.ChatComponentTranslation
 *  net.minecraft.util.ChatStyle
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.IChatComponent
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.StatCollector
 *  org.apache.commons.lang3.StringUtils
 */
package lotr.common.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRConfig;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.LOTRPlayerData;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.fac.LOTRAlignmentBonusMap;
import lotr.common.fac.LOTRAlignmentValues;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionBounties;
import lotr.common.quest.LOTRMiniQuest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import org.apache.commons.lang3.StringUtils;

public class LOTRMiniQuestBounty
extends LOTRMiniQuest {
    private static final int KILL_THRESHOLD = 25;
    private static final float MIN_ALIGNMENT_LOWERING = 100.0f;
    public UUID targetID;
    public String targetName;
    public boolean killed;
    public float alignmentBonus;
    public int coinBonus;
    private boolean bountyClaimedByOther;
    private boolean killedByBounty;

    public LOTRMiniQuestBounty(LOTRPlayerData pd) {
        super(pd);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (this.targetID != null) {
            nbt.setString("TargetID", this.targetID.toString());
        }
        if (this.targetName != null) {
            nbt.setString("TargetName", this.targetName);
        }
        nbt.setBoolean("Killed", this.killed);
        nbt.setFloat("AlignF", this.alignmentBonus);
        nbt.setInteger("Coins", this.coinBonus);
        nbt.setBoolean("BountyClaimed", this.bountyClaimedByOther);
        nbt.setBoolean("KilledBy", this.killedByBounty);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("TargetID")) {
            String s = nbt.getString("TargetID");
            this.targetID = UUID.fromString(s);
        }
        if (nbt.hasKey("TargetName")) {
            this.targetName = nbt.getString("TargetName");
        }
        this.killed = nbt.getBoolean("Killed");
        this.alignmentBonus = nbt.hasKey("Alignment") ? (float)nbt.getInteger("Alignment") : nbt.getFloat("AlignF");
        this.coinBonus = nbt.getInteger("Coins");
        this.bountyClaimedByOther = nbt.getBoolean("BountyClaimed");
        this.killedByBounty = nbt.getBoolean("KilledBy");
    }

    @Override
    public boolean isValidQuest() {
        return super.isValidQuest() && this.targetID != null;
    }

    @Override
    public boolean canPlayerAccept(EntityPlayer entityplayer) {
        if (super.canPlayerAccept(entityplayer) && !this.targetID.equals(entityplayer.getUniqueID()) && LOTRLevelData.getData(entityplayer).getAlignment(this.entityFaction) >= 100.0f) {
            LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
            List<LOTRMiniQuest> active = pd.getActiveMiniQuests();
            for (LOTRMiniQuest quest : active) {
                if (!(quest instanceof LOTRMiniQuestBounty) || !((LOTRMiniQuestBounty)quest).targetID.equals(this.targetID)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getQuestObjective() {
        return StatCollector.translateToLocalFormatted((String)"lotr.miniquest.bounty", (Object[])new Object[]{this.targetName});
    }

    @Override
    public String getObjectiveInSpeech() {
        return this.targetName;
    }

    @Override
    public String getProgressedObjectiveInSpeech() {
        return this.targetName;
    }

    @Override
    public String getQuestProgress() {
        if (this.killed) {
            return StatCollector.translateToLocal((String)"lotr.miniquest.bounty.progress.slain");
        }
        return StatCollector.translateToLocal((String)"lotr.miniquest.bounty.progress.notSlain");
    }

    @Override
    public String getQuestProgressShorthand() {
        return StatCollector.translateToLocalFormatted((String)"lotr.miniquest.progressShort", (Object[])new Object[]{this.killed ? 1 : 0, 1});
    }

    @Override
    public float getCompletionFactor() {
        return this.killed ? 1.0f : 0.0f;
    }

    @Override
    public ItemStack getQuestIcon() {
        return new ItemStack(Items.iron_sword);
    }

    @Override
    public void onInteract(EntityPlayer entityplayer, LOTREntityNPC npc) {
        if (this.killed) {
            this.complete(entityplayer, npc);
        } else {
            this.sendProgressSpeechbank(entityplayer, npc);
        }
    }

    @Override
    public void onKill(EntityPlayer entityplayer, EntityLivingBase entity) {
        if (!this.killed && !this.isFailed() && entity instanceof EntityPlayer && ((EntityPlayer)entity).getUniqueID().equals(this.targetID)) {
            EntityPlayer slainPlayer = (EntityPlayer)entity;
            LOTRPlayerData slainPlayerData = LOTRLevelData.getData(slainPlayer);
            this.killed = true;
            LOTRFactionBounties.forFaction(this.entityFaction).forPlayer(slainPlayer).recordBountyKilled();
            this.updateQuest();
            LOTRFaction highestFaction = this.getPledgeOrHighestAlignmentFaction(slainPlayer, 100.0f);
            if (highestFaction != null) {
                float alignmentLoss;
                float curAlignment = slainPlayerData.getAlignment(highestFaction);
                if (curAlignment + (alignmentLoss = this.getKilledAlignmentPenalty()) < 100.0f) {
                    alignmentLoss = -(curAlignment - 100.0f);
                }
                LOTRAlignmentValues.AlignmentBonus source = new LOTRAlignmentValues.AlignmentBonus(alignmentLoss, "lotr.alignment.bountyKilled");
                slainPlayerData.addAlignment(slainPlayer, source, highestFaction, (Entity)entityplayer);
                ChatComponentTranslation slainMsg1 = new ChatComponentTranslation("chat.lotr.bountyKilled1", new Object[]{entityplayer.getCommandSenderName(), this.entityFaction.factionName()});
                ChatComponentTranslation slainMsg2 = new ChatComponentTranslation("chat.lotr.bountyKilled2", new Object[]{highestFaction.factionName()});
                slainMsg1.getChatStyle().setColor(EnumChatFormatting.YELLOW);
                slainMsg2.getChatStyle().setColor(EnumChatFormatting.YELLOW);
                slainPlayer.addChatMessage((IChatComponent)slainMsg1);
                slainPlayer.addChatMessage((IChatComponent)slainMsg2);
            }
            ChatComponentTranslation announceMsg = new ChatComponentTranslation("chat.lotr.bountyKill", new Object[]{entityplayer.getCommandSenderName(), slainPlayer.getCommandSenderName(), this.entityFaction.factionName()});
            announceMsg.getChatStyle().setColor(EnumChatFormatting.YELLOW);
            for (Object obj : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                EntityPlayer otherPlayer = (EntityPlayer)obj;
                if (otherPlayer == slainPlayer) continue;
                otherPlayer.addChatMessage((IChatComponent)announceMsg);
            }
        }
    }

    @Override
    public void onKilledByPlayer(EntityPlayer entityplayer, EntityPlayer killer) {
        if (!this.killed && !this.isFailed() && killer.getUniqueID().equals(this.targetID)) {
            float curAlignment;
            LOTRPlayerData pd;
            LOTRPlayerData killerData = LOTRLevelData.getData(killer);
            LOTRFaction killerHighestFaction = this.getPledgeOrHighestAlignmentFaction(killer, 0.0f);
            if (killerHighestFaction != null) {
                float killerBonus = this.getAlignmentBonus();
                LOTRAlignmentValues.AlignmentBonus source = new LOTRAlignmentValues.AlignmentBonus(killerBonus, "lotr.alignment.killedHunter");
                killerData.addAlignment(killer, source, killerHighestFaction, (Entity)entityplayer);
            }
            if ((curAlignment = (pd = this.getPlayerData()).getAlignment(this.entityFaction)) > 100.0f) {
                float alignmentLoss = this.getKilledAlignmentPenalty();
                if (curAlignment + alignmentLoss < 100.0f) {
                    alignmentLoss = -(curAlignment - 100.0f);
                }
                LOTRAlignmentValues.AlignmentBonus source = new LOTRAlignmentValues.AlignmentBonus(alignmentLoss, "lotr.alignment.killedByBounty");
                pd.addAlignment(entityplayer, source, this.entityFaction, (Entity)killer);
                ChatComponentTranslation slainMsg1 = new ChatComponentTranslation("chat.lotr.killedByBounty1", new Object[]{killer.getCommandSenderName()});
                ChatComponentTranslation slainMsg2 = new ChatComponentTranslation("chat.lotr.killedByBounty2", new Object[]{this.entityFaction.factionName()});
                slainMsg1.getChatStyle().setColor(EnumChatFormatting.YELLOW);
                slainMsg2.getChatStyle().setColor(EnumChatFormatting.YELLOW);
                entityplayer.addChatMessage((IChatComponent)slainMsg1);
                entityplayer.addChatMessage((IChatComponent)slainMsg2);
            }
            this.killedByBounty = true;
            this.updateQuest();
            killerData.addAchievement(LOTRAchievement.killHuntingPlayer);
            ChatComponentTranslation announceMsg = new ChatComponentTranslation("chat.lotr.killedByBounty", new Object[]{entityplayer.getCommandSenderName(), killer.getCommandSenderName()});
            announceMsg.getChatStyle().setColor(EnumChatFormatting.YELLOW);
            for (Object obj : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                EntityPlayer otherPlayer = (EntityPlayer)obj;
                if (otherPlayer == entityplayer) continue;
                otherPlayer.addChatMessage((IChatComponent)announceMsg);
            }
        }
    }

    private LOTRFaction getPledgeOrHighestAlignmentFaction(EntityPlayer entityplayer, float min) {
        LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
        if (pd.getPledgeFaction() != null) {
            return pd.getPledgeFaction();
        }
        ArrayList<LOTRFaction> highestFactions = new ArrayList<LOTRFaction>();
        float highestAlignment = min;
        for (LOTRFaction f : LOTRFaction.getPlayableAlignmentFactions()) {
            float alignment = pd.getAlignment(f);
            if (!(alignment > min)) continue;
            if (alignment > highestAlignment) {
                highestFactions.clear();
                highestFactions.add(f);
                highestAlignment = alignment;
                continue;
            }
            if (alignment != highestAlignment) continue;
            highestFactions.add(f);
        }
        if (!highestFactions.isEmpty()) {
            Random rand = entityplayer.getRNG();
            LOTRFaction highestFaction = (LOTRFaction)((Object)highestFactions.get(rand.nextInt(highestFactions.size())));
            return highestFaction;
        }
        return null;
    }

    @Override
    public void onPlayerTick(EntityPlayer entityplayer) {
        super.onPlayerTick(entityplayer);
        if (this.isActive() && !this.killed && !this.bountyClaimedByOther && LOTRFactionBounties.forFaction(this.entityFaction).forPlayer(this.targetID).recentlyBountyKilled()) {
            this.bountyClaimedByOther = true;
            this.updateQuest();
        }
    }

    @Override
    public boolean isFailed() {
        return super.isFailed() || this.bountyClaimedByOther || this.killedByBounty;
    }

    @Override
    public String getQuestFailure() {
        if (this.killedByBounty) {
            return StatCollector.translateToLocalFormatted((String)"lotr.miniquest.bounty.killedBy", (Object[])new Object[]{this.targetName});
        }
        if (this.bountyClaimedByOther) {
            return StatCollector.translateToLocalFormatted((String)"lotr.miniquest.bounty.claimed", (Object[])new Object[]{this.targetName});
        }
        return super.getQuestFailure();
    }

    @Override
    public String getQuestFailureShorthand() {
        if (this.killedByBounty) {
            return StatCollector.translateToLocal((String)"lotr.miniquest.bounty.killedBy.short");
        }
        if (this.bountyClaimedByOther) {
            return StatCollector.translateToLocal((String)"lotr.miniquest.bounty.claimed.short");
        }
        return super.getQuestFailureShorthand();
    }

    @Override
    public void start(EntityPlayer entityplayer, LOTREntityNPC npc) {
        super.start(entityplayer, npc);
        LOTRLevelData.getData(this.targetID).placeBountyFor(npc.getFaction());
    }

    @Override
    protected void complete(EntityPlayer entityplayer, LOTREntityNPC npc) {
        boolean specialReward;
        LOTRPlayerData pd = this.getPlayerData();
        pd.addCompletedBountyQuest();
        int bComplete = pd.getCompletedBountyQuests();
        boolean bl = specialReward = bComplete > 0 && bComplete % 5 == 0;
        if (specialReward) {
            ItemStack trophy = new ItemStack(LOTRMod.bountyTrophy);
            this.rewardItemTable.add(trophy);
        }
        super.complete(entityplayer, npc);
        pd.addAchievement(LOTRAchievement.doMiniquestHunter);
        if (specialReward) {
            pd.addAchievement(LOTRAchievement.doMiniquestHunter5);
        }
    }

    @Override
    public float getAlignmentBonus() {
        return this.alignmentBonus;
    }

    public float getKilledAlignmentPenalty() {
        return -this.getAlignmentBonus() * 2.0f;
    }

    @Override
    public int getCoinBonus() {
        return this.coinBonus;
    }

    @Override
    protected boolean shouldRandomiseCoinReward() {
        return false;
    }

    public static enum BountyHelp {
        BIOME("biome"),
        WAYPOINT("wp");

        public final String speechName;

        private BountyHelp(String s) {
            this.speechName = s;
        }

        public static BountyHelp getRandomHelpType(Random random) {
            return BountyHelp.values()[random.nextInt(BountyHelp.values().length)];
        }
    }

    public static class QFBounty<Q extends LOTRMiniQuestBounty>
    extends LOTRMiniQuest.QuestFactoryBase<Q> {
        public QFBounty(String name) {
            super(name);
        }

        @Override
        public Class getQuestClass() {
            return LOTRMiniQuestBounty.class;
        }

        @Override
        public Q createQuest(LOTREntityNPC npc, Random rand) {
            if (!LOTRConfig.allowBountyQuests) {
                return null;
            }
            LOTRMiniQuestBounty quest = (LOTRMiniQuestBounty)super.createQuest(npc, rand);
            LOTRFaction faction = npc.getFaction();
            LOTRFactionBounties bounties = LOTRFactionBounties.forFaction(faction);
            List<LOTRFactionBounties.PlayerData> players = bounties.findBountyTargets(25);
            if (players.isEmpty()) {
                return null;
            }
            LOTRFactionBounties.PlayerData targetData = players.get(rand.nextInt(players.size()));
            int kills = targetData.getNumKills();
            float f = kills;
            int alignment = (int)f;
            alignment = MathHelper.clamp_int((int)alignment, (int)1, (int)50);
            int coins = (int)(f * 10.0f * MathHelper.randomFloatClamp((Random)rand, (float)0.75f, (float)1.25f));
            coins = MathHelper.clamp_int((int)coins, (int)1, (int)1000);
            quest.targetID = targetData.playerID;
            String username = targetData.findUsername();
            if (StringUtils.isBlank((CharSequence)username)) {
                username = quest.targetID.toString();
            }
            quest.targetName = username;
            quest.alignmentBonus = alignment;
            quest.coinBonus = coins;
            return (Q)quest;
        }
    }

}

