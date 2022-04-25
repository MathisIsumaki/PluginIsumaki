package fr.isumaki.pluginisumaki;

import fr.isumaki.pluginisumaki.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;



public class Main extends JavaPlugin {


    public HashMap<Player, HashMap<String, Location>> homes = new HashMap<>();
    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Bukkit.getServer().getConsoleSender().sendMessage("§2Le plugin Isumaki a bien demarre");
        Bukkit.getPluginManager().registerEvents(new RegisterEvents(), this);
        saveDefaultConfig();

        getCommand("alert").setExecutor(new Alert());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("sethome").setExecutor(new SetHome());
        getCommand("home").setExecutor(new Home());
        getCommand("gm").setExecutor(new Gm());
        getCommand("top").setExecutor(new Top());
        getCommand("speed").setExecutor(new Speed());
        System.out.println(getConfig().get("Homes"));
        CommandManager.initCommand();

        // get la config
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§2Le plugin Isumaki vient de s'eteindre");
    }

    public void updateHomes(){
        /*
        Homes:
            PlayerUUID:
                Home1: loc
                Home2: loc
                Home3: loc
                ...
            PlayerUUID:
                Home1: loc
                Home2: loc
                Home3: loc
                ...
        */
        homes.forEach((player, Hm) -> {
            Hm.forEach((HomeName, HomeLoc) -> {
                getConfig().set("Homes."+player.getUniqueId()+"."+HomeName, HomeLoc);
            });
        });
        saveConfig();

    }


}
