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

/**
 * @author Flv92
 */
public class EntityRaptor extends EntityDinosaurce {

    public EntityRaptor(World var1) {
        super(var1, Dinosaurus.raptorAttackStrength, true);
        this.texture = "/dinosaurus/Raptor_Adult.png";
        setSize(2.0F, 2.0F);
        this.moveSpeed = Dinosaurus.raptorMoveSpeed;
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 40.0F, 0, true));
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.SOUND_PREFIX + "raptor_living_wild";
    }

    @Override
    protected String getHurtSound() {
        return Sounds.SOUND_PREFIX + "Raptor_hurt";
    }

    @Override
    protected String getDeathSound() {
        return Sounds.SOUND_PREFIX + "raptor_death";
    }

    @Override
    public int getMaxHealth() {
        return 70;
    }

    @Override
    public float getSpeedModifier() {
        return this.getAttackTarget() != null ? 1.5F : 1.0F;
    }
}
