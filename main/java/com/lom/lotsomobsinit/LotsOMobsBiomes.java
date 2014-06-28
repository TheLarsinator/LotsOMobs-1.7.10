package com.lom.lotsomobsinit;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

import com.lom.lotsomobsbiomes.BiomeGenAntartica;
import com.lom.lotsomobsbiomes.BiomeGenArcticOcean;
import com.lom.lotsomobsbiomes.BiomeGenDinoIslands;
import com.lom.lotsomobsbiomes.BiomeGenDinoJungle;
import com.lom.lotsomobsbiomes.BiomeGenDinoMountains;
import com.lom.lotsomobsbiomes.BiomeGenDinoOcean;
import com.lom.lotsomobsbiomes.BiomeGenDinoPlains;
import com.lom.lotsomobsbiomes.BiomeGenIceIslands;
import com.lom.lotsomobsbiomes.BiomeGenIceMountains;
import com.lom.lotsomobsbiomes.BiomeGenIceOcean;
import com.lom.lotsomobsbiomes.BiomeGenIcePlains;
import com.lom.lotsomobscore.ConfigDetails;
import com.lom.lotsomobsdino.WorldProviderDino;
import com.lom.lotsomobsiceage.WorldProviderIceAge;

public class LotsOMobsBiomes 
{
	//Biomes
		public static  BiomeGenBase modBiomeAntartica;
		public static  BiomeGenBase modBiomeArcticOcean;
		public static  BiomeGenBase modBiomeDinoPlains;
		public static  BiomeGenBase modBiomeDinoMountains;
		public static  BiomeGenBase modBiomeDinoOcean;
		public static  BiomeGenBase modBiomeDinoIslands;
		public static  BiomeGenBase modBiomeDinoJungle;
		public static  BiomeGenBase modBiomeIcePlains;
		public static  BiomeGenBase modBiomeIceMountains;
		public static  BiomeGenBase modBiomeIceOcean;
		public static  BiomeGenBase modBiomeIceIslands;

	public static void Init()
	{
		//Biomes
		 modBiomeAntartica = new BiomeGenAntartica(ConfigDetails.AntarticaID).setColor(747097).setBiomeName("Antartica");
		 modBiomeArcticOcean = new BiomeGenArcticOcean(ConfigDetails.ArcticOceanID).setColor(747097).setBiomeName("Arctic Ocean");
		 modBiomeDinoPlains = new BiomeGenDinoPlains(ConfigDetails.DinoTerrainID).setColor(6546587).setBiomeName("Dino Plains");
		 modBiomeDinoMountains = new BiomeGenDinoMountains(ConfigDetails.DinoTerrainID+1).setColor(6546587).setBiomeName("Dino Mountains");
		 modBiomeDinoOcean = new BiomeGenDinoOcean(ConfigDetails.DinoTerrainID+2).setColor(6546587).setBiomeName("Dino Ocean");
		 modBiomeDinoIslands = new BiomeGenDinoIslands(ConfigDetails.DinoTerrainID+3).setColor(6546587).setBiomeName("Dino Islands");
		 modBiomeDinoJungle = new BiomeGenDinoJungle(ConfigDetails.DinoTerrainID+4).setColor(6546587).setBiomeName("Dino Jungle");	
		 modBiomeIcePlains = new BiomeGenIcePlains(ConfigDetails.IceAgeTerrainID+1).setColor(6546587).setBiomeName("Ice Plains");
		 modBiomeIceMountains = new BiomeGenIceMountains(ConfigDetails.IceAgeTerrainID+2).setColor(6546587).setBiomeName("Ice Mountains");
		 modBiomeIceOcean = new BiomeGenIceOcean(ConfigDetails.IceAgeTerrainID+3).setColor(6546587).setBiomeName("Ice Ocean");
		 modBiomeIceIslands = new BiomeGenIceIslands(ConfigDetails.IceAgeTerrainID+4).setColor(6546587).setBiomeName("Ice Islands");

		 BiomeManager.icyBiomes.add(new BiomeEntry(modBiomeAntartica, 10));
		 BiomeManager.oceanBiomes.add(modBiomeArcticOcean);
		 
		 BiomeManager.addSpawnBiome(modBiomeAntartica);
//Dimensions
		DimensionManager.registerProviderType(ConfigDetails.dimension, WorldProviderDino.class, false);
		DimensionManager.registerDimension(ConfigDetails.dimension, ConfigDetails.dimension);
		
		DimensionManager.registerProviderType(ConfigDetails.dimension2, WorldProviderIceAge.class, false);
		DimensionManager.registerDimension(ConfigDetails.dimension2, ConfigDetails.dimension2);
	}
}
