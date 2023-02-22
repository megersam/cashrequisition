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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PreAuthorize("hasRole('Branch Account Holder')")
    public commonData createNewRequest(@RequestBody request r){
        return commondataRepository.save(r.getCommondata());
    }

//    get all request API

    @GetMapping({"/getAllRequests"})
    @PreAuthorize("hasRole('Branch Account Holder')")
    public List<commonData> getAllRequest(){
       return  commondataRepository.findAll();
    }


//    get single request by id.
@GetMapping({"/getSingleRequest/{id}"})
@PreAuthorize("hasRole('Branch Account Holder')")
public commonData getSingleRequest(@PathVariable Integer id){
    Optional<commonData> commondatas = commondataRepository.findById(id);
    if(commondatas.isPresent()){
        return commondatas.get();
    }
    else
    {
        throw new RuntimeException(" cant get request data bi this id" +id);
    }
}

// delete request by id
    @DeleteMapping({"/deleteSingleRequest/{id}"})
    @PreAuthorize("hasRole('Branch Account Holder')")
  public Optional<String> deleteSingleRequest(@PathVariable Integer id){
        return commondataRepository.findById(id)
                .map(commonData -> {
                    commondataRepository.delete(commonData);
                    return "deleted done with id no of" +id;
                });

    }

//    update request data using id.

    @PutMapping({"/updateSingleRequest/{id}"})
    @PreAuthorize("hasRole('Branch Account Holder')")
    public commonData updateSingleRequest(@PathVariable Integer id, @RequestBody commonData commondatas){
        commondatas.setId(id);
        return commondataRepository.save(commondatas);
    }



    //    get all money note stored as refered on demonstration table.
@GetMapping({"/getAllNotes"})
@PreAuthorize("hasRole('Branch Account Holder')")
public List<note> getAllNote(){
    return (List<note>) mndao.getAllNote();
}

}
