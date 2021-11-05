package PO_TrabalhoC2_NeumannSoftware.Classes;

import java.util.ArrayList;
import java.util.Calendar;

import PO_TrabalhoC2_NeumannSoftware.Interfaces.Ordernacao;
import PO_TrabalhoC2_NeumannSoftware.Interfaces.Vetor;

public class CadastrarCompra implements Vetor, Ordernacao {

    private ArrayList<Compra> vetorCompra;

    public CadastrarCompra() {
        this.vetorCompra = new ArrayList<>();
    }

    public ArrayList<Compra> getVetorCompra() {
        return vetorCompra;
    }

    public void setVetorCompra (ArrayList<Compra> novoVetorCompra) {
        this.vetorCompra = novoVetorCompra;
    }

    @Override
    public Compra get (int posicao) {
        return (vetorCompra.get(posicao));
    }
    
    @Override
    public void inserirCompra (Compra compra) {
        this.vetorCompra.add(compra);
    }

    @Override
    public void remove (String cpf, Calendar data) {
        
        for (int contador = 0; contador <= vetorCompra.size(); contador++) {
            
            if (vetorCompra.get(contador).getCliente().getCpf().contentEquals(cpf) && vetorCompra.get(contador).getData() == data) {

                    vetorCompra.remove(contador);
                    contador--;
            }
        }
    }

    @Override
    public void insercaoDireta () {

        int auxiliar01, auxiliar02;
        Compra auxiliarCompra;

        for (auxiliar01 = 1; auxiliar01 < this.vetorCompra.size(); auxiliar01++) {

            auxiliarCompra = this.vetorCompra.get(auxiliar01);
            auxiliar02 = auxiliar01 - 1;

            while ((auxiliar02 >= 0) && (verificarMaior(auxiliar02, auxiliarCompra) == 1)) {

                this.vetorCompra.set(auxiliar02 + 1, this.vetorCompra.get(auxiliar02));
                auxiliar02--;
            }

            this.vetorCompra.set(auxiliar02 + 1, auxiliarCompra);
        }
    }

    @Override
    public void shellSort () {

        int auxiliar01, auxiliar02, auxiliar03;
        Compra auxiliarCompra;
        auxiliar03 = 1;

        do {

            auxiliar03 = 3 * auxiliar03 + 1;

        } while (auxiliar03 < this.vetorCompra.size());

        do {

            auxiliar03 = auxiliar03 / 3;

            for (auxiliar01 = auxiliar03; auxiliar01 < this.vetorCompra.size(); auxiliar01++) {

                auxiliarCompra = this.vetorCompra.get(auxiliar01);
                auxiliar02 = auxiliar01;

                while (verificarMaior(auxiliar02 - 1, auxiliarCompra) == 1) {

                    this.vetorCompra.set(auxiliar02, this.vetorCompra.get(auxiliar02 - auxiliar03));
                    auxiliar02 -= auxiliar03;

                    if (auxiliar02 < auxiliar03) {

                        break;
                    }
                }

                this.vetorCompra.set(auxiliar02, auxiliarCompra);
            }

        } while (auxiliar03 != 1);
    }

    @Override
    public void quickSort () {
        quick(0, this.vetorCompra.size() - 1);
    }

    private void quick (int esquerda, int direita) {

        int auxiliar01 = esquerda, auxiliar02 = direita;
        Compra temporario, pivo;

        pivo = this.vetorCompra.get((auxiliar01 + auxiliar02) / 2);

        do {

            while (verificarMaior(auxiliar01, pivo) == -1) {
                auxiliar01++;
            }

            while (verificarMaior(auxiliar02, pivo) == 1) {
                auxiliar02--;
            }

            if (auxiliar01 <= auxiliar02) {

                temporario = this.vetorCompra.get(auxiliar01);
                this.vetorCompra.set(auxiliar01, this.vetorCompra.get(auxiliar02));
                this.vetorCompra.set(auxiliar02, temporario);
                auxiliar01++;
                auxiliar02--;
            }

        } while (auxiliar01 <= auxiliar02);

        if (esquerda < auxiliar02) {
            quick(esquerda, auxiliar02);
        }

        if (direita > auxiliar01) {
            quick(auxiliar01, direita);
        }
    }

    @Override
    public void quickComInsercao() {
        quickInsercao(0, this.vetorCompra.size() - 1);
    }

    private void quickInsercao (int esquerda, int direita) {

        int auxiliar01 = esquerda, auxiliar02 = direita;
        Compra temporario, pivo;
        pivo = this.vetorCompra.get((auxiliar01 + auxiliar02) / 2);

        do {

            while (verificarMaior(auxiliar01, pivo) == -1) {
                auxiliar01++;
            }

            while (verificarMaior(auxiliar02, pivo) == 1) {
                auxiliar02--;
            }

            if (auxiliar01 <= auxiliar02) {

                temporario = this.vetorCompra.get(auxiliar01);
                this.vetorCompra.set(auxiliar01, this.vetorCompra.get(auxiliar02));
                this.vetorCompra.set(auxiliar02, temporario);
                auxiliar01++;
                auxiliar02--;
            }

        } while (auxiliar01 <= auxiliar02);

        if (esquerda < auxiliar02) {

            if ((auxiliar02 - esquerda) <= 20) {
                insercaoModificada(esquerda, auxiliar02);

            } else {
                quickInsercao(esquerda, auxiliar02);
            }
        }

        if (direita > auxiliar01) {

            if ((direita - auxiliar01) <= 20) {
                insercaoModificada(auxiliar01, direita);

            } else {
                quickInsercao(auxiliar01, direita);
            }
        }
    }

    private void insercaoModificada (int inicio, int fim) {

        int auxiliar;
        Compra temporario;

        for (int contador = inicio; contador <= fim; contador++) {

            temporario = this.vetorCompra.get(contador);
            auxiliar = contador - 1;

            while ((auxiliar >= 0) && (verificarMaior(auxiliar, temporario)) == 1) {

                this.vetorCompra.set(auxiliar + 1, this.vetorCompra.get(auxiliar));
                auxiliar--;
            }

            this.vetorCompra.set(auxiliar + 1, temporario);
        }
    }

    public int verificarMaior(int auxiliar, Compra temporario) {

        if (this.vetorCompra.get(auxiliar).getCliente().getCpf().compareTo(temporario.getCliente().getCpf()) > 0) {
            return 1;
        
        } else if (this.vetorCompra.get(auxiliar).getCliente().getCpf().compareTo(temporario.getCliente().getCpf()) < 0) {
            return -1;
        
        } else {
        
            if (this.vetorCompra.get(auxiliar).getData().compareTo(temporario.getData()) > 0) {
                return 1;
        
            } else if (this.vetorCompra.get(auxiliar).getData().compareTo(temporario.getData()) < 0) {
                return -1;
        
            } else {
                return 0;
            }
        }
    }
    
}