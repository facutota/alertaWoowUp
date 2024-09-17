import java.time.LocalDateTime;

import model.Alerta;
import model.Topico;
import model.Usuario;
import service.SistemaNotificaciones;

public class App {
     public static void main(String[] args) {
        // Crear sistema de notificaciones
        SistemaNotificaciones sistema = new SistemaNotificaciones();
        
        // Crear usuarios
        Usuario usuario1 = new Usuario(1, "Facundo");
        Usuario usuario2 = new Usuario(2, "Nicolas");
        
        // Crear tópicos
        Topico deportes = new Topico(1, "Deportes");
        Topico noticias = new Topico(2, "Noticias");
        
        sistema.agregarTopico(deportes);
        sistema.agregarTopico(noticias);
        
        // Suscribir usuarios a tópicos
        usuario1.suscribir(deportes);
        usuario2.suscribir(noticias);
        
        // Enviar alertas
        Alerta alertaDeportes = new Alerta("Partido de fútbol hoy", false, LocalDateTime.now().plusDays(1));
        Alerta alertaUrgente = new Alerta("Hospital en llamas", true, LocalDateTime.now().plusHours(1));
        
        sistema.enviarAlertaGlobal(deportes, alertaDeportes);
        sistema.enviarAlertaGlobal(noticias, alertaUrgente);

        System.out.println(sistema.obtenerAlertasPorTopico(noticias));

        
        // Obtener alertas no leídas
        System.out.println("Alertas de Alice: " + usuario1.getAlertasNoLeidas().size());
        System.out.println("Alertas de Bob: " + usuario2.getAlertasNoLeidas().size());
    }
}
