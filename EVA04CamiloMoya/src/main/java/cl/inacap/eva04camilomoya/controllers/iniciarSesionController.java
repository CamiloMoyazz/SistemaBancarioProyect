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
@WebServlet("/iniciarSesionController.do")
public class iniciarSesionController extends HttpServlet {

    @Inject
    ClienteDAOImp clienteDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/vistas/iniciarSesion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientes = clienteDAO.getAll();
        HttpSession session = request.getSession();
        String rut = request.getParameter("rut-txt");
        String clave = request.getParameter("password-txt");
        
        
        int pass = 0;

        if (rut != null) {
           
            for (Cliente c : clientes) {
                System.out.println(c);
                if (rut.equals(c.getRut()) && clave.equals(c.getClave())) {
                     Cliente cli = new Cliente();

                    pass++;
                    
                    cli.setRut(c.getRut());
                    cli.setNombre(c.getNombre());
                    cli.setApellido(c.getApellido());
                    cli.setCuentaList(c.getCuentaList());

                    session.setAttribute("cliente", cli);
    
                    request.getRequestDispatcher("miSaldoController.do").forward(request, response);
                }
            }
        }
        if(pass == 0){
            request.setAttribute("error", "Usuario Incorrecto!");
            doGet(request, response);
        }
        
    }

}
