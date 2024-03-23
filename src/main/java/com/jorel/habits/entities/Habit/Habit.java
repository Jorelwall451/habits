package com.jorel.habits.entities.Habit;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "habits")
public class Habit {
    @Id
    private UUID id;
    @Column(name = "name", nullable = false, unique = true, length = 25)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "sub_habits", nullable = false)
    @OneToMany
    private final List<Habit> subHabits = new ArrayList<>();
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Habit(){}

    public Habit(String name, String description){
        this.name = name;
        this.description = description;

        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals(this.name)){
            throw new IllegalArgumentException("You are already using this name, choose another one.");
        }

        this.name = name;
        setUpdatedAt();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.equals(this.description)){
            throw new IllegalArgumentException("You are already using this description, choose another one.");
        }

        this.description = description;
        setUpdatedAt();
    }

    public List<Habit> getSubHabits() {
        return subHabits;
    }

    public void addSubHabit(Habit subHabit) {
        this.subHabits.add(subHabit);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
