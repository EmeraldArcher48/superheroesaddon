//package me.imrandoet.superheroesaddon.client.models;
//
//import fiskfille.heroes.common.data.SHData;
//import fiskfille.heroes.common.helper.SHRenderHelper;
//import fiskfille.heroes.helper.SHRenderHelper;
//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.model.ModelRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.ChatComponentText;
//import net.minecraft.util.Vec3;
//
//import java.lang.reflect.Field;
//
///**
// * Created by ImranDoet on 17-6-2017.
// */
//public class ModelSpiderWing extends ModelBase {
//    public ModelRenderer rightWing1;
//    public ModelRenderer leftWing1;
//    public ModelRenderer rightWing2;
//    public ModelRenderer rightWing3;
//    public ModelRenderer rightWing4;
//    public ModelRenderer rightWing5;
//    public ModelRenderer rightWing6;
//    public ModelRenderer leftWing2;
//    public ModelRenderer leftWing3;
//    public ModelRenderer leftWing4;
//    public ModelRenderer leftWing5;
//    public ModelRenderer leftWing6;
//
//    public ModelSpiderWing() {
//        this.textureWidth = 64;
//        this.textureHeight = 32;
//        this.leftWing1 = new ModelRenderer(this, 0, -3);
//        this.leftWing1.setRotationPoint(0.95F, 2.0F, 1.6F);
//        this.leftWing1.addBox(-2.0F, -2.0F, -0.5F, 5, 7, 1, 0.0F);
//        this.setRotateAngle(this.leftWing1, 0.0F, 0.0F, 0.6981317F);
//        this.rightWing5 = new ModelRenderer(this, 0, -3);
//        this.rightWing5.mirror = true;
//        this.rightWing5.setRotationPoint(-4.0F, 0.0F, 0.0F);
//        this.rightWing5.addBox(-4.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.rightWing5, 0.0F, 0.017453292F, -0.5009095F);
//        this.rightWing2 = new ModelRenderer(this, 12, -3);
//        this.rightWing2.mirror = true;
//        this.rightWing2.setRotationPoint(-3.0F, -2.0F, 0.0F);
//        this.rightWing2.addBox(-5.0F, 0.0F, -0.5F, 5, 7, 1, 0.0F);
//        this.setRotateAngle(this.rightWing2, 0.0F, 0.017453292F, -0.87266463F);
//        this.rightWing6 = new ModelRenderer(this, 10, -3);
//        this.rightWing6.mirror = true;
//        this.rightWing6.setRotationPoint(-4.0F, 0.0F, 0.0F);
//        this.rightWing6.addBox(-4.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.rightWing6, 0.0F, 0.017453292F, -1.3203416F);
//        this.leftWing4 = new ModelRenderer(this, 10, -3);
//        this.leftWing4.setRotationPoint(4.0F, 0.0F, 0.0F);
//        this.leftWing4.addBox(0.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.leftWing4, 0.0F, -0.017453292F, 1.0821041F);
//        this.rightWing3 = new ModelRenderer(this, 0, -3);
//        this.rightWing3.mirror = true;
//        this.rightWing3.setRotationPoint(-5.0F, 0.0F, 0.0F);
//        this.rightWing3.addBox(-4.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.rightWing3, 0.0F, 0.017453292F, -0.9948377F);
//        this.leftWing2 = new ModelRenderer(this, 12, -3);
//        this.leftWing2.setRotationPoint(3.0F, -2.0F, 0.0F);
//        this.leftWing2.addBox(0.0F, 0.0F, -0.5F, 5, 7, 1, 0.0F);
//        this.setRotateAngle(this.leftWing2, 0.0F, -0.017453292F, 0.87266463F);
//        this.leftWing6 = new ModelRenderer(this, 10, -3);
//        this.leftWing6.setRotationPoint(4.0F, 0.0F, 0.0F);
//        this.leftWing6.addBox(0.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.leftWing6, 0.0F, -0.017453292F, 1.3203416F);
//        this.rightWing1 = new ModelRenderer(this, 0, -3);
//        this.rightWing1.mirror = true;
//        this.rightWing1.setRotationPoint(-0.95F, 2.0F, 1.6F);
//        this.rightWing1.addBox(-3.0F, -2.0F, -0.5F, 5, 7, 1, 0.0F);
//        this.setRotateAngle(this.rightWing1, 0.0F, 0.0F, -0.6981317F);
//        this.leftWing5 = new ModelRenderer(this, 0, -3);
//        this.leftWing5.setRotationPoint(4.0F, 0.0F, 0.0F);
//        this.leftWing5.addBox(0.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.leftWing5, 0.0F, -0.017453292F, 0.5009095F);
//        this.leftWing3 = new ModelRenderer(this, 0, -3);
//        this.leftWing3.setRotationPoint(5.0F, 0.0F, 0.0F);
//        this.leftWing3.addBox(0.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.leftWing3, 0.0F, -0.017453292F, 0.9948377F);
//        this.rightWing4 = new ModelRenderer(this, 10, -3);
//        this.rightWing4.mirror = true;
//        this.rightWing4.setRotationPoint(-4.0F, 0.0F, 0.0F);
//        this.rightWing4.addBox(-4.0F, 0.0F, -0.5F, 4, 7, 1, 0.0F);
//        this.setRotateAngle(this.rightWing4, 0.0F, 0.017453292F, -1.0821041F);
//        this.rightWing4.addChild(this.rightWing5);
//        this.rightWing1.addChild(this.rightWing2);
//        this.rightWing5.addChild(this.rightWing6);
//        this.leftWing3.addChild(this.leftWing4);
//        this.rightWing2.addChild(this.rightWing3);
//        this.leftWing1.addChild(this.leftWing2);
//        this.leftWing5.addChild(this.leftWing6);
//        this.leftWing4.addChild(this.leftWing5);
//        this.leftWing2.addChild(this.leftWing3);
//        this.rightWing3.addChild(this.rightWing4);
//    }
//
//    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//        this.leftWing1.render(f5);
//        this.rightWing1.render(f5);
//    }
//
//    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//        modelRenderer.rotateAngleX = x;
//        modelRenderer.rotateAngleY = y;
//        modelRenderer.rotateAngleZ = z;
//    }
//
//    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
//        this.leftWing1.setRotationPoint(0.95F, 2.0F, 1.6F);
//        this.setRotateAngle(this.leftWing1, 0.0F, 0.0F, 0.6981317F);
//        this.rightWing5.setRotationPoint(-4.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.rightWing5, 0.0F, 0.017453292F, -0.5009095F);
//        this.rightWing2.setRotationPoint(-3.0F, -2.0F, 0.0F);
//        this.setRotateAngle(this.rightWing2, 0.0F, 0.017453292F, -0.87266463F);
//        this.rightWing6.setRotationPoint(-4.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.rightWing6, 0.0F, 0.017453292F, -1.3203416F);
//        this.leftWing4.setRotationPoint(4.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.leftWing4, 0.0F, -0.017453292F, 1.0821041F);
//        this.rightWing3.setRotationPoint(-5.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.rightWing3, 0.0F, 0.017453292F, -0.9948377F);
//        this.leftWing2.setRotationPoint(3.0F, -2.0F, 0.0F);
//        this.setRotateAngle(this.leftWing2, 0.0F, -0.017453292F, 0.87266463F);
//        this.leftWing6.setRotationPoint(4.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.leftWing6, 0.0F, -0.017453292F, 1.3203416F);
//        this.rightWing1.setRotationPoint(-0.95F, 2.0F, 1.6F);
//        this.setRotateAngle(this.rightWing1, 0.0F, 0.0F, -0.6981317F);
//        this.leftWing5.setRotationPoint(4.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.leftWing5, 0.0F, -0.017453292F, 0.5009095F);
//        this.leftWing3.setRotationPoint(5.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.leftWing3, 0.0F, -0.017453292F, 0.9948377F);
//        this.rightWing4.setRotationPoint(-4.0F, 0.0F, 0.0F);
//        this.setRotateAngle(this.rightWing4, 0.0F, 0.017453292F, -1.0821041F);
//        if(entity instanceof EntityPlayer) {
//            EntityPlayer player = (EntityPlayer)entity;
//            float f6 = SHRenderHelper.interpolate((double) SHData.(player, 46), (double)SHData.getFloat(player, 47));
//            float f7 = 1.0F - f6 * f6 * 0.8F;
//            float f8 = -0.261799F;
//            float f9 = 1.0F;
//            if(player.motionY < 0.0D) {
//                Vec3 vec3d = Vec3.createVectorHelper(player.motionX, player.motionY, player.motionZ).normalize();
//                f9 = 1.0F - (float)Math.pow(-vec3d.yCoord, 1.5D);
//            }
//
//            f8 = f9 * -1.570796F + (1.0F - f9) * f8;
//            ModelRenderer[] rightWings = new ModelRenderer[]{this.rightWing1, this.rightWing2, this.rightWing3, this.rightWing4, this.rightWing5, this.rightWing6};
//            ModelRenderer[] leftWings = new ModelRenderer[]{this.leftWing1, this.leftWing2, this.leftWing3, this.leftWing4, this.leftWing5, this.leftWing6};
//
//            for(int i = 0; i < rightWings.length; ++i) {
//                ModelRenderer right = rightWings[i];
//                ModelRenderer left = leftWings[i];
//                right.rotateAngleX *= f7;
//                right.rotateAngleY *= f7;
//                right.rotateAngleZ *= f7;
//                left.rotateAngleX *= f7;
//                left.rotateAngleY *= f7;
//                left.rotateAngleZ *= f7;
//                if(i == 0) {
//                    right.rotateAngleX -= 0.2F * f6;
//                    right.rotateAngleY -= 0*2.F * f6;
////                    right.rotateAngleY += 0.2F * f6;
//                    //standard = 0
//                    right.rotateAngleZ = -(1.5707964F - 0.4F * f6 + f8 * f6);
//                    left.rotateAngleX -= 0.2F * f6;
//                    left.rotateAngleY -= 0*2.F * f6;
//                    //standard = 0
////                    left.rotateAngleY -= 0.2F * f6;
//                    left.rotateAngleZ = 1.5707964F - 0.4F * f6 + f8 * f6;
//                }
//            }
//        }
//
//    }
//}
