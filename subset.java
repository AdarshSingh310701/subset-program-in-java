import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the first array size");
        int size1 = sc.nextInt();
        if (size1 <= 0) {
            System.out.println(size1 + " is an invalid array size");
            return;
        }
        
        System.out.println("Enter the numbers");
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            array1[i] = sc.nextInt();
        }
        
        System.out.println("Enter the second array size");
        int size2 = sc.nextInt();
        if (size2 <= 0) {
            System.out.println(size2 + " is an invalid array size");
            return;
        }
        if (size2 > size1) {
            System.out.println(size2 + " is an invalid size as it is greater than first array size " + size1);
            return;
        }
        
        System.out.println("Enter the numbers");
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            array2[i] = sc.nextInt();
        }
        
        boolean isSubset = checkSubset(array1, array2);
        if (isSubset) {
            System.out.println("Array2 of size " + size2 + " is a subset of array1");
        } else {
            System.out.println("Array2 of size " + size2 + " is not a subset of array1");
        }
    }
    
    private static boolean checkSubset(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                i++;
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            } else {
                return false;
            }
        }
        
        return j == array2.length;
    }
}
