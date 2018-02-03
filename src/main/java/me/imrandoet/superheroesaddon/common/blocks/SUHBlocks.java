package me.imrandoet.superheroesaddon.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.common.entity.tileentity.TileEntitySpeedDampener;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ImranDoet on 30-10-2017.
 */

public class SUHBlocks {

    public static Block blockSpeedDampener;
    public static Block blockKryptoniteOre;

    private static void registerBlockTileEntity(Block block, String name, Class clazzzzz, String textureName) {
        registerBlock(block, name, textureName);
        GameRegistry.registerTileEntity(clazzzzz, name);
    }

    private static void registerBlock(Block block, String name, String textureName) {
        block.setBlockName(name.toLowerCase().replaceAll(" ", "_"));
        block.setBlockTextureName(new ResourceLocation("superheroesaddon", textureName).toString());
        block.setCreativeTab(SuperheroesAddon.tab);

        GameRegistry.registerBlock(block, name.toLowerCase().replaceAll(" ", "_"));
    }

    public static void init() {
        blockSpeedDampener = new BlockSpeedDampener().setHardness(4.5F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(SuperheroesAddon.tab);
        registerBlockTileEntity(blockSpeedDampener, "Speed Dampener", TileEntitySpeedDampener.class, "speed_dampener");
        blockKryptoniteOre = new BlockKryptoniteOre();
        registerBlock(blockKryptoniteOre, "Kryptonite Ore", "kryptonite_ore");
    }

}
