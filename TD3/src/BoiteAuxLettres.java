
public class BoiteAuxLettres {
    public static void main(String[] args) {
        Bal bal = new Bal();
        Producteur p = new Producteur(bal);
        Consommateur c = new Consommateur(bal);
        p.start();
        c.start();
    }
}