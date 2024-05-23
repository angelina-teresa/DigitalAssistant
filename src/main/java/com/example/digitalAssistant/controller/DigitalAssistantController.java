package com.example.digitalAssistant.controller;

import com.example.digitalAssistant.exception.InvalidInputException;
import com.example.digitalAssistant.model.MessageModel;
import com.example.digitalAssistant.model.Response;
import com.example.digitalAssistant.service.DigitalAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DigitalAssistantController {

    @Autowired
    private DigitalAssistantService digitalAssistantService;
    ResponseEntity<Response> responseEntity = null;

    @PostMapping("/saveMessage")
    public ResponseEntity<Response> saveMessage(@RequestBody MessageModel messageModel) {
        Response response = new Response();
        try {
            digitalAssistantService.saveMessage(messageModel);
            response.setResponse("Entry added");
            responseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (InvalidInputException e) {
            response.setResponse(e.getMessage());
            responseEntity = new ResponseEntity<>(response, e.getHttpStatus());
        }
        return responseEntity;
    }

    @PostMapping("/getMessage")
    public ResponseEntity<Response> getMessage(@RequestBody MessageModel messageModel) {

        try {
            responseEntity = digitalAssistantService.getMessage(messageModel);
        } catch (InvalidInputException e) {
            Response response = new Response();
            response.setResponse(e.getMessage());
            responseEntity = new ResponseEntity<>(response,e.getHttpStatus());
        }
        return responseEntity;
    }

}
