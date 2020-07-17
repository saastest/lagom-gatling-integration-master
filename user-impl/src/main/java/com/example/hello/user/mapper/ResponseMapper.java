package com.example.hello.user.mapper;

import com.example.hello.user.models.UserResponse;

public class ResponseMapper {

    public UserResponse getResponse(String userData) {
        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("Hello, Your UserId is " + userData);
        return userResponse;
    }
}
