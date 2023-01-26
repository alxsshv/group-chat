package main.service.impl;

import main.model.User;
import main.repository.UserRepository;
import main.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;
import java.util.Optional;

@Component
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public HashMap<String, Boolean> auth(String name){
        HashMap<String, Boolean> response = new HashMap<>();
        boolean result = false;
        if ((name != null) && (!name.isEmpty())) {
            User user = new User();
            user.setName(name);
            user.setSessionId(RequestContextHolder.getRequestAttributes().getSessionId());
            userRepository.save(user);
            result = true;
        }
        response.put("result", result);
        return response;
    }

    @Override
    public HashMap<String, Boolean> isAuthorized() {
        HashMap<String, Boolean> response = new HashMap<>();
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        Optional<User> userOptional =  userRepository.findBySessionId(sessionId);
        response.put("result", userOptional.isPresent());
        return response;
    }
}
