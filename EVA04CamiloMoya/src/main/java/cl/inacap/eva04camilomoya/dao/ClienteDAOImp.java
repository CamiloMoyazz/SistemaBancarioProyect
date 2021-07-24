/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.dao;

import cl.inacap.eva04camilomoya.dto.Cliente;
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
public class ClienteDAOImp implements ClienteDAO{
    
    @PersistenceContext(unitName = "BANCO_PU")
    private EntityManager em;

    @Override
    public List<Cliente> getAll() {
        return em.createNamedQuery("Cliente.findAll").getResultList();
    }

    @Override
    public String getPassword(String rut) {
        Query query = em.createQuery("FROM cliente c where c.rut = :rut");
        query.setParameter("rut", "%" + rut + "%");
        return (String) query.getSingleResult();
    }

    @Override
    public Cliente getCliente(String rut) {
        try{
            Query query = em.createQuery("FROM Cliente c WHERE c.rut = :rut");
            query.setParameter("rut", rut);
            return (Cliente) query.getSingleResult();
        }catch(Exception ex){
            return null;
        }
    }

    
    
    
}
