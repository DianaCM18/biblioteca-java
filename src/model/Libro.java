package model;

public class Libro {
    private String isbn;
    private int numeroPaginas;
    private String autor;

    public Libro(String isbn, int numeroPaginas, String autor) {
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
    }

    public Libro() {
    }

    // Getters y setters según necesidad
    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void mostrarDatos(){
        System.out.println("isbn = " + isbn);
        System.out.println("numeroPaginas = " + numeroPaginas);
        System.out.println("autor = " + autor);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", autor='" + autor + '\'' +
                '}';
    }
}
