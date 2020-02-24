package es.codeurjc.test.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
  plugin = {"pretty"}, 
  features = { "classpath:es/codeurjc/test/cucumber" },
  glue = {"es.codeurjc.test.cucumber" },
  monochrome = true)
public class CalculatorTest extends AbstractTestNGCucumberTests{}