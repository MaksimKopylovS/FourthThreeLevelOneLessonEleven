package max_sk.Home_Work.service;

import max_sk.Home_Work.entities.Scope;
import max_sk.Home_Work.entities.User;
import max_sk.Home_Work.repositories.ScopeRepository;
import max_sk.Home_Work.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeService {
    private ScopeRepository scopeRepository;
    private UserRepository userRepository;

    @Autowired
    public ScopeService(ScopeRepository scopeRepository, UserRepository userRepository) {
        this.scopeRepository = scopeRepository;
        this.userRepository = userRepository;
    }

    public void incrimentScope(Long userid){
        Scope scope = scopeRepository.findByUserId(userid);
        System.out.println(scope.getScops() + "Q QQQQQQQQQQQQQQQQQ");
        scope.setScops(scope.getScops()+1);
        scopeRepository.saveAndFlush(scope);
        scope = scopeRepository.findByUserId(userid);
        System.out.println(scope.getScops() + "Q QQQQQQQQQQQQQQQQQ");
    }

    public void decrimentScope(Long userid){
        Scope scope = scopeRepository.findByUserId(userid);
        System.out.println(scope.getScops() + "Q QQQQQQQQQQQQQQQQQ");
        scope.setScops(scope.getScops()-1);
        scopeRepository.saveAndFlush(scope);
        scope = scopeRepository.findByUserId(userid);
        System.out.println(scope.getScops() + "Q QQQQQQQQQQQQQQQQQ");
    }

    public Integer getScopeUser(Long userid){
        Scope scope = scopeRepository.findByUserId(userid);
        return scope.getScops();
    }

    public String findScopeUserById(Long id){
        Scope scope = scopeRepository.findByUserId(id);
        User user = userRepository.findByid(id);
        return "Name: " + user.getUsername() + " Scope: " + scope.getScops();
    }



}
