package fr.isumaki.pluginisumaki.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.setHealth(20);
            return false;
        } else {
            Player playerheal = Bukkit.getPlayer(args[0]);
            if (playerheal != null) {
                playerheal.setHealth(20);

            } else sender.sendMessage("Ce joueur n'est pas connecté");
        }
        return false;
    }
}

