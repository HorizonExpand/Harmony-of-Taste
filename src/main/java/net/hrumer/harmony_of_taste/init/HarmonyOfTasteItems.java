package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;
import net.hrumer.harmony_of_taste.content.items.GoatMilkBucketItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HarmonyOfTasteItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HarmonyOfTaste.MODID);

    public static final DeferredItem<BlockItem> CHAMPIGNON_ITEM = ITEMS.registerSimpleBlockItem("champignon", HarmonyOfTasteBlocks.CHAMPIGNON);
    public static final DeferredItem<BlockItem> CHAMPIGNON_STEM_ITEM = ITEMS.registerSimpleBlockItem("champignon_stem", HarmonyOfTasteBlocks.CHAMPIGNON_STEM);
    public static final DeferredItem<BlockItem> CHAMPIGNON_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("champignon_block", HarmonyOfTasteBlocks.CHAMPIGNON_BLOCK);
    public static final DeferredItem<Item> RAW_GOAT_MEAT = ITEMS.registerSimpleItem("raw_goat_meat",
            new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f).build()));
    public static final DeferredItem<Item> COOKED_GOAT_MEAT = ITEMS.registerSimpleItem("cooked_goat_meat",
            new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f).build()));
    public static final DeferredItem<Item> GOAT_MILK_BUCKET = ITEMS.register("goat_milk_bucket", () ->
                    new GoatMilkBucketItem(HarmonyOfTasteFluids.GOAT_MILK.get(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    ));

    public static void registry (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
