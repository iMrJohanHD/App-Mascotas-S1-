package com.manriquetavi.curso3_semana3;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTodasMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public void insertarTodasMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "turtle");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.turtle);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, 1);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "panda");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.panda);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, 2);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "husky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.husky);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, 3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "pug");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pug);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, 4);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "parrot");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.parrot);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, 5);
        db.insertarMascotas(contentValues);
    }

    public void darFavoritoMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_FAVORITO, LIKE);
        db.insertarFavoritoMascotas(contentValues);
    }

    public int obtenerFavoritoMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerFavoritoMascota(mascota);
    }

    public int obtenerFavoritoTotales(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerFavoritoTotales(context);
    }

    public ArrayList<Integer> obtenerIdsMascotasFavoritas() {
        BaseDatos db =  new BaseDatos(context);
        return db.obtenerIdsMascotasFavoritas(context);
    }

}
