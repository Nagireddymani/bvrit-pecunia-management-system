$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CreditingFeature.feature");
formatter.feature({
  "name": "Credit Feature Of Transaction",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Whenan Employee enters all the details, Without mistakes",
  "description": "          of a cheque form then amount is Credited from FromAccount and Debited to ToAccountNumber\n          mentioned in Form successfully",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Employee is in Credit Using Cheque Form Page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.capg.pbms.stepdefination.CreditUsingChequeSteps.employee_is_in_Credit_Using_Cheque_Form_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Employee Enters Cheque Form Details and Click Submit",
  "keyword": "When "
});
formatter.match({
  "location": "com.capg.pbms.stepdefination.CreditUsingChequeSteps.employee_Enters_Cheque_Form_Details_and_Click_Submit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Amount is Credited From the FromAccountNumber to ToAccountNumber",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.pbms.stepdefination.CreditUsingChequeSteps.amount_is_Credited_From_the_FromAccountNumber_to_ToAccountNumber()"
});
formatter.result({
  "status": "passed"
});
});