/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.npc.LOTREntityUrukHai;
import lotr.common.entity.npc.LOTRInventoryNPCItems;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityUrukHaiBerserker
extends LOTREntityUrukHai {
    public static float BERSERKER_SCALE = 1.15f;

    public LOTREntityUrukHaiBerserker(World world) {
        super(world);
        this.setSize(this.npcWidth * BERSERKER_SCALE, this.npcHeight * BERSERKER_SCALE);
    }

    @Override
    public EntityAIBase createOrcAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.6, false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
        this.getEntityAttribute(npcAttackDamageExtra).setBaseValue(2.0);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        this.npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.scimitarUrukBerserker));
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        this.setCurrentItemOrArmor(4, new ItemStack(LOTRMod.helmetUrukBerserker));
        this.setCurrentItemOrArmor(3, new ItemStack(LOTRMod.bodyFur));
        this.setCurrentItemOrArmor(2, new ItemStack(LOTRMod.legsFur));
        this.setCurrentItemOrArmor(1, new ItemStack(LOTRMod.bootsFur));
        return data;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.8f;
    }
}

