import java.util.Random;

public class Utils {
    public static int getRandomNumberInRange(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

}
