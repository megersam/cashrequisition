package awashproject.awwashproject.branch.model;

import lombok.Data;

@Data
public class requestdata {

    private Long id;
    private Long denomnstrationId;
    private String qnty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDenomnstrationId() {
        return denomnstrationId;
    }

    public void setDenomnstrationId(Long denomnstrationId) {
        this.denomnstrationId = denomnstrationId;
    }

    public String getQnty() {
        return qnty;
    }

    public void setQnty(String qnty) {
        this.qnty = qnty;
    }



}
