package cn.edu.zucc.shijf.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wetsaid on 6/2/2016.
 */
@Entity
@Table(name = "choose_course")
public class ChooseCourse {

    private int chooseCouresId;
    private int studentId;
    private int courseId;
    private String courseSemester;
    private int contentEvaluate;
    private int attitudeEvaluate;
    private int effectEvaluate;
    private int generalEvaluate;
    private String chooseCourseStatus;

    public ChooseCourse() {
    }

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getChooseCouresId() {
        return chooseCouresId;
    }

    public void setChooseCouresId(int chooseCouresId) {
        this.chooseCouresId = chooseCouresId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public int getContentEvaluate() {
        return contentEvaluate;
    }

    public void setContentEvaluate(int contentEvaluate) {
        this.contentEvaluate = contentEvaluate;
    }

    public int getAttitudeEvaluate() {
        return attitudeEvaluate;
    }

    public void setAttitudeEvaluate(int attitudeEvaluate) {
        this.attitudeEvaluate = attitudeEvaluate;
    }

    public int getEffectEvaluate() {
        return effectEvaluate;
    }

    public void setEffectEvaluate(int effectEvaluate) {
        this.effectEvaluate = effectEvaluate;
    }

    public int getGeneralEvaluate() {
        return generalEvaluate;
    }

    public void setGeneralEvaluate(int generalEvaluate) {
        this.generalEvaluate = generalEvaluate;
    }

    public String getChooseCourseStatus() {
        return chooseCourseStatus;
    }

    public void setChooseCourseStatus(String chooseCourseStatus) {
        this.chooseCourseStatus = chooseCourseStatus;
    }
}
