package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandOnline extends kCommand {
    public CommandOnline(kEssentials plugin) {
        super(plugin);
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kessentials.online")) {
                    Player tplayer = Bukkit.getServer().getPlayer(args[0]);
                    if (tplayer != null) {
                        player.sendMessage(GREEN + player.getName() + " is online!");
                    } else {
                        player.sendMessage(RED + args[0] + " is offline.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/online <player>");
            }
        } else {
            if (args.length == 1) {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (player != null) {
                    log(Level.INFO, player.getName() + " is online!");
                } else {
                    log(Level.INFO, args[0] + " is offline.");
                }
            } else {
                incorrectUsageC("/online <player>");
            }
        }
        return false;
    }
}