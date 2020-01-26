package io.github.ahenteti.java.hackerrank;

import java.util.Scanner;

public class NewYearChaosSolution {

    public static class Person {
        int currentPosition;
        int initialPosition;

        public Person(int currentPosition, int initialPosition) {
            this.currentPosition = currentPosition;
            this.initialPosition = initialPosition;
        }

        static Person[] from(int[] persons) {
            Person[] res = new Person[persons.length];
            for (int i = 0; i < persons.length; i++) {
                res[i] = new Person(i + 1, persons[i]);
            }
            return res;
        }

        static void swap(Person person1, Person person2) {
            int tmpPosition = person1.initialPosition;
            person1.initialPosition = person2.initialPosition;
            person2.initialPosition = tmpPosition;
        }

        static Person get(Person[] persons, int pos) {
            try {
                return persons[pos];
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
    }

    static void minimumBribes(int[] arr) {
        Person[] persons = Person.from(arr);
        int n = persons.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            Person currentPerson = persons[i];
            if (currentPerson.currentPosition != currentPerson.initialPosition) {
                // we are in the case of a bribe
                Person nextPerson = Person.get(persons, i - 1);
                Person nextNextPerson = Person.get(persons, i - 2);
                if (nextPerson != null && nextPerson.initialPosition == currentPerson.currentPosition) {
                    res++;
                    Person.swap(nextPerson, currentPerson);
                } else if (nextNextPerson != null && nextNextPerson.initialPosition == currentPerson.currentPosition) {
                    res += 2;
                    Person.swap(nextNextPerson, nextPerson);
                    Person.swap(nextPerson, currentPerson);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;

        for (int tItr = 0; tItr < t; tItr++) {
            int n = 5;

            int[] q = new int[n];

            String[] qItems = "2 1 5 3 4".split(" ");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
