package mx.com.hiringa.transactions.service;

import mx.com.hiringa.transactions.domain.User;

import jakarta.ejb.Remote;
import java.util.List;

@Remote public interface UserServiceRemote {
    List<User> ListUsers();
    User FindUserById(User user);
    void AddUser(User user);
    void ModifyUser(User user);
    void DeleteUser(User user);
}
