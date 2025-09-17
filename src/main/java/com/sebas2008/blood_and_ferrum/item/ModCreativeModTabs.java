package com.sebas2008.blood_and_ferrum.item;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Blood_and_Ferrum.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BAF_ITEMS_TAB = CREATIVE_MODE_TABS.register("baf_items_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
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


                    })

                    .build());

    public static final RegistryObject<CreativeModeTab> BAF_BLOCKS_TAB = CREATIVE_MODE_TABS.register("baf_blocks_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK.get()))
                    .withTabsBefore(BAF_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.bloodandferrum.baf_block"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.BRASS_BLOCK.get());
                        pOutput.accept(ModBlocks.LEAD_ORE.get());
                        pOutput.accept(ModBlocks.ZINC_ORE.get());
                        pOutput.accept(ModBlocks.RAW_SILVER_ORE.get());




                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
