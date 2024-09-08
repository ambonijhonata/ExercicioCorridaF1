/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilotosf1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import pilotosf1.model.Volta;

/**
 *
 * @author diogo
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here                

        Volta voltasHamilton = new Volta();
        Volta voltasAlonso = new Volta();                
        
        Thread threadHamilton = new Thread(voltasHamilton);
        Thread threadAlonso = new Thread(voltasAlonso);
        
        threadHamilton.start();
        threadAlonso.start();
        System.out.println("INICIOU THREADS");
        threadHamilton.join();
        threadAlonso.join();

        System.out.println("Total voltas Hamilton: " + formatarDouble(voltasHamilton.somarTemposVoltas()) + " segundos.");
        System.out.println("Total voltas Alonso: " + formatarDouble(voltasAlonso.somarTemposVoltas()) + " segundos.");
        
        double tempoTotalHamilton = voltasHamilton.somarTemposVoltas();
        double tempoTotalAlonso = voltasAlonso.somarTemposVoltas();
        
        if(tempoTotalHamilton < tempoTotalAlonso) { 
            System.out.println("Vencedor Hamilton!!! Tempo total corrida: " + formatarDouble(tempoTotalHamilton) / 60 + " minutos");
        } else {
            System.out.println("Vencedor: Fernando Alonso Tempo total corrida: " + formatarDouble(tempoTotalAlonso) / 60 + " minutos");
        }
    }
    
    private static double formatarDouble(double num) {
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("#.####", symbols);

        String formatado = formatter.format(num);
        double doubleFormatado = Double.parseDouble(formatado);

        return doubleFormatado;
    }

}
