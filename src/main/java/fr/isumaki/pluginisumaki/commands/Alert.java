package fr.isumaki.pluginisumaki.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Alert implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage("§6Syntaxe incorecte, merci de spécifier le message après la commande. /alert <message>");
        }else{
            StringBuilder bc = new StringBuilder();
            for (String part : args) {
                bc.append(part + " ");
            }
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.sendMessage("§6[§4Broadcast§6] §f"+bc); // /alert qf sdg h hfds h
            });
        }



        return false;
    }
}
