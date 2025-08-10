Feature: Single browser instance with multiple roles

  Background:
    Given I load env configuration

  @smoke
  Scenario: Switch roles within one browser
    When I switch to role Approver
    Then the title should contain "Example"
    When I switch to role Admin
    Then the title should contain "Example"
