package main.service;

import java.util.List;

public interface IMessageService {

    Boolean sendMessage(String message);

    List<String> getMessagesList();
}
