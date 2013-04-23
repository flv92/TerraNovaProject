package fr.terranova.flv92.dinosaurus.common;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * @author Flv92
 */
public class TerraNovaWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Terra Nova";
    }

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 1.0F, 0.0F);
        this.dimensionId = 2; // This is the main line I'm showing. You can set up everything else how ever you want.
    }
    
    
}
