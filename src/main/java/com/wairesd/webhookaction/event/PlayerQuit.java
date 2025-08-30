package com.wairesd.webhookaction.event;

import com.wairesd.webhookaction.discord.webhook.Send;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void PlayerQuit (PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();

        Send send = new Send();
        send.send("Игрок " + playerName + " вышел на сервер");
    }
}
