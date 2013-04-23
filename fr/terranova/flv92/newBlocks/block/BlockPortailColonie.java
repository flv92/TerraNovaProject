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
 * The block representing the base portal of the Terra Nova colonie This block
 * is the block representing a "closed portal" It can go up then disappear in
 * order to make the colonie open
 *
 * @author Florian
 */
public class BlockPortailColonie extends Block {

    /**
     * Simple constructor
     *
     * @param id id of the block
     * @param textureId texture id of the block
     * @param material Material of the block
     */
    public BlockPortailColonie(int id, int textureId, Material material) {
        super(id, textureId, material);
    }

    /**
     * Custom method Only called by "/portail open" Represents all of the Block
     * IA It allows the block to update itself and nearest Blocks to start
     * opening the portal
     *
     * @param world The World
     * @param x Position X of the Block
     * @param y Position Y of the Block
     * @param z Position Z of the Block
     */
    public void onCallByCommand(World world, int x, int y, int z) {
        if (!world.isRemote)
        {
            for (int i = 0; i < 30; i++)
            {
                int metadata_r = world.getBlockMetadata(x + i, y, z);
                int id_r = world.getBlockId(x + i, y, z);
                int metadata_l = world.getBlockMetadata(x + i, y, z);
                int id_l = world.getBlockId(x + i, y, z);
                if (id_r == this.blockID && metadata_r == 0)
                {
                    world.scheduleBlockUpdate(x + i, y, z, this.blockID, 10);
                }
                if (id_l == this.blockID && metadata_l == 0)
                {
                    world.scheduleBlockUpdate(x - i, y, z, this.blockID, 10);
                }
            }
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {

        if (!world.isRemote)
        {
            int metadata = world.getBlockMetadata(x, y, z);

            if ((world.getBlockId(x, y, z) == 0) && (world.getBlockId(x, y + 1, z) == this.blockID))
            {
                world.setBlockAndMetadataWithNotify(x, y + 1, z, this.blockID, 1);
                world.scheduleBlockUpdate(x, y + 1, z, this.blockID, 10);
            }

            if (metadata < 8)
            {

                if (metadata != 7)
                {
                    world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, metadata + 1);
                    world.scheduleBlockUpdate(x, y, z, this.blockID, 10);
                } else
                {
                    world.setBlockWithNotify(x, y, z, 0);
                    world.scheduleBlockUpdate(x, y + 1, z, this.blockID, 10);
                }
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Some render functions ...">
    @Override
    public int getRenderType() {
        return newBlocks.renderPortailColonie;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return 116;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     *
     * @param iBlockAccess An IBlockAccess instance
     * @param x (presuming) position X of the block
     * @param y (presuming) position Y of the block
     * @param z (presuming) position Z of the block
     * @param side (presuming) side number of the block
     * @return
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
        return true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    //</editor-fold>
}