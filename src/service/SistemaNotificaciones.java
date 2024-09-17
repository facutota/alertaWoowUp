package service;
import java.util.List;
import model.Alerta;
import model.Topico;
import model.Usuario;

import java.util.ArrayList;

public class SistemaNotificaciones {
    private List<Topico> topicos;

    public SistemaNotificaciones() {
        this.topicos = new ArrayList<>();
    }

    public void agregarTopico(Topico topico) {
        topicos.add(topico);
    }

    public void enviarAlertaGlobal(Topico topico, Alerta alerta) {
        topico.enviarAlerta(alerta);
    }

    public void enviarAlertaUsuario(Usuario usuario, Alerta alerta) {
        usuario.recibirAlerta(alerta);
    }

    public List<Alerta> obtenerAlertasUsuario(Usuario usuario) {
        return usuario.getAlertasNoLeidas();
    }

    public List<Alerta> obtenerAlertasPorTopico(Topico topico) {
        List<Alerta> alertasTopico = new ArrayList<>();
        for (Usuario usuario : topico.usuariosSuscritos) {
            alertasTopico.addAll(usuario.getAlertasNoLeidas());
        }
        return alertasTopico;
    }
}

