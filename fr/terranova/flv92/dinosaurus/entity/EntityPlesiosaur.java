package fr.terranova.flv92.dinosaurus.entity;

import fr.terranova.flv92.dinosaurus.common.Dinosaurus;
import fr.terranova.flv92.dinosaurus.common.IWaterDino;
import fr.terranova.flv92.dinosaurus.common.Sounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPlesiosaur extends EntityDinosaurce implements IWaterDino {

    public EntityPlesiosaur(World var1) {
        super(var1, Dinosaurus.plesiosaurAttackStrength, false);
        this.texture = "/dinosaurus/Plesiosaur_adult.png";
        this.setSize(7.0F, 5.0F);
        this.moveSpeed = Dinosaurus.plesiosaurMoveSpeed;
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they
     * walk on. used for spiders and wolves to prevent them from trampling crops
     */
    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean isOnSurface() {
        return this.worldObj.isAirBlock((int) Math.floor(this.posX), (int) Math.floor(this.posY + (double) (this.getEyeHeight() / 2.0F)), (int) Math.floor(this.posZ));
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this
     * creature will try to path to the block. Args: x, y, z
     */
    public float getBlockPathWeight(int var1, int var2, int var3) {
        return 0.5F - this.worldObj.getLightBrightness(var1, var2, var3);
    }

    public float getEyeHeight() {
        return this.height * 0.8F;
    }

    protected void getPathOrWalkableBlock(Entity var1, float var2) {
        PathEntity var3 = this.worldObj.getPathEntityToEntity(this, var1, 16.0F, true, false, true, false);
        this.setPathToEntity(var3);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this
     * entity.
     */
    public boolean getCanSpawnHere() {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public boolean CheckSpace() {
        if (!this.isInWater())
        {
            return !this.isEntityInsideOpaqueBlock();
        } else
        {
            for (int var1 = 0; var1 < 8; ++var1)
            {
                float var2 = ((float) ((var1 >> 0) % 2) - 0.5F) * this.width * 0.9F;
                float var3 = ((float) ((var1 >> 1) % 2) - 0.5F) * 0.1F;
                float var4 = ((float) ((var1 >> 2) % 2) - 0.5F) * this.width * 0.9F;
                int var5 = MathHelper.floor_double(this.posX + (double) var2);
                int var6 = MathHelper.floor_double(this.posY + (double) this.getEyeHeight() + (double) var3);
                int var7 = MathHelper.floor_double(this.posZ + (double) var4);
                Block var8 = Block.blocksList[this.worldObj.getBlockId(var1, var5, var6)];

                if (var8 != null && var8 != Block.waterStill && var8 != Block.waterMoving)
                {
                    return false;
                }
            }

            return true;
        }
    }

    public void FaceToCoord(int var1, int var2, int var3) {
        double var4 = (double) var1;
        double var6 = (double) var3;
        float var8 = (float) (Math.atan2(var6, var4) * 180.0D / Math.PI) - 90.0F;
        this.rotationYaw = this.updateRotation(this.rotationYaw, var8, 360.0F);
    }

    private float updateRotation(float var1, float var2, float var3) {
        float var4;

        for (var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F)
        {
            ;
        }

        while (var4 >= 180.0F)
        {
            var4 -= 360.0F;
        }

        if (var4 > var3)
        {
            var4 = var3;
        }

        if (var4 < -var3)
        {
            var4 = -var3;
        }

        return var1 + var4;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump() {
        if (this.isInWater() && this.isCollidedHorizontally && this.riddenByEntity == null)
        {
            super.jump();
        }
    }

    /**
     * Checks if this entity is inside water (if inWater field is true as a
     * result of handleWaterMovement() returning true)
     */
    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    public int getMaxHealth() {
        return 200;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.SOUND_PREFIX + "Pls_Living";
    }

    @Override
    protected String getHurtSound() {
        return Sounds.SOUND_PREFIX + "Pls_hurt";
    }

    @Override
    protected String getDeathSound() {
        return null;
    }
}
