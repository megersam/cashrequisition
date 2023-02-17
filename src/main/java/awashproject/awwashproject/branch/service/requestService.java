package awashproject.awwashproject.branch.service;

import awashproject.awwashproject.branch.dao.branchDao;
import awashproject.awwashproject.branch.model.branchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class requestService {

    @Autowired()
    private branchDao bdao;

    public void saveData(branchModel bmodel){
        bdao.saveData(bmodel);
    }
}
