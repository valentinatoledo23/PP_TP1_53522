public class Taller extends Actividad {
    private boolean requiereNotebook;

    //--------------------------CONSTRUCTOR--------------------------

    public Taller (int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo); //Se llama al constructor de Actividad
        this.requiereNotebook = requiereNotebook;
    }

    //--------------------------METODOS--------------------------

    @Override
    public double calcularCostoMateriales() {
        return requiereNotebook ? 5000 : 2000;
    }

    @Override
    public String getTipo() {
         return "Taller";
    }

    //--------------------------GETTERS--------------------------

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }

    //--------------------------SETTERS--------------------------

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }
}
