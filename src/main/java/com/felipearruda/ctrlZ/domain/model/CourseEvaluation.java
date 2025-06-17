package com.felipearruda.ctrlZ.domain.model;

import com.felipearruda.ctrlZ.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "course_evaluation")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_course_evaluation", nullable = false)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    @CreationTimestamp
    @Column(name = "evaluation_date", nullable = false)
    private LocalDate evaluationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "fk_course_evaluation_course"))
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "fk_course_evaluation_student"))
    private Student student;

}
