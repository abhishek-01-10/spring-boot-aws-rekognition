package com.example.awsrekognition.service;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

@Service
public class AwsRekognitionService {
    @Autowired
    private AmazonRekognition client;

    public List<TextDetection> detectText(MultipartFile imageToCheck) throws IOException {
        DetectTextRequest request = new DetectTextRequest()
                .withImage(new Image().withBytes(ByteBuffer.wrap(imageToCheck.getBytes())));

//        return client.detectModerationLabels(request);
        return client.detectText(request).getTextDetections();
    }

//    public DetectTextResult detectText(MultipartFile imageToCheck) throws IOException {
//        DetectTextRequest request = new DetectTextRequest()
//                .withImage(new Image().withBytes(ByteBuffer.wrap(imageToCheck.getBytes())));
//
//        return client.detectText(request);
//    }



}
