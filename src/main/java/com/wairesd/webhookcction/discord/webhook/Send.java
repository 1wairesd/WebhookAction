package com.wairesd.webhookcction.discord.webhook;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Send {
    public void main() {
        try {
            URL url = new URL("https://discord.com/api/webhooks/1409858902761410651/LTBabVyN-xXo_aP4JiK5FPtbEP_dd6mOz-4k9HMDwpjlZSIlG7YD_695Iu8bT5wFs7Zm");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            String jsonInputString = "{" +
                    "\"username\": \"Bot\", " +
                    "\"content\": \"Hello World\"" +
                    "}";

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            System.out.println("Webhook sent, response code: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
