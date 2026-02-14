import controller.Biblioteca;
import model.Comedia;
import model.Libro;
import model.Policiaca;
import model.Terror;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) /*throws Biblioteca.LibroNoEncontradoException*/ {

        Biblioteca biblioteca = new Biblioteca("Biblioteca", "DI");

        Scanner entrada = new Scanner(System.in);

        // Agregar libros
       /* try {
        biblioteca.agregarLibroCatalogo(new Libro("001", 345, "autor1"));
        biblioteca.agregarLibroCatalogo(new Libro("002", 3245, "autor2"));
        biblioteca.agregarLibroCatalogo(new Libro("003", 1223, "autor3"));
        } catch (Biblioteca.CatalogoLlenoException e) {}*/




        Comedia Libro1 = new Comedia("001", 200, "Eduardo", "Parodia");
        Comedia Libro2 = new Comedia("002", 350, "Helena", "Comedia Romantica");
        Comedia Libro3 = new Comedia("003", 400, "Raul", "Parodia");
        Comedia Libro4 = new Comedia("004", 567, "Carlos", "Comedia romántica");
        Terror Libro5 = new Terror("Sara", 658, "005", 3.2);
        Terror Libro6 = new Terror("Thomas", 400, "006", 4.5);
        Terror Libro7 = new Terror("James", 365, "007", 5.5);
        Terror Libro8 = new Terror("Roberto", 490, "008", 2.2);
        Policiaca Libro9 = new Policiaca("Cristina",345,"009","crimen",new String[]{"personaje1","personaje2"});
        Policiaca Libro10 = new Policiaca("Ramon",769,"010","crimen",new String[]{"personaje1","personaje2"});
        Policiaca Libro11 = new Policiaca("Francisco",675,"011","crimen",new String[]{"personaje1","personaje2"});
        Policiaca Libro12 = new Policiaca("Sandra",678,"012","crimen",new String[]{"personaje1","personaje2"});

        try {
            biblioteca.agregarLibroCatalogo(new Comedia("001", 200, "Eduardo", "Parodia"));
            biblioteca.agregarLibroCatalogo(new Terror("Roberto", 490, "008", 2.2));
            biblioteca.agregarLibroCatalogo(new Comedia("003", 400, "Raul", "Parodia"));
        } catch (Biblioteca.CatalogoLlenoException e) {}

        System.out.println("BIENVENIDO A LA BIBLIOTECA");
        System.out.println();
        biblioteca.mostrarLibrosCatalogo();

        int opcion = 0;
        //Si metemos una opcion por encima de 6, no accedemos al switch
        do {
            System.out.println();
            System.out.println("Opcion 1 - Buscar información del lubro introduciendo el ISBN");
            System.out.println("Opcion 2 - Construir un catálogo de libros");
            System.out.println("Opcion 3 - Consultar el catálogo de libros");
            System.out.println("Opcion 4 - Agregar libros al catálogo");
            System.out.println("Opcion 5 - Eliminar libro del catálago");
            System.out.println();
            System.out.println("¿De las opciones que hay, que quiere hacer?");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el ISBN");
                    String isbnopcion1 = entrada.next();
                    try {
                        biblioteca.buscarPorISBN(isbnopcion1);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("A continuacion se mostrara la capacidad delibros que tiene el catálogo");
                    biblioteca.construirCatalogo(4);
                    biblioteca.exportarLibrosCatalogo("Libros: ");
                    break;

                case 3:
                    System.out.println("Los libros que tiene el catálogo son los siguientes");
                    biblioteca.mostrarLibrosCatalogo();
                    break;

                case 4:
                    while (true) {

                        //Empezamos el bucle
                        System.out.println("si quiere continuar pulse cualquier tecla, sino escriba 'salir'");
                        String Continuar = entrada.nextLine();

                        if (Continuar.equalsIgnoreCase("salir")) {
                            break;
                        }

                        System.out.println("Que tipo de genero quieres añadir, 'Comedia = C', 'Terror = T' o 'Policiaca = P'");
                        String opcionGenero = entrada.nextLine();

                        //Atributos generales
                        System.out.println("Ingrese isbn del libro:");
                        String isbnopcion2 = entrada.nextLine();

                        System.out.println("Ingrese numero de paginas del libro:");
                        int numeroPaginas = entrada.nextInt();


                        System.out.println("Ingrese autor del libro:");
                        String autor = entrada.nextLine();

                        String tipoHumor = "";
                        int calificacion = 0;

                        //Pillamos atributos especificos
                        if (opcionGenero.equalsIgnoreCase("C")) {
                            System.out.println("Que tipo de humor quieres añadir");
                            tipoHumor = entrada.nextLine();
                        } else if (opcionGenero.equalsIgnoreCase("T")) {
                            System.out.println("Que tipo de calificación quieres añadir");
                            calificacion = entrada.nextInt();
                        } else if (opcionGenero.equalsIgnoreCase("P")) {
                            calificacion = entrada.nextInt();
                        }

                        //Creamos cada tipo de genero
                        Libro nuevoLibro;
                        if (opcionGenero.equalsIgnoreCase("C")) {
                            nuevoLibro = new Comedia(isbnopcion2, numeroPaginas, autor, tipoHumor);
                        } else if (opcionGenero.equalsIgnoreCase("T")) {
                            nuevoLibro = new Terror(isbnopcion2, numeroPaginas, autor, calificacion);
                        } else if (opcionGenero.equalsIgnoreCase("P")) {
                            nuevoLibro = new Terror(isbnopcion2, numeroPaginas, autor, calificacion);
                        }else {
                            System.out.println("Género no reconocido, se creará como Libro genérico.");
                            nuevoLibro = new Libro(isbnopcion2, numeroPaginas, autor);
                        }

                        try {
                            biblioteca.agregarLibroCatalogo(nuevoLibro);
                            System.out.println("Libro agregado correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        biblioteca.mostrarLibrosPorGenero(opcionGenero);

                    }break;

                case 5:
                    while (true) {

                        System.out.println("si quiere continuar pulse cualquier tecla, sino escriba 'salir'");
                        String Continuar = entrada.nextLine();

                        if (Continuar.equalsIgnoreCase("salir")) {
                            break;
                        }

                        System.out.println("Ingrese isbn del libro:");
                        String isbnopcion3 = entrada.nextLine();

                        biblioteca.eliminarLibroCatalogo(isbnopcion3);

                        biblioteca.mostrarLibrosCatalogo();
                    }
                    break;
            }


        }while (opcion != 6) ;
    }
}

