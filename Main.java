Нижче наведено приклади простого коду Java для обробки даних, який включає в себе роботу з масивами, колекціями, використання стрімів та виконання основних операцій над даними.

```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Define a new array
        int[] array = new int[50]; 

        // Populate the array with random integers
        Random rand = new Random(); 
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); 
        }

        // Convert the array to a list
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        // Output the original list
        System.out.println("Original List: " + list);

        // Sort the list
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // Filter out odd numbers
        List<Integer> evenNumbers = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Square the even numbers
        List<Integer> squaredNumbers = evenNumbers.stream().map(num -> num * num).collect(Collectors.toList());
        System.out.println("Squared even numbers: " + squaredNumbers);

        // Calculate sum and average
        int sum = list.stream().reduce(0, Integer::sum);
        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        // Group the numbers by their last digit
        Map<Integer, List<Integer>> groupedByLastDigit = list.stream()
                                                             .collect(Collectors.groupingBy(num -> num % 10));

        System.out.println("Numbers grouped by their last digit: " + groupedByLastDigit);

        // Get the maximum and minimum number
        int maxNumber = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        int minNumber = list.stream().mapToInt(Integer::intValue).min().getAsInt();

        System.out.println("Max number: " + maxNumber);
        System.out.println("Min number: " + minNumber);
    }
}
```
Цей код обробляє масив випадкових чисел, виконує різні операції над ним (фільтрація, сортування, квадратування, групування тощо), а також обчислює суму та середнє значення масиву.