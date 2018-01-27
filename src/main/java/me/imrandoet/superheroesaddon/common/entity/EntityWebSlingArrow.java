package me.imrandoet.superheroesaddon.common.entity;

import fiskfille.heroes.common.entity.arrow.EntityTrickArrow;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by ImranDoet on 25-10-2017.
 */

public class EntityWebSlingArrow extends EntityTrickArrow
{

    public EntityWebSlingArrow(World world)
    {
        super(world);
        ignoreFrustumCheck = true;
        renderDistanceWeight = 20;
    }

    public EntityWebSlingArrow(World world, double x, double y, double z)
    {
        super(world, x, y, z);
        ignoreFrustumCheck = true;
        renderDistanceWeight = 20;
    }

    public EntityWebSlingArrow(World world, EntityLivingBase shooter, float velocity)
    {
        super(world, shooter, velocity);
        ignoreFrustumCheck = true;
        renderDistanceWeight = 20;
    }

    public EntityWebSlingArrow(World world, EntityLivingBase shooter, float velocity, boolean horizontal)
    {
        super(world, shooter, velocity, horizontal);
        ignoreFrustumCheck = true;
        renderDistanceWeight = 20;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if (getIsCableCut())
        {
            super.onCollideWithPlayer(player);
        }
    }


    @Override
    public float getVelocityFactor()
    {
        return 1.5F;
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.05F;
    }

    @Override
    protected void onImpactEntity(MovingObjectPosition mop)
    {
        if (mop.entityHit != null && mop.entityHit != getShooter())
        {
            shootingEntity = getShooter();

            if (isBurning() && canTargetEntity(mop.entityHit))
            {
                SHHelper.ignite(mop.entityHit, 5);
            }

            if (mop.entityHit instanceof EntityLivingBase && !(mop.entityHit instanceof EntityEnderman))
            {
                handlePostDamageEffects((EntityLivingBase) mop.entityHit);

                if (shootingEntity instanceof EntityPlayerMP && mop.entityHit != shootingEntity && mop.entityHit instanceof EntityPlayer)
                {
                    ((EntityPlayerMP) shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                }
            }

            playSound("random.bowhit", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));

            if (canTargetEntity(mop.entityHit))
            {
                setDead();
            }
        }
    }

    @Override
    public boolean isInvisibleToPlayer(EntityPlayer p_98034_1_) {
        return true;
    }

    @Override
    public void onUpdate()
    {
        this.setInvisible(true);
        super.onUpdate();

        EntityLivingBase entityLivingBase = (EntityLivingBase) getShooter();
        inEntityUpdate(entityLivingBase);

        if (!getIsCableCut() && (getShooter() == null || !getShooter().isEntityAlive()))
        {
            setIsCableCut(true);
        }

    }

    @Override
    public ItemStack getPickedResult(MovingObjectPosition target) {
        return null;
    }

    @Override
    public void inEntityUpdate(EntityLivingBase living)
    {
        super.inEntityUpdate(living);

        if (getShooter() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) getShooter();

            if (!getIsCableCut())
            {
                if (player.isSneaking()) {
                    setIsCableCut(true);
                }

                if (prevPosX == posX && prevPosY == posY && prevPosZ == posZ)
                {
                    player.fallDistance = 0;
                    player.motionX += (posX - player.posX) / 60;
                    player.motionY += (posY - player.posY) / 60;
                    player.motionZ += (posZ - player.posZ) / 60;

                    if (player.getDistanceToEntity(living) > 10)
                    {
                        living.fallDistance = 0;
                        living.motionX += (player.posX - posX) / 100;
                        living.motionY += (player.posY - posY) / 100;
                        living.motionZ += (player.posZ - posZ) / 100;
                    }
                }

                worldObj.spawnEntityInWorld(makeCable(living, player));
            }
        }
    }

    public EntityWebSlingLine makeCable(EntityLivingBase living, EntityPlayer player)
    {
        return new EntityWebSlingLine(worldObj, living, player, this);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(19, (byte) 0);
    }

    public boolean getIsCableCut()
    {
        return dataWatcher.getWatchableObjectByte(19) > 0;
    }

    public void setIsCableCut(boolean flag)
    {
        dataWatcher.updateObject(19, (byte) (flag ? 1 : 0));
        this.setDead();
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        setIsCableCut(nbt.getBoolean("IsCableCut"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("IsCableCut", getIsCableCut());
    }
}
