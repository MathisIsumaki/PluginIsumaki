package fr.isumaki.pluginisumaki.commands;

import fr.isumaki.pluginisumaki.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            sender.sendMessage("§4Seul un joueur peut éxécuter cette commande");
            return false;
        }
        //      /home <home>
        if(args.length ==0) {
            sender.sendMessage("§4Veuillez préciser le nom du home");
            return false;
        }
        Player player = (Player)sender;
        if(Main.INSTANCE.homes.containsKey(player) && Main.INSTANCE.homes.get(player).containsKey(args[0])){
            player.teleport(Main.INSTANCE.homes.get(player).get(args[0]));
            player.sendMessage("§2Vous avez été téléporté avec succès");
        }else player.sendMessage("§4Ce home n'existe pas");


        return false;

    }
}
