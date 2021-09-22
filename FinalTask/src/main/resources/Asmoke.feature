Feature: Smoke
  As a user
  I want to test site main functionality
  So that I can be sure that I can search and by products

  Scenario Outline: Check site components and critical elements presence
    Given User opens '<homePage>' page
    And User checks header and header critical elements visibility
    And User scrolls down
    And User waits for login button visibility
    And User checks body and body critical elements number <criticalElementsNumber>
    And User check main content visibility
    And User checks footer and footer critical elements visibility
    And User validates login button presence and link accuracy

    Examples:
      | homePage               | criticalElementsNumber |
      | https://www.amazon.com | 21                     |


  Scenario Outline: Check login form
    Given User opens '<homePage>' page
    And User clicks Sign In button
    And User clicks Create Amazon account button
    And Page '<newAccountPageURL>' page appears with all required fields
    And User navigates back to the login page
    And User enters valid '<username>' and click next
    And User clicks on the Forgot Password link
    And Forgot password '<forgotPassword>' page with Email/Phone textarea field appears.
    And User clicks navigates back, confirms form re-submitting
    And User enters valid '<password>' and clicks next
    And User finds '<username>' visible in Account menu


    Examples:
      | homePage               | newAccountPageURL                   | forgotPassword                           | username                      | password    |
      | https://www.amazon.com | https://www.amazon.com/ap/register? | https://www.amazon.com/ap/forgotpassword | dmitriybeletskiy423@gmail.com | tester12345 |


  Scenario Outline: Search box test with different input
    Given User opens '<homePage>' page
    And User enters '<product>' in the search area
    And User clicks search icon
    And search result page appears with at least <numberOfElements> of searched elements
    And User clicks back, '<homepage>' appears
    And User types single '<character>' in the search box
    And A list of product appears with suggestions starting with the entered character
    And User enters <InvalidNumber> of "a" letters from 5000 to 10000
    And search results page appears along with error message
    And User opens '<homePage>' page
    And user enters <ValidNumber> of "a" letters from 1 to 600
    And search result page appears without error message

    Examples:
      | homePage               | product | numberOfElements | character | InvalidNumber | ValidNumber |
      | https://www.amazon.com | herbal  | 7                | d         | 9000          | 200         |

  Scenario Outline: Login, search for a product insert the correct user , and add the item successfully to the wish list
    Given  User opens '<homePage>' page
    And User clicks Sign In button
    And User enters valid '<username>' and click next
    And User enters valid '<password>' and clicks next
    And User expands categories within search field, selecting the <CategoryNumber>
    And User enters '<product>' in the search area
    And User clicks search icon
    And User click in the image of the first result in the search list result page
    And User clicks Add to List button in the item page
    And User clicks View Your List button  in the Add to List page
    Then My wish list, should be populated with the '<product>' item

    Examples:
      | homePage               | username                      | password    | CategoryNumber | product   |
      | https://www.amazon.com | dmitriybeletskiy423@gmail.com | tester12345 | 9              | iphone 12 |

  Scenario Outline: User is able to select the quantity and add to cart
    Given User opens '<homePage>' page
    And User enters '<product>' in the search box
    And User clicks search icon
    And User click in the image of the first result in the search list result page
    And User selects the product quantity as '<number>' in a range from 2 to 30
    And User clicks add to cart on the page on product details page
    And Products are added to the cart


    Examples:
      | homePage               | product | number |
      | https://www.amazon.com | java    | 2      |


  Scenario Outline: User is unable to sort search result by price
    Given User opens '<homePage>' page
    And User enters '<product>' in the search box
    And User clicks search icon
    And User expands sortBy selector
    And User selects high to low
    And Search result page displays descending price result, check at least <number> of results

    Examples:
      | homePage               | product | number |
      | https://www.amazon.com | java    | 10     |


  Scenario Outline: User can add new shipping address
    Given User opens '<homePage>' page
    And User clicks Sign In button
    And User enters valid '<username>' and click next
    And User enters valid '<password>' and clicks next
    And User clicks Deliver to icon
    And User clicks Manage address book link
    And User clicks add address
    And User fills valid '<phoneNumber>' phone number
    And User fills valid '<Address>' address
    And User fills valid '<city>' city
    And User selects corresponding '<state>'
    And User fills corresponding '<zipCode>'
    And User clicks add address form button
    And New '<Address>' appears in the addresses list


    Examples:
      | homePage               | username                      | password    | phoneNumber   | Address          | city       | state        | zipCode |
      | https://www.amazon.com | dmitriybeletskiy423@gmail.com | tester12345 | +380939387585 | 1421 Monterey St | Pittsburgh | Pennsylvania | 15212   |





