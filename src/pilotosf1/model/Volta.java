/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilotosf1.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diogo
 */
public class Volta implements Runnable {

    private List<Double> tempos;

    public Volta() {        
        tempos = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                double tempoVolta = calcularTempoVolta();
                tempos.add(tempoVolta);                
                
                System.out.println("Tempo aguardar: " + tempoVolta);
                
                long tempoAguardar = (long) tempoVolta * 1000;
                Thread.sleep(tempoAguardar);
            } catch (InterruptedException ex) {
                Logger.getLogger(Volta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public double calcularTempoVolta() {
        Random random = new Random();
        double numeroAleatorio = 0 + (30) * random.nextDouble();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("#.####", symbols);

        String formatado = formatter.format(numeroAleatorio);
        double doubleFormatado = Double.parseDouble(formatado);

        return doubleFormatado;
    }

    public double somarTemposVoltas() {
        double retorno = 0;
        for (Double tempo : tempos) {
            retorno += tempo;
        }

        return retorno;
    }           

}
