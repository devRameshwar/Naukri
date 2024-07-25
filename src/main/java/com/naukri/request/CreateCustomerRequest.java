package com.naukri.request;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerRequest implements Serializable {


    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String type;

}
