Feature: Delete Lead Functionality TC 

Background: 
	Given Open the chrome browser 
	And Load the application URL as 'http://leaftaps.com/opentaps/control/main' 
	And Enter the User Name as 'Demosalesmanager' 
	And Enter the Password as 'crmsfa' 
	And Click the Login Button 
	And Click CRM Link 
	And Click Leads 
	And Click Find Leads 
	
Scenario: TC001_To Verify Lead is Deleted 
	Given Get and Store 1st Emp ID and Click 1st Emp ID 
	And Delete the 1st Emp ID 
	And Click Find Leads 
	When Enter Stored 1st Emp ID and then Click to Find Deleted Lead 
	Then Verify Lead is Deleted