package com._3cloudsolutions.smssender.controller;

import com._3cloudsolutions.smssender.service.SmsService;
import com.azure.communication.sms.models.SmsSendResult;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class SmsController {
    // TODO: validate group SMS numbers

    private SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/sms")
    Mono<ResponseEntity<?>> sendSms(@RequestParam(name = "toAddress") String toAddress,
                                    @RequestParam(name = "message") String message) {
        JSONObject response = new JSONObject();

        try {
            toAddress = validateUSPhoneNumber(toAddress);
            if (toAddress.isBlank()) {
                response.put("status", "failed");
                response.put("cause", "invalid phone number");
                return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toJSONString()));
            }

            SmsSendResult smsSendResult = smsService.sendText(toAddress, message);
            if (smsSendResult.isSuccessful()) {
                response.put("status", "success");
                return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response.toJSONString()));
            } else {
                response.put("status", "failed");
                response.put("cause", smsSendResult.getErrorMessage());
                return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toJSONString()));
            }

        } catch (Exception ex) {
            response.put("status", "error");
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.toJSONString()));
        }
    }

    @GetMapping("/asyncsms")
    Mono<ResponseEntity<?>> sendAsyncSms(@RequestParam(name = "toAddress") String toAddress,
                                    @RequestParam(name = "message") String message) {
        JSONObject response = new JSONObject();

        toAddress = validateUSPhoneNumber(toAddress);
        if (toAddress.isBlank()) {
            response.put("status", "failed");
            response.put("cause", "invalid phone number");
            return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toJSONString()));
        }

        try {
            SmsSendResult smsSendResult = smsService.sendAsyncText(toAddress, message);
            if (smsSendResult.isSuccessful()) {
                response.put("status", "success");
                return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response.toJSONString()));
            } else {
                response.put("status", "failed");
                response.put("cause", smsSendResult.getErrorMessage());
                return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toJSONString()));
            }

        } catch (Exception ex) {
            response.put("status", "error");
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.toJSONString()));
        }
    }

    @GetMapping("/groupsms")
    Mono<ResponseEntity<?>> sendGroupSms(@RequestParam(name = "toAddress") List<String> toAddresses,
                                    @RequestParam(name = "message") String message) {
        List<String> failed = new ArrayList<>();
        int failureCount = 0;
        JSONObject response = new JSONObject();

        try {
            Iterable<SmsSendResult> smsSendResults = smsService.sendGroupText(toAddresses, message);
            for (SmsSendResult result : smsSendResults ) {
                if (result.isSuccessful()) {
                    continue;
                } else {
                    failureCount++;
                }
            }
            if (failureCount == 0) {
                response.put("status", "success");
                return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response.toJSONString()));
            } else {
                response.put("status", "failed");
                JSONArray array = new JSONArray();
                for (String fail : failed) {
                    array.add(fail);
                }
                response.put("failedAddresses", array);
                return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toJSONString()));
            }

        } catch (Exception ex) {
            response.put("status", "error");
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.toJSONString()));
        }
    }

    private String validateUSPhoneNumber(String number) {
        number = number.replaceAll("[^0-9]", "");
        if (number.length() == 10) {
            return "+1" + number;
        } else if (number.length() == 11 && number.charAt(0) == '1') {
            return "+" + number;
        } else {
            return "";
        }
    }
}
