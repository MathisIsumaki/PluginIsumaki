package fr.isumaki.pluginisumaki.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Speed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§4Veuillez préciser la vitesse");
            return false;
        }
        if (player.isFlying()) {
            if (args[0].equalsIgnoreCase("0")) {
                player.setFlySpeed(0);
                player.sendMessage("§2Votre speed en vole est maintenant de 0");
            }
            if (args[0].equalsIgnoreCase("1")) {
                player.setFlySpeed(1);
                player.sendMessage("§2Votre speed en vole est maintenant de 1");
            }
            if (args[0].equalsIgnoreCase("2")) {
                player.setFlySpeed(2);
                player.sendMessage("§2Votre speed en vole est maintenant de 2");
            }
            if (args[0].equalsIgnoreCase("3")) {
                player.setFlySpeed(3);
                player.sendMessage("§2Votre speed en vole est maintenant de 3");
            }
            if (args[0].equalsIgnoreCase("4")) {
                player.setFlySpeed(4);
                player.sendMessage("§2Votre speed en vole est maintenant de 4");
            }
            if (args[0].equalsIgnoreCase("5")) {
                player.setFlySpeed(5);
                player.sendMessage("§2Votre speed en vole est maintenant de 5");
                return false;
            }
        }
        return false;
    }
}














