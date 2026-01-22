/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.jek86100.tienda2026;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author 1dawd04
 */
public class Pedido {

    private String idPedido;
    private Cliente clientePedido;
    private LocalDate fechaPedido;
    private ArrayList<LineaPedido> cestacompra;

    public Pedido(String idPedido, Cliente clientePedido, LocalDate fechaPedido, ArrayList<LineaPedido> cestacompra) {
        this.idPedido = idPedido;
        this.clientePedido = clientePedido;
        this.fechaPedido = fechaPedido;
        this.cestacompra = cestacompra;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setCestacompra(ArrayList<LineaPedido> cestacompra) {
        this.cestacompra = cestacompra;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public ArrayList<LineaPedido> getCestacompra() {
        return cestacompra;
    }

    @Override
    public String toString() {
        return "\tidPedido:" + idPedido + " | Usuario: " + clientePedido + " | F.Pedido: " + fechaPedido + " | cesta: " + cestacompra;
    }
}
