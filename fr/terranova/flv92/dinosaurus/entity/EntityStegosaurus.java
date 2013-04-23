package fr.terranova.flv92.dinosaurus.entity;

import fr.terranova.flv92.dinosaurus.common.Dinosaurus;
import fr.terranova.flv92.dinosaurus.common.Sounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityStegosaurus extends EntityDinosaurce {

    public EntityStegosaurus(World var1) {
        super(var1, Dinosaurus.stegosaurAttackStrength, false);
        this.texture = "/dinosaurus/Stegosaurus_Adult.png";
        setSize(7.0F, 4.0F);
        this.moveSpeed = Dinosaurus.stegosaurMoveSpeed;
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    protected String getLivingSound() {
        return this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null ? Sounds.SOUND_PREFIX + "Steg_living" : null;
    }

    protected String getHurtSound() {
        this.worldObj.setBlockWithNotify((int) this.posX, (int) this.posY, (int) this.posZ, Block.blockDiamond.blockID);
        this.worldObj.setBlockWithNotify((int) this.posX, (int) this.posY + 1, (int) this.posZ, Block.blockDiamond.blockID);
        this.worldObj.setBlockWithNotify((int) this.posX, (int) this.posY + 2, (int) this.posZ, Block.blockDiamond.blockID);


        return Sounds.SOUND_PREFIX + "Steg_Hurt";
    }

    protected String getDeathSound() {
        return Sounds.SOUND_PREFIX + "Steg_death";
    }

    /*@Override
    public int getBlockPathWeight(int par1, int par2, int par3) {
        int blockPathWeight = 0;
        int blockHighMedium = this.worldObj.getTopSolidOrLiquidBlock(par1, par3);
        for (int i = par1 - 5; i < par1 + 5; i++)
        {
            for (int j = par3 - 5; j < par3 + 5; j++)
            {
                if (this.worldObj.getTopSolidOrLiquidBlock(i, j) < blockHighMedium)
                {
                    blockPathWeight++;
                }
            }
        }
        if(blockPathWeigth < 10)
        System.out.println(par1 + " " + par2 + " " + par3);
        System.out.println(blockPathWeight);
        return blockPathWeight;
    }*/

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