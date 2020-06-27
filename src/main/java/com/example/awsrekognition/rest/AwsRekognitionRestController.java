package com.example.awsrekognition.rest;

import com.amazonaws.services.rekognition.model.TextDetection;
import com.example.awsrekognition.service.AwsRekognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/api")
public class AwsRekognitionRestController {

    @Autowired
    private AwsRekognitionService awsRekognitionService;



    @PostMapping("/image/text-detection")
    public List<String> detectText(@RequestParam MultipartFile image) throws IOException {
        List<TextDetection> list = awsRekognitionService.detectText(image);
        ArrayList<String> result = new ArrayList<>();
        list.forEach((text) -> {
            result.add(text.getDetectedText());
        });
        return result;

    }

//    @PostMapping("/image/text-detection")
//    public Object detectText(@RequestParam MultipartFile image) throws IOException {
//        return ResponseEntity.ok(awsRekognitionService.detectText(image));
//    }


}
