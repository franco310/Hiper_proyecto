/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercorp.entidades;

/**
 *
 * @author Usuario
 */
public class Categoria {
    
    private int CodCategoria;
    private String NombreCategoria;
    private String DescripcionCat;

    public Categoria() {
    }

    public Categoria(int CodCategoria, String NombreCategoria, String DescripcionCat) {
        this.CodCategoria = CodCategoria;
        this.NombreCategoria = NombreCategoria;
        this.DescripcionCat = DescripcionCat;
    }

    public int getCodCategoria() {
        return CodCategoria;
    }

    public void setCodCategoria(int CodCategoria) {
        this.CodCategoria = CodCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getDescripcionCat() {
        return DescripcionCat;
    }

    public void setDescripcionCat(String DescripcionCat) {
        this.DescripcionCat = DescripcionCat;
    }
    
    
    
}
