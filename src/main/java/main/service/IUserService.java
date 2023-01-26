package main.service;

import java.util.HashMap;

public interface IUserService {
    HashMap<String, Boolean> isAuthorized();

    HashMap<String, Boolean> auth(String name);
}
