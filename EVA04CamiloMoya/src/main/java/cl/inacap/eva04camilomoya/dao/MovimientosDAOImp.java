/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.dao;

import cl.inacap.eva04camilomoya.dto.Movimientos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Chalabera
 */
@Transactional()
public class MovimientosDAOImp implements MovimientosDAO{
     @PersistenceContext(unitName = "BANCO_PU")
    private EntityManager em;
    
    
    @Override
    public List<Movimientos> getMovimientos(int cuentaFK) {
        try{
            Query query = em.createQuery("FROM Movimientos m WHERE m.cuentaFK = :cuentaFK");
            query.setParameter("cuentaFK", cuentaFK);
           
            return query.getResultList();
        }catch(Exception ex){
             return null;
        }
         
    }

    @Override
    public void insertMovimiento(Movimientos movimiento) {

            Query query = em.createNativeQuery("INSERT INTO MOVIMIENTOS (fecha,descripcion,cuentaFK) VALUES(?,?,?)");
            query.setParameter(1, movimiento.getFecha());
            query.setParameter(2, movimiento.getDescripcion());
            query.setParameter(3, movimiento.getCuentaFK().getNumerocta());
            query.executeUpdate();
            
        
            System.out.println("Movimiento REGISTRADO!");
        
        
    }
    
}
