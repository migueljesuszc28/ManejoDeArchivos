package Libreria;

import java.io.*;
import java.nio.file.*;

/**
 * Esta clase sirve para leer, crear, eliminar, copiar, mover 
 * y escribir en un archivo
 * @author Miguel Jesus Zuñiga Coneo
 * @version 1.0
 */
public class ManejoDeArchivos {

    //Atributos
    private String Ruta;
    private String Texto;
    private String RutaDestino;
    private String ArchivoOriginal;
    private String ArchivoCopia;
    /**
     * Lee un archivo y muestra su contenido por el output.
     *
     * @param Ruta La ruta del archivo a leer.
     * @throws IOException Si se produce un error al leer el archivo.
     */
    public static void Lectura(String Ruta) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Ruta));
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
    }
    } 
    /**
     * Escribe en un archivo.
     *
     * @param Ruta La ruta del archivo a escribir.
     * @param Texto El texto a escribir en el archivo.
     * @throws IOException Si se produce un error al escribir en el archivo.
     */
    public static void Escritura(String Ruta, String Texto) throws IOException {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(Ruta));
            writer.write(Texto);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Crea un archivo.
     *
     * @param Ruta La ruta del archivo a crear.
     * @throws IOException Si se produce un error al crear el archivo.
     */
    public static void Crear(String Ruta) throws IOException {
        try {
            Path Archivo = Paths.get(Ruta);
            Files.createFile(Archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Mueve un archivo de una ruta a otra.
     *
     * @param Ruta   La ruta del archivo a mover.
     * @param RutaDestino La ruta de destino del archivo.
     * @throws IOException Si se produce un error al mover el archivo.
     */
    public static void Mover(String Ruta, String RutaDestino) throws IOException {
        try {
            File archivo = new File(Ruta);
            File destino = new File(RutaDestino);
            archivo.renameTo(destino);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /**
     * Copia un archivo de una ruta a otra.
     *
     * @param ArchivoOriginal La ruta del archivo original.
     * @param ArchivoCopia La ruta del archivo copia.
     * @throws IOException Si se produce un error al copiar el archivo.
     */
    public static void Copiar(String ArchivoOriginal, String ArchivoCopia) throws IOException {
        try {
            Path archivoOrigen = Paths.get(ArchivoOriginal);
            Path archivoDestino = Paths.get(ArchivoCopia);
            Files.copy(archivoOrigen,archivoDestino);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    /**
     * Elimina un archivo.
     *
     * @param Ruta La ruta del archivo a eliminar.
     * @throws IOException Si se produce un error al eliminar el archivo.
     */
    public static void Eliminar(String Ruta) throws IOException {
            try {
                File archivo = new File(Ruta);
                if (archivo.delete()) {
                    System.out.println("Archivo borrado");
                } else {
                    System.out.println("Archivo no borrado");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
