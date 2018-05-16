package com.example.restlisty.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "listings")
public class Listty {

    @Id
    private String id;
    private String title;
    private Category category;
    private String description;
    private String togs;
    private Region region;
    private User user;
    private Date date;
    private String website;
    private String videoUrl;
    private String ms;
}
