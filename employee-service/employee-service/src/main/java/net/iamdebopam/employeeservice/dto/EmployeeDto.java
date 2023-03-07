package net.iamdebopam.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long id;

    //user first name should not be null or empty
    //@NotEmpty(message = "User First name should not be null or empty")
    private String firstName;
    //@NotEmpty(message = "User Last name should not be null or empty")
    private String lastName;

    // User email should not be null or empty
    //Email address should be valid
    //@NotEmpty(message = "User Email should not be null or empty")
    //@Email(message = "Email Address should be Valid")
    private String email;
}
