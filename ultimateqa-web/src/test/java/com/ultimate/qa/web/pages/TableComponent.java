package com.ultimate.qa.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableComponent extends BasePage {
    By tableWithNoId = By.cssSelector(".et_pb_text_inner > table:not([id])");
    By tableWithNoIdRow = By.cssSelector(".et_pb_text_inner > table:not([id]) tr");

    public TableComponent() {
        super();
    }

    public List<String> getDataByColumn(int columnIndex) {
        scrollToElement(tableWithNoId);
        List<String> firstColumnData = new ArrayList<>();
        List<WebElement> rows = driver.findElements(tableWithNoIdRow);
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            WebElement firstCell = row.findElement(By.xpath("./td[" + columnIndex + "]"));
            firstColumnData.add(firstCell.getText());
        }
        return firstColumnData;
    }
}
