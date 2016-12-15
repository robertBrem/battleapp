package ninja.disruptor.battleapp.user.control;

import ninja.disruptor.battleapp.user.entity.User;

import javax.ejb.Stateless;
import javax.ws.rs.core.GenericEntity;
import java.util.HashSet;
import java.util.Set;

@Stateless
public class UserService {

    public GenericEntity<Set<User>> getUsersAsGenericEntity() {
        return new GenericEntity<Set<User>>(getUsers()) {
        };
    }

    public Set<User> getUsers() {
        HashSet<User> users = new HashSet<>();
        users.add(new User("robert"));
        users.add(new User("dan"));
        users.add(new User("kevin"));
        return users;
    }

}