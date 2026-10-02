import java.io.*;
import java.util.ArrayList;

public class StudentFileManager {

    static String fileName = "students.txt";


    // Save students
    public static void saveStudents(ArrayList<student> students) {

        try {

            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < students.size(); i++) {

                student s = students.get(i);

                writer.write(
                        s.id + "," +
                        s.name + "," +
                        s.javaMarks + "," +
                        s.dbmsMarks + "," +
                        s.dsaMarks + "," +
                        s.osMarks + "," +
                        s.cnMarks + "\n"
                );
            }

            writer.close();

        }
        catch (IOException e) {

            System.out.println("Error saving students.");
        }
    }


    // Load students
    public static void loadStudents(ArrayList<student> students) {

        try {

            File file = new File(fileName);

            if (!file.exists()) {

                return;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);

                String name = data[1];

                student s = new student(id, name);

                s.javaMarks = Integer.parseInt(data[2]);
                s.dbmsMarks = Integer.parseInt(data[3]);
                s.dsaMarks = Integer.parseInt(data[4]);
                s.osMarks = Integer.parseInt(data[5]);
                s.cnMarks = Integer.parseInt(data[6]);

                students.add(s);
            }

            reader.close();

        }
        catch (Exception e) {

            System.out.println("Error loading students.");
        }
    }
}