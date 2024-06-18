package com.naukri.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerResponse implements Serializable {

    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String type;

}
