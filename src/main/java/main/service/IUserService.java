package main.service;

import java.util.HashMap;
import java.util.List;

public interface IUserService {
    HashMap<String, Boolean> isAuthorized();

    HashMap<String, Boolean> auth(String name);

    List<String> getActiveUsersNameList();
}
