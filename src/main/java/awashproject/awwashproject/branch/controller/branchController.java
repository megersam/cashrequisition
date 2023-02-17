package awashproject.awwashproject.branch.controller;

import awashproject.awwashproject.branch.dao.branchDao;
import awashproject.awwashproject.branch.dao.moneyNoteDao;
import awashproject.awwashproject.branch.model.branchModel;
import awashproject.awwashproject.branch.model.note;
import awashproject.awwashproject.branch.service.branchService;
import awashproject.awwashproject.branch.service.moneyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class branchController {

    @Autowired()
    private branchService bservice;
    @Autowired()
    private branchDao bdao;
    @Autowired()
    private moneyNoteDao mndao;
    @Autowired()
    private moneyNoteService mnservice;

//    post api to send data to database
    @PostMapping({"/requestApi"})
    @PreAuthorize("hasRole('Admin')")
    public void saveData(@RequestBody branchModel bmodel){
        System.out.println("hithere controller is working");
        System.out.println(bmodel);
        bservice.saveData(bmodel);
    }

//    get all datas that stored in the database.
@GetMapping({"/getAllNotes"})
@PreAuthorize("hasRole('Admin')")
public List<note> getAllNote(){
    return (List<note>) mndao.getAllNote();
}

}
