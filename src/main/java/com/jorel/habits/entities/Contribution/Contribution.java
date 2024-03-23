package com.jorel.habits.entities.Contribution;

import com.jorel.habits.entities.Habit.Habit;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contributions")
public class Contribution {
    @Id
    private final UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UUID userId;
    @Column(name = "habits", nullable = false)
    @OneToMany(mappedBy = "contribution", cascade = CascadeType.ALL)
    private final List<Habit> habits = new ArrayList<>();
    @Column(name = "force", nullable = false)
    private Integer force;
    @Column(name = "date")
    private final LocalDateTime date;

    public Contribution(){
        this.id = UUID.randomUUID();
        this.date = LocalDateTime.now();
    }

    public Contribution(UUID userId){
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.date = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void addHabit(Habit habit){
        this.habits.add(habit);
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        if(force > 5){
            throw new IllegalArgumentException("Force cannot be bigger than 5.");
        }

        this.force = force;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
