package model;

import java.util.ArrayList;

public class Policiaca extends Libro{
    private String trama;
    private ArrayList<String>listaPersonajes;



    public Policiaca(String cristina, int numeroPaginas, String isbn, String trama, String[] strings) {
    }

    public Policiaca(String autor, int numeroPaginas, String isbn, String trama, ArrayList<String> listaPersonajes) {
        super(autor, numeroPaginas, isbn);
        this.trama = trama;
        this.listaPersonajes = listaPersonajes;
    }

    public ArrayList<String> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<String> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("trama = " + trama);
        System.out.println("listaPersonajes = " + listaPersonajes);
    }
}
