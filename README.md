# xconfig 

###### *a universal configuration standard*

## Contents

This repository contains the specification for the `xconfig` standard, located in the [spec folder](spec/README.md).

If you are looking for an example implementation, please refer to the [example repository](https://github.com/stardust-enterprises/xconfig-example-impl).

## What is xconfig?

`xconfig`, `crossconfig`, or `xcfg4j` is a universal configuration standard for the [JVM] and [JVM]-based programming languages. 
It is designed to be simple yet expandable, easy to use, and easy to implement.

## How does it work?

`xconfig` is divided into three moving parts:
- The [**frontend**](frontend/README.md)
  - A **user**-intractable part that allows for configuration modification
  - Examples:
    - A command-line interface
    - A graphical interface
    - A text editor
<br><br>
- The [**backend**](backend/README.md)
  - A **programmatic** interface that specifies I/O operations and configuration storage
  - Examples:
    - A file-based backend (using a file format such as JSON, YAML, XML, etc...)
    - A database-based backend (using a database such as MySQL, MangoDB, etc...)
<br><br>
- The [**middle-end**](middle-end/README.md)
  - A **programmer chosen** approach to configuration declaration and validation
  - Examples:
    - A functional declaration 
    - An annotation-based configuration declaration
    - A Kotlin DSL-based configuration declaration
    - A Scala macros-based configuration declaration

Philosophically speaking, each part should be different and interchangeable by the user, allowing for a wide range of
configuration styles and approaches. 

However, in practice, a frontend could (and/or would) also bundle its own backend 
for simplicity's sake, since the part that developers would be interacting more often
(therefore would differ more) would be the middle-end.

## Why should I use it?

you shouldn't, it's not finished lmao

## License

This project is licensed under the [LGPLv3 License](LICENSE).

<!-- Links -->
[JVM]: https://en.wikipedia.org/wiki/Java_virtual_machine
