package awashproject.awwashproject.security.service;


import awashproject.awwashproject.security.dao.RoleDao;
import awashproject.awwashproject.security.dao.UserDao;
import awashproject.awwashproject.security.entity.Role;
import awashproject.awwashproject.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired()
    private UserDao userDao;

    @Autowired()
    private RoleDao roleDao;

    @Autowired()
    private PasswordEncoder passwordEncoder;

//registering new role and user.
    public User registerNewUser(User user){
        Role role = roleDao.findById("Branch Account Holder").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);


        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
         return userDao.save(user);
    }

    public  void  initRolesAndUser(){

//        role for admin
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin key holders");
        roleDao.save(adminRole);

//        role for branch account holders

        Role branchAccountHolder = new Role();
        branchAccountHolder.setRoleName("Branch Account Holder");
        branchAccountHolder.setRoleDescription("for branch account Holders only");
        roleDao.save(branchAccountHolder);

//        role for branch approvals.

        Role branchApproval = new Role();
        branchApproval.setRoleName("Branch Approvals");
        branchApproval.setRoleDescription("Branch Approvals who approves requests");
        roleDao.save(branchApproval);



//       hard code for creating default admin user.


//          1 admin users
//        User adminUser = new User();
//        adminUser.setUserName("Megersa");
//        adminUser.setUserLastName("Biratu");
//        adminUser.setUserPhone("0966916168");
//        adminUser.setUserEmail("megibiratu@gmail.com");
//        adminUser.setUserPassword(getEncodedPassword("123456"));
//        Set<Role> adminRoles = new HashSet<>();
//        adminRoles.add(adminRole);
//        adminUser.setRole(adminRoles);
//        userDao.save(adminUser);

//        3 branch approvals or request approvals.






    }

//    encrypting password
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }


//    get all users from db
    public List<User> getAllUser() {
        return (List<User>) userDao.findAll();
    }

//    get user by username or id

    public User getSingleUser(String userName){
        Optional <User> users = userDao.findById(userName);
        if (users.isPresent()){
            return  users.get();
        }else{
            throw new RuntimeException(" User Not Found for the username of" + userName);
        }
    }


//    update users data by id.
    public User updateUsersData(User user){
        return userDao.save(user);
    }
  public User deleteUsersData(User users){
        //return userDao.delete(users);
      return null;
  }
}
