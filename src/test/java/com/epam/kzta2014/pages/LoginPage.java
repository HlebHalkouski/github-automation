package com.epam.kzta2014.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class LoginPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "https://github.com/login";

	@Name("Login")
	@FindBy(id = "login_field")
	private TextInput inputLogin;
	
	@Name("Password")
	@FindBy(id = "password")
	private TextInput inputPassword;
	
	@Name("Submit")
	@FindBy(xpath = "//input[@value='Sign in']")
	private Button buttonSubmit;
	
	@Name("LoggedInUser")
	@FindBy(xpath = "//ul[@id='user-links']//a")
	private Link linkLoggedInUser;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}

	public String getLoggedInUserName()
	{
		return linkLoggedInUser.getText();
	}

}
