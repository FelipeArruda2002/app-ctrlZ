package com.felipearruda.ctrlZ.domain.model;

import com.felipearruda.ctrlZ.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "lesson_question")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LessonQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lesson_question", nullable = false)
    private Long id;

    @Lob
    @Column(name = "ds_question", nullable = false)
    private String question;

    @CreationTimestamp
    @Column(name = "date_question", nullable = false)
    private LocalDate dateQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", foreignKey = @ForeignKey(name = "fk_question_lesson_lesson"))
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_question_lesson_student"))
    private Student student;

}
