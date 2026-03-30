    package UtilsT1;

    import java.time.LocalDate;

    public class RegistroInscripcionesEvento {
        private String codigo;
        private String nombre;
        private String telefono;
        private String correo;
        private LocalDate fechaEvento;

        public RegistroInscripcionesEvento(String codigo, String nombre, String telefono, String correo, LocalDate fechaEvento) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.telefono = telefono;
            this.correo = correo;
            this.fechaEvento = fechaEvento;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public LocalDate getFechaEvento() {
            return fechaEvento;
        }

        public void setFechaEvento(LocalDate fechaEvento) {
            this.fechaEvento = fechaEvento;
        }
    }
