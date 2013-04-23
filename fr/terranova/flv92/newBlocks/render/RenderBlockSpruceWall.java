package fr.terranova.flv92.newBlocks.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.terranova.flv92.newBlocks.block.BlockSpruceWall;
import fr.terranova.flv92.newBlocks.common.newBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * @author Flv92
 */
public class RenderBlockSpruceWall implements ISimpleBlockRenderingHandler {

    public RenderBlockSpruceWall() {
    }

    @Override
    public void renderInventoryBlock(Block par1Block, int par2, int modelID, RenderBlocks renderer) {
        Tessellator var4 = Tessellator.instance;
        for (int var14 = 0; var14 < 2; ++var14)
        {
            if (var14 == 0)
            {
                renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            }

            if (var14 == 1)
            {
                renderer.setRenderBounds(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
            }

            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var4.startDrawingQuads();
            var4.setNormal(0.0F, -1.0F, 0.0F);
            renderer.renderBottomFace(par1Block, 0.0D, 0.0D, 0.0D, par1Block.getBlockTextureFromSideAndMetadata(0, par2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(0.0F, 1.0F, 0.0F);
            renderer.renderTopFace(par1Block, 0.0D, 0.0D, 0.0D, par1Block.getBlockTextureFromSideAndMetadata(1, par2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(0.0F, 0.0F, -1.0F);
            renderer.renderEastFace(par1Block, 0.0D, 0.0D, 0.0D, par1Block.getBlockTextureFromSideAndMetadata(2, par2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(0.0F, 0.0F, 1.0F);
            renderer.renderWestFace(par1Block, 0.0D, 0.0D, 0.0D, par1Block.getBlockTextureFromSideAndMetadata(3, par2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(-1.0F, 0.0F, 0.0F);
            renderer.renderNorthFace(par1Block, 0.0D, 0.0D, 0.0D, par1Block.getBlockTextureFromSideAndMetadata(4, par2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(1.0F, 0.0F, 0.0F);
            renderer.renderSouthFace(par1Block, 0.0D, 0.0D, 0.0D, par1Block.getBlockTextureFromSideAndMetadata(5, par2));
            var4.draw();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }

        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int par2, int par3, int par4, Block block, int modelId, RenderBlocks renderer) {
        BlockSpruceWall par1BlockWall = (BlockSpruceWall) block;
        boolean var5 = par1BlockWall.canConnectWallTo(blockAccess, par2 - 1, par3, par4);
        boolean var6 = par1BlockWall.canConnectWallTo(blockAccess, par2 + 1, par3, par4);
        boolean var7 = par1BlockWall.canConnectWallTo(blockAccess, par2, par3, par4 - 1);
        boolean var8 = par1BlockWall.canConnectWallTo(blockAccess, par2, par3, par4 + 1);
        boolean var9 = var7 && var8 && !var5 && !var6;
        boolean var10 = !var7 && !var8 && var5 && var6;
        boolean var11 = blockAccess.isAirBlock(par2, par3 + 1, par4);

        if ((var9 || var10) && var11)
        {
            if (var9)
            {
                renderer.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
                renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);
            } else
            {
                renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);
            }
        } else
        {
            renderer.setRenderBounds(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
            renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);

            if (var5)
            {
                renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
                renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);
            }

            if (var6)
            {
                renderer.setRenderBounds(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);
            }

            if (var7)
            {
                renderer.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
                renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);
            }

            if (var8)
            {
                renderer.setRenderBounds(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
                renderer.renderStandardBlock(par1BlockWall, par2, par3, par4);
            }
        }

        par1BlockWall.setBlockBoundsBasedOnState(blockAccess, par2, par3, par4);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return newBlocks.renderBlockSpruceWall;
    }
}
