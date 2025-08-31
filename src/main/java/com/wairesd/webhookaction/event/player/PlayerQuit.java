package com.wairesd.webhookaction.event.player;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();

        Send.send("Игрок " + playerName + " вышел с сервер");
    }
}
