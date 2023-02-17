package awashproject.awwashproject.branch.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class branchModel {

    private Long id;
    private String requestedBy;
    private String branchName;
    private String Date;
    private String remark;
    private String status;
    private String requestType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "requestData",
            joinColumns = {
                    @JoinColumn(name = "reqId")
            }

    )

//    creating getters and setters.

    private Set<requestdata> rdata;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Set<requestdata> getRdata() {
        return rdata;
    }

    public void setRdata(Set<requestdata> rdata) {
        this.rdata = rdata;
    }
}
