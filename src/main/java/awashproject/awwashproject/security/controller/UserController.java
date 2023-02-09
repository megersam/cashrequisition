package awashproject.awwashproject.security.controller;


import awashproject.awwashproject.security.dao.UserDao;
import awashproject.awwashproject.security.entity.User;
import awashproject.awwashproject.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {
    @Autowired
     private UserService userService;
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public  void  initRolesAndUsers(){
        userService.initRolesAndUser();
    }

//    register New user if you are only Admin
    @PostMapping({"/registerNewUser"})
    @PreAuthorize("hasRole('Admin')")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }


//    get All Users if you are only Admin User
    @GetMapping({"/getUsers"})
    @PreAuthorize("hasRole('Admin')")
   public  List <User> getAllUser(){
        return  userService.getAllUser();

    }



    //    get users by username or id.
    @GetMapping({"/getSingleUser/{userName}"})
    @PreAuthorize("hasRole('Admin')")
    public User getSingleUser(@PathVariable String userName){
        return userService.getSingleUser(userName);
    }


//    update data by id.
    @PutMapping({"/updateUsersData/{userName}"})
    @PreAuthorize("hasRole('Admin')")
    public User updateUsersData(@PathVariable String userName, @RequestBody User user){
        user.setUserName(userName);
        return userService.updateUsersData(user);
    }

//    delete users data by id.
@PutMapping({"/deleteUsersData/{userName}"})
@PreAuthorize("hasRole('Admin')")
public User deleteUsersData(@PathVariable String userName, @RequestBody User user){
    user.setUserName(userName);
    return userService.deleteUsersData(user);
}






    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public  String forAdmin(){
        return "This is only accessible to Admin";
    }
    @GetMapping({"/forBranchAccountHolder"})
    @PreAuthorize("hasRole('Branch Account Holder')")
    public String forBranchAccountHolder(){
        return "This is for branch account holders only.";
    }

    @GetMapping({"/forBranchApprovals"})
    @PreAuthorize("hasRole('Branch Approvals')")
    public String forBranchApprovals (){
        return  "This is for Branch Account Approvals";
    }
}
