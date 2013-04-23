package fr.terranova.flv92.newBlocks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.terranova.flv92.newBlocks.common.newBlocks;
import fr.terranova.flv92.dinosaurus.common.WorldGenDinoTrees;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import static net.minecraftforge.common.ForgeDirection.*;

/**
 *
 * @author Florian
 */
public class BlockRopeLadder extends Block {

    /**
     * Basic block constructor
     *
     * @param par1 Id
     * @param par2 Texture id
     */
    public BlockRopeLadder(int par1, int par2) {
        super(par1, par2, Material.wood);
    }

    @Override
    public boolean isLadder(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving) {
        int rotation = MathHelper.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (rotation % 2 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
        } else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);

        }

    }

    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        if (par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) || par1World.getBlockId(par2, par3 + 1, par4) == this.blockID)
        {
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {

        if (!canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par5, 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {

        return canBlockStay(par1World, par2, par3, par4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int metadata = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        if (metadata == 0)
        {
            this.setBlockBounds(0.49F, 0.0F, 0.0F, 0.51F, 1.0F, 1.0F);
        } else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.49F, 1.0F, 1.0F, 0.51F);

        }
    }

    //<editor-fold defaultstate="collapsed" desc="Some render functions ...">
    @Override
    public int getRenderType() {
        return newBlocks.renderBlockRopeLadder;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (par5 == 0 || par5 == 1)
        {
            return false;
        }
        if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 0)
        {
            if (par5 == 2 || par5 == 3)
            {
                return false;
            }
        } else
        {
            if (par5 == 4 || par5 == 5)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    //</editor-fold>
}
