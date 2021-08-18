package com.service.register.SERVICEREGISTRATION.config;

import com.service.register.SERVICEREGISTRATION.entity.UserInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserInformationConfig {

    @Bean
    public List<UserInformation> userInformationMock() {
        List<UserInformation> userInformationList = new ArrayList<>();
        UserInformation userInformation = new UserInformation();
        userInformation.setName("A");
        userInformation.setSurname("HODJUNG");
        userInformation.setUsername("misterA");
        userInformation.setPassword("12345678");
        userInformation.setAddress("BAN KOK KOKK");
        userInformation.setMemberType("Platinum");
        userInformation.setPhone("088-5885885");
        userInformation.setSalary(51000);
        userInformation.setReferenceCode("202108075885");

        userInformationList.add(userInformation);
        return userInformationList;
    }
}
