package io.github.ahenteti.java.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class JavaPriorityQueueSolutionStudent {
    private String name;
    private double cgpa;
    private int id;

    public JavaPriorityQueueSolutionStudent(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getId() {
        return id;
    }
}

class JavaPriorityQueueSolutionPriorities {

    public List<JavaPriorityQueueSolutionStudent> getStudents(List<String> events) {
        PriorityQueue<JavaPriorityQueueSolutionStudent> students = new PriorityQueue<>(Comparator.comparing(JavaPriorityQueueSolutionStudent::getCgpa).reversed()
                .thenComparing(JavaPriorityQueueSolutionStudent::getName).thenComparing(JavaPriorityQueueSolutionStudent::getId));
        for (String event : events) {
            String[] eventComponents = event.split(" ");
            String eventName = eventComponents[0];
            if ("ENTER".equals(eventName)) {
                String studentName = eventComponents[1];
                double studentCgpa = Double.parseDouble(eventComponents[2]);
                int studentId = Integer.parseInt(eventComponents[3]);
                students.add(new JavaPriorityQueueSolutionStudent(studentName, studentCgpa, studentId));
            } else {
                students.poll();
            }
        }
        List<JavaPriorityQueueSolutionStudent> res = new ArrayList<>();
        JavaPriorityQueueSolutionStudent first = students.poll();
        while (first != null) {
            res.add(first);
            first = students.poll();
        }
        return res;
    }
}

class JavaPriorityQueueSolutionMain {

    private final static Scanner scan = new Scanner(System.in);
    private final static JavaPriorityQueueSolutionPriorities priorities = new JavaPriorityQueueSolutionPriorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<JavaPriorityQueueSolutionStudent> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (JavaPriorityQueueSolutionStudent st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
