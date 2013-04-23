package fr.terranova.flv92.dinosaurus.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.terranova.flv92.dinosaurus.biome.BiomeGenDinoHighlands;
import fr.terranova.flv92.dinosaurus.biome.BiomeGenDinoPlains;
import fr.terranova.flv92.dinosaurus.block.BlockBigTreeLeave;
import fr.terranova.flv92.dinosaurus.block.BlockHugeThinTreeLog;
import fr.terranova.flv92.dinosaurus.entity.EntityBrachiosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityHadrosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityPlesiosaur;
import fr.terranova.flv92.dinosaurus.entity.EntityRaptor;
import fr.terranova.flv92.dinosaurus.entity.EntityStegosaurus;
import fr.terranova.flv92.dinosaurus.entity.EntityTRex;
import fr.terranova.flv92.dinosaurus.entity.EntityTriceratops;
import fr.terranova.flv92.dinosaurus.items.ItemTest;
import fr.terranova.flv92.dinosaurus.proxy.DinoCommonProxy;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "DinosaurusMod", name = "The Dinosaurus Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Dinosaurus {

    public static final String version = "1.0";
    public static Logger myLog = Logger.getLogger("Dinosaurus v" + version);
    public static final String textureFile = "/dinosaurus/items.png";
    /**
     * An instance of LanguageRegistry. Used to register custom names
     */
    LanguageRegistry language = LanguageRegistry.instance();
    /**
     * A simple SidedProxy.
     * fr.terranova.flv92.dinosaurus.DinoClientProxy client-side
     * fr.terranova.flv92.dinosaurus.DinoCommonProxy server-side
     */
    @SidedProxy(clientSide = "fr.terranova.flv92.dinosaurus.proxy.DinoClientProxy", serverSide = "fr.terranova.flv92.dinosaurus.proxy.DinoCommonProxy")
    public static DinoCommonProxy proxy;
    public static Configuration config;
    //<editor-fold defaultstate="collapsed" desc="Variables de configuration">
    ////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////DinoConfig/////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //-------> Eggs color:
    /**/ public static int brachiosaurEggColor1 = 0;
    /**/ public static int brachiosaurEggColor2 = 0;
    /**/ public static int hadrosaurEggColor1 = 0;
    /**/ public static int hadrosaurEggColor2 = 0;
    /**/ public static int plesiosaurEggColor1 = 0;
    /**/ public static int plesiosaurEggColor2 = 0;
    /**/ public static int raptorEggColor1 = 0;
    /**/ public static int raptorEggColor2 = 0;
    /**/ public static int stegosaurEggColor1 = 0;
    /**/ public static int stegosaurEggColor2 = 0;
    /**/ public static int trexEggColor1 = 0;
    /**/ public static int trexEggColor2 = 0;
    /**/ public static int triceratopsEggColor1 = 0;
    /**/ public static int triceratopsEggColor2 = 0;
    //--------> Attack Strength:
    /**/ public static int brachiosaurAttackStrength = 0;
    /**/ public static int hadrosaurAttackStrength = 0;
    /**/ public static int plesiosaurAttackStrength = 0;
    /**/ public static int raptorAttackStrength = 0;
    /**/ public static int stegosaurAttackStrength = 0;
    /**/ public static int trexAttackStrength = 0;
    /**/ public static int triceratopsAttackStrength = 0;
    //--------> Move Speed:
    /**/ public static float brachiosaurMoveSpeed = 0;
    /**/ public static float hadrosaurMoveSpeed = 0;
    /**/ public static float plesiosaurMoveSpeed = 0;
    /**/ public static float raptorMoveSpeed = 0;
    /**/ public static float stegosaurMoveSpeed = 0;
    /**/ public static float trexMoveSpeed = 0;
    /**/ public static float triceratopsMoveSpeed = 0;
    //-------> Drop count:
    /**/ public static int dinoSteakLooted = 0;
    /**/ public static int dinoBoneLooted = 0;
    //-------> Ore generation:
    /**/ public static int highestAluminiumOreLevel = 40;
    ////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////End of DinoConfig//////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //</editor-fold>
    public static final CreativeTabs customTab = new DinoCreativeTab();
    public static final Item dinoTibia = new Item(148).setItemName("dinoTibia").setIconIndex(2).setCreativeTab(customTab);
    public static final Item dinoClaw = new Item(149).setItemName("dinoClaw").setIconIndex(3).setCreativeTab(customTab);
    public static final Item dinoSkull = new Item(150).setItemName("dinoSkull").setIconIndex(4).setCreativeTab(customTab);
    public static final Item dinoSteak = new Item(151).setItemName("dinoSteak").setIconIndex(5).setCreativeTab(customTab);
    public static final Item dinoBone = new Item(152).setItemName("dinoBone").setIconIndex(6).setCreativeTab(customTab);
    public static final Item aluminiumIngot = new Item(153).setItemName("aluminiumIngot").setIconIndex(0).setCreativeTab(customTab);
    public static final Item itemTest = new ItemTest(154).setItemName("itemTest").setIconIndex(Item.appleGold.getIconIndex(new ItemStack(Item.appleGold))).setCreativeTab(customTab);
    public static final Block aluminiumOre = new Block(167, 1, Material.rock).setBlockName("aluminumOre").setResistance(3.0F).setHardness(5.0F).setCreativeTab(customTab);
    public static final Block blockHugeThinTreeLog1 = new BlockHugeThinTreeLog(168, 0).setBlockName("blockLog").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(customTab);
    public static final Block blockHugeThinTreeLog2 = new BlockHugeThinTreeLog(169, 1).setBlockName("blockLog").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(customTab);
    public static final Block blockHugeThinTreeLog3 = new BlockHugeThinTreeLog(170, 2).setBlockName("blockLog").setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(customTab);
    public static final BlockLeaves blockHugeThinTreeLeaves = (BlockLeaves) (new BlockBigTreeLeave(171, 21)).setCreativeTab(customTab).setBlockName("blockLeaves").setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify();
    public static final BlockTerraNovaPortal terraNovaPortal = (BlockTerraNovaPortal)(new BlockTerraNovaPortal(172,Block.ice.blockIndexInTexture)).setHardness(-1.0F).setLightValue(0.75F).setCreativeTab(customTab).setBlockName("terraNovaPortal");

    /**
     * Forge method, called at the beginning, before the initialization phase
     * Mark the designated method as being called at the "pre-initialization"
     * phase
     *
     * @param event FMLPreInitializationEvent
     */
    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent event) {
        myLog.setParent(FMLLog.getLogger());
        log("Starting PreInitialization of Dinosaurus v" + version);
        proxy.registerSound();
        MinecraftForge.TERRAIN_GEN_BUS.register(new BiomeSizeHandler());
        MinecraftForge.EVENT_BUS.register(new FirePlacedEvent());
        config = new Configuration(event.getSuggestedConfigurationFile());
        log("Loading Dinosaurus.cfg config file");
        config.load();

        brachiosaurEggColor1 = config.get("EggColors", "brachiosaurEggColor1", "10066176").getInt();
        hadrosaurEggColor1 = config.get("EggColors", "hadrosaurEggColor1", "10066176").getInt();
        plesiosaurEggColor1 = config.get("EggColors", "plesiosaurEggColor1", "10066176").getInt();
        raptorEggColor1 = config.get("EggColors", "raptorEggColor1", "10066176").getInt();
        stegosaurEggColor1 = config.get("EggColors", "stegosaurEggColor1", "10066176").getInt();
        trexEggColor1 = config.get("EggColors", "brachiosaurEggColor1", "10066176").getInt();
        triceratopsEggColor1 = config.get("EggColors", "triceratopsEggColor1", "10066176").getInt();

        brachiosaurEggColor2 = config.get("EggColors", "brachiosaurEggColor2", "10053120").getInt();
        hadrosaurEggColor2 = config.get("EggColors", "hadrosaurEggColor2", "10053120").getInt();
        plesiosaurEggColor2 = config.get("EggColors", "plesiosaurEggColor2", "10053120").getInt();
        raptorEggColor2 = config.get("EggColors", "raptorEggColor2", "10053120").getInt();
        stegosaurEggColor2 = config.get("EggColors", "stegosaurEggColor2", "10053120").getInt();
        trexEggColor2 = config.get("EggColors", "brachiosaurEggColor2", "10053120").getInt();
        triceratopsEggColor2 = config.get("EggColors", "triceratopsEggColor2", "10053120").getInt();

        brachiosaurAttackStrength = config.get("AttackStrength", "brachiosaurAttackStrength", 4).getInt();
        hadrosaurAttackStrength = config.get("AttackStrength", "hadrosaurAttackStrength", 4).getInt();
        plesiosaurAttackStrength = config.get("AttackStrength", "plesiosaurAttackStrength", 7).getInt();
        raptorAttackStrength = config.get("AttackStrength", "raptorAttackStrength", 8).getInt();
        stegosaurAttackStrength = config.get("AttackStrength", "stegosaurAttackStrength", 6).getInt();
        trexAttackStrength = config.get("AttackStrength", "trexAttackStrength", 11).getInt();
        triceratopsAttackStrength = config.get("AttackStrength", "triceratopsAttackStrength", 8).getInt();

        brachiosaurMoveSpeed = (float) config.get("MoveSpeed", "brachiosaurMoveSpeed", 0.2D).getDouble(0.2D);
        hadrosaurMoveSpeed = (float) config.get("MoveSpeed", "hadrosaurMoveSpeed", 0.3D).getDouble(0.3D);
        plesiosaurMoveSpeed = (float) config.get("MoveSpeed", "plesiosaurMoveSpeed", 0.2D).getDouble(0.2D);
        raptorMoveSpeed = (float) config.get("MoveSpeed", "raptorMoveSpeed", 0.4D).getDouble(0.4D);
        stegosaurMoveSpeed = (float) config.get("MoveSpeed", "stegosaurMoveSpeed", 0.3D).getDouble(0.3D);
        trexMoveSpeed = (float) config.get("MoveSpeed", "trexMoveSpeed", 0.3D).getDouble(0.3D);
        triceratopsMoveSpeed = (float) config.get("MoveSpeed", "triceratopsMoveSpeed", 0.3D).getDouble(0.3D);

        dinoBoneLooted = config.get("Loots", "NumberOfDinoBonesLooted", 8).getInt();
        dinoSteakLooted = config.get("Loots", "NumberOfDinoSteaksLooted", 6).getInt();

        highestAluminiumOreLevel = config.get("OreGeneration", "HighestAluminiumOreLevel", 64).getInt();

        config.save();
    }

    /**
     * Forge method, called when the mod is being loaded Mark the designated
     * method as being called at the "initialization" phase
     *
     * @param event FMLInitializationEvent
     */
    @Mod.Init
    public void load(FMLInitializationEvent event) {
        log("Registering mobs inside minecraft");
        registerMobs();
        log("Registering mobs renders inside minecraft");
        proxy.registerRenderThings();
        log("Adding english translation");
        addLocalizations();
        GameRegistry.registerBlock(aluminiumOre, "aluminiumOre");
        GameRegistry.addSmelting(aluminiumOre.blockID, new ItemStack(aluminiumIngot, 1), 1.0F);
        GameRegistry.registerWorldGenerator(new AluminiumWorldGenerator());
        GameRegistry.removeBiome(BiomeGenBase.desert);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
        GameRegistry.removeBiome(BiomeGenBase.forest);
        GameRegistry.removeBiome(BiomeGenBase.forestHills);
        GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
        GameRegistry.removeBiome(BiomeGenBase.iceMountains);
        GameRegistry.removeBiome(BiomeGenBase.icePlains);
        GameRegistry.removeBiome(BiomeGenBase.jungle);
        GameRegistry.removeBiome(BiomeGenBase.jungleHills);
        GameRegistry.removeBiome(BiomeGenBase.swampland);
        GameRegistry.removeBiome(BiomeGenBase.taiga);
        GameRegistry.removeBiome(BiomeGenBase.taigaHills);
        GameRegistry.removeBiome(BiomeGenBase.forest);
        GameRegistry.removeBiome(BiomeGenBase.river);
        GameRegistry.removeBiome(BiomeGenBase.ocean);
        GameRegistry.removeBiome(BiomeGenBase.beach);
        GameRegistry.removeBiome(BiomeGenBase.plains);
        GameRegistry.removeBiome(BiomeGenBase.icePlains);
        GameRegistry.addBiome(new BiomeGenDinoPlains(150));
        GameRegistry.addBiome(new BiomeGenDinoHighlands(151));

        BiomeGenBase.ocean.setColor(16421912);
        BiomeGenBase.ocean.waterColorMultiplier = 39219;
        BiomeGenBase.ocean.setBiomeName("Dino - Ocean");
        BiomeGenBase.ocean.temperature = 2.0F;
        BiomeGenBase.ocean.rainfall = 2.0F;

        BiomeGenBase.river.setColor(16421912);
        BiomeGenBase.river.waterColorMultiplier = 39219;
        BiomeGenBase.river.setBiomeName("Dino - River");
        BiomeGenBase.river.temperature = 2.0F;
        BiomeGenBase.river.rainfall = 2.0F;

        BiomeGenBase.beach.setColor(16421912);
        BiomeGenBase.beach.waterColorMultiplier = 39219;
        BiomeGenBase.beach.setBiomeName("Dino - Beach");
        BiomeGenBase.beach.temperature = 2.0F;
        BiomeGenBase.beach.rainfall = 2.0F;

        BiomeGenBase.frozenRiver.setColor(16421912);
        BiomeGenBase.frozenRiver.waterColorMultiplier = 39219;
        BiomeGenBase.frozenRiver.setBiomeName("Dino - RiverF");
        BiomeGenBase.frozenRiver.temperature = 2.0F;
        BiomeGenBase.frozenRiver.rainfall = 2.0F;

        BiomeGenBase.iceMountains.setColor(16421912);
        BiomeGenBase.iceMountains.waterColorMultiplier = 39219;
        BiomeGenBase.iceMountains.setBiomeName("Dino - MountainsI");
        BiomeGenBase.iceMountains.temperature = 2.0F;
        BiomeGenBase.iceMountains.rainfall = 2.0F;

        BiomeGenBase.icePlains.setColor(16421912);
        BiomeGenBase.icePlains.waterColorMultiplier = 39219;
        BiomeGenBase.icePlains.setBiomeName("Dino - PlainsI");
        BiomeGenBase.icePlains.temperature = 2.0F;
        BiomeGenBase.icePlains.rainfall = 2.0F;

        BiomeGenBase.plains.setColor(16421912);
        BiomeGenBase.plains.waterColorMultiplier = 39219;
        BiomeGenBase.plains.setBiomeName("Dino - Plains");
        BiomeGenBase.plains.temperature = 2.0F;
        BiomeGenBase.plains.rainfall = 2.0F;

        GameRegistry.registerBlock(blockHugeThinTreeLog1, "blockhugeThinTreeLog1");
        GameRegistry.registerBlock(blockHugeThinTreeLog2, "blockhugeThinTreeLog2");
        GameRegistry.registerBlock(blockHugeThinTreeLog3, "blockhugeThinTreeLog3");
        GameRegistry.registerBlock(blockHugeThinTreeLeaves, "blockHugeThinTreeLeave");
        GameRegistry.registerBlock(terraNovaPortal, "terraNovaPortal");
        
        DimensionManager.registerProviderType(2, TerraNovaWorldProvider.class, false);
        DimensionManager.registerDimension(2, 2);

    }

    /**
     * Add a global name for each entity.
     */
    public void addLocalizations() {
        language.addStringLocalization("entity.Hadro.name", "Hadrosaurus");
        language.addStringLocalization("entity.Brachio.name", "Brachiosaurus");
        language.addStringLocalization("entity.Stegosaurus.name", "Stegosaurus");
        language.addStringLocalization("entity.Triceratops.name", "Triceratops");
        language.addStringLocalization("entity.Raptor.name", "Raptor");
        language.addStringLocalization("entity.TRex.name", "T-Rex");
        language.addStringLocalization("entity.Plesiosaur.name", "Plesiosaur");
        language.addStringLocalization("itemGroup.DinoCreativeTab", "en_US", "Dinosaurs item");
        language.addStringLocalization("itemGroup.DinoCreativeTab", "fr_FR", "Dinosaurs");
        language.addNameForObject(Dinosaurus.dinoBone, "fr_FR", "Os de dinosaur");
        language.addNameForObject(Dinosaurus.dinoBone, "en_US", "Dinosaur bone");
        language.addNameForObject(Dinosaurus.dinoClaw, "fr_FR", "Griffe de dinosaur");
        language.addNameForObject(Dinosaurus.dinoClaw, "en_US", "Dinosaur claw");
        language.addNameForObject(Dinosaurus.dinoSkull, "fr_FR", "Crâne de dinosaur");
        language.addNameForObject(Dinosaurus.dinoSkull, "en_US", "Dinosaur skull");
        language.addNameForObject(Dinosaurus.dinoSteak, "fr_FR", "Steak de dinosaur");
        language.addNameForObject(Dinosaurus.dinoSteak, "en_US", "Dinosaur steak");
        language.addNameForObject(Dinosaurus.dinoTibia, "fr_FR", "Tibia de dinosaur");
        language.addNameForObject(Dinosaurus.dinoTibia, "en_US", "Dinosaur tibia");
        language.addNameForObject(Dinosaurus.aluminiumIngot, "fr_FR", "Lingot d'aluminium");
        language.addNameForObject(Dinosaurus.aluminiumIngot, "en_US", "Aluminium ingot");
        language.addNameForObject(Dinosaurus.aluminiumOre, "fr_FR", "Minerai d'aluminium");
        language.addNameForObject(Dinosaurus.aluminiumOre, "en_US", "Aluminium Ore");
        language.addNameForObject(Dinosaurus.itemTest, "fr_FR", "itemTest");
        language.addNameForObject(Dinosaurus.itemTest, "en_US", "itemTest");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLog1, "fr_FR", "LogBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLog1, "en_US", "LogBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLog2, "fr_FR", "LogBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLog2, "en_US", "LogBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLog3, "fr_FR", "LogBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLog3, "en_US", "LogBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLeaves, "fr_FR", "LeaveBlock");
        language.addNameForObject(Dinosaurus.blockHugeThinTreeLeaves, "en_US", "LeaveBlock");

    }

    /**
     * Add a spawn to mobs, depending on the biome they are.
     */
    public void addSpawn() {
        BiomeGenBase[] biome = new BiomeGenBase[22];
        System.arraycopy(BiomeGenBase.biomeList, 0, biome, 0, biome.length);
        EntityRegistry.addSpawn(EntityRaptor.class, 10, 5, 20, EnumCreatureType.creature, biome);
    }

    /**
     * Register all custom mobs inside minecraft.
     */
    public void registerMobs() {
        registerCreature(EntityHadrosaur.class, "Hadro", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
        registerCreature(EntityBrachiosaur.class, "Brachio", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
        registerCreature(EntityStegosaurus.class, "Stegosaurus", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
        registerCreature(EntityTriceratops.class, "Triceratops", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
        registerCreature(EntityRaptor.class, "Raptor", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
        registerCreature(EntityTRex.class, "TRex", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
        registerCreature(EntityPlesiosaur.class, "Plesiosaur", EntityRegistry.findGlobalUniqueEntityId(), 10066176, 10053120);
    }

    /**
     * Register both GlobalEntityID and ModEntity.
     *
     * @param var1 Class of the entity to register
     * @param var2 Name of the entity
     * @param var3 Unique id of the entity
     * @param var4 First color of the egg
     * @param var5 Second color of the egg
     */
    private void registerCreature(Class var1, String var2, int var3, int var4, int var5) {
        EntityRegistry.registerGlobalEntityID(var1, var2, var3, var4, var5);
        EntityRegistry.registerModEntity(var1, var2, var3, this, 60, 3, true);
    }

    public static void log(String str) {
        myLog.log(Level.INFO, str);
    }

    public static void log(Level lvl, String str) {
        myLog.log(lvl, str);
    }
}