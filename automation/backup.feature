# language: en

@register_user
Feature: User Registration
    As a new user of the e-commerce platform
    I want to create an account
    So that I can make purchases on the platform

    @successful_registration
    Scenario: User Registration with sucess
        Given I am at homepage
        And I click in register
        When I fill the form with my name, email and password
        Then I see the register has been done

    @unsuccessful_registration_invalid_name
    Scenario: Invalid name
        Given I am at homepage
        And I click in register
        When I fill the form with the following information, name "", password "TestPa$$w0rd123" and email "test_email@email"
        Then I see the message "O campo nome deve ser prenchido"

    @unsuccessful_registration_invalid_email
    Scenario: Invalid email
        Given I am at homepage
        And I click in register
        When I fill the form with the following information, name "Test Name", password "TestPa$$w0rd123" and email "test_email@email"
        Then I see the message "O campo e-mail deve ser prenchido corretamente"

    @unsuccessful_registration_invalid_password
    Scenario: Invalid password
        Given I am at homepage
        And I click in register
        When I fill the form with the following information, name "Test Name", password "Tst1#" and email "test_email@email.com"
        Then I see the message "O campo senha deve ter pelo menos 6 dígitos"
