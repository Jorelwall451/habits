package com.jorel.habits.entities.Habit;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class HabitTest {
    @Test

    public void testSetName() {
        Habit habit = new Habit();
        String newName = "Exercise";
        habit.setName(newName);
        assertEquals(newName, habit.getName());
    }

    @Test
    public void testSetDescription() {
        Habit habit = new Habit();
        String newDescription = "Exercise regularly for better health.";
        habit.setDescription(newDescription);
        assertEquals(newDescription, habit.getDescription());
    }

    @Test
    public void testSetSubHabit() {
        Habit habit = new Habit();
        Habit subHabit = new Habit();
        habit.setSubHabit(subHabit);
        assertTrue(habit.getSubHabits().contains(subHabit));
    }

    @Test
    public void testSetCreatedAt() {
        Habit habit = new Habit();
        LocalDateTime createdAt = LocalDateTime.now();
        assertEquals(createdAt.toLocalDate(), habit.getCreatedAt().toLocalDate());
    }

    @Test
    public void testSetUpdatedAt() {
        Habit habit = new Habit();
        habit.setName("Exercise");
        LocalDateTime updatedAt = habit.getUpdatedAt();
        assertNotNull(updatedAt);
    }

}
