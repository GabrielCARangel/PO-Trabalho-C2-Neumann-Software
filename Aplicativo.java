package PO_TrabalhoC2_NeumannSoftware;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import PO_TrabalhoC2_NeumannSoftware.Classes.CadastrarCompra;
import PO_TrabalhoC2_NeumannSoftware.Manipuladores.GravarDados;
import PO_TrabalhoC2_NeumannSoftware.Manipuladores.LerDados;

public class Aplicativo {

	static double[] resultadosIteracoes = new double[5];
	static Scanner entrada = new Scanner(System.in);
	static String ordenacaoEscolhida, ordenacaoArquivo, nomeLeitura, nomeResultados, nomeDadosOrdenados;

    public static void main (String[] args) {

		long mediaTempos = 0;
		long tempoInicial, tempoFinal;

		CadastrarCompra compra = new CadastrarCompra();

		tipoDado(compra);
		tipoOrdenacao();

        for (int contador = 0; contador < resultadosIteracoes.length; contador++) {
	
			lerArquivo(compra, nomeLeitura);

    	    tempoInicial = System.nanoTime();

        	ordenar(compra);
			gravarArquivo(compra);
			
        	tempoFinal = System.nanoTime();

			resultadosIteracoes[contador] = tempoFinal - tempoInicial;

			System.out.print("\nA " + (contador + 1) +"ª iteração foi concluida com sucesso.");
		}
		
		gravarResultado(mediaTempos);
    }

	public static void tipoDado (CadastrarCompra compra) {

		byte opcao = -1;
		boolean continuar = true;
		
		do {
			try {

				System.out.print("\nEscolha o tipo de dado em que os testes serão realizados:"
								+"\n	 1.   500 números aleatórios"
								+"\n	 2.   500 números invertidos"
								+"\n	 3.   500 números ordenados"
								+"\n"
								+"\n	 4.  1000 números aleatórios"
								+"\n	 5.  1000 números invertidos"
								+"\n	 6.  1000 números ordenados"
								+"\n"
								+"\n	 7.  5000 números aleatorios"
								+"\n	 8.  5000 números invertidos"
								+"\n	 9.  5000 números ordenados"
								+"\n"
								+"\n	10. 10000 números aleatórios"
								+"\n	11. 10000 números invertidos"
								+"\n	12. 10000 números ordenados"
								+"\n"
								+"\n	13. 50000 números aleatórios"
								+"\n	14. 50000 números invertidos"
								+"\n	15. 50000 números ordenados"
								+"\nTipo de Dado: ");
				opcao = entrada.nextByte();

				if (opcao >= 1 && opcao <= 15) {
                    continuar = false;
                }

			} catch (Exception erro) {

				System.out.print("\nOpção incorreta. Por favor, tente novamente.");
				entrada.nextLine();
			}

		} while (continuar);

		switch (opcao) {

			case 1:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/500_Aleatorios.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/500_Aleatorios";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/500_Aleatorios";
			break;

			case 2:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/500_Invertidos.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/500_Invertidos";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/500_Invertidos";
			break;

			case 3:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/500_Ordenados.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/500_Ordenados";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/500_Ordenados";
			break;

			case 4:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/1000_Aleatorios.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/1000_Aleatorios";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/1000_Aleatorios";
			break;

			case 5:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/1000_Invertidos.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/1000_Invertidos";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/1000_Invertidos";
			break;

			case 6:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/1000_Ordenados.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/1000_Ordenados";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/1000_Ordenados";
			break;

			case 7:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/5000_Aleatorios.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/5000_Aleatorios";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/5000_Aleatorios";
			break;

			case 8:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/5000_Invertidos.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/5000_Invertidos";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/5000_Invertidos";
			break;

			case 9:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/5000_Ordenados.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/5000_Ordenados";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/5000_Ordenados";
			break;

			case 10:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/10000_Aleatorios.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/10000_Aleatorios";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/10000_Aleatorios";
			break;

			case 11:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/10000_Invertidos.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/10000_Invertidos";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/10000_Invertidos";
			break;

			case 12:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/10000_Ordenados.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/10000_Ordenados";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/10000_Ordenados";
			break;

			case 13:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/50000_Aleatorios.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/50000_Aleatorios";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/50000_Aleatorios";
			break;

			case 14:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/50000_Invertidos.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/50000_Invertidos";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/50000_Invertidos";
			break;

			case 15:
				nomeLeitura = "ExercicioGrupo_PO_LPOO/Dados/50000_Ordenados.txt";
				nomeDadosOrdenados = "ExercicioGrupo_PO_LPOO/DadosOrdenados/50000_Ordenados";
				nomeResultados = "ExercicioGrupo_PO_LPOO/Resultados/50000_Ordenados";
			break;
		}

	}

    public static void lerArquivo (CadastrarCompra compra, String nomeArquivo) {

		LerDados arquivo = null;

		try {

			arquivo = new LerDados(nomeArquivo);
			compra.setVetorCompra(arquivo.ler());
			arquivo.fecha();
		}

		catch (FileNotFoundException erro) {

			System.out.print("\n" +erro);
			System.exit(1);
		}

		catch (NumberFormatException erro) {

			System.out.print("\n" +erro);
			arquivo.fecha();
			System.exit(1);
		}		

		catch (ArrayIndexOutOfBoundsException erro) {

			System.out.print("\n" +erro);
			arquivo.fecha();
			System.exit(1);
		}
    }

	public static void tipoOrdenacao () {

		boolean continuar = true;
		byte opcao;

		do {

			try {
			
				System.out.print("\nEscolha o tipo de ordenação a se fazer:"
								+"\n	1. Inserção Direta"
								+"\n	2. Shell Sort"
								+"\n	3. Quick Sort"
								+"\n	4. Quick com Inserção"
								+"\nTipo de Ordenação: ");
				opcao = entrada.nextByte();

				if (opcao >= 1 && opcao <= 4) {

					switch (opcao) {

						case 1:
							ordenacaoEscolhida = "Inserção Direta";
							ordenacaoArquivo = "_InsercaoDireta.txt";
						break;

						case 2:
							ordenacaoEscolhida = "Shell Sort";
							ordenacaoArquivo = "_ShellSort.txt";
						break;

						case 3:
							ordenacaoEscolhida = "Quick Sort";
							ordenacaoArquivo = "_QuickSort.txt";
						break;

						case 4:
							ordenacaoEscolhida = "Quick com Inserção";
							ordenacaoArquivo = "_QuickInsercao.txt";
						break;
					}

					continuar = false;
				}
			
			} catch (Exception erro) {

				System.out.print("\nTipo de ordenação incorreto. Por favor, tente novamente.");
				entrada.nextLine();
			}

		} while (continuar);

	}

    public static void ordenar (CadastrarCompra compra) {

		switch (ordenacaoEscolhida) {

			case "Inserção Direta":
				compra.insercaoDireta();
			break;

			case "Shell Sort":
				compra.shellSort();
			break;

			case "Quick Sort":
				compra.quickSort();
			break;

			case "Quick com Inserção":
				compra.quickComInsercao();
			break;
		}

    }

	public static void gravarArquivo(CadastrarCompra compra) {
		
		try {

			String arquivo = nomeDadosOrdenados + ordenacaoArquivo;

			GravarDados saida = new GravarDados(arquivo, false);
			
			for (int contador = 0; contador < compra.getVetorCompra().size(); contador++) {
			
				saida.gravar(compra.get(contador).toString());
			}
			
			saida.fechar();
		
		} catch (IOException erro) {

			System.out.println(erro);
		}
	}

	public static void gravarResultado(long mediaFinal) {

		Double auxiliarMedia = 0.0;
		String auxiliarString;
		String arquivoResultados = nomeResultados+ordenacaoArquivo;

		try {

			GravarDados saida = new GravarDados(arquivoResultados, true);
			saida.gravar("O tipo escolhido foi: " +ordenacaoEscolhida +"\nOs resultados estão em segundos." +"\n\n");

			for (int contador = 0; contador < resultadosIteracoes.length; contador ++) {

				saida.gravar("	Tempo da " + (contador + 1) + "° Execução: " + (resultadosIteracoes[contador]) / 1e+9 + "\n");
				auxiliarMedia += resultadosIteracoes[contador]; 
			}
			
			auxiliarMedia = (auxiliarMedia/resultadosIteracoes.length) / 1e+9;
			auxiliarString = Double.toString(auxiliarMedia);

			saida.gravar("\n" +"	O tempo médio final é: " + auxiliarString +"\n\n");
			saida.fechar();

		} catch (IOException erro) {

			System.out.println(erro);
		}

		System.out.print("\n\nOs dados ordenados já estão gravados na pasta chamada 'DadosOrdenados'.");
		System.out.print("\nOs tempos de cada iteração tambem foram gravados e estão contidos na pasta 'Resultados'.\n\n");

	}

}