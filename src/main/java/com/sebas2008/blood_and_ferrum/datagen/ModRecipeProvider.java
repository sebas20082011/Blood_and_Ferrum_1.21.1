package com.sebas2008.blood_and_ferrum.datagen;

import com.sebas2008.blood_and_ferrum.block.ModBlocks;
import com.sebas2008.blood_and_ferrum.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {



        // 9 Brass -> 1 Brass Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRASS_BLOCK.get())
                .pattern("BBB").pattern("BBB").pattern("BBB")
                .define('B', ModItems.BRASS.get())
                .unlockedBy("has_brass", has(ModItems.BRASS.get()))
                .save(recipeOutput);

        // 1 Brass Block -> 9 Brass
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRASS.get(), 9)
                .requires(ModBlocks.BRASS_BLOCK.get())
                .unlockedBy("has_brass_block", has(ModBlocks.BRASS_BLOCK.get()))
                .save(recipeOutput);

        // 9 Steel -> 1 Steel Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("AAA").pattern("AAA").pattern("AAA")
                .define('A', ModItems.STEEL.get())
                .unlockedBy("has_steel", has(ModItems.STEEL.get()))
                .save(recipeOutput);

        // 1 Steel Block -> 9 Steel
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK.get()))
                .save(recipeOutput);

        // 9 Silver -> 1 Silver Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("AAA").pattern("AAA").pattern("AAA")
                .define('A', ModItems.SILVER.get())
                .unlockedBy("has_silver", has(ModItems.SILVER.get()))
                .save(recipeOutput);

        // 1 Silver Block -> 9 Silver
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy("has_silver_block", has(ModBlocks.SILVER_BLOCK.get()))
                .save(recipeOutput);




        // Copper and Zinc Mix (r_c_zinc)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_AND_ZINC.get())
                .pattern("XXC")
                .pattern("XCC")
                .define('X', Items.COPPER_INGOT)
                .define('C', ModItems.ZINC.get())
                .unlockedBy("has_zinc", has(ModItems.ZINC.get()))
                .group("r_c_zinc")
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SHELL_45ACP.get())

                .pattern("XCX")
                .pattern("XXX")
                .define('X', ModItems.BRASS.get())
                .define('C', Items.GUNPOWDER)
                .unlockedBy("has_brass", has(ModItems.BRASS.get()))
                .group("shell_45acp")
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POINT_45ACP.get())
                .pattern(" C ")
                .pattern("CXC")

                .define('X', ModItems.LEAD.get())
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_brass", has(ModItems.BRASS.get()))
                .group("point_45acp")
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ACP45.get())
                .pattern(" C ")
                .pattern(" X ")
                .pattern(" A ")
                .define('X', Items.GUNPOWDER)
                .define('C', ModItems.POINT_45ACP.get())
                .define('A', ModItems.SHELL_45ACP.get())
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER))
                .group("point_45acp")
                .save(recipeOutput);

        // Raw Iron and Coal Material (i_coal)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_IRON_COAL.get())
                .pattern("XXC")
                .pattern("XCC")
                .define('X', Items.RAW_IRON)
                .define('C', Items.COAL)
                .unlockedBy("has_raw_iron", has(Items.RAW_IRON))
                .group("i_coal")
                .save(recipeOutput);

        // Cristian Cross
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.C_CROSS.get())
                .pattern(" X ")
                .pattern("ZCD")
                .pattern(" O ")
                .define('X', Items.GOLD_INGOT)
                .define('C', Items.DIAMOND)
                .define('Z', Items.LAPIS_LAZULI)
                .define('D', Items.EMERALD)
                .define('O', Items.REDSTONE)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .group("c_cross")
                .save(recipeOutput);

        // Orthodox Cross
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.O_CROSS.get())
                .pattern(" L ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', Items.GOLD_INGOT)
                .define('C', Items.DIAMOND)
                .define('L', Items.PURPLE_DYE)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .group("c_cross")
                .save(recipeOutput);






        // Lead Ore Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.LEAD_ORE.get()), RecipeCategory.MISC, ModItems.LEAD.get(), 1.0F, 200)
                .unlockedBy("has_lead_ore", has(ModBlocks.LEAD_ORE.get()))
                .group("lead")
                .save(recipeOutput, "bloodandferrum:lead_from_smelting_leadore");

        // Raw Lead Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_LEAD.get()), RecipeCategory.MISC, ModItems.LEAD.get(), 1.0F, 100)
                .unlockedBy("has_raw_lead", has(ModItems.RAW_LEAD.get()))
                .group("lead")
                .save(recipeOutput, "bloodandferrum:lead_from_smelting_raw");

        // Zinc Ore Smelting (zincore_block)
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ZINC_ORE.get()), RecipeCategory.MISC, ModItems.ZINC.get(), 1.0F, 200)
                .unlockedBy("has_zinc_ore", has(ModBlocks.ZINC_ORE.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:zinc_from_smelting_ore");

        // Raw Zinc Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_ZINC.get()), RecipeCategory.MISC, ModItems.ZINC.get(), 1.0F, 200)
                .unlockedBy("has_raw_zinc", has(ModItems.RAW_ZINC.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:zinc_from_smelting_raw");

        // Silver Ore Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.RAW_SILVER_ORE.get()), RecipeCategory.MISC, ModItems.SILVER.get(), 1.0F, 350)
                .unlockedBy("has_silver_ore", has(ModBlocks.RAW_SILVER_ORE.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:silver_from_smelting_ore");

        // Raw Silver Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_SILVER.get()), RecipeCategory.MISC, ModItems.SILVER.get(), 1.0F, 350)
                .unlockedBy("has_raw_silver", has(ModItems.RAW_SILVER.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:silver_from_smelting_raw");

        // Copper and Zinc Mix Smelting into Brass
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COPPER_AND_ZINC.get()), RecipeCategory.MISC, ModItems.BRASS.get(), 3.0F, 355)
                .unlockedBy("has_copper_and_zinc_mix", has(ModItems.COPPER_AND_ZINC.get()))
                .group("brass")
                .save(recipeOutput, "bloodandferrum:brass_from_smelting_mix");




        // Lead Ore Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.LEAD_ORE.get()), RecipeCategory.MISC, ModItems.LEAD.get(), 1.0F, 50)
                .unlockedBy("has_lead_ore", has(ModBlocks.LEAD_ORE.get()))
                .group("lead")
                .save(recipeOutput, "bloodandferrum:lead_from_blasting_leadore");

        // Raw Lead Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_LEAD.get()), RecipeCategory.MISC, ModItems.LEAD.get(), 1.0F, 50)
                .unlockedBy("has_raw_lead", has(ModItems.RAW_LEAD.get()))
                .group("lead")
                .save(recipeOutput, "bloodandferrum:lead_from_blasting_raw");

        // Zinc Ore Blasting (zincore_block)
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.ZINC_ORE.get()), RecipeCategory.MISC, ModItems.ZINC.get(), 1.0F, 100)
                .unlockedBy("has_zinc_ore", has(ModBlocks.ZINC_ORE.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:zinc_from_blasting_ore");

        // Raw Zinc Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_ZINC.get()), RecipeCategory.MISC, ModItems.ZINC.get(), 1.0F, 100)
                .unlockedBy("has_raw_zinc", has(ModItems.RAW_ZINC.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:zinc_from_blasting_raw");

        // Silver Ore Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.RAW_SILVER_ORE.get()), RecipeCategory.MISC, ModItems.SILVER.get(), 1.0F, 200)
                .unlockedBy("has_silver_ore", has(ModBlocks.RAW_SILVER_ORE.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:silver_from_blasting_ore");


        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_SILVER.get()), RecipeCategory.MISC, ModItems.SILVER.get(), 1.0F, 200)
                .unlockedBy("has_raw_silver", has(ModItems.RAW_SILVER.get()))
                .group("zinc")
                .save(recipeOutput, "bloodandferrum:silver_from_blasting_raw");


        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.COPPER_AND_ZINC.get()), RecipeCategory.MISC, ModItems.BRASS.get(), 3.0F, 200)
                .unlockedBy("has_copper_and_zinc_mix", has(ModItems.COPPER_AND_ZINC.get()))
                .group("brass")
                .save(recipeOutput, "bloodandferrum:brass_from_blasting_mix");





        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.RAW_LEAD.get()), RecipeCategory.MISC, ModItems.LEAD.get(), 1.0F, 150)
                .unlockedBy("has_raw_lead", has(ModItems.RAW_LEAD.get()))
                .group("lead")
                .save(recipeOutput, "bloodandferrum:lead_from_campfire_raw");
    }
}