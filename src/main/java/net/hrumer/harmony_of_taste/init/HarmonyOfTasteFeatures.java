package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;
import net.hrumer.harmony_of_taste.content.features.HugeChampignonFeature;
import net.hrumer.harmony_of_taste.content.features.configurations.HugeChampignonFeatureConfiguration;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HarmonyOfTasteFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, HarmonyOfTaste.MODID);

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, HarmonyOfTaste.MODID);

    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_CHAMPIGNON_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(HarmonyOfTaste.MODID, "huge_champignon"));

    public static final DeferredHolder<Feature<?>, HugeChampignonFeature> HUGE_CHAMPIGNON_FEATURE =
            FEATURES.register("huge_champignon", () -> new HugeChampignonFeature(HugeChampignonFeatureConfiguration.CODEC));

    public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<HugeChampignonFeatureConfiguration, ?>>
            HUGE_CHAMPIGNON = CONFIGURED_FEATURES.register("huge_champignon", () ->
            new ConfiguredFeature<>(
                    HUGE_CHAMPIGNON_FEATURE.get(),
                    new HugeChampignonFeatureConfiguration(
                            BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK),
                            BlockStateProvider.simple(Blocks.MUSHROOM_STEM),
                            Mth.randomBetweenInclusive(RandomSource.create(), 3, 5)
                    )
            )
    );

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
        CONFIGURED_FEATURES.register(eventBus);
    }
}