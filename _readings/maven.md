---
title: Build systems and Maven
summary: |
  We consider a bit about command-line build systems and explore some
  details of one such system, Maven.
---
_Warning! This reading is not yet complete. Check back later!_

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

## Using Maven

Now that we've set up our Maven project, we can start exploring what we can do with Maven.

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

Where do the compiled files go? In the aftorementioned `target directory.

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

### Testing

### Cleaning up
