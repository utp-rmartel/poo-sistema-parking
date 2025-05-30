/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTOs.ApiResponseDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.*;

/**
 *
 * @author Royss
 */
public class ApiService {

    private String BASE_URL = "";
    private final HttpClient httpClient;
    private final Gson gson;
    private String Token = "2fea3a9b6190f478789a8086ae70f6eef79facd762cdb4d2ce645e7fe20757aa";

    public ApiService(String baseUrl) {
        this.BASE_URL = baseUrl;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public <T> ApiResponseDTO<T> methodGET(String path, Class<T> clase) {
        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + path))
                    .header("Accept", "application/json")
                    .header("User-Agent", "Java-HttpClient")
                    .header("Authorization", "Bearer " + Token)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error HTTP: " + response.statusCode());
            }
            Type responseType = TypeToken.getParameterized(ApiResponseDTO.class, clase).getType();
            return gson.fromJson(response.body(), responseType);

        } catch (Exception e) {
            System.err.println("Error al consultar: " + e.getMessage());
            throw new RuntimeException("Error en consulta de ApiService", e);
        }
    }

}
