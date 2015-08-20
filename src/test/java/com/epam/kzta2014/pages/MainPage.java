package com.epam.kzta2014.pages;

import com.epam.kzta2014.pages.AbstractPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";

	@Name("Create New Repository")
	@FindBy(xpath = "//a[contains(@aria-label, 'Create new')]")
	private Button buttonCreateNew;

	@Name("New Repository")
	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private Link linkNewRepository;

	public MainPage(WebDriver driver)
	{
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public void clickOnCreateNewRepositoryButton()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
}
