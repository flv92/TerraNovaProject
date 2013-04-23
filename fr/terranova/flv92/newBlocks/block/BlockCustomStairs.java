package fr.terranova.flv92.newBlocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * Only use is to extend BlockStairs and have access to a public constructor in order to make an instance of BlockStairs
 * @author Flv92
 */
public class BlockCustomStairs extends BlockStairs
{

    public BlockCustomStairs(int par1, Block par2Block, int par3) {
        super(par1,par2Block,par3);
    }
}
