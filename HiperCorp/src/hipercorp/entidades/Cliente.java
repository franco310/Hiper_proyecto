
package hipercorp.entidades;
import java.util.*;
/**
 *
 * @author Francisco
 */
public class Cliente {
    
      private int idCliente;
      private String cedula;
      private String nombres;
      private String apellidos;
      private String direccion;
      private String telefono;
      private String email;
      private Date fecha;

    public Cliente() {
    }

    public Cliente(int idCliente, String cedula, String nombres, String apellidos, String direccion, String telefono, String email, Date fecha) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha = fecha;
    }

   

     @Override
    public String toString() {
        return nombres; 
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
