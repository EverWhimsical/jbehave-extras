
Scenario: Verify login screen buttons and labels. Fetch details from database

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


Scenario: S2

Meta:
@Scenario2

Given I Open Home Page
When I click header 1
When I click header 2
Then I verify header 1
Then I verify header 2
Then I print <symbol>


Examples:
|Meta:|symbol|
|@IT R1|STK2|
|@IT R2|STK3|


Scenario: Scenario3

Meta:
@Scenario3

Given I Open Home Page

Examples:
|Meta:|symbol|
|@IT R1|STK4|
|@IT R2|STK5|
|@IT R3|STK6|