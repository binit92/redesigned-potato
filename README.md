# redesigned-potato
Risk Game - SOEN 6441 Team11 project, winter 2021
(Nilesh, Ritika, Satinder, Gurseerut, Binit )

> Feel free to make changes in the repo, no-pressure as we can always revert the code if something goes wrong.

### Open Tasks :rocket:
+ [Binit] : Read and parse map files
+ [Unassigned] : code to take **number of players** and **map path** as input
+ [Unassigned] : Junit test class to verify maps
+ [Unassigned] : round-robin algorithm to select players
+ [Unassigned] : how players will automatically make Orders
+ [Unassigned] : Action (Advance, reinforce etc) on maps files based on orders, what makes an order invalid
+ [Unassigned] : Rules to conquer a territory (60% attack, 70% defense etc)
+ [Unassigned] : Cards
+ [Unassigned] : Model view Controller
+ [Binit] : observer design pattern
+ [Binit] : strategy design pattern


(we will update this list as the requirement comes and as we complete things)

### Completed Tasks :checkered_flag:
+ [Binit] : (sandbox/MapReader/../Util.java) helper class to print the logs of the project using static methods. We will use this common class to print all logs of the project into `risk.log` file


### How to download Git and use it
1. Installing Git https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
2. Alternatively, download Anaconda to automatically install Git
3. Free Git Course : https://www.udacity.com/course/version-control-with-git--ud123
4. [Optional] Git Internals: https://vimeo.com/14629850
5. How to write commit messages: https://udacity.github.io/git-styleguide
6. How to use Markdown (Basic Syntax): https://www.markdownguide.org/basic-syntax/

### How to clone and contribute on this project using command-line:
 1. command to clone `git clone https://github.com/binit92/redesigned-potato.git`
 2. once repo is downloaded locally .. make changes as required
 3. `git log` - to the see the history of changes
 4. `git status ` - to see what are the files changed locally
 5. `git add .` or `git add <filename>`  - to add all the changed files or specific files to local staging
 6. `git reset` to remove the changed files from local staging
 7. `git commit - m "fix : <description of fix>" ` - to commit changes locally
 style guide on how to write commit message -  https://udacity.github.io/git-styleguide
 8.  see this link (https://github.com/binit92/redesigned-potato.git) on best practices on writing commit messages
 9. `git push`  - to push this to the master branch.
 (we can keep it simple and submit directly to the master branch (instead of create child branch), there could be two people making changes parallely in a file, then we have to merge it.)

### Extreme Programming Paradigms:
 1. Build Plan: <br>
  - Make a build plan that determines what will be the goals of each successive builds <br>
  - As each build starts, make a detailed plan. <br>
  
 2. Small Releases: <br>
  - Three different builds <br>
  - 3 weeks to deliver the build <br>
 
 3. System Methaphor: <br>
  - It is a "story" about the system. <br>
  - The initial project desc is the system metaphor. <br>
 
 4. Simple Design: <br>
  - Use simple designs for development. <br>
  - Every time a solution is proposed, it should be debated as to whether it is the simplest solution that can meet the required features. <br>
  - Overly complex designs should be avoided as a team principle. <br>
 
 5. Testing: <br>
  - Unit tests must be delivered with each build. <br>
  - Tests for individual sub-systems has to be created and tested. <br>
 
 6. Refactoring: <br>
  - After each build is delivered, have a meeting and decide what parts need to be cleaned up before development continues on the next build. <br>
  - Make sure that test run successfully before and after each individual refactoring operation. <br>
 
 7. Pair Programming: <br>
  - Work in pairs and make sure both individuals know their responsibilities as part of the pair. <br>
 
 8. Collective Ownership: <br>
  - Setup a software repository and enforce that it is used as frequently as possible. <br>
 
 9. Continuous Integration: <br>
  - Enforce the practice of frequent commits. <br>
  - Activate a continuous integration framework on the repository, e.g. to enforce that any code committed actually compiles and passes all tests. <br>
  - It is done so that everbody is working on the same code base. <br>
  - Use CI tool in GitHub, it allows us to run certain tests during pushing a commit. <br>
  
 10. Sustainable Pace: <br>
  - Distribute work evenly across people and over time. <br>
  - Implement practices that ensure efficient usage of time. <br>
 
 11. On-Site Customer: <br>
  - Discuss the project features during lectures. <br>
  - Contact instructor any time for clarifications. <br>
 
 12. Coding Standards: <br>
  - Use a predefined set of coding conventions. <br>
  - Keep focused on a simple, reduced set of conventions. <br>
  - These standards will be checked by marker/instructor against the standard used for writing the actual code. <br>
  - Use a documentation generation software (e.g. Javadoc, DOxygen etc).

### How to use IntellijIdea and submit directly from there:
 1. Download IntellijIdea Community Edition from:
 https://www.jetbrains.com/idea/download/#section=windows
 2. TODO: add steps here on how to add file in Git from inside IntellijIdea
