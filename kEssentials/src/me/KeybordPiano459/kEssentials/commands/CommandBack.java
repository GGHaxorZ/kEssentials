package me.KeybordPiano459.kEssentials.commands;

import me.KeybordPiano459.kEssentials.helpers.Back;
import me.KeybordPiano459.kEssentials.kEssentials;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBack extends kCommand {
    public CommandBack(kEssentials plugin) {
        super(plugin);
    }
    
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("kessentials.back")) {
                    if (Back.getBackLocation(player) != null) {
                        player.teleport(Back.getBackLocation(player));
                        player.sendMessage(GREEN + "You have teleported to your last location.");
                    } else {
                        player.sendMessage(RED + "There isn't a location to go back to.");
                    }
                } else {
                    noPermissionsMessage(player);
                }
            } else {
                incorrectUsage(player, "/back");
            }
        } else {
            consoleError();
        }
        return false;
    }
}