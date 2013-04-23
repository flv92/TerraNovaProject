package fr.terranova.flv92.dinosaurus.common;

import java.util.logging.Level;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class DinoSoundHandler {

    /**
     * Forge method called for sound registering. Called from preInit method in
     * main mod class. Called from the proxy if the mod is client-side
     *
     * @param event SoundLoadEvent, used to get the sound manager and add
     * sounds.
     */
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event) {
        // For each custom sound file we have defined in Sounds
        for (String soundFile : Sounds.soundFiles)
        {
            // Try to add the custom sound file to the pool of sounds
            try
            {
                event.manager.soundPoolSounds.addSound(soundFile, this.getClass().getResource("/" + soundFile));
                if(Dinosaurus.class.getResource("/" + soundFile) != null)
                {
                    Dinosaurus.log("Successfully loaded [" + Dinosaurus.class.getResource("/" + soundFile) + "] as [" + soundFile + "]");
                }
                else {
                    Dinosaurus.log("Unable to load [" + soundFile + "]");
                }
            } // If we cannot add the custom sound file to the pool, log the exception
            catch (Exception e)
            {
                Dinosaurus.log(Level.SEVERE, e.getMessage());
            }
        }
    }
}
