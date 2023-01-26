package main.service.impl;

import main.service.IMessageService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public class MessageService implements IMessageService {


    @Override
    public Boolean sendMessage(String message) {
        return null;
    }

    @Override
    public List<String> getMessagesList() {
        return null;
    }
}
