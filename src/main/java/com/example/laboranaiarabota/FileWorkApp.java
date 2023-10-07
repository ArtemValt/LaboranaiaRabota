package com.example.laboranaiarabota;

import java.util.Objects;
import java.util.Scanner;

public class FileWorkApp {
    private static final String path = "/Users/belousovartem/IdeaProjects/bdcourse/LaboranaiaRabota/";

    public static void main(String[] args) {

        boolean work = true;
        Scanner sc = new Scanner(System.in);
        FileLab file = null;
        while (work) {
            System.out.println("""
                    Выберите действие : 
                    1)Создать файл
                    2)Записать информацию в файл
                    3)Прочитать файл
                    4)Закончить работу
                    """);
            int number = sc.nextInt();
            switch (number) {
                case 1 -> {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Назовите файл");
                    String path = sc1.nextLine();
                    file = FileWork.createFile(path);
                    System.out.println("Создан файл" + file);
                }
                case 2 -> {
                    if (file == null) {
                        System.out.println("Сначала создайте файл");
                    } else {
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Введите информацию");
                        String line = sc1.nextLine();
                        boolean toFile = FileWork.writeToFile(file, line);
                        System.out.println(toFile ? "Информация успешно записана" : "Произошла ошибка");
                    }
                }
                case 3 -> {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Напишите название файла в директории");
                    String line = sc1.nextLine();
                    String fileInfo = FileWork.getFileInfo(path.concat(line));
                    System.out.println(Objects.requireNonNullElse(fileInfo, "Файл не найден повторите попытку"));
                }
                case 4 -> work = false;
            }
            System.out.println("Приложение завершило работу");
        }

    }
}
