package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandEnderchest extends kCommand {
    public CommandEnderchest(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.enderchest")) {
                    Inventory inv = player.getEnderChest();
                    player.openInventory(inv);
                    player.sendMessage(GREEN + "You are now viewing your enderchest.");
                } else {
                    noPermissionsMessage(player);
                }
            } else if (args.length == 1) {
                if (player.hasPermission("kessentials.enderchest")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        Inventory inv = tplayer.getEnderChest();
                        player.openInventory(inv);
                        player.sendMessage(GREEN + "You are now viewing " + YELLOW + tplayer.getName() + GREEN + "'s enderchest.");
                    } else {
                        player.sendMessage(RED + args[0] + " is not online.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/enderchest [player]");
            }
        } else {
            consoleError();
        }
        return false;
    }
}