import java.util.concurrent.*;

public class Bal {

    private BlockingQueue<String> tampon;
    int tailleMax = 5;

    public Bal() {
        tampon = new ArrayBlockingQueue<>(tailleMax);
    }

    public boolean deposer(String lettre) throws InterruptedException {
        return tampon.offer(lettre, 200, TimeUnit.MILLISECONDS);
    }

    public String retirer() throws InterruptedException {
        return tampon.poll(200, TimeUnit.MILLISECONDS);
    }

    public int getStock() {
        return tampon.size();
    }
}