import com.google.gson.JsonObject;
import java.util.Map;

public class ConversorDivisas {
    public static double obtenerTasaCambio(String divisaOrigen, String divisaDestino) throws Exception {
        JsonObject jsonobj = API.obtenerDatos(divisaOrigen, divisaDestino);
        return jsonobj.get("conversion_rate").getAsDouble();
    }

    public double convertir(double cantidad, String divisaOrigen, String divisaDestino) throws Exception {
        double tasaCambio = obtenerTasaCambio(divisaOrigen, divisaDestino);
        return cantidad * tasaCambio;
    }
}
