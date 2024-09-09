package com.erick.tourismsystem.dto;

public record SignupRequestDTO(
         Long id,
         String email,
         String password,
         String name,
         String lastname,
         String phone
        )
{}
