package es.codeurjc.test.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(monochrome = true,
  plugin = {"pretty"}, 
  features = { "classpath:es/codeurjc/test/cucumber" },
  glue = {"es.codeurjc.test.cucumber" })
public class CalculatorTest extends AbstractTestNGCucumberTests{}