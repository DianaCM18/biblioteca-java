package model;

public class Terror extends Libro{
    private double calificacion;

    public Terror() {
    }

    public Terror(String autor, int numeroPaginas, String isbn, double calificacion) {
        super(autor, numeroPaginas, isbn);
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("calificacion = " + calificacion);
    }

    public String toString() {
        return super.toString() + ", Calificación de terror: " + calificacion;
    }
}
