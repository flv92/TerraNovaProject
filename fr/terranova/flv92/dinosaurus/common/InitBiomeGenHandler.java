package fr.terranova.flv92.dinosaurus.common;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerSwampRivers;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

/**
 * @author Flv92
 */
public class InitBiomeGenHandler {

    @ForgeSubscribe
    public void setNewGenLayer(WorldTypeEvent.InitBiomeGens event) {
       /*GenLayerIsland var3 = new GenLayerIsland(1L);
        GenLayerFuzzyZoom var9 = new GenLayerFuzzyZoom(2000L, var3);
        GenLayerAddIsland var10 = new GenLayerAddIsland(1L, var9);
        GenLayerZoom var11 = new GenLayerZoom(2001L, var10);
        var10 = new GenLayerAddIsland(2L, var11);
        //GenLayerAddSnow var12 = new GenLayerAddSnow(2L, var10);
        var11 = new GenLayerZoom(2002L, var10);
        var10 = new GenLayerAddIsland(3L, var11);
        var11 = new GenLayerZoom(2003L, var10);
        var10 = new GenLayerAddIsland(4L, var11);
        GenLayerAddMushroomIsland var16 = new GenLayerAddMushroomIsland(5L, var10);
        byte var4 = 3;

        if (event.worldType == WorldType.LARGE_BIOMES)
        {
            var4 = 6;
        }
        GenLayer var5 = GenLayerZoom.func_75915_a(1000L, var16, 0);
        //GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var5);
        var5 = GenLayerZoom.func_75915_a(1000L, var5, var4 + 2);
        //GenLayerRiver var14 = new GenLayerRiver(1L, var5);
        GenLayerSmooth var15 = new GenLayerSmooth(1000L, var5);
        GenLayer var6 = GenLayerZoom.func_75915_a(1000L, var16, 0);
        GenLayerBiome var17 = new GenLayerBiome(200L, var6, event.worldType);
        var6 = GenLayerZoom.func_75915_a(1000L, var17, 2);
        Object var18 = new GenLayerHills(1000L, var6);

        for (int var7 = 0; var7 < var4; ++var7)
        {
            var18 = new GenLayerZoom((long) (1000 + var7), (GenLayer) var18);

            if (var7 == 0)
            {
                var18 = new GenLayerAddIsland(3L, (GenLayer) var18);
            }

            if (var7 == 1)
            {
                var18 = new GenLayerShore(1000L, (GenLayer) var18);
            }

            if (var7 == 1)
            {
                var18 = new GenLayerSwampRivers(1000L, (GenLayer) var18);
            }
        }

        GenLayerSmooth var19 = new GenLayerSmooth(1000L, (GenLayer) var18);
        GenLayerRiverMix var20 = new GenLayerRiverMix(100L, var19, var15);
        GenLayerVoronoiZoom var8 = new GenLayerVoronoiZoom(10L, var20);
        var20.initWorldGenSeed(event.seed);
        var8.initWorldGenSeed(event.seed);
        event.newBiomeGens = new GenLayer[]
        {
            var20, var8, var20
        };*/
    }
}
