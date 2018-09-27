package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

class IsItFriday {
	static String isItFriday(String today) {
		String date="";
		switch (today) {
			case ("Friday"):
				date = "TGIF";
				break;
			case ("Sunday"):
				date = "Nope";
				break;
			case ("anything else!"):
				date = "Nope!";
				break;
		}
		return date;
	}
}

public class Stepdefs {
	private String today;
	private String actualAnswer;
/*
	@Given("^today is Sunday$")
	public void today_is_Sunday() {
		this.today = "Monday";
	}

	@Given("^today is Friday$")
	public void today_is_Friday(){
		this.today = "Friday";
	}
*/

	@Given("^today is \"([^\"]*)\"$")
	public void today_is(String date){
		this.today = date;
	}
	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_is_s_Friday_yet() {
		this.actualAnswer = IsItFriday.isItFriday(this.today);
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String Answer) {
		assertEquals(Answer, actualAnswer);
	}
}