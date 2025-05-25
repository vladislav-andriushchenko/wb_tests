package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class DialogWindow {

    private final SelenideElement
            modalWindow = $(".popup__content"),
            searchItemButton = $("#searchGoodsButton");


    public void shouldAppear() {
        modalWindow.should(appear);
    }

    public void makeSearch() {
        searchItemButton.click();
    }
}
