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

### How to use IntellijIdea and submit directly from there:
 1. Download IntellijIdea Community Edition from:
 https://www.jetbrains.com/idea/download/#section=windows
 2. TODO: add steps here on how to add file in Git from inside IntellijIdea
