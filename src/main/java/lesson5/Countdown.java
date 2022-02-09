package lesson5;

public class Countdown {
    public static void main(String[] args) {
        countdown(5); //5 4 3 2 1
    }

    private static void countdown(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(n);
        countdown(n - 1);
        System.out.println("End n = " + n);

    }
}
