package model;

public class Comedia extends Libro{

    private String tipoHumor;

    public Comedia() {
    }

    public Comedia(String isbn, int numeroPaginas, String autor, String tipoHumor) {
        super(isbn, numeroPaginas, autor);
        this.tipoHumor = tipoHumor;
    }

    public String getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(String tipoHumor) {
        this.tipoHumor = tipoHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("tipoHumor = " + tipoHumor);
    }

    public String toString() {
        return super.toString() + ", Tipo de humor: " + tipoHumor;
    }
}