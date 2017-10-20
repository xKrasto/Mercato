/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercato;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





/**
 *
 * @author Alex
 */
public class Cassa {
    
        public static void main(String[] args) throws IOException {
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            String nome;
            float prezzo=0, qta=0; 
            
            
            
            try {
                do{
                    System.out.println("Inserisci il nome del prodotto!");
                    nome=tastiera.readLine();
                }while(nome.length()>=30);
            } catch (Exception ex) {              
                nome="Errore";
            }
            
            try {
                     do {                    
                    System.out.println("Inserisci il prezzo unitario del prodotto!");
                    prezzo=(Float.valueOf(tastiera.readLine()));                    
                    } while (prezzo>2000 || prezzo<0);
                    
            } catch (NumberFormatException e) {
                System.out.println("Errore nell'inserimento del prezzo!" + e);
                prezzo=0.00f;
            }
            try {
                do {                    
                    System.out.println("Inserisci la quantità di prodotti acquistati!");
                    qta=(Float.valueOf(tastiera.readLine()));
                } while (qta>=100 || qta<=0);

            } catch (NumberFormatException ex) {
                System.err.println("Errore nell'inserimento della quantità!");
            }
            Prodotto pera;
            pera = new Prodotto(nome, prezzo, qta);
            
            try {
                System.out.println("Inserisci la soglia per poter applicare lo sconto!");
                pera.setSoglia(Float.valueOf(tastiera.readLine()));
            } catch (NumberFormatException e) {
                System.err.println("Errore nell'inserimento della soglia!");
                pera.setSoglia(0f);
                
            }
            
            try {
                do {                    
                System.out.println("Inserisci lo sconto da applicare se possibile!");
                pera.setPSconto(Integer.valueOf(tastiera.readLine()));
                } while (pera.getPSconto()<0 && pera.getPSconto()>=100);
            } catch (NumberFormatException ex) {
                System.err.println("Errore nell'inserimento dello sconto!");
                pera.setPSconto(0);
            }
            pera.CalcolaToT();
            pera.ApplicaSconto();
            pera.StampaTutto();     
        }
}
                 
            
        



