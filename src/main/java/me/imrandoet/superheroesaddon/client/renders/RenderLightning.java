package me.imrandoet.superheroesaddon.client.renders;


import fiskfille.core.helper.VectorHelper;
import fiskfille.heroes.client.trail.TrailRenderHandler;
import fiskfille.heroes.common.entity.EntitySpeedMirage;
import fiskfille.heroes.common.event.ClientEventHandler;
import fiskfille.heroes.helper.SHRenderHelper;
import fiskfille.heroes.helper.SpeedsterHelper;
import me.imrandoet.superheroesaddon.common.entity.EntityLightning;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;

/**
 * Created by ImranDoet on 9-8-2017.
 */

public class RenderLightning extends Render {

    @Override
    public void doRender(Entity entity1, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityLightning entity = (EntityLightning) entity1;
        EntityPlayer player = (EntityPlayer) entity.entity;
//        EntityPlayer clientPlayer = Minecraft.getMinecraft().thePlayer;

        if (player != null) {
            if (player.ticksExisted == 0) {
                player.lastTickPosX = player.posX;
                player.lastTickPosY = player.posY;
                player.lastTickPosZ = player.posZ;
            }

            x = SHRenderHelper.interpolate(player.posX, player.lastTickPosX) - RenderManager.renderPosX;
            y = SHRenderHelper.interpolate(player.posY, player.lastTickPosY) - RenderManager.renderPosY;
            z = SHRenderHelper.interpolate(player.posZ, player.lastTickPosZ) - RenderManager.renderPosZ;

            GL11.glPushMatrix();
            GL11.glTranslatef((float) x, (float) y, (float) z);
            GL11.glScalef(-1, -1, -1);

            LinkedList<EntitySpeedMirage> list = TrailRenderHandler.getSpeedMiragesFromPlayer(player);
            int amountOfLightnings = 6;
            float lightningSpace = player.height / amountOfLightnings;
            float scale = player.height / 1.8F;
            float offset = (scale - 1) * 1.62F - player.height * 1.1F;

            SHRenderHelper.setupRenderLightning();
            Vec3 playerPos = player.getPosition(partialTicks).addVector(0, offset + (1 - scale) * 1.62F * 2, 0);

            for (int i = 0; i < amountOfLightnings; ++i) {
                Vec3 add = Vec3.createVectorHelper(0, i * lightningSpace, 0);
                float differ = 0.435F * scale;

                if (list.size() > 0) {
                    Vec3 firstStart = list.getLast().getLightningPosVector(i).subtract(list.getLast().getPosition(partialTicks)).addVector(0, offset + player.yOffset, 0);
                    Vec3 firstEnd = list.getLast().getLightningPosVector(i).subtract(playerPos);

                    float alpha = 1 - (list.getLast().progress + ClientEventHandler.renderTick) / 10;
                    SHRenderHelper.drawLightningLine(VectorHelper.add(firstStart, add.addVector(0, list.getFirst().lightningFactor[i] * differ, 0)), VectorHelper.add(firstEnd, add.addVector(0, list.getLast().lightningFactor[i] * differ, 0)), 5, 1, SpeedsterHelper.getLightningColor(player), alpha);

                    for (int j = 0; j < list.size(); ++j) {
                        if (j < list.size() - 1) {
                            EntitySpeedMirage speedMirage = list.get(j);
                            EntitySpeedMirage speedMirage2 = list.get(j + 1);
                            Vec3 start = speedMirage.getLightningPosVector(i).subtract(playerPos);
                            Vec3 end = speedMirage2.getLightningPosVector(i).subtract(playerPos);

                            float progress = 1 - (speedMirage.progress + ClientEventHandler.renderTick) / 10;
                            SHRenderHelper.drawLightningLine(VectorHelper.add(start, add.addVector(0, speedMirage.lightningFactor[i] * differ, 0)), VectorHelper.add(end, add.addVector(0, speedMirage2.lightningFactor[i] * differ, 0)), 5, 1, SpeedsterHelper.getLightningColor(player), progress);
                            }
                        }
                    }
                }

                SHRenderHelper.finishRenderLightning();

            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
