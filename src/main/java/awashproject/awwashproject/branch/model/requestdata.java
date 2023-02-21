package awashproject.awwashproject.branch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class requestdata {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
    private Long denomnstrationId;
    private String qnty;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//   @JoinColumn(name = "req_id")
//  private commonData commondata;

}
