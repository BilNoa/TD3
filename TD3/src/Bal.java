public class Bal {
    private String lettre;      // ressource partagée
    private boolean dispo = false;  // état : vide (false) ou pleine (true)

    // Méthode pour déposer une lettre
    public synchronized void deposer(String l) {
        // tant que la BAL est pleine, on attend
        while (dispo) {
            try {
                wait();  // met le producteur en attente
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // on dépose la lettre
        lettre = l;
        dispo = true;
        System.out.println("Producteur : dépose la lettre \"" + lettre + "\"");
        notifyAll(); // réveille le consommateur
    }

    // Méthode pour retirer une lettre
    public synchronized String retirer() {
        // tant que la BAL est vide, on attend
        while (!dispo) {
            try {
                wait();  // met le consommateur en attente
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // on retire la lettre
        String l = lettre;
        dispo = false;
        System.out.println("Consommateur : retire la lettre \"" + l + "\"");
        notifyAll(); // réveille le producteur
        return l;
    }
}
