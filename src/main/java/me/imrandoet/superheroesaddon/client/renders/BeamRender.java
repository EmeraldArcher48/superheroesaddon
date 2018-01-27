//package me.imrandoet.superheroesaddon.client.renders;
//
//import fiskfille.heroes.common.data.SHData;
//import fiskfille.heroes.common.helper.SHHelper;
//import fiskfille.heroes.common.helper.SHRenderHelper;
//import fiskfille.heroes.common.helper.VectorHelper;
//import fiskfille.heroes.common.hero.Hero;
//import fiskfille.heroes.common.hero.IHeatVision;
//import java.awt.Color;
//
//import fiskfille.heroes.helper.SHHelper;
//import fiskfille.heroes.helper.SHRenderHelper;
//import me.imrandoet.superheroesaddon.common.abilities.Abilities;
//import me.imrandoet.superheroesaddon.common.entity.EntityBeam;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.Tessellator;
//import net.minecraft.client.renderer.entity.Render;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.Vec3;
//import org.lwjgl.opengl.GL11;
//
//public class BeamRender extends Render {
//
//    public void doRender(Entity entity1, double x, double y, double z, float entityYaw, float partialTicks) {
//        EntityBeam entity = (EntityBeam) entity1;
//        EntityPlayer player = entity.acquired;
//        EntityPlayer clientPlayer = Minecraft.getMinecraft().thePlayer;
//        if(player != null) {
//            Hero hero = SHHelper.getHero(player);
//            if(player.ticksExisted == 0) {
//                player.lastTickPosX = player.posX;
//                player.lastTickPosY = player.posY;
//                player.lastTickPosZ = player.posZ;
//            }
//
//            double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)partialTicks;
//            double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)partialTicks;
//            double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)partialTicks;
//            x = d0 - RenderManager.renderPosX;
//            y = d1 - RenderManager.renderPosY;
//            z = d2 - RenderManager.renderPosZ;
//            GL11.glPushMatrix();
//            GL11.glTranslatef((float)x, (float)y, (float)z);
//            if(hero != null && hero.hasAbility(Abilities.ENERGY_BEAM) && SHData.getBoolean(player, 16)) {
//                Tessellator tessellator = Tessellator.instance;
//                GL11.glDisable(3553);
//                GL11.glDisable(2896);
//                GL11.glDisable(2884);
//                GL11.glEnable(3042);
//                GL11.glBlendFunc(770, '耄');
//                GL11.glAlphaFunc(516, 0.003921569F);
//                SHRenderHelper.setLighting('\uf0f0');
//                int i = 0;
//
//                while(true) {
//                    if(i >= 2) {
//                        SHRenderHelper.resetLighting();
//                        GL11.glEnable(2896);
//                        GL11.glEnable(3553);
//                        GL11.glAlphaFunc(516, 0.1F);
//                        GL11.glDisable(3042);
//                        break;
//                    }
//
//                    float scale = SHHelper.getDefaultScale(player);
//                    double d = player == clientPlayer?-1.62D:0.0D;
////                    Vec3 vec = VectorHelper.getOffsetCoords(player, 0.0D, 0.0D, 0.0D);
////                    Vec3 src = vec.subtract(SHHelper.getHeatVisionVec(player, i, true, partialTicks)).addVector(0.0D, d, 0.0D);
////                    Vec3 dst = vec.subtract(SHHelper.getHeatVisionVec(player, i, false, partialTicks)).addVector(0.0D, d, 0.0D);
////                    if(player == clientPlayer && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
////                        src = vec.subtract(VectorHelper.getOffsetCoords(player, (double)(0.05F * (float)(i * 2 - 1) * scale), -0.05000000074505806D, -0.10000000149011612D, partialTicks).addVector(0.0D, (double)(1.62F * scale), 0.0D)).addVector(0.0D, d, 0.0D);
////                        scale = 1.0F;
////                    }
//
//                    int smoothFactor = Minecraft.getMinecraft().gameSettings.ambientOcclusion;
//                    int layers = 10 + smoothFactor * 20;
//
//                    for(int j = 0; j <= layers; ++j) {
//                        GL11.glPushMatrix();
//                        if(j < layers) {
////                            Color color = ((IHeatVision)hero).getHeatVisionColor(player);
//                            GL11.glColor4f((float)color.getRed() / 255.0F, (float)color.getGreen() / 255.0F, (float)color.getBlue() / 255.0F, 1.0F / (float)layers / 2.0F);
//                            GL11.glDepthMask(false);
//                        } else {
//                            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                            GL11.glDepthMask(true);
//                        }
//
//                        double size = 0.25D + (j < layers?(double)j * (1.25D / (double)layers):0.0D);
//                        double width = 0.0625D * size * (double)scale;
//                        double height = 0.03125D * size * (double)scale;
//                        double length = src.distanceTo(dst) + (j < layers?(double)j * (1.0D / (double)layers):0.0D) * 0.0625D;
//                        GL11.glTranslated(src.xCoord, src.yCoord, src.zCoord);
//                        if(player == clientPlayer && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
//                            GL11.glRotated((double)(-SHRenderHelper.median((double)player.rotationYaw, (double)player.prevRotationYaw)) - (double)(i * 2 - 1) * (32.0D / length) * 0.20999999344348907D, 0.0D, 1.0D, 0.0D);
//                            GL11.glRotated((double)SHRenderHelper.median((double)player.rotationPitch, (double)player.prevRotationPitch), 1.0D, 0.0D, 0.0D);
//                        } else {
//                            GL11.glRotated((double)(-SHRenderHelper.median((double)player.rotationYawHead, (double)player.prevRotationYawHead)) - (double)(i * 2 - 1) * (32.0D / length) * 0.20999999344348907D, 0.0D, 1.0D, 0.0D);
//                            GL11.glRotated((double)SHRenderHelper.median((double)player.rotationPitch, (double)player.prevRotationPitch), 1.0D, 0.0D, 0.0D);
//                        }
//
//                        tessellator.startDrawingQuads();
//                        tessellator.addVertex(-width, height, length);
//                        tessellator.addVertex(width, height, length);
//                        tessellator.addVertex(width, height, 0.0D);
//                        tessellator.addVertex(-width, height, 0.0D);
//                        tessellator.addVertex(width, -height, 0.0D);
//                        tessellator.addVertex(width, -height, length);
//                        tessellator.addVertex(-width, -height, length);
//                        tessellator.addVertex(-width, -height, 0.0D);
//                        tessellator.addVertex(-width, -height, 0.0D);
//                        tessellator.addVertex(-width, -height, length);
//                        tessellator.addVertex(-width, height, length);
//                        tessellator.addVertex(-width, height, 0.0D);
//                        tessellator.addVertex(width, height, length);
//                        tessellator.addVertex(width, -height, length);
//                        tessellator.addVertex(width, -height, 0.0D);
//                        tessellator.addVertex(width, height, 0.0D);
//                        tessellator.addVertex(width, -height, length);
//                        tessellator.addVertex(width, height, length);
//                        tessellator.addVertex(-width, height, length);
//                        tessellator.addVertex(-width, -height, length);
//                        tessellator.draw();
//                        GL11.glPopMatrix();
//                    }
//
//                    ++i;
//                }
//            }
//
//            GL11.glPopMatrix();
//        }
//
//    }
//
//    protected ResourceLocation getEntityTexture(Entity entity) {
//        return null;
//    }
//}
