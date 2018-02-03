package me.imrandoet.superheroesaddon.common.blocks;

import me.imrandoet.superheroesaddon.common.items.SUHItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class BlockKryptoniteOre extends Block {

    protected BlockKryptoniteOre() {
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(6.0F);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return SUHItems.kryptonite;
    }
}
