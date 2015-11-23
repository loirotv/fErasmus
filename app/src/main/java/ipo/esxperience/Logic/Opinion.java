package ipo.esxperience.Logic;

/**
 * Created by SANTANA on 22/11/2015.
 */
public class Opinion {
    public String usuario;
    public int estrella;
    public String texto;

    public Opinion(String usuario, int estrella, String texto) {
        this.usuario = usuario;
        this.estrella = estrella;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "usuario='" + usuario + '\'' +
                ", estrella=" + estrella +
                ", texto='" + texto + '\'' +
                '}';
    }
}
