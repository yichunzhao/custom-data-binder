# Spring Type Conversion
Custom data binding in Spring mvc.

## Binding individual object to handler method parameter

Spring mvc may carry out simple object binding, like String, Numbers etc, but it cannot bind Sting to objects like Enum, Date etc. 

## Binding String to an Hiearchycal Objects

Instead of a list of individual converters, it may use a ConverterFactory to centralize the conversion logic for an entire class hierarchy
(for example, converting from string to Enum)

## Binding to domain model

Uisng handler method argument resolver to bind data stored in header, session, or cookie to a domain model.


