package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Interfaces.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/greeting")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;
    @GetMapping()
    public String welcome() {
        return greetingService.getWelcomeMessage();
    }

    @GetMapping("/user-welcome/{sessionId}")
    public String userWelcome(@PathVariable String sessionId){
        return greetingService.getUserWelcomeMessage(sessionId);
    }

    @GetMapping("/premium-message/{sessionId}")
    public String premiumMessage(@PathVariable String sessionId){
        return greetingService.getPremiumMessage(sessionId);
    }
}
