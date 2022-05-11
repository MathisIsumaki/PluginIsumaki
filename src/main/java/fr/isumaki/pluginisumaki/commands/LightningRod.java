package fr.isumaki.pluginisumaki.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LightningRod implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Seul un joueur peut executer cette commande");
            return false;
        }
        Player player = (Player) sender;
        if (args.length >= 1) {
            player.sendMessage("§4Cette commande n'éxiste pas");
            return false;
        }
        player.sendMessage("§2 Vous avez reçu le Lighting Rod");
        ItemStack LightningRod = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta customM = LightningRod.getItemMeta();
        customM.setDisplayName("§6Lightning Rod");
        customM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_ENCHANTS);
        customM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true);
        LightningRod.setItemMeta(customM);
        player.getInventory().addItem(LightningRod);
        player.getWorld();


        return false;

    }
}
