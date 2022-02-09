package lesson2.HW;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSort {
    private static final int NOTEBOOKS_COUNT = 100;

    public static void main(String[] args) {
        List<Notebook> notebooks = generateListNotebooks();

        long timeStart = System.currentTimeMillis();

//        способ 1 - сортировка выбором
        notebooks = SortNotebooksSelection.sort(notebooks);

//        способ 2 - сортировка компаратором
//        SortNotebooksSelection.sortLight(notebooks);

/*        способ 3 - сортировка быстрая
        SortNotebooksQuick.quickSort(notebooks);*/

        long timeEnd = System.currentTimeMillis();


        displayNotebooks(notebooks);
        System.out.printf("Прошло времени: %dms", timeEnd - timeStart);

    }

    private static void displayNotebooks(List<Notebook> list) {
        for (Notebook n : list) {
            System.out.printf("Ноутбук:\tс\\н: %s,\tцена: %s,\tпамять: %s,\tпроизводитель: %s%n", n.getSerialId(),
                    n.getPrice(),
                    n.getMemory(), n.getProducer());
        }
    }

    private static ArrayList<Notebook> generateListNotebooks() {
        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_COUNT; i++) {
            arrayList.add(createNotebook());
        }
        return arrayList;
    }

    private static Notebook createNotebook() {
        Random random = new Random();
        BigDecimal price = BigDecimal.valueOf(random.nextInt(26) * 100 + 500);
        int memory = (random.nextInt(6) + 1) * 4;
        int producersCount = Notebook.Producer.values().length;
        Notebook.Producer producer = Notebook.Producer.values()[random.nextInt(producersCount)];
        return new Notebook(price, memory, producer);
    }

}
