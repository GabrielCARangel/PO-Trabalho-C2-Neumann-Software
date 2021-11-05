package PO_TrabalhoC2_NeumannSoftware.Classes;

public class ClienteEspecial extends Cliente {

    private double valeCompra;

    public ClienteEspecial (String nome, String cpf, double valeCompra) {
        super(nome, cpf);
        this.valeCompra = valeCompra;
    }

    public double getValeCompra () {
        return valeCompra;
    }

    public void setValeCompra (double novoValeCompra) {
        this.valeCompra = novoValeCompra;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + this.valeCompra;
    }
}