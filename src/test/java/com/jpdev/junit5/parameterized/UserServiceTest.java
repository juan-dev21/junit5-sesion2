package com.jpdev.junit5.parameterized;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository mockRepo;

    @InjectMocks
    private UserService service;

    @Test
    void testFindUserById() {
        // crear mock
        //UserRepository mockRepo = Mockito.mock(UserRepository.class);
        //UserService service = new UserService(mockRepo);

        // usar el mock
        User user = new User(1, "Lionel");
        when(mockRepo.findById(1)).thenReturn(user);

        // llamar a mi método a probar, que por dentro usará el mock
        User userById = service.findUserById(1);
        assertNotNull(userById);
        assertEquals("Lionel", userById.getName());

        verify(mockRepo, times(1)).findById(1);
    }


}

class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User findUserById(int id) {
        return userRepository.findById(id);
    }
}

interface UserRepository {
    User findById(int id);
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
