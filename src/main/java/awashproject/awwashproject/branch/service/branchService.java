package awashproject.awwashproject.branch.service;


import awashproject.awwashproject.branch.dao.branchDao;
import awashproject.awwashproject.branch.model.branchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class branchService {

    @Autowired()
    private branchDao bdo;


    public void saveData(branchModel bmodel){
         bdo.saveData(bmodel);
    }
}
