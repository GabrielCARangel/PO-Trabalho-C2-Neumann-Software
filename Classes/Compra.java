package PO_TrabalhoC2_NeumannSoftware.Classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Compra {

    private Cliente cliente;
    private Calendar data;
    private double valor;

    public Compra (PO_TrabalhoC2_NeumannSoftware.Classes.Cliente cliente, Calendar data, double valor) {

        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
    }

    public Cliente getCliente () {
        return cliente;
    }

    public void setCliente (Cliente novoCliente) {
        this.cliente = novoCliente;
    }

    public Calendar getData () {
        return data;
    }

    public void setData (Calendar novaData) {
        this.data = novaData;
    }

    public double getValor () {
        return valor;
    }

    public void setValor (double novoValor) {
        this.valor = novoValor;
    }

    @Override
    public String toString() {

        SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");

        if (cliente.getClass() == ClienteEspecial.class) {

            return cliente.getNome() + ";" 
            + cliente.getCpf() + ";" 
            + ((ClienteEspecial) cliente).getValeCompra()
            + ";" +dataSimples.format(data.getTime()) + ";" 
            + valor + "\n";
        } 

        return cliente.getNome() + ";" + cliente.getCpf() + ";" + dataSimples.format(data.getTime()) + ";" + valor + "\n";
    }
}