package com.manriquetavi.curso3_semana3;

public class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS                      = "mascota";
    public static final String TABLE_MASCOTAS_ID                   = "id";
    public static final String TABLE_MASCOTAS_NOMBRE               = "nombre";
    public static final String TABLE_MASCOTAS_FOTO                 = "foto";

    public static final String TABLE_FAVORITAS_MASCOTAS            = "mascota_favorita";
    public static final String TABLE_FAVORITAS_MASCOTAS_ID         = "id";
    public static final String TABLE_FAVORITAS_MASCOTAS_ID_MASCOTA = "id_mascota";
    public static final String TABLE_FAVORITAS_MASCOTAS_FAVORITO   = "numero_favoritos";
}
