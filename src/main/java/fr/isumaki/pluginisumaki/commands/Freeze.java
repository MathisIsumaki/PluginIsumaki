package fr.isumaki.pluginisumaki.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage("§4Veuillez préciser le joueur a freeze");
            return false;
        } else {
            player.setWalkSpeed(0);
            player.setFlySpeed(0);
            player.sendMessage("§4VOUS AVEZ ÉTÉ FREEZE. MERCI DE NE PAS VOUS DÉCONNECTER SOUS PEINE DE BAN. NOUS PROCÈDONS A UNE VÉRIFICATION");}
        return false;
    }
}
