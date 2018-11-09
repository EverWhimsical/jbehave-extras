
Scenario: S1

Meta:
@Scenario1

Given I Open Home Page
When I click header 1
When I click header 2
Then I verify header 1
Then I verify header 2
Then I print <symbol>

Examples:
|Meta:|symbol|
|@IT R1|STK1|