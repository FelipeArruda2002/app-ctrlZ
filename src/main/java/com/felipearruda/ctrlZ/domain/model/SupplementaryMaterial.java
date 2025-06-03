package com.felipearruda.ctrlZ.domain.model;

import com.felipearruda.ctrlZ.domain.enums.TypeSupplementaryMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplementary_material")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplementaryMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_supplementary_material", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 255)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeSupplementaryMaterial type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id",  foreignKey = @ForeignKey(name = "fk_supplementary_material_lesson"))
    private Lesson lesson;
}
