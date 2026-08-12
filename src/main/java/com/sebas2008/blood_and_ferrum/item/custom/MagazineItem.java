package com.sebas2008.blood_and_ferrum.item.custom;

import com.sebas2008.blood_and_ferrum.components.ModDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class MagazineItem extends Item {
    public static final int MAX_AMMO = 7; //[cite: 8]

    public MagazineItem(Properties properties) {
        super(properties.stacksTo(1)); //[cite: 8]
    }

    public static int getAmmo(ItemStack stack) {

        return stack.getOrDefault(ModDataComponents.AMMO.get(), 0);
    }

    public static void setAmmo(ItemStack stack, int ammo) {

        stack.set(ModDataComponents.AMMO.get(), Math.min(ammo, MAX_AMMO));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int ammo = getAmmo(stack);

        tooltipComponents.add(
                Component.literal("Ammo: " + ammo + " / " + MAX_AMMO)
                        .withStyle(ChatFormatting.GRAY)
        );

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}