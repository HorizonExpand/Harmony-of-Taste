package net.hrumer.harmony_of_taste.content.features;

import com.mojang.serialization.Codec;

import net.hrumer.harmony_of_taste.content.features.configurations.HugeChampignonFeatureConfiguration;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
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
        BlockPos posOrigin = pContext.origin();
        HugeChampignonFeatureConfiguration config = pContext.config();
        BlockState capState = config.capProvider.getState(random, posOrigin);
        BlockState stemState = config.stemProvider.getState(random, posOrigin);
        int stemHeightMin = config.stemHeightMin;
        int stemHeightMax = config.stemHeightMax;
        int stemHeight = Mth.randomBetweenInclusive(random, stemHeightMin, stemHeightMax);
        boolean smallMush = stemHeight < 5;

        for (int x = (posOrigin.getX() - 1); x <= (posOrigin.getX() + 1); x++) {
            for (int z = (posOrigin.getZ() - 1); z <= (posOrigin.getZ() + 1); z++) {
                BlockPos posCapTop = new BlockPos(x, smallMush ? (posOrigin.getY() + stemHeight - 2) : (posOrigin.getY() + stemHeight - 3), z);
                placeBlock(posCapTop, capState.setValue(HugeMushroomBlock.UP, false).setValue(HugeMushroomBlock.DOWN, false), 3, worldgenlevel);
            }
        }
        for (int x = (posOrigin.getX() - 1); x <= (posOrigin.getX() + 1); x++) {
            for (int z = (posOrigin.getZ() - 1); z <= (posOrigin.getZ() + 1); z++) {
                BlockPos posCapTop = new BlockPos(x, (posOrigin.getY() + stemHeight), z);
                placeBlock(posCapTop, capState.setValue(HugeMushroomBlock.DOWN, false), 3, worldgenlevel);
            }
        }
        for (int x = (posOrigin.getX() - 1); x <= (posOrigin.getX() + 1); x++) {
            for (int y = (posOrigin.getY() + stemHeight - 1); smallMush ? y >= (posOrigin.getY() + stemHeight - 2) : y >= (posOrigin.getY() + stemHeight - 3); y--) {
                BlockPos posCapNorth = new BlockPos(x, y, (posOrigin.getZ() - 2));
                placeBlock(posCapNorth, capState.setValue(HugeMushroomBlock.SOUTH, false), 3, worldgenlevel);
            }
        }
        for (int x = (posOrigin.getX() - 1); x <= (posOrigin.getX() + 1); x++) {
            for (int y = (posOrigin.getY() + stemHeight - 1); smallMush ? y >= (posOrigin.getY() + stemHeight - 2) : y >= (posOrigin.getY() + stemHeight - 3); y--) {
                BlockPos posCapSouth = new BlockPos(x, y, (posOrigin.getZ() + 2));
                placeBlock(posCapSouth, capState.setValue(HugeMushroomBlock.NORTH, false), 3, worldgenlevel);
            }
        }
        for (int z = (posOrigin.getZ() - 1); z <= (posOrigin.getZ() + 1); z++) {
            for (int y = (posOrigin.getY() + stemHeight - 1); smallMush ? y >= (posOrigin.getY() + stemHeight - 2) : y >= (posOrigin.getY() + stemHeight - 3); y--) {
                BlockPos posCapWest = new BlockPos((posOrigin.getX() - 2), y, z);
                placeBlock(posCapWest, capState.setValue(HugeMushroomBlock.EAST, false), 3, worldgenlevel);
            }
        }
        for (int z = (posOrigin.getZ() - 1); z <= (posOrigin.getZ() + 1); z++) {
            for (int y = (posOrigin.getY() + stemHeight - 1); smallMush ? y >= (posOrigin.getY() + stemHeight - 2) : y >= (posOrigin.getY() + stemHeight - 3); y--) {
                BlockPos posCapEast = new BlockPos((posOrigin.getX() + 2), y, z);
                placeBlock(posCapEast, capState.setValue(HugeMushroomBlock.WEST, false), 3, worldgenlevel);
            }
        }
        for (int y = posOrigin.getY(); y <= (posOrigin.getY() + stemHeight - 1); y++) {
            BlockPos posStem = new BlockPos(posOrigin.getX(), y, posOrigin.getZ());
            placeBlock(posStem, stemState, 3, worldgenlevel);
        }
        return true;
    }

    public void placeBlock(BlockPos pos, BlockState blockState, int update, WorldGenLevel worldGenLevel) {
        if (worldGenLevel.getBlockState(pos).is(BlockTags.REPLACEABLE_BY_TREES) || worldGenLevel.getBlockState(pos).is(Blocks.AIR)) {
            worldGenLevel.setBlock(pos, blockState, update);
        }
    }
}
