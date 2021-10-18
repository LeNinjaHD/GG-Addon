package com.leprofi.ggaddon.listener;

import com.leprofi.ggaddon.GGAddon;
import de.marcely.bedwars.api.GameAPI;
import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.arena.ArenaStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {
    GGAddon main;

    public ChatListener(GGAddon instance) {
        main = instance;
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        String msg = event.getMessage();
        Player player = event.getPlayer();

        if(msg.equalsIgnoreCase("gg")) {
            Arena arena = GameAPI.get().getArenaByPlayer(player);

            if(arena != null && arena.getStatus().equals(ArenaStatus.END_LOBBY)) {
                    Bukkit.getServer().dispatchCommand(main.getServer().getConsoleSender(), "say hi");
            }

        }
    }
}
