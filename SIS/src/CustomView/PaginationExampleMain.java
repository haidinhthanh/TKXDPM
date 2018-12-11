/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomView;

/**
 *
 * @author haidt
 */
import Course.Control.CourseController;
import Course.Model.Course;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaginationExampleMain {
    public static void main(String[] args) {
        JFrame frame = createFrame();
        JTable table = new JTable(createObjectDataModel());
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<Course> dataProvider = createDataProvider();
        PaginatedTableDecorator<Course> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        frame.add(paginatedDecorator.getContentPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<Course>() {
            @Override
            public Object getValueAt(Course course, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return course.getCourseID();
                    case 1:
                        return course.getCourseName();
                    case 2:
                        return course.getCredit();
                    case 3:
                        return course.getCourseCondition();
                    case 4:
                        return course.getCourseType();
                    case 5:
                        return course.getProgramId();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 6;
            }
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "CourseID";
                    case 1:
                        return "CourseName";
                    case 2:
                        return "Credit";
                    case 3:
                        return "CourseCondition";
                    case 4:
                        return "CourseType";
                    case 5:
                        return "ProgramId";
                }
                return null;
            }
        };
    }
     private static PaginationDataProvider<Course> createDataProvider() {
        CourseController courseController= new CourseController();
        List<Course> listCourse = courseController.getAllCourse();
        for (int i = 1; i <= 500; i++) {
            Course c= new Course();
            c.setCourseID(String.valueOf(i));
            c.setCourseName(String.valueOf(i));
            c.setCredit(i);
            c.setCourseCondition(String.valueOf(i));
            c.setCourseType(String.valueOf(i));
            c.setProgramId(String.valueOf(i));
            listCourse.add(c);
        }
        return new PaginationDataProvider<Course>() {
            @Override
            public int getTotalRowCount() {
                return listCourse.size();
            }

            @Override
            public List<Course> getRows(int startIndex, int endIndex) {
                return listCourse.subList(startIndex, endIndex);
            }
        };
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTable Pagination example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
}
