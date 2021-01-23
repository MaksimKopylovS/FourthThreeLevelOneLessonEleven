package max_sk.Home_Work.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max_sk.Home_Work.entities.User;
import max_sk.Home_Work.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Profile("dao")
@Slf4j
@RequiredArgsConstructor
public class DaoController {
    private final UserService userService;

    @GetMapping("/dao")
    public String daoTestPage(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : " + user.getEmail();
    }
}
