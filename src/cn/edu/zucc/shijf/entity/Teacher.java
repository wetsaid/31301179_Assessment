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
@Table(name = "teacher")
public class Teacher {

    private int teacherId;
    private int branchId;
    private String teacherAccount;
    private String teacherPassword;
    private String teacherName;
    private String teacherSex;
    private String teacherDegree;
    private String teacherPosition;
    private String professionalTitle;
    private String teacherPhoneNumber;
    private String teacherStatus;

    public Teacher() {
    }

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree;
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }
}
