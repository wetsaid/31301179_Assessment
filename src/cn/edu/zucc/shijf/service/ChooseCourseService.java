package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.ChooseCourseDAO;
import cn.edu.zucc.shijf.dao.CourseDAO;
import cn.edu.zucc.shijf.dao.TeacherDAO;
import cn.edu.zucc.shijf.entity.ChooseCourse;
import cn.edu.zucc.shijf.entity.Course;
import cn.edu.zucc.shijf.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wetsaid on 2016/6/12.
 */
public class ChooseCourseService {

    private ChooseCourseDAO chooseCourseDAO;
    private CourseDAO courseDAO;
    private TeacherDAO teacherDAO;

    public ChooseCourseDAO getChooseCourseDAO() {
        return chooseCourseDAO;
    }

    public void setChooseCourseDAO(ChooseCourseDAO chooseCourseDAO) {
        this.chooseCourseDAO = chooseCourseDAO;
    }

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public TeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    /**
     * 选课
     * 须实现判断是否已经选过
     *
     * @param chooseCourse
     */
    public void addChooseCourse(ChooseCourse chooseCourse) {
        String hql = "from ChooseCourse as c where c.chooseCourseStatus <> 'D' and c.studentId = ? and c.courseId = ?";
        Integer[] params = {chooseCourse.getStudentId(), chooseCourse.getCourseId()};
        List list = chooseCourseDAO.findByHQL(hql, params);
        if (list == null || list.size() < 1) {
            chooseCourseDAO.add(chooseCourse);
        }
    }

    public void deleteChooseCourse(int studentId, int courseId) {
        String hql = "from ChooseCourse where chooseCourseStatus <> 'D' and studentId = ? and courseId = ?";
        Object[] params = {studentId, courseId};
        List<ChooseCourse> list = chooseCourseDAO.findByHQL(hql, params);

        //同一学生选同一课程只能选一次，并且肯定此条记录
        //所以list有且仅有1条数据
        ChooseCourse chooseCourse = list.get(0);
        chooseCourse.setChooseCourseStatus("D");
        chooseCourseDAO.update(chooseCourse);
    }

    public List loadMyCourse(int studentId) {
        String hql = "from ChooseCourse where chooseCourseStatus <> 'D' and studentId = ?";
        Object[] params = {studentId};
        List<ChooseCourse> myChooseCourses = chooseCourseDAO.findByHQL(hql, params);
        List<Course> myCourses = new ArrayList<Course>();
        for (ChooseCourse chooseCourse : myChooseCourses) {
            Course course = courseDAO.get(chooseCourse.getCourseId());

            //取教师姓名
            Teacher teacher = teacherDAO.get(course.getTeacherId());
            course.setTeacherName(teacher.getTeacherName());

            myCourses.add(course);
        }
        return myCourses;
    }
}
