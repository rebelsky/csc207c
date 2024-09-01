---
title: Build systems and Maven
summary: |
  We consider a bit about command-line build systems and explore some
  details of one such system, Maven.
---
_Note! This reading contains lots and lots of sample output. You do not need to read that sample output carefully._

_Note: This reading is new for Fall 2024._

In CSC-161, you learned the basics of Make (or at least I hope you learned the basics of Make). Make is a prototypical "build tool" or "build system". Make and its relatives make it comparatively simple to put together a project that is composed of multiple moving parts. Build tools emerge from two common software design inclinations: (a) don't do things by hand when you can do them by code and (b) generalize!

That is, these tools let you move from a situation in which instead of providing instructions to someone else for building a project from multiple files, you can just provide an instruction for them to type for the project. And, instead of using a different process for each project, you use the same process. In effect, many build systems are _declarative_ rather than imperative; the project designer documents steps and dependencies and the system figures out what to do.

What are the most common tasks? You can *build* a program or library from the source files (when working with C, compiling `.c` files to `.o` files and then linking them). You can often *test* the code to make sure it works once compiled. You can *clean up* your system after you are done (when working with C, removing all those no-longer-necessary `.o` files). There are, of course, many more.

Although you can use Make to manage Java projects, most Java programmers use a newer build tool that has been designed specifically for Java. There are a bunch: Ant (old), Gradle, Maven, Bazel, and more. One nice aspect of some modern build tools is that they have a fairly generous view of "building". For example, some tools will even download additional software you might need to complete a task.
(Not everyone takes this as a positive.)

You might think, "I use an IDE (integrated development environment); why do I need a build tool?" There are a number of reasons. One is that you might be working on a project that other people started. Another is that different members of the team working on the project may want to use different IDEs. Yet another is that sometimes we just want to build and deploy software without editing it; the build tool provides the instructions for doing so.

## The Maven build tool

In this class, we'll use the Maven build tool, one of the more popular Java build tools. Our use of Maven will be relatively straightforward; we'll primarily take advantage of Maven's ability to run tests on code (including syntax checks).

Your Maven configuration is stored in the file `pom.xml`. The "pom" stands for "Project Object Model". XML is a standard mechanism for representing data. It's somewhat human-readable and writable, but definitely computer readable.

We'll generally use just a few standard Maven instructions, including for testing the program, running the program, and checking syntax.

## Getting started with Maven

There are a variety of ways you might start a Maven project.  Most frequently, you'll ask Maven to generate the initial setup using a template ("archetype", in Maven speak).

To set the initial project parameters interactively, you simply type

    mvn archetype:generate

One danger of doing that is you will see a catalog of all the possible archetype. The last time I checked, there were about 3500.

    $ mvn archetype:generate
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ------------------< org.apache.maven:standalone-pom >-------------------
    [INFO] Building Maven Stub Project (No POM) 1
    [INFO] --------------------------------[ pom ]---------------------------------
    [INFO] 
    [INFO] >>> archetype:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
    [INFO] 
    [INFO] <<< archetype:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
    [INFO] 
    [INFO] 
    [INFO] --- archetype:3.2.1:generate (default-cli) @ standalone-pom ---
    [INFO] Generating project in Interactive mode
    [INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
    Choose archetype:
    1: remote -> am.ik.archetype:elm-spring-boot-blank-archetype (Blank multi project for Spring Boot + Elm)
    2: remote -> am.ik.archetype:graalvm-blank-archetype (Blank project for GraalVM)
    3: remote -> am.ik.archetype:graalvm-springmvc-blank-archetype (Blank project for GraalVM + Spring MVC)
    4: remote -> am.ik.archetype:graalvm-springwebflux-blank-archetype (Blank project for GraalVM + Spring MVC)
    ...
    3455: remote -> xyz.luan.generator:xyz-generator (-)
    3456: remote -> za.co.absa.hyperdrive:component-archetype (-)
    3457: remote -> za.co.absa.hyperdrive:component-archetype_2.11 (-)
    3458: remote -> za.co.absa.hyperdrive:component-archetype_2.12 (-)
    Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 2167:

    Choose org.apache.maven.archetypes:maven-archetype-quickstart version:
    1: 1.0-alpha-1
    2: 1.0-alpha-2
    3: 1.0-alpha-3
    4: 1.0-alpha-4
    5: 1.0
    6: 1.1
    7: 1.3
    8: 1.4
    Choose a number: 8:

    Define value for property 'groupId': edu.grinnell.csc207

    Define value for property 'artifactId': my-project

    Define value for property 'version' 1.0-SNAPSHOT: : 

    Define value for property 'package' edu.grinnell.csc207: : 

    Confirm properties configuration:
    groupId: edu.grinnell.csc207
    artifactId: my-project
    version: 1.0-SNAPSHOT
    package: edu.grinnell.csc207
     Y: : 

    [INFO] ----------------------------------------------------------------------------
    [INFO] Using following parameters for creating project from Archetype: maven-archetype-quickstart:1.4
    [INFO] ----------------------------------------------------------------------------
    [INFO] Parameter: groupId, Value: edu.grinnell.csc207
    [INFO] Parameter: artifactId, Value: my-project
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] Parameter: package, Value: edu.grinnell.csc207
    [INFO] Parameter: packageInPathFormat, Value: edu/grinnell/csc207
    [INFO] Parameter: package, Value: edu.grinnell.csc207
    [INFO] Parameter: groupId, Value: edu.grinnell.csc207
    [INFO] Parameter: artifactId, Value: my-project
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] Project created from Archetype in dir: /Users/rebelsky/CSC207/Projects/my-project
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  03:17 min
    [INFO] Finished at: 2024-08-27T12:49:35-05:00
    [INFO] ------------------------------------------------------------------------

Wasn't that exciting? You'll note that in some cases, I just hit return/enter to accept the suggested value.

Of course, the catalog of options is a bit annoying. If you want to avoid the long catalog of choices, you can add a command-line flag to specify the appropriate archetype.

    mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

Let's see how that goes.

    $ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ------------------< org.apache.maven:standalone-pom >-------------------
    [INFO] Building Maven Stub Project (No POM) 1
    [INFO] --------------------------------[ pom ]---------------------------------
    [INFO] 
    [INFO] >>> archetype:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
    [INFO] 
    [INFO] <<< archetype:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
    [INFO] 
    [INFO] 
    [INFO] --- archetype:3.2.1:generate (default-cli) @ standalone-pom ---
    [INFO] Generating project in Interactive mode
    Define value for property 'groupId': edu.grinnell.csc207
    Define value for property 'artifactId': my-project
    Define value for property 'version' 1.0-SNAPSHOT: : 
    Define value for property 'package' edu.grinnell.csc207: : 
    Confirm properties configuration:
    groupId: edu.grinnell.csc207
    artifactId: my-project
    version: 1.0-SNAPSHOT
    package: edu.grinnell.csc207
     Y: : 
    [INFO] ----------------------------------------------------------------------------
    [INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0
    [INFO] ----------------------------------------------------------------------------
    [INFO] Parameter: basedir, Value: /Users/rebelsky/CSC207/Projects/YAMaven
    [INFO] Parameter: package, Value: edu.grinnell.csc207
    [INFO] Parameter: groupId, Value: edu.grinnell.csc207
    [INFO] Parameter: artifactId, Value: my-project
    [INFO] Parameter: packageName, Value: edu.grinnell.csc207
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] project created from Old (1.x) Archetype in dir: /Users/rebelsky/CSC207/Projects/my-project
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  42.059 s
    [INFO] Finished at: 2024-08-27T12:53:37-05:00
    [INFO] ------------------------------------------------------------------------

That's a bit better, but still a bit verbose. Fortunately, you can specify all the options on the command-line.

    mvn archetype:generate -DgroupId=edu.grinnell.csc207 -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

    $ mvn archetype:generate -DgroupId=edu.grinnell.csc207 -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
    [INFO] Scanning for projects...
    [INFO]
    [INFO] ------------------< org.apache.maven:standalone-pom >-------------------
    [INFO] Building Maven Stub Project (No POM) 1
    [INFO] --------------------------------[ pom ]---------------------------------
    [INFO]
    [INFO] >>> archetype:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
    [INFO]
    [INFO] <<< archetype:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
    [INFO]
    [INFO]
    [INFO] --- archetype:3.2.1:generate (default-cli) @ standalone-pom ---
    [INFO] Generating project in Batch mode
    [INFO] ----------------------------------------------------------------------------
    [INFO] Using following parameters for creating project from Archetype: maven-archetype-quickstart:1.4
    [INFO] ----------------------------------------------------------------------------
    [INFO] Parameter: groupId, Value: edu.grinnell.csc207
    [INFO] Parameter: artifactId, Value: my-project
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] Parameter: package, Value: edu.grinnell.csc207
    [INFO] Parameter: packageInPathFormat, Value: edu/grinnell/csc207
    [INFO] Parameter: package, Value: edu.grinnell.csc207
    [INFO] Parameter: groupId, Value: edu.grinnell.csc207
    [INFO] Parameter: artifactId, Value: my-project
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] Project created from Archetype in dir: /Users/rebelsky/CSC207/Projects/my-project
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  1.212 s
    [INFO] Finished at: 2024-08-27T12:56:12-05:00
    [INFO] ------------------------------------------------------------------------

If you don't want to see all of the `[INFO]` lines, you can add the `-q` (for "quiet") flag.

    mvn -q archetype:generate -DgroupId=edu.grinnell.csc207 -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

Are there other options to initializing your Maven project on the command line? Certainly.

If you're using an IDE, you can have your IDE do the setup for you.  In VSCode (which we'll be using), after opening the command palette and selecting "Java: Create Java Project...", you then select "Maven".

You can also copy and modify an existing Maven project. (You'll often do this in our class.)

### The directory structure

If you dig around a bit, you'll see that you've created a bunch of directories. (Yes, project management often means following some expectations for how things are arranged.)

* The `src` directory contains the source code. 
* Because of the wonders of Java, we end up putting the source code in `src/main/java/edu/grinnell/csc207/`. (Your IDE will often make navigating this directory structure easier.)
* The quickstart archetype creates the file `App.java` in that directory.
* There's a file called `pom.xml` which we'll discuss in the next section.

You will eventually end up with a folder called `target` that contains a variety of files that Maven builds.

### The `pom.xml` file

As we mentioned earlier, the `pom.xml` file contains information on the project. Here's the one created by the commands we've used above.

    <?xml version="1.0" encoding="UTF-8"?>
    
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
    
      <groupId>edu.grinnell.csc207</groupId>
      <artifactId>my-project</artifactId>
      <version>1.0-SNAPSHOT</version>
    
      <name>my-project</name>
      <!-- FIXME change it to the project's website -->
      <url>http://www.example.com</url>
    
      <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
      </properties>
    
      <dependencies>
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.11</version>
          <scope>test</scope>
        </dependency>
      </dependencies>
    
      <build>
        <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
          <plugins>
            <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
            <plugin>
              <artifactId>maven-clean-plugin</artifactId>
              <version>3.1.0</version>
            </plugin>
            <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
            <plugin>
              <artifactId>maven-resources-plugin</artifactId>
              <version>3.0.2</version>
            </plugin>
            <plugin>
              <artifactId>maven-compiler-plugin</artifactId>
              <version>3.8.0</version>
            </plugin>
            <plugin>
              <artifactId>maven-surefire-plugin</artifactId>
              <version>2.22.1</version>
            </plugin>
            <plugin>
              <artifactId>maven-jar-plugin</artifactId>
              <version>3.0.2</version>
            </plugin>
            <plugin>
              <artifactId>maven-install-plugin</artifactId>
              <version>2.5.2</version>
            </plugin>
            <plugin>
              <artifactId>maven-deploy-plugin</artifactId>
              <version>2.8.2</version>
            </plugin>
            <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
            <plugin>
              <artifactId>maven-site-plugin</artifactId>
              <version>3.7.1</version>
            </plugin>
            <plugin>
              <artifactId>maven-project-info-reports-plugin</artifactId>
              <version>3.0.0</version>
            </plugin>
          </plugins>
        </pluginManagement>
      </build>
    </project>

Isn't that exciting? And aren't you glad that you don't have to build that file by hand? As you might guess, the most important parts are the things at the top. We'll see what those are as we move forward.

Unfortunately, the default `pom.xml` is not necessarily what we'll need for the class. For example, you'll see that it's using Java 1.7. We'll generally be using Java 17, so you'll need to update that portion appropriately.

          <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <maven.compiler.source>17</maven.compiler.source>
            <maven.compiler.target>17</maven.compiler.target>
          </properties>
    
## Using Maven

Now that we've set up our Maven project, we can start exploring what we can do with Maven.

### tl;dr

Most of these commands will take a `-q` flag for "quiet". Some need additional updates to your `pom.xml` file.

Compiling

    mvn compile

Cleaning up after building

    mvn clean

Testing

    mvn test

Packaging

    mvn package

Running a pre-specified `main` method

    mvn exec:java

Syntax checking

    mvn checksyntax:check

### Compiling

One obvious step is to compile our code. We often compile the code in preparation for other activities. We might also compile the code to see if we have syntax errors in our program.

The instruction for compiling the code is fairly straightforward.

    mvn compile

Here's what happens when we compile the default project.

    $ mvn compile
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] -------------------< edu.grinnell.csc207:my-project >-------------------
    [INFO] Building my-project 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] 
    [INFO] --- resources:3.0.2:resources (default-resources) @ my-project ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/my-project/src/main/resources
    [INFO] 
    [INFO] --- compiler:3.8.0:compile (default-compile) @ my-project ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.329 s
    [INFO] Finished at: 2024-08-27T13:36:14-05:00
    [INFO] ------------------------------------------------------------------------

If we do it in quiet mode, it's even simpler.

    $ mvn compile -q
    $

That's right! There's no output.

But suppose we had an error in the code, such as a missing semicolon.

    $ mvn compile
    [INFO] Scanning for projects...
    [INFO]
    [INFO] -------------------< edu.grinnell.csc207:my-project >-------------------
    [INFO] Building my-project 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- resources:3.0.2:resources (default-resources) @ my-project ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/my-project/src/main/resources
    [INFO]
    [INFO] --- compiler:3.8.0:compile (default-compile) @ my-project ---
    [INFO] Changes detected - recompiling the module!
    [INFO] Compiling 1 source file to /Users/rebelsky/CSC207/Projects/my-project/target/classes
    [INFO] -------------------------------------------------------------
    [ERROR] COMPILATION ERROR :
    [INFO] -------------------------------------------------------------
    [ERROR] /Users/rebelsky/CSC207/Projects/my-project/src/main/java/edu/grinnell/csc207/App.java:[11,45] ';' expected
    [INFO] 1 error
    [INFO] -------------------------------------------------------------
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.400 s
    [INFO] Finished at: 2024-08-27T13:38:19-05:00
    [INFO] ------------------------------------------------------------------------
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.0:compile (default-compile) on project my-project: Compilation failure
    [ERROR] /Users/rebelsky/CSC207/Projects/my-project/src/main/java/edu/grinnell/csc207/App.java:[11,45] ';' expected
    [ERROR]
    [ERROR] -> [Help 1]
    [ERROR]
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR]
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

Let's try again with the `-q` flag.

    $ mvn compile -q
    [ERROR] COMPILATION ERROR : 
    [ERROR] /Users/rebelsky/CSC207/Projects/my-project/src/main/java/edu/grinnell/csc207/App.java:[11,45] ';' expected
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.0:compile (default-compile) on project my-project: Compilation failure
    [ERROR] /Users/rebelsky/CSC207/Projects/my-project/src/main/java/edu/grinnell/csc207/App.java:[11,45] ';' expected
    [ERROR] 
    [ERROR] -> [Help 1]
    [ERROR] 
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR] 
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

Okay, we still see the error (twice, it seems). And we also see some notes on getting additional information from Maven. We won't try those additional pieces of information.

If we correct that error (adding a semicolon at column 45 of line 11), we should go back to seeing no messages.

    $ mvn compile -q

Where do the compiled files go? In the aforementioned `target` directory.

    $ ls target
    classes                 generated-sources       maven-status
    $ ls target/classes
    edu
    $ ls target/classes/edu/grinnell/csc207/
    App.class

As you may have learned, we typically run Java classes in the parent directory of the package. In this case, that's `target/classes`.

    $ pushd target/classes
    $ java edu.grinnell.csc207.App
    Hello World!
    $ popd

### Cleaning up

Just as building projects in C leaves around a bunch of `.o` files, building projects in Java leaves around a bunch of `.class` files, as well as some other files. At some point, you might want to get rid of those files. With Maven, that's simple.

    mvn clean

### Testing

As you learned in CSC-151 and CSC-161, regular automated testing should be part of your development practice. Why automated? One reason is that you're more likely to run automated tests. Another is that the computer is better at comparing expected and actual outputs than you are.

We will explore the details of unit testing in JUnit 5 a bit later in the semester. For now, we'll see how it works in Maven.

In order to run tests in Maven, you need the appropriate instructions in your `pom.xml` file. The default instructions are as follows.

      <dependencies>
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.11</version>
          <scope>test</scope>
        </dependency>
      </dependencies>

As you can see, they references an old version of JUnit. You should update that as follows. (Don't worry, we have those instructions elsewhere, too.)

      <dependencies>
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-engine</artifactId>
          <version>5.9.1</version>
          <scope>test</scope>
        </dependency>
      </dependencies>

The command to run tests in Maven is simple.

    mvn test

A newly created repository has no tests, so you'll see very little of use when you run that command.

    $ mvn test
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ---------------------< edu.grinnell.csc207:sample >---------------------
    [INFO] Building sample 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] 
    [INFO] --- resources:3.3.1:resources (default-resources) @ sample ---
    [INFO] Copying 0 resource from src/main/resources to target/classes
    [INFO] 
    [INFO] --- compiler:3.11.0:compile (default-compile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] 
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ sample ---
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/sample/src/test/resources
    [INFO] 
    [INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] 
    [INFO] --- surefire:3.2.2:test (default-test) @ sample ---
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.304 s
    [INFO] Finished at: 2024-09-01T08:39:18-05:00
    [INFO] ------------------------------------------------------------------------

Wasn't that exciting? As you might expect, the quiet test is a bit less verbose.

    $ mvn test -q
    $

What if we had actual tests? Let's see ...

    $ mvn test
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ---------------------< edu.grinnell.csc207:sample >---------------------
    [INFO] Building sample 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] 
    [INFO] --- resources:3.3.1:resources (default-resources) @ sample ---
    [INFO] Copying 0 resource from src/main/resources to target/classes
    [INFO] 
    [INFO] --- compiler:3.11.0:compile (default-compile) @ sample ---
    [INFO] Changes detected - recompiling the module! :input tree
    [INFO] Compiling 2 source files with javac [debug target 17] to target/classes
    [WARNING] system modules path not set in conjunction with -source 17
    [INFO] 
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ sample ---
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/sample/src/test/resources
    [INFO] 
    [INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ sample ---
    [INFO] Changes detected - recompiling the module! :dependency
    [INFO] Compiling 1 source file with javac [debug target 17] to target/test-classes
    [WARNING] system modules path not set in conjunction with -source 17
    [INFO] 
    [INFO] --- surefire:3.2.2:test (default-test) @ sample ---
    [INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.pom (4.5 kB at 12 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.2/surefire-providers-3.2.2.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/3.2.2/surefire-providers-3.2.2.pom (2.5 kB at 110 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.pom (2.7 kB at 109 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.pom (3.0 kB at 126 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-engine/1.9.3/junit-platform-engine-1.9.3.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-engine/1.9.3/junit-platform-engine-1.9.3.pom (3.2 kB at 139 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-commons/1.9.3/junit-platform-commons-1.9.3.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-commons/1.9.3/junit-platform-commons-1.9.3.pom (2.8 kB at 118 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.jar
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit-platform/3.2.2/surefire-junit-platform-3.2.2.jar (27 kB at 803 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.jar
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.jar
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-engine/1.9.3/junit-platform-engine-1.9.3.jar
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-commons/1.9.3/junit-platform-commons-1.9.3.jar
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/common-java5/3.2.2/common-java5-3.2.2.jar (18 kB at 650 kB/s)
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-engine/1.9.3/junit-platform-engine-1.9.3.jar (189 kB at 475 kB/s)
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.jar (169 kB at 418 kB/s)
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-commons/1.9.3/junit-platform-commons-1.9.3.jar (103 kB at 170 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.1/junit-platform-launcher-1.9.1.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.1/junit-platform-launcher-1.9.1.pom (3.0 kB at 112 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.1/junit-platform-launcher-1.9.1.jar
    Downloaded from central: https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-launcher/1.9.1/junit-platform-launcher-1.9.1.jar (169 kB at 627 kB/s)
    [INFO] 
    [INFO] -------------------------------------------------------
    [INFO]  T E S T S
    [INFO] -------------------------------------------------------
    [INFO] Running edu.grinnell.csc207.C2FTests
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.016 s -- in edu.grinnell.csc207.C2FTests
    [INFO] 
    [INFO] Results:
    [INFO] 
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
    [INFO] 
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  2.548 s
    [INFO] Finished at: 2024-09-01T09:10:05-05:00
    [INFO] ------------------------------------------------------------------------
    
As you may have noticed, Maven realized that we didn't have all the JUnit 5 resources installed and installed them for us. We also saw that the tests worked successfully.

What happens if we test and some of the tests fail? Let's see. 

    [INFO] Scanning for projects...
    [INFO]
    [INFO] ---------------------< edu.grinnell.csc207:sample >---------------------
    [INFO] Building sample 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- resources:3.3.1:resources (default-resources) @ sample ---
    [INFO] Copying 0 resource from src/main/resources to target/classes
    [INFO]
    [INFO] --- compiler:3.11.0:compile (default-compile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO]
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ sample ---
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/sample/src/test/resources
    [INFO]
    [INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO]
    [INFO] --- surefire:3.2.2:test (default-test) @ sample ---
    [INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
    [INFO]
    [INFO] -------------------------------------------------------
    [INFO]  T E S T S
    [INFO] -------------------------------------------------------
    [INFO] Running edu.grinnell.csc207.FailingTests
    [ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.018 s <<< FAILURE! -- in edu.grinnell.csc207.FailingTests
    [ERROR] edu.grinnell.csc207.FailingTests.justFail -- Time elapsed: 0.007 s <<< FAILURE!
    org.opentest4j.AssertionFailedError
    	at org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:34)
    	at org.junit.jupiter.api.Assertions.fail(Assertions.java:116)
    	at edu.grinnell.csc207.FailingTests.justFail(FailingTests.java:25)
    	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
    	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
            ...
    	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
    	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)
    
    [ERROR] edu.grinnell.csc207.FailingTests.notReallyEqual -- Time elapsed: 0.001 s <<< FAILURE!
    org.opentest4j.AssertionFailedError: One equals two ==> expected: <1> but was: <2>
    	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
    	at org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
    	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
    	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:150)
    	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:560)
    	at edu.grinnell.csc207.FailingTests.notReallyEqual(FailingTests.java:17)
    	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
            ...
    	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)
    
    [INFO] Running edu.grinnell.csc207.C2FTests
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 s -- in edu.grinnell.csc207.C2FTests
    [INFO]
    [INFO] Results:
    [INFO]
    [ERROR] Failures:
    [ERROR]   FailingTests.justFail:25
    [ERROR]   FailingTests.notReallyEqual:17 One equals two ==> expected: <1> but was: <2>
    [INFO]
    [ERROR] Tests run: 4, Failures: 2, Errors: 0, Skipped: 0
    [INFO]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.589 s
    [INFO] Finished at: 2024-09-01T09:30:11-05:00
    [INFO] ------------------------------------------------------------------------
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project sample: There are test failures.
    [ERROR]
    [ERROR] Please refer to /Users/rebelsky/CSC207/Projects/sample/target/surefire-reports for the individual test results.
    [ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
    [ERROR] -> [Help 1]
    [ERROR]
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR]
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

Once again, we get much more information than we can use. The most important ones are those that start with `[ERROR]`, particularly these.

    [ERROR] Failures:
    [ERROR]   FailingTests.justFail:25
    [ERROR]   FailingTests.notReallyEqual:17 One equals two ==> expected: <1> but was: <2>
    [ERROR] Tests run: 4, Failures: 2, Errors: 0, Skipped: 0

### Packaging

Most frequently, the end result of a Java project is having everything packaged together into a `.jar` (Java Archive) file. `.jar` files can serve as libraries for other programs or even as pseudo-executables. We package projects with the 

    mvn package

command.

    $ mvn package
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ---------------------< edu.grinnell.csc207:sample >---------------------
    [INFO] Building sample 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] 
    [INFO] --- resources:3.3.1:resources (default-resources) @ sample ---
    [INFO] Copying 0 resource from src/main/resources to target/classes
    [INFO] 
    [INFO] --- compiler:3.11.0:compile (default-compile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] 
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ sample ---
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/sample/src/test/resources
    [INFO] 
    [INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] 
    [INFO] --- surefire:3.2.2:test (default-test) @ sample ---
    [INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
    [INFO] 
    [INFO] -------------------------------------------------------
    [INFO]  T E S T S
    [INFO] -------------------------------------------------------
    [INFO] Running edu.grinnell.csc207.C2FTests
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.020 s -- in edu.grinnell.csc207.C2FTests
    [INFO] 
    [INFO] Results:
    [INFO] 
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
    [INFO] 
    [INFO] 
    [INFO] --- jar:3.3.0:jar (default-jar) @ sample ---
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.714 s
    [INFO] Finished at: 2024-09-01T10:32:25-05:00
    [INFO] ------------------------------------------------------------------------

As the output suggests, the request to package a project automatically runs all the tests. That way, if any tests fail, it refuses to build the project. Here's the output you get with a failing test.

    $ mvn package
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ---------------------< edu.grinnell.csc207:sample >---------------------
    [INFO] Building sample 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] 
    [INFO] --- resources:3.3.1:resources (default-resources) @ sample ---
    [INFO] Copying 0 resource from src/main/resources to target/classes
    [INFO] 
    [INFO] --- compiler:3.11.0:compile (default-compile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] 
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ sample ---
    [INFO] skip non existing resourceDirectory /Users/rebelsky/CSC207/Projects/sample/src/test/resources
    [INFO] 
    [INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ sample ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO] 
    [INFO] --- surefire:3.2.2:test (default-test) @ sample ---
    [INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
    [INFO] 
    [INFO] -------------------------------------------------------
    [INFO]  T E S T S
    [INFO] -------------------------------------------------------
    [INFO] Running edu.grinnell.csc207.FailingTests
    [ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.020 s <<< FAILURE! -- in edu.grinnell.csc207.FailingTests
    [ERROR] edu.grinnell.csc207.FailingTests.notReallyEqual -- Time elapsed: 0.010 s <<< FAILURE!
    org.opentest4j.AssertionFailedError: One equals two ==> expected: <1> but was: <2>
    	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
    ...
    	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)
    
    [INFO] Running edu.grinnell.csc207.C2FTests
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.003 s -- in edu.grinnell.csc207.C2FTests
    [INFO] 
    [INFO] Results:
    [INFO] 
    [ERROR] Failures: 
    [ERROR]   FailingTests.notReallyEqual:17 One equals two ==> expected: <1> but was: <2>
    [INFO] 
    [ERROR] Tests run: 3, Failures: 1, Errors: 0, Skipped: 0
    [INFO] 
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.773 s
    [INFO] Finished at: 2024-09-01T10:34:24-05:00
    [INFO] ------------------------------------------------------------------------
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project sample: There are test failures.
    [ERROR] 
    [ERROR] Please refer to /Users/rebelsky/CSC207/Projects/sample/target/surefire-reports for the individual test results.
    [ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
    [ERROR] -> [Help 1]
    [ERROR] 
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR] 
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

If you know the name of a class with a `main` method in the project, you can run it from the jar file. (Note that we added the `Alternate.java` class in the following example.)

    $ java -cp target/my-project-1.0-SNAPSHOT.jar edu.grinnell.csc207.App
    Hello World!
    $ java -cp target/my-project-1.0-SNAPSHOT.jar edu.grinnell.csc207.Alternate
    Hello Alternate World!

You can also make the jar runnable by specifying a main class in the `pom.xml` file. In your plugins section, add the following.

          <plugin>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.0.2</version>
            <configuration>
              <archive>
                <manifest>
                  <addClasspath>true</addClasspath>
                  <mainClass>edu.grinnell.csc207.App</mainClass>
                </manifest>
              </archive>
            </configuration>
          </plugin>

If you don't have a plugins section, it looks something like this.

      <build>
        <pluginManagement>
          <plugins>
          ...
          </plugins>
        </pluginmanagement>
      </build>

Once you've added the plugin information, we can build and run our project.

    $ mvn package -q
    $ java -jar target/my-project-1.0-SNAPSHOT.jar
    Hello World!

### Another way to run programs

Maven also provides an alternate way to run code using the target `exec:java`. To use that mechanism, you must add plugin information for that.

            <plugin>
              <groupId>org.codehaus.mojo</groupId>
              <artifactId>exec-maven-plugin</artifactId>
              <version>3.3.0</version>
              <configuration>
                <mainClass>edu.grinnell.csc207.App</mainClass>
              </configuration>
            </plugin>

Now we can run the program.

    $ mvn -q exec:java
    Hello World!

### Checking style

In this class, I expect you to follow something fairly close to [the Google Java Style Guide](https://google.github.io/styleguide/javaguide.html). That means you will benefit from the option of having Maven check your style. 

Once again, we need to add code to the `pom.xml` file.

            <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-checkstyle-plugin</artifactId>
              <version>3.4.0</version>
              <configuration>
                <configLocation>csc207-checks.xml</configLocation>
              </configuration>
            </plugin>

Those instructions reference [`csc-207-checks.xml`](../files/csc207-checks.xml), so you'll need to download that file, too.

Once you've done so, you should be able to use the following command to check the style in your file.

    mvn checkstyle:check

Unfortunately, the sample `App.java` file uses very different style guidlines, so we will see a lot of errors.

    $ !mvn
    mvn checkstyle:check
    [INFO] Scanning for projects...
    [INFO]
    [INFO] -------------------< edu.grinnell.csc207:my-project >-------------------
    [INFO] Building my-project 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- checkstyle:3.4.0:check (default-cli) @ my-project ---
    [INFO] There are 14 errors reported by Checkstyle 9.3 with csc207-checks.xml ruleset.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[7] (regexp) RegexpSingleline: Line has trailing spaces.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[8,1] (indentation) Indentation: 'class def lcurly' has incorrect indentation level 0, expected level should be 2.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[8,1] (blocks) LeftCurly: '{' at column 1 should be on the previous line.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[9,5] (javadoc) MissingJavadocMethod: Missing a Javadoc comment.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[9,28] (whitespace) ParenPad: '(' is followed by whitespace.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[9,44] (whitespace) ParenPad: ')' is preceded with whitespace.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[10,5] (blocks) LeftCurly: '{' at column 5 should be on the previous line.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[11] (regexp) Regexp: Line matches the illegal pattern 'System.out.println'.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[11,9] (indentation) Indentation: 'method def' child has incorrect indentation level 8, expected level should be 6.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[11,27] (whitespace) ParenPad: '(' is followed by whitespace.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[11,44] (whitespace) ParenPad: ')' is preceded with whitespace.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[12] (regexp) Regexp: Line matches the illegal pattern 'end brace without comment'.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[13] (regexp) Regexp: Line matches the illegal pattern 'end brace without comment'.
    [ERROR] src/main/java/edu/grinnell/csc207/App.java:[13,1] (indentation) Indentation: 'class def rcurly' has incorrect indentation level 0, expected level should be 2.
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.724 s
    [INFO] Finished at: 2024-09-01T12:55:02-05:00
    [INFO] ------------------------------------------------------------------------
    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-checkstyle-plugin:3.4.0:check (default-cli) on project my-project: You have 14 Checkstyle violations. -> [Help 1]
    [ERROR]
    [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
    [ERROR] Re-run Maven using the -X switch to enable full debug logging.
    [ERROR]
    [ERROR] For more information about the errors and possible solutions, please read the following articles:
    [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

Isn't that sad? Here's the supplied `App.java`.

    package edu.grinnell.csc207;
    
    /**
     * Hello world!
     *
     */
    public class App
    {
        public static void main( String[] args )
        {
            System.out.println( "Hello World!" );
        }
    }

Here's what it should look like.

    package edu.grinnell.csc207;
    
    import java.io.PrintWriter;
    
    /**
     * Hello world!
     */
    public class App {
      /**
       * Print a message.
       *
       * @param args
       *  The command-line arguments.
       */
      public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        pen.println("Hello World!");
        pen.close();
      } // main(String[])
    } // class App

And here's what our output looks like after we make those changes.

    $ mvn checkstyle:check
    [INFO] Scanning for projects...
    [INFO]
    [INFO] -------------------< edu.grinnell.csc207:my-project >-------------------
    [INFO] Building my-project 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- checkstyle:3.4.0:check (default-cli) @ my-project ---
    [INFO] You have 0 Checkstyle violations.
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  0.642 s
    [INFO] Finished at: 2024-09-01T12:58:32-05:00
    [INFO] ------------------------------------------------------------------------

Note that not all of these changes are required by the Google Java Style Guide. For example, I'm the one who requires that you avoid `System.out.println`. I'm also the one who wants you to comment your closing brackets. But those are both good habits to get into.


## Wrapping up

That's likely all you need to know about Maven right now. As I noted at the beginning, most of the time, we'll provide you with a premade Maven file. The [project setup instructions](..handouts/project-setup) also help you set up that file.

You should remember that

* You use Maven on the command line, typically with `mvn COMMAND`.
* You set up a new Maven project with `mvn archetype:generate`.
* The most important commands are `compile`, `clean`, `test`, `package`, `exec:java`, and `checksyntax:check`.
* You can add a `-q` flag for "quiet" to eliminate much of the output from Maven.
* The way these commands behave is governed by a file called `pom.xml`, which is semi-human-readable. You will often extend your `pom.xml` by adding and modifying chunks of XML.
  
