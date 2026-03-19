package me.su.springdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class quizController {
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code")int code ){
        switch (code){
            case 1:
                return ResponseEntity.created(null).body("Created");

            case 2:
                return ResponseEntity.badRequest().body("Bad request");

            default:
                return ResponseEntity.ok().body("ok");
        }

    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code){
        switch (code.value()){
            case 1:
                return ResponseEntity.status(404).body("Forbidden");

            default:
                return ResponseEntity.ok().body("ok");
        }

    }

    record Code(int value){}

}
