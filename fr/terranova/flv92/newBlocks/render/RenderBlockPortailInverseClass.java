package fr.terranova.flv92.newBlocks.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.terranova.flv92.newBlocks.common.newBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * Render BlockPortailInverse in the World.
 *
 * @author Florian
 *
 */
public class RenderBlockPortailInverseClass implements ISimpleBlockRenderingHandler
{

    /**
     *
     * @param par1Block The block which is going to be rendered
     * @param metadata The metadata of the Block
     * @param modelID The ID of the renderModel
     * @param renderer An instance of RenderBlocks, needed to render the block
     * in the world
     */
    @Override
    public void renderInventoryBlock(Block par1Block, int metadata, int modelID, RenderBlocks renderer) {
        Tessellator var4 = Tessellator.instance;
        renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        var4.startDrawingQuads();
        var4.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderBottomFace(par1Block, 0.0D, 0.0D, 0.0D, 116);
        var4.draw();
        var4.startDrawingQuads();
        var4.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderTopFace(par1Block, 0.0D, 0.0D, 0.0D, 116);
        var4.draw();
        var4.startDrawingQuads();
        var4.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderEastFace(par1Block, 0.0D, 0.0D, 0.0D, 116);
        var4.draw();
        var4.startDrawingQuads();
        var4.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderWestFace(par1Block, 0.0D, 0.0D, 0.0D, 116);
        var4.draw();
        var4.startDrawingQuads();
        var4.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderNorthFace(par1Block, 0.0D, 0.0D, 0.0D, 116);
        var4.draw();
        var4.startDrawingQuads();
        var4.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderSouthFace(par1Block, 0.0D, 0.0D, 0.0D, 116);
        var4.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);


        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }

    /**
     *
     * @param world An IBlockAccess instance, to have access to information and
     * more
     * @param x Position X of the block
     * @param y Position Y of the block
     * @param z Position Z of the block
     * @param block The block
     * @param modelId The ID of the renderModel
     * @param renderer An instance of RenderBlocks, needed to render the block
     * in the world
     * @return always true
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int metadata = world.getBlockMetadata(x, y, z);
        if (metadata == 0) {
            renderer.setRenderBounds(0.0D, 0.875D, 0.3125D, 1.0D, 1.0D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else if (metadata == 1) {
            renderer.setRenderBounds(0.0D, 0.75D, 0.3125D, 1.0D, 1.0D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else if (metadata == 2) {
            renderer.setRenderBounds(0.0D, 0.625D, 0.3125D, 1.0D, 1.0D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else if (metadata == 3) {
            renderer.setRenderBounds(0.0D, 0.5D, 0.3125D, 1.0D, 1.0D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else if (metadata == 4) {

            renderer.setRenderBounds(0.0D, 0.375D, 0.3125D, 1.0D, 1.0D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else if (metadata == 5) {

            renderer.setRenderBounds(0.0D, 0.25D, 0.3125D, 1.0D, 1.0D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else if (metadata == 6) {
            renderer.setRenderBounds(0.0D, 0.125D, 0.3125D, 1.0D, 0.9375D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);

        }
        else if (metadata == 7) {

            renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        else {
            renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            renderer.renderStandardBlock(block, x, y, z);
        }
        block.setBlockBoundsBasedOnState(world, x, y, z);
        return true;
    }

    /**
     * If this block needs to be render in 3D in the inventory
     *
     * @return
     */
    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    /**
     * The unique id of the render
     *
     * @return
     */
    @Override
    public int getRenderId() {
        return newBlocks.renderPortailColonieInverse;
    }
}