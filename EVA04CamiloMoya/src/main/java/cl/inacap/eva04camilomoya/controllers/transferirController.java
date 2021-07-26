/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.controllers;

import cl.inacap.eva04camilomoya.dao.ClienteDAOImp;
import cl.inacap.eva04camilomoya.dao.MovimientosDAOImp;
import cl.inacap.eva04camilomoya.dao.TransferenciaControllerImp;
import cl.inacap.eva04camilomoya.dto.Cliente;
import cl.inacap.eva04camilomoya.dto.Cuenta;
import cl.inacap.eva04camilomoya.dto.Movimientos;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet("/transferirController.do")
public class transferirController extends HttpServlet {

    @Inject TransferenciaControllerImp transferir;
    @Inject ClienteDAOImp clientesDAO;
    @Inject MovimientosDAOImp movimientoDAO;
    
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
            int numerocta = cuenta.getNumerocta(); 
            request.setAttribute("numerocta", numerocta);
            request.setAttribute("cuenta", cuenta);
            request.setAttribute("client", cli);
            request.getRequestDispatcher("WEB-INF/vistas/transferir.jsp").forward(request, response);
        }
       
 
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errores = new ArrayList<String>();
        
        HttpSession session = request.getSession();
        Cliente cli = (Cliente) session.getAttribute("cliente");
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
        
        int numerocta = 0;
        int monto = 0;
        int montoAbs = 0;
        String clave = "";
       
        if(request.getParameter("destino-txt").trim().isEmpty()){
            errores.add("Ingrese un Numero de Destino");
        }else if(request.getParameter("destino-txt").trim().equalsIgnoreCase(String.valueOf(cuenta.getNumerocta()))){
            errores.add("No Puedes Transferir a tu Propia Cuenta!");
        }else{
             try{
             numerocta = Integer.parseInt(request.getParameter("destino-txt"));
        }catch(Exception e){
            errores.add("Ingrese un Numero de Cuenta Valido! Solo Numeros!");
        }
        }
       
        if(request.getParameter("monto-txt").trim().isEmpty()){
            errores.add("Ingrese un Monto Válido!");
        }else{
            try{
             monto = Integer.parseInt(request.getParameter("monto-txt"));
             montoAbs = Math.abs(monto);
        }catch(Exception e){
            errores.add("Ingrese un Monto Valido! Solo Numeros!");
        }
        }
        
        if(request.getParameter("clave-txt").trim().isEmpty()){
            errores.add("Debe ingresar su Clave de Cuenta!");
        }else if(cuenta.getClavetransaccion().equalsIgnoreCase(request.getParameter("clave-txt"))){
             clave = request.getParameter("clave-txt");
        }else{
            errores.add("La Clave de Transferencia no es Válida!");
        }
        
        
        int saldo = cuenta.getSaldo();
        int lineaCredito = cuenta.getSaldolineacredito();
        int lineaCreditoUsada = cuenta.getSaldolineacreditousado();
        
        
        
        if(errores.isEmpty()){
            
            try{
                Cuenta cuentaOri = new Cuenta();
                Cuenta cuentaDes = new Cuenta();

                if((saldo - montoAbs) < 0){
                    lineaCredito -= montoAbs ;
                    lineaCreditoUsada += montoAbs;
                    
                    cuentaOri.setNumerocta(cuenta.getNumerocta());
                    cuentaOri.setSaldo(saldo);
                    cuentaOri.setSaldolineacredito(lineaCredito);
                    cuentaOri.setSaldolineacreditousado(lineaCreditoUsada);
                    transferir.updateCuentaOrigen(cuentaOri);
                    transferir.updateLineaOrigen(cuentaOri);
                    
                    cuentaDes.setNumerocta(numerocta);
                    cuentaDes.setSaldo(montoAbs);
                    transferir.updateCuentaDestino(cuentaDes);
                    
                }else{
                    cuentaOri.setNumerocta(cuenta.getNumerocta());
                    cuentaOri.setSaldo(cuenta.getSaldo() - montoAbs);
                    cuentaOri.setSaldolineacredito(lineaCredito);
                    cuentaOri.setSaldolineacreditousado(lineaCreditoUsada);
                    transferir.updateCuentaOrigen(cuentaOri);
                    
                    
                   cuentaDes.setNumerocta(numerocta);
                   cuentaDes.setSaldo(montoAbs);
                   transferir.updateCuentaDestino(cuentaDes);
                }   

               

               Date fecha = new Date();

               Movimientos moviOrigen = new Movimientos();
               moviOrigen.setCuentaFK(cuentaOri);
               moviOrigen.setDescripcion("Transferencia por "+ montoAbs);
               moviOrigen.setFecha(fecha);


               Movimientos moviDest = new Movimientos();
               moviDest.setCuentaFK(cuentaDes);
               moviDest.setDescripcion("Deposito por $" + montoAbs);
               moviDest.setFecha(fecha);

               System.out.println(moviOrigen);
               System.out.println(moviDest);
               movimientoDAO.insertMovimiento(moviOrigen);
               movimientoDAO.insertMovimiento(moviDest);
            }catch(Exception ex){
                errores.add("Se Produjo un Problema en la Transaccion!");
            }
        }
        
        
        if(!errores.isEmpty()){
             request.setAttribute("errores", errores);
        }else{
            request.setAttribute("exito", "Transferencia Realizada con EXITO!");
        }
        
        doGet(request, response);
        
    }

   

}
