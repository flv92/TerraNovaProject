package fr.terranova.flv92.newBlocks.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.terranova.flv92.newBlocks.common.newBlocks;
import fr.terranova.flv92.newBlocks.render.RenderBlockPortailClass;
import fr.terranova.flv92.newBlocks.render.RenderBlockPortailInverseClass;
import fr.terranova.flv92.newBlocks.render.RenderBlockRopeLadder;
import fr.terranova.flv92.newBlocks.render.RenderBlockSpruceWall;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Forge Proxy, extending NewBlocksCommonProxy
 * Needed to register client side things
 * @author Florian
 */
public class NewBlocksClientProxy extends NewBlocksCommonProxy {

    /**
     * Register all "client-side" only things
     * ex: Blocks renderer, texture preloading, mob renders ...
     */
    @Override
    public void registerRenderThings() {
        newBlocks.log("The mod is loaded client-side");
        newBlocks.log("Starting registering client-side only renders and textures...");
        RenderingRegistry.registerBlockHandler(new RenderBlockPortailInverseClass());
        RenderingRegistry.registerBlockHandler(new RenderBlockPortailClass());
        RenderingRegistry.registerBlockHandler(new RenderBlockRopeLadder());
        RenderingRegistry.registerBlockHandler(new RenderBlockSpruceWall());
        MinecraftForgeClient.preloadTexture(newBlocks.texture2);
        newBlocks.log("4 renders and 1 texture successfully loaded!");
    }
}