package modelos;

/**
 *
 * @author Ardys CPN
 */
public class Articulos extends Categorias{
    private long codigo;
    private String nombreArt;
    private String unidadMedida;
    private int existencias;
    private int cantMaxima;
    private int cantMinima;

    public Articulos() {
    }

    public Articulos(long codigo, String nombreArt, String unidadMedida, int existencias, int cantMaxima, int cantMinima, int idCategoria, String nombre) {
        super(idCategoria, nombre);
        this.codigo = codigo;
        this.nombreArt = nombreArt;
        this.unidadMedida = unidadMedida;
        this.existencias = existencias;
        this.cantMaxima = cantMaxima;
        this.cantMinima = cantMinima;
    }

    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getCantMaxima() {
        return cantMaxima;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    public int getCantMinima() {
        return cantMinima;
    }

    public void setCantMinima(int cantMinima) {
        this.cantMinima = cantMinima;
    }

    @Override
    public String toString() {
        return "Articulos{" + "codigo=" + codigo + ", nombre=" + nombreArt + ", unidadMedida=" + unidadMedida + ", existencias=" + existencias + ", cantMaxima=" + cantMaxima + ", cantMinima=" + cantMinima + '}';
    }

}
