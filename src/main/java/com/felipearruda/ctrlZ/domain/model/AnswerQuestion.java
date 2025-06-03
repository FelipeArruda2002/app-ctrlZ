package com.felipearruda.ctrlZ.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "answer_question")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_answer", nullable = false)
    private Long id;

    @Lob
    @Column(name = "ds_answer", nullable = false)
    private String answer;

    @CreationTimestamp
    @Column(name = "date_answer", nullable = false)
    private LocalDate dateAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false, foreignKey = @ForeignKey(name = "fk_answer_question"))
    private LessonQuestion question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false, foreignKey = @ForeignKey(name = "fk_answer_question_teacher"))
    private Teacher teacher;
}
