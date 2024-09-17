package model;

import java.util.ArrayList;
import java.util.List;

public class Topico {
    private int id;
    private String nombre;
    public List<Usuario> usuariosSuscritos;

    public Topico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.usuariosSuscritos = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuariosSuscritos.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuariosSuscritos.remove(usuario);
    }

    public void enviarAlerta(Alerta alerta) {
        for (Usuario usuario : usuariosSuscritos) {
            usuario.recibirAlerta(alerta);
        }
    }
}
