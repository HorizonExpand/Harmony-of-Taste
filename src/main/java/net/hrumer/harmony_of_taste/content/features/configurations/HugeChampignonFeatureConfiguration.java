package net.hrumer.harmony_of_taste.content.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class HugeChampignonFeatureConfiguration implements FeatureConfiguration {

    public static final Codec<HugeChampignonFeatureConfiguration> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    BlockStateProvider.CODEC.fieldOf("cap_provider")
                            .forGetter(config -> config.capProvider),

                    BlockStateProvider.CODEC.fieldOf("stem_provider")
                            .forGetter(config -> config.stemProvider),

                    Codec.INT.fieldOf("stem_height")
                            .orElse(3)
                            .forGetter(config -> config.stemHeight)
            ).apply(instance, HugeChampignonFeatureConfiguration::new));

    public final BlockStateProvider capProvider;
    public final BlockStateProvider stemProvider;
    public final int stemHeight;

    public HugeChampignonFeatureConfiguration(
            BlockStateProvider capProvider,
            BlockStateProvider stemProvider,
            int stemHeight) {

        this.capProvider = capProvider;
        this.stemProvider = stemProvider;
        this.stemHeight = stemHeight;
    }
}