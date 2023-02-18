package com.datdt.kafkademo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("message")
    private String message;
}
