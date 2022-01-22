package com.microservice.user.ValueObject;

// this is the wrapper class which contains both User and Department


import com.microservice.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
    private User user;
    private Department department;
}
