package main.service;

import java.util.HashMap;
import java.util.List;

public interface IMessageService {

    HashMap<String, Boolean> sendMessage(String message);

    List<String> getMessagesList();
}
