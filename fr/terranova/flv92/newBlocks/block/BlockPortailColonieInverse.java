package fr.terranova.flv92.newBlocks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.terranova.flv92.newBlocks.common.newBlocks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * The block representing the top portal of the Terra Nova colonie This block is
 * the block representing an "opened portal" It can go down then create a full
 * portal in order to close the colonie
 *
 * @author Florian
 */
public class BlockPortailColonieInverse extends Block {

    /**
     *
     * @param par1 The id of the Block
     * @param par2 The texture id of the block
     * @param par3Material The Material of the block
     */
    public BlockPortailColonieInverse(int par1, int par2, Material par3Material) {
        super(par1, par2, par3Material);
    }

    /**
     * Custom method Only called by "/portail close" Represents all of the Block
     * IA It allows the block to update itself and nearest Blocks to start
     * closing the portal
     *
     * @param par1World The World
     * @param par2 Position X of the Block
     * @param par3 Position Y of the Block
     * @param par4 Position Z of the Block
     */
    public void onCallByCommand(World par1World, int par2, int par3, int par4) {
        if (!par1World.isRemote)
        {
            for (int i = 0; i < 30; i++)
            {
                int metadata_r = par1World.getBlockMetadata(par2 + i, par3, par4);
                int id_r = par1World.getBlockId(par2 + i, par3, par4);
                int metadata_l = par1World.getBlockMetadata(par2 + i, par3, par4);
                int id_l = par1World.getBlockId(par2 + i, par3, par4);

                if (id_r == this.blockID && metadata_r == 0)
                {
                    par1World.scheduleBlockUpdate(par2 + i, par3, par4, this.blockID, 10);
                }
                if (id_l == this.blockID && metadata_l == 0)
                {
                    par1World.scheduleBlockUpdate(par2 - i, par3, par4, this.blockID, 10);
                }
            }
        }
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote)
        {
            int metadata = par1World.getBlockMetadata(par2, par3, par4);

            if ((metadata == 7) && (par1World.getBlockId(par2, par3 - 1, par4) == 0))
            {
                par1World.setBlockAndMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 0);
                par1World.scheduleBlockUpdate(par2, par3 - 1, par4, this.blockID, 10);
            }

            if (metadata < 8)
            {

                if (metadata != 7)
                {
                    par1World.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, metadata + 1);
                    par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 10);
                } else
                {
                    par1World.setBlockWithNotify(par2, par3, par4, newBlocks.portailColonie.blockID);
                    par1World.scheduleBlockUpdate(par2, par3 - 1, par4, this.blockID, 10);
                }

            }

        }
    }

    //<editor-fold defaultstate="collapsed" desc="Some render functions ...">
    @Override
    public int getRenderType() {
        return newBlocks.renderPortailColonieInverse;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     *
     * @param par1IBlockAccess An IBlockAccess instance
     * @param par2 (presuming) position X of the block
     * @param par3 (presuming) position Y of the block
     * @param par4 (presuming) position Z of the block
     * @param par5 (presuming) side number of the block
     * @return
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    //</editor-fold>
}