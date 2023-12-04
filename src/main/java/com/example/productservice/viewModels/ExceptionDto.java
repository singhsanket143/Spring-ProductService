package com.example.productservice.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data // equivalent to @setter + @getter
@AllArgsConstructor // gives a constructor with all args to data members
public class ExceptionDto {
    private HttpStatus status;
    private String message;
}
