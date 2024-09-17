package model;

import java.time.LocalDateTime;

public class Alerta {
    private String mensaje;
    private boolean urgente;
    private boolean leida;
    private LocalDateTime fechaExpiracion;

    public Alerta(String mensaje, boolean urgente, LocalDateTime fechaExpiracion) {
        this.mensaje = mensaje;
        this.urgente = urgente;
        this.leida = false;
        this.fechaExpiracion = fechaExpiracion;
    }

    public void marcarLeida() {
        this.leida = true;
    }

    public boolean isLeida() {
        return leida;
    }

    public boolean esExpirada() {
        return LocalDateTime.now().isAfter(fechaExpiracion);
    }

    public boolean isUrgente() {
        return urgente;
    }

    public String getMensaje() {
        return mensaje;
    }
}
