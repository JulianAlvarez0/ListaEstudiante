package com.modelo;


import com.configuracion.Conexion;
import com.interfaces.InterfaceCrudEstudiante;
import com.modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstudianteDAO implements InterfaceCrudEstudiante {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listarEstudiante() {
        List<Estudiante> estudianteList = new ArrayList<>();

        try {
            con = cn.getConexion();
            String selectAllEstudiantes = "SELECT * FROM estudiantes";
            ps = con.prepareStatement(selectAllEstudiantes);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellidos"));
                estudiante.setFechaCreacion(rs.getString("fechaCreacion"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumentos(rs.getString("documento"));
                estudianteList.add(estudiante);

            }

        } catch (SQLException e) {
            System.err.println("Fallo la conexion  " + e);

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

        }

        return estudianteList;
    }
    @Override
    public Estudiante selectEstudiante(int id) {
        Estudiante estudiante = new Estudiante();   
        try {
            con = cn.getConexion();
            String consultaEstudiantePorIdSql = "SELECT * FROM estudiantes where id=?";
            ps = con.prepareStatement(consultaEstudiantePorIdSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                estudiante.setId(rs.getInt("id"));
                estudiante.setFechaRegistro(rs.getString("fechaRegistro"));
                estudiante.setNombre(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellidos"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
            }

        } catch (SQLException e) {
            System.err.printf("Fallo de la conexion" + e);
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return estudiante;

    }
    
    public boolean insertEstudiante(Estudiante estudiante){
        try{
            con = cn.getConexion();
            String ConsultaGuardarEstudianteSql = "INSERT INTO estudiante"
                    +"(fechaRegistro,nombres,apellidos,celular,documento)VALUES ((now()),?,?,?,?";
            
            ps = con.prepareStatement(ConsultaGuardarEstudianteSql);
            ps.setString(2, estudiante.getNombres());
            ps.setString(3, estudiante.getApellidos());
            ps.setString(4, estudiante.getCelular());
            ps.setString(5, estudiante.getDocumento());
            return ps.execute();
        } catch (SQLException e){
              Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, e);
           return Boolean.FALSE;
        }
    }

    
    @Override
    public boolean updateEstudiante(Estudiante estudiante){
        try{
            con = cn.getConexion();
            String consultaActualizarEstudianteSql = "UPDATE estudiante SET nombres=?, apellidos=?, celular=?, documento=?";
            ps = con.prepareStatement(consultaActualizarEstudianteSql);
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCelular());
            ps.setString(4, estudiante.getDocumento());
            ps.setInt(5, estudiante.getId());
            ps.execute();
            return Boolean.TRUE;
        }catch (SQLException e) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, e);
            return Boolean.FALSE;
        }
    }
     @Override
    public boolean deleteEstudiante(int id) {
        try {
            con = cn.getConexion();
            String consultarEliminarEstudianteSql = "DELETE FROM estudiantes where id=?";
            ps.setInt(1, id);
            ps = con.prepareStatement(consultarEliminarEstudianteSql);
            ps.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException e) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, e);
            return Boolean.FALSE;   
        } 

    }

    @Override
    public boolean insertEstudiante(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

