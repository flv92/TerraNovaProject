/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.terranova.flv92.newBlocks.common;

import fr.terranova.flv92.newBlocks.block.BlockPortailColonie;
import fr.terranova.flv92.newBlocks.block.BlockPortailColonieInverse;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;


/**
 *
 * @author Florian
 */
class CommandPortail extends CommandBase implements ICommand {

    /**
     * Basic constructor
     */
    public CommandPortail() {
    }

    /**
     *
     * @return name of the command
     */
    @Override
    public String getCommandName() {
        return "portail";
    }

    /**
     * @param var1 ICommandSender, a player or the terminal
     * @param var2 An array of String, the command arguments
     */ 
    @Override
    public void processCommand(ICommandSender var1, String[] var2) {


        //Stop the process if there are less than 1 or more than 1 argument
        //Send to the command sender a way to use the command
        if (var2.length != 1) {
            var1.sendChatToPlayer(getCommandUsage(var1));
            return;
        }

        //If the given argument doesn't match with either "set", "open" or "close"
        //Stop the process and send to the command sender a way to use the command
        if (!"set".equals(var2[0]) && !"open".equals(var2[0]) && !"close".equals(var2[0])) {
            var1.sendChatToPlayer(getCommandUsage(var1));
            return;
        }

        //If the give argument match with "set"
        //Do the following actions
        if ("set".equals(var2[0])) {
            Minecraft mc = ModLoader.getMinecraftInstance();
            if (mc.objectMouseOver != null) {
                int id = mc.theWorld.getBlockId(mc.objectMouseOver.blockX, mc.objectMouseOver.blockY, mc.objectMouseOver.blockZ);
                if (id == 149) {
                    var1.sendChatToPlayer("Veuillez inscrire les informations suivantes dans le fichier de configuration:");
                    var1.sendChatToPlayer("PositionX: " + mc.objectMouseOver.blockX);
                    var1.sendChatToPlayer("PositionY: " + mc.objectMouseOver.blockY);
                    var1.sendChatToPlayer("PositionZ: " + mc.objectMouseOver.blockZ);
                } else {
                    var1.sendChatToPlayer("Veuillez pointer un bloc de portail!");
                }
            } else {
                var1.sendChatToPlayer("Veuillez pointer un bloc!");
            }
        }
        
        //If the give argument match with "open"
        //Do the following actions
        if ("open".equals(var2[0])) {
            Minecraft mc = ModLoader.getMinecraftInstance();
            int id = mc.theWorld.getBlockId(newBlocks.portailX, newBlocks.portailY, newBlocks.portailZ);
            if (id == 149) {
                ((BlockPortailColonie) Block.blocksList[id]).onCallByCommand(DimensionManager.getWorld(0), newBlocks.portailX, newBlocks.portailY, newBlocks.portailZ);
            } else {
                var1.sendChatToPlayer("Le bloc n'est pas un bloc de portail!");
            }
        }
        if ("close".equals(var2[0])) {
            Minecraft mc = ModLoader.getMinecraftInstance();
            int x = newBlocks.portailX;
            int y = newBlocks.portailY;
            int z = newBlocks.portailZ;

            int top;
            for (top = y; mc.theWorld.getBlockId(x, top, z) == 0; top++) {
            }
            top--;
            int left;
            for (left = x; mc.theWorld.getBlockId(left, top, z) == 0; left--) {
            }
            left++;
            for (int i = 0; mc.theWorld.getBlockId(left + i, top, z) == 0; i++) {
                //System.out.println((left+i) + " " + top + " " + z);
                World w = DimensionManager.getWorld(0);
                w.setBlockAndMetadataWithNotify(left + i, top, z, 150, 0);
                ((BlockPortailColonieInverse) Block.blocksList[150]).onCallByCommand(w, left, top, z);

            }
        }
    }

    /**
     * Get the way to use the command
     * @param par1ICommandSender ICommandSender, a player or the terminal
     * @return a string to use the command
     */
    @Override
    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "Usage: /" + getCommandName() + " <set|open|close>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender) {
        if ("tuturo92".equals(par1ICommandSender.getCommandSenderName()) || "TheAntoine".equals(par1ICommandSender.getCommandSenderName())) {
            return true;
        } else {
            return true;
        }
    }
}
