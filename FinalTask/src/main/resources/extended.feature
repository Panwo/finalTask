Feature: Extended
 As I user
  I want to test important but not critical elements
 So that I can be sure that I can receive support, leave a review and check search history

  Scenario Outline: support
    Given User opens '<homePage>' page
    And User clicks Sign In button
    And User enters valid '<username>' and click next
    And User enters valid '<password>' and clicks next
    And User clicks Customer service link
    And User sees nine categories within the page body and text : We’re here to help, '<name>'
    And User sees help library search area

    Examples:
      | homePage               | username                      | password    | name |
      | https://www.amazon.com | dmitriybeletskiy423@gmail.com | tester12345 | Dima |


  Scenario Outline: verify reviews section
    Given User opens '<homePage>' page
    And User enters '<product>' in the search box
    And User clicks search icon
    And User sets customer reviews filter to 4 stars and up
    And User click in the image of the first result in the search list result page
    And Product page appears, review section is not empty
    Examples:
      | homePage               | product |
      | https://www.amazon.com | java    |


  Scenario Outline: search history
    Given User opens '<homePage>' page
    And User clicks Sign In button
    And User enters valid '<username>' and click next
    And User enters valid '<password>' and clicks next
    And User enters '<product1>' in the search box
    And User clicks search icon
    And User click in the image of the first result in the search list result page
    And User enters '<product2>' in the search box
    And User clicks search icon
    And User click in the image of the first result in the search list result page
    And User clicks  Browsing history link
    And Users is able to see two products

    Examples:
      | homePage               | username                      | password    | product1 | product2   |
      | https://www.amazon.com | dmitriybeletskiy423@gmail.com | tester12345 | java     | javascript |

