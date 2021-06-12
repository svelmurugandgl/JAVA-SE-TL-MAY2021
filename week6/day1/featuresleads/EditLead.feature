Feature: Edit Lead Functionality TC 

Background: 
	Given Open the chrome browser 
	And Load the application URL as 'http://leaftaps.com/opentaps/control/main' 
	And Enter the User Name as 'Demosalesmanager' 
	And Enter the Password as 'crmsfa' 
	And Click the Login Button 
	And Click CRM Link 
	And Click Leads 
	And Click Find Leads 
	
Scenario Outline: TC001_To Verify View Lead Title is displayed correctly 
	Given Enter the firstName as <firstName> 
	And Click Find Leads List 
	When Click 1st Emp ID List 
	Then Verify View Lead Title is displayed correctly 
	Examples: 
		|firstName|
		|'vel'|
		|'hari'|
		
Scenario Outline: TC002_To Verify Edited Company Name is 
	Given Enter the firstName as <firstName> 
	And Click Find Leads List 
	And Click 1st Emp ID List 
	And Click Edit Emp ID 
	And Clear and Enter new company name as <company> 
	When Click update the 1st Emp ID record 
	Then Verify new company name is updated 
	Examples: 
		|firstName|company|
		|'vel'|'sony'|
		|'hari'|'adobe'|