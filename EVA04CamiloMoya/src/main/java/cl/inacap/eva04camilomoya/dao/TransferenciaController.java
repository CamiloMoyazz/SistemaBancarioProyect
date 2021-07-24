/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.dao;

import cl.inacap.eva04camilomoya.dto.Cuenta;
import java.util.List;

/**
 *
 * @author Chalabera
 */
public interface TransferenciaController {
    
    public void updateCuentaOrigen(Cuenta cuenta);
    public void updateLineaOrigen(Cuenta cuenta);
    public void updateCuentaDestino(Cuenta cuenta);
    public List<Cuenta> findCuenta(int numeroCuenta);
}
