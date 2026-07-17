package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.HarmonyOfTaste;
import net.hrumer.harmony_of_taste.content.features.configurations.HugeChampignonFeatureConfiguration;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class HarmonyOfTasteConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_CHAMPIGNON = registerKey("huge_champignon");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, HUGE_CHAMPIGNON, HarmonyOfTasteFeature.HUGE_CHAMPIGNON, hugeChampignon());

    }

    private static HugeChampignonFeatureConfiguration hugeChampignon() {
        return (new HugeChampignonFeatureConfiguration(
                BlockStateProvider.simple(HarmonyOfTasteBlocks.CHAMPIGNON_BLOCK.get()),
                BlockStateProvider.simple(HarmonyOfTasteBlocks.CHAMPIGNON_STEM.get()),
                Mth.randomBetweenInclusive(RandomSource.create(), 3, 5)
        ));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(HarmonyOfTaste.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}