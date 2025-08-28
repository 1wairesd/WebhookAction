package com.wairesd.webhookaction.discord.webhook;

import com.wairesd.webhookaction.config.configurators.Settings;
import com.wairesd.webhookaction.tools.message.error.webhook.SendError;
import com.wairesd.webhookaction.tools.message.error.webhook.SendNotFound;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Send {
    public void main(String content) {
        String webhookUrl = Settings.getWebhookUrl();
        if (SendNotFound.check(webhookUrl)) return;

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{"
                    + "\"username\": \"Bot\","
                    + "\"content\": \"" + content + "\""
                    + "}";

            try (OutputStream os = con.getOutputStream()) {
                os.write(jsonInputString.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = con.getResponseCode();
            SendError.handle(responseCode);

            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
