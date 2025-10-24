public class Producteur extends Thread {
    private Bal bal;

    public Producteur(Bal b) {
        this.bal = b;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 5) { // produit 5 lettres
            String message = "Lettre n°" + i;
            bal.deposer(message);
            try {
                sleep(1000); // simulation du temps de production
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            i++;
        }
    }
}
