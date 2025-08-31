package com.wairesd.webhookaction.discord.webhook;

import com.wairesd.webhookaction.Main;
import com.wairesd.webhookaction.config.configurators.Settings;
import org.bukkit.Bukkit;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Send {
    public static void send(String content) {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            String webhookUrl = Settings.getWebhookUrl();
            try {
                URL url = new URL(webhookUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json; utf-8");
                con.setRequestProperty("Accept", "application/json");
                con.setDoOutput(true);
                String safeContent = content.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
                String jsonInputString = "{" +
                        "\"username\": \"Bot\"," +
                        "\"content\": \"" + safeContent + "\"" +
                        "}";

                try (OutputStream os = con.getOutputStream()) {
                    os.write(jsonInputString.getBytes(StandardCharsets.UTF_8));
                }

                int responseCode = con.getResponseCode();
                if (Settings.isDebugMode()) {
                    Bukkit.getLogger().info("Webhook response: " + responseCode);
                }

                con.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
