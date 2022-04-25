package fr.isumaki.pluginisumaki.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Top implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return false;
        }
        Player player = (Player) sender;
            player.sendMessage("§2Vous avez été téléporté au block le plus haut");
            Location PlayerLocation = player.getLocation();
            player.getWorld().getHighestBlockAt(PlayerLocation);
            player.teleport(PlayerLocation);
            return false;
        }

    }

