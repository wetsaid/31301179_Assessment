package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.ChooseCourseDAO;
import cn.edu.zucc.shijf.entity.ChooseCourse;

import java.util.List;

/**
 * Created by wetsaid on 2016/6/12.
 */
public class ChooseCourseService {

    private ChooseCourseDAO chooseCourseDAO;

    public ChooseCourseDAO getChooseCourseDAO() {
        return chooseCourseDAO;
    }

    public void setChooseCourseDAO(ChooseCourseDAO chooseCourseDAO) {
        this.chooseCourseDAO = chooseCourseDAO;
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

    public void deleteChooseCourse(int chooseCourseId) {
        chooseCourseDAO.delete(chooseCourseId);
    }
}
