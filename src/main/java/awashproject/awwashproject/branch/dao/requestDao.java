package awashproject.awwashproject.branch.dao;

import awashproject.awwashproject.branch.model.requestdata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface requestDao extends JpaRepository<requestdata, Integer> {

}
