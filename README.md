# CtrlZ- Online Programming Course Platform

## 📘 Project Overview

**CtrlZ** is an educational platform designed for online courses in the field of programming, databases, and quality assurance (Q.A). This MVP focuses on the pedagogical aspects of the platform, providing students and teachers with essential tools for course delivery, tracking, and evaluation.

## 🎯 MVP Goals

The main goal of this MVP is to deliver a functional backend system that supports the core functionalities of a course platform, including:

- Course and lesson management
- Student enrollment and lesson progress tracking
- Chat-based assessments for students
- Supplementary materials for lessons
- Teacher-student interaction through question/answer threads
- Course evaluation and feedback
- Certificate generation upon course completion
- Notification system for updates

## 🧱 Features

### ✅ Core Features
- **User Management**: Register and authenticate students and teachers.
- **Courses & Lessons**: Teachers can create courses with YouTube-based lessons.
- **Lesson Progress**: Tracks which lessons a student has completed.
- **Assessments**: Chat-based quizzes to evaluate students at the end of a course.
- **Supplementary Materials**: Additional resources (PDFs, links, etc.) for each lesson.
- **Q&A Section**: Students can submit questions related to lessons and receive answers from teachers.
- **Course Evaluation**: Students rate and comment on the course after completion.
- **Certificates**: Automatically generated certificates for students who complete a course.
- **Notifications**: In-app notifications for events like new lessons, answers, or course updates.

### 🔒 Business Rules
- Students have **3 attempts** to pass the final course evaluation.
- After 3 failed attempts, students are **blocked from retaking the test for 3 days**.
- Courses can have **multiple categories**, stored using an `EnumSet` to avoid an additional table.

## 🧪 Technologies

- **Backend**: Java 21, Spring Boot
- **Database**: PostgreSQL
- **ORM**: JPA/Hibernate
- **Frontend (planned)**: Angular
- **Notification System**: Based on Observer pattern (Publisher/Subscriber model)
- **Chat Assessment**: Integration with ChatGPT (OpenAI API)
- **Certificate Generation**: Blob storage for downloadable PDF files
- **Hosting (planned)**: AWS (Free Tier usage with S3, RDS, EC2 or Lambda)
