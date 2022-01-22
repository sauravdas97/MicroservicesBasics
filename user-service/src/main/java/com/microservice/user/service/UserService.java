package com.microservice.user.service;

import com.microservice.user.ValueObject.Department;
import com.microservice.user.ValueObject.ResponseTemplate;
import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of Service");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
