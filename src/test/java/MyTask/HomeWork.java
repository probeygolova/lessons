package MyTask;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Татьяна on 17.05.2016.
 */
public class HomeWork {
///coment
    @Test
    public static void taskTest() {
        Configuration.pageLoadStrategy = "normal";
        open("https://todomvc4tasj.herokuapp.com/");

        $("#new-todo").setValue("task1").pressEnter();
        $("#new-todo").setValue("task2").pressEnter();
        $("#new-todo").setValue("task3").pressEnter();
        $("#new-todo").setValue("task4").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task2", "task3", "task4"));

        $(By.xpath(".//*[@id='todo-list']/li[2]/div/label")).hover();
        $(By.xpath(".//*[@id='todo-list']/li[2]/div/button")).click();
        $$("#todo-list>li").shouldHave(exactTexts("task1", "task3", "task4"));

        $(By.xpath(".//*[@id='todo-list']/li[3]/div/input")).click();
        $("#clear-completed").click();
        $$("#todo-list>li").shouldHave(exactTexts("task1", "task3"));
        $("#toggle-all").click();
        $("#clear-completed").click();
        $$("#todo-list>li").shouldBe(empty);


    }
}