Feature: Prueba Cucumber Test

Scenario: Prueba login

Given user opens login page
Then user enters userid
Then user enters password
And user clicks on signin button
And close the browser


Scenario: Yahoo login title page

Given user opens yahoo login page
Then get the tittle of yahoo login page and verify
And close the browser

