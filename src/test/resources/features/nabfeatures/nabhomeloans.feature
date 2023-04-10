Feature: NAB Home Loans

  @homeloanenquiry
  Scenario Outline: Home loan enquiry form
    Given I am in nab home page
    #When I navigate to home loan page
    #And I navigate to home loan topic page
    #And I navigate to home loan enquiry page
    #And I submit new home loan enquiry details <firstname> <lastname> <phonenumber> <email>
    #Then I validate the confirmation message
    Examples: 
      | firstname  | lastname  | phonenumber  | email  |
      | John       | Doe       | 0412345678   | test@test.com|