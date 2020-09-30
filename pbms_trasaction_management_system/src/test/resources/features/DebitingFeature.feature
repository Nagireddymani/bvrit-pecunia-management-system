Feature: Debit Feature Of Transaction


Scenario: Whenan Employee enters all the details, Without mistakes 
          of a cheque form then amount is debited from the account successfully
    Given Employee is in Debit Using Cheque Form Page
    When Employee Enters Form Details and Click Submit
    Then Amount is Debited From the Account 