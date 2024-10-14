package com.naukri.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerRequest implements Serializable {


    @NotNull(message = "fist Name Not Be Null")
    @NotBlank(message = "first Name Not be Blank")
    private String first_name;

    @NotNull(message = "last_name Not Be Null")
    @NotBlank(message = "last_name Not be Blank")
    private String last_name;
    @Email(message = "Must be email format")
    @NotBlank(message = "Email not be Blank")
    @NotNull(message = "Email not be Null")
    private String email;

    private String phone;
    private String type;

}
