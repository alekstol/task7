package org.example;

import java.util.Scanner;

public class task7 {
    public static boolean prostoe(int n){
        int mod = Math.abs(n);
        if (mod == 0){
            return true;
        }
        if (mod==1){
            return false;
        }
        if (mod==2){
            return true;
        }
        for (int i =3; i <= Math.sqrt(mod); i += 2){
            if ( mod % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int firstindex = -1;
        int lastindex = -1;
        for (int i =0; i < arr.length; i++){
            if (org.example.task7.prostoe(arr[i])) {
                if (firstindex == -1) {
                    firstindex = i;
                }
                lastindex = i;
            }
        }
        if (firstindex == -1 || firstindex == lastindex) {
            return 0;
        }
        int sum = 0;
        for (int i = firstindex + 1; i < lastindex; i++) {
            if (arr[i] % 2 == 0) {
                sum = sum + arr[i];
            }
        }
        return sum;
    }
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            return new int[0];
        }
        int[] arr = new int[n];
        System.out.println("Введите " + n + " элементов");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.print("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public static void runTests() {
        int[] t1 = {4, 3, 8, 2, 6, 5, 10};
        test(t1, 16);
        int[] t2 = {4, 6, 9, 15};
        test(t2, 0);
        int[] t3 = {4, 6, 8, 9, 15, 1};
        test(t3, 0);
        int[] t4 = {10, 3, 5, 20};
        test(t4, 0);
        int[] t5 = {-3, 4, 0, 6, 7};
        test(t5, 10);
        int[] t6 = {0};
        test(t6, 0);
        int[] t7 = {0, 0};
        test(t7, 0);
        int[] t8 = {2, 4, 6, 8, 3};
        test(t8, 4 + 6 + 8);
        int[] t9 = {9, 10, 0, 12, 13};
        test(t9, 12);
        int[] t10 = {-5, 1, 4, 2};
        test(t10, 4);
        int[] t11 = {};
        test(t11, 0);
    }

    public static void test(int[] arr, int expected) {
        int result = solution(arr);
        System.out.print("Массив: ");
        printArray(arr);
        System.out.println(" результат: " + result + " ожидалось: " + expected);
        if (result != expected) {
            System.out.println("Не выполнено");
        } else {
            System.out.println("Выполнено");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        runTests();
        int[] userArray = inputArray();
        System.out.print("массив: ");
        printArray(userArray);
        System.out.println();
        int result = solution(userArray);
        System.out.println("Сумма  " + result);
    }
}
