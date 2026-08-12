package com.sebas2008.blood_and_ferrum.event;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.effect.ModEffects;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.neoforge.event.enchanting.EnchantmentLevelSetEvent;

@EventBusSubscriber(modid = Blood_and_Ferrum.MOD_ID)
public class ModEffectEvents {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;

        MobEffectInstance effect = player.getEffect(ModEffects.INGENUITY);
        if (effect != null) {
            ItemStack left = event.getLeft();
            ItemStack right = event.getRight();

            if (!left.isEmpty() && !right.isEmpty()) {
                // 1. Calculate base cost (estimating 2 if default calculation is 0)
                int baseCost = (int) event.getCost();
                if (baseCost <= 0) {
                    baseCost = 2;
                }

                // 2. Calculate scaling discount based on level
                int level = effect.getAmplifier() + 1; // Level I = 1, Level II = 2...
                double discountFactor = Math.min(2.0, 0.5 * level); // Lvl I: -0.5, Lvl II: -1.0, Lvl III: -1.5, Lvl IV: -2.0

                int discountedCost = (int) Math.round(baseCost * (1.0 - discountFactor));
                discountedCost = Math.max(1, discountedCost); // Keep minimum 1 XP

                event.setCost(discountedCost);
                event.setMaterialCost(1);

                // 3. Create the enchanted output item stack explicitly
                ItemStack output = left.copy();

                // Transfer enchantments from the right book/item onto the left item
                ItemEnchantments storedEnchants = right.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
                if (!storedEnchants.isEmpty()) {
                    ItemEnchantments.Mutable builder = new ItemEnchantments.Mutable(left.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));
                    storedEnchants.entrySet().forEach(entry -> builder.upgrade(entry.getKey(), entry.getIntValue()));
                    output.set(DataComponents.ENCHANTMENTS, builder.toImmutable());
                }

                // Apply custom name if typed in anvil
                if (event.getName() != null && !event.getName().isEmpty()) {
                    output.set(DataComponents.CUSTOM_NAME, net.minecraft.network.chat.Component.literal(event.getName()));
                }

                // Force set output stack
                event.setOutput(output);

                Blood_and_Ferrum.LOGGER.info("Ingenuity (Lvl {}) Anvil Cost: {} -> {}", level, baseCost, discountedCost);
            }
        }
    }

    @SubscribeEvent
    public static void onEnchantmentLevelSet(EnchantmentLevelSetEvent event) {
        Player player = event.getLevel().getNearestPlayer(
                event.getPos().getX() + 0.5D,
                event.getPos().getY() + 0.5D,
                event.getPos().getZ() + 0.5D,
                3.0D,
                false
        );

        if (player != null) {
            MobEffectInstance effect = player.getEffect(ModEffects.INGENUITY);
            if (effect != null) {
                int originalLevel = event.getEnchantLevel();
                if (originalLevel > 0) {
                    int level = effect.getAmplifier() + 1;

                    double discountFactor = Math.min(2.0, 0.5 * level);
                    int discountedLevel = (int) Math.round(originalLevel * (1.0 - discountFactor));

                    discountedLevel = Math.max(1, discountedLevel);
                    event.setEnchantLevel(discountedLevel);

                    Blood_and_Ferrum.LOGGER.info("Ingenuity (Lvl {}) Enchant Level: {} -> {}", level, originalLevel, discountedLevel);
                }
            }
        }
    }
}
