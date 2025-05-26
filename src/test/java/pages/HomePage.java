package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.DialogWindow;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    DialogWindow dialogWindow = new DialogWindow();

    private final SelenideElement
            searchInput = $("#searchInput"),
            cartButton = $("a[data-wba-header-name='Cart']"),
            searchByImageButton = $("#searchByImageFormAbNew"),
            imageSelector = $("#popUpFileInput"),
            imageSelectorPopup = $("#uploadLink"),
            resultTitle = $(".catalog-page__title"),
            productCardResult = $(".product-card-list"),
            notFoundTitle = $(".not-found-search__title");

    private final ElementsCollection
            itemCatalog = $$("article"),
            searchProduct = $$("article.product-card");

    public HomePage openPage() {
        open("/");
        sleep(2000);
        return this;
    }

    public HomePage enterValue(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public HomePage selectCart() {
        cartButton.click();
        sleep(2000);
        return this;
    }

    public HomePage selectItem(String itemId) {
        SelenideElement item = itemCatalog
                .findBy(attribute("data-card-index", itemId));
        item.$(".j-add-to-basket").click();
        return this;
    }

    public String getItemInfo(String itemId) {
        SelenideElement item = itemCatalog.findBy(attribute("data-card-index", itemId));
        return item.$("a.product-card__link").getAttribute("href").replaceAll(".*/catalog/(\\d+).*", "$1");
    }

    public HomePage selectSearchImage() {
        searchByImageButton.click();
        return this;
    }

    public HomePage uploadImage(String filePath) {
        imageSelectorPopup.shouldBe(visible, Duration.ofSeconds(5));
        imageSelector
                .uploadFromClasspath("media/" + filePath);
        return this;
    }

    public HomePage makeSearch() {
        dialogWindow.makeSearch();
        return this;
    }

    public HomePage checkModalWindow() {
        dialogWindow.shouldAppear();
        return this;
    }

    public HomePage checkResultTitle(String title) {
        resultTitle.shouldHave(text(title));
        return this;
    }

    public void checkResultContent() {
        productCardResult.shouldBe(visible);
    }

    public void notFoundTitle(String searchQuery) {
        notFoundTitle
                .shouldBe(visible)
                .has(text("По запросу «" + searchQuery + "» ничего не найдено"));
    }

    public Boolean notFoundItems() {
        return searchProduct.isEmpty();
    }
}
