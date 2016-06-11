package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Course;
import cn.edu.zucc.shijf.service.CourseService;

/**
 * Created by wetsaid on 6/11/2016.
 */
public class CourseAction extends BaseAction {

    private Course course;
    private CourseService courseService;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public String addCourse() {
        courseService.addCourse(course);
        return "success";
    }

    public String updateCourse() {
        courseService.updateCourse(course);
        return "success";
    }

    public String deleteCourse() {
        courseService.deleteCourse(course);
        return "success";
    }
}
