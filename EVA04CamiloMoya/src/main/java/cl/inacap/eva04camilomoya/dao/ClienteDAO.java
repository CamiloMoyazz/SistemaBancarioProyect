/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.dao;

import cl.inacap.eva04camilomoya.dto.Cliente;
import java.util.List;

/**
 *
 * @author Chalabera
 */
public interface ClienteDAO {
    
   public List<Cliente> getAll();
   public String getPassword(String rut);
   public Cliente getCliente(String rut);
    
}
