package main.service.impl;

import main.dto.DtoMessage;
import main.dto.MessageMapper;
import main.model.Message;
import main.model.User;
import main.repository.MessageRepository;
import main.repository.UserRepository;
import main.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Service
public class MessageService implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    private MessageMapper mapper;


    @Override
    public HashMap<String, Boolean> sendMessage(String message) {
        HashMap<String, Boolean> response = new HashMap<>();
        boolean result = false;
        if ((message != null) && (!message.isEmpty())) {
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            Optional<User> userOpt = userRepository.findBySessionId(sessionId);
            Message messageObj = new Message();
            messageObj.setMessage(message);
            messageObj.setDateTime(LocalDateTime.now());
            messageObj.setUser(userOpt.get());
            messageRepository.save(messageObj);
            result = true;
        }
        response.put("result", result);
        return response;
    }
    @Override
    public List<DtoMessage> getMessagesList() {
        return messageRepository
               .findAll(Sort.by(Sort.Direction.ASC, "dateTime"))
               .stream()
               .map(MessageMapper::map)
               .collect(Collectors.toList());

    }


}
