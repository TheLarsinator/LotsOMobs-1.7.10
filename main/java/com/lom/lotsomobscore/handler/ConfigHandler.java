package com.lom.lotsomobscore.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler 
{
	
	public static Configuration config;
	
	public static int TriceratopsID = 110;
	public static int BrontosaurusID = 111;
	public static int RaptorID = 112;
	public static int TRexID = 113;
	public static int PterosaurusID = 114;
	public static int MammothID = 115;
	public static int SaberToothID = 116;
	public static int IchtyosaurusID = 117;
	
	//All Mobs On/Off
	public static boolean DeerOn = true;
	public static boolean BoarOn = true;
	public static boolean WinterDeerOn = true;
	public static boolean BearOn = true;
	public static boolean GorillaOn = true;
	public static boolean WhaleOn = true;
	public static boolean NarwalOn = true;
	public static boolean FishyOn = true;
	public static boolean CamelOn = true;
	public static boolean BirdOn = true;
	public static boolean PenguinOn = true;
	public static boolean IceBearOn = true;
	public static boolean SnakeOn = true;
	public static boolean ButterFlyOn = true;
	public static boolean GiraffeOn = true;
	public static boolean ElephantOn = true;
	public static boolean VultureOn = true;
	public static boolean AntOn = true;
	public static boolean TurtleOn = true;
	public static boolean LizardOn = true;
	public static boolean GekkoOn = true;
	public static boolean SantaOn = true;
	public static boolean CrocoOn = true;
	public static boolean TriceratopsOn = true;
	public static boolean BrontosaurusOn = true;
	public static boolean RaptorOn = true;
	public static boolean TRexOn = true;
	public static boolean PterosaurusOn = true;
	public static boolean MammothOn = true;
	public static boolean SaberToothOn = true;
	public static boolean LionOn = true;
	public static boolean EskimoOn = true;
	public static boolean CavemanOn = true;
	public static boolean BunnyOn = true;
	public static boolean EasterFeaturesOn = true;
	public static boolean SquirrelOn = true;
	public static boolean EmpirosaurusOn = true;
	public static boolean BirdyOn = true;
	public static boolean KakkerlakOn = true;
	public static boolean MuskOxOn = true;
	public static boolean PDFrogOn = true;
	public static boolean FrogOn = true;
	public static boolean FlyOn = true;
	public static boolean FireFlyOn = true;
	public static boolean BullFrogOn = true;
	public static boolean BeeOn = true;
	public static boolean WormOn = true;
	public static boolean HermitCrabOn = true;
	public static boolean SwordFishOn = true;
	public static boolean IchtyosaurusOn = true;
	public static boolean EasterBunnyOn = true;
	public static boolean GoatOn = true;
	public static boolean GazelleOn = true;
	
	//Dimension IDs
	public static int dimension = -24;
	public static int dimension2 = -25;
	
	//Biome IDs
	public static int ArcticOceanID = 40;
	public static int AntarticaID = 41;
	public static int DinoTerrainID = 42;
	public static int IceAgeTerrainID = 46;
	public static int TropicBeachID = 50;
	
	public static void LoadFile(File configFile)
	{
		config = new Configuration(configFile);
		
		config.load();
		syncConfig();
		
		FMLCommonHandler.instance().bus().register(new ConfigChanger());
	}
	
	public static void syncConfig()
	{
		/**Here are all the Configuration settings for the mobs**/
		DeerOn = config.getBoolean("Deer", "mobs", DeerOn, "Turn the Deer on/off");
		BoarOn = config.getBoolean("Boar", "mobs", BoarOn, "Turn the Boar on/off");
		WinterDeerOn = config.getBoolean("WinterDeer", "mobs", WinterDeerOn, "Turn the WinterDeer on/off");
		BearOn = config.getBoolean("Bear", "mobs", BearOn, "Turn the Bear on/off");
		GorillaOn = config.getBoolean("Gorilla", "mobs", GorillaOn, "Turn the Bear on/off");
		WhaleOn = config.getBoolean("Whale", "mobs", WhaleOn, "Turn the Whale on/off");
		NarwalOn = config.getBoolean("Narwhale", "mobs", NarwalOn, "Turn the Narwhale on/off");
		FishyOn = config.getBoolean("Fishy", "mobs", FishyOn, "Turn the Fishy on/off");
		CamelOn = config.getBoolean("Camel", "mobs", CamelOn, "Turn the Camel on/off");
		BirdOn = config.getBoolean("Bird", "mobs", BirdOn, "Turn the Bird on/off");		
		
		PenguinOn = config.getBoolean("Penguin", "mobs", PenguinOn, "Turn the Penguin on/off");
		IceBearOn = config.getBoolean("Polar Bear", "mobs", IceBearOn, "Turn the Polar Bear on/off");
		SnakeOn = config.getBoolean("Snake", "mobs", SnakeOn, "Turn the Snake on/off");
		ButterFlyOn = config.getBoolean("ButterFly", "mobs", ButterFlyOn, "Turn the ButterFly on/off");
		GiraffeOn = config.getBoolean("Giraffe", "mobs", GiraffeOn, "Turn the Giraffe on/off");
		ElephantOn = config.getBoolean("Elephant", "mobs", ElephantOn, "Turn the Elephant on/off");
		VultureOn = config.getBoolean("Vulture", "mobs", VultureOn, "Turn the Vulture on/off");
		AntOn = config.getBoolean("Ant", "mobs", AntOn, "Turn the Ant on/off");
		TurtleOn = config.getBoolean("Turtle", "mobs", TurtleOn, "Turn the Turtle on/off");
		LizardOn = config.getBoolean("Lizard", "mobs", LizardOn, "Turn the Lizard on/off");		
		
		GekkoOn = config.getBoolean("Gekko", "mobs", GekkoOn, "Turn the Gekko on/off");
		SantaOn = config.getBoolean("Santa", "mobs", SantaOn, "Turn the Santa on/off");
		CrocoOn = config.getBoolean("Croco", "mobs", CrocoOn, "Turn the Croco on/off");
		TriceratopsOn = config.getBoolean("Triceratops", "mobs", TriceratopsOn, "Turn the Triceratops on/off");
		BrontosaurusOn = config.getBoolean("Brontosaurus", "mobs", BrontosaurusOn, "Turn the Brontosaurus on/off");
		RaptorOn = config.getBoolean("Raptor", "mobs", RaptorOn, "Turn the Raptor on/off");
		TRexOn = config.getBoolean("T-Rex", "mobs", TRexOn, "Turn the T-Rex on/off");
		PterosaurusOn = config.getBoolean("Pterosaur", "mobs", PterosaurusOn, "Turn the Pterosaur on/off");
		MammothOn = config.getBoolean("Mammoth", "mobs", MammothOn, "Turn the Mammoth on/off");
		SaberToothOn = config.getBoolean("SaberTooth", "mobs", SaberToothOn, "Turn the SaberTooth on/off");		
		
		LionOn = config.getBoolean("Lion", "mobs", LionOn, "Turn the Lion on/off");
		EskimoOn = config.getBoolean("Eskimo", "mobs", EskimoOn, "Turn the Eskimo on/off");
		CavemanOn = config.getBoolean("Caveman", "mobs", CavemanOn, "Turn the Caveman on/off");
		BunnyOn = config.getBoolean("Bunny", "mobs", BunnyOn, "Turn the Bunny on/off");
		EasterBunnyOn = config.getBoolean("EasterBunny", "mobs", EasterBunnyOn, "Turn the EasterBunny on/off");
		SquirrelOn = config.getBoolean("Squirrel", "mobs", SquirrelOn, "Turn the Squirrel on/off");
		KakkerlakOn = config.getBoolean("Cockroach", "mobs", KakkerlakOn, "Turn the Cockroach on/off");
		MuskOxOn = config.getBoolean("Musk Ox", "mobs", MuskOxOn, "Turn the Musk Ox on/off");
		PDFrogOn = config.getBoolean("Poison Dart Frog", "mobs", PDFrogOn, "Turn the Poison Dart Frog on/off");
		
		FrogOn = config.getBoolean("Frog", "mobs", FrogOn, "Turn the Frog on/off");
		FlyOn = config.getBoolean("Fly", "mobs", FlyOn, "Turn the Fly on/off");
		FireFlyOn = config.getBoolean("FireFly", "mobs", FireFlyOn, "Turn the FireFly on/off");
		BullFrogOn = config.getBoolean("BullFrog", "mobs", BullFrogOn, "Turn the BullFrog on/off");
		BeeOn = config.getBoolean("Bee", "mobs", BeeOn, "Turn the Bee on/off");
		WormOn = config.getBoolean("Worm", "mobs", WormOn, "Turn the Worm on/off");
		HermitCrabOn = config.getBoolean("Hermit Crab", "mobs", HermitCrabOn, "Turn the Hermit Crab on/off");
		EmpirosaurusOn = config.getBoolean("Empirosaurus", "mobs", EmpirosaurusOn, "Turn the Empirosaurus on/off");
		GoatOn = config.getBoolean("Goat", "mobs", GoatOn, "Turn the Goat on/off");
		IchtyosaurusOn = config.getBoolean("Ichtyosaurus", "mobs", IchtyosaurusOn, "Turn the Ichtyosaurus on/off");	
		GazelleOn = config.getBoolean("Gazelle", "mobs", GazelleOn, "Turn the Gazelle on/off");	
	
		IchtyosaurusID = config.getInt("IchtyosaurusID", "dinoid", IchtyosaurusID, 0, Integer.MAX_VALUE, "Ichtyosaurus ID");
		TriceratopsID = config.getInt("TriceratopsID", "dinoid", TriceratopsID, 0, Integer.MAX_VALUE, "Triceratops ID");
		BrontosaurusID = config.getInt("BrontosaurusID", "dinoid", BrontosaurusID, 0, Integer.MAX_VALUE, "Brontosaurus ID");
		RaptorID = config.getInt("RaptorID", "dinoid", RaptorID, 0, Integer.MAX_VALUE, "Raptor ID");
		TRexID = config.getInt("TRexID", "dinoid", TRexID, 0, Integer.MAX_VALUE, "TRex ID");
		PterosaurusID = config.getInt("PterosaurusID", "dinoid", PterosaurusID, 0, Integer.MAX_VALUE, "Pterosaurus ID");
		MammothID = config.getInt("MammothID", "dinoid", MammothID, 0, Integer.MAX_VALUE, "Mammoth ID");
		SaberToothID = config.getInt("SaberToothID", "dinoid", SaberToothID, 0, Integer.MAX_VALUE, "SaberTooth ID");

		AntarticaID = config.getInt("AntarticaID", "biome", AntarticaID, 0, Integer.MAX_VALUE, "Antartica ID");
		ArcticOceanID = config.getInt("ArcticOceanID", "biome", ArcticOceanID, 0, Integer.MAX_VALUE, "ArcticOcean ID");
		DinoTerrainID = config.getInt("DinoTerrainID", "biome", DinoTerrainID, 0, Integer.MAX_VALUE, "DinoTerrain ID, remember to keep the next 3 IDs "
				+ "empty as well since LotsOMobs adds 4 Dino Biomes");
		IceAgeTerrainID = config.getInt("IceAgeTerrainID", "biome", IceAgeTerrainID, 0, Integer.MAX_VALUE, "IceAgeTerrain ID, also keep 3 IDs empty after this one");

		dimension = config.getInt("Dino Dimension ID", "dimension", dimension, -100, Integer.MAX_VALUE, "Dino ID");
		dimension2 = config.getInt("Ice Dimension ID", "dimension", dimension2, -100, Integer.MAX_VALUE, "Ice Age ID");

		
		if(config.hasChanged())	
		config.save();
	}

	public static class ConfigChanger {

		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
			if(eventArgs.modID.equals("lom"))
				syncConfig();
		}
	}
}
