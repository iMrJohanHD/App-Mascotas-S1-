package com.manriquetavi.curso3_semana3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE IF NOT EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS +"(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID                       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE                   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO                     + " INTEGER" +
                ")";

        String queryCrearTablaMascotaFavorita = "CREATE TABLE IF NOT EXISTS " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID_MASCOTA     + " INTEGER, " +
                ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_FAVORITO       + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaFavorita);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //Para recorrer los registros
        while (cursor.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(cursor.getInt(0));
            mascotaActual.setNombre(cursor.getString(1));
            mascotaActual.setFoto(cursor.getInt(2));
            String queryFavoritos = "SELECT COUNT(" +ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_FAVORITO + ") as favorito" +
                    " FROM " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor cursorFavoritos = db.rawQuery(queryFavoritos, null);
            if(cursorFavoritos.moveToNext()) {
                mascotaActual.setFavorito(cursorFavoritos.getInt(0));
            }
            else {
                mascotaActual.setFavorito(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarFavoritoMascotas(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS, null, contentValues);
        db.close();
    }


    public int obtenerFavoritoMascota(Mascota mascota) {
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_FAVORITO + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToNext()) {
            likes = cursor.getInt(0);
        }
        db.close();
        return likes;
    }

    public int obtenerFavoritoTotales(Context context) {
        int totalFavoritos = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_FAVORITO + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()) {
            totalFavoritos = cursor.getInt(0);
        }
        db.close();
        return totalFavoritos;
    }

    public ArrayList<Integer> obtenerIdsMascotasFavoritas(Context context) {
        ArrayList<Integer> Ids = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS +
                " ORDER BY " + ConstantesBaseDatos.TABLE_FAVORITAS_MASCOTAS_ID + " DESC LIMIT 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()) {
            Ids.add(cursor.getInt(1));
        }
        db.close();
        return Ids;
    }

}
