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
public class Lek {

    private int sifra;
    private int dobavljac_id;
    private String ime;

    public Lek() {
    }

    public Lek(int sifra, int dobavljac_id, String ime) {
        this.sifra = sifra;
        this.dobavljac_id = dobavljac_id;
        this.ime = ime;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getDobavljac_id() {
        return dobavljac_id;
    }

    public void setDobavljac_id(int dobavljac_id) {
        this.dobavljac_id = dobavljac_id;
    }

    @Override
    public String toString() {
        return "Lek{" + "sifra=" + sifra + ", dobavljac id=" + dobavljac_id + ", ime=" + ime + '}';
    }

}
