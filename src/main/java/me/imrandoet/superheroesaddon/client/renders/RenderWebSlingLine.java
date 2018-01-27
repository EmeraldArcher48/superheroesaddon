package me.imrandoet.superheroesaddon.client.renders;

import fiskfille.heroes.helper.SHRenderHelper;
import me.imrandoet.superheroesaddon.common.entity.EntityWebSlingLine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

/**
 * Created by ImranDoet on 25-10-2017.
 */

public class RenderWebSlingLine extends Render {

    public RenderWebSlingLine()
    {
        shadowSize = 0.0F;
    }

    public void renderCable(EntityWebSlingLine cable, double x, double y, double z, float f, float partialTicks)
    {
        GL11.glPushMatrix();
        Tessellator tessellator = Tessellator.instance;
        EntityPlayer player = cable.player;
        Entity entity = cable.entity;

        if (cable.isEntityAlive() && player != null)
        {
            float f9 = player.getSwingProgress(partialTicks);
            float f10 = MathHelper.sin(MathHelper.sqrt_float(f9) * (float) Math.PI);
            Vec3 vec3 = Vec3.createVectorHelper(-0.35D, -0.1D, 0.35D);
            vec3.rotateAroundX(-SHRenderHelper.interpolate(player.rotationPitch, player.prevRotationPitch) * (float) Math.PI / 180.0F);
            vec3.rotateAroundY(-SHRenderHelper.interpolate(player.rotationYaw, player.prevRotationYaw) * (float) Math.PI / 180.0F);
            vec3.rotateAroundY(f10 * 0.5F);

            double entityPosX = SHRenderHelper.interpolate(entity.posX, entity.prevPosX);
            double entityPosY = SHRenderHelper.interpolate(entity.posY, entity.prevPosY) + entity.height / 2 - (entity == Minecraft.getMinecraft().thePlayer ? 1.62F : 0);
            double entityPosZ = SHRenderHelper.interpolate(entity.posZ, entity.prevPosZ);
            double playerPosX = SHRenderHelper.interpolate(player.posX, player.prevPosX) + vec3.xCoord;
            double playerPosY = SHRenderHelper.interpolate(player.posY, player.prevPosY) + vec3.yCoord;
            double playerPosZ = SHRenderHelper.interpolate(player.posZ, player.prevPosZ) + vec3.zCoord;

            if (renderManager.options.thirdPersonView > 0 || player != Minecraft.getMinecraft().thePlayer)
            {
                float renderYawOffset = SHRenderHelper.interpolate(player.renderYawOffset, player.prevRenderYawOffset) * (float) Math.PI / 180.0F;
                double side = 0.3D;
                double forward = 0.3D;
                double yOffset = (player == Minecraft.getMinecraft().thePlayer ? 0.0D : (double) player.getEyeHeight()) - 0.3D;
                double d = MathHelper.sin(renderYawOffset);
                double d1 = MathHelper.cos(renderYawOffset);

                playerPosX = SHRenderHelper.interpolate(player.posX, player.prevPosX) - d1 * side - d * forward;
                playerPosY = SHRenderHelper.interpolate(player.posY, player.prevPosY) + yOffset - 0.45D;
                playerPosZ = SHRenderHelper.interpolate(player.posZ, player.prevPosZ) - d * side + d1 * forward;
            }

            Vec3 src = Vec3.createVectorHelper(entityPosX, entityPosY, entityPosZ);
            Vec3 dst = Vec3.createVectorHelper(playerPosX, playerPosY, playerPosZ);
            double width = 1F / 48;
            double length = src.distanceTo(dst);
            byte segments = 24;

            x = entityPosX - RenderManager.renderPosX;
            y = entityPosY - RenderManager.renderPosY;
            z = entityPosZ - RenderManager.renderPosZ;
            GL11.glTranslated(x, y, z);
            SHRenderHelper.faceVec(src, dst);

            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);

            for (int i = 0; i < segments; ++i)
            {
                double segmentLength = length / segments;
                double start = i * segmentLength;
                double end = i * segmentLength + segmentLength;

                tessellator.startDrawingQuads();

                tessellator.addVertex(width, width, end);
                tessellator.addVertex(width, width, start);
                tessellator.addVertex(-width, width, start);
                tessellator.addVertex(-width, width, end);
                tessellator.addVertex(-width, -width, start);
                tessellator.addVertex(width, -width, start);
                tessellator.addVertex(width, -width, end);
                tessellator.addVertex(-width, -width, end);
                tessellator.addVertex(-width, width, start);
                tessellator.addVertex(-width, -width, start);
                tessellator.addVertex(-width, -width, end);
                tessellator.addVertex(-width, width, end);
                tessellator.addVertex(width, -width, end);
                tessellator.addVertex(width, -width, start);
                tessellator.addVertex(width, width, start);
                tessellator.addVertex(width, width, end);

                if (i == segments - 1)
                {
                    tessellator.addVertex(width, -width, end);
                    tessellator.addVertex(width, width, end);
                    tessellator.addVertex(-width, width, end);
                    tessellator.addVertex(-width, -width, end);
                }
                else if (i == 0)
                {
                    tessellator.addVertex(-width, width, start);
                    tessellator.addVertex(width, width, start);
                    tessellator.addVertex(width, -width, start);
                    tessellator.addVertex(-width, -width, start);
                }

                tessellator.draw();
            }

            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glEnable(GL11.GL_LIGHTING);
        }

        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float f, float partialTicks)
    {
        renderCable((EntityWebSlingLine) entity, x, y, z, f, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation("textures/entity/arrow.png");
    }
}
