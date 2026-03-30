package UtilsT1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroInscripcionesEventoService {
    private final List<RegistroInscripcionesEvento> inscripciones = new ArrayList<>();

    public String registrar(String codigo, String nombre, String telefono, String correo, String fechaStr) {

        // CAMPOS VACIOS
        if (isAnyEmpty(codigo, nombre, telefono, correo, fechaStr)) {
            return "Debe ingresar todos los datos requeridos";
        }

        // 1 VALIDAR CODIGO
        if (!codigo.matches("^E\\d{4}$")) {
            return "Ingrese un código de inscripción válido";
        }

        // 2 VALIDAR NOMBRE
        if (!nombre.matches("^[a-zA-Z\\s]{4,}$")) {
            return "El nombre del participante debe tener al menos cuatro caracteres alfabéticos";
        }

        // 3 VALIDAR TELEFONO
        if (!telefono.matches("^\\d{9}$")) {
            return "Ingrese un número de teléfono válido";
        }

        // 4 VALIDAR CORREO
        if (!correo.contains("@") || correo.length() < 8) {
            return "Ingrese un correo electrónico válido";
        }

        // 5 VALIDAR FECHA
        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            if (fecha.isBefore(LocalDate.now())) {
                return "Ingrese una fecha de evento válida";
            }

            // EXITO
            RegistroInscripcionesEvento nueva = new RegistroInscripcionesEvento(codigo, nombre, telefono, correo, fecha);
            inscripciones.add(nueva);
            return "La inscripción ha sido registrada correctamente";

        } catch (Exception e) {
            return "Ingrese una fecha de evento válida";
        }
    }

    private boolean isAnyEmpty(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) return true;
        }
        return false;
    }

    public List<RegistroInscripcionesEvento> getInscripciones() {
        return inscripciones;
    }
}
