//package me.imrandoet.superheroesaddon.client.renders;
//
//import fiskfille.heroes.client.model.ModelBipedMultiLayer;
//import me.imrandoet.superheroesaddon.SuperheroesAddon;
//import me.imrandoet.superheroesaddon.heroes.Wolverine;
//import me.imrandoet.superheroesaddon.client.models.LeftClaw;
//import me.imrandoet.superheroesaddon.client.models.RightClaw;
//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.model.ModelRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.util.ResourceLocation;
//import org.lwjgl.opengl.GL11;
//
///**
// * Created by ImranDoet on 23-7-2017.
// */
//public class ModelWolverine extends ModelBipedMultiLayer {
//
//    private RightClaw rightClaw = new RightClaw();
//    private LeftClaw leftClaw = new LeftClaw();
//    private ResourceLocation resourceLocation = new ResourceLocation(SuperheroesAddon.MODID, "textures/adamantium_texture.png");
//
//    @Override
//    public void renderModel(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//        super.renderModel(entity, f, f1, f2, f3, f4, f5);
//
//        float f55 = 0.0625F;
//        if (Wolverine.claws) {
//            mc.getTextureManager().bindTexture(resourceLocation);
//            GL11.glPushMatrix();
//            bipedRightArm.postRender(0.0625F);
//            GL11.glTranslatef(1.0F, -0.2F, 0.0F);
//            rightClaw.render();
//            GL11.glPopMatrix();
//
//            mc.getTextureManager().bindTexture(resourceLocation);
//            GL11.glPushMatrix();
//            this.bipedLeftArm.postRender(0.0625F);
//            GL11.glTranslatef(-1.0F, -0.2F, 0.0F);
//            leftClaw.render();
//            GL11.glPopMatrix();
//        }
//    }
//}
