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

public class EntityTriceratops extends EntityDinosaurce {

    public EntityTriceratops(World var1) {
        super(var1, Dinosaurus.triceratopsAttackStrength, false);
        this.moveSpeed = Dinosaurus.triceratopsMoveSpeed;
        setSize(2.25F, 2.25F);
        this.texture = "/dinosaurus/Triceratops_Adult_2.png";
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(8, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
    }

    protected String getLivingSound() {
        return this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null ? Sounds.SOUND_PREFIX + "tri_roar" : null;
    }

    protected String getHurtSound() {
        return "mob.cow.hurt";
    }

    protected String getDeathSound() {
        return Sounds.SOUND_PREFIX + "tri_death";
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

    public int getMaxHealth() {
        return 80;
    }
}