# DIP Refactor

## Problem
The `BirthdayGreeter` class directly created an `EmailSender` instance, violating the **Dependency Inversion Principle (DIP)**. High-level modules should depend on abstractions, not concrete classes.

## Solution
1. Added a `GreetingSender` interface as an abstraction.
2. `EmailSender` now implements `GreetingSender`.
3. `BirthdayGreeter` receives a `GreetingSender` via constructor injection.
4. Optional convenience constructor allows default `EmailSender` for simplicity.