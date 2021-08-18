package com.service.register.SERVICEREGISTRATION.impl;

import com.service.register.SERVICEREGISTRATION.config.UserInformationConfig;
import com.service.register.SERVICEREGISTRATION.entity.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ServiceRegistrationAPIImpl {

    @Autowired
    private UserInformationConfig userInformationConfig;

    public UserInformation getUserInformation(String username) {
        List<UserInformation> userInformationList = userInformationConfig.userInformationMock();
        UserInformation userInformation = null;
        if (userInformationList.stream().filter(w -> w.getUsername().equals(username)).findFirst().isPresent()) {
            userInformation = userInformationList.stream().filter(w -> w.getUsername().equals(username)).findFirst().get();
        }
        return userInformation;
    }

    public ResponseEntity<String> createUserInformation(UserInformation userInformation) {
        try {
            if (getUserInformation(userInformation.getUsername()) == null) {
                String dateTime = new SimpleDateFormat("YYYYMMDD").format(Calendar.getInstance().getTime());
                String genReferenceCode = dateTime.concat(userInformation.getPhone().substring(6, userInformation.getPhone().length()));
                userInformation.setReferenceCode(genReferenceCode);
                if (userInformation.getSalary() > 50000) {
                    userInformation.setMemberType("Platinum");
                } else if (userInformation.getSalary() > 30000 && userInformation.getSalary() < 50000) {
                    userInformation.setMemberType("Gold");
                } else if (userInformation.getSalary() <= 30000 && userInformation.getSalary() >= 15000) {
                    userInformation.setMemberType("Silver");
                } else {
                    return new ResponseEntity<>("{\"message\":\"Salary must more than or equal 15000 Bath\"}", HttpStatus.CONFLICT);
                }
                userInformationConfig.userInformationMock().add(userInformation);
                return new ResponseEntity<>("{\"message\":\"Create Success\"}", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("{\"message\":\"username is duplicate\"}", HttpStatus.CONFLICT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"message\":\"Create UserInformation Failed\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
