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
public class Zamena {

    private int zamena_id;
    private int sifra_lek;
    private int zamena_sifra_lek;

    public Zamena() {
    }

    public Zamena(int zamena_id, int sifra_lek, int zamena_sifra_lek) {
        this.zamena_id = zamena_id;
        this.sifra_lek = sifra_lek;
        this.zamena_sifra_lek = zamena_sifra_lek;
    }

    public int getZamena_id() {
        return zamena_id;
    }

    public void setZamena_id(int zamena_id) {
        this.zamena_id = zamena_id;
    }

    public int getSifra_lek() {
        return sifra_lek;
    }

    public void setSifra_lek(int sifra_lek) {
        this.sifra_lek = sifra_lek;
    }

    public int getZamena_sifra_lek() {
        return zamena_sifra_lek;
    }

    public void setZamena_sifra_lek(int zamena_sifra_lek) {
        this.zamena_sifra_lek = zamena_sifra_lek;
    }

    @Override
    public String toString() {
        return "Zamena{" + "zamena_id=" + zamena_id + ", sifra_lek=" + sifra_lek + ", zamena_sifra_lek=" + zamena_sifra_lek + '}';
    }

}
