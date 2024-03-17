package com.developers.ipasrilankaapi.dto.core;


import com.developers.ipasrilankaapi.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratedIdentificationDTO implements SuperDTO {
    long id;
    String prefix;
}
