package awashproject.awwashproject.branch.dao;

import awashproject.awwashproject.branch.model.branchModel;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface branchDao {
    @Insert("insert into ctable(requestedBy, branchName, date, remark, status, requestType) values("
            +" #{requestedBy}, #{branchName}, #{date}, #{remark}, 'pending', 'collection')")
    void saveData(branchModel bmodel);
}
