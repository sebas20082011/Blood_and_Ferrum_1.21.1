package com.sebas2008.blood_and_ferrum.datagen;

import com.sebas2008.blood_and_ferrum.Blood_and_Ferrum;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Blood_and_Ferrum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
            // These are all for the materials that would later transform into ingots
            basicItem(ModItems.RAW_LEAD.get());
            basicItem(ModItems.RAW_ZINC.get());
            basicItem(ModItems.RAW_SILVER.get());
            basicItem(ModItems.RAW_IRON_COAL.get());

        basicItem(ModItems.STEEL.get());
        basicItem(ModItems.C_CROSS.get());
        basicItem(ModItems.O_CROSS.get());
        basicItem(ModItems.ZINC.get());
        basicItem(ModItems.SILVER.get());
        basicItem(ModItems.BRASS.get());
        basicItem(ModItems.POWERED_CRISTIAN_CROSS.get());
        basicItem(ModItems.POWERED_ORTODOX_CROSS.get());
        basicItem(ModItems.LEAD.get());
        basicItem(ModItems.COPPER_AND_ZINC.get());
        }
}
