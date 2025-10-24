class Consommateur extends Thread {
    private Bal bal;

    public Consommateur(Bal b) {
        this.bal = b;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 5) { // consomme 5 lettres
            String message = bal.retirer();
            System.out.println("Consommateur a lu : " + message);
            try {
                sleep(1500); // simulation du temps de lecture
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            i++;
        }
    }
}
