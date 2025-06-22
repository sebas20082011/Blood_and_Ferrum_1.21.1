package com.sebas2008.blood_and_ferrum.block;


import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Blood_and_Ferrum.MOD_ID);

    public static final RegistryObject<Block> ZINC_ORE  =   registerBlock("zincore_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> LEAD_ORE  =   registerBlock("leadore_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> STEEL_BLOCK  =   registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BRASS_ORE  =   registerBlock("brass_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));

private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
}

private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
    ModItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
}

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
