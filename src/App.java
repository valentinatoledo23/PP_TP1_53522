import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        //--------------------------INSTANCIAS--------------------------

        //Creación de sala
        Sala sala1 = new Sala( //Agregacion: la sala se crea afuera de EventoUniversitario
                1,
                "Aula Multimedia"
        );

        //Creación de evento
        EventoUniversitario evento1 = new EventoUniversitario(
                "EV01",
                "Charla informativa sobre Java",
                25000,
                false
        );

        //Creación de actividades
        evento1.crearActividad(11, "Problemáticas actuales en el mundo digital", 35, "Charla", "Carlos Pereyra");
        evento1.crearActividad(23, "Programación Orientada a Objetos", 40, "Taller", true);

        //Asignacion de sala
        evento1.asignarSala(sala1); //Agregacion: la sala existe independientemente de EventoUniversitario

        //Copias del evento y actividades
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);

        //Creacion de estudiantes
        Estudiante estudiante1= new Estudiante(
                "53442",
                "Juan Olivieri"
        );

        Estudiante estudiante2= new Estudiante(
                "53522",
                "Albana Mattos"
        );

        Estudiante estudiante3= new Estudiante(
                "53772",
                "Jimena Perez"
        );

        //--------------------------LISTAS--------------------------

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);

        evento1.getActividades().get(0).inscribir(estudiante1); //get(0) representa a Charla porque se creo primero
        evento1.getActividades().get(0).inscribir(estudiante2);
        evento1.getActividades().get(1).inscribir(estudiante1); //get(1) representa a Taller porque se creo segundo
        evento1.getActividades().get(1).inscribir(estudiante3);

        //--------------------------MUESTRAS DE DATOS--------------------------
        evento1.mostrarDatos();
        copiaEvento1.mostrarDatos();

        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}