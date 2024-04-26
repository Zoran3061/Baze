package Baza;

import Tabele.Ugovor;
import Tabele.Pacijent;
import Tabele.Farmaceut;
import Tabele.Doktor;
import Tabele.Zamena;
import Tabele.Lek;
import Tabele.Recept;
import Tabele.Apoteka;
import Tabele.Maloprodajna_cena;
import Tabele.Komercijalista;
import Tabele.Dobavljac;
import Tabele.Angazovanje;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Milos PC
 */
public class Baza {

    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost/bazait350";
    private static String user = "root";
    private static String pass = "";
    private static String query = "";

    public static void connect() {
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Angazovanje> getAllAngazovanje() {
        ArrayList<Angazovanje> angazovanja = new ArrayList<>();
        try {
            query = "SELECT * FROM `angazovanje`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("ID_ANGAZOVANJE");
                int apoteka_id = rs.getInt("ID_APOTEKA");
                String jmbg_farmaceut = rs.getString("JMBG_FARMACEUT");
                int broj_meseci = rs.getInt("BROJ_MESECI");
                int broj_dana = rs.getInt("BROJ_DANA");

                Angazovanje a = new Angazovanje(id, apoteka_id, jmbg_farmaceut, broj_meseci, broj_dana);
                angazovanja.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return angazovanja;

    }

    public static void addAngazovanje(Angazovanje a) {
        query = "INSERT INTO `angazovanje` (`ID_ANGAZOVANJE`, `ID_APOTEKA`, `JMBG_FARMACEUT`, `BROJ_MESECI`, `BROJ_DANA`) "
                + "VALUES (NULL,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, a.getApoteka_id());
            ps.setString(2, a.getJmbg_farmaceut());
            if (a.getBroj_dana() == 0) {
                ps.setNull(3, java.sql.Types.INTEGER);
            } else {
                ps.setInt(3, a.getBroj_dana());
            }
            if (a.getBroj_meseci() == 0) {
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, a.getBroj_meseci());
            }

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateAngazovanje(Angazovanje a) {
        query = "UPDATE `angazovanje` SET  "
                + " `ID_APOTEKA` = ?, `JMBG_FARMACEUT` = ?, "
                + "`BROJ_MESECI` = ?, `BROJ_DANA` = ? WHERE `angazovanje`.`ID_ANGAZOVANJE` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, a.getApoteka_id());
            ps.setString(2, a.getJmbg_farmaceut());
            ps.setInt(3, a.getBroj_meseci());
            ps.setInt(4, a.getBroj_dana());
            ps.setInt(5, a.getId());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Apoteka> getAllApoteka() {
        ArrayList<Apoteka> apoteka = new ArrayList<>();
        try {
            query = "SELECT * FROM `apoteka`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("ID_APOTEKA");
                String ime = rs.getString("IME_APOTEKA");
                String adresa = rs.getString("ADRESA_APOTEKA");
                String br_telefona = rs.getString("TELEFON_APOTEKA");

                Apoteka a = new Apoteka(id, ime, adresa, br_telefona);
                apoteka.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apoteka;
    }

    public static void addApoteka(Apoteka a) {
        query = "INSERT INTO `apoteka` (`ID_APOTEKA`, `IME_APOTEKA`, `ADRESA_APOTEKA`, `TELEFON_APOTEKA`) "
                + "VALUES (?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getIme());
            ps.setString(3, a.getAdresa());
            ps.setString(4, a.getBr_telefona());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateApoteka(Apoteka a) {
        query = "UPDATE `apoteka` SET  "
                + " `IME_APOTEKA` = ?, `ADRESA_APOTEKA` = ?, "
                + "`TELEFON_APOTEKA` = ?  WHERE `apoteka`.`ID_APOTEKA` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, a.getIme());
            ps.setString(2, a.getAdresa());
            ps.setString(3, a.getBr_telefona());
            ps.setInt(4, a.getId());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Dobavljac> getAllDobavljac() {
        ArrayList<Dobavljac> dobavljac = new ArrayList<>();
        try {
            query = "SELECT * FROM `dobavljac`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("ID_DOBAVLJAC");
                String ime = rs.getString("IME_DOBAVLJAC");
                String br_telefona = rs.getString("TELEFON_DOBAVLJAC");

                Dobavljac d = new Dobavljac(id, ime, br_telefona);
                dobavljac.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dobavljac;
    }

    public static void addDobavljac(Dobavljac d) {
        /*ID_DOBAVLJAC, IME_DOBAVLJAC, TELEFON_DOBAVLJAC*/
        query = "INSERT INTO `dobavljac` (`ID_DOBAVLJAC`, `IME_DOBAVLJAC`, `TELEFON_DOBAVLJAC`) "
                + "VALUES (?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, d.getId());
            ps.setString(2, d.getIme());
            ps.setString(3, d.getBr_telefona());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateDobavljac(Dobavljac d1) {
        query = "UPDATE `dobavljac` SET  "
                + "`IME_DOBAVLJAC` = ?, "
                + "`TELEFON_DOBAVLJAC` = ? WHERE `ID_DOBAVLJAC` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);

            ps.setString(1, d1.getIme());
            ps.setString(2, d1.getBr_telefona());
            ps.setInt(3, d1.getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Doktor> getAllDoktor() {
        ArrayList<Doktor> doktor = new ArrayList<>();
        try {
            query = "SELECT * FROM `doktor`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                String jmbg = rs.getString("JMBG_DOKTOR");
                String ime = rs.getString("IME_DOKTOR");
                String adresa = rs.getString("ADRESA_DOKTOR");
                int starost = rs.getInt("STAROST_DOKTOR");

                Doktor d = new Doktor(jmbg, ime, adresa, starost);
                doktor.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doktor;
    }

    public static void addDoktor(Doktor d) {
        query = "INSERT INTO `doktor` (`JMBG_DOKTOR`, `IME_DOKTOR`, `ADRESA_DOKTOR`, `STAROST_DOKTOR`) "
                + "VALUES (?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, d.getJmbg());
            ps.setString(2, d.getIme());
            ps.setString(3, d.getAdresa());
            ps.setInt(4, d.getStarost());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateDoktor(Doktor d) {
        query = "UPDATE `doktor` SET `IME_DOKTOR` = ?, "
                + "`ADRESA_DOKTOR` = ?, `STAROST_DOKTOR` = ? "
                + "WHERE `doktor`.`JMBG_DOKTOR` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, d.getIme());
            ps.setString(2, d.getAdresa());
            ps.setInt(3, d.getStarost());
            ps.setString(4, d.getJmbg());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Farmaceut> getAllFarmaceut() {
        ArrayList<Farmaceut> farmaceut = new ArrayList<>();
        try {
            query = "SELECT * FROM `farmaceut`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                String jmbg = rs.getString("JMBG_FARMACEUT");
                String ime = rs.getString("IME_FARMACEUT");
                String prezime = rs.getString("PREZIME_FARMACEUT");
                String adresa = rs.getString("ADRESA_FARMACEUT");

                String strucnaSprema = rs.getString("STRUCNA_SPREMA");

                Farmaceut f = new Farmaceut(jmbg, ime, prezime, adresa, strucnaSprema);
                farmaceut.add(f);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmaceut;
    }

    public static void addFarmaceut(Farmaceut f) {
        query = "INSERT INTO `farmaceut` (`JMBG_FARMACEUT`, `IME_FARMACEUT`, `PREZIME_FARMACEUT` , `ADRESA_FARMACEUT`, `STRUCNA_SPREMA`) "
                + "VALUES (?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, f.getJmbg());
            ps.setString(2, f.getIme());
            ps.setString(3, f.getPrezime());
            ps.setString(4, f.getAdresa());
            ps.setString(5, f.getStrucnaSprema());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateFarmaceut(Farmaceut f) {
        query = "UPDATE `farmaceut` SET  "
                + " `IME_FARMACEUT` = ?, `PREZIME_FARMACEUT` = ?, "
                + "`ADRESA_FARMACEUT` = ?, `STRUCNA_SPREMA` = ?  WHERE `farmaceut`.`JMBG_FARMACEUT` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, f.getIme());
            ps.setString(2, f.getPrezime());
            ps.setString(3, f.getAdresa());
            ps.setString(4, f.getStrucnaSprema());
            ps.setString(5, f.getJmbg());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Komercijalista> getAllKomercijalista() {
        ArrayList<Komercijalista> komercijalisti = new ArrayList<>();
        try {
            query = "SELECT * FROM `komercijalista`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                String jmbg_komercijalista = rs.getString("JMBG_KOMERCIJALISTA");
                String ime_komercijalista = rs.getString("IME_KOMERCIJALISTA");
                String prezime_komercijalista = rs.getString("PREZIME_KOMERCIJALISTA");
                String adresa_komercijalista = rs.getString("ADRESA_KOMERCIJALISTA");
                String telefon_komercijalista = rs.getString("TELEFON_KOMERCIJALISTA");

                Komercijalista k = new Komercijalista(jmbg_komercijalista, ime_komercijalista, prezime_komercijalista, adresa_komercijalista, telefon_komercijalista);
                komercijalisti.add(k);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return komercijalisti;

    }

    public static void addKomercijalista(Komercijalista k) {
        query = "INSERT INTO `komercijalista` (`JMBG_KOMERCIJALISTA`, `IME_KOMERCIJALISTA`, `PREZIME_KOMERCIJALISTA` , `ADRESA_KOMERCIJALISTA`, `TELEFON_KOMERCIJALISTA`) "
                + "VALUES (?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, k.getJmbg());
            ps.setString(2, k.getIme());
            ps.setString(3, k.getPrezime());
            ps.setString(4, k.getAdresa());
            ps.setString(5, k.getBr_telefona());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateKomercijalista(Komercijalista k) {
        query = "UPDATE `komercijalista` SET "
                + "`IME_KOMERCIJALISTA` = ?, "
                + "`PREZIME_KOMERCIJALISTA` = ?, "
                + "`ADRESA_KOMERCIJALISTA` = ?, "
                + "`TELEFON_KOMERCIJALISTA` = ? "
                + "WHERE `komercijalista`.`JMBG_KOMERCIJALISTA` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setString(3, k.getAdresa());
            ps.setString(4, k.getBr_telefona());
            ps.setString(5, k.getJmbg());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Lek> getAllLek() {
        ArrayList<Lek> lekovi = new ArrayList<>();
        try {
            query = "SELECT * FROM `lek`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int sifra_lek = rs.getInt("SIFRA_LEK");
                int id_dobavljac = rs.getInt("ID_DOBAVLJAC");
                String ime_lek = rs.getString("IME_LEK");

                Lek l = new Lek(sifra_lek, id_dobavljac, ime_lek);
                lekovi.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lekovi;

    }

    public static void addLek(Lek lek) {
        query = "INSERT INTO `lek` (`SIFRA_LEK`, `ID_DOBAVLJAC`, `IME_LEK`) "
                + "VALUES (?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, lek.getSifra());
            ps.setInt(2, lek.getDobavljac_id());
            ps.setString(3, lek.getIme());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateLek(Lek l) {
        query = "UPDATE `lek` SET  "
                + " `ID_DOBAVLJAC` = ?, `IME_LEK` = ? WHERE `lek`.`SIFRA_LEK` = ?";

        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, l.getDobavljac_id());
            ps.setString(2, l.getIme());
            ps.setInt(3, l.getSifra());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Maloprodajna_cena> getAllMaloprodajnaCena() {
        ArrayList<Maloprodajna_cena> maloprodajne_cene = new ArrayList<>();
        try {
            query = "SELECT * FROM `maloprodajna_cena`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id_cena = rs.getInt("ID_CENA");
                int id_apoteka = rs.getInt("ID_APOTEKA");
                int sifra_lek = rs.getInt("SIFRA_LEK");
                int cena_leka = rs.getInt("CENA_LEKA");

                Maloprodajna_cena m = new Maloprodajna_cena(id_cena, id_apoteka, sifra_lek, cena_leka);
                maloprodajne_cene.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maloprodajne_cene;

    }

    public static void addMaloprodajnaCena(Maloprodajna_cena m) {
        query = "INSERT INTO `maloprodajna_cena` (`ID_CENA`, `ID_APOTEKA`, `SIFRA_LEK`, `CENA_LEKA`) "
                + "VALUES (NULL,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, m.getApoteka_id());
            ps.setInt(2, m.getSifra_lek());
            ps.setInt(3, m.getCena_leka());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Pacijent> getAllPacijent() {
        ArrayList<Pacijent> pacijenti = new ArrayList<>();
        try {
            query = "SELECT * FROM `pacijent`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                String jmbg_pacijent = rs.getString("JMBG_PACIJENT");
                String jmbg_doktor = rs.getString("JMBG_DOKTOR");
                String ime_pacijent = rs.getString("IME_PACIJENT");
                String adresa_pacijent = rs.getString("ADRESA_PACIJENT");
                int starost_pacijent = rs.getInt("STAROST_PACIJENT");

                Pacijent p = new Pacijent(jmbg_pacijent, jmbg_doktor, ime_pacijent, adresa_pacijent, starost_pacijent);
                pacijenti.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacijenti;

    }

    public static void updateMaloprodajnaCena(Maloprodajna_cena mc) {

        query = "UPDATE `maloprodajna_cena` SET `ID_APOTEKA` = ?, `SIFRA_LEK` = ?, `CENA_LEKA` = ? WHERE `maloprodajna_cena`.`ID_CENA` = ?";

        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, mc.getApoteka_id());
            ps.setInt(2, mc.getSifra_lek());
            ps.setInt(3, mc.getCena_leka());
            ps.setInt(4, mc.getId());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatePacijent(Pacijent p) {
        query = "UPDATE `pacijent` SET  "
                + " `JMBG_DOKTOR` = ?, `IME_PACIJENT` = ?, "
                + "`ADRESA_PACIJENT` = ?, `STAROST_PACIJENT` = ?  WHERE `pacijent`.`JMBG_PACIJENT` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, p.getJmbg_doktor());
            ps.setString(2, p.getIme());
            ps.setString(3, p.getAdresa());
            ps.setInt(4, p.getStarost_pacijent());
            ps.setString(5, p.getJmbg());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addPacijent(Pacijent p) {
        query = "INSERT INTO `pacijent` (`JMBG_PACIJENT`, `JMBG_DOKTOR`, `IME_PACIJENT` , `ADRESA_PACIJENT`, `STAROST_PACIJENT`) "
                + "VALUES (?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, p.getJmbg());
            ps.setString(2, p.getJmbg_doktor());
            ps.setString(3, p.getIme());
            ps.setString(4, p.getAdresa());
            ps.setInt(5, p.getStarost_pacijent());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Recept> getAllRecept() {
        ArrayList<Recept> recepti = new ArrayList<>();
        try {
            query = "SELECT * FROM `recept`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("ID_RECEPT");
                String jmbg_pacijent = rs.getString("JMBG_PACIJENT");
                int sifra_lek = rs.getInt("SIFRA_LEK");
                String jmbg_doktor = rs.getString("JMBG_DOKTOR");
                Date datum = rs.getDate("DATUM");
                int kolicina_lekova = rs.getInt("KOLICINA_LEKOVA");

                Recept r = new Recept(id, jmbg_pacijent, sifra_lek, jmbg_doktor, datum, kolicina_lekova);
                recepti.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return recepti;

    }

    public static void addRecept(Recept r) {
        query = "INSERT INTO `recept` (`ID_RECEPT`, `JMBG_PACIJENT`, `SIFRA_LEK`, `JMBG_DOKTOR`, `DATUM`, `KOLICINA_LEKOVA`) "
                + "VALUES (NULL,?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, r.getJmbg_pacijent());
            ps.setInt(2, r.getSifra_lek());
            ps.setString(3, r.getJmbg_doktor());
            ps.setDate(4, r.getDatum());
            ps.setInt(5, r.getKolicina_lekova());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateRecept(Recept r) {
        query = "UPDATE `recept` SET `JMBG_PACIJENT` = ?, "
                + "`SIFRA_LEK` = ?, "
                + "`JMBG_DOKTOR` = ?, "
                + "`DATUM` = ?, "
                + "`KOLICINA_LEKOVA` = ? "
                + "WHERE `recept`.`ID_RECEPT` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, r.getJmbg_pacijent());
            ps.setInt(2, r.getSifra_lek());
            ps.setString(3, r.getJmbg_doktor());
            ps.setDate(4, r.getDatum());
            ps.setInt(5, r.getKolicina_lekova());
            ps.setInt(6, r.getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Ugovor> getAllUgovor() {
        ArrayList<Ugovor> ugovori = new ArrayList<>();
        try {
            query = "SELECT * FROM `ugovor`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("UGOVOR_ID");
                int id_dobavljac = rs.getInt("ID_DOBAVLJAC");
                int id_apoteka = rs.getInt("ID_APOTEKA");
                String jmbg_komercijalista = rs.getString("JMBG_KOMERCIJALISTA");
                Date pocetak_vazenja = rs.getDate("POCETAK_VAZENJA");
                Date kraj_vazenja = rs.getDate("KRAJ_VAZENJA");
                String tekst_ugovor = rs.getString("TEKST_UGOVOR");

                Ugovor u = new Ugovor(id, id_dobavljac, id_apoteka, jmbg_komercijalista, pocetak_vazenja, kraj_vazenja, tekst_ugovor);
                ugovori.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return ugovori;

    }

    public static void addUgovor(Ugovor u) {
        query = "INSERT INTO `ugovor` (`UGOVOR_ID`, `ID_DOBAVLJAC`, `ID_APOTEKA`, `JMBG_KOMERCIJALISTA`, `POCETAK_VAZENJA`, `KRAJ_VAZENJA`, `TEKST_UGOVOR`) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, u.getId());
            ps.setInt(2, u.getId_dobavljac());
            ps.setInt(3, u.getId_apoteka());
            ps.setString(4, u.getJmbg_komercijalista());
            ps.setDate(5, u.getPocetak_vazenja());
            ps.setDate(6, u.getKraj_vazenja());
            ps.setString(7, u.getTekst_ugovor());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateUgovor(Ugovor u) {
        query = "UPDATE `ugovor` SET `ID_DOBAVLJAC` = ?, "
                + "`ID_APOTEKA` = ?, "
                + "`POCETAK_VAZENJA` = ?, "
                + "`KRAJ_VAZENJA` = ?, "
                + "`TEKST_UGOVOR` = ?, "
                + "`JMBG_KOMERCIJALISTA` = ? "
                + "WHERE `ugovor`.`UGOVOR_ID` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, u.getId_dobavljac());
            ps.setInt(2, u.getId_apoteka());
            ps.setDate(3, u.getPocetak_vazenja());
            ps.setDate(4, u.getKraj_vazenja());
            ps.setString(5, u.getTekst_ugovor());
            ps.setString(6, u.getJmbg_komercijalista());
            ps.setInt(7, u.getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Zamena> getAllZamena() {
        ArrayList<Zamena> zamene = new ArrayList<>();
        try {
            query = "SELECT * FROM `zamena`";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                int zamena_id = rs.getInt("ZAMENA_ID");
                int sifra_lek = rs.getInt("SIFRA_LEK");
                int zamena_sifra_lek = rs.getInt("ZAMENA_SIFRA_LEK");

                Zamena z = new Zamena(zamena_id, sifra_lek, zamena_sifra_lek);
                zamene.add(z);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return zamene;
    }

    public static void addZamena(Zamena z) {
        query = "INSERT INTO `zamena` (`ZAMENA_ID`, `SIFRA_LEK`, `ZAMENA_SIFRA_LEK`) "
                + "VALUES (?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, z.getZamena_id());
            ps.setInt(2, z.getSifra_lek());
            ps.setInt(3, z.getZamena_sifra_lek());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateZamena(Zamena z) {
        query = "UPDATE `zamena` SET `SIFRA_LEK` = ?, `ZAMENA_SIFRA_LEK` = ? WHERE `zamena`.`ZAMENA_ID` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, z.getSifra_lek());
            ps.setInt(2, z.getZamena_sifra_lek());
            ps.setInt(3, z.getZamena_id());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void delete(Angazovanje a) {
        query = "DELETE FROM `angazovanje` WHERE `angazovanje`.`ID_ANGAZOVANJE` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, a.getId());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Apoteka a) {
        query = "DELETE FROM `apoteka` WHERE `apoteka`.`ID_APOTEKA` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, a.getId());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Dobavljac d) {
        query = "DELETE FROM `dobavljac` WHERE `dobavljac`.`ID_DOBAVLJAC` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, d.getId());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Doktor d) {
        query = "DELETE FROM `doktor` WHERE `doktor`.`JMBG_DOKTOR` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, d.getJmbg());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Farmaceut f) {
        query = "DELETE FROM `farmaceut` WHERE `farmaceut`.`JMBG_FARMACEUT` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, f.getJmbg());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Komercijalista k) {
        query = "DELETE FROM `komercijalista` WHERE `komercijalista`.`JMBG_KOMERCIJALISTA` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, k.getJmbg());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Lek l) {
        query = "DELETE FROM `lek` WHERE `lek`.`SIFRA_LEK` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, l.getSifra());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Maloprodajna_cena m) {
        query = "DELETE FROM `maloprodajna_cena` WHERE `maloprodajna_cena`.`ID_CENA` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, m.getId());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Pacijent p) {
        query = "DELETE FROM `pacijent` WHERE `pacijent`.`JMBG_PACIJENT` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setString(1, p.getJmbg());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Recept r) {
        query = "DELETE FROM `recept` WHERE `recept`.`ID_RECEPT` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, r.getId());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Ugovor u) {
        query = "DELETE FROM `ugovor` WHERE `ugovor`.`UGOVOR_ID` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, u.getId());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(Zamena z) {
        query = "DELETE FROM `zamena` WHERE `zamena`.`ZAMENA_ID` = ?";
        try {
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, z.getZamena_id());
            ps.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce obrisati objekat.");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
