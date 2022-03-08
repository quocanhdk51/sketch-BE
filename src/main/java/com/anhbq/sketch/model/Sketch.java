package com.anhbq.sketch.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sketch {
    @SequenceGenerator(
            name = "sketch_sequence",
            sequenceName = "sketch_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sketch_sequence"
    )
    private Long id;
    @Column(unique = true)
    private String name = "New Sketch";
    @Lob
    private byte[] imageURL;
    private String background = "#FFFFFF";
    private Integer width = 0;
    private Integer height = 0;

    public Sketch(
            byte[] imageURL,
            String name,
            String background,
            Integer width,
            Integer height
    ) {
        this.imageURL = imageURL;
        this.name = name;
        this.background = background;
        this.width = width;
        this.height = height;
    }
}
