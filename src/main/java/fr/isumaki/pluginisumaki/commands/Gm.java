package fr.isumaki.pluginisumaki.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§4Veuillez préciser le gamemode");
            return false;

        }
        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("Survival")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§2Vous avez été mit en Gamemode 0 avec succès");
        }
        if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("Cretive")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage("§2Vous avez été mit en Gamemode 1 avec succès");
        }
        if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("Adventure")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage("§2Vous avez été mit en Gamemode 2 avec succès");
        }
        if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("Spectator")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("§2Vous avez été mit en Gamemode 3 avec succès");
            return false;
        }
        return false;
    }
}