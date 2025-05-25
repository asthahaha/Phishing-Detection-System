import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostRequestExample {
    public static void main(String[] args) {
        try {
            // Define the API endpoint
            URL url = new URL("http://127.0.0.1:5000/predict");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            conn.setRequestMethod("POST");

            // Set request headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create JSON payload
            JSONObject payload = new JSONObject();
            ((Object) payload).put("text", "This is a test message");
            ((Object) payload).put("numeric_features", new double[]{1.0, 2.0, 3.0});

            // Write JSON payload to the request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = payload.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read the response from the API
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Response from API: " + response.toString());
                }
            } else {
                System.out.println("Error: HTTP response code " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
