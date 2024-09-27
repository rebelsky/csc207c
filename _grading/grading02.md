---
title: Grading instructions for mini-project 2 (Fraction Calculators)
link: false
---
# {{ page.title }}

_These are the instructions that we've provided to the graders._

1. Read through the assignment instructions to make sure that you understand the expectations. <{{ site.url }}/mps/mp02.html>.

2. Make a copy of the unit tests for the assignment. <{{ site.url }}/code/calculator/TestMP02.java>.

3. Make a copy of the course style file. <{{ site.url }}/files/csc207-checks.xml>. 

4. Clone the student's GitHub repository. (The `README.md` file should indicate where it is. If not, download from Gradescope and do the best you can. The student should get an **I** for not submitting properly, but you should still review their work.)

5. Copy the test file into the appropriate location (presumably, `src/test/java/edu/grinnell/csc207`).

6. Copy the course style file into the top level of their Maven repository.

7. You should be able to compile their code with `mvn compile -q`, test their code with `mvn test`, and check their style with `mvn checkstyle:check`.

8. Since there are interactive programs in this assignment and the students have some freedom in what the output looks like, you'll have to check them manually. Their are scripts for checking the programs after the Rubric in the assignment. Use those, taking notes as you go.

9. On Gradescope, fill out the checklists for R, M, and E. If there's a checklist item they miss, please add it to the comments (along with a helpful note), so that they can address it next time.

    For example, `[ ] Handles expressions with one operator and two registers. It looks like your code works correctly if the second value is a register, but not the first. Try something like 1/2 + a.`

10. Please take the time to skim their code to see if their stylistic issues that checkstyle doesn't check, like bad variable names or inefficient algorithms. I'd like every student to receive a few comments on their style.

11. Once you've gone through the checklists and the code, you should have a grade to assign (I, R, M, or E). This semester, we're using 1 for I, 2 for R, 3 for M, and 4 for E so that I can more readily distinguish students who submitted something not at R level from those who didn't submit anything at all.

12. Make sure to say something positive in the comments section. "Great job." "It looks like you struggled a bit, but you did a nice job on setting up the Maven infrastructure."

If you find yourself unsure about how to deal with an issue, reach out on Teams.
