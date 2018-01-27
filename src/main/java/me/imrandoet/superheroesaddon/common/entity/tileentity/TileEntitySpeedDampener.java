package me.imrandoet.superheroesaddon.common.entity.tileentity;

import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.data.effect.Effect;
import fiskfille.heroes.common.data.effect.StatusEffect;
import fiskfille.heroes.common.tileentity.TileEntitySH;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

/**
 * Created by ImranDoet on 30-10-2017.
 */

public class TileEntitySpeedDampener extends TileEntitySH {

    @Override
    public void updateEntity() {
        List<EntityPlayer> entityList = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.xCoord + 1, this.yCoord + 1, this.zCoord + 1, this.xCoord + 50, this.yCoord + 50, this.zCoord + 50));
        for (EntityPlayer ep : entityList) {
            if (SHHelper.isSpeedster(ep)) {
                if (!this.worldObj.isRemote) {
                    if (SHData.SPEED.get(ep) != null && SHData.SPEED.get(ep) >= 0) {
                        if (StatusEffect.has(ep, Effect.SPEED_DAMPENER))
                            return;
                        StatusEffect.add(ep, Effect.SPEED_DAMPENER, 300 * 20, 0);
                    }
                }
            }
        }
    }

    @Override
    protected void writeCustomNBT(NBTTagCompound nbt) {
    }

    @Override
    protected void readCustomNBT(NBTTagCompound nbt) {
    }
}
