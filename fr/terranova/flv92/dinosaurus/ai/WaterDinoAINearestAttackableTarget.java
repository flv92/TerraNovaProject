package fr.terranova.flv92.dinosaurus.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class WaterDinoAINearestAttackableTarget extends EntityAINearestAttackableTarget
{
    public WaterDinoAINearestAttackableTarget(EntityLiving var1, Class var2, float var3, int var4, boolean var5)
    {
        super(var1, var2, var3, var4, var5);
    }

    /**
     * A method used to see if an entity is a suitable target through a number of checks.
     * @param var1
     * @param var2
     * @return  
     */
    @Override
    protected boolean isSuitableTarget(EntityLiving var1, boolean var2)
    {
        return var1 != null && !var1.isInWater() ? false : super.isSuitableTarget(var1, var2);
    }
}
