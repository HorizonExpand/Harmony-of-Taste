package net.hrumer.harmony_of_taste.content.features;

import com.mojang.serialization.Codec;
import net.hrumer.harmony_of_taste.content.features.configurations.HugeChampignonFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class HugeChampignonFeature extends Feature<HugeChampignonFeatureConfiguration> {
    public HugeChampignonFeature(Codec<HugeChampignonFeatureConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<HugeChampignonFeatureConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        RandomSource random = pContext.random();
        BlockPos pos = pContext.origin();
        HugeChampignonFeatureConfiguration config = pContext.config();
        BlockState capState = config.capProvider.getState(random, pos);
        BlockState stemState = config.stemProvider.getState(random, pos);
        Integer height = config.stemHeight;

        for (int y = pos.getY(); y <= pos.getY() + height; y++) {
            BlockPos posStem = new BlockPos(pos.getX(), y, pos.getZ());
            worldgenlevel.setBlock(posStem, stemState.getBlock().defaultBlockState(), 2);
        }

        return true;
    }
}
