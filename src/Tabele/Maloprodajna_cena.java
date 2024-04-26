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
public class Maloprodajna_cena {

    private int id;
    private int apoteka_id;
    private int sifra_lek;
    private int cena_leka;

    public Maloprodajna_cena() {
    }

    public Maloprodajna_cena(int id, int apoteka_id, int sifra_lek, int cena_leka) {
        this.id = id;
        this.apoteka_id = apoteka_id;
        this.sifra_lek = sifra_lek;
        this.cena_leka = cena_leka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApoteka_id() {
        return apoteka_id;
    }

    public void setApoteka_id(int apoteka_id) {
        this.apoteka_id = apoteka_id;
    }

    public int getSifra_lek() {
        return sifra_lek;
    }

    public void setSifra_lek(int sifra_lek) {
        this.sifra_lek = sifra_lek;
    }

    public int getCena_leka() {
        return cena_leka;
    }

    public void setCena_leka(int cena_leka) {
        this.cena_leka = cena_leka;
    }

    @Override
    public String toString() {
        return "Maloprodajna_cena{" + "id=" + id + ", apoteka id=" + apoteka_id + ", sifra lek=" + sifra_lek + ", cena_leka=" + cena_leka + '}';
    }

}
