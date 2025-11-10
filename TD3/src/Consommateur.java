class Consommateur extends Thread {
    private Bal bal;

    public Consommateur(Bal bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = bal.retirer();
                if (message != null) {
                    System.out.println("Consommateur a lu : " + message);
                } else {
                    System.out.println("Consommateur n'a rien à lire !");
                }
                sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
