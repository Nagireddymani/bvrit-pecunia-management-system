Feature: Credit Feature Of Transaction


Scenario: Whenan Employee enters all the details, Without mistakes 
          of a cheque form then amount is Credited from FromAccount and Debited to ToAccountNumber
          mentioned in Form successfully
    Given Employee is in Credit Using Cheque Form Page
    When Employee Enters Cheque Form Details and Click Submit
    Then Amount is Credited From the FromAccountNumber to ToAccountNumber 