package com.mycompany.ejercicio6;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SolucionEjercicio6 {

    public static void main(String[] args) throws IOException {

        String urlString = "https://www.w3schools.com/action_page.php";

        Map<String, String> datosFormulario = new HashMap<>();
        datosFormulario.put("nombre", "Juan Perez");
        datosFormulario.put("correo", "juan.perez@ejemplo.com");
        datosFormulario.put("mensaje", "Este es un mensaje de prueba enviado por Java.");

        String dataString = buildFormData(datosFormulario);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", String.valueOf(dataString.length()));
        connection.setDoOutput(true);

        try (OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8)) {
            osw.write(dataString);
            osw.flush();
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Formulario enviado exitosamente!");
        } else {
            System.out.println("Error al enviar formulario: Código " + responseCode);
        }

        connection.disconnect();
    }

    private static String buildFormData(Map<String, String> data) {
        StringBuilder formData = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            formData.append(entry.getKey());
            formData.append("=");
            formData.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            formData.append("&");
        }
        formData.deleteCharAt(formData.length() - 1);
        return formData.toString();
    }
}
