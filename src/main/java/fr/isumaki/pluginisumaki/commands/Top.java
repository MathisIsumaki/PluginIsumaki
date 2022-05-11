package fr.isumaki.pluginisumaki.commands;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Top implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("top")) {
                final double topX = player.getLocation().getBlockX() + 0.5;
                final double topZ = player.getLocation().getBlockZ() + 0.5;
                final float pitch = player.getLocation().getPitch();
                final float yaw = player.getLocation().getYaw();
                final Location loc = (new Location(player.getWorld(), topX,
                        player.getWorld().getHighestBlockYAt(player.getLocation()), topZ, yaw, pitch));
                player.teleport(loc);
                player.sendMessage("§2Vous avez été téléporté au point le plus haut avec succès");
            }
        }else System.out.println("Seul un joueur peut executer cette commande.");
        return false;
    }
}


