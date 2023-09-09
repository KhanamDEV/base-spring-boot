package com.tkg.MasterSystem.controllers;

import com.tkg.MasterSystem.dto.GeoLiteDto;
import com.tkg.MasterSystem.payload.requests.authentication.SendSignInCodeRequest;
import com.tkg.MasterSystem.services.impl.AuthenticationService;
import com.tkg.MasterSystem.utils.Helper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/authentication")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {

    private final AuthenticationService authenticationService;

    private final Helper helper;
    @PostMapping(path = "send-sign-in-code")
    public GeoLiteDto sendSignInCode(@RequestBody(required = false) @Valid SendSignInCodeRequest sendSignInCodeRequest) {
//        try{
            return helper.getGeoLocation("sss");
//        } catch (Exception e){
//
//        }
    }

}
