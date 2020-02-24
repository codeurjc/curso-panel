package es.codeurjc.test.cucumber;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(monochrome = true)
public class CalculatorRunSteps extends AbstractTestNGCucumberTests{
 
    private int total;
 
    private Calculator calculator;
 
    @BeforeMethod
    private void init() {
        total = -999;
    }
 
    @Given("^I have a calculator$")
    public void initializeCalculator() throws Throwable {
        calculator = new Calculator();
    }
 
    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void testAdd(int num1, int num2) throws Throwable {
        total = calculator.add(num1, num2);
    }
 
    @Then("^the result should be (-?\\d+)$")
    public void validateResult(int result) throws Throwable {
        assertThat(total, Matchers.equalTo(result));
    }
}