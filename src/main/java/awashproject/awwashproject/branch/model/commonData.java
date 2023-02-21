package awashproject.awwashproject.branch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class commonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String requestedBy;
    private String branchName;
    private String date;
    private String remark;
    private String total;
    private String status;
    private String requestType;


    @OneToMany(targetEntity = requestdata.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "req_id", referencedColumnName = "id")
    private List<requestdata> requestdatas = new ArrayList<requestdata>();
}
