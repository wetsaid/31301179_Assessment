package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.CourseDAO;
import cn.edu.zucc.shijf.entity.Course;
import cn.edu.zucc.shijf.page.PageBean;

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

    public Course getCourse(int courseId) {
        return courseDAO.get(courseId);
    }

    public void addCourse(Course course) {
        courseDAO.add(course);
    }

    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    public void deleteCourse(int courseId) {
        //软删除
        Course course = courseDAO.get(courseId);
        course.setCourseStatus("D");
        courseDAO.update(course);

        //非软删除
        //courseDAO.delete(courseId);
    }

    public PageBean loadTeachersCoursesByPage(int teacherId, int pageSize, int page) {
        String hql = "from Course as c where c.courseStatus <> 'D' and c.teacherId = ?";
        Object[] params = {teacherId};
        PageBean pageBean = courseDAO.findForPage(hql, params, pageSize, page);
        return pageBean;
    }
}
