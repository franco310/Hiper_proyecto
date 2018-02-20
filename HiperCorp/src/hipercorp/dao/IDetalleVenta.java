/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.dao;

import java.util.*;

/**
 *
 * @author Usuario
 */
public interface IDetalleVenta {
    
public int insertar(IDetalleVenta detalle_venta) throws Exception;
    public int modificar(IDetalleVenta detalle_venta) throws Exception;
    public int eliminar(IDetalleVenta detalle_venta) throws Exception;
    public IDetalleVenta obtener(int CodDetalleVenta) throws Exception;
    public List<IDetalleVenta> obtener() throws Exception;    
}

