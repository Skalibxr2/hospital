/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bd.Conexion;
import Models.Paciente;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

public class PacienteController {
    
    Conexion cx;
    HelperController hc = new HelperController();

    public PacienteController() {
        
        cx= new Conexion();
        cx.conectar();
    }
    
    public void agregarPaciente(int rut,String nombre,String fechaNac,String direccion,int numContacto){
        
        String query = "INSERT INTO `paciente` (rut_pac,nom_pac,fec_nac_pac,dir_pac,tel_pac) VALUES (?,?,?,?,?)";
        
        try {
            //java.sql.Date fecha = new java.sql.Date(fechaNac);
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            st.setInt(1, rut);
            st.setString(2, nombre);
            st.setString(3, fechaNac);
            st.setString(4, direccion);
            st.setInt(5, numContacto);
            st.executeUpdate();
            hc.showInformation("Paciente agregado con exito");
            
        } catch (Exception e) {
            hc.showError("error: "+ e.getMessage());
        }
        
    }
    
    public Paciente buscarPacientePorId(int id){
        
        Paciente pacienteEncontrado = null;
        
        String query = "SELECT * FROM `paciente` WHERE rut_pac = "+id;
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            if(rs.next()){
                pacienteEncontrado = new Paciente();
                pacienteEncontrado.setRut(rs.getInt("rut_pac"));
                pacienteEncontrado.setNombre(rs.getString("nom_pac"));
                pacienteEncontrado.setFechaNacimiento(rs.getDate("fec_nac_pac"));
                pacienteEncontrado.setDireccion(rs.getString("dir_pac"));
                pacienteEncontrado.setNumeroContacto(rs.getInt("tel_pac"));
                
                
            }
        } catch (Exception e) {
            hc.showError("error: "+e.getMessage());
        }
                
        return pacienteEncontrado;
        
    }
    
    
    
    
    
    
    
    
}
