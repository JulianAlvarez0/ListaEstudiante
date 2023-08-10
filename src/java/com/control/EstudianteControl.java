/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.control;

import com.modelo.Estudiante;
import com.modelo.EstudianteDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;


public class EstudianteControl extends HttpServlet {
    EstudianteDAO estudianteDao = new EstudianteDAO();
    Estudiante estudiante = new Estudiante();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("ISO-8859-1");
        String nombres,apellidos,celular,documento;
        String accion = request.getParameter("accion");
        
        switch (accion){
            case"guardar":
                nombres = request.getParameter("txtNombre");
                apellidos = request.getParameter("txtApellido");
                celular = request.getParameter("txtCelular");
                documento = request.getParameter("txtDocumento");
                
                if(nombres.isEmpty() && !!apellidos.isEmpty() && !celular.isEmpty() && !documento.isEmpty()){
                    estudiante.setNombres(nombres);
                    estudiante.setApellidos(apellidos);
                    estudiante.setCelular(celular);
                    estudiante.setDocumento(documento);
                    boolean respuestaBaseDeDatos = estudianteDao.insertEstudiante(estudiante);
                    if (respuestaBaseDeDatos){
                        request.setAttribute("mensaje", "Se ha realizado el guardado del estudiante con exito");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "No se logro guardar el estudiante");
                        
                    }
                }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
