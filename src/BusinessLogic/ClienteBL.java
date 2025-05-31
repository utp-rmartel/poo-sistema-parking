/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import DTOs.ApiResponseDTO;
import DTOs.ClienteSunatDTO;
import DataAccessObject.ClienteDAO;
import Services.ApiService;

/**
 *
 * @author Royss
 */
public class ClienteBL {

    private ApiService apiServiceSunat;
    private ApiService apiServiceSunarp;
    private ClienteDAO clienteDAO;

    public ClienteBL() {
        this.apiServiceSunat = new ApiService("https://apiperu.dev/api");
        this.apiServiceSunarp = new ApiService("http://localhost:8000");
        this.clienteDAO = new ClienteDAO();
    }

    public ClienteSunatDTO buscarClienteDNI(String numeroDocumento) {

        String path = "/dni/" + numeroDocumento;
        ApiResponseDTO<ClienteSunatDTO> response = this.apiServiceSunat.methodGET(path, ClienteSunatDTO.class);
        
        return response.getData();
    }

}
