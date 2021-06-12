Feature: Create Lead Functionality TC 

Background: 
	Given Open the chrome browser 
	And Load the application URL as 'http://leaftaps.com/opentaps/control/main' 
	And Enter the User Name as 'Demosalesmanager' 
	And Enter the Password as 'crmsfa' 
	And Click the Login Button 
	And Click CRM Link 
	And Click Leads 
	And Click Create Leads 
	
Scenario Outline: TC001_To Verify Lead is Created 
	Given Enter Company Name <company> 
	And Enter first Name <firstname> 
	And Enter last Name <lastname> 
	When Click Create Lead 
	Then Verify Lead is created 
	Examples: 
		|company|firstname|lastname|
		|'Google'|'Vel'|'Subra'|
		|'Apple'|'Hari'|'Vel'|
		
Scenario Outline: TC002_To Verify Lead is NOT Created 
	Given Enter Company Name <company> 
	And Enter first Name <firstname> 
	And Enter last Name <lastname> 
	When Click Create Lead 
	But Veirfy Lead is Not created with Error Message 
	Examples: 
		|company|firstname|lastname|
		|''|'Vel'|'Subra'|
		|'Apple'|''|'Vel'|
		|'Fiserv'|'Shyam'|''|
		|''|''|''|