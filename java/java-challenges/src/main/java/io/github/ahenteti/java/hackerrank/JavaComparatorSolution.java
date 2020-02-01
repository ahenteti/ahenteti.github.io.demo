package io.github.ahenteti.java.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class JavaComparatorSolutionChecker implements Comparator<JavaComparatorSolutionPlayer> {
    @Override
    public int compare(JavaComparatorSolutionPlayer o1, JavaComparatorSolutionPlayer o2) {
        if (o1.score == o2.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o2.score - o1.score;
        }
    }
}

class JavaComparatorSolutionPlayer{
    String name;
    int score;

    JavaComparatorSolutionPlayer(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class JavaComparatorSolutionMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        JavaComparatorSolutionPlayer[] player = new JavaComparatorSolutionPlayer[n];
        JavaComparatorSolutionChecker checker = new JavaComparatorSolutionChecker();

        for(int i = 0; i < n; i++){
            player[i] = new JavaComparatorSolutionPlayer(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
