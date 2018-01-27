package me.imrandoet.superheroesaddon.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ImranDoet on 1-7-2017.
 */
public class EntityBeam extends Entity {

    public EntityPlayer acquired;

    public EntityBeam(World world) {
        super(world);
        this.setSize(0.1F, 0.1F);
        this.noClip = true;
        this.renderDistanceWeight = 10.0D;
        this.ignoreFrustumCheck = true;
    }

    public EntityBeam(World world, EntityPlayer player) {
        super(world);
        this.setSize(0.1F, 0.1F);
        this.noClip = true;
        this.renderDistanceWeight = 10.0D;
        this.ignoreFrustumCheck = true;
        this.acquired = player;
        this.setLocationAndAngles(this.acquired.prevPosX, this.acquired.prevPosY - 1.6200000047683716D, this.acquired.prevPosZ, this.acquired.rotationYaw, this.acquired.rotationPitch);
    }

    public void onUpdate() {
        if(++this.ticksExisted > 2) {
            this.setDead();
        }

    }

    public boolean shouldRenderInPass(int pass) {
        return pass == 1;
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean canBePushed() {
        return false;
    }

    public boolean writeToNBTOptional(NBTTagCompound nbttagcompound) {
        return false;
    }

    protected void entityInit() {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }
}
