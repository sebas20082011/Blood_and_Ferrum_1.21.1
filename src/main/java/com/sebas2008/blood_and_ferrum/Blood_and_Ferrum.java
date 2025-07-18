package com.sebas2008.blood_and_ferrum;

import com.mojang.logging.LogUtils;
import com.sebas2008.blood_and_ferrum.block.ModBlocks;
import com.sebas2008.blood_and_ferrum.item.ModCreativeModTabs;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Blood_and_Ferrum.MOD_ID)
public class Blood_and_Ferrum {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bloodandferrum";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();




    public Blood_and_Ferrum(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.C_CROSS);
            event.accept(ModItems.O_CROSS);
            event.accept(ModItems.COPPER_AND_ZINC);
            event.accept(ModItems.RAW_LEAD);
            event.accept(ModItems.LEAD);
            event.accept(ModItems.BRASS);
            event.accept(ModItems.RAW_IRON_COAL);
            event.accept(ModItems.RAW_ZINC);
            event.accept(ModItems.ZINC);
            event.accept(ModItems.STEEL);
        }

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
                event.accept(ModBlocks.ZINC_ORE);
                event.accept(ModBlocks.LEAD_ORE);
                event.accept(ModBlocks.BRASS_BLOCK);
                event.accept(ModBlocks.STEEL_BLOCK);
            }






    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
