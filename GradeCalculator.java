public class GradeCalculator {

    public static int calculateTotal(student s) {

        int total = s.javaMarks
                + s.dbmsMarks
                + s.dsaMarks
                + s.osMarks
                + s.cnMarks;

        return total;
    }


    public static double calculatePercentage(student s) {

        int total = calculateTotal(s);

        double percentage = total / 5.0;

        return percentage;
    }


    public static String calculateGrade(double percentage) {

        if (percentage >= 90) {

            return "A+";
        }
        else if (percentage >= 80) {

            return "A";
        }
        else if (percentage >= 70) {

            return "B";
        }
        else if (percentage >= 60) {

            return "C";
        }
        else if (percentage >= 50) {

            return "D";
        }
        else {

            return "F";
        }
    }
}