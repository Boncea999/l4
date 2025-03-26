package exemplulab;
import java.io.*;
import java.util.*;

/**
 * Enumerare pentru starea echipamentului.
 * Definește stările posibile ale unui echipament electronic.
 */
enum Stare {
    ACHIZITIONAT, /**< Echipamentul a fost achiziționat */
    EXPUS, /**< Echipamentul este expus în magazin */
    VANDUT /**< Echipamentul a fost vândut */
}

/**
 * Enumerare pentru tipul de tipărire al imprimantei.
 */
enum TipTiparire { COLOR, ALB_NEGRU; }

/**
 * Enumerare pentru formatul copiatorului.
 */
enum FormatCopiere { A3, A4; }

/**
 * Enumerare pentru sistemele de operare disponibile.
 */
enum SistemOperare { WINDOWS, LINUX; }

/**
 * Clasa abstractă pentru echipamente electronice.
 * Aceasta oferă baza pentru toate tipurile de echipamente comercializate.
 */
abstract class Echipament implements Serializable {
    protected String denumire;
    protected int nrInv;
    protected double pret;
    protected Stare stare;

    /**
     * Constructor pentru clasa Echipament.
     * @param denumire Numele echipamentului
     * @param nrInv Numarul de inventar
     * @param pret Prețul echipamentului
     * @param stare Starea echipamentului
     */
    public Echipament(String denumire, int nrInv, double pret, Stare stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.stare = stare;
    }

    /**
     * Setează starea echipamentului.
     * @param stare Noua stare a echipamentului
     */
    public void setStare(Stare stare) {
        this.stare = stare;
    }

    /**
     * Returnează starea echipamentului.
     * @return Starea echipamentului
     */
    public Stare getStare() {
        return stare;
    }

    /**
     * Returnează detalii despre echipament sub formă de string.
     * @return Reprezentarea echipamentului ca text
     */
    @Override
    public String toString() {
        return "Echipament: " + denumire + ", Inventar: " + nrInv + ", Pret: " + pret + ", Stare: " + stare;
    }
}

/**
 * Clasa principală pentru gestionarea echipamentelor electronice.
 */
public class MagazinElectronice {
    private static List<Echipament> echipamente = new ArrayList<>();

    /**
     * Punctul de intrare în program.
     * @param args Argumente din linia de comandă
     */
    public static void main(String[] args) {
        citireDinFisier("echipamente.txt");
        meniu();
    }

    /**
     * Afișează meniul și procesează comenzile utilizatorului.
     */
    private static void meniu() {
        Scanner scanner = new Scanner(System.in);
        int optiune;
        do {
            System.out.println("1. Afisare echipamente\n2. Afisare imprimante\n3. Afisare copiatoare\n4. Afisare sisteme de calcul\n5. Exit");
            optiune = scanner.nextInt();
            switch (optiune) {
                case 1 -> echipamente.forEach(System.out::println);
                case 2 -> afisareImprimante();
                case 3 -> afisareCopiatoare();
                case 4 -> afisareSistemeCalcul();
            }
        } while (optiune != 5);
    }

    /**
     * Citește echipamentele dintr-un fișier și le adaugă în colecție.
     * @param fisier Numele fișierului de intrare
     */
    private static void citireDinFisier(String fisier) {
        try (Scanner scanner = new Scanner(new File(fisier))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit!");
        }
    }

    /**
     * Afișează toate imprimantele din colecție.
     */
    private static void afisareImprimante() { /* Implementare */ }

    /**
     * Afișează toate copiatoarele din colecție.
     */
    private static void afisareCopiatoare() { /* Implementare */ }

    /**
     * Afișează toate sistemele de calcul din colecție.
     */
    private static void afisareSistemeCalcul() { /* Implementare */ }

    /**
     * Salvează lista de echipamente într-un fișier binar.
     */
    private static void serializare() { /* Implementare */ }

    /**
     * Încarcă lista de echipamente dintr-un fișier binar.
     */
    private static void deserializare() { /* Implementare */ }
}
