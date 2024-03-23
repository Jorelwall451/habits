package com.jorel.habits.entities.User;

import com.jorel.habits.entities.Contribution.Contribution;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    private final UUID id;
    @Column(name = "name", nullable = false, length = 25)
    private String name;
    @Column(name = "age", nullable = false, length = 100)
    private Integer age;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "contributions", nullable = false)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final List<Contribution> contributions = new ArrayList<>();
    @Column(name = "created_at", updatable = false, nullable = false)
    private final LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "login_at")
    private LocalDateTime loginAt;

    public User(){
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
        this.name = name;
        setUpdatedAt();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        setUpdatedAt();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        setUpdatedAt();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        setUpdatedAt();
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void addContribution(Contribution contribution) {
        this.contributions.add(contribution);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getLoginAt() {
        return loginAt;
    }

    public void setLoginAt() {
        this.loginAt = LocalDateTime.now();
    }
}
