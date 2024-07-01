package ru.netology.manager;

public class MovieManager {
    private String[] movies = new String[0];
    private int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(String movie) { //добавление фильмов
        String[] tmp = new String[movies.length + 1]; // расширяем массив
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i]; // копируем все из старого массива
        }
        tmp[tmp.length - 1] = movie; //заполняем ново-добавленныю ячейку
        movies = tmp; // запоминаем массив в качестве основнова
    }

    public String[] findAll() { // Вывод всех фильмов в порядке добавления
        return movies; // возвращаем массив
    }

    public String[] findLast() { // Вывод штук последних добавленных фильмов в обратном от добавления порядке
        int resultLenght;
        if (movies.length < limit) { // если фильмов меньше чем лимит
            resultLenght = movies.length; // будет ответ= сколько есть фильмов, столько и будет
        } else {
            resultLenght = limit; // не больше лимита
        }
        String[] ans = new String[resultLenght]; // массив ответа
        for (int i = 0; i < ans.length; i++) { //проход по массиву
            ans[i] = movies[movies.length - 1 - i];
        }
        return ans;
    }
}
