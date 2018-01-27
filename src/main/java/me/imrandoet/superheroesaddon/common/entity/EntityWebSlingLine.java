package me.imrandoet.superheroesaddon.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ImranDoet on 25-10-2017.
 */

public class EntityWebSlingLine extends Entity
{
    public Entity entity;
    public EntityPlayer player;

    public EntityWebSlingLine(World world)
    {
        super(world);
        setSize(0.1F, 0.1F);
        ignoreFrustumCheck = true;
        renderDistanceWeight = 20D;
    }

    public EntityWebSlingLine(World world, EntityLivingBase entity, EntityPlayer player, EntityWebSlingArrow parent)
    {
        super(world);
//        this.entity = entity;
//        this.player = player;
        this.player = (EntityPlayer) parent.getShooter();
        this.entity = parent;
        setSize(0.1F, 0.1F);
        ignoreFrustumCheck = true;
        renderDistanceWeight = 20D;
        setLocationAndAngles(entity.posX, entity.posY + entity.height / 2, entity.posZ, entity.rotationYaw, entity.rotationPitch);
    }

    @Override
    public void onUpdate()
    {
        if (++ticksExisted > 2)
        {
            setDead();
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
    }

    @Override
    protected void entityInit()
    {
    }
}
