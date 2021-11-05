package PO_TrabalhoC2_NeumannSoftware.Classes;

public class Cliente {

    private String nome;
    private String cpf;

    public Cliente (String nome, String cpf) {

        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String novoNome) {
        this.nome = novoNome;
    }

    public String getCpf () {
        return cpf;
    }

    public void setCpf (String novoCPF) {
        this.cpf = novoCPF;
    }

    @Override
    public String toString() {
        return this.nome + ";" + this.cpf; 
    }
}