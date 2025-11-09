package com.simportal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sims")
public class Sim {
    @Id
    private String id;
    private String iccId;      // unique
    private boolean active = false;
}