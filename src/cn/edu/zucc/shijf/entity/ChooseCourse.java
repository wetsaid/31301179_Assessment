package cn.edu.zucc.shijf.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wetsaid on 6/2/2016.
 */
@Entity
@Table(name = "choose_course")
public class ChooseCourse {

    private int chooseCourseId;
    private int studentId;
    private int courseId;
    private String courseSemester;
    private int contentEvaluate;
    private int techniqueEvaluate;
    private int attitudeEvaluate;
    private int effectEvaluate;
    private int generalEvaluate;
    private String chooseCourseStatus;

    public ChooseCourse() {
    }

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getChooseCourseId() {
        return chooseCourseId;
    }

    public void setChooseCourseId(int chooseCouresId) {
        this.chooseCourseId = chooseCouresId;
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

    @Transient
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

    public int getTechniqueEvaluate() {
        return techniqueEvaluate;
    }

    public void setTechniqueEvaluate(int techniqueEvaluate) {
        this.techniqueEvaluate = techniqueEvaluate;
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
