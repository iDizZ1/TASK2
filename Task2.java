import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        //System.out.println(duplicateChars("Barack", "Obama"));

        //System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));

        //System.out.println(getInitials("simonov sergei evgenievich"));
        //System.out.println(getInitials("kozhevnikova tatiana vitalevna"));

        //System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5));
        //System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0})));

        //System.out.println(Arrays.toString(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5})));

        //System.out.println(camelToSnake("helloWorld"));

        //System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));

        //System.out.println(localReverse("baobab", 'b'));
        //System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));

        //System.out.println(equal(8,1,8));
        //System.out.println(equal(5,5,5));
        //System.out.println(equal(4,9,6));

        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }
    public static String duplicateChars(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char s = a.charAt(i);
            if (b.indexOf(s) == -1) {
                str.append(s);
            }
        }
        return str.toString();
    }
    public static int dividedByThree(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 != 0 && number % 3 == 0) {
                count++;
            }
        }
        return count;

    }
    public static String getInitials(String s) {
        String[] str = s.split(" ");
        String f = str[0].toUpperCase().charAt(0) + str[0].substring(1);
        char i = str[1].toUpperCase().charAt(0);
        char o = str[2].toUpperCase().charAt(0);
        return i + "." + o + "." + f;
    }
    public static double[] normalizator(double[] numbers) {
        double min = Arrays.stream(numbers).min().getAsDouble();
        double max = Arrays.stream(numbers).max().getAsDouble();
        for (int i = 0; i< numbers.length; i++) {
            if (max != min) {
                numbers[i] = (numbers[i] - min)/(max-min);
            }
            else {
                numbers[i] = 0.0D;
            }
        }
        return numbers;
    }
    public static int[] compressedNums(double[] numbers) {
        int count = 0;
        int[] mas = new int[numbers.length];
        for (int i =0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                count++;
            }
            mas[i] = (int) numbers[i];
        }
        Arrays.sort(mas);
        mas = Arrays.copyOfRange(mas, count, mas.length);
        return mas;

    }
    public static String camelToSnake(String str) {
        int count = 0;
        StringBuilder st = new StringBuilder();
        String str1 = str.toUpperCase();
        for (int i = 0; i<str.length(); i++) {
            char s = str.charAt(i);
            char s1 = str1.charAt(i);
            if (s == s1){
                st.append("_");
            }
            st.append(str.toLowerCase().charAt(i));
            count++;

        }
        return (st.toString());

    }
    public static int secondBiggest(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-2];
    }
    public static String localReverse(String str, char ch) {
        StringBuilder st = new StringBuilder();
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }

        boolean isEven = count % 2 == 0;
        int part = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != ch) {
                st.append(currentChar);
            }
            else
            {
                if (isEven) {
                    part = str.indexOf(ch, i + 1);
                }
                else {
                    part = str.indexOf(ch, str.indexOf(ch, i + 1) + 1);
                }
                if (part != -1) {
                    st.append(new StringBuilder(str.substring(i, part + 1)).reverse());
                    i = part;
                }
                else {
                    st.append(ch);
                }
            }
        }

        return st.toString();
    }
    public static int equal(int a, int b, int c) {
        if (a == b && b== c) {
            return 3;
        }
        if (a == b || b== c || a ==c) {
            return 2;
        }
        return 0;
    }
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] s1 = a.toLowerCase().toCharArray();
        char[] s2 = b.toLowerCase().toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1,s2);

    }
}