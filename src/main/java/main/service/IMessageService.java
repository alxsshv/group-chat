package main.service;

import main.dto.DtoMessage;

import java.util.HashMap;
import java.util.List;

public interface IMessageService {

    HashMap<String, Boolean> sendMessage(String message);

    List<DtoMessage> getMessagesList();
}
