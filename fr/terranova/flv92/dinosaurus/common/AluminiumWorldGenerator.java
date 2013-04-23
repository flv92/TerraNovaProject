package fr.terranova.flv92.dinosaurus.common;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class AluminiumWorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId)
        {
            case -1:
                generateNether();
                break;
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd();
                break;
        }
    }

    public void generateNether() {
//we're not doing ore ore in the nether
    }

    public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int i = 0; i < 30; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(Dinosaurus.highestAluminiumOreLevel);
            int randPosZ = chunkZ + rand.nextInt(16);

            (new WorldGenMinable(Dinosaurus.aluminiumOre.blockID, 10)).generate(world, rand, randPosX, randPosY, randPosZ);
        }

        BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if ("Dino - Plains".equals(b.biomeName))
        {
            int treesPerChunk = 10;
            if (rand.nextInt(10) == 0)
            {
                ++treesPerChunk;
            }

            int var3, var4;
            for (int var2 = 0; var2 < treesPerChunk; ++var2)
            {
                var3 = chunkX + rand.nextInt(16) + 8;
                var4 = chunkZ + rand.nextInt(16) + 8;
                if("Dino - Plains".equals(world.getBiomeGenForCoords(var3, var4).biomeName))
                {
                    (new WorldGenDinoTrees()).generate(world, rand, var3, world.getHeightValue(var3, var4), var4);
                }
            }
        }
    }

    public void generateEnd() {
//we're not going to generate in the end either
    }
}