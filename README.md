<a href="https://www.wildberries.ru"> <img src="media/wb_logo.jpg" width="200" height="200"> 
<h1>Проект по автоматизации тестирования для <a href="https://www.wildberries.ru">Wildberries</a></h1>

## ☑️ Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins)
- Allure-отчет
- Уведомление в Telegram о результатах прогона
- Видео пример прохождения тестов

<a id="tools"></a>
## :ballot_box_with_check: Технологии и инструменты:

|                                               Java                                                |                                              IntelliJ Idea                                              |                                               GitHub                                                |                                                  JUnit 5                                                   |                                               Gradle                                                | Selenide | Selenoid | Allure Report | Jenkins | Telegram |
|:-------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------:|:--------:|:--------:|:-------------:|:-------:|:--------:|
| <a href="https://www.java.com/"><img src="media/Java.svg" width="50" height="50" alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/IntellijIdea.svg" width="50" height="50" alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/Github.svg" width="50" height="50" alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/JUnit5.svg" width="50" height="50" alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/Gradle.svg" width="50" height="50" alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="media/Selenide.svg" width="50" height="50" alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="media/Selenoid.svg" width="50" height="50" alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="media/Allure.svg" width="50" height="50" alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="media/Jenkins.svg" width="50" height="50" alt="Jenkins"/></a> | <a href="https://web.telegram.org/"><img src="media/Telegram.svg" width="50" height="50" alt="Telegram"/></a> |

<a id="cases"></a>
## :ballot_box_with_check: Реализованные проверки:

- Проверка успешного добавления товара в корзину
- Проверка успешного удаления товара из корзины
- Проверка возможности поиска по картинки
- Проверка поиска несуществующего товара
- Проверка увеличения счетчика товара
- Проверка уменьшения счетчика товара

## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в Jenkins

<p align="center">  
<img src="media/JenkinsBuild.png" alt="Jenkins" width="950"/>  
</p>

## :ballot_box_with_check: Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 120.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)
- remoteUrl (URL для удаленного запуска)

## Команда для запуска из терминала
Локальный запуск
```bash
gradle clean wb_tests
```
Запуск с параметрами:
```bash  
-Dbrowser=chrome -DbrowserSize=1920x1080 -DbrowserVersion=128.0
```
Удаленный запуск через Jenkins:
```bash  
clean mts_tests
-Dbrowser="${BROWSER}"
-DbrowserSize="${BROWSER_SIZE}"
-DbrowserVersion="${BROWSER_VERSION}"
-DbrowserRemote="https://log:pass@${BROWSER_REMOTE}/wd/hub"
```

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure Report	</a>


## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/AllureReport.png" width="850">  
</p>  

____
## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/tgAllert.jpg" width="550">  
</p>

____
## <img alt="Selenoid" height="25" src="media/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="media/tests.gif" width="550" height="350"  alt="video">   
</p>
