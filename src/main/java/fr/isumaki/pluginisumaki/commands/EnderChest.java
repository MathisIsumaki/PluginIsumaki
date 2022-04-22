package fr.isumaki.pluginisumaki.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            //      /ec <player>

            if (args.length == 0){
                ((Player) sender).openInventory(((Player) sender).getEnderChest());
            }else{
                Player playerec = Bukkit.getPlayer(args[0]);
                if(playerec != null){
                    ((Player)sender).openInventory(playerec.getEnderChest());
                }else sender.sendMessage("Ce joueur n'est pas connecté");
            }


        }else System.out.println("Une erreur est survenue, seul un joueur peu executer cette commande");


        return false;
    }
}
