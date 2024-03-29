# Triggerise Checkout

## Candidate Information

Akshar Bhagwandin

Java Developer

aksharbhagwandin@gmail.com

## Setup

- Clone the project
- Run ```CheckoutAppTest.java```

## Dependencies/Environment

- Java 11
- JUnit 4
- I used IntelliJ to develop the solution
- You may need to add Junit your classpath in order for the tests to work

## Approach

I approached this assessment by first understanding what the requirements are and then designing a rough structure on what solution will work to solve it.  I spent roughly 4 - 5 hours on this broken up over 2 days. 3 hours on day 1 and 1.5 hours on day 2.  My initial solution worked but it lacked the loose coupling which made it difficult to add extra offers and products.  I refactored the solution to incorporate 2 design patterns, namely Strategy and the Builder pattern.

The solution allows the developer to easily add more discount offers and product based offers.

There was no hard requirement for a UI so I followed the TDD approach and wrote tests first in order to cover the given requirements as well as tests to show other scenarios.  

You can view the image called test-success.png in this folder to see a screenshot of the tests passing.

Your feedback, good and bad, will be appreciated.
