package com.example.domain.repository;

import com.example.domain.model.Message;

import java.util.List;

public interface MessageRepository extends Repository<Message> {

    List<Message> getAllMessages();
}
