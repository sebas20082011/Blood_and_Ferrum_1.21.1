package com.sebas2008.blood_and_ferrum;

import com.mojang.logging.LogUtils;
import com.sebas2008.blood_and_ferrum.block.ModBlocks;
import com.sebas2008.blood_and_ferrum.item.ModCreativeModTabs;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(Blood_and_Ferrum.MOD_ID)
public class Blood_and_Ferrum {
    public static final String MOD_ID = "bloodandferrum";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Blood_and_Ferrum(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.C_CROSS.get());
            event.accept(ModItems.O_CROSS.get());
            event.accept(ModItems.COPPER_AND_ZINC.get());
            event.accept(ModItems.RAW_LEAD.get());
            event.accept(ModItems.LEAD.get());
            event.accept(ModItems.BRASS.get());
            event.accept(ModItems.RAW_IRON_COAL.get());
            event.accept(ModItems.RAW_ZINC.get());
            event.accept(ModItems.ZINC.get());
            event.accept(ModItems.STEEL.get());
            event.accept(ModItems.SILVER.get());
            event.accept(ModItems.RAW_SILVER.get());
            event.accept(ModItems.DORAYAKI.get());
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ZINC_ORE.get());
            event.accept(ModBlocks.LEAD_ORE.get());
            event.accept(ModBlocks.BRASS_BLOCK.get());
            event.accept(ModBlocks.STEEL_BLOCK.get());
            event.accept(ModBlocks.RAW_SILVER_ORE.get());
            event.accept(ModBlocks.SILVER_BLOCK.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // FIXED: Removed deprecated Bus.MOD parameter
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}