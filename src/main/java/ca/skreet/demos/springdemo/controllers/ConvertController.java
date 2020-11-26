package ca.skreet.demos.springdemo.controllers;

import ca.skreet.demos.springdemo.data.ConvertData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @GetMapping("/convert")
    @CrossOrigin(origins = {"http://localhost:8080","null"})
    public ConvertData conversion(@RequestParam(value="input",defaultValue = "1")String input) {
        try {
            ConvertData data = new ConvertData(input);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ConvertData("1");
    }

}
