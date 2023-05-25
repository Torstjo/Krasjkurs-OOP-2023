package Eksamensforelesning.Filbehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityHandbook {
    
    private List<Course> courses = new ArrayList<>();
 
    /**
     * Reads all the courses from a given input stream. The courses are on this
     * form: courseName, averageGrade, prerequisite 1, prerequisite 2,
     * prerequisite 3....
     *
     * See courses.txt in src/main/resources/del7_og_8 for an example file.
     *
     * Calling this method should remove any existing courses from the handbook.
     *
     * A given course can have anything from 0 to unlimited number of prerequisites.
     * The courses do not necessary come in order. Meaning that a course may appear
     * in the prerequisite list as a never before seen course. The method should read
     * in all courses, and set the courseName, averageGrade and prerequisites of all
     * courses and add the courses to the courses field of this class.
     *
     * A skeleton code to read from file is provided to you but feel free to write
     * your own code for this.
     *
     * You can assume that all lines from the file will be on the correct format.
     *
     * @param stream InputStream containing the course data
     */
    public void readFromInputStream(InputStream stream) {
        try (Scanner scanner = new Scanner(stream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(",");
                // TODO - Continue implementation here
                if (getCourse(details[0]) != null) {
                    getCourse(details[0]).setAverageGrade(Double.parseDouble(details[1]));
                }
                else {
                    Course course = new Course(details[0], Double.parseDouble(details[1]));
                    courses.add(course);
                }
                if (details.length > 2) {
                    for (int i = 2; i < details.length; i++) {
                        if (getCourse(details[i]) != null) {
                            getCourse(details[0]).addPrequisite(getCourse(details[i]));
                        }
                        else {
                            Course course = new Course(details[i]);
                            courses.add(course);
                            getCourse(details[0]).addPrequisite(course);
                        }
                    }
                }
            }
        }
    }
 
    /**
     * Gets the course with the courseName
     *
     * @param courseName The name of the course
     *
     * @return The course with the given name
     */
    public Course getCourse(String courseName) {
        return courses.stream().filter(course -> course.getCourseName().equals(courseName)).findFirst().orElse(null);
    }

    public static void main(String[] args) throws FileNotFoundException {
        UniversityHandbook uh = new UniversityHandbook();
        uh.readFromInputStream(new FileInputStream("Eksamensforelesning/Filbehandling/course.txt"));
        Course course = uh.getCourse("TDT4100");
        System.out.println(course.getCourseName());
        System.out.println(course.getAverageGrade());
        System.out.println(course.getPrerequisites());
    }
}
