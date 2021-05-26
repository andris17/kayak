Feature: Kayak.ch search
  As a user of the Kayak website
  I would like to search for flights
  So that I can see my options in a result list

  Scenario Outline: Search happy path
    Given I use the Kayak website
    When I search for a flight:
      | originAirport  | destinationAirport | departureDate | arrivalDate |
      | <from_airport> | <to_airport>       | <from_date>   | <to_date>   |
    And I set the maximum price to <max_price>
    Then I see search results
    And all results have lower price than the maximum

    Examples:
      | from_airport | to_airport | from_date  | to_date    | max_price |
      | LON          | ZRH        | 24.07.2021 | 30.07.2021 | 139       |
      | ZRH          | LON        | 04.08.2021 | 30.08.2021 | 1390      |

  Scenario Outline: Search happy path with deeplink
    Given I use the Kayak website
    When I search for a flight with a deeplink:
      | originAirport  | destinationAirport | departureDate | arrivalDate | maximumPrice |
      | <from_airport> | <to_airport>       | <from_date>   | <to_date>   | <max_price>  |
    Then I see search results
    And all results have lower price than the maximum

    Examples:
      | from_airport | to_airport | from_date  | to_date    | max_price |
      | LON          | ZRH        | 24.07.2021 | 30.07.2021 | 139       |
      | ZRH          | LON        | 04.08.2021 | 30.08.2021 | 1390      |
