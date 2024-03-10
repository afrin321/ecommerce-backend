package com.webshop.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
