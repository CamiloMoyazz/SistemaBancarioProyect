/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.controllers;

import cl.inacap.eva04camilomoya.dao.ClienteDAOImp;
import cl.inacap.eva04camilomoya.dto.Cliente;
import cl.inacap.eva04camilomoya.dto.Cuenta;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chalabera
 */
@WebServlet("/miSaldoController.do")
public class miSaldoController extends HttpServlet {

    @Inject ClienteDAOImp clientesDAO;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cliente cli = null;
        if(session.getAttribute("cliente") == null){
            request.getRequestDispatcher("iniciarSesionController.do").forward(request, response);
        }else{
            cli = (Cliente) session.getAttribute("cliente");
        }
        
        Cliente cliente = clientesDAO.getCliente(cli.getRut());
        System.out.println(cliente);
        Cuenta cuenta = new Cuenta();
        if(cliente != null){
             for (Cuenta cu : cliente.getCuentaList()) {
                        cuenta.setNumerocta(cu.getNumerocta());
                        cuenta.setClavetransaccion(cu.getClavetransaccion());
                        cuenta.setSaldo(cu.getSaldo());
                        cuenta.setSaldolineacredito(cu.getSaldolineacredito());
                        cuenta.setSaldolineacreditousado(cu.getSaldolineacreditousado());
                    }
        }
        
        
        if(cuenta != null){
           request.setAttribute("cuenta", cuenta);
        }
       
        request.getSession().setAttribute("client", cli);
        
        
        
        request.getRequestDispatcher("WEB-INF/vistas/miSaldo.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   

}
