package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void withoutAdding() { // без добавления
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual); //

    }

    @Test
    public void shouldBeAddedOne() { // добавили один фильм
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeAddedSeveral() { // добавили несколько
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");

        String[] expected = {"Бладшот", "Вперед", "Отель \"Белград\""};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldBeDisplayedBelowLimit() {   // меньше лимита
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");

        String[] expected = {"Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDisplayMoreThanlimit() {   // больше лимита
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек- невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек- невидимка", "Джентльмены",
                "Отель \"Белград\""};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldBeDisplayedMaximumLimit() {   //  равно лимиту
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек- невидимка");

        String[] expected = {"Человек- невидимка", "Джентльмены", "Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOutputAsMuchSpecified() {   // должно вывести столько, сколько указали
        MovieManager manager = new MovieManager(7);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек- невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек- невидимка", "Джентльмены",
                "Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOutputLessThanList() {   // должно вывести столько, сколько указали
        MovieManager manager = new MovieManager(4);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек- невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек- невидимка", "Джентльмены"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
