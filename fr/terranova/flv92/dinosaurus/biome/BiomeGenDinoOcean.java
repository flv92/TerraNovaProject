package fr.terranova.flv92.dinosaurus.biome;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenDinoOcean extends BiomeGenBase {

    public BiomeGenDinoOcean(int var1) {
        super(var1);
        this.minHeight = -1.5F;
        this.maxHeight = 0.5F;
        this.setBiomeName("Pre-Historic Oceans");
        this.waterColorMultiplier = 47513;
        this.setColor(112);
        this.topBlock = (byte) Block.grass.blockID;
        this.fillerBlock = (byte) Block.dirt.blockID;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.field_82914_M.clear();
        this.temperature = 2.0F;
        this.rainfall = 2.0F;
        this.setColor(39321);
    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float var1) {
        return 39321;
    }
}
