import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class API {
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "YOUR_API_KEY";

    public static JsonObject obtenerDatos(String DivisaOrigen, String divisaDestino) throws Exception {
        String urlFinal = URL_BASE + API_KEY + "/pair/" + DivisaOrigen+ "/" + divisaDestino;
        URL url = new URL(urlFinal);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String resultadoSolicitud = jsonobj.get("result").getAsString();
        if (!"success".equals(resultadoSolicitud)) {
            throw new IllegalStateException("Error en la solicitud a la API: " + resultadoSolicitud);
        }

        return jsonobj;
    }
    public static List<String[]> obtenerDivisasSoportadas() throws Exception {
        String urlFinal = URL_BASE + API_KEY + "/codes";
        URL url = new URL(urlFinal);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String resultadoSolicitud = jsonobj.get("result").getAsString();
        if (!"success".equals(resultadoSolicitud)) {
            throw new IllegalStateException("Error en la solicitud a la API: " + resultadoSolicitud);
        }

        List<String[]> divisasSoportadas = new ArrayList<>();
        JsonArray supportedCodes = jsonobj.getAsJsonArray("supported_codes");
        for (JsonElement elemento : supportedCodes) {
            JsonArray par = elemento.getAsJsonArray();
            String codigo = par.get(0).getAsString();
            String nombre = par.get(1).getAsString();
            divisasSoportadas.add(new String[]{codigo, nombre});
        }

        return divisasSoportadas;
    }
}
