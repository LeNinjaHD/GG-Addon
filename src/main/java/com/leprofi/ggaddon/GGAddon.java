package com.leprofi.ggaddon;

import com.leprofi.ggaddon.listener.ChatListener;
import com.leprofi.ggaddon.utils.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GGAddon extends JavaPlugin {

    @Override
    public void onEnable() {
        int pluginId = 13067;
        Metrics metrics = new Metrics(this, pluginId);

        if(Bukkit.getPluginManager().getPlugin("MBedwars") == null) {
            getLogger().info("MBedWars Was not found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
