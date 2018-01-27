package me.imrandoet.superheroesaddon.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ImranDoet on 31-10-2017.
 */

public class EntityLightning extends Entity {

    public EntityLivingBase entity;

    public EntityLightning(World world) {
        super(world);
        setSize(0.1F, 0.1F);
        this.ignoreFrustumCheck = true;
        this.renderDistanceWeight = 100.0D;
    }

    public EntityLightning(World world, EntityLivingBase entity)
    {
        this(world);
        this.entity = entity;
        setLocationAndAngles(entity.posX, entity.posY + entity.height / 2.0F, entity.posZ, entity.rotationYaw, entity.rotationPitch);
    }

    public void onUpdate() {
        if (++this.ticksExisted > 2) {
            setDead();
        }
    }



    public void readEntityFromNBT(NBTTagCompound nbt) {}

    public void writeEntityToNBT(NBTTagCompound nbt) {}

    protected void entityInit() {}
}
