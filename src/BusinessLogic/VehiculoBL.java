/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.VehiculoBE;
import DTOs.ApiResponseDTO;
import DTOs.VehiculoSunarpDTO;
import DataAccessObject.VehiculoDAO;
import Services.ApiService;

/**
 *
 * @author Royss
 */
public class VehiculoBL {

    private ApiService apiServiceSunarp;
    private VehiculoDAO vehiculoDAO;

    public VehiculoBL() {
        this.apiServiceSunarp = new ApiService("http://localhost:8000","");
        vehiculoDAO = new VehiculoDAO();
    }

    public VehiculoSunarpDTO buscarVehiculoSunarp(String placa) {

        String path = "/consulta-vehiculo?placa=" + placa;
        ApiResponseDTO<VehiculoSunarpDTO> response = this.apiServiceSunarp.methodGET(path, VehiculoSunarpDTO.class);
        
        return response.getData();
    }
    
    public VehiculoBE buscarVehiculoPorPlaca(String placa) {
        return vehiculoDAO.ReadByPlaca(placa);
    }
    
    public VehiculoBE buscarVehiculo(String placa) {
        VehiculoBE vehiculoBD = buscarVehiculoPorPlaca(placa);

        if (vehiculoBD != null) {
            return vehiculoBD;
        }

        VehiculoSunarpDTO vehiculoSunarp = buscarVehiculoSunarp(placa);
        

        return vehiculoSunarp == null ? null : new VehiculoBE(placa, vehiculoSunarp.getMarca(), vehiculoSunarp.getModelo(), vehiculoSunarp.getColor(), null);
    }
    
    public VehiculoBE obtenerPorId(String id) {
        return vehiculoDAO.Read(id);
    }

}
