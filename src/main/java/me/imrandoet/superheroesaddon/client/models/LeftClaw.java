package me.imrandoet.superheroesaddon.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class LeftClaw extends ModelBase {
    public ModelRenderer shape15;
    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape18;
    public ModelRenderer shape19;
    public ModelRenderer shape20;

    public LeftClaw() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape15 = new ModelRenderer(this, 0, 0);
        this.shape15.setRotationPoint(7.0F, 10.9F, -0.5F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape20 = new ModelRenderer(this, 0, 0);
        this.shape20.setRotationPoint(8.0F, 14.8F, 1.0F);
        this.shape20.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape20, 0.18203784098300857F, -1.5707963267948966F, 0.0F);
        this.shape18 = new ModelRenderer(this, 0, 0);
        this.shape18.setRotationPoint(8.0F, 14.8F, -2.0F);
        this.shape18.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape18, 0.18203784098300857F, -1.5707963267948966F, 0.0F);
        this.shape17 = new ModelRenderer(this, 0, 0);
        this.shape17.setRotationPoint(7.0F, 10.9F, 0.0F);
        this.shape17.addBox(0.0F, 0.0F, -2.0F, 1, 4, 1, 0.0F);
        this.shape19 = new ModelRenderer(this, 0, 0);
        this.shape19.setRotationPoint(7.0F, 10.9F, 1.0F);
        this.shape19.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape16 = new ModelRenderer(this, 0, 0);
        this.shape16.setRotationPoint(8.0F, 14.8F, -0.5F);
        this.shape16.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape16, 0.18203784098300857F, -1.5707963267948966F, 0.0F);
    }

    public void bindbox(ModelBiped to) {
        to.bipedRightArm.addChild(this.shape15);
        to.bipedRightArm.addChild(this.shape20);
        to.bipedRightArm.addChild(this.shape18);
        to.bipedRightArm.addChild(this.shape17);
        to.bipedRightArm.addChild(this.shape19);
        to.bipedRightArm.addChild(this.shape16);
    }


    public void render() {
        GL11.glPushMatrix();
        float f5 = 0.0625F;
        GL11.glTranslatef(-1.0F, -0.2F, 0.0F);
        this.shape15.render(f5);
        this.shape20.render(f5);
        this.shape18.render(f5);
        this.shape17.render(f5);
        this.shape19.render(f5);
        this.shape16.render(f5);
        GL11.glPopMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
