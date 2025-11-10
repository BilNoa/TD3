class Producteur extends Thread {
    private Bal bal;

    public Producteur(Bal bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        try {
            for (char c = 'A'; c <= 'Z'; c++) {
                String message = String.valueOf(c);
                boolean added = bal.deposer(message);
                if (added) {
                    System.out.println("Producteur : dépose la lettre \"" + message + "\"");
                } else {
                    System.out.println("Producteur : La BAL est pleine, j'ai dû attendre pour déposer.");
                }
                sleep(1000);
            }

            bal.deposer("*");
            System.out.println("Producteur a terminé la production !");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
