public class Charla extends Actividad {
    private String disertante;

    //--------------------------CONSTRUCTOR--------------------------

    //Se pasan los parametros de la clase Charla y la de Actividad (SUPERCLASE)
    public Charla (int id, String titulo, int cupoMaximo, String disertante) {
        super(id, titulo, cupoMaximo); //Se llama al constructor de Actividad
        this.disertante = disertante;
    }

    //--------------------------METODOS--------------------------

    @Override
    public double calcularCostoMateriales() {
        return 0; //Las charlas son gratuitas
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    //--------------------------GETTERS--------------------------

    public String getDisertante() {
        return disertante;
    }


    //--------------------------SETTERS--------------------------

    public void setDisertante(String disertante) {
        this.disertante = disertante;
    }
}
