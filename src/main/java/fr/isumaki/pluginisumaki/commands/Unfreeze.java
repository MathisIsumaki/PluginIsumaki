package fr.isumaki.pluginisumaki.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unfreeze implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage("§4Veuillez préciser le joueur a unfreeze");
            return false;
        } else {
            player.setWalkSpeed((float) 0.2);
            player.setFlySpeed((float) 0.2);
            player.sendMessage("§2VÉRIFICATION TERMINÉE, MERCI DE VOTRE PATIENCE");
        }
        return false;
    }
}
