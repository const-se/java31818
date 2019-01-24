package org.itstep;

import java.io.*;

public class Streams {
    // "Ручная" сериализация. Externalizable
    public static void main(String[] args) throws Throwable {
        File f = new File(System.getProperty("user.dir") + File.separator + "obj.txt");

        FishExt fish = new FishExt();
        fish.name = "Щука";
        fish.weight = 3;
        fish.price = 200;

        // Создаем поток для записи в файл
        FileOutputStream out = new FileOutputStream(f);
        // Создаем обертку над потоком, чтобы можно было писать объекты
        ObjectOutputStream objOutput = new ObjectOutputStream(out);
        // Сначала в файл запишем строку
        objOutput.write("hello!".getBytes());
        // Затем записываем объект
        objOutput.writeObject(fish);
        // Закрываем потоки
        objOutput.close();
        out.close();

        // Создаем поток чтения из файла
        FileInputStream in = new FileInputStream(f);
        // Создаем обертку над потоком для чтения объектов
        ObjectInputStream objInput = new ObjectInputStream(in);
        // Сначала пропускаем записанную строку
        objInput.skipBytes("hello!".getBytes().length);
        // Затем считываем объект для десериализации
        FishExt newFish = (FishExt) objInput.readObject();

        System.out.println(newFish);
    }

    // Простая сериализация. Serializable
    public static void example3(String[] args) throws Throwable {
        File f = new File(System.getProperty("user.dir") + File.separator + "obj.txt");
        FileInputStream in = null;
        FileOutputStream out = null;
        ObjectInputStream objInput = null;
        ObjectOutputStream objOutput = null;

        Fish fish = new Fish();
        fish.name = "Щука";
        fish.weight = 3;
        fish.price = 200;

        // Создаем поток для записи в файл
        out = new FileOutputStream(f);
        // Создаем обертку над потоком, чтобы можно было писать объекты
        objOutput = new ObjectOutputStream(out);
        // Записываем объект в файл
        objOutput.writeObject(fish);
        // Закрываем потоки
        objOutput.close();
        out.close();

        // Создаем поток чтения из файла
        in = new FileInputStream(f);
        // Создаем обертку над потоком для чтения объектов
        objInput = new ObjectInputStream(in);
        Fish newFish = (Fish) objInput.readObject();

        System.out.println(newFish);
    }

    public static void example2(String[] args) {
        File f = new File(System.getProperty("user.dir") + "\\test.txt");
        FileInputStream input = null;

        try {
            input = new FileInputStream(f);
            // Чтение по 1 байту
//            int r = input.read();
//            System.out.println(r);
//            byte[] b = new byte[1024];
            byte[] b = new byte[input.available()]; // Сколько байт внутри потока
            int i = input.read(b); // Возвращает количество прочитанных байт
            String s = new String(b); // Байты в строку
            System.out.println(i);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileOutputStream output = null;

        File f1 = new File(System.getProperty("user.dir") + "\\test2.txt");

        try {

            output = new FileOutputStream(f);
            output.write("Пока!".getBytes());

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void example1(String[] args) {
        String dir = System.getProperty("user.dir");
//        String dir = "  %:\\fg/ hi!!! "; Вызовет ошибку
        String fileName = "test.txt";
        String fullName = dir + File.separator + fileName;
        File f = new File(fullName);
        f.deleteOnExit();

        try {
            if (f.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Что-то пошло не так");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File d1 = new File(dir + File.separator + "dir");
        if (d1.mkdir()) {}

        File d2 = new File(dir + File.separator + "dir1\\dir2");
        if (d2.mkdirs()) {}
    }
}
