package model;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private List<Alerta> alertas;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.alertas = new ArrayList<>();
    }

    public void suscribir(Topico topico) {
        topico.agregarUsuario(this);
    }

    public void desuscribir(Topico topico) {
        topico.eliminarUsuario(this);
    }

    public void recibirAlerta(Alerta alerta) {
        alertas.add(alerta);
    }

    public List<Alerta> getAlertasNoLeidas() {
        List<Alerta> alertasNoLeidas = new ArrayList<>();
        for (Alerta alerta : alertas) {
            if (!alerta.isLeida() && !alerta.esExpirada()) {
                alertasNoLeidas.add(alerta);
            }
        }
        return alertasNoLeidas;
    }
}
