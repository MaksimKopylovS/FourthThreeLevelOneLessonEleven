package max_sk.Home_Work.repositories;


import max_sk.Home_Work.entities.Role;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dao")
public interface RoleRepositoriy extends CrudRepository<Role, Long> {

}
