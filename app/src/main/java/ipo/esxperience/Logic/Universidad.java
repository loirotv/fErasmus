package ipo.esxperience.Logic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * Created by SANTANA on 22/11/2015.
 */

public class Universidad {
    public String nombre, siglas, telefono, email, web, pais;
    private LinkedList<Opinion> listaOpiniones = new LinkedList<>();
    private float valoracion = 0;
    public boolean cientifico, tecnologico, humanidades, artistico;
    public String imagen;   //Supongo que se le asocia el path hac�a la imagen a cada universidad

    public Universidad(String nombre, String siglas, String telefono,
                       String email, String web, String pais,
                       boolean cientifico, boolean tecnologico,
                       boolean humanidades, boolean artistico,
                       String imagen) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.telefono = telefono;
        this.email = email;
        this.web = web;
        this.pais = pais;
        this.cientifico = cientifico;
        this.tecnologico = tecnologico;
        this.humanidades = humanidades;
        this.artistico = artistico;
        this.imagen = imagen;
    }

    public void addOpinion(String usuario, int estrella, String texto) {
        if (estrella < 0) estrella = 0;
        if (estrella > 5) estrella = 5;
        listaOpiniones.add(new Opinion(usuario, estrella, texto));

        //Calculamos la media
        this.valoracion = 0;
        for (Opinion o : listaOpiniones)
            valoracion += o.estrella;
        this.valoracion = this.valoracion / listaOpiniones.size();
    }

    public float getValoracion() {
        return valoracion;
    }

    /* Devuelve la valoracion en un String y con 1 solo decimal */
    public String getStringValoracion() {
        DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(this.valoracion);
    }

    public LinkedList<Opinion> getListaOpiniones() {
        return listaOpiniones;
    }

    /* Devuelve el String con las siglas entre parentesis y el nombre completo
        para mostrarlo en forma de lista.
     */
    public String getNombreCompleto() {
        return "("+siglas+") "+nombre;
    }


}
