/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.ClienteBE;
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
    private ClienteDAO clienteDAO;

    public ClienteBL() {
        this.apiServiceSunat = new ApiService("https://apiperu.dev/api", "2fea3a9b6190f478789a8086ae70f6eef79facd762cdb4d2ce645e7fe20757aa");
        this.clienteDAO = new ClienteDAO();
    }

    public ClienteSunatDTO buscarClienteSunatDNI(String documento) {

        String path = "/dni/" + documento;
        ApiResponseDTO<ClienteSunatDTO> response = this.apiServiceSunat.methodGET(path, ClienteSunatDTO.class);

        return response.getData();
    }

    public ClienteBE buscarClientePorDocumento(int tipoDocumento, String documento) {
        return clienteDAO.ReadByDocumento(tipoDocumento, documento);
    }

    public ClienteBE buscarCliente(int tipoDocumento, String documento) {
        ClienteBE clienteBD = buscarClientePorDocumento(tipoDocumento, documento);

        if (clienteBD != null) {
            return clienteBD;
        }
        
        if(tipoDocumento != 1) //DNI
            return null;

        ClienteSunatDTO clienteSunat = buscarClienteSunatDNI(documento);

        return clienteSunat == null ? null : new ClienteBE(clienteSunat.getNombres(), clienteSunat.getApellidoPaterno() + " " + clienteSunat.getApellidoMaterno(), documento);
    }
    
    public ClienteBE obtenerPorId(String id) {
        return clienteDAO.Read(id);
    }

}
