package com.felipearruda.ctrlZ.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "evaluation_attempt")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EvaluationAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_evaluation_attempt", nullable = false)
    private Long id;

    @Column(name = "fl_passed", nullable = false)
    private Boolean passed;

    @CreationTimestamp
    @Column(name = "attempted_at", nullable = false)
    private LocalDate attemptedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_evaluation_attempt_student"))
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "fk_evaluation_attempt_course"))
    private Course course;
}
