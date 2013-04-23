package fr.terranova.flv92.dinosaurus.common;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

/**
 * @author Flv92
 */
public class BiomeSizeHandler {

    @ForgeSubscribe
    public void onSizeAsked(WorldTypeEvent.BiomeSize event) {
        event.newSize = 5;
    }
}
