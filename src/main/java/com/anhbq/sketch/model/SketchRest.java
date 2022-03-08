package com.anhbq.sketch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SketchRest {
    private Long id;
    private String name;
    private String background;
    private Integer width;
    private Integer height;
    private String imageURL;
}
