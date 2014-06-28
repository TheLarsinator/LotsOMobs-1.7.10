package com.lom.lotsomobscore;

import com.lom.lotsomobscore.handler.ConfigHandler;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class LotsOMobsConfigGUI extends GuiConfig 
{
    public LotsOMobsConfigGUI(GuiScreen parent) 
    {
        super(parent,
        		new ConfigElement(ConfigHandler.config.getCategory("mobs")).getChildElements(),
        		"lom", false, false, "LotsOMobs Config", GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}