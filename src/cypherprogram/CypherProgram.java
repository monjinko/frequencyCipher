/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypherprogram;

/**
 *
 * @author Jinho
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CypherProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        char[] tble2 = new char[]{'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] tble = new char[]{'Z', 'J', 'Q', 'X', 'K', 'V',
            'B', 'P', 'G', 'W', 'Y', 'F', 'M', 'C', 'U', 'L', 'D',
            'H', 'R', 'S', 'N', 'I', 'O', 'A', 'T', 'E'};

        int[] freq = new int[26];
        int[] sorted = new int[26];
        char[] freqT = new char[26];

        FileReader fIn = new FileReader("shakespeare_cipher.txt");
        BufferedReader br = new BufferedReader(fIn);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        String text = sb.toString();
        int tLength = text.length();
        freqCounter(text, freq);
        detectDup(freq);
        System.arraycopy(freq, 0, sorted, 0, freq.length);
        QS ob = new QS();
        ob.sort(sorted, 0, freq.length - 1);

        for (int i = 0; i < 26; i++) {

            for (int j = 0; j < 26; j++) {
                if (freq[i] == sorted[j]) {

                    freqT[j] = tble2[i]; //places char in order of incr. freq.                   
                }
            }
        }
        char[] s1 = text.toCharArray();

        System.out.println();
        System.out.println("Frequency of Letters Unsorted");
        for (int i = 0; i < freq.length; i++) {
            System.out.print(tble2[i] + ":" + freq[i] + " ");
        }
        System.out.println();

        System.out.println("Freq UnOrdered but Increasing freq. Alpha.");
        for (int i = 0; i < freqT.length; i++) {
            System.out.print(freqT[i] + ":" + sorted[i] + " ");
        }
        System.out.println();

        System.out.println("Frequency of Letters Sorted");
        for (int i = 0; i < freq.length; i++) {
            System.out.print(tble[i] + ":" + sorted[i] + " ");
        }
        System.out.println();
        System.out.println();

        char[] temp = matchAlpha(freqT, tble2, tble);

        System.out.println("Freq Ordered Alpha.");
        for (int i = 0; i < freq.length; i++) {
            System.out.print(tble2[i]);
        }
        System.out.println();
        for (int i = 0; i < freqT.length; i++) {
            System.out.print(temp[i]);
        }
        System.out.println();

        finalCipher(s1, temp, tLength);

        System.out.println();
        System.out.println("Final Text");
        for (int i = 0; i < s1.length; i++) {
            System.out.print(s1[i]);
        }
        
        System.out.println();
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("DO YOU WANT TO GUESS A LETTER?");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("N")) {

            if (command.equals("Y")) {

                System.out.println("Type letter you want to switch");
                char gs = scanner.next(".").charAt(0);
                System.out.println("Type letter you want to switch to");
                char sw = scanner.next(".").charAt(0);

                guessHelper(gs, sw, temp, tble2);

                s1 = text.toCharArray();

                finalCipher(s1, temp, tLength);

                System.out.println();
                System.out.println("Final Text");
                for (int i = 0; i < s1.length; i++) {
                    System.out.print(s1[i]);
                }
                System.out.println();

                System.out.println("DO YOU WANT TO GUESS AGAIN?");

            }

            command = scanner.nextLine();
        }

    }

    public static void freqCounter(String text, int[] freq) {
        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == 'A') {
                freq[0] += 1;
            }
            if (text.charAt(i) == 'B') {
                freq[1] += 1;
            }
            if (text.charAt(i) == 'C') {
                freq[2] += 1;
            }
            if (text.charAt(i) == 'D') {
                freq[3] += 1;
            }
            if (text.charAt(i) == 'E') {
                freq[4] += 1;
            }
            if (text.charAt(i) == 'F') {
                freq[5] += 1;
            }
            if (text.charAt(i) == 'G') {
                freq[6] += 1;
            }
            if (text.charAt(i) == 'H') {
                freq[7] += 1;
            }
            if (text.charAt(i) == 'I') {
                freq[8] += 1;
            }
            if (text.charAt(i) == 'J') {
                freq[9] += 1;
            }
            if (text.charAt(i) == 'K') {
                freq[10] += 1;
            }
            if (text.charAt(i) == 'L') {
                freq[11] += 1;
            }
            if (text.charAt(i) == 'M') {
                freq[12] += 1;
            }
            if (text.charAt(i) == 'N') {
                freq[13] += 1;
            }
            if (text.charAt(i) == 'O') {
                freq[14] += 1;
            }
            if (text.charAt(i) == 'P') {
                freq[15] += 1;
            }
            if (text.charAt(i) == 'Q') {
                freq[16] += 1;
            }
            if (text.charAt(i) == 'R') {
                freq[17] += 1;
            }
            if (text.charAt(i) == 'S') {
                freq[18] += 1;
            }
            if (text.charAt(i) == 'T') {
                freq[19] += 1;
            }
            if (text.charAt(i) == 'U') {
                freq[20] += 1;
            }
            if (text.charAt(i) == 'V') {
                freq[21] += 1;
            }
            if (text.charAt(i) == 'W') {
                freq[22] += 1;
            }
            if (text.charAt(i) == 'X') {
                freq[23] += 1;
            }
            if (text.charAt(i) == 'Y') {
                freq[24] += 1;
            }
            if (text.charAt(i) == 'Z') {
                freq[25] += 1;
            }

        }
    }

    public static void guessHelper(char find, char swtch, char[] temp, char[] tble2) {

        int x = 0, y = 0;
        char org = ' ';
        for (int i = 0; i < temp.length; i++) {

            if (temp[i] == find) {

                x = i;
            } else if (temp[i] == swtch) {
                y = i;
            }
        }

        org = temp[x];
        temp[x] = swtch;
        temp[y] = org;
    }

    public static void finalCipher(char[] str, char[] temp, int tLength) {

        for (int i = 0; i < tLength; i++) {

            if (str[i] == 'A') {
                str[i] = temp[0];
            } else if (str[i] == 'B') {
                str[i] = temp[1];
            } else if (str[i] == 'C') {
                str[i] = temp[2];
            } else if (str[i] == 'D') {
                str[i] = temp[3];
            } else if (str[i] == 'E') {
                str[i] = temp[4];
            } else if (str[i] == 'F') {
                str[i] = temp[5];
            } else if (str[i] == 'G') {
                str[i] = temp[6];
            } else if (str[i] == 'H') {
                str[i] = temp[7];
            } else if (str[i] == 'I') {
                str[i] = temp[8];
            } else if (str[i] == 'J') {
                str[i] = temp[9];
            } else if (str[i] == 'K') {
                str[i] = temp[10];
            } else if (str[i] == 'L') {
                str[i] = temp[11];
            } else if (str[i] == 'M') {
                str[i] = temp[12];
            } else if (str[i] == 'N') {
                str[i] = temp[13];
            } else if (str[i] == 'O') {
                str[i] = temp[14];
            } else if (str[i] == 'P') {
                str[i] = temp[15];
            } else if (str[i] == 'Q') {
                str[i] = temp[16];
            } else if (str[i] == 'R') {
                str[i] = temp[17];
            } else if (str[i] == 'S') {
                str[i] = temp[18];
            } else if (str[i] == 'T') {
                str[i] = temp[19];
            } else if (str[i] == 'U') {
                str[i] = temp[20];
            } else if (str[i] == 'V') {
                str[i] = temp[21];
            } else if (str[i] == 'W') {
                str[i] = temp[22];
            } else if (str[i] == 'X') {
                str[i] = temp[23];
            } else if (str[i] == 'Y') {
                str[i] = temp[24];
            } else if (str[i] == 'Z') {
                str[i] = temp[25];
            }

        }
    }

    public static void detectDup(int arr[]) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {

                    arr[i] = arr[i] + 1;
                }
            }
        }

    }

    public static char[] matchAlpha(char[] f1, char[] tbl2, char[] tbl) {

        char AS[] = new char[26];

        for (int i = 0; i < f1.length; i++) {

            for (int j = 0; j < 26; j++) {

                if (tbl2[i] == f1[j]) {

                    AS[i] = tbl[j];
                }
            }

        }
        return AS;
    }

}

class QS {

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }

    }

    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j] 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
