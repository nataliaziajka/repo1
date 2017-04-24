package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Natalia on 2017-03-30.
 */
public class DatePickerPage extends BasePage {
    private final static Logger LOG = Logger.getLogger(DatePickerPage.class);

    @FindBy(css = "#menu-item-146>a")
    private WebElement datePickerSection;

    @FindBy(css = "#datepicker1")
    private WebElement datePickerBox;

    @FindBy(css = "#ui-datepicker-div>table.ui-datepicker-calendar>tbody>tr")
    private List<WebElement> dateTable;

    @FindBy(css = ".ui-icon.ui-icon-circle-triangle-w")
    private WebElement btnPrevious;

    @FindBy(css = ".ui-icon.ui-icon-circle-triangle-e")
    private WebElement btnNext;

    @FindBy(css = ".ui-datepicker-year")
    private WebElement datePickerYear;

    @FindBy(css = ".ui-datepicker-month")
    private WebElement datePickerMonth;

    @FindBy(css = "#ui-id-95")
    private WebElement selectedItem;

    private String today;

    Calendar calendar = Calendar.getInstance();
    private int currentYear = calendar.get(Calendar.YEAR);
    private int currentMonth = calendar.get(Calendar.MONTH);

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    public DatePickerPage selectDateWithInlineCalendar() {
        datePickerSection.click();
        datePickerBox.clear();
        datePickerBox.sendKeys("15-Dec-2014");
        return this;
    }

    public DatePickerPage selectDateFromPopup() {
        datePickerSection.click();
        datePickerBox.click();

        today = getCurrentYear();
        System.out.println("Current year:" + currentYear+ "\n");
        while(Integer.parseInt(datePickerYear.getText())!= currentYear)
            if (Integer.parseInt(datePickerYear.getText()) > currentYear)
            {
                btnPrevious.click();
            }
            else
            {
                btnNext.click();
            }
        currentMonth = getCurrentMonth();
        System.out.println("Current month:" + currentMonth+ "\n");
        while((datePickerMonth.getText()).equals(currentMonth))
            if ( Integer.parseInt(datePickerMonth.getText())<currentMonth)
        {
            btnNext.click();
        }
        else {
                btnNext.click();
            }
        today = getCurrentDay();
        System.out.println("Today's number: " + today + "\n");
        for (WebElement cell : dateTable) {
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
        return this;
    }

    private String getCurrentDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        String todayStr = Integer.toString(todayInt);
        return todayStr;
    }
    private Integer getCurrentMonth() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int monthInt = calendar.get(Calendar.MONTH)+1;
        return monthInt;
    }
    private String getCurrentYear() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int yearInt = calendar.get(Calendar.YEAR);
        String yearStr = Integer.toString(yearInt);
            return yearStr;
    }
}


