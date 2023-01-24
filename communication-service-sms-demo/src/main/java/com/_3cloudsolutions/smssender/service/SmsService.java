package com._3cloudsolutions.smssender.service;

import com._3cloudsolutions.smssender.config.SmsServerConfig;
import com.azure.communication.sms.SmsAsyncClient;
import com.azure.communication.sms.SmsClient;
import com.azure.communication.sms.models.SmsSendOptions;
import com.azure.communication.sms.models.SmsSendResult;
import com.azure.core.util.Context;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Component
public class SmsService {

    private SmsClient smsClient;
    private SmsAsyncClient smsAsyncClient;
    private SmsServerConfig smsServerConfig;

    public SmsService(SmsClient smsClient, SmsAsyncClient smsAsyncClient, SmsServerConfig smsServerConfig) {
        this.smsClient = smsClient;
        this.smsAsyncClient = smsAsyncClient;
        this.smsServerConfig = smsServerConfig;
    }

    public SmsSendResult sendText(String to, String message) {
        SmsSendResult smsSendResult = null;
        SmsSendOptions options = new SmsSendOptions();
        options.setDeliveryReportEnabled(true);

        smsSendResult = smsClient.send(smsServerConfig.getFromNumber(), to, message, options);

        return smsSendResult;
    }

    @Async
    public SmsSendResult sendAsyncText(String to, String message) {
        SmsSendResult smsSendResult = null;
        SmsSendOptions options = new SmsSendOptions();
        options.setDeliveryReportEnabled(true);

        smsSendResult = smsClient.send(smsServerConfig.getFromNumber(), to, message, options);

        return smsSendResult;
    }

    public Iterable<SmsSendResult> sendGroupText(List<String> to, String message) {
        Iterable<SmsSendResult> smsSendResult = null;
        SmsSendOptions options = new SmsSendOptions();
        options.setDeliveryReportEnabled(true);

        smsSendResult = smsClient.sendWithResponse(smsServerConfig.getFromNumber(), to, message,
                options, Context.NONE).getValue();

        return smsSendResult;
    }

}
