Feature: Is it Friday yet?
  Every body want to know when it's Friday

  Scenario Outline: Sunday is not Friday
      Given today is <day>
      When I ask whether it's Friday yet
      Then I should be told <answer>

  Examples:
        | day              | answer |
        | "Friday"         | "TGIF" |
        | "Sunday"         | "Nope" |
        | "anything else!" | "Nope" |
