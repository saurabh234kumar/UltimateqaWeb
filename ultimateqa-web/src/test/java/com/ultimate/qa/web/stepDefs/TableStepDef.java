package com.ultimate.qa.web.stepDefs;

import com.ultimate.qa.web.pages.TableComponent;
import com.ultimate.qa.web.utils.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class TableStepDef {

    private TableComponent tableComponent = new TableComponent();
    ;
    private List<String> titles;
    private List<String> salaries;
    private List<String> works;

    @When("I get all the title from the table with no id")
    public void iGetAllTheTitleFromTheTableWithNoId() {
        titles = getAllTitles();
    }

    @When("I get all the salaries from the table with no id")
    public void iGetAllTheSalariesFromTheTableWithNoId() {
        titles = getAllTitles();
        salaries = getAllSalaries();
    }

    @Then("the first letter of each word in the title is in upper case excluding the preposition")
    public void the_first_letter_of_each_word_in_the_title_is_in_upper_case_excluding_the_preposition() {
        for (String title : titles) {
            Assert.assertTrue(Utils.isFirstLetterUpperCaseExcludingPrepositions(title),
                    title + " is not a matching with first cap and preposition");
        }
    }

    @Then("all roles have at least ${int}")
    public void allRolesHaveAtLeast$(int minSalary) {
        ArrayList<String> errorList = new ArrayList<>();
        for (int i = 0; i < salaries.size(); i++) {
            String salary = salaries.get(i);
            if (!Utils.hasMinimumSalary(salary, minSalary)) {
                errorList.add("Expected a minimum salary of $" + minSalary + ", but the salary is: " + salary + " for role: " + titles.get(i));
            }
        }

        if (!errorList.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Errors found:\n");
            for (String error : errorList) {
                errorMessage.append("- ").append(error).append("\n");
            }
            throw new AssertionError(errorMessage.toString());
        }
    }

    @When("get all the roles from the table with no id")
    public void getAllTheRolesFromTheTableWithNoId() {
        titles = getAllTitles();
        works = getAllWorks();
    }

    @Then("verify if there is any manual work")
    public void verifyIfThereIsAnyManualWork() {
        ArrayList<String> errorList = new ArrayList<>();
        for (int i = 0; i < works.size(); i++) {
            String work = works.get(i);
            if (work.equals("Manual")) {
                errorList.add("Expected all roles to be Automation but it's manual for role: " + titles.get(i));
            }
        }

        if (!errorList.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Errors found:\n");
            for (String error : errorList) {
                errorMessage.append("- ").append(error).append("\n");
            }
            throw new AssertionError(errorMessage.toString());
        }
    }

    private List<String> getAllTitles() {
        return tableComponent.getDataByColumn(1);
    }

    private List<String> getAllWorks() {
        return tableComponent.getDataByColumn(2);
    }

    private List<String> getAllSalaries() {
        return tableComponent.getDataByColumn(3);
    }
}
