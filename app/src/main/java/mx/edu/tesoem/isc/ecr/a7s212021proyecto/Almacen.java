package mx.edu.tesoem.isc.ecr.a7s212021proyecto;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private final String NomArch = "Final.tesoem";
    List<Datos> datos = new ArrayList<>();

    public boolean Existe(Context context){
        String[] archivos = context.fileList();
        for (String archivo: archivos){
            if (archivo.equals("Final.tesoem")){
                return true;
            }
        }
        return false;
    }
    public boolean Escribir(Context context, List<Datos> datos){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(NomArch, Activity.MODE_PRIVATE));
            for (Datos dato : datos){
                archivo.write(ConvertirJson(dato) + "\n");
            }
            archivo.flush();
            archivo.close();
            return true;
        }catch (Exception ex) {
            return false;
        }
    }
    public boolean Leer(Context context){
        try {
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(NomArch));
            BufferedReader br = new BufferedReader(archivo);
            String linea = "";
            while ((linea = br.readLine()) != null){
                datos.add(ConvertirClase(linea));
            }
            br.close();
            archivo.close();
            return true;
        }catch (Exception ex){ return false; }
    }
    public List<Datos> getDatos(){
        return datos;
    }
    private String ConvertirJson(Datos dato){
        Gson gson = new Gson();
        return  gson.toJson(dato);
    }
    private Datos ConvertirClase(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Datos.class);
    }
}
