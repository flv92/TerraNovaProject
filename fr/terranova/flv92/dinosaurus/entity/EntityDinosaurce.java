package fr.terranova.flv92.dinosaurus.entity;

import fr.terranova.flv92.dinosaurus.common.Dinosaurus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 *
 * @author Florian
 */
public abstract class EntityDinosaurce extends EntityCreature {

    /**
     * The strenght of the dinosaur attack
     */
    public int attackStrength = 0;
    public boolean isAngry = true;

    public EntityDinosaurce(World var1, int a, boolean an) {
        super(var1);
        attackStrength = a;
        isAngry = an;
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean attackEntityAsMob(Entity var1) {
        return false;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource var1, int var2) {
        Entity var3 = var1.getEntity();

        if ((var3 != null) && (!(var3 instanceof EntityPlayer)) && (!(var3 instanceof EntityArrow)))
        {
            var2 = (var2 + 1) / 2;
        }

        if (!super.attackEntityFrom(var1, var2) || (var3 instanceof EntityArrow))
        {
            return false;
        }

        if ((var3 != this) && (var3 != null))
        {

            this.entityToAttack = var3;
        }

        return true;
    }

    @Override
    protected Entity findPlayerToAttack() {
        if (this.isAngry)
        {
            return this.worldObj.getClosestPlayerToEntity(this, 40.0D);
        }
        return null;

    }

    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    protected void collideWithEntity(Entity par1Entity) {
    }

    @Override
    public void onUpdate() {
        if (this.isAngry)
        {
            EntityPlayer p = this.worldObj.getClosestPlayerToEntity(this, this.width);
            if (p != null)
            {
                p.attackEntityFrom(DamageSource.causeMobDamage(this), this.attackStrength);
            }
        }
        super.onUpdate();

    }

    @Override
    protected void damageEntity(DamageSource par1DamageSource, int par2) {
        super.damageEntity(par1DamageSource, par2);
        if (!this.isAngry)
        {
            this.isAngry = true;
        }
        Entity p = par1DamageSource.getEntity();
        if (p != null && p instanceof EntityPlayer)
        {
            this.setAttackTarget((EntityPlayer) p);
        }
    }

    @Override
    protected void dropFewItems(boolean bool, int lootLevel) {
        for (int i = 0; i < Dinosaurus.dinoSteakLooted; i++)
        {
            this.dropItem(Dinosaurus.dinoSteak.itemID, 1);
        }
        for (int i = 0; i < Dinosaurus.dinoBoneLooted; i++)
        {
            this.dropItem(Dinosaurus.dinoBone.itemID, 1);
        }
        int randVar = this.rand.nextInt(10) + 1;
        switch (randVar)
        {
            case 8:
                if (this instanceof EntityTRex)
                {
                    this.dropItem(Dinosaurus.dinoSkull.itemID, 1);
                }
                break;
            case 9:
                this.dropItem(Dinosaurus.dinoClaw.itemID, 1);
                break;
            case 10:
                this.dropItem(Dinosaurus.dinoTibia.itemID, 1);
                break;
        }
    }
}