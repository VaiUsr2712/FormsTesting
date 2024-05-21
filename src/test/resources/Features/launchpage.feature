Feature: Launch Application form page


@Smoke1
  Scenario: Verify user is able to launch the application form page
    Given User is able to open the browser
    And User Enters Name "SaiVai"
    And User Enters Email "vaishuv818@gmail.com"


  @Smoke2
  Scenario Outline: Verify user is able to launch the application form page
    Given User is able to open the browser
    And User Enters Name "<Username>"
    Examples:
      | Username  |
      | Sai       |
      | Vaishnavi |



  @Smoke3
  Scenario: Verify user is able to launch the application form page
    Given User is able to open the browser
    And Enter the details
      | Name | Email                |
      | Sai  | vaishuv818@gmail.com |

  @Smoke4
  Scenario: Verify user is able to add data from excel
    Given User is able to open the browser
    And Get values from the excel

  @Smoke4
  Scenario Outline: Verify user is able to add data from excel
    Given User is able to open the browser
    And Get values from the excel "<SheetName>" and <Rownumber>
    Examples:
      | SheetName   | Rownumber |
      | UserDetails | 1         |







