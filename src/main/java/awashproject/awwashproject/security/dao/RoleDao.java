package awashproject.awwashproject.security.dao;

import awashproject.awwashproject.security.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao  extends CrudRepository<Role, String> {

}
