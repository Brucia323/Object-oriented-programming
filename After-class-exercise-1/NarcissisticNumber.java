public class NarcissisticNumber {

    public static void main(String[] args) {
        int number = 100, a, b, c;
        while (number < 1000) {
            a = number / 100;
            b = (number % 100) / 10;
            c = number % 10;
            if (power(a) + power(b) + power(c) == number) {
                System.out.println(number);
            }
            number++;
        }
    }

    public static int power(int a) {
        return a * a * a;
    }
}
