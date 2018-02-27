
package hipercorp.entidades;

/**
 *
 * @author Francisco
 */
public class Producto {
    
  private int idProducto;
    private Categoria categoria;
    private String nombre;
    private int precio;
    private String descripcion;
    

    public Producto() {
    }
    
    

    public Producto(int idProducto, Categoria categoria, String nombre, int precio, String descripcion) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    @Override 
    public String toString(){
        return nombre;
    }
        
}
