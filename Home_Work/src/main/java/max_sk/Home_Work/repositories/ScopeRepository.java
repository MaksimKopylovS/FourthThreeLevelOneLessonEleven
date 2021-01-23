package max_sk.Home_Work.repositories;

import max_sk.Home_Work.entities.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ScopeRepository extends JpaRepository<Scope, Long> {
            Scope findByUserId(Long userid);
}
