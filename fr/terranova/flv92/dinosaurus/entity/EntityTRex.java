package fr.terranova.flv92.dinosaurus.entity;

import fr.terranova.flv92.dinosaurus.common.Dinosaurus;
import fr.terranova.flv92.dinosaurus.common.Sounds;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTRex extends EntityDinosaurce {

    public EntityTRex(World var1) {
        super(var1, Dinosaurus.trexAttackStrength, true);
        this.texture = "/dinosaurus/TRex.png";
        setSize(8.0F, 8.0F);
        this.moveSpeed = Dinosaurus.trexMoveSpeed;
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
    }

    @Override
    protected String getLivingSound() {
        return this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null ? Sounds.SOUND_PREFIX + "Trex_Living" : null;
    }

    @Override
    protected String getHurtSound() {
        return Sounds.SOUND_PREFIX + "TRex_hit";
    }

    @Override
    protected String getDeathSound() {
        return Sounds.SOUND_PREFIX + "Trex_Death";
    }

    @Override
    public boolean getCanSpawnHere() {
        return (this.worldObj.checkIfAABBIsClear(this.boundingBox)) && (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()) && (!this.worldObj.isAnyLiquid(this.boundingBox));
    }

    @Override
    public int getMaxHealth() {
        return 140;
    }
}