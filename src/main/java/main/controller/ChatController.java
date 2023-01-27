package main.controller;

import main.service.IMessageService;
import main.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ChatController {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;
    @Autowired
    @Qualifier("messageService")
    private IMessageService messageService;

    @GetMapping("/init")
    public HashMap<String, Boolean> init(){
        return userService.isAuthorized();
    }

    @PostMapping("/auth")
    public HashMap<String, Boolean> auth(@RequestParam String name){
        return userService.auth(name);
    }
    
    @PostMapping("/message")
    public HashMap<String, Boolean> sendMessage(@RequestParam String message){
        return messageService.sendMessage(message);
    }

    @GetMapping("/message")
    public List<String> getMessagesList(){
        return null;
    }

    @GetMapping("/user")
    public HashMap<Integer, String> getUsersList(){
        return null;
    }


}
