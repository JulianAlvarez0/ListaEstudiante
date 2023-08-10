package com.interfaces;

import com.modelo.Estudiante;
import java.util.List;

public interface InterfaceCrudEstudiante {

    List listarEstudiante();
    Estudiante selectEstudiante(int id);
    boolean insertEstudiante(int id);
    boolean updateEstudiante(Estudiante estudiante);
    boolean deleteEstudiante(int id);
}
