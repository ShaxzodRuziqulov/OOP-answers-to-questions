package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Mark {
    private final String name;
    private final List<Double> marks;

    public Mark(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Double> getMarks() {
        return marks;
    }

    public Double calculateAverageMark() {
        double totalMark = 0;
        for (Double m : marks) {
            totalMark += m;
        }
        return marks.isEmpty() ? 0.0 : totalMark / marks.size();
    }

    public Double findHighestMark() {
        double highestMark = 0;
        for (Double m :
                marks) {
            if (m > highestMark)
                highestMark = m;
        }
        return highestMark;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ism kiriting:");
        String name = scanner.next();

        Mark student = new Mark(name);
        System.out.println("Baholar sonini kiriting:");
        int markCount = scanner.nextInt();

        System.out.println("Baholarni kiriting:");
        for (int i = 0; i < markCount; i++) {
            while (!scanner.hasNextDouble()) {
                System.out.println("Noto'g'ri kiritish! Baholarni qaytadan kiriting:");
                scanner.next();
            }
            double mark = scanner.nextDouble();
            student.getMarks().add(mark);
        }


        double averageMark = student.calculateAverageMark();
        double findHighestMark = student.findHighestMark();
        System.out.println(student.getName() + " uchun o'rtacha baho: " + averageMark);
        System.out.println(student.getName() + " uchun max baho " + findHighestMark);
    }
}
