package com.sebas2008.blood_and_ferrum.item.custom;

import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class MagazineReloadHandler {

    @SuppressWarnings("resource")
    public static void handleMagazineReload(ServerPlayer player) {
        ItemStack heldItem = player.getMainHandItem();

        // Must be holding a MagazineItem
        if (!(heldItem.getItem() instanceof MagazineItem)) return;

        int currentAmmo = MagazineItem.getAmmo(heldItem);
        if (currentAmmo >= MagazineItem.MAX_AMMO) return; // Full at 7 rounds

        int needed = MagazineItem.MAX_AMMO - currentAmmo;
        int addedAmmo = 0;

        // Loop through inventory slots for .45 ACP bullets
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack slotStack = player.getInventory().getItem(i);

            // Direct Item check against registered ACP45
            if (slotStack.getItem() == ModItems.ACP45.get()) {
                int toTake = Math.min(needed, slotStack.getCount());

                slotStack.shrink(toTake);
                currentAmmo += toTake;
                addedAmmo += toTake;
                needed -= toTake;

                if (needed <= 0) break;
            }
        }


        if (addedAmmo > 0) {
            if (heldItem.getItem() == ModItems.M1911_MAGAZINE.get()) {
                ItemStack loadedStack = new ItemStack(ModItems.M1911_MAGAZINE_LOADED.get(), 1);
                MagazineItem.setAmmo(loadedStack, currentAmmo);
                player.setItemInHand(InteractionHand.MAIN_HAND, loadedStack);
            } else {
                MagazineItem.setAmmo(heldItem, currentAmmo);
            }

            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ARMOR_EQUIP_IRON, SoundSource.PLAYERS, 1.0F, 1.2F);
        }
    }
}