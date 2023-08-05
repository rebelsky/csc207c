---
title: Learning assessments
summary: How we assess your learning.
permalink: /las/
---

# Learning assessments

To directly assess your mastery of the learning objectives of this course, we will conduct a series of learning assessments, both individually and in sets (SoLAs), over the course of the semester.
The use LAs of this course is inspired by [mastery-based testing](https://mbtmath.wordpress.com/) practices found in mathematics.

SoLAs consist of a set of individual assessment problems---one problem for each learning objective of the course covered so far.  

Most of the LAs will also appear as in-class paper-based ten-minute quizzes, given at the start of class on various days.

All of the LAs in a phase (except those marked as in-class-only) will be released as a SoLA on gradescope.  **Do not discuss the problems on the SoLA with anyone until I have returned graded problems.**

You may choose to attempt as many of the individual assessment problems as you wish for that period.  As described in the [syllabus]({{ "/syllabus" | relative_url }}), LA problems are graded on a binary *satisfactory (S)/not satisfactory (N)*.
Once you receive a satisfactory on a problem tied to a particular learning objective, you do not need to attempt additional problems tied to that learning objective in subsequent SoLAs, *i.e.*, you have demonstrated sufficient mastery of that objective, so you are done with it!

## Learning objectives

The objectives may change slightly during the semester as the schedule shifts.

{% for la in site.data.learning-goals %}
**{{ la.assessment }}**
{% for goal in la.goals %}
1.  {{ goal }}
{% endfor %}
{% endfor %}

## Rubrics for learning assessments

**Programming problems**

For programming problems in learning assessments, we are concerned primarily with correctness rather than design.  Make sure that your program works according to the specification outlined in the problem by testing it on a variety of inputs.  Pay attempt to the prompt for guidance about what aspects of design you need to include in your program, *e.g.*, documentation or explicit test suites.

**Written problems**

For problems with written responses, we are looking for responses that *address the prompt directly and concisely*.  In particular, if a written problems asks you to solve a problem in a certain style or show your work, *e.g.*, the trace of the execution of a program, make sure to include this information in the style presented in class.

## Sample SoLAs

_Forthcoming._
