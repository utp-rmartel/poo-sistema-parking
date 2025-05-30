/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.UsuarioBE;
import DTOs.UsuarioLoginDto;
import DataAccessObject.UsuarioDAO;

/**
 *
 * @author Royss
 */
public class UsuarioBL {

    private UsuarioDAO usuarioDao;
    
    public UsuarioBL() {
        usuarioDao = new UsuarioDAO();
    }
    
    public UsuarioBE iniciarSesion(UsuarioLoginDto usuarioLoginDto) throws Exception {
        UsuarioBE usuario = usuarioDao.GetByUserName(usuarioLoginDto.getUsuario());
        String mensaje = "El usuario y/o contraseña invalidos";
        
        if(usuario == null || !usuario.getContrasenia().equals(usuarioLoginDto.getContrasenia()))
            throw new Exception(mensaje);
        
        return usuario;
    }
}
