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
@Table(name = "branch")
public class Branch {

    private int branchId;
    private String branchCode;
    private String branchName;
    private String branchStatus;

    public Branch() {
    }

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchStatus() {
        return branchStatus;
    }

    public void setBranchStatus(String branchStatus) {
        this.branchStatus = branchStatus;
    }
}
