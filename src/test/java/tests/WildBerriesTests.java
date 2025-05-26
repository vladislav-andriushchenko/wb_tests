package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.HomePage;
import utils.TestBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestData.getRandomInstrument;
import static utils.TestData.getRandomItem;

public class WildBerriesTests extends TestBase {

    HomePage home = new HomePage();
    BasketPage basket = new BasketPage();

    @DisplayName("Проверка успешного добавления товара в корзину")
    @Test
    void addItemToCartTest() {
        String item = getRandomItem();

        step("Найти товар и добавить к корзину", () -> {
            home
                    .openPage()
                    .enterValue(getRandomInstrument())
                    .selectItem(item);
        });

        String itemInfo = home.getItemInfo(item);

        step("Перейти в корзину", () -> {
            home.selectCart();
        });

        step("Проверить наличие товара в корзине", () -> {
            assertThat(basket.isItemInCart(itemInfo))
                    .as("Item should be in cart")
                    .isTrue();
        });

        step("Проверить кол-во товара в корзине", () -> {
            assertThat(basket.checkItemCount())
                    .as("Item quantity in cart must be equal to 1")
                    .isEqualTo(1);
        });
    }

    @DisplayName("Проверка успешного удаления товара из корзины")
    @Test
    void deleteItemFromCartTest() {
        String item = getRandomItem();

        step("Найти товар и добавить к корзину", () -> {
            home
                    .openPage()
                    .enterValue("iPhone")
                    .selectItem(item);
        });

        String itemInfo = home.getItemInfo(item);

        step("Перейти в корзину", () -> {
            home.selectCart();
        });

        step("Удалить товар из корзины", () -> basket.deleteItem(itemInfo));
        step("Проверить, что корзина пуста", () -> basket.checkEmptyCart());
    }

    @DisplayName("Проверка возможности поиска по картинки")
    @Test
    void searchByImageTest() {
        step("Найти товар по картинке", () -> {
            home
                    .openPage()
                    .selectSearchImage()
                    .uploadImage("example.jpg")
                    .checkModalWindow()
                    .makeSearch()
                    .checkResultTitle("Вот, что мы нашли")
                    .checkResultContent();
        });

        step("Проверить, что список товаров не пуст", () -> {
            assertThat(home.notFoundItems())
                    .as("Item list should be not blank")
                    .isFalse();
        });
    }

    @DisplayName("Проверка поиска несуществующего товара")
    @Test
    void invalidSearchTest() {
        String searchQuery = "qwertyasdf";

        step("Найти товар по запросу", () -> {
            home
                    .openPage()
                    .enterValue(searchQuery)
                    .notFoundTitle(searchQuery);
        });

        step("Проверить, что список товаров пуст", () -> {
            assertThat(home.notFoundItems())
                    .as("Item '%s' should not be found", searchQuery)
                    .isFalse();
        });
    }

    @DisplayName("Проверка увеличения счетчика товара")
    @Test
    void increaseItemCountTest() {
        String item = getRandomItem();

        step("Найти товар и добавить к корзину", () -> {
            home
                    .openPage()
                    .enterValue("iPhone")
                    .selectItem(item);
        });

        String itemInfo = home.getItemInfo(item);

        step("Перейти в корзину", () -> {
            home.selectCart();
        });

        step("Проверить наличие товара в корзине", () -> {
            assertThat(basket.isItemInCart(itemInfo))
                    .as("Item should be in cart")
                    .isTrue();
        });

        step("Проверить кол-во товара в корзине", () -> {
            assertThat(basket.checkItemCount())
                    .as("Item quantity in cart must be equal to 1")
                    .isEqualTo(1);
        });

        step("Увеличить кол-во товара в корзине", () -> {
            basket.increaseItem();
            assertThat(basket.checkItemCount())
                    .as("Item quantity in cart must be equal to 1")
                    .isEqualTo(2);
        });
    }

    @DisplayName("Проверка уменьшения счетчика товара")
    @Test
    void decreaseItemCountTest() {
        String item = getRandomItem();

        step("Найти товар и добавить к корзину", () -> {
            home
                    .openPage()
                    .enterValue("iPhone")
                    .selectItem(item);
        });

        String itemInfo = home.getItemInfo(item);

        step("Перейти в корзину", () -> {
            home.selectCart();
        });

        step("Проверить наличие товара в корзине", () -> {
            assertThat(basket.isItemInCart(itemInfo))
                    .as("Item should be in cart")
                    .isTrue();
        });

        step("Проверить кол-во товара в корзине", () -> {
            assertThat(basket.checkItemCount())
                    .as("Item quantity in cart must be equal to 1")
                    .isEqualTo(1);
        });

        step("Увеличить кол-во товара в корзине", () -> {
            basket.increaseItem();
            assertThat(basket.checkItemCount())
                    .as("Item quantity in cart must be equal to 1")
                    .isEqualTo(2);
        });

        step("Уменьшить кол-во товара в корзине", () -> {
            basket.decreaseItem();
            assertThat(basket.checkItemCount())
                    .as("Item quantity in cart must be equal to 1")
                    .isEqualTo(1);
        });

        step("Проверить, что кнопка уменьшения счетчика недоступна", () -> {
            assertThat(basket.checkDisabledButton())
                    .as("The decrease button must be disabled")
                    .isTrue();
        });
    }
}
