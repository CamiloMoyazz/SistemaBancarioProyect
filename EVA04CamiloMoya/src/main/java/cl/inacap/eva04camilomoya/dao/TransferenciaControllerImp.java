/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.dao;

import cl.inacap.eva04camilomoya.dto.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Chalabera
 */

@Transactional
public class TransferenciaControllerImp implements TransferenciaController{
    
     @PersistenceContext(unitName = "BANCO_PU")
    private EntityManager em;
     
  

    @Override
    public List<Cuenta> findCuenta(int numeroCuenta) {
        return em.createNamedQuery("Cuenta.findByNumerocta").setParameter("numerocta", numeroCuenta).getResultList();
    }

    @Override
    public void updateCuentaOrigen(Cuenta cuenta) {
        try{
            
            Query query = em.createQuery("UPDATE Cuenta c SET c.saldo = :saldo WHERE c.numerocta = :numerocta ");
            query.setParameter("saldo", cuenta.getSaldo());
            query.setParameter("numerocta", cuenta.getNumerocta());
            
            query.executeUpdate();
            
            System.out.println("EHHH!!! Se agrego!");
            
        }catch(Exception ex){
            System.out.println("HEYY!! Error PAAH");
        }
    }

    @Override
    public void updateCuentaDestino(Cuenta cuenta) {
         
            
             Query query = em.createQuery("UPDATE Cuenta c SET c.saldo = c.saldo + :monto WHERE c.numerocta = :numerocta");
             query.setParameter("monto", cuenta.getSaldo());
             query.setParameter("numerocta", cuenta.getNumerocta());
             
             query.executeUpdate();
             System.out.println("EHHH!!! se Agrego!!");
       
    }

    @Override
    public void updateLineaOrigen(Cuenta cuenta) {
          try{
            
             Query query = em.createQuery("UPDATE Cuenta c SET c.saldolineacredito = :saldolineacredito , c.saldolineacreditousado = :saldolineacreditousado WHERE c.numerocta = :numerocta");
             query.setParameter("saldolineacredito", cuenta.getSaldolineacredito());
             query.setParameter("saldolineacreditousado", cuenta.getSaldolineacreditousado());
             query.setParameter("numerocta", cuenta.getNumerocta());
             
             query.executeUpdate();
             
             System.out.println("EHHH!!! se Agrego la Lineeaa!!");
        }catch(Exception ex){
            System.out.println("HEYY!! Error PAAH en linea paa");
        }
    }
    
}
