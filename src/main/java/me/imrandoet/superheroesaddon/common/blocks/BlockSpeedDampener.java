package me.imrandoet.superheroesaddon.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.imrandoet.superheroesaddon.SuperheroesAddon;
import me.imrandoet.superheroesaddon.common.entity.tileentity.TileEntitySpeedDampener;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by ImranDoet on 30-10-2017.
 */

public class BlockSpeedDampener extends Block implements ITileEntityProvider {

    @SideOnly(Side.CLIENT)
    public IIcon icon;

    protected BlockSpeedDampener() {
        super(Material.iron);
        this.setHardness(4.5F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab(SuperheroesAddon.tab);
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
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntitySpeedDampener();
    }
}
