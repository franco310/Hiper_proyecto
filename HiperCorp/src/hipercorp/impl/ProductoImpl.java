
package hipercorp.impl;
import hipercorp.accesodatos.Conexion;
import hipercorp.accesodatos.Parametro;
import hipercorp.dao.ICategoria;
import hipercorp.dao.IProducto;
import hipercorp.entidades.Categoria;
import hipercorp.entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class ProductoImpl implements IProducto {
    
    
    
    @Override
    public int insertar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into producto  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getIdProducto()));
        lstPar.add(new Parametro(2, producto.getCategoria().getIdCategoria()));
        lstPar.add(new Parametro(3, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getPrecio()));
        lstPar.add(new Parametro(5, producto.getDescripcion()));
       
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE producto"
                + "   SET idProducto=?, idCategoria=?, nombre=?, precio=? , descripcion=?"
                + "where idProducto=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getIdProducto()));
        lstPar.add(new Parametro(2, producto.getCategoria().getIdCategoria()));
        lstPar.add(new Parametro(3, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getPrecio()));
        lstPar.add(new Parametro(5, producto.getDescripcion()));
              
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM producto  where idProducto=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getIdProducto()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Producto obtener(int IdProducto) throws Exception {
        Producto producto = null;
        String sql = "SELECT idProducto, idCategoria, nombre, "
                + "precio, descripcion FROM producto where idProducto=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProducto));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                producto = new Producto();
                producto.setIdProducto(rst.getInt(1)); 
                
                ICategoria categoriadao = (ICategoria) new CategoriaImpl();
                Categoria  categoria=categoriadao.obtener(rst.getInt(2));
                producto.setCategoria(categoria);
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getInt(4));
                producto.setDescripcion(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return producto;
    }

    @Override
    public List<Producto> obtener() throws Exception {
        List<Producto> lista = new ArrayList<>();
         String sql = "SELECT idProducto, idCategoria, nombre, "
                 + "precio, descripcion FROM producto";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Producto producto=null;
            while (rst.next()) {
                producto = new Producto();
                producto.setIdProducto(rst.getInt(1)); 
                ICategoria categoriadao =(ICategoria) new CategoriaImpl();
                Categoria  categoria=categoriadao.obtener(rst.getInt(2));
                producto.setCategoria(categoria);
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getInt(4));
                producto.setDescripcion(rst.getString(5));
                lista.add(producto);
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
    
}
