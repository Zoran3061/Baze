package Tabele;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Milos PC
 */
public class Ugovor {

    private int id;
    private int id_dobavljac;
    private int id_apoteka;
    private String jmbg_komercijalista;
    private Date pocetak_vazenja;
    private Date kraj_vazenja;
    private String tekst_ugovor;

    public Ugovor() {
    }

    public Ugovor(int id, int id_dobavljac, int id_apoteka, String jmbg_komercijalista, Date pocetak_vazenja, Date kraj_vazenja, String tekst_ugovor) {
        this.id = id;
        this.id_dobavljac = id_dobavljac;
        this.id_apoteka = id_apoteka;
        this.jmbg_komercijalista = jmbg_komercijalista;
        this.pocetak_vazenja = pocetak_vazenja;
        this.kraj_vazenja = kraj_vazenja;
        this.tekst_ugovor = tekst_ugovor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dobavljac() {
        return id_dobavljac;
    }

    public void setId_dobavljac(int id_dobavljac) {
        this.id_dobavljac = id_dobavljac;
    }

    public int getId_apoteka() {
        return id_apoteka;
    }

    public void setId_apoteka(int id_apoteka) {
        this.id_apoteka = id_apoteka;
    }

    public String getJmbg_komercijalista() {
        return jmbg_komercijalista;
    }

    public void setJmbg_komercijalista(String jmbg_komercijalista) {
        this.jmbg_komercijalista = jmbg_komercijalista;
    }

    public Date getPocetak_vazenja() {
        return pocetak_vazenja;
    }

    public void setPocetak_vazenja(Date pocetak_vazenja) {
        this.pocetak_vazenja = pocetak_vazenja;
    }

    public Date getKraj_vazenja() {
        return kraj_vazenja;
    }

    public void setKraj_vazenja(Date kraj_vazenja) {
        this.kraj_vazenja = kraj_vazenja;
    }

    public String getTekst_ugovor() {
        return tekst_ugovor;
    }

    public void setTekst_ugovor(String tekst_ugovor) {
        this.tekst_ugovor = tekst_ugovor;
    }

    @Override
    public String toString() {
        return "Ugovor{" + "id=" + id + ", id_dobavljac=" + id_dobavljac + ", id_apoteka=" + id_apoteka + ", jmbg_komercijalista=" + jmbg_komercijalista + ", pocetak_vazenja=" + pocetak_vazenja + ", kraj_vazenja=" + kraj_vazenja + ", tekst_ugovor=" + tekst_ugovor + '}';
    }

}
