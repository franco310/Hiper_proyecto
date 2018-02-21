
package hipercorp.entidades;

public class Categoria {
    
    private int idCategoria;
    private String tipo;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int idCategoria, String tipo, String descripcion) {
        this.idCategoria = idCategoria;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getidCategoria() {
        return idCategoria;
    }

    public void setidCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}