package net.hrumer.harmony_of_taste.init;

import net.hrumer.harmony_of_taste.content.features.HugeChampignonFeature;
import net.hrumer.harmony_of_taste.content.features.configurations.HugeChampignonFeatureConfiguration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public abstract class HarmonyOfTasteFeature<FC extends FeatureConfiguration> {
    public static final Feature<HugeChampignonFeatureConfiguration> HUGE_CHAMPIGNON =
            register("huge_champignon", new HugeChampignonFeature(HugeChampignonFeatureConfiguration.CODEC));

    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String id, F feature) {
        return (F)(Registry.register(BuiltInRegistries.FEATURE, id, feature));
    }

}