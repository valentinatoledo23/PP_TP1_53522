import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        //--------------------------INSTANCIAS--------------------------

        //Creación de salas
        Sala sala1 = new Sala( //Agregacion: la sala se crea afuera de EventoUniversitario
                1,
                "Aula Multimedia"
        );

        Sala sala2 = new Sala(
                2,
                "Aula Básica"
        );

        //Creación de eventos
        EventoUniversitario evento1 = new EventoUniversitario(
                "EV01",
                "Charla informativa sobre Phython",
                25000,
                false
        );
        EventoUniversitario evento2 = new EventoUniversitario(
                "EV02",
                "Charla informativa sobre Java",
                21000,
                false
        );

        //Creación de actividades
        evento1.crearActividad(11, "Problemáticas actuales en el mundo digital", 35, "Charla", "Carlos Pereyra");
        evento2.crearActividad(23, "Programación Orientada a Objetos", 40, "Taller", true);

        //Asignacion de salas
        evento1.asignarSala(sala1); //Agregacion: la sala existe independientemente de EventoUniversitario
        evento2.asignarSala(sala2);

        //Copias de los eventos y actividades
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaEvento2 = new EventoUniversitario(evento2);

        //Creacion de estudiantes
        Estudiante estudiante1= new Estudiante(
                "53442",
                "Juan Olivieri"
        );

        Estudiante estudiante2= new Estudiante(
                "53522",
                "Albana Mattos"
        );

        //--------------------------LISTAS--------------------------

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);

        evento1.getActividades().get(0).inscribir(estudiante1);
        evento2.getActividades().get(0).inscribir(estudiante2);

        //--------------------------MUESTRAS DE DATOS--------------------------
        evento1.mostrarDatos();
        copiaEvento1.mostrarDatos();

        evento2.mostrarDatos();
        copiaEvento2.mostrarDatos();

        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());

    }
}