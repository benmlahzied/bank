[![Build Status](https://app.travis-ci.com/benmlahzied/bank.svg?token=F9f8Qodqv9Nqg1yXHo4P&branch=main)](https://app.travis-ci.com/github/benmlahzied/badges)

# User stories
* US 1: In order to save money As a bank client I want to make a deposit in my account
* US 2: In order to retrieve some or all of my savings  As a bank client I want to make a withdrawal from my account
* US 3: In order to check my operations  As a bank client I want to see the history (operation, date, amount, balance)
  of my operations

# Some clarifications about some choices
* I chose not to use a Framework or a plugin because I think that it's not the goal of this Kata
* Git commits were created in order to demonstrate the use of the Red/Green/Refactor process.
  <br/> In real life I produce fewer commits while respecting git best practices such as small commits, complete and well tested code in each commit, good commit messages ...
* Some commits contain both Green and refactor steps when the solution is quite obvious
* Account is not an anemic object containing behavior.
    * According to Martin Fowler, Anemic Domain Model is an anti-pattern.
    * I can produce another version with a 'classic' anemic Account object and a 'classic' AccountService containing behavior if required.

# Some thoughts
* TDD benefits
    * requirement verification
    * early regression catching
    * lower maintenance
    * developer confidence
    * avoid over engineering
* TDD is not a Silver Bullet
    * we can have holes in tests
    * TDD is not sufficient by itself
        * deployment verification needed
        * network changes can happen
        * integration issues can happen (partner service changes...)
* In real life applications, we should have Unit, Integration and Acceptance tests with respect to test pyramid.
