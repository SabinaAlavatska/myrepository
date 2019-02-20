Feature: test epam web page vacancies

As a potential test automation engineer
I want to get a job in EPAM
So that I can find open positions due to my professional skills

Scenario: Test epam web site vacancies
  Given User is not an EPAM employee.
  When User go to website 'https://www.epam.com/'.
  And User select region 'Ukraine/English' at location dropdown.
  And User go to 'Vacancies' tab.
  And User fill the search field 'Keyword or job id' with value 'Java'.
  And User select location 'Kyiv' from location dropdown.
  And User tick 'Software Test Engineering' in 'Skills' dropdown.
  And User click 'Find' button.
  And User sees list of job openings related to above criteria.
  And User select first vacancy and click 'Apply' button.
  Then User sees description of selected vacancy.
  And User sees next blocks:
    |DESCRIPTION|
    |REQUIREMENTS|
    |NICE TO HAVE|
    |TECHNOLOGIES|
    |WE OFFER|
  And User sees item 'Flexible work hours.' at 'We offer' block