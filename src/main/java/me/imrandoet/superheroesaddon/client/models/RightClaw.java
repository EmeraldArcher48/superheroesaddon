package me.imrandoet.superheroesaddon.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class RightClaw extends ModelBase {
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;

    public RightClaw() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape11 = new ModelRenderer(this, 0, 0);
        this.shape11.setRotationPoint(-8.0F, 10.9F, 0.95F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape12 = new ModelRenderer(this, 0, 0);
        this.shape12.setRotationPoint(-8.0F, 14.8F, 1.95F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape12, 0.18203784098300857F, 1.5707963267948966F, 0.0F);
        this.shape14 = new ModelRenderer(this, 0, 0);
        this.shape14.setRotationPoint(-8.0F, 14.8F, 0.5F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape14, 0.18203784098300857F, 1.5707963267948966F, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(-8.0F, 10.9F, -1.95F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape13 = new ModelRenderer(this, 0, 0);
        this.shape13.setRotationPoint(-8.0F, 14.8F, -0.95F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape13, 0.18203784098300857F, 1.5707963267948966F, 0.0F);
        this.shape10 = new ModelRenderer(this, 0, 0);
        this.shape10.setRotationPoint(-8.0F, 10.9F, -0.5F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
    }

    public void bindbox(ModelBiped to) {
        to.bipedRightArm.addChild(this.shape11);
        to.bipedRightArm.addChild(this.shape12);
        to.bipedRightArm.addChild(this.shape14);
        to.bipedRightArm.addChild(this.shape9);
        to.bipedRightArm.addChild(this.shape13);
        to.bipedRightArm.addChild(this.shape10);
    }

    public void render() {
        GL11.glPushMatrix();
        float f5 = 0.0625F;
        GL11.glTranslatef(-1.0F, -0.2F, 0.0F);
        this.shape11.render(f5);
        this.shape12.render(f5);
        this.shape14.render(f5);
        this.shape9.render(f5);
        this.shape13.render(f5);
        this.shape10.render(f5);
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
