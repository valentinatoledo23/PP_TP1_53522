import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private static int cantidadEventos = 0;

    private Sala sala; //Referencia a Sala --> Agregacion

    private List<Actividad> actividades; //Referencia a una lista (tipo PADRE, abstracta)

    //--------------------------CONSTRUCTOR--------------------------

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>(); //Se crea una lista vacia
        cantidadEventos++;
    }

    //------------------------CONSTRUCTOR COPIA------------------------

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
        cantidadEventos++;
    }

    //--------------------------METODOS--------------------------

    public void mostrarDatos() {
        System.out.println("Id: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo Base: $" + costoBase);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Costo estimado: $" + calcularCostoEstimado());

        if (sala == null) {
                    System.out.println("No hay sala asignada");
        }       else {
                    System.out.println("Sala: " + sala.getNombre());
                    System.out.println("Id: " + sala.getId());
        }


        for (Actividad a: actividades) {
            a.mostrarIdentificacion(); //Polimorfismo: cada actividad muestra su propio getTipo()
            a.mostrarInscripciones();
        }
    }

    public double calcularCostoEstimado(){
        if (gratuito) {
            return 0;
        }
        else {
            double costoActividades = 0;
            for (Actividad a : actividades) {
                costoActividades = costoActividades + a.calcularCostoMateriales();
            }
            return (costoBase + costoActividades) * 1.21;
        }
    }

    public void asignarSala(Sala sala){
        this.sala= sala; //Se asigna una sala a un evento
    }

    //Se quiere crear una Actividad segun si es Charla o Taller, entonces hacemos especializaciones para cada caso:
    public void crearActividad(int id, String titulo, int cupoMaximo, String tipo, String disertante){
        if (tipo.equalsIgnoreCase("Charla")) { //tipo.equalsIgnoreCase se usa para comparar Strings
            actividades.add(new Charla(id, titulo, cupoMaximo, disertante));
        }
        else {
            System.out.println("No se ha creado una actividad de tipo Charla.");
        }
    }

    public void crearActividad(int id, String titulo, int cupoMaximo, String tipo, boolean requiereNotebook){
        if (tipo.equalsIgnoreCase("Taller")) { //tipo.equalsIgnoreCase se usa para comparar Strings
            actividades.add(new Taller(id, titulo, cupoMaximo, requiereNotebook));
        }
        else {
            System.out.println("No se ha creado una actividad de tipo Taller.");
        }
    }

    //--------------------------GETTERS--------------------------

    public String getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public double getCostoBase() {
        return costoBase;
    }
    public boolean isGratuito() {
        return gratuito;
    }
    public static int getCantidadEventos() {
        return cantidadEventos;
    }
    public Sala getSala() {
        return sala;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    //--------------------------SETTERS--------------------------
    public void setId(String id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }
}
