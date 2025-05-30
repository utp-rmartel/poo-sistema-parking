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

    private ApiService apiService;
    private ClienteDAO clienteDAO;

    public ClienteBL() {
        this.apiService = new ApiService("https://apiperu.dev/api");
        this.clienteDAO = new ClienteDAO();
    }

    public ClienteSunatDTO buscarClienteDNI(String numeroDocumento) {

        String path = "/dni/" + numeroDocumento;
        ApiResponseDTO<ClienteSunatDTO> response = this.apiService.methodGET(path, ClienteSunatDTO.class);
        
        return response.getData();
    }

}
