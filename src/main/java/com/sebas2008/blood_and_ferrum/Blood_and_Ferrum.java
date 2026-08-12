package com.sebas2008.blood_and_ferrum;

import com.mojang.logging.LogUtils;
import com.sebas2008.blood_and_ferrum.block.ModBlocks;
import com.sebas2008.blood_and_ferrum.components.ModDataComponents;
import com.sebas2008.blood_and_ferrum.datagen.DataGenerators;
import com.sebas2008.blood_and_ferrum.effect.ModEffects;
import com.sebas2008.blood_and_ferrum.item.ModCreativeModTabs;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import com.sebas2008.blood_and_ferrum.item.client.KeyMappings;
import com.sebas2008.blood_and_ferrum.item.custom.ChitoArmorItem;
import com.sebas2008.blood_and_ferrum.item.custom.MagazineItem;
import com.sebas2008.blood_and_ferrum.item.custom.YuuriArmorItem;
import com.sebas2008.blood_and_ferrum.network.ModMessages;
import com.sebas2008.blood_and_ferrum.network.ReloadPayload;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.slf4j.Logger;

@Mod(Blood_and_Ferrum.MOD_ID)
public class Blood_and_Ferrum {
    public static final String MOD_ID = "bloodandferrum";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Blood_and_Ferrum(IEventBus modEventBus) {
        LOGGER.info("Initializing Blood and Ferrum mod...");

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(DataGenerators::gatherData);
        NeoForge.EVENT_BUS.register(this);

        ModDataComponents.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(ModMessages::register);
        ModEffects.register(modEventBus);
        modEventBus.addListener(this::onClientSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void onClientSetup(final FMLClientSetupEvent event) {

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
            event.accept(ModItems.ACP45.get());
            event.accept(ModItems.SHELL_45ACP.get());
            event.accept(ModItems.POINT_45ACP.get());
            event.accept(ModItems.M1911_MAGAZINE.get());
            ItemStack loadedMag = new ItemStack(ModItems.M1911_MAGAZINE_LOADED.get());
            MagazineItem.setAmmo(loadedMag, MagazineItem.MAX_AMMO);
            event.accept(loadedMag);
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

    // Handles powder snow physics and freeze prevention directly in 1.21.1
    @EventBusSubscriber(modid = MOD_ID)
    public static class PowderSnowHandler {

        @SubscribeEvent
        public static void onEntityTick(EntityTickEvent.Post event) {
            Entity rawEntity = event.getEntity();

            if (rawEntity instanceof LivingEntity entity) {
                ItemStack boots = entity.getItemBySlot(EquipmentSlot.FEET);

                boolean wearingModBoots = (boots.getItem() instanceof YuuriArmorItem || boots.getItem() instanceof ChitoArmorItem);

                if (wearingModBoots) {
                    // Prevent freeze accumulation
                    if (entity.getTicksFrozen() > 0) {
                        entity.setTicksFrozen(0);
                    }

                    // Handle standing on powder snow without crouching
                    if (entity.level().getBlockState(entity.blockPosition()).is(Blocks.POWDER_SNOW) && !entity.isCrouching()) {
                        entity.setOnGround(true);
                        if (entity.getDeltaMovement().y < 0) {
                            entity.setDeltaMovement(entity.getDeltaMovement().x, 0.0D, entity.getDeltaMovement().z);
                        }
                    }
                }
            }
        }
    }

    // Modern NeoForge 1.21.1 gameplay event listener (No bus parameter needed!)[cite: 8]
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientGameEvents {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            while (KeyMappings.RELOAD_KEY.consumeClick()) {
                Player player = Minecraft.getInstance().player;
                if (player == null) return;

                ItemStack mainHand = player.getMainHandItem();

                if (mainHand.getItem() instanceof MagazineItem) {
                    PacketDistributor.sendToServer(new ReloadPayload());
                }
            }
        }
    }
}