package me.imrandoet.superheroesaddon.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.imrandoet.superheroesaddon.common.items.SUHItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by ImranDoet on 29-1-2018.
 */

public class BlockKryptoniteOre extends Block {

    @SideOnly(Side.CLIENT)
    public IIcon icon;

    protected BlockKryptoniteOre() {
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(6.0F);
    }

    @Override
    public void registerBlockIcons(IIconRegister iIconRegister) {
        icon = iIconRegister.registerIcon(getTextureName());
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return icon;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return SUHItems.kryptonite;
    }
}
