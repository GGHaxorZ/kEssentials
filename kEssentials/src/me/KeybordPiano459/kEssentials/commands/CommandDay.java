package me.KeybordPiano459.kEssentials.commands;

import java.util.logging.Level;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDay extends kCommand {
    public CommandDay(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kessentials.day")) {
                if (args.length == 0) {
                    World world = player.getWorld();
                    world.setTime(0);
                    player.sendMessage(GREEN + "It is now daytime in the world " + YELLOW + world.getName());
                } else if (args.length == 1) {
                    World world = Bukkit.getServer().getWorld(args[0]);
                    if (world != null) {
                        world.setTime(0);
                        player.sendMessage(GREEN + "It is now daytime in the world " + YELLOW + world.getName());
                    } else {
                        player.sendMessage(RED + "The world " + YELLOW + args[0] + RED + " is nonexistant.");
                    }
                } else {
                    incorrectUsage(player, "/day [world]");
                }
            } else {
                noPermissionsMessage(player);
            }
        } else {
            if (args.length == 1) {
                World world = Bukkit.getServer().getWorld(args[0]);
                if (world != null) {
                    world.setTime(0);
                    log(Level.INFO, "It is now daytime in the world " + world.getName());
                } else {
                    log(Level.INFO, "The world " + args[0] + " is nonexistant.");
                }
            } else {
                incorrectUsageC("/day <world>");
            }
        }
        return false;
    }
}