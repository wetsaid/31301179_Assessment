package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.CourseDAO;
import cn.edu.zucc.shijf.entity.Course;

/**
 * Created by wetsaid on 6/11/2016.
 */
public class CourseService {

    private CourseDAO courseDAO;

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void addCourse(Course course) {
        courseDAO.add(course);
    }

    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    public void deleteCourse(Course course) {
        courseDAO.delete(course.getCourseId());
    }

    public void loadCourseByPage(int page) {

    }
}
