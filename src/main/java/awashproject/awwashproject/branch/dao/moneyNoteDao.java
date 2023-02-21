package awashproject.awwashproject.branch.dao;

import awashproject.awwashproject.branch.model.note;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface moneyNoteDao {
    @Select("Select * From denomination")
    List<note> getAllNote();


}
