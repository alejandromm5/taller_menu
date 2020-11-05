package com.clientes;

import clases.Clientes;
import clases.Producto;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Producto> arregloProductos = new ArrayList<>();
        List<Clientes> arregloClientes = new ArrayList<>();

        Integer opMenu = new Integer(0);
        String op = null;

        do {
            op = JOptionPane.showInputDialog("SISTEMA DE CAPTURA DE CLIENTES Y PRODUCTOS \n "
                          + "1 Agregar Cliente \n"
                          + "2 Editar Cliente \n"
                          + "3 Eliminar Cliente \n"
                          + "4 Adicionar Producto \n"
                          + "5 Consultar cliente por documento y tipo de documento \n"
                          + "0 Salir");
            opMenu = Integer.parseInt(op);
            switch (opMenu.toString()) {
                case "1":
                    String nombreCli    = JOptionPane.showInputDialog("Nombre del Cliente:");
                    String telefonoCli  = JOptionPane.showInputDialog("Telefono del Cliente:");
                    String direccionCli = JOptionPane.showInputDialog("Direccion del Cliente:");
                    String documentoCli = JOptionPane.showInputDialog("Documento del Cliente:");
                    String tipoDocCli   = JOptionPane.showInputDialog("Tipo de Documento del Cliente:");
                    Clientes clientes = new Clientes(nombreCli,telefonoCli,direccionCli,documentoCli,tipoDocCli,arregloProductos);
                    arregloClientes.add(clientes);
                    break;
                case "2":
                    int modifico = 0;
                    String documentoModificar = JOptionPane.showInputDialog("Digite el documento del cliente a Modificar");
                    if(!arregloClientes.isEmpty()) {
                        for (int i = 0; i < arregloClientes.size(); i++) {
                            if (arregloClientes.get(i).getDocumento().equals(documentoModificar)) {
                                String nombreCliMod = JOptionPane.showInputDialog("Nombre del Cliente:");
                                String telefonoCliMod = JOptionPane.showInputDialog("Telefono del Cliente:");
                                String direccionCliMod = JOptionPane.showInputDialog("Direccion del Cliente:");
                                String documentoCliMod = JOptionPane.showInputDialog("Documento del Cliente:");
                                String tipoDocCliMod = JOptionPane.showInputDialog("Tipo de Documento del Cliente:");
                                Clientes clientesMod = new Clientes(nombreCliMod, telefonoCliMod, direccionCliMod, documentoCliMod, tipoDocCliMod, arregloProductos);
                                arregloClientes.set(i, clientesMod);
                                JOptionPane.showMessageDialog(null, "Nombre :" + arregloClientes.get(i).getNombre() + "\n " +
                                        "Direccion : " + arregloClientes.get(i).getDireccion() + "\n" +
                                        "Telefoni : " + arregloClientes.get(i).getTelefono() + "\n" +
                                        "Documento: " + arregloClientes.get(i).getDocumento() + "\n" +
                                        "Tipo documento: " + arregloClientes.get(i).getTipDoc() +"\n" +
                                        "Productos " + arregloClientes.get(i).getProductos());
                                modifico = 1;
                                break;
                            }
                        }
                        if(modifico == 0 ) {
                            JOptionPane.showMessageDialog(null,"El cliente a modificar no existe");
                        }else
                            JOptionPane.showMessageDialog(null,"El cliente " + documentoModificar + " fue modificado exitosamente" );
                    }
                break;
                case "3":
                    int elimino = 0;
                    String documentoEli = JOptionPane.showInputDialog("Digite el documento del cliente a Eliminar");
                    if(!arregloClientes.isEmpty()) {
                        for(int i = 0; i < arregloClientes.size(); i++) {
                            if(arregloClientes.get(i).getDocumento().equals(documentoEli)){
                                arregloClientes.remove(i);
                                elimino = 1;
                                break;
                            }
                        }
                        if(elimino == 1) {
                            JOptionPane.showMessageDialog(null,"Se elemino el cliente");
                        }else {
                            JOptionPane.showMessageDialog(null,"No se enecontro el cliente a eliminar");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha creado ningun cliente");
                    }
                    break;
                case "4":
                    Producto addProd = new Producto();
                    addProd.setNombre(JOptionPane.showInputDialog("Nombre del Producto:"));
                    addProd.setCaracteristicas(JOptionPane.showInputDialog("Caracteristicas del Producto:"));
                    addProd.setCondiciones(JOptionPane.showInputDialog("Condiciones del Producto:"));
                    addProd.setIdProducto(JOptionPane.showInputDialog("ID del Producto:"));
                    arregloProductos.add(addProd);
                    break;
                case "5":
                    int encontro = 0;
                    String documentoCon = JOptionPane.showInputDialog("Digite docuemento a consultar : ");
                    String tipoDocCon = JOptionPane.showInputDialog("Digite tipo documento a consultar : ");
                    encontro = arregloClientes.indexOf(documentoCon);
                    JOptionPane.showMessageDialog(null,arregloClientes.get(encontro).getNombre());
                    if(!arregloClientes.isEmpty()){
                        for (int i = 0; i< arregloClientes.size(); i++) {
                            if (arregloClientes.get(i).getDocumento().equals(documentoCon) &&
                                    arregloClientes.get(i).getTipDoc().equals(tipoDocCon)) {
                                JOptionPane.showMessageDialog(null, "Nombre :" + arregloClientes.get(i).getNombre() + "\n " +
                                        "Direccion : " + arregloClientes.get(i).getDireccion() + "\n" +
                                        "Telefoni : " + arregloClientes.get(i).getTelefono() + "\n" +
                                        "Documento: " + arregloClientes.get(i).getDocumento() + "\n" +
                                        "Tipo documento: " + arregloClientes.get(i).getTipDoc() +"\n" +
                                        "Productos " + arregloClientes.get(i).getProductos());
                                encontro = 1;
                            }
                        }
                        if(encontro == 0 ) {
                            JOptionPane.showMessageDialog(null,"No se encontro el cliente a consulatar");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "No existen clientes ");
                    }
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null,"Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default :
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es una opción del menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));

    }
}
