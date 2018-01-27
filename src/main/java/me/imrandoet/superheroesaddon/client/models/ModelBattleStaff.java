//package me.imrandoet.superheroesaddon.models;
//
//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.model.ModelRenderer;
//import net.minecraft.entity.Entity;
//
//public class ModelBattleStaff extends ModelBase {
//    public ModelRenderer battlestaff_part1;
//    public ModelRenderer battlestaff_middle;
//    public ModelRenderer battlestaff_part1_1;
//
//    public ModelBattleStaff() {
//        this.textureWidth = 16;
//        this.textureHeight = 16;
//        this.battlestaff_middle = new ModelRenderer(this, 0, 0);
//        this.battlestaff_middle.setRotationPoint(0.0F, 0.0F, 0.0F);
//        this.battlestaff_middle.addBox(-1.4F, -4.5F, -1.5F, 3, 1, 3, 0.4F);
//        this.battlestaff_part1_1 = new ModelRenderer(this, 0, 0);
//        this.battlestaff_part1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
//        this.battlestaff_part1_1.addBox(-1.4F, -24.6F, -1.5F, 3, 20, 3, 0.0F);
//        this.battlestaff_part1 = new ModelRenderer(this, 0, 0);
//        this.battlestaff_part1.setRotationPoint(0.1F, 0.0F, 0.0F);
//        this.battlestaff_part1.addBox(-1.5F, -3.51F, -1.5F, 3, 20, 3, 0.0F);
//    }
//
//    @Override
//    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
//        this.battlestaff_middle.render(f5);
//        this.battlestaff_part1_1.render(f5);
//        this.battlestaff_part1.render(f5);
//    }
//
//    /**
//     * This is a helper function from Tabula to set the rotation of model parts
//     */
//    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//        modelRenderer.rotateAngleX = x;
//        modelRenderer.rotateAngleY = y;
//        modelRenderer.rotateAngleZ = z;
//    }
//}
