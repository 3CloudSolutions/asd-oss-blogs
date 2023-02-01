package com.threecloud.kitchenbff.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO implements Serializable {
    private static final long serialVersionUID = 9205788174730279956L;

    private String name;
    private String city;
    private String state;

}
