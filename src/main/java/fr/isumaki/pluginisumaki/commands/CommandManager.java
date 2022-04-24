package fr.isumaki.pluginisumaki.commands;

import fr.isumaki.pluginisumaki.Main;

public class CommandManager {
    public static void initCommand (){
        Main.INSTANCE.getCommand("Lightningrod").setExecutor(new LightningRod());
    }
}
