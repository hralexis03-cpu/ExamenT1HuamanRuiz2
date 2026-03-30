package UtilsT1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class RegistroInscripcionesEventoServiceTest {
    private final RegistroInscripcionesEventoService service = new RegistroInscripcionesEventoService();

    //TEST DE REGISTRO EXITOSO
    @Test
    @DisplayName("Registro exitoso con todos los datos correctos")
    void testRegistroExitoso() {
        String hoy = LocalDate.now().toString();
        String resultado = service.registrar("E1234", "Alexis Huaman", "987654321", "alexis@gmail.com", hoy);
        System.out.println(resultado);
        assertEquals("La inscripción ha sido registrada correctamente", resultado);
    }

    //TEST DE CODIGO
    @Test
    @DisplayName("Error en formato de código")
    void testCodigoInvalido() {
        String resultado = service.registrar("A123", "Alexis", "987654321", "alexis@gmail.com", "2026-10-03");
        System.out.println(resultado);
        assertEquals("Ingrese un código de inscripción válido", resultado);
    }

    //TEST DE NOMBRE
    @Test
    @DisplayName("Error en nombre corto o no alfabético")
    void testNombreInvalido() {
        String resultado = service.registrar("E1234", "Ale", "987654321", "alexis@gmail.com", "2026-10-03");
        System.out.println(resultado);
        assertEquals("El nombre del participante debe tener al menos cuatro caracteres alfabéticos", resultado);
    }

    //TEST DE TELEFONO
    @Test
    @DisplayName("Error en teléfono que no tiene 9 dígitos")
    void testTelefonoInvalido() {
        String resultado = service.registrar("E1234", "Alexis Ruiz", "12345", "alexis@gmail.com", "2026-10-03");
        System.out.println(resultado);
        assertEquals("Ingrese un número de teléfono válido", resultado);
    }

    //TEST DE CORREO
    @Test
    @DisplayName("Error en correo sin @ o muy corto")
    void testCorreoInvalido() {
        String resultado = service.registrar("E1234", "Alexis Ruiz", "987654321", "a@m.c", "2026-10-03");
        System.out.println(resultado);
        assertEquals("Ingrese un correo electrónico válido", resultado);
    }

    //TEST DE FECHA
    @Test
    @DisplayName("Error en fecha anterior a hoy")
    void testFechaInvalida() {
        String ayer = LocalDate.now().minusDays(1).toString();
        String resultado = service.registrar("E1234", "Alexis Ruiz", "987654321", "alexis@gmail.com", ayer);
        System.out.println(resultado);
        assertEquals("Ingrese una fecha de evento válida", resultado);
    }

    //TEST DE CAMPOS VACIOS
    @Test
    @DisplayName("Error cuando falta algún campo")
    void testCamposVacios() {
        String resultado = service.registrar("", "Alexis", "987654321", "alexis@gmail.com", "2026-10-03");
        System.out.println(resultado);
        assertEquals("Debe ingresar todos los datos requeridos", resultado);
    }

}