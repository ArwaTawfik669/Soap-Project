package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;
import io.spring.guides.gs_producing_web_service.AddUserRequest;
import io.spring.guides.gs_producing_web_service.AddUserResponse;
import io.spring.guides.gs_producing_web_service.GetAllUserResponse;
import io.spring.guides.gs_producing_web_service.GetAllUserRequest;

import java.math.BigInteger;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userRepository.findUser(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetAllUserResponse getUser(@RequestPayload GetAllUserRequest request) {
        GetAllUserResponse response = new GetAllUserResponse();

        response.setUser1(userRepository.findUser(BigInteger.valueOf(1)));
        response.setUser2(userRepository.findUser(BigInteger.valueOf(2)));
        response.setUser3(userRepository.findUser(BigInteger.valueOf(3)));
        response.setUser4(userRepository.findUser(BigInteger.valueOf(4)));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse getUser(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new  AddUserResponse();
        userRepository.addUser(request.getUser());
        response.setResult("Success");

        return response;
    }
}
