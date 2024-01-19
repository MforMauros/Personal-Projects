package gr.aueb.cf.ch9;

import java.io.*;

public class GradesAverageApp {

    public static void main(String[] args) {
        String line = "";
        String[] student;
        int grade1 = 0;
        int grade2 = 0;
        int sum = 0;
        double avg = 0.0;

        try (BufferedReader grades = new BufferedReader(new FileReader("/Users/mixalismavromanolakis/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/grades.txt"));
             PrintStream primOut = new PrintStream(new FileOutputStream("/Users/mixalismavromanolakis/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/primOut.txt"));
             PrintStream log = new PrintStream(new FileOutputStream("/Users/mixalismavromanolakis/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/ch9/log.txt"));
        ) {
            while ((line = grades.readLine()) != null) {
                student = line.split(" +");
                if (isInt(student[2])) {
                    grade1 = Integer.parseInt(student[2]);
                }
                if (isInt(student[3])) {
                    grade2 = Integer.parseInt(student[3]);
                }

                if ((grade1 < 0 || grade1 > 10) || (grade2 < 0 || grade2 > 10)) {
                    log.println("The grade(s) of student [" + student[0] + " " + student[1] + "] 1is greater than 10 or smaller than 0. Please check your files");
                }
                sum = grade1 + grade2;
                avg = (double) sum / 2;

                primOut.println(student[0] + " " + student[1] + " " + avg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static boolean isInt (String s) {
        try {
            Integer.parseInt(s);
            return  true;
        } catch (NumberFormatException e) {
            return  false;
        }
    }
}
