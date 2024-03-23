package com.jorel.habits.entities.Contribution;

import com.jorel.habits.entities.Habit.Habit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContributionTest {
    @Test
    public void testConstructorWithUserId() {
        UUID userId = UUID.randomUUID();
        Contribution contribution = new Contribution(userId);
        assertEquals(userId, contribution.getUserId());
    }

    @Test
    public void testSetForce() {
        Contribution contribution = new Contribution();
        int newForce = 3;
        contribution.setForce(newForce);
        assertEquals(newForce, (int) contribution.getForce());
    }

    @Test()
    public void testSetForceExceedLimit() {
        Contribution contribution = new Contribution();
        int invalidForce = 5;
        contribution.setForce(invalidForce);
    }

    @Test
    public void testGetDate() {
        Contribution contribution = new Contribution();
        LocalDateTime currentDate = LocalDateTime.now();
        assertTrue(currentDate.isEqual(contribution.getDate()) || currentDate.isAfter(contribution.getDate()));
    }

    @Test
    public void testAddHabit() {
        Contribution contribution = new Contribution();
        Habit habit = new Habit();
        contribution.addHabit(habit);
        assertTrue(contribution.getHabits().contains(habit));
    }
}
