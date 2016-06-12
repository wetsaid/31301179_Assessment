package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.ChooseCourse;
import cn.edu.zucc.shijf.entity.Course;
import cn.edu.zucc.shijf.page.PageBean;
import cn.edu.zucc.shijf.service.ChooseCourseService;
import cn.edu.zucc.shijf.service.CourseService;

import java.util.List;

/**
 * Created by wetsaid on 6/11/2016.
 */
public class CourseAction extends BaseAction {

    private List<String> ids;
    private String p;
    private String code;
    private int startWeek;
    private int endWeek;
    private int courseId;
    private Course course;
    private CourseService courseService;
    private ChooseCourseService chooseCourseService;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

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

    public ChooseCourseService getChooseCourseService() {
        return chooseCourseService;
    }

    public void setChooseCourseService(ChooseCourseService chooseCourseService) {
        this.chooseCourseService = chooseCourseService;
    }

    /**
     * 更新列表
     */
    public void updateList() {
        int teacherId = (int) session.get("teacherId");
        int pageSize = (int) session.get("coursesPageSize");
        int page = (int) session.get("coursesCurrentPage");
        PageBean pageBean = courseService.loadTeachersCoursesByPage(teacherId, pageSize, page);
        request.setAttribute("courses", pageBean.getList());
        session.put("coursesTotalPage", pageBean.getTotalPage());
        session.put("coursesAllRow", pageBean.getAllRow());
        this.forward("manageCenterTeacher.jsp");
    }

    public void addCourse() {
        course.setStartEndWeek(startWeek + "-" + endWeek);
        courseService.addCourse(course);

        //刷新列表
        updateList();
    }

    /**
     * 跳转到修改页之前把数据传入
     */
    public void goToUpdate() {
        course = courseService.getCourse(courseId);
        request.setAttribute("course", course);

        //起始结束周拆分
        String[] startEnd = course.getStartEndWeek().split("-");
        request.setAttribute("type", course.getCourseCode().charAt(0));
        request.setAttribute("start", startEnd[0]);
        request.setAttribute("end", startEnd[1]);
        this.forward("courseUpdate.jsp");
    }

    public void updateCourse() {
        course.setStartEndWeek(startWeek + "-" + endWeek);
        courseService.updateCourse(course);

        //刷新列表
        updateList();
    }

    public void deleteCourse() {
        courseService.deleteCourse(courseId);

        //刷新列表
        updateList();
    }

    /**
     * 分页
     * 首页/上一页/下一页/末页
     */
    public void goToPage() {
        int teacherId = (int) session.get("teacherId");
        int pageSize = (int) session.get("coursesPageSize");
        int page = (int) session.get("coursesCurrentPage");
        int totalPage = (int) session.get("coursesTotalPage");
        switch (p) {
            case "first":
                page = 1;
                break;
            case "previous":
                page -= 1;
                break;
            case "next":
                page = Math.min(page + 1, totalPage);
                break;
            case "last":
                page = totalPage;
                break;
        }
        PageBean pageBean = courseService.loadTeachersCoursesByPage(teacherId, pageSize, page);
        request.setAttribute("courses", pageBean.getList());
        session.put("coursesCurrentPage", pageBean.getCurrentPage());
        this.forward("manageCenterTeacher.jsp");
    }

    public void chooseCourses() {
        for (String str : ids) {
            ChooseCourse chooseCourse = new ChooseCourse();
            chooseCourse.setStudentId((Integer) session.get("studentId"));
            chooseCourse.setCourseId(Integer.parseInt(str));
            chooseCourse.setChooseCourseStatus("A");
//            chooseCourse.setCourseSemester("2015-2");
            chooseCourseService.addChooseCourse(chooseCourse);
        }
        this.forward("manageCenterStudent.jsp");
    }
}
