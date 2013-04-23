package fr.terranova.flv92.dinosaurus.common;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

/**
 * @author Flv92
 */
public class FirePlacedEvent {

    @ForgeSubscribe
    public void onBlockClicked(PlayerInteractEvent event) {
        if (event.action == Action.RIGHT_CLICK_BLOCK)
        {
            World w = DimensionManager.getWorld(0);
            if (w.getBlockId(event.x, event.y, event.z) == Block.sandStone.blockID)
            {
                Dinosaurus.terraNovaPortal.tryToCreatePortal(w, event.x, event.y + 1, event.z);
            }
        }
    }
}
