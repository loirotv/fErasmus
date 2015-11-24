package ipo.esxperience.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by SANTANA on 22/11/2015.
 */
public class ListaUniversidades {
    public LinkedList<Universidad> listaUniversidades = new LinkedList<>();

    public ListaUniversidades(BufferedReader bfu, BufferedReader bfo) throws IOException {
        String s;
        String[] datos;
        while ((s = bfu.readLine()) != null) {
            datos = s.split(",");
            listaUniversidades.add(new Universidad(
                    datos[0],
                    datos[1],
                    datos[2],
                    datos[3],
                    datos[4],
                    datos[5],
                    Boolean.parseBoolean(datos[6]),
                    Boolean.parseBoolean(datos[7]),
                    Boolean.parseBoolean(datos[8]),
                    Boolean.parseBoolean(datos[9]),
                    datos[10]));
        }

        while ((s = bfo.readLine()) != null) {
            datos = s.split(",");
            getUniversidad(datos[0]).addOpinion(datos[1], Integer.parseInt(datos[2]), datos[3]);
        }
    }

    /* Constructor para filtros */
    private ListaUniversidades(LinkedList<Universidad> listaUniversidades) {
        this.listaUniversidades = listaUniversidades;
    }

    /* Buscador que devuelve la misma clase con coincidencias */
    public ListaUniversidades buscarNombre(String texto) {
        LinkedList<Universidad> lista = new LinkedList<>();
        for (Universidad u : listaUniversidades) {
            if (u.nombre.toLowerCase().contains(texto.toLowerCase()) ||
                    u.siglas.toLowerCase().contains(texto.toLowerCase()))
                lista.add(u);
        }
        return new ListaUniversidades(lista);
    }

    public ListaUniversidades buscarPais(String pais) {
        LinkedList<Universidad> lista = new LinkedList<>();
        for (Universidad u : listaUniversidades) {
            if (u.pais.toLowerCase().equals(pais.toLowerCase()))
                lista.add(u);
        }
        return new ListaUniversidades(lista);
    }

    public ListaUniversidades filtrarCampo(boolean cientifico, boolean tecnologico, boolean humanidades, boolean artistico) {
        LinkedList<Universidad> lista = new LinkedList<>();
        for (Universidad u : listaUniversidades) {
            if ((u.cientifico == cientifico) && (u.tecnologico == tecnologico) && (u.humanidades == humanidades) && (u.artistico == artistico))
                lista.add(u);
        }
        return new ListaUniversidades(lista);
    }

    /* Filtros para ordenar por nombre y por valoracion */
    public void ordenarNombre(){
        Collections.sort(listaUniversidades, Universidad.porNombre);
    }

    public void ordenarValoracion(){
        Collections.sort(listaUniversidades, Universidad.porValoracion);
    }

    /* Obtiene los nombres de toda la lista */
    public String[] getNombresCompletos() {
        String lista[] = new String[listaUniversidades.size()];
        int i = 0;
        for (Universidad u : listaUniversidades)
            lista[i++] = u.getNombreCompleto();
        return lista;
    }

    public String[] getNombres() {
        String lista[] = new String[listaUniversidades.size()];
        int i = 0;
        for (Universidad u : listaUniversidades)
            lista[i++] = u.nombre;
        return lista;
    }

    public Universidad getUniversidad(String nombre) {
        for (Universidad u : listaUniversidades)
            if (u.nombre.toLowerCase().equals(nombre.toLowerCase()))
                return u;
        return null;
    }

    public Universidad getUniversidad(int posicion) {
        if (posicion < listaUniversidades.size()) return listaUniversidades.get(posicion);
        return null;
    }
}
