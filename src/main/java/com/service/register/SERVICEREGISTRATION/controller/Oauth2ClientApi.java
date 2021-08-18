package com.service.register.SERVICEREGISTRATION.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Oauth2.client", value = "/rest/api/v1/oauth2Client", description = "Oauth2 Client APIs")
@RequestMapping(value = "/rest/api/v1/oauth2Client")
public class Oauth2ClientApi {

    @ApiOperation(value = "test", nickname = "test oauth2", notes = "This API is used for test oauth2 server.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> test() throws Exception {
        return new ResponseEntity<>("{\"message\":\"Congrats, on unlocking the secret!\"}", HttpStatus.OK);
    }
}
