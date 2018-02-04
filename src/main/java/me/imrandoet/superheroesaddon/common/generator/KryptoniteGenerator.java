package me.imrandoet.superheroesaddon.common.generator;

import cpw.mods.fml.common.IWorldGenerator;
import me.imrandoet.superheroesaddon.common.blocks.SUHBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class KryptoniteGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            generateOre(SUHBlocks.blockKryptoniteOre, world, random, chunkX, chunkZ, 10, 6, SUHBlocks.blockKryptoniteOre);
        }
    }

    public void generateOre(Block block, World world, Random random, int chunk_x, int chunk_z, int maxVeinSize, int chancesToSpawn, Block generateIn) {
        WorldGenMinable worldgenminable = new WorldGenMinable(block, maxVeinSize, generateIn);
        for (int k1 = 0; k1 < chancesToSpawn; ++k1) {
            int xrand = random.nextInt(16);
            int yrand = random.nextInt(38);
            int zrand = random.nextInt(16);
            worldgenminable.generate(world, random, chunk_x+xrand, yrand, chunk_z+zrand);
        }
    }

}
