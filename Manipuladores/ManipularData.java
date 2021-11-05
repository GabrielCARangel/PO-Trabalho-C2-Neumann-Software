package PO_TrabalhoC2_NeumannSoftware.Manipuladores;

import java.util.Calendar;

public class ManipularData {

    public static Calendar lerData (String leituraData) {

        String linhaData;
        Calendar data;
        String[] dado;
        int dia, mes, ano;

        linhaData = leituraData;
        dado = linhaData.split("/");
        dia = Integer.parseInt(dado[0]);
        mes = Integer.parseInt(dado[1]) - 1;
        ano = Integer.parseInt(dado[2]);

        data = Calendar.getInstance();
        data.set(ano, mes, dia);

        return data;
    }

    public static String formatar(Calendar data) {

        String linhaData = "";

        linhaData += data.get(Calendar.DATE) + "/" +(data.get(Calendar.MONTH) + 1) + "/" +data.get(Calendar.YEAR);

        return linhaData;
    }
}