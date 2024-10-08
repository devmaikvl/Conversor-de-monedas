import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        String monedaActual;
        String monedaSolicitada;
        Double cantidad;



        while (true) {
            System.out.println("""
                    Seleccione opción de tu moneda actual:\s
                    1. Dólares
                    2. Euros
                    3. Dólar Australiano
                    4. Lev Búlgaro
                    5. Dólar Canadiense""");
            var opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Elegiste Dólares");
                    monedaActual = "USD";
                    break;
                case 2:
                    System.out.println("Elegiste Euros");
                    monedaActual = "EUR";
                    break;
                case 3:
                    System.out.println("Elegiste Dólar Australiano");
                    monedaActual = "AUD";
                    break;
                case 4:
                    System.out.println("Elegiste Lev Búlgaro.");
                    monedaActual = "BGN";
                    break;
                case 5:
                    System.out.println("Elegiste Dólar Canadiense");
                    monedaActual = "CAD";
                    break;
                default:
                    System.out.println("Número no válido. Inténtalo de nuevo.");
                    continue;
            }

            break;
        }



        while (true) {
            System.out.println("""
                    Seleccione opción de tu moneda a convertir:\s
                    1. Dólares
                    2. Euros
                    3. Dólar Australiano
                    4. Lev Búlgaro
                    5. Dólar Canadiense""");
            var opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Elegiste Dólares");
                    monedaSolicitada = "USD";
                    break;
                case 2:
                    System.out.println("Elegiste Euros");
                    monedaSolicitada = "EUR";
                    break;
                case 3:
                    System.out.println("Elegiste Dólar Australiano");
                    monedaSolicitada = "AUD";
                    break;
                case 4:
                    System.out.println("Elegiste Lev Búlgaro.");
                    monedaSolicitada = "BGN";
                    break;
                case 5:
                    System.out.println("Elegiste Dólar Canadiense");
                    monedaSolicitada = "CAD";
                    break;
                default:
                    System.out.println("Número no válido. Inténtalo de nuevo.");
                    continue;
            }

            break;
        }



        System.out.println("Digite la cantidad");
        cantidad = lectura.nextDouble();










        String direccion = "https://v6.exchangerate-api.com/v6/4ac7adae82d2ff4634c33563/latest/"+monedaActual;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionesJson = jsonObject.getAsJsonObject("conversion_rates");


        double usd = conversionesJson.get("USD").getAsDouble();
        double eur = conversionesJson.get("EUR").getAsDouble();
        double cad = conversionesJson.get("CAD").getAsDouble();
        double bgn = conversionesJson.get("BGN").getAsDouble();
        double aud = conversionesJson.get("AUD").getAsDouble();


        Conversiones conversiones = new Conversiones(usd, eur, cad, bgn, aud);

        switch (monedaSolicitada) {
            case "USD" -> System.out.println("Resultado: " + cantidad * conversiones.getUSD());
            case "EUR" -> System.out.println("Resultado: " + cantidad * conversiones.getEUR());
            case "CAD" -> System.out.println("Resultado: " + cantidad * conversiones.getCAD());
            case "BGN" -> System.out.println("Resultado: " + cantidad * conversiones.getBGN());
            case "AUD" -> System.out.println("Resultado: " + cantidad * conversiones.getAUD());
        }



    }
}