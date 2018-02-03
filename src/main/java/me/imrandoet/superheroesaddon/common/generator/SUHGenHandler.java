package me.imrandoet.superheroesaddon.common.generator;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.imrandoet.superheroesaddon.common.blocks.SUHBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class SUHGenHandler  {

    private World world;
    private Random rand;
    private int xCoord;
    private int zCoord;
    private WorldGenerator kryptoniteGen;

    public SUHGenHandler() {
        this.kryptoniteGen = new KryptoniteGenerator(SUHBlocks.blockKryptoniteOre);
    }

    @SubscribeEvent
    public void onOreGenPre(OreGenEvent.Pre event) {
        this.world = event.world;
        this.rand = event.rand;
        this.xCoord = event.worldX;
        this.zCoord = event.worldZ;
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post e) {
        this.genStandardOre(2, this.kryptoniteGen, 38);
    }

    private void genStandardOre(int veins, WorldGenerator generator, int maxHeight) {
        if (TerrainGen.generateOre(this.world, this.rand, generator, this.xCoord, this.zCoord, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
            for(int i = 0; i < veins; ++i) {
                int x = this.xCoord + this.rand.nextInt(16);
                int y = this.rand.nextInt(maxHeight);
                int z = this.zCoord + this.rand.nextInt(16);
                generator.generate(this.world, this.rand, x, y, z);
            }
        }
    }
}
