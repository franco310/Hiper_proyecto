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
    
public int insertar(DetalleVenta detalle_venta) throws Exception;
    public int modificar(DetalleVenta detalle_venta) throws Exception;
    public int eliminar(DetalleVenta detalle_venta) throws Exception;
    public DetalleVenta obtener(int idDetalleVenta) throws Exception;
    public List<IDetalleVenta> obtener() throws Exception;    
}

