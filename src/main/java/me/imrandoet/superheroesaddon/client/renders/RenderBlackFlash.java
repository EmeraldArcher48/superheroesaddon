package me.imrandoet.superheroesaddon.client.renders;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.heroes.FiskHeroes;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ImranDoet on 25-11-2017.
 */

@SideOnly(Side.CLIENT)
public class RenderBlackFlash extends RenderBiped {

    public RenderBlackFlash() {
        super(new ModelBiped(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        float f1 = 0.9375F;
        GL11.glScalef(f1, f1, f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return new ResourceLocation(FiskHeroes.MODID, "textures/null.png");

    }
}
