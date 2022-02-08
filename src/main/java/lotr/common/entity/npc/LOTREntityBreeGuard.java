/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import java.util.Random;
import lotr.common.LOTRMod;
import lotr.common.LOTRShields;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.npc.LOTREntityBreeMan;
import lotr.common.entity.npc.LOTRFamilyInfo;
import lotr.common.entity.npc.LOTRHiredNPCInfo;
import lotr.common.entity.npc.LOTRInventoryNPCItems;
import lotr.common.util.LOTRColorUtil;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityBreeGuard
extends LOTREntityBreeMan {
    private static final ItemStack[] guardWeapons = new ItemStack[]{new ItemStack(Items.iron_sword), new ItemStack(Items.iron_sword), new ItemStack(LOTRMod.pikeIron)};
    private static final int[] leatherDyes = new int[]{11373426, 7823440, 5983041, 9535090};

    public LOTREntityBreeGuard(World world) {
        super(world);
        this.addTargetTasks(true);
        this.npcShield = LOTRShields.ALIGNMENT_BREE;
    }

    @Override
    protected int addBreeAttackAI(int prio) {
        this.tasks.addTask(prio, (EntityAIBase)new LOTREntityAIAttackOnCollide(this, 1.45, false));
        return prio;
    }

    @Override
    protected void addBreeAvoidAI(int prio) {
    }

    @Override
    public void setupNPCGender() {
        this.familyInfo.setMale(true);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        int i = this.rand.nextInt(guardWeapons.length);
        this.npcItemsInv.setMeleeWeapon(guardWeapons[i].copy());
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        if (this.rand.nextInt(3) == 0) {
            this.setCurrentItemOrArmor(1, new ItemStack((Item)Items.chainmail_boots));
        } else {
            this.setCurrentItemOrArmor(1, LOTRColorUtil.dyeLeather(new ItemStack((Item)Items.leather_boots), 3354152));
        }
        if (this.rand.nextInt(3) == 0) {
            this.setCurrentItemOrArmor(2, new ItemStack((Item)Items.chainmail_leggings));
        } else {
            this.setCurrentItemOrArmor(2, LOTRColorUtil.dyeLeather(new ItemStack((Item)Items.leather_leggings), leatherDyes, this.rand));
        }
        if (this.rand.nextInt(3) == 0) {
            this.setCurrentItemOrArmor(3, new ItemStack((Item)Items.chainmail_chestplate));
        } else {
            this.setCurrentItemOrArmor(3, LOTRColorUtil.dyeLeather(new ItemStack((Item)Items.leather_chestplate), leatherDyes, this.rand));
        }
        this.setCurrentItemOrArmor(4, new ItemStack((Item)Items.iron_helmet));
        return data;
    }

    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if (this.isFriendlyAndAligned(entityplayer)) {
            if (this.hiredNPCInfo.getHiringPlayer() == entityplayer) {
                return "bree/guard/hired";
            }
            return "bree/guard/friendly";
        }
        return "bree/guard/hostile";
    }
}

