package com.naukri.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCustomerRecord {

    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String type;
}
