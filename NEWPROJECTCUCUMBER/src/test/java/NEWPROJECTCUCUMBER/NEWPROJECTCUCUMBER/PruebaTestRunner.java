package NEWPROJECTCUCUMBER.NEWPROJECTCUCUMBER;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/NEWPROJECTCUCUMBER/NEWPROJECTCUCUMBER/PruebaCucumberTest.feature",format={"pretty","json:target/cucumber.json"})


public class PruebaTestRunner {
}
