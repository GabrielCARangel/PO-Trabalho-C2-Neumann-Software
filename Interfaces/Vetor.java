package PO_TrabalhoC2_NeumannSoftware.Interfaces;

import java.util.Calendar;

import PO_TrabalhoC2_NeumannSoftware.Classes.Compra;

public interface Vetor {
    
    public Compra get(int pos);
    public void inserirCompra(Compra compra);
    public void remove(String cpf, Calendar data);
}