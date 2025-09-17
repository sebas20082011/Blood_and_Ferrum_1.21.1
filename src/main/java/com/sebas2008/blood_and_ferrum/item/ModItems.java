package com.sebas2008.blood_and_ferrum.item;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.custom.PoweredCristianCrossItem;
import com.sebas2008.blood_and_ferrum.item.custom.PoweredOrtodoxCrossItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Blood_and_Ferrum.MOD_ID);

public static final RegistryObject<Item> C_CROSS=ITEMS.register
        ("c_cross", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> O_CROSS=ITEMS.register
            ("o_cross", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_AND_ZINC=ITEMS.register
            ("r_c_zinc", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_LEAD=ITEMS.register
            ("r_l", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BRASS=ITEMS.register
            ("brass", ()-> new Item(new Item.Properties()));


    public static final RegistryObject<Item> LEAD=ITEMS.register
            ("lead", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_IRON_COAL=ITEMS.register
            ("i_coal", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ZINC=ITEMS.register
            ("r_zinc", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZINC=ITEMS.register
            ("zinc", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL=ITEMS.register
            ("steel", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SILVER=ITEMS.register
            ("silver", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SILVER=ITEMS.register
            ("r_silver", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> POWERED_CRISTIAN_CROSS = ITEMS.register(
            "p_c_c", () -> new PoweredCristianCrossItem(new Item.Properties().durability(PoweredCristianCrossItem.MAX_USES).stacksTo(1))
    );

    public static final RegistryObject<Item> POWERED_ORTODOX_CROSS = ITEMS.register(
            "p_o_c", () -> new PoweredOrtodoxCrossItem(new Item.Properties().durability(PoweredCristianCrossItem.MAX_USES).stacksTo(1))
    );

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
