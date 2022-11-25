import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Sort.sort;
import person.Student;

public class App {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> ArrayList<Student<T>> createRandomArray(int arrayLength, String typeName) {
        ArrayList<Student<T>> arrayList = new ArrayList<>(arrayLength);
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            String id = String.valueOf(i);
            switch (typeName) {
                case "Integer":
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    break;
                case "Float":
                    arrayList.add((Student<T>) new Student<Float>(id, random.nextFloat(100)));
                    break;
                case "Double":
                    arrayList.add((Student<T>) new Student<Double>(id, random.nextDouble(100)));
                    break;
                default:
                    System.out.println("Use Integer as the grade data type.");
            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please input the array size: ");
            int arrayLength = scanner.nextInt();
            System.out.print("Please input the grade data type: (choose Integer, Float, or Double): ");
            String typeName = scanner.next();
            ArrayList<Student<T>> arrayList = createRandomArray(arrayLength, typeName);
            System.out.println(arrayList.toString());
            System.out.print("Is the array sorted? ");
            System.out.println(sort.isSorted(arrayList));
            System.out.println("Sorting array...");
            sort.mergeSort(arrayList, 0, arrayLength);
            System.out.println(arrayList.toString());
            System.out.print("Array Sorted? ");
            System.out.println(sort.isSorted(arrayList));
            System.out.print("Continue? Please enter yes or no: ");
            String yesNo = scanner.next();
            if (yesNo.equals("no"))
                System.out.println("Goodbye!");
            break;
        }
        scanner.close();

    }
}
