package Eksamensforelesning.Interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UniversityHandbookUtils {
    /**
     * Get all courses that matches the given predicate
     *
     * @param courses The list of courses to check for
     * @param p       The predicate that should be matched on
     *
     * @return A collection of courses that satisfy the predicate.
     */
    public static Collection<Course> getCoursesWithPredicate(Collection<Course> courses, Predicate<Course> p) {
        return courses.stream().filter(p).collect(Collectors.toList());
    }
 
    /**
     * Get all courses that does not have any prerequisites
     *
     * @param courses The list of courses to check for
     * @return A collection of course without any prerequisites
     */
    public static Collection<Course> getNonPrequisiteCourses(Collection<Course> courses) {
        return courses.stream().filter(course -> course.getPrerequisites().size() == 0).collect(Collectors.toList()); 
 
    }
     
    /**
     * Returns whether the handbook contains an impossible course. A course is
     * deemed impossible if any of the prerequisite of the course has the current
     * course as a prerequisite. Only direct dependencies need to be checked. You
     * do not need to worry about transitive dependencies. That means if TDT4100 has
     * a dependency on TDT4110 and TDT4110 has a dependency on TDT4100 it is impossible.
     *
     * A transitive dependency that does not need to be checked is if TDT4100 has a
     * dependency on TDT4110, TDT4110 has dependency on TDT4200 and TDT4200 has a
     * dependency on TDT4100.
     *
     * @param courses The list of courses to check for
     * @return whether the courses contains an impossible course
     */
    public static boolean containsImpossibleCourse(Collection<Course> courses) {
        return courses.stream().anyMatch(course -> course.getPrerequisites().stream().anyMatch(prerequisite -> prerequisite.getPrerequisites().contains(course)));
    }

    public static void main(String[] args) {
        
        Collection<Course> courses = new ArrayList<>();
        Course course1 = new Course("TDT4100", 3.5);
        Course course2 = new Course("TDT4109", 4);
        Course course3 = new Course("TDT4140", 2);

        course1.addPrequisite(course2);
        course1.addPrequisite(course3);
        course3.addPrequisite(course1);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        System.out.println(UniversityHandbookUtils.getCoursesWithPredicate(courses, course -> course.getAverageGrade() > 3));
        System.out.println(UniversityHandbookUtils.getNonPrequisiteCourses(courses));
        System.out.println(UniversityHandbookUtils.containsImpossibleCourse(courses));
    }
}
