# kayak
WebUI tests for Kayak.ch

## Improvement Ideas
As Kayak.ch uses a Rest API, many of the potential WebUI tests could be covered in a lower testing level too.  
If we are adamant to use BDD-style test scenarios, it's easy to create multiple definitions of the keywords.  
For example:   

`When I search for a flight:` can be implemented as either an action set in the web browser to select the form elements
or as a request sending for a Rest API test.

## Areas not covered in this PoC
* Ad Hoc pop-ups appear on the site but without knowing their logic, it seemed an overkill to handle them.
* When there are numerous pages of search results, they are not expanded, this sort of verification should be covered by lower level tests.
* Optimization of locators: ids and classes use generated data, a workaround is used to overcome this, but a better approach could be reached via a discussion with the development team.
* Internalization, although it should be a simple task as the locators are language-agnostic.
* Error-handling(when the application doesn't work as expected). It requires clarification from the development organization.
* Complete removal of flakiness. This is a PoC, when CI would be used, more data would be available to analyse potential instability of the tests.

