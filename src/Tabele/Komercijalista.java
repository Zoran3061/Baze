package Tabele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Milos PC
 */
public class Komercijalista extends Osoba {

    private String br_telefona;

    public Komercijalista(String jmbg, String ime, String prezime, String adresa, String br_telefona) {
        super(jmbg, ime, prezime, adresa);
        this.br_telefona = br_telefona;
    }

    public Komercijalista() {
    }

    public String getBr_telefona() {
        return br_telefona;
    }

    public void setBr_telefona(String br_telefona) {
        this.br_telefona = br_telefona;
    }

    @Override
    public String toString() {
        return "Komercijalista{" + "jmbg=" + super.getJmbg() + ", ime=" + super.getIme() + ", prezime=" + super.getPrezime() + ", adresa=" + super.getAdresa() + ", broj telefona=" + br_telefona + '}';

    }

}
