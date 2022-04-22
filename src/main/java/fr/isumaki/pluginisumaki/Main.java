package fr.isumaki.pluginisumaki;

import fr.isumaki.pluginisumaki.commands.Alert;
import fr.isumaki.pluginisumaki.commands.EnderChest;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§eLe plugin Isumaki a bien demarre");
        Bukkit.getPluginManager().registerEvents(new RegisterEvents(), this);

        getCommand("alert").setExecutor(new Alert());
        getCommand("enderchest").setExecutor(new EnderChest());
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§eLe plugin Isumaki vient de s'eteindre");

    }
}
