package awashproject.awwashproject.branch.controller;

import awashproject.awwashproject.branch.dao.branchDao;
import awashproject.awwashproject.branch.model.branchModel;
import awashproject.awwashproject.branch.service.branchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class branchController {

    @Autowired()
    private branchService bservice;
    @Autowired()
    private branchDao bdao;

    @PostMapping({"/requestApi"})
    @PreAuthorize("hasRole('Admin')")
    public void saveData(@RequestBody branchModel bmodel){
        System.out.println("hithere controller is working");
        System.out.println(bmodel);
        bservice.saveData(bmodel);
    }
}
