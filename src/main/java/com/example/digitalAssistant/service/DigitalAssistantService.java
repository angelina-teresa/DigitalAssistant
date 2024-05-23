package com.example.digitalAssistant.service;

import com.example.digitalAssistant.entity.Message;
import com.example.digitalAssistant.exception.InvalidInputException;
import com.example.digitalAssistant.model.MessageModel;
import com.example.digitalAssistant.model.Response;
import com.example.digitalAssistant.repository.DigitalAssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DigitalAssistantService {

    @Autowired
    private DigitalAssistantRepository digitalAssistantRepository;

    public void saveMessage(MessageModel messageModel) throws InvalidInputException {
        if(messageModel.getName() == null || messageModel.getResponse() == null){
            throw new InvalidInputException("Invalid Input", HttpStatus.BAD_REQUEST);
        }
            Message message = new Message(messageModel.getName().toLowerCase().trim(),
                    messageModel.getResponse().toLowerCase());
            digitalAssistantRepository.save(message);
    }

    public ResponseEntity<Response> getMessage(MessageModel messageModel) throws InvalidInputException {
        ResponseEntity<Response> responseEntity;
        if(messageModel.getName() == null){
            throw new InvalidInputException("Invalid Input", HttpStatus.BAD_REQUEST);
        }
        Optional<Message> message = digitalAssistantRepository.findById(messageModel.getName().toLowerCase().trim());
        if (message.isPresent()) {
            Response response = new Response();
            response.setResponse(message.get().getResponse());
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else
            throw new InvalidInputException("Input text not found", HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
