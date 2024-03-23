package com.jorel.habits.entities.User;

import com.jorel.habits.entities.Contribution.Contribution;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testSetName() {
        User user = new User();
        String newName = "John Doe";
        user.setName(newName);
        assertEquals(newName, user.getName());
    }

    @Test
    public void testSetAge() {
        User user = new User();
        Integer newAge = 30;
        user.setAge(newAge);
        assertEquals(newAge, user.getAge());
    }

    @Test
    public void testSetEmail() {
        User user = new User();
        String newEmail = "john.doe@example.com";
        user.setEmail(newEmail);
        assertEquals(newEmail, user.getEmail());
    }

    @Test
    public void testSetPhone() {
        User user = new User();
        String newPhone = "123-456-7890";
        user.setPhone(newPhone);
        assertEquals(newPhone, user.getPhone());
    }

    @Test
    public void testSetLoginAt() {
        User user = new User();
        LocalDateTime loginTime = LocalDateTime.now();
        user.setLoginAt();
        assertEquals(loginTime.getMinute(), user.getLoginAt().getMinute());
    }

    @Test
    public void testSetCreatedAt() {
        User user = new User();
        LocalDateTime createdAt = LocalDateTime.now();
        assertEquals(createdAt.getMinute(), user.getCreatedAt().getMinute());
    }

    @Test
    public void testSetUpdatedAt() {
        User user = new User();
        user.setName("John Doe");
        LocalDateTime updatedAt = LocalDateTime.now();
        assertEquals(updatedAt.getMinute(), user.getUpdatedAt().getMinute());
    }

    @Test
    public void testAddContribution() {
        User user = new User();
        Contribution contribution = new Contribution();
        user.addContribution(contribution);
        assertTrue(user.getContributions().contains(contribution));
    }
}
