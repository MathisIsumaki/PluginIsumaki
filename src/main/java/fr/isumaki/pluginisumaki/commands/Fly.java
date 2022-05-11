package fr.isumaki.pluginisumaki.commands;

import fr.isumaki.pluginisumaki.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return true;
            }
        Player player = (Player) sender;
        if (player.hasPermission("fly"));
            if(player.isFlying()) {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage("§4Fly off");
                return true;
            }else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage("§2Fly on");
            }
        return false;
    }
}