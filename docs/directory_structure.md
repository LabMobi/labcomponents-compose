# Directory structure

Overview of how project directories are structured. 

## Project structure

The project uses Kotlin as the main language. See https://kotlinlang.org/docs/reference/ for more information about Kotlin.

`Ktlint` is added to the project to keep code style and formatting uniform. Ktlint is run with regular lint checks during a build (specifically `gradle check` command). For more information about Ktlint, see https://github.com/shyiko/ktlint

We have different modules for different parts of the application:
* app-demo -> Component catalog
* lib -> Lab Design library
