package com.sebas2008.blood_and_ferrum.item;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.block.ModBlocks;
import com.sebas2008.blood_and_ferrum.item.custom.MagazineItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Blood_and_Ferrum.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAF_ITEMS_TAB = CREATIVE_MODE_TABS.register("baf_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .title(Component.translatable("creativetab.bloodandferrum.baf_item"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.C_CROSS.get());
                        pOutput.accept(ModItems.O_CROSS.get());
                        pOutput.accept(ModItems.STEEL.get());
                        pOutput.accept(ModItems.ZINC.get());
                        pOutput.accept(ModItems.RAW_IRON_COAL.get());
                        pOutput.accept(ModItems.RAW_LEAD.get());
                        pOutput.accept(ModItems.LEAD.get());
                        pOutput.accept(ModItems.BRASS.get());
                        pOutput.accept(ModItems.RAW_ZINC.get());
                        pOutput.accept(ModItems.COPPER_AND_ZINC.get());
                        pOutput.accept(ModItems.SILVER.get());
                        pOutput.accept(ModItems.RAW_SILVER.get());
                        pOutput.accept(ModItems.POWERED_CRISTIAN_CROSS.get());
                        pOutput.accept(ModItems.POWERED_ORTODOX_CROSS.get());
                        pOutput.accept(ModItems.DORAYAKI.get());
                        pOutput.accept(ModItems.POINT_45ACP.get());
                        pOutput.accept(ModItems.SHELL_45ACP.get());
                        pOutput.accept(Items.GUNPOWDER);


                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAF_BLOCKS_TAB = CREATIVE_MODE_TABS.register("baf_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK.get()))
                    .withTabsBefore(BAF_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.bloodandferrum.baf_block"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.BRASS_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVER_BLOCK.get());

                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAF_ORES_TAB = CREATIVE_MODE_TABS.register("baf_ores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LEAD_ORE.get()))
                    .withTabsBefore(BAF_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.bloodandferrum.baf_ores"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.LEAD_ORE.get());
                        pOutput.accept(ModBlocks.ZINC_ORE.get());
                        pOutput.accept(ModBlocks.RAW_SILVER_ORE.get());
                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAF_ARMOR_TAB = CREATIVE_MODE_TABS.register("baf_armor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.YUURI_HELMET.get()))
                    .withTabsBefore(BAF_ORES_TAB.getId())
                    .title(Component.translatable("creativetab.bloodandferrum.baf_armor"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.YUURI_HELMET.get());
                        pOutput.accept(ModItems.YUURI_CHESTPLATE.get());
                        pOutput.accept(ModItems.YUURI_LEGGINGS.get());
                        pOutput.accept(ModItems.YUURI_BOOTS.get());
                        pOutput.accept(ModItems.CHITO_HELMET.get());
                        pOutput.accept(ModItems.CHITO_CHESTPLATE.get());
                        pOutput.accept(ModItems.CHITO_LEGGINGS.get());
                        pOutput.accept(ModItems.CHITO_BOOTS.get());
                    })
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAF_AMMO_AND_MAGAZINES = CREATIVE_MODE_TABS.register("baf_ammo_and_magazine_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ACP45.get()))
                    .withTabsBefore( BAF_ARMOR_TAB.getId()) .title(Component.translatable("creativetab.bloodandferrum.baf_ammo_and_magazines"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ACP45.get());
                        pOutput.accept(ModItems.M1911_MAGAZINE.get());
                        ItemStack loadedMag = new ItemStack(ModItems.M1911_MAGAZINE_LOADED.get());
                        MagazineItem.setAmmo(loadedMag, MagazineItem.MAX_AMMO);
                        pOutput.accept(loadedMag);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}