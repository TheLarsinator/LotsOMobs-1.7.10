package com.lom.lotsomobscore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import com.lom.lotsomobsachievement.LotsOMobsAchievements;
import com.lom.lotsomobscore.handler.GuiHandler;
import com.lom.lotsomobsinit.LotsOMobsAchievementsBook;
import com.lom.lotsomobsinit.LotsOMobsBiomes;
import com.lom.lotsomobsinit.LotsOMobsBlocks;
import com.lom.lotsomobsinit.LotsOMobsItems;
import com.lom.lotsomobsinit.LotsOMobsMobs;
import com.lom.lotsomobsinit.LotsOMobsRecipes;
import com.lom.lotsomobstabs.MyBlockTab;
import com.lom.lotsomobstabs.MyCombatTab;
import com.lom.lotsomobstabs.MyItemsTab;
import com.lom.lotsomobsworldgen.FossilOreGeneration;
import com.lom.lotsomobsworldgen.OreGeneration;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod (modid = "lom",name = "LotsOMobs", version = "version", guiFactory = "com.lom.lotsomobscore.LotsOMobsGUIFactory")
/**100.000 downloads!!!
 * http://prntscr.com/1hz9gd
 * http://prntscr.com/1hzais
 * @author Lars
 */
public class LotsOMobs
{
	public static String modid = "lom";	
	@SidedProxy(clientSide = "com.lom.lotsomobscore.LotsOMobsClient",serverSide = "com.lom.lotsomobscore.LotsOMobsProxy")
	public static LotsOMobsProxy proxy;
	@Mod.Instance("LotsOMobs")
	public static LotsOMobs instance;	
	public static Configuration config;
	
//Enums
	public static ToolMaterial EnumToolMaterialHorn= EnumHelper.addToolMaterial("HORN", 1, 100, 2.1F, 1, 17);
	public static ToolMaterial EnumToolMaterialIvory= EnumHelper.addToolMaterial("IVORY", 1, 200, 5.0F, 2, 8);
	public static ToolMaterial EnumToolMaterialIcemintuim= EnumHelper.addToolMaterial("ICEMINTUIM", 2, 500, 8F, 4, 12);
	public static ToolMaterial EnumToolMaterialAmber= EnumHelper.addToolMaterial("AMBER", 5, 1800, 15F, 8, 24);

	public static final ArmorMaterial Fur = EnumHelper.addArmorMaterial("Fur",  6, new int[] {2, 4, 3, 2}, 17);
	public static final ArmorMaterial Elephant = EnumHelper.addArmorMaterial("Elephant",  7, new int[] {3, 5, 4, 3}, 19);
	public static final ArmorMaterial Santa = EnumHelper.addArmorMaterial("Santa",  7, new int[] {1, 3, 2, 1}, 15);
	public static final ArmorMaterial AmberA = EnumHelper.addArmorMaterial("Amber",  200, new int[] {5, 10, 8, 5}, 12);
	public static final ArmorMaterial Dino = EnumHelper.addArmorMaterial("Dino",  75, new int[] {3, 8, 6, 3}, 10);
	public static final ArmorMaterial Eskimo = EnumHelper.addArmorMaterial("Eskimo",  8, new int[] {3, 5, 4, 4}, 20);
	public static final ArmorMaterial IcemintuimA = EnumHelper.addArmorMaterial("Icemintuim", 90, new int[] {3, 6, 5, 3}, 12);
//Tabs
	public static CreativeTabs LotsOMobsItemsTab = new MyItemsTab(CreativeTabs.getNextID(),"LotsOMobsItems");
	public static CreativeTabs LotsOMobsCombatTab = new MyCombatTab(CreativeTabs.getNextID(),"LotsOMobsCombat");
	public static CreativeTabs LotsOMobsBlockTab = new MyBlockTab(CreativeTabs.getNextID(),"LotsOMobsBlock");
	
//Configurations
	@Mod.EventHandler
	public void initConfiguration(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());	
		//config.load();
		syncConfig();
	}
	
	public static void syncConfig()
	{
//		config.load();
		/**Here are all the Configuration settings for the mobs**/
		ConfigDetails.DeerOn = config.getBoolean("Deer", "mobs", ConfigDetails.DeerOn, "Turn the Deer on/off");
		ConfigDetails.BoarOn = config.getBoolean("Boar", "mobs", ConfigDetails.BoarOn, "Turn the Boar on/off");
		ConfigDetails.WinterDeerOn = config.getBoolean("WinterDeer", "mobs", ConfigDetails.WinterDeerOn, "Turn the WinterDeer on/off");
		ConfigDetails.BearOn = config.getBoolean("Bear", "mobs", ConfigDetails.BearOn, "Turn the Bear on/off");
		ConfigDetails.GorillaOn = config.getBoolean("Gorilla", "mobs", ConfigDetails.GorillaOn, "Turn the Bear on/off");
		ConfigDetails.WhaleOn = config.getBoolean("Whale", "mobs", ConfigDetails.WhaleOn, "Turn the Whale on/off");
		ConfigDetails.NarwalOn = config.getBoolean("Narwhale", "mobs", ConfigDetails.NarwalOn, "Turn the Narwhale on/off");
		ConfigDetails.FishyOn = config.getBoolean("Fishy", "mobs", ConfigDetails.FishyOn, "Turn the Fishy on/off");
		ConfigDetails.CamelOn = config.getBoolean("Camel", "mobs", ConfigDetails.CamelOn, "Turn the Camel on/off");
		ConfigDetails.BirdOn = config.getBoolean("Bird", "mobs", ConfigDetails.BirdOn, "Turn the Bird on/off");		
		
		ConfigDetails.PenguinOn = config.getBoolean("Penguin", "mobs", ConfigDetails.PenguinOn, "Turn the Penguin on/off");
		ConfigDetails.IceBearOn = config.getBoolean("Polar Bear", "mobs", ConfigDetails.IceBearOn, "Turn the Polar Bear on/off");
		ConfigDetails.SnakeOn = config.getBoolean("Snake", "mobs", ConfigDetails.SnakeOn, "Turn the Snake on/off");
		ConfigDetails.ButterFlyOn = config.getBoolean("ButterFly", "mobs", ConfigDetails.ButterFlyOn, "Turn the ButterFly on/off");
		ConfigDetails.GiraffeOn = config.getBoolean("Giraffe", "mobs", ConfigDetails.GiraffeOn, "Turn the Giraffe on/off");
		ConfigDetails.ElephantOn = config.getBoolean("Elephant", "mobs", ConfigDetails.ElephantOn, "Turn the Elephant on/off");
		ConfigDetails.VultureOn = config.getBoolean("Vulture", "mobs", ConfigDetails.VultureOn, "Turn the Vulture on/off");
		ConfigDetails.AntOn = config.getBoolean("Ant", "mobs", ConfigDetails.AntOn, "Turn the Ant on/off");
		ConfigDetails.TurtleOn = config.getBoolean("Turtle", "mobs", ConfigDetails.TurtleOn, "Turn the Turtle on/off");
		ConfigDetails.LizardOn = config.getBoolean("Lizard", "mobs", ConfigDetails.LizardOn, "Turn the Lizard on/off");		
		
		ConfigDetails.GekkoOn = config.getBoolean("Gekko", "mobs", ConfigDetails.GekkoOn, "Turn the Gekko on/off");
		ConfigDetails.SantaOn = config.getBoolean("Santa", "mobs", ConfigDetails.SantaOn, "Turn the Santa on/off");
		ConfigDetails.CrocoOn = config.getBoolean("Croco", "mobs", ConfigDetails.CrocoOn, "Turn the Croco on/off");
		ConfigDetails.TriceratopsOn = config.getBoolean("Triceratops", "mobs", ConfigDetails.TriceratopsOn, "Turn the Triceratops on/off");
		ConfigDetails.BrontosaurusOn = config.getBoolean("Brontosaurus", "mobs", ConfigDetails.BrontosaurusOn, "Turn the Brontosaurus on/off");
		ConfigDetails.RaptorOn = config.getBoolean("Raptor", "mobs", ConfigDetails.RaptorOn, "Turn the Raptor on/off");
		ConfigDetails.TRexOn = config.getBoolean("T-Rex", "mobs", ConfigDetails.TRexOn, "Turn the T-Rex on/off");
		ConfigDetails.PterosaurusOn = config.getBoolean("Pterosaur", "mobs", ConfigDetails.PterosaurusOn, "Turn the Pterosaur on/off");
		ConfigDetails.MammothOn = config.getBoolean("Mammoth", "mobs", ConfigDetails.MammothOn, "Turn the Mammoth on/off");
		ConfigDetails.SaberToothOn = config.getBoolean("SaberTooth", "mobs", ConfigDetails.SaberToothOn, "Turn the SaberTooth on/off");		
		
		ConfigDetails.LionOn = config.getBoolean("Lion", "mobs", ConfigDetails.LionOn, "Turn the Lion on/off");
		ConfigDetails.EskimoOn = config.getBoolean("Eskimo", "mobs", ConfigDetails.EskimoOn, "Turn the Eskimo on/off");
		ConfigDetails.CavemanOn = config.getBoolean("Caveman", "mobs", ConfigDetails.CavemanOn, "Turn the Caveman on/off");
		ConfigDetails.BunnyOn = config.getBoolean("Bunny", "mobs", ConfigDetails.BunnyOn, "Turn the Bunny on/off");
		ConfigDetails.EasterBunnyOn = config.getBoolean("EasterBunny", "mobs", ConfigDetails.EasterBunnyOn, "Turn the EasterBunny on/off");
		ConfigDetails.SquirrelOn = config.getBoolean("Squirrel", "mobs", ConfigDetails.SquirrelOn, "Turn the Squirrel on/off");
		ConfigDetails.KakkerlakOn = config.getBoolean("Cockroach", "mobs", ConfigDetails.KakkerlakOn, "Turn the Cockroach on/off");
		ConfigDetails.MuskOxOn = config.getBoolean("Musk Ox", "mobs", ConfigDetails.MuskOxOn, "Turn the Musk Ox on/off");
		ConfigDetails.PDFrogOn = config.getBoolean("Poison Dart Frog", "mobs", ConfigDetails.PDFrogOn, "Turn the Poison Dart Frog on/off");
		
		ConfigDetails.FrogOn = config.getBoolean("Frog", "mobs", ConfigDetails.FrogOn, "Turn the Frog on/off");
		ConfigDetails.FlyOn = config.getBoolean("Fly", "mobs", ConfigDetails.FlyOn, "Turn the Fly on/off");
		ConfigDetails.FireFlyOn = config.getBoolean("FireFly", "mobs", ConfigDetails.FireFlyOn, "Turn the FireFly on/off");
		ConfigDetails.BullFrogOn = config.getBoolean("BullFrog", "mobs", ConfigDetails.BullFrogOn, "Turn the BullFrog on/off");
		ConfigDetails.BeeOn = config.getBoolean("Bee", "mobs", ConfigDetails.BeeOn, "Turn the Bee on/off");
		ConfigDetails.WormOn = config.getBoolean("Worm", "mobs", ConfigDetails.WormOn, "Turn the Worm on/off");
		ConfigDetails.HermitCrabOn = config.getBoolean("Hermit Crab", "mobs", ConfigDetails.HermitCrabOn, "Turn the Hermit Crab on/off");
		ConfigDetails.EmpirosaurusOn = config.getBoolean("Empirosaurus", "mobs", ConfigDetails.EmpirosaurusOn, "Turn the Empirosaurus on/off");
		ConfigDetails.GoatOn = config.getBoolean("Goat", "mobs", ConfigDetails.GoatOn, "Turn the Goat on/off");
		ConfigDetails.IchtyosaurusOn = config.getBoolean("Ichtyosaurus", "mobs", ConfigDetails.IchtyosaurusOn, "Turn the Ichtyosaurus on/off");	
		ConfigDetails.GazelleOn = config.getBoolean("Gazelle", "mobs", ConfigDetails.GazelleOn, "Turn the Gazelle on/off");	
	
		ConfigDetails.IchtyosaurusID = config.getInt("IchtyosaurusID", "mobs", ConfigDetails.IchtyosaurusID, 0, Integer.MAX_VALUE, "Ichtyosaurus ID");
		ConfigDetails.TriceratopsID = config.getInt("TriceratopsID", "mobs", ConfigDetails.TriceratopsID, 0, Integer.MAX_VALUE, "Triceratops ID");
		ConfigDetails.BrontosaurusID = config.getInt("BrontosaurusID", "mobs", ConfigDetails.BrontosaurusID, 0, Integer.MAX_VALUE, "Brontosaurus ID");
		ConfigDetails.RaptorID = config.getInt("RaptorID", "mobs", ConfigDetails.RaptorID, 0, Integer.MAX_VALUE, "Raptor ID");
		ConfigDetails.TRexID = config.getInt("TRexID", "mobs", ConfigDetails.TRexID, 0, Integer.MAX_VALUE, "TRex ID");
		ConfigDetails.PterosaurusID = config.getInt("PterosaurusID", "mobs", ConfigDetails.PterosaurusID, 0, Integer.MAX_VALUE, "Pterosaurus ID");
		ConfigDetails.MammothID = config.getInt("MammothID", "mobs", ConfigDetails.MammothID, 0, Integer.MAX_VALUE, "Mammoth ID");
		ConfigDetails.SaberToothID = config.getInt("SaberToothID", "mobs", ConfigDetails.SaberToothID, 0, Integer.MAX_VALUE, "SaberTooth ID");

		ConfigDetails.AntarticaID = config.getInt("AntarticaID", "mobs", ConfigDetails.AntarticaID, 0, Integer.MAX_VALUE, "Antartica ID");
		ConfigDetails.ArcticOceanID = config.getInt("ArcticOceanID", "mobs", ConfigDetails.ArcticOceanID, 0, Integer.MAX_VALUE, "ArcticOcean ID");
		ConfigDetails.DinoTerrainID = config.getInt("DinoTerrainID", "mobs", ConfigDetails.DinoTerrainID, 0, Integer.MAX_VALUE, "DinoTerrain ID, remember to keep the next 3 IDs "
				+ "empty as well since LotsOMobs adds 4 Dino Biomes");
		ConfigDetails.IceAgeTerrainID = config.getInt("IceAgeTerrainID", "mobs", ConfigDetails.IceAgeTerrainID, 0, Integer.MAX_VALUE, "IceAgeTerrain ID, also keep 3 IDs empty after this one");

		ConfigDetails.dimension = config.getInt("Dino Dimension ID", "mobs", ConfigDetails.dimension, -100, Integer.MAX_VALUE, "Dino ID");
		ConfigDetails.dimension2 = config.getInt("Ice Dimension ID", "mobs", ConfigDetails.dimension2, -100, Integer.MAX_VALUE, "Ice Age ID");

		
		if(config.hasChanged())	
		{
		config.save();
		System.out.println("Yay");
		}
	}

//PreInit
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
     LotsOMobsBlocks.Init();
     LotsOMobsItems.Init();
     LotsOMobsBiomes.Init();
     LotsOMobsAchievementsBook.Init();

     GameRegistry.registerWorldGenerator(new FossilOreGeneration(), 2);
     GameRegistry.registerWorldGenerator(new OreGeneration(), 2);
		// proxy.registerSound();		
	}

	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{	
     	FMLCommonHandler.instance().bus().register(new LotsOMobsConfigEvent());

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		LotsOMobsMobs.Init();
		LotsOMobsRecipes.RecipeBook();		
     	
		proxy.registerRenderInformation();
     	
     	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(LotsOMobsItems.PineApple, 0, 1, 4, 50));
     	ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(LotsOMobsItems.PineApple, 0, 1, 4, 50));
     	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(LotsOMobsItems.PineApple, 0, 1, 4, 50));
     	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(LotsOMobsItems.PineApple, 0, 1, 4, 50));
     	
     	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(LotsOMobsItems.Tomato, 0, 1, 4, 50));
     	ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(LotsOMobsItems.Tomato, 0, 1, 4, 50));
     	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(LotsOMobsItems.Tomato, 0, 1, 4, 50));
     	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(LotsOMobsItems.Tomato, 0, 1, 4, 50));     	

     	MinecraftForge.EVENT_BUS.register(new LotsOMobsAchievements());
     	FMLCommonHandler.instance().bus().register(new LotsOMobsAchievements());

	}
}