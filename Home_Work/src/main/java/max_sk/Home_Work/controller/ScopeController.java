package max_sk.Home_Work.controller;

import lombok.RequiredArgsConstructor;
import max_sk.Home_Work.entities.User;
import max_sk.Home_Work.service.ScopeService;
import max_sk.Home_Work.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeController {
    private final UserService userService;
    private final ScopeService scopeService;

    //Расскожите пожалуйста как principal знает всё про зарегистрированного юзера, если даннай объект не где не участвует
    @GetMapping("/inc")
    public String inc(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        scopeService.incrimentScope(user.getId());
        return "Helo User - " + user.getUsername() + " : " + user.getEmail();
    }

    @GetMapping("/dec")
    public String dec(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        scopeService.decrimentScope(user.getId());
        return "Helo User - " + user.getUsername() + " : " + user.getEmail();
    }

    @GetMapping("/current")
    public String current(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "Name: " + user.getUsername() + "   Scope: " + scopeService.getScopeUser(user.getId());
    }

    @GetMapping("/{id}")
    public String findScopeUserById(@PathVariable Long id){
        return scopeService.findScopeUserById(id);
    }

}
