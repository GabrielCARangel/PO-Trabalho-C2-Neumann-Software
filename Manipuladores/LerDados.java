package PO_TrabalhoC2_NeumannSoftware.Manipuladores;

import java.io.*;
import java.util.*;

import PO_TrabalhoC2_NeumannSoftware.Classes.Cliente;
import PO_TrabalhoC2_NeumannSoftware.Classes.ClienteEspecial;
import PO_TrabalhoC2_NeumannSoftware.Classes.Compra;

public class LerDados {

	private Scanner entrada;

	public LerDados(String nomeArquivo) throws FileNotFoundException {

		try
		{
			this.entrada = new Scanner(new File(nomeArquivo));
		}
		catch (FileNotFoundException excessao)
		{
			throw new FileNotFoundException("O arquivo não foi encontrado.");
		}
	}

	public ArrayList<Compra> ler() throws ArrayIndexOutOfBoundsException, NumberFormatException {

		ArrayList<Compra> compra = new ArrayList<>();
		String linha;

		while (this.entrada.hasNext()) {

			linha = this.entrada.nextLine();
			compra.add((separaDados(linha)));
		}

		return compra;
	}

	private Compra separaDados(String linha) throws ArrayIndexOutOfBoundsException, NumberFormatException {

		String[] dados = null;
		double vale, valor;
		Calendar data;

		try {

			dados = linha.split(";");

			if (dados.length > 4) {

				data = ManipularData.lerData(dados[3]);
				vale = Double.parseDouble(dados[2]);
				valor = Double.parseDouble(dados[4]);

				ClienteEspecial novoClienteEspecial = new ClienteEspecial(dados[0], dados[1], vale);

				return (new Compra(novoClienteEspecial, data, valor));

			} else {

				data = ManipularData.lerData(dados[2]);
				valor = Double.parseDouble(dados[3]);

				Cliente novoCliente = new Cliente(dados[0], dados[1]);

				return (new Compra(novoCliente, data, valor));

			}

		} catch (ArrayIndexOutOfBoundsException erro) {

			throw new ArrayIndexOutOfBoundsException("Registro tem " + dados.length + " informações.");
		
		} catch (NumberFormatException erro) {
		
			throw new NumberFormatException("O número da conta não é inteiro.");
		}
	}

	public void fecha() throws IllegalStateException {

		try {
			
			this.entrada.close();

		} catch (IllegalStateException erro) {

			throw new IllegalStateException("Erro ao fechar o arquivos.");
		}
	}
	
}