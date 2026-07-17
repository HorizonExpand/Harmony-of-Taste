package net.hrumer.harmony_of_taste.content.features;

import com.mojang.serialization.Codec;
import net.hrumer.harmony_of_taste.content.features.configurations.HugeChampignonFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class HugeChampignonFeature extends Feature<HugeChampignonFeatureConfiguration> {
    public HugeChampignonFeature(Codec<HugeChampignonFeatureConfiguration> pContext) {
        super(pContext);
    }

    @Override
    public boolean place(FeaturePlaceContext<HugeChampignonFeatureConfiguration> pContext) {
        final WorldGenLevel worldgenlevel = pContext.level();
        RandomSource random = pContext.random();
        BlockPos pos = pContext.origin();
        HugeChampignonFeatureConfiguration config = pContext.config();
        Block capBlock = config.capProvider.getState(random, pos).getBlock();
        Block stemBlock = config.capProvider.getState(random, pos).getBlock();
        int stemHeight = Mth.randomBetweenInclusive(random, 3, 5);

        for (int y = pos.getY(); y < (pos.getY() + stemHeight); y++) {
            BlockPos posStem = new BlockPos(pos.getX(), y, pos.getZ());
            worldgenlevel.setBlock(posStem, stemBlock.defaultBlockState(), 3);
        }

        return true;
    }
}
