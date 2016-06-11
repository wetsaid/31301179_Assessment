package cn.edu.zucc.shijf.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wetsaid on 6/2/2016.
 */
@Entity
@Table(name = "student")
public class Student {

    private int studentId;
    private int branchId;
    private String studentAccount;
    private String studentPassword;
    private String studentName;
    private String studentSex;
    private Date admissionDate;
    private String administrativeClass;
    private String studentPhoneNumber;
    private String studentStatus;

    public Student() {
    }

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAdministrativeClass() {
        return administrativeClass;
    }

    public void setAdministrativeClass(String administrativeClass) {
        this.administrativeClass = administrativeClass;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }
}
