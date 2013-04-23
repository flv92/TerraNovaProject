package fr.terranova.flv92.newBlocks.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.terranova.flv92.newBlocks.common.newBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

/**
 * @author Flv92
 */
public class RenderBlockRopeLadder implements ISimpleBlockRenderingHandler {

    public RenderBlockRopeLadder() {
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int par2, int par3, int par4, Block par1Block, int modelId, RenderBlocks renderer) {
        /*int metadata = world.getBlockMetadata(x, y, z);
         if (metadata == 0) {
         renderer.setRenderMinMax(0.49D, 0.0D, 0.0D, 0.51D, 1.0D, 1.0D);
         renderer.renderStandardBlock(block, x, y, z);
         } else {
         renderer.setRenderMinMax(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         renderer.renderStandardBlock(block, x, y, z);
         }
         return true;*/
        Tessellator var5 = Tessellator.instance;
        int var6 = par1Block.getBlockTextureFromSide(0);

        if (renderer.overrideBlockTexture >= 0) {
            var6 = renderer.overrideBlockTexture;
        }

        var5.setBrightness(par1Block.getMixedBrightnessForBlock(renderer.blockAccess, par2, par3, par4));
        float var7 = 1.0F;
        var5.setColorOpaque_F(var7, var7, var7);
        int var22 = (var6 & 15) << 4;
        int var8 = var6 & 240;
        double var9 = (double) ((float) var22 / 256.0F);
        double var11 = (double) (((float) var22 + 15.99F) / 256.0F);
        double var13 = (double) ((float) var8 / 256.0F);
        double var15 = (double) (((float) var8 + 15.99F) / 256.0F);
        int var17 = renderer.blockAccess.getBlockMetadata(par2, par3, par4);
        double var18 = 0.0D;
        double var20 = 0.49D;
        
        if (var17 == 1) {
            var5.addVertexWithUV((double)(par2 + 1) + var18, (double)(par3 + 0) - var18, (double)par4 + var20, var11, var15);
            var5.addVertexWithUV((double)(par2 + 1) + var18, (double)(par3 + 1) + var18, (double)par4 + var20, var11, var13);
            var5.addVertexWithUV((double)(par2 + 0) - var18, (double)(par3 + 1) + var18, (double)par4 + var20, var9, var13);
            var5.addVertexWithUV((double)(par2 + 0) - var18, (double)(par3 + 0) - var18, (double)par4 + var20, var9, var15);
        }
        if (var17 == 0) {
            var5.addVertexWithUV((double)par2 + 0.49D, (double)(par3 + 1) + var18, (double)(par4 + 1) + var18, var9, var13);
            var5.addVertexWithUV((double)par2 + 0.49D, (double)(par3 + 0) - var18, (double)(par4 + 1) + var18, var9, var15);
            var5.addVertexWithUV((double)par2 + 0.49D, (double)(par3 + 0) - var18, (double)(par4 + 0) - var18, var11, var15);
            var5.addVertexWithUV((double)par2 + 0.49D, (double)(par3 + 1) + var18, (double)(par4 + 0) - var18, var11, var13);
        }


        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public int getRenderId() {
        return newBlocks.renderBlockRopeLadder;
    }
}
