package demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(
            @RequestParam(required = false, defaultValue = "Stranger") String name) {
        return ResponseEntity.ok(String.format("Hello, %s!", name));
    }
}
