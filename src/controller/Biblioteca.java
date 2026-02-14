package controller;

import model.Comedia;
import model.Libro;
import model.Policiaca;
import model.Terror;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private String nombre;
    private String director;
    private Catalogo catalogo;


    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
        this.catalogo = new Catalogo();
    }




    public void agregarLibroCatalogo(Libro libro) throws CatalogoLlenoException {
        catalogo.agregarLibro(libro);
    }

    public void eliminarLibroCatalogo(String isbn) {
        catalogo.eliminarLibro(isbn);
    }

    public Libro buscarPorISBN(String isbn) throws LibroNoEncontradoException {
        return catalogo.buscarPorISBN(isbn);
    }

    public void mostrarLibrosCatalogo() {
        catalogo.mostrarLibros();
    }

    public void mostrarLibrosPorGenero(String genero) {
        catalogo.mostrarLibrosPorGenero(genero);
    }

    public class LibroNoEncontradoException extends Exception {
        public LibroNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    public class CatalogoLlenoException extends Exception {
        public CatalogoLlenoException(String mensaje) {
            super(mensaje);
        }
    }

    public void construirCatalogo(int capacidad){
        this.catalogo = new Catalogo();
        System.out.println("El catalogo tiene un a capadidad de " + capacidad + "Libros");
        if (this.catalogo == null) {
            throw new RuntimeException("Libro no encontrado");
        }
    }

    public void exportarLibrosCatalogo(String fichero){
        catalogo.exportarLibrosCatalogo(fichero);
    }




    private class Catalogo {
        private ArrayList<Libro> libros;

        public Catalogo() {
            this.libros = new ArrayList<>();
        }

        public ArrayList<Libro> getLibros() {
            return libros;
        }

        public void setLibros(ArrayList<Libro> libros) {
            this.libros = libros;
        }

        public void exportarLibrosCatalogo(String fichero) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
                oos.writeObject(libros);
                System.out.println("Libros exportados correctamente a " + fichero);
            } catch (IOException e) {
                System.err.println("Error al exportar los libros: " + e.getMessage());
            }
        }

        public void agregarLibro(Libro libro) throws CatalogoLlenoException {
            if (libros.size() >= 4) {
                throw new CatalogoLlenoException("No hay hueco para más libros");
            }
            libros.add(libro);
        }



        public void eliminarLibro(String isbn){
            for(Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    libros.remove(libro);
                    System.out.println("Libro eliminado.");
                    break;
                }
            }
            System.out.println("Libro no encontrado.");
        }

        public Libro buscarPorISBN(String isbn) throws LibroNoEncontradoException {

            for (Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    System.out.println("Libro encontrado:");
                    System.out.println(libro);
                    return libro;
                }
            }
            throw new LibroNoEncontradoException("Libro con ISBN " + isbn + " no encontrado.");
        }


        public void mostrarLibros() {
            System.out.println("Estos Libros se encuentran disponibles en el Catalogo: " + nombre);
            //Recorremos la lista de los libros añadidos al array list
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }

        public void mostrarLibrosPorGenero(String genero) {
            System.out.println("Libros del género " + genero + ":");
            for (Libro libro : libros) {
                if (libro instanceof Comedia && genero.equalsIgnoreCase("C")) {
                    System.out.println(libro);
                } else if (libro instanceof Terror && genero.equalsIgnoreCase("C")) {
                    System.out.println(libro);
                } else if (libro instanceof Policiaca && genero.equalsIgnoreCase("P")) {
                    System.out.println(libro);
                }
            }
        }
    }
}




