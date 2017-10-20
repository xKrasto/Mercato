package mercato;

import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

/**
 *
 * @author Alex
 */
public class Prodotto {
    private final String nome;
    private final float prezzo;
    private final float qta;
    private float prezzoFinale;
    private float soglia;
    private int pSconto;
    private float daSottrarre;
    private boolean scontoApplicato;
    //METODI
    //COSTRUTTORE
    public Prodotto(String nome, float prezzo, float qta) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.qta = qta;
        scontoApplicato=false;
    }
    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public float getQta() {
        return qta;
    }

    public float getPrezzoFinale() {
        return prezzoFinale;
    }

    public void setPrezzoFinale(float prezzoFinale) {
        this.prezzoFinale = prezzoFinale;
    }

    public float getSoglia() {
        return soglia;
    }

    public void setSoglia(float soglia) {
        this.soglia = soglia;
    }

    public int getPSconto() {
        return pSconto;
    }

    public void setPSconto(int pSconto) {
        this.pSconto = pSconto;
    }
    
    public void CalcolaToT(){
        prezzoFinale=prezzo*qta;
        }

    public float getDaSottrarre() {
        return daSottrarre;
    }

    public void setDaSottrarre(float daSottrarre) {
        this.daSottrarre = daSottrarre;
    }
    
    
    
    public void StampaTutto(){//boolean prima
        DecimalFormat dfp, dpq;
        dfp = new DecimalFormat("#0.00");
        dpq = new DecimalFormat("#####.###");
        System.out.println("-------------------------------------------");
        System.out.println("-Nome prodotto: " + nome);
        System.out.println("-Prezzo unitario del prodotto: "+ dfp.format(prezzo) + "€");
        System.out.println("-Quantità acquistate: "+ dpq.format(qta));
        System.out.println("-Prezzo Totale prima dello sconto: "+ dfp.format((prezzo*qta)) + "€");
        if (scontoApplicato) {
            System.out.println("-Sconto applicato:" + pSconto + "%" + " Importo scontato: " + daSottrarre + "€"  );
            System.out.println("-Prezzo finale dopo lo sconto: " + prezzoFinale + "€");
        }
        else{   
            System.out.println("-Sconto non applicabile!");
        }
        System.out.println("-------------------------------------------");
    }
    public void ApplicaSconto(){
        if (prezzoFinale>=soglia) {
            daSottrarre=(prezzoFinale*((float) pSconto/100));
            prezzoFinale-=daSottrarre;
            scontoApplicato=true;
          }
    }
        
    
}
