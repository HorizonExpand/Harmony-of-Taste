package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;
import net.hrumer.harmony_of_taste.content.items.CowMilkBottleItem;
import net.hrumer.harmony_of_taste.content.items.GoatMilkBottleItem;
import net.hrumer.harmony_of_taste.content.items.GoatMilkBucketItem;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HarmonyOfTasteItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HarmonyOfTaste.MODID);

    public static final DeferredItem<BlockItem> CHAMPIGNON_ITEM = ITEMS.registerSimpleBlockItem("champignon", HarmonyOfTasteBlocks.CHAMPIGNON);
    public static final DeferredItem<BlockItem> CHAMPIGNON_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("champignon_block", HarmonyOfTasteBlocks.CHAMPIGNON_BLOCK);
    public static final DeferredItem<Item> RAW_GOAT_MEAT = ITEMS.registerSimpleItem("raw_goat_meat",
            new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).build()));
    public static final DeferredItem<Item> COOKED_GOAT_MEAT = ITEMS.registerSimpleItem("cooked_goat_meat",
            new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f).build()));
    public static final DeferredItem<Item> GOAT_MILK_BUCKET = ITEMS.register("goat_milk_bucket", () ->
                    new GoatMilkBucketItem(HarmonyOfTasteFluids.GOAT_MILK.get(),
                            new Item.Properties().craftRemainder(Items.BUCKET)
                                    .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).alwaysEdible().build()).stacksTo(1)));
    public static final DeferredItem<Item> GOAT_MILK_BOTTLE = ITEMS.register("goat_milk_bottle", () ->
            new GoatMilkBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6f).alwaysEdible().build()).stacksTo(16).component(
                    HarmonyOfTasteDataComponents.FLUID_CONTENT.get(),
                    SimpleFluidContent.copyOf(
                            new FluidStack(HarmonyOfTasteFluids.GOAT_MILK.get(), 250)))));
    public static final DeferredItem<Item> COW_MILK_BOTTLE = ITEMS.register("cow_milk_bottle", () ->
            new CowMilkBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6f).alwaysEdible().build()).stacksTo(16).component(
                    HarmonyOfTasteDataComponents.FLUID_CONTENT.get(),
                    SimpleFluidContent.copyOf(
                            new FluidStack(NeoForgeMod.MILK.get(), 250)))));
    public static final DeferredItem<BlockItem> HAY_SLAB_ITEM = ITEMS.registerSimpleBlockItem("hay_slab", HarmonyOfTasteBlocks.HAY_SLAB);
    public static final DeferredItem<BlockItem> HAY_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("hay_stairs", HarmonyOfTasteBlocks.HAY_STAIRS);

    public static void registry (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
