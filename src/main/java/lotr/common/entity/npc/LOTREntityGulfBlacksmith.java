package lotr.common.entity.npc;

import lotr.common.*;
import lotr.common.item.LOTRItemHaradRobes;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityGulfBlacksmith extends LOTREntityGulfHaradrim implements LOTRTradeable.Smith {
    public LOTREntityGulfBlacksmith(World world) {
        super(world);
        this.addTargetTasks(false);
    }

    @Override
    public LOTRTradeEntries getBuyPool() {
        return LOTRTradeEntries.GULF_BLACKSMITH_BUY;
    }

    @Override
    public LOTRTradeEntries getSellPool() {
        return LOTRTradeEntries.GULF_BLACKSMITH_SELL;
    }

    @Override
    public void setupNPCGender() {
        this.familyInfo.setMale(true);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        this.npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.blacksmithHammer));
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        ItemStack turban = new ItemStack(LOTRMod.helmetHaradRobes);
        LOTRItemHaradRobes.setRobesColor(turban, 4995619);
        this.setCurrentItemOrArmor(4, turban);
        return data;
    }

    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    protected void dropFewItems(boolean flag, int i) {
        super.dropFewItems(flag, i);
        int ingots = 1 + this.rand.nextInt(3) + this.rand.nextInt(i + 1);
        for(int l = 0; l < ingots; ++l) {
            this.dropItem(Items.iron_ingot, 1);
        }
    }

    @Override
    public boolean canTradeWith(EntityPlayer entityplayer) {
        return LOTRLevelData.getData(entityplayer).getAlignment(this.getFaction()) >= 50.0f && this.isFriendly(entityplayer);
    }

    @Override
    public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
        LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.tradeGulfBlacksmith);
    }

    @Override
    public boolean shouldTraderRespawn() {
        return true;
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if(this.isFriendly(entityplayer)) {
            if(this.canTradeWith(entityplayer)) {
                return "nearHarad/gulf/blacksmith/friendly";
            }
            return "nearHarad/gulf/blacksmith/neutral";
        }
        return "nearHarad/gulf/blacksmith/hostile";
    }
}
