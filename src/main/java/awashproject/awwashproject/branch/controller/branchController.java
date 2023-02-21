package awashproject.awwashproject.branch.controller;

import awashproject.awwashproject.branch.dao.commonDataDao;
import awashproject.awwashproject.branch.dao.moneyNoteDao;
import awashproject.awwashproject.branch.dao.requestDao;
import awashproject.awwashproject.branch.dto.request;
import awashproject.awwashproject.branch.model.commonData;
import awashproject.awwashproject.branch.model.note;
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
    private moneyNoteDao mndao;
    @Autowired()
    private moneyNoteService mnservice;

    @Autowired()
    private commonDataDao commondataRepository;

    @Autowired()
    private requestDao requestRepository;


//    post API
    @PostMapping({"/createNewRequest"})
    @PreAuthorize("hasRole('Admin')")
    public commonData createNewRequest(@RequestBody request r){
        return commondataRepository.save(r.getCommondata());
    }

//    get all request API

    @GetMapping({"/getAllRequests"})
    @PreAuthorize("hasRole('Admin')")
    public List<commonData> getAllRequest(){
       return  commondataRepository.findAll();
    }


//    get all money note stored as refered on demonstration table.
@GetMapping({"/getAllNotes"})
@PreAuthorize("hasRole('Admin')")
public List<note> getAllNote(){
    return (List<note>) mndao.getAllNote();
}

}
