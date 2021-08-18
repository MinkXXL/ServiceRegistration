package com.service.register.SERVICEREGISTRATION.controller;

import com.service.register.SERVICEREGISTRATION.entity.UserInformation;
import com.service.register.SERVICEREGISTRATION.impl.ServiceRegistrationAPIImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Service.Registration", value = "/rest/api/v1/service/registration", description = "Service Registration APIs")
@RequestMapping(value = "/rest/api/v1/service/registration")
public class ServiceRegistrationAPI {
    @Autowired
    ServiceRegistrationAPIImpl serviceRegistrationAPIIml;

    @ApiOperation(value = "test", nickname = "test oauth2", notes = "This API is used for test oauth2 server.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> test() throws Exception {
        return new ResponseEntity<>("{\"message\":\"Congrats, on unlocking the secret!\"}", HttpStatus.OK);
    }

    @ApiOperation(value = "create user information", notes = "This API is used for create information.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    @RequestMapping(value = "/create/userInformation", method = RequestMethod.POST)
    public ResponseEntity<String> createUserInformation(@Valid @RequestBody(required = true) UserInformation userInformation) throws Exception {
        return serviceRegistrationAPIIml.createUserInformation(userInformation);
    }

    @ApiOperation(value = "get user information", notes = "This API is used for get information.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    @RequestMapping(value = "/userInformation", method = RequestMethod.POST)
    public UserInformation getUserInformation(
            @ApiParam(name = "username", value = "username", required = true)
            @RequestParam(value = "username") String username) throws Exception {
        return serviceRegistrationAPIIml.getUserInformation(username);
    }
}
