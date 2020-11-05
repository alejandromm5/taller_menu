package clases;

import java.util.List;

public class Clientes extends Empresas {
    private String nombre;
    private String telefono;
    private String direccion;
    private List<Producto> productos;

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", productos=" + productos +
               // ", tipDoc='" + tipDoc + '\'' +
                '}';
    }

    public Clientes (String nombre , String telefono, String direccion, String documento, String tipoDoc, List<Producto> productos) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.productos = productos;
        this.setDocumento(documento);
        this.setTipDoc(tipoDoc);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
