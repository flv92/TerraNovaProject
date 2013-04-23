package fr.terranova.flv92.dinosaurus.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.terranova.flv92.dinosaurus.common.BiomeSizeHandler;
import fr.terranova.flv92.dinosaurus.common.DinoSoundHandler;
import fr.terranova.flv92.dinosaurus.common.Dinosaurus;
import fr.terranova.flv92.dinosaurus.entity.EntityBrachiosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityHadrosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityPlesiosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityRaptor;
import fr.terranova.flv92.dinosaurus.entity.EntityStegosaurus;
import fr.terranova.flv92.dinosaurus.entity.EntityTRex;
import fr.terranova.flv92.dinosaurus.entity.EntityTriceratops;
import fr.terranova.flv92.dinosaurus.model.ModelHadrosaur;
import fr.terranova.flv92.dinosaurus.model.ModelRaptor;
import fr.terranova.flv92.dinosaurus.model.ModelStegosaurus;
import fr.terranova.flv92.dinosaurus.model.ModelTRex;
import fr.terranova.flv92.dinosaurus.model.ModelTriceratops;
import fr.terranova.flv92.dinosaurus.render.RenderBrachiosaur;
import fr.terranova.flv92.dinosaurus.render.RenderHadrosaur;
import fr.terranova.flv92.dinosaurus.render.RenderPlesiosaur;
import fr.terranova.flv92.dinosaurus.render.RenderRaptor;
import fr.terranova.flv92.dinosaurus.render.RenderStegosaurus;
import fr.terranova.flv92.dinosaurus.render.RenderTRex;
import fr.terranova.flv92.dinosaurus.render.RenderTriceratops;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author Flv92
 */
public class DinoClientProxy extends DinoCommonProxy {

    /**
     * Custom method used to make renders, client-side only.
     *
     * @author Flv92
     */
    @Override
    public void registerRenderThings() {
        Dinosaurus.log("The mod is loaded client-side");
        Dinosaurus.log("Starting rendering registry of some Dinosaurs");
        RenderingRegistry.registerEntityRenderingHandler(EntityHadrosaur.class, new RenderHadrosaur(new ModelHadrosaur(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBrachiosaur.class, new RenderBrachiosaur(0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, new RenderStegosaurus(new ModelStegosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderTriceratops(new ModelTriceratops(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRaptor.class, new RenderRaptor(new ModelRaptor(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTRex.class, new RenderTRex(new ModelTRex(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaur.class, new RenderPlesiosaur(0.5F));
        MinecraftForgeClient.preloadTexture(Dinosaurus.textureFile);
        Dinosaurus.dinoBone.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.dinoClaw.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.dinoSkull.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.dinoSteak.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.dinoTibia.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.aluminiumIngot.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.aluminiumOre.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.blockHugeThinTreeLog1.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.blockHugeThinTreeLog2.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.blockHugeThinTreeLog3.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.blockHugeThinTreeLeaves.setTextureFile(Dinosaurus.textureFile);
        Dinosaurus.log("Successfully registered 7 dinosaurs and 1 texture");
    }

    @Override
    public void registerSound() {
        MinecraftForge.EVENT_BUS.register(new DinoSoundHandler());
    }
}
