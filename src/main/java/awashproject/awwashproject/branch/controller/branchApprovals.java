package awashproject.awwashproject.branch.controller;

import awashproject.awwashproject.branch.dao.commonDataDao;
import awashproject.awwashproject.branch.model.commonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class branchApprovals {

//    branch approvals can see all listed requests from the branch users.
//    branch approvals can see reqeusts by id.
//    branch approvals can update status and approved by branch approval or decline by branch Approval
//    three api are needed for this.
//    1 for fetching all request.
//    2. for fetching by search value.
//    3. for updating whether it's accepted or not.

    @Autowired()
    private commonDataDao commonRepository;

//    search all datas here.
    @GetMapping({"/getAlldata"})
    @PreAuthorize("hasRole('Branch Approvals')")
    public List<commonData>getAllRequests(){
        return commonRepository.findAll();
    }

//    search data by date of inserted.

    @GetMapping({"getDataDate/{id}"})
    @PreAuthorize("hasRole('Branch Approvals')")
    public commonData getSingledata(@PathVariable Integer id){

        Optional<commonData> commondatas = commonRepository.findById(id);
        if(commondatas.isPresent()){
            return commondatas.get();
        }
        else{
            throw new RuntimeException(" cant get request data bi this id " + id);
        }

    }

//    update situations using request id.

    @PutMapping({"/updateRequest/{id}"})
    @PreAuthorize("hasRole('Branch Approvals')")
    public commonData updateSingleRequest(@PathVariable Integer id, @RequestBody commonData commondatas){
        commondatas.setId(id);
        return commonRepository.save(commondatas);
    }

}
