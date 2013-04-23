package fr.terranova.flv92.dinosaurus.biome;

import fr.terranova.flv92.dinosaurus.entity.EntityRaptor;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenDinoPlains extends BiomeGenBase {

    public static int topBlockID = Block.grass.blockID;
    public static int fillerBlockID = Block.dirt.blockID;
    public static int skyColor = 6737049;

    public BiomeGenDinoPlains(int var1) {
        super(var1);
        this.minHeight = 0.0F;
        this.maxHeight = 0.0F;
        this.setBiomeName("Dino - Plains");
        this.waterColorMultiplier = 39219;
        this.setColor(16421912);
        this.field_82914_M.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.temperature = 2.0F;
        this.rainfall = 2.0F;
        this.topBlock = (byte) topBlockID;
        this.fillerBlock = (byte) fillerBlockID;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 15;

    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float var1) {
        return skyColor;
    }
}
