package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {

    private final SelenideElement
            increaseButton = $("button.count__plus"),
            decreaseButton = $("button.count__minus"),
            emptyBasket = $(".basket-empty"),
            itemsListCart = $("div.basket-list"),
            itemsCount =  $("input.count__numeric.j-tb-qnt");

    private final ElementsCollection itemListData = $$("div.basket-list a[href]");

    public boolean isItemInCart(String value) {
        itemsListCart.shouldBe(visible);
        return itemListData
                .as("Cart items")
                .stream()
                .anyMatch(item -> item.getAttribute("href").contains(value));
    }

    public void deleteItem(String productId) {
        itemsListCart
                .$$("a[href*='/catalog/" + productId + "/']")
                .findBy(visible)
                .parent().$("button.btn__del").click();
    }

    public void checkEmptyCart() {
        Selenide.refresh();
        emptyBasket.shouldBe(visible);
    }

    public int checkItemCount() {
        return Integer.parseInt(
                Objects.requireNonNull(itemsCount
                        .shouldBe(visible)
                        .getValue())
        );
    }

    public void increaseItem() {
        increaseButton.click();
    }

    public void decreaseItem() {
        decreaseButton.click();
    }

    public boolean checkDisabledButton() {
        return decreaseButton.has(cssClass("disabled"));
    }
}
