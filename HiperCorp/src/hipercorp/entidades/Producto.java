
package hipercorp.entidades;

/**
 *
 * @author Francisco
 */
public class Producto {
    
    private int codigoProducto;
    private Categoria categoria;
    private String nombre;
    private int precio;

    public Producto() {
    }

    public Producto(int codigoProducto, Categoria categoria, String nombre, int precio) {
        this.codigoProducto = codigoProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
}