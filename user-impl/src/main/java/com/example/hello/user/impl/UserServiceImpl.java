package com.example.hello.user.impl;

import akka.NotUsed;
import com.example.hello.user.api.UserService;
import com.example.hello.user.mapper.ResponseMapper;
import com.example.hello.user.models.UserResponse;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public class UserServiceImpl implements UserService {

    ResponseMapper responseMapper;

    @Inject
    public UserServiceImpl(ResponseMapper responseMapper) {
        this.responseMapper = responseMapper;
    }

    @Override
    public ServiceCall<NotUsed, UserResponse> helloUser() {
        return request ->
        {
			return CompletableFuture.completedFuture(new UserResponse(){
            	{
            		setMessage("Hello User!");
            	}
            });
        };
    }
}
