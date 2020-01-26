package io.github.ahenteti.java.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaSortSolution {

    static class Student {
        private Integer id;
        private String name;
        private Double cgpa;

        public Student(Integer id, String name, Double cgpa) {
            super();
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Double getCgpa() {
            return cgpa;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> students = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String name = in.next();
            double cgpa = in.nextDouble();
            students.add(new Student(id, name, cgpa));
            testCases--;
        }

        students.sort((s1, s2) -> {
            if (s1.getCgpa().equals(s2.getCgpa())) {
                if (s1.getName().equals(s2.getName())) {
                    return s1.getId().compareTo(s2.getId());
                } else {
                    return s1.getName().compareTo(s2.getName());
                }
            } else {
                return s2.getCgpa().compareTo(s1.getCgpa());
            }
        });

        for (Student st : students) {
            System.out.println(st.getName());
        }
    }
}
