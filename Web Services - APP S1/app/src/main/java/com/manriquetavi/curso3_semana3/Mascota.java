package com.manriquetavi.curso3_semana3;

public class Mascota {
    private int id;
    private String nombre;
    private int favorito;
    private int foto;

    public Mascota(String nombre, int favorito, int foto) {
        this.nombre = nombre;
        this.favorito = favorito;
        this.foto = foto;
    }

    public Mascota() { }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int addOneFavorito() {
        favorito = favorito + 1;
        return favorito;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
