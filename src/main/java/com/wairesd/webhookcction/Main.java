package com.wairesd.webhookcction;

import com.wairesd.webhookcction.discord.webhook.Send;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
       new Send().main();
    }

    @Override
    public void onDisable() {

    }
}
