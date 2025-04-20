package com.felipearruda.ctrlZ.domain.model;

import com.felipearruda.ctrlZ.domain.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id",  foreignKey = @ForeignKey(name = "fk_course_teacher"))
    private Teacher teacher;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "course_categories", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "category")
    private Set<Category> categories;
}
