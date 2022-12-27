package com.emsi.pfe.contoller;

import com.emsi.pfe.model.PassengerDTO;
import com.emsi.pfe.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    SecurityUtils securityUtils;
    @GetMapping("/passengers/{passengerPublicId}")
    public PassengerDTO getPassengerByPublicId(@PathVariable String passengerPublicId, @RequestHeader(name = "name",required = false) String name)
    {
        PassengerDTO passengerDTO=new PassengerDTO();
        passengerDTO.setPublicId(passengerPublicId);
        passengerDTO.setCin("MH9"+UUID.randomUUID().toString().charAt(0));
        passengerDTO.setBirthday(new Date());
        passengerDTO.setLastName("Passenger");
        passengerDTO.setFirstName("Passenger");
        passengerDTO.setPhoneNumber("+212689788979");
        return passengerDTO;
    }

    @GetMapping("/passengers")
    public PassengerDTO getPassengerByEmail(@RequestHeader(name = "email",required = false) String email, HttpServletRequest request)
    {
        PassengerDTO passengerDTO=new PassengerDTO();
        passengerDTO.setPublicId(email);
        passengerDTO.setCin("MH9"+UUID.randomUUID().toString().charAt(0));
        passengerDTO.setBirthday(new Date());
        passengerDTO.setLastName("Passenger");
        passengerDTO.setFirstName("Passenger");
        passengerDTO.setPhoneNumber("+212689788979");
        return passengerDTO;
    }
}
