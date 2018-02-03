package me.imrandoet.superheroesaddon.common.generator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class KryptoniteGenerator extends WorldGenMinable {

    private Block kryptonite;

    public KryptoniteGenerator(Block block) {
        super(block, 1);
        this.kryptonite = block;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        if (world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.stone)) {
            world.setBlock(x, y, z, this.kryptonite, 0, 1);
        }

        return true;
    }
}
