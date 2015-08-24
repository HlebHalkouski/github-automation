package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.epam.ta.utils.Utils;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class CreateNewRepositoryPage extends AbstractPage
{
	private final String BASE_URL = "http://www.github.com/new";
	
	@Name("Repository Name")
	@FindBy(id = "repository_name")
	private TextInput inputRepositoryName;

	@Name("Repository Description")
	@FindBy(id = "repository_description")
	private TextInput inputRepositoryDescription;

	@Name("Create repository")
	@FindBy(xpath = "//form[@id='new_repository']//button[@type='submit']")
	private Button butttonCreate;

	@Name("Empty Repo Setup Option")
	@FindBy(className = "empty-repo-setup-option")
	private HtmlElement labelEmptyRepoSetupOption;

	@Name("Current Repository")
	@FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
	private HtmlElement linkCurrentRepository;

	public CreateNewRepositoryPage(WebDriver driver)
	{
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public boolean isCurrentRepositoryEmpty()
	{
		return labelEmptyRepoSetupOption.isDisplayed();
	}

	public String createNewRepository(String repositoryName, String repositoryDescription)
	{
		String repositoryFullName = repositoryName + Utils.getRandomString(6);
		inputRepositoryName.sendKeys(repositoryFullName);
		inputRepositoryDescription.sendKeys(repositoryDescription);
		butttonCreate.click();
		return repositoryFullName;
	}

	public String getCurrentRepositoryName()
	{
		return linkCurrentRepository.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

}
