package com._3cloudsolutions.demo.appconfigfeatureflags.dto;

import com._3cloudsolutions.demo.appconfigfeatureflags.models.DemoValue;
import lombok.Data;

@Data
public class DemoValueDTO {
    private String question;
    private String answer;
    private String featureFlagStatus;

    public DemoValueDTO(DemoValue demoValue){
        this.question = demoValue.getValue1();
        this.answer = demoValue.getValue2();
    }

}
