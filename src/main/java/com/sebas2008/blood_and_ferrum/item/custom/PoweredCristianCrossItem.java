package com.sebas2008.blood_and_ferrum.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;


public class PoweredCristianCrossItem extends Item {
    // Cooldown in ticks (20 ticks = 1 second)
    public static final int COOLDOWN_TICKS = 150; // 5 seconds

    // Max uses before breaking
    public static final int MAX_USES = 16;

    public PoweredCristianCrossItem(Properties pProperties) {
        super(pProperties.durability(MAX_USES)); // enables durability bar
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (!player.getCooldowns().isOnCooldown(this)) {
                player.heal(6.0F);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1));
                player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));
                player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);

                EquipmentSlot slot = (hand == InteractionHand.MAIN_HAND) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                stack.hurtAndBreak(1, player, slot);
            } else {
                player.displayClientMessage(
                        Component.literal("Item on cooldown!"), true);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public boolean hurtEnemy(ItemStack Stack, LivingEntity Target, LivingEntity Attacker) {
        return super.hurtEnemy(Stack, Target, Attacker);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (13.0F * stack.getDamageValue() / (float) stack.getMaxDamage()));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float f = Math.max(0.0F, ((float) stack.getMaxDamage() - (float) stack.getDamageValue()) / (float) stack.getMaxDamage());
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }
}





