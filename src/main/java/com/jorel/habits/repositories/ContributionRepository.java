package com.jorel.habits.repositories;

import com.jorel.habits.entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContributionRepository extends JpaRepository<User, UUID> {
}
