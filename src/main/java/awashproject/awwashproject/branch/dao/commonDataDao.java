package awashproject.awwashproject.branch.dao;

import awashproject.awwashproject.branch.model.commonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commonDataDao extends JpaRepository<commonData, Integer> {


}
