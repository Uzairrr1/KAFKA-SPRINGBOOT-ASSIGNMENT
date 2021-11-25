package com.controller;



import com.producer.producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkaapp")
class KafkaController {

    @Autowired
    producer producer;

    @GetMapping(value="/post")
    public String sendMessage(@RequestParam("msg") String msg) {

        producer.publishToTopic(msg);
        return "Publish succesfully";
    }
}