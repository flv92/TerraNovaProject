package fr.terranova.flv92.dinosaurus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * @author Flv92
 */
public class BlockHugeThinTreeLog extends Block {

    public int blockType = 0;

    public BlockHugeThinTreeLog(int id, int bT) {
        super(id, Material.wood);
        this.blockType = bT;
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
        if (this.blockType == 0)
        {
            if (par1 == 0 || par1 == 1)
            {
                return 37;
            } else
            {
                return 8;
            }
        } else if (this.blockType == 1)
        {
            if (par1 == 2 || par1 == 3)
            {
                return 37;
            } else
            {
                return 8;
            }
        } else
        {
            if (par1 == 4 || par1 == 5)
            {
                return 37;
            } else
            {
                return 8;
            }
        }
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        byte var7 = 4;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

                        if (Block.blocksList[var12] != null)
                        {
                            Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z) {
        return true;
    }
}
