import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
private int id;
private String titulo;
private int CupoMaximo;

public  static final int CUPO_MINIMO = 5;

private List<Inscripcion> inscripciones; //Se declara una referencia a una lista

    //--------------------------CONSTRUCTOR--------------------------

    //Al ser SUPERCLASE, no se ocupa dicho constructor
    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.CupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>(); //Se crea una lista vacía
    }

    //--------------------------METODOS--------------------------

    public Inscripcion inscribir(Estudiante estudiante) {

        if (inscripciones.size() < CupoMaximo) {

            //Datos propios de la nueva inscripcion:
            LocalDate fecha = LocalDate.now(); //Obtenemos la fecha actual
            String estado = "CONFIRMADO";

            //Creación de la nueva inscripcion:
            Inscripcion inscripcion = new Inscripcion(estudiante, this, fecha, estado);
            //Como la clase se llama Actividad, this hace referencia a eso mismo, por ej: actividad1, actividad2, etc

            //Guardado de la inscripcion en la lista:
            inscripciones.add(inscripcion);

            //Se devuelve la inscripcion ya creada:
            return inscripcion;

        } else {
            System.out.println("No hay mas cupos");
            return null;
        }
    }

    public void mostrarInscripciones(){
        for (Inscripcion i: inscripciones) {//Inscripcion i hace referencia al objeto
            System.out.println("Estudiante: " + i.getEstudiante().getNombre());
            System.out.println("Legajo: " + i.getEstudiante().getLegajo());
            System.out.println("Fecha: " + i.getFecha());
            System.out.println("Estado: " + i.getEstado());
        }
    }

    //Como es final, no se puede redefinir ni en Charla ni en Taller
    public final void mostrarIdentificacion(){
        System.out.println("Actividad #" + id + " - " + titulo + " [Tipo: " + getTipo() + "]");
    }

    //Métodos abstractos: cada subclase la implementa de una cierta manera
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();


//--------------------------GETTERS--------------------------

    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getCupoMaximo() {
        return CupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    //--------------------------SETTERS--------------------------

    public void setId(int id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setCupoMaximo(int cupoMaximo) {
        CupoMaximo = cupoMaximo;
    }
}


