/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import DTOs.ApiResponseDTO;
import DTOs.VehiculoSunarpDTO;
import Services.ApiService;

/**
 *
 * @author Royss
 */
public class VehiculoBL {

    private ApiService apiServiceSunarp;

    public VehiculoBL() {
        this.apiServiceSunarp = new ApiService("http://localhost:8000");
    }

    public VehiculoSunarpDTO buscarVehiculoPorPlaca(String placa) {

        String path = "/consulta-vehiculo?placa=" + placa;
        ApiResponseDTO<VehiculoSunarpDTO> response = this.apiServiceSunarp.methodGET(path, VehiculoSunarpDTO.class);
        
        return response.getData();
    }

}
