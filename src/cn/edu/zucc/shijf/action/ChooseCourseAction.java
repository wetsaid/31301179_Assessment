package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.ChooseCourse;
import cn.edu.zucc.shijf.service.ChooseCourseService;

import java.util.List;

/**
 * Created by wetsaid on 2016/6/13.
 */
public class ChooseCourseAction extends BaseAction {

    private int courseId;
    private List<String> ids;
    private ChooseCourseService chooseCourseService;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public ChooseCourseService getChooseCourseService() {
        return chooseCourseService;
    }

    public void setChooseCourseService(ChooseCourseService chooseCourseService) {
        this.chooseCourseService = chooseCourseService;
    }

    /**
     * 刷新我选的课程
     */
    private void updateMyCourses() {
        int studentId = (int) session.get("studentId");
        List myCourses = chooseCourseService.loadMyCourse(studentId);
        session.put("myCourses", myCourses);
        session.put("myCoursesAllRow", myCourses.size());
    }

    public void addChooseCourse() {
        for (String id : ids) {
            ChooseCourse chooseCourse = new ChooseCourse();
            chooseCourse.setStudentId((Integer) session.get("studentId"));
            chooseCourse.setCourseId(Integer.parseInt(id));
            chooseCourse.setChooseCourseStatus("A");
//            chooseCourse.setCourseSemester("2015-2");
            chooseCourseService.addChooseCourse(chooseCourse);
        }
        this.updateMyCourses();
        this.alertRedirect("选课成功！", "manageCenterStudent.jsp");
    }

    public void deleteChooseCourse() {
        int studentId = (int) session.get("studentId");
        chooseCourseService.deleteChooseCourse(studentId, courseId);
        this.updateMyCourses();
//        this.forward("myCourses.jsp");
    }
}
