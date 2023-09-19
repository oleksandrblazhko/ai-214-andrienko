Feature: functionality of receiving a consultation request
Given I am a somnologist-consultant
When I check available requests page
And at least one request is available
Then I should see the available requests on the page.
