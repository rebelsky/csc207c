---
title: Grading instructions for MP3 (ASCII Blocks)
link: false
---
# {{ page.title}}

1. Read through the assignment at https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/mps/mp03.html to make sure that you understand the expectations.

2. Clone the original project repository. That will give you access to the testing and style files. <https://github.com/Grinnell-CSC207/mp-blocks-maven>

3. Clone the student's GitHub repository. (The README.md file should indicate where it is.)

4. Copy the testing files from the original repository into the student's repository. (This step helps us deal with students who decide to pass tests by changing or removing them. I don't expect that there are many/any such students, but it's best to be safe.)
    * `src/test/java/edu/grinnell/csc207/TestBlockEquiv.java`
    * `src/test/java/edu/grinnell/csc207/TestBlocks.java`
    * `src/test/java/edu/grinnell/csc207/TestUtils.java`

5. Copy the style file from the original repository into the student's repository. That's `csc207-checks.xml`. (We have a slightly different version of that file for this assignment.)

6. You should be able to compile their code with `mvn compile -q`, test their code with `mvn test`, and check their style with `mvn checkstyle:check`.  You should be able to check their git commits with `git log`.

7. On Gradescope, fill out the checklists for R, M, and E. If there's a checklist item they miss, please add it to the comments section (along with a helpful comment) so that they'll be able to address it the next time through. For example, 

    `[ ] TestNewBlock.java includes at least two interesting edge cases, such as empty blocks. I only see one. Perhaps consider one that uses an HComp as a sub-block.`

8. Please take the time to skim their code to see if their stylistic issues that checkstyle doesn't check, like bad variable names or inefficient algorithms. I'd like every student to receive a few comments on their style.

8. Once you've gone through the checklists and the code, you should have a grade to assign (I, R, M, or E). This semester, we're using 1 for I, 2 for R, 3 for M, and 4 for E so that I can more readily distinguish students who submitted something not at R level from those who didn't submit anything at all.

10. Make sure to say something positive in the comments section. "Great job." "It looks like you struggled a bit, but you did a nice job on HComp."

Let me know if you find that you have questions.
