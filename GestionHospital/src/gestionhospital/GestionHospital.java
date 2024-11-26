/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionhospital;

import Bd.Conexion;
import Views.AgregarPaciente;
import Views.MenuPrincipal;

/**
 *
 * @author Cetecom
 */
public class GestionHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuPrincipal menu = new MenuPrincipal();
        //menu.setVisible(true);
        AgregarPaciente p = new AgregarPaciente();
        p.setVisible(true);
        Conexion cx = new Conexion();
        cx.conectar();
        
        
    }
    
}
