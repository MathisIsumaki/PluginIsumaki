package fr.isumaki.pluginisumaki.commands;

import fr.isumaki.pluginisumaki.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

;import java.util.HashMap;

public class SetHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //          /sethome <name>
        if(sender instanceof ConsoleCommandSender){
            sender.sendMessage("Une erreur est survenue, seul un joueur peut executer cette commande");
            return false;
        }
        Player player = (Player)sender;

        if(args.length == 0){
            player.sendMessage("§4Veuillez préciser le nom du home");
            return false;
        }
        String HomeName = args[0];
        Location HomeLoc = player.getLocation();
        if (Main.INSTANCE.homes.containsKey(player)){
            if(Main.INSTANCE.homes.get(player).containsKey(HomeName)){
                player.sendMessage("§4Ce home existe déjà");
                return false;
            }
            Main.INSTANCE.homes.get(player).put(HomeName, HomeLoc);
        }else{
            HashMap<String, Location> Hm = new HashMap<>();
            Hm.put(HomeName, HomeLoc);
            Main.INSTANCE.homes.put(player, Hm);
        }
        player.sendMessage("§2Le home à bien été ajouté");
        Main.INSTANCE.updateHomes();
        System.out.println(Main.INSTANCE.homes);

        return false;
    }
}
