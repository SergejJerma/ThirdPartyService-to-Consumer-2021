package com.visma.task.thirdpartyservice.controller;

import com.visma.task.thirdpartyservice.model.Status;
import com.visma.task.thirdpartyservice.model.StatusType;
import com.visma.task.thirdpartyservice.service.ProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.visma.task.thirdpartyservice.utils.RandomUtils.getRandomNumber;

@RestController
public class RestAPIController {

    private final ProcessingService processingService;

    public RestAPIController(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @PostMapping("/init")
    public ResponseEntity<String> init() throws InterruptedException {
        return ResponseEntity.ok(processingService.addNewItemToStorage());
    }

    @GetMapping("/checkStatus/{uuid}")
    public ResponseEntity<Status> checkStatus(@PathVariable String uuid) {
        StatusType statusType = processingService.getStatus(uuid);
        return ResponseEntity.ok(new Status(uuid, statusType));
    }



}
