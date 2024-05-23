package com.example.digitalAssistant.repository;

import com.example.digitalAssistant.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DigitalAssistantRepository extends JpaRepository<Message, String> {
}
