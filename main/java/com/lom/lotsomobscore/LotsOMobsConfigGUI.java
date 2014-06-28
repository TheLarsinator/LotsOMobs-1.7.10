package com.lom.lotsomobscore;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class LotsOMobsConfigGUI extends GuiConfig 
{
    public LotsOMobsConfigGUI(GuiScreen parent) 
    {
        super(parent, new ConfigElement(LotsOMobs.config.getCategory("mobs")).getChildElements(), "LotsOMobs", false, false, GuiConfig.getAbridgedConfigPath(LotsOMobs.config.toString()));
    }
}