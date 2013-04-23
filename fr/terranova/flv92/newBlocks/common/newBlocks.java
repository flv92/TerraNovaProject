package fr.terranova.flv92.newBlocks.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.terranova.flv92.newBlocks.block.BlockCustomStairs;
import fr.terranova.flv92.newBlocks.block.BlockPortailColonie;
import fr.terranova.flv92.newBlocks.block.BlockPortailColonieInverse;
import fr.terranova.flv92.newBlocks.block.BlockRopeLadder;
import fr.terranova.flv92.newBlocks.block.BlockSpruceWall;
import fr.terranova.flv92.newBlocks.proxy.NewBlocksCommonProxy;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

/**
 * Main mod class
 *
 * @author Flv92
 */
@Mod(modid = "newBlocks", name = "Some new Blocks", version = "r1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class newBlocks {

    public static final String version = "r1.0";
    public static final String logHead = "[NewBlocks " + version + "] ";
    public static Logger requestLog = Logger.getLogger("newBlocks " + version);
    /**
     * The X position of the main block portal
     */
    public static int portailX = 0;
    /**
     * The Y position of the main block portal
     */
    public static int portailY = 0;
    /**
     * The Z position of the main block portal
     */
    public static int portailZ = 0;
    /**
     * A common Forge Proxy Client-side: Flv92ClientProxy
     * Server-side/Common-side: Flv92CommonProxy
     */
    @SidedProxy(clientSide = "fr.terranova.flv92.newBlocks.proxy.NewBlocksClientProxy", serverSide = "fr.terranova.flv92.newBlocks.proxy.NewBlocksCommonProxy")
    public static NewBlocksCommonProxy proxy;
    /**
     * A spruce wall
     */
    public static final Block woodSapinWall = new BlockSpruceWall(180, 116, Material.wood).setCreativeTab(CreativeTabs.tabBlock).setBlockName("woodWall").setHardness(2.0F);
    /**
     * A simple block, named goudron
     */
    public static final Block goudron = new Block(146, 0, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(CreativeTabs.tabBlock).setBlockName("goudron");
    /**
     * The block representing the closed/opening portal
     */
    public static final Block portailColonie = new BlockPortailColonie(148, 116, Material.wood).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(CreativeTabs.tabBlock).setBlockName("portailColonie");
    /**
     * The block representing the closing portal
     */
    public static final Block portailColonieInverse = new BlockPortailColonieInverse(149, 116, Material.wood).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(CreativeTabs.tabBlock).setBlockName("portailColonieInverse");
    /**
     * The rope ladder block
     */
    public static final Block ropeLadder = new BlockRopeLadder(150, 1).setCreativeTab(CreativeTabs.tabBlock).setBlockName("ropeLadder").setStepSound(Block.soundLadderFootstep).setRequiresSelfNotify();
    public static final Block woolStair1 = (new BlockCustomStairs(151, Block.cloth, 0)).setBlockName("stairWool1").setRequiresSelfNotify();
    public static final Block woolStair2 = (new BlockCustomStairs(152, Block.cloth, 1)).setBlockName("stairWool2").setRequiresSelfNotify();
    public static final Block woolStair3 = (new BlockCustomStairs(153, Block.cloth, 2)).setBlockName("stairWool3").setRequiresSelfNotify();
    public static final Block woolStair4 = (new BlockCustomStairs(154, Block.cloth, 3)).setBlockName("stairWool4").setRequiresSelfNotify();
    public static final Block woolStair5 = (new BlockCustomStairs(155, Block.cloth, 4)).setBlockName("stairWool5").setRequiresSelfNotify();
    public static final Block woolStair6 = (new BlockCustomStairs(156, Block.cloth, 5)).setBlockName("stairWool6").setRequiresSelfNotify();
    public static final Block woolStair7 = (new BlockCustomStairs(157, Block.cloth, 6)).setBlockName("stairWool7").setRequiresSelfNotify();
    public static final Block woolStair8 = (new BlockCustomStairs(158, Block.cloth, 7)).setBlockName("stairWool8").setRequiresSelfNotify();
    public static final Block woolStair9 = (new BlockCustomStairs(159, Block.cloth, 8)).setBlockName("stairWool9").setRequiresSelfNotify();
    public static final Block woolStair10 = (new BlockCustomStairs(160, Block.cloth, 9)).setBlockName("stairWool10").setRequiresSelfNotify();
    public static final Block woolStair11 = (new BlockCustomStairs(161, Block.cloth, 10)).setBlockName("stairWool11").setRequiresSelfNotify();
    public static final Block woolStair12 = (new BlockCustomStairs(162, Block.cloth, 11)).setBlockName("stairWool12").setRequiresSelfNotify();
    public static final Block woolStair13 = (new BlockCustomStairs(163, Block.cloth, 12)).setBlockName("stairWool13").setRequiresSelfNotify();
    public static final Block woolStair14 = (new BlockCustomStairs(164, Block.cloth, 13)).setBlockName("stairWool14").setRequiresSelfNotify();
    public static final Block woolStair15 = (new BlockCustomStairs(165, Block.cloth, 14)).setBlockName("stairWool15").setRequiresSelfNotify();
    public static final Block woolStair16 = (new BlockCustomStairs(166, Block.cloth, 15)).setBlockName("stairWool16").setRequiresSelfNotify();
    /**
     * A unique render id, used by portailColonie
     */
    public static final int renderPortailColonie = RenderingRegistry.getNextAvailableRenderId();
    /**
     * A unique render id, used by portailColonieInverse
     */
    public static final int renderPortailColonieInverse = RenderingRegistry.getNextAvailableRenderId();
    /**
     * A unique render id, used by BlockSpruceWall
     */
    public static final int renderBlockSpruceWall = RenderingRegistry.getNextAvailableRenderId();
    /**
     * A render id, used by ropeLadder
     */
    public static final int renderBlockRopeLadder = RenderingRegistry.getNextAvailableRenderId();
    /**
     * A path to the main texture file
     */
    public static String texture2 = "/terrain2.png";
    /**
     * A simple config
     */
    public static Configuration config;
    /**
     * An instance of LanguageRegistry
     */
    public static LanguageRegistry language = LanguageRegistry.instance();

    /**
     * Called before the mod initialization Used to create and read config files
     *
     * @param event The PreInitialization event
     */
    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent event) {
        newBlocks.requestLog.setParent(FMLLog.getLogger());
        log("Starting Pre-Initialization of NewBlocks " + version);
        config = new Configuration(event.getSuggestedConfigurationFile());
        log("Loading newBlocks.cfg config file");
        config.load();
        portailX = config.get("PortailPosition", "positionPortailX", 0).getInt();
        portailY = config.get("PortailPosition", "positionPortailY", 0).getInt();
        portailZ = config.get("PortailPosition", "positionPortailZ", 0).getInt();
        config.save();
    }

    /**
     * Called when the mod is initializing
     *
     * @param event The InitializationEvent
     */
    @Mod.Init
    public void load(FMLInitializationEvent event) {
        log("Starting intialization of NewBlocks v." + version);
        log("Adding French Translation");
        this.registerAllFr();
        log("Adding English Translation");
        this.registerAllEn();
        this.registerAllBlocks();

        proxy.registerRenderThings();
        goudron.setTextureFile(texture2);
        ropeLadder.setTextureFile(texture2);
        woolStair1.setLightOpacity(0);
        woolStair2.setLightOpacity(0);
        woolStair3.setLightOpacity(0);
        woolStair4.setLightOpacity(0);
        woolStair5.setLightOpacity(0);
        woolStair6.setLightOpacity(0);
        woolStair7.setLightOpacity(0);
        woolStair8.setLightOpacity(0);
        woolStair9.setLightOpacity(0);
        woolStair10.setLightOpacity(0);
        woolStair11.setLightOpacity(0);
        woolStair12.setLightOpacity(0);
        woolStair13.setLightOpacity(0);
        woolStair14.setLightOpacity(0);
        woolStair15.setLightOpacity(0);
        woolStair16.setLightOpacity(0);
    }

    public void addAllRecipes() {
        GameRegistry.addRecipe(new ItemStack(woodSapinWall, 6), new Object[]
                {
                    "XXX",
                    "XXX",
                    Character.valueOf('X'), new ItemStack(Block.wood, 1, 1)
                });
        log("Succesffully added 1 recipe!");
    }

    /**
     * Register all custom blocks using this.registerBlock(Block block)
     */
    public void registerAllBlocks() {
        this.registerBlock(woodSapinWall, "spruceWoodWall");
        this.registerBlock(goudron, "tar");
        this.registerBlock(portailColonie, "Portal");
        this.registerBlock(portailColonieInverse, "inversedPortal");
        this.registerBlock(ropeLadder, "ropeLadder");
        this.registerBlock(woolStair1, "woolStair1");
        this.registerBlock(woolStair2, "woolStair2");
        this.registerBlock(woolStair3, "woolStair3");
        this.registerBlock(woolStair4, "woolStair4");
        this.registerBlock(woolStair5, "woolStair5");
        this.registerBlock(woolStair6, "woolStair6");
        this.registerBlock(woolStair7, "woolStair7");
        this.registerBlock(woolStair8, "woolStair8");
        this.registerBlock(woolStair9, "woolStair9");
        this.registerBlock(woolStair10, "woolStair10");
        this.registerBlock(woolStair11, "woolStair11");
        this.registerBlock(woolStair12, "woolStair12");
        this.registerBlock(woolStair13, "woolStair13");
        this.registerBlock(woolStair14, "woolStair14");
        this.registerBlock(woolStair15, "woolStair15");
        this.registerBlock(woolStair16, "woolStair16");
    }

    public void registerBlock(Block block, String str) {
        log("Registering [" + language.getStringLocalization(block.getBlockName() + ".name", "en_US") + "] with id: [" + block.blockID + "]");
        GameRegistry.registerBlock(block, str);
    }

    /**
     * Call several times registerFr function for each object to translate
     */
    public void registerAllFr() {
        registerFr(woodSapinWall, "Mur en sapin");
        registerFr(goudron, "Goudron");
        registerFr(portailColonie, "Portail Colonie");
        registerFr(portailColonieInverse, "Portail Colonie Inverse");
        registerFr(ropeLadder, "Echelle de corde");
        registerFr(woolStair1, "Escalier en Laine Blanche");
        registerFr(woolStair2, "Escalier en Laine Orange");
        registerFr(woolStair3, "Escalier en Laine Magenta");
        registerFr(woolStair4, "Escalier en Laine Bleu Clair");
        registerFr(woolStair5, "Escalier en Laine Jaune");
        registerFr(woolStair6, "Escalier en Laine Vert Clair");
        registerFr(woolStair7, "Escalier en Laine Rose");
        registerFr(woolStair8, "Escalier en Laine Grise");
        registerFr(woolStair9, "Escalier en Laine Gris Clair");
        registerFr(woolStair10, "Escalier en Laine Cyan");
        registerFr(woolStair11, "Escalier en Laine Violette");
        registerFr(woolStair12, "Escalier en Laine Bleue");
        registerFr(woolStair13, "Escalier en Laine Marron");
        registerFr(woolStair14, "Escalier en Laine Verte");
        registerFr(woolStair15, "Escalier en Laine Rouge");
        registerFr(woolStair16, "Escalier en Laine Noire");

    }

    /**
     * Call several times registerEn function for each object to translate
     */
    public void registerAllEn() {
        registerEn(woodSapinWall, "Spruce Wall");
        registerEn(goudron, "Tar");
        registerEn(portailColonie, "Colony Portal");
        registerEn(portailColonieInverse, "Inversed Colony Portal");
        registerEn(ropeLadder, "Rope Ladder");
        registerEn(woolStair1, "White Wool Stair");
        registerEn(woolStair2, "Orange Wool Stair");
        registerEn(woolStair3, "Magenta Wool Stair");
        registerEn(woolStair4, "Light Blue Wool Stair");
        registerEn(woolStair5, "Yellow Wool Stair");
        registerEn(woolStair6, "Lime Wool Stair");
        registerEn(woolStair7, "Rose Wool Stair");
        registerEn(woolStair8, "Gray Wool Stair");
        registerEn(woolStair9, "Light Gray Wool Stair");
        registerEn(woolStair10, "Cyan Wool Stair");
        registerEn(woolStair11, "Purple Wool Stair");
        registerEn(woolStair12, "Blue Wool Stair");
        registerEn(woolStair13, "Brown Wool Stair");
        registerEn(woolStair14, "Green Wool Stair");
        registerEn(woolStair15, "Red Wool Stair");
        registerEn(woolStair16, "Black Wool Stair");
    }

    /**
     * Translate the given object to French (fr_FR) using name
     *
     * @param obj The object to translate
     * @param name The french name of this object
     */
    public void registerFr(Object obj, String name) {
        language.addNameForObject(obj, "fr_FR", name);
    }

    /**
     * Translate the given object to English (en_US) using name
     *
     * @param obj The object to translate
     * @param name The english name of this object
     */
    public void registerEn(Object obj, String name) {
        language.addNameForObject(obj, "en_US", name);
    }

    /**
     * Called when the server is starting Used to register custom commands
     *
     * @param event A ServerStartingEvent
     */
    @ServerStarting
    public void serverStarting(FMLServerStartingEvent event) {
        ServerCommandManager manager = (ServerCommandManager) event.getServer().getCommandManager();
        manager.registerCommand(new CommandPortail());
    }

    public static void log(Level lvl, String str) {
        requestLog.log(lvl, str);
    }

    public static void log(String str) {
        requestLog.log(Level.INFO, str);
    }
}