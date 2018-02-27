/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.dao;

import hipercorp.entidades.DetalleVenta;
import java.util.*;

/**
 *
 * @author Usuario
 */
public interface IDetalleVenta {
    
public int insertar(DetalleVenta detalleventa) throws Exception;
    public int modificar(DetalleVenta detalleventa) throws Exception;
    public int eliminar(DetalleVenta detalleventa) throws Exception;
    public DetalleVenta obtener(int idDetalleVenta) throws Exception;
    public List<DetalleVenta> obtener() throws Exception;    
}

