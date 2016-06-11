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
@Table(name = "course_type")
public class CourseType {

    private int courseTypeId;
    private int branchId;
    private String courseTypeCode;
    private String courseTypeName;
    private String courseTypeStatus;

    public CourseType() {
    }

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getCourseTypeCode() {
        return courseTypeCode;
    }

    public void setCourseTypeCode(String courseTypeCode) {
        this.courseTypeCode = courseTypeCode;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public String getCourseTypeStatus() {
        return courseTypeStatus;
    }

    public void setCourseTypeStatus(String courseTypeStatus) {
        this.courseTypeStatus = courseTypeStatus;
    }
}
