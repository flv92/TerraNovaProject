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

public class EntityBrachiosaur extends EntityDinosaurce {

    public EntityBrachiosaur(World var1) {
        super(var1, Dinosaurus.brachiosaurAttackStrength, false);
        this.texture = "/dinosaurus/Brachiosaurus.png";
        setSize(7.0F, 10.0F);
        this.moveSpeed = Dinosaurus.brachiosaurMoveSpeed;
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

    }

    @Override
    protected String getLivingSound() {
        return this.worldObj.getClosestPlayerToEntity(this, 16.0D) != null ? Sounds.SOUND_PREFIX + "Brach_living" : null;
    }

    @Override
    public void onUpdate() {
        Entity p = this.getAttackTarget();
        if (p != null)
        {
            if (this.getDistanceToEntity(p) > 25.0D)
            {
                this.setAttackTarget(null);
            }
        }

        super.onUpdate();
    }

    @Override
    protected String getHurtSound() {
        return "mob.cow.hurt";
    }

    @Override
    protected String getDeathSound() {
        return Sounds.SOUND_PREFIX + "Brach_death";
    }

    @Override
    public int getMaxHealth() {
        return 250;
    }

    @Override
    public float getSpeedModifier() {
        return this.getAttackTarget() != null ? 1.5F : 1.0F;
    }

}