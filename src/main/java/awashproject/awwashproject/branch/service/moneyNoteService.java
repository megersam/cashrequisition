package awashproject.awwashproject.branch.service;

import awashproject.awwashproject.branch.dao.commonDataDao;
import awashproject.awwashproject.branch.dao.moneyNoteDao;
import awashproject.awwashproject.branch.model.note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class moneyNoteService {

    @Autowired()
    private moneyNoteDao mnotedao;

    @Autowired()
    private commonDataDao commonDaoRepository;

//    get money notes

    public List<note> getAllNote(){
        return mnotedao.getAllNote();
    }

//    get single request by id.



}
