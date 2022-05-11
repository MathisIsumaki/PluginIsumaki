package fr.isumaki.pluginisumaki;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashSet;
import java.util.Set;

import static sun.audio.AudioPlayer.player;


public class RegisterEvents implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        event.setJoinMessage(playerName + " vient de se connecter");
    }
        @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        event.setQuitMessage(playerName + " vient de quitter");
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getItem() == null) return;
        Player player = event.getPlayer();
        if (event.getItem().getType() == Material.CARROT_ITEM) {
            Inventory inv = Bukkit.createInventory(null, 54, "Player List");
            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
            ItemMeta glassm = glass.getItemMeta();
            glassm.setDisplayName(" ");
            glass.setItemMeta(glassm);
            inv.setItem(0, glass);
            inv.setItem(1, glass);
            inv.setItem(2, glass);
            inv.setItem(3, glass);
            inv.setItem(4, glass);
            inv.setItem(5, glass);
            inv.setItem(6, glass);
            inv.setItem(7, glass);
            inv.setItem(8, glass);
            inv.setItem(9, glass);
            inv.setItem(17, glass);
            inv.setItem(18, glass);
            inv.setItem(26, glass);
            inv.setItem(27, glass);
            inv.setItem(35, glass);
            inv.setItem(36, glass);
            inv.setItem(44, glass);
            inv.setItem(45, glass);
            inv.setItem(46, glass);
            inv.setItem(47, glass);
            inv.setItem(48, glass);
            inv.setItem(49, glass);
            inv.setItem(50, glass);
            inv.setItem(51, glass);
            inv.setItem(52, glass);
            inv.setItem(53, glass);
            Bukkit.getOnlinePlayers().forEach(p -> {
                ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta skullm = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                skullm.setDisplayName(p.getName());
                skullm.setOwner(p.getName());
                skull.setItemMeta(skullm);
                inv.addItem(skull);

            });

            event.getPlayer().openInventory(inv);

        }
        if (event.getItem().hasItemMeta() && event.getItem().getItemMeta().getDisplayName().equals("§6Lightning Rod")) {
            player.getWorld().strikeLightning(player.getTargetBlock(new HashSet<Material>() {{
                add(Material.AIR);
            }}, 300).getLocation().add(0.0, 1, 0.0));
        }
    }



    @EventHandler
    public void onInventoryClick(InventoryPickupItemEvent event) {
        if (event.getInventory().getName() == "Player List") {
            event.setCancelled(true);

        }
    }
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractEntityEvent e) {
        if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().hasItemMeta()
                && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("§6Lightning Rod"))
            e.getPlayer().getWorld().strikeLightning(e.getRightClicked().getLocation());


    }
}