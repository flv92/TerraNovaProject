package fr.terranova.flv92.dinosaurus.entity;

import fr.terranova.flv92.dinosaurus.common.Dinosaurus;
import fr.terranova.flv92.dinosaurus.common.Sounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityHadrosaur extends EntityDinosaurce
{

    public EntityHadrosaur(World world) {
        super(world, Dinosaurus.hadrosaurAttackStrength, false);
        this.texture = "/dinosaurus/hadrosaur.png";
        setSize(7.0F, 4.0F);
        this.moveSpeed = Dinosaurus.hadrosaurMoveSpeed;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    @Override
    public int getMaxHealth() {
        return 60;
    }

    @Override
    public void onUpdate() {
        Entity p = this.getAttackTarget();
        if (p != null) {
            if (this.getDistanceToEntity(p) > 25.0D) {
                this.setAttackTarget(null);
            }
        }

        super.onUpdate();
    }

    @Override
    protected int getDropItemId() {
        return 0;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.SOUND_PREFIX + "hadrosaur_living";
    }

    @Override
    protected String getHurtSound() {
        return Sounds.SOUND_PREFIX + "hadrosaur_hurt";
    }

    @Override
    protected String getDeathSound() {
        return Sounds.SOUND_PREFIX + "hadrosaur_death";
    }

    @Override
    public float getSpeedModifier() {
        return this.getAttackTarget() != null ? 1.5F : 1.0F;
    }
}