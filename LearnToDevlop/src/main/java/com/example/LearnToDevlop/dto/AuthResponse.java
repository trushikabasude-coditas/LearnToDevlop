package com.example.LearnToDevlop.dto;

import lombok.Getter;
import lombok.Setter;

public record AuthResponse(String token,String username,String role) {

}
