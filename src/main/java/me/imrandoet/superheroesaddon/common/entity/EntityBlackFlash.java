package me.imrandoet.superheroesaddon.common.entity;

import fiskfille.heroes.common.data.IDataHolder;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.helper.SHHelper;
import me.imrandoet.superheroesaddon.common.data.SUHData;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by ImranDoet on 22-11-2017.
 */

public class EntityBlackFlash extends EntityMob implements IDataHolder {

    public EntityBlackFlash(World w) {
        super(w);
        this.getNavigator().setAvoidsWater(true);
        this.isImmuneToFire = true;
        this.entityCollisionReduction = 1.5F;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
    }

    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
        SUHData.BLACK_FLASH.set(this.getAttackTarget(), false);
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    protected void attackEntity(Entity attacked, float amount) {
        super.attackEntity(attacked, amount);

        if (attacked instanceof EntityPlayer) {
            EntityPlayer ep = (EntityPlayer) attacked;
            if (SHHelper.getHero(ep) == null) return;
            if (SHHelper.isSpeedster(ep)) {
                if (getAttackTarget() == ep) {
                    ep.setCurrentItemOrArmor(1, null);
                    ep.setCurrentItemOrArmor(2, null);
                    ep.setCurrentItemOrArmor(3, null);
                    ep.setCurrentItemOrArmor(4, null);
                    SUHData.BLACK_FLASH.set(ep, false);
                    this.setDead();
                }
            }
        }
    }

    @Override
    public void onUpdate() {
//        super.onUpdate();
        if (!this.isEntityAlive()) return;
        if (!this.worldObj.isRemote) {
            if (this.getActivePotionEffects().size() > 0) {
                this.clearActivePotions();
            }
        }
    }

    @Override
    public <T> void set(SHData<T> shData, T t) {}

    @Override
    public <T> T get(SHData<T> shData) {
        return null;
    }
}
