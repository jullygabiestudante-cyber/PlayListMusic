public class PlayList implements PlayListTAD {
    private int[] listmusicas;
    private int capacidade;
    private int size;

    public PlayList(int capacidade) {
        this.capacidade = capacidade;
        this.size = 0;
        this.listmusicas = new int[capacidade];

    }

    @Override
    public void addFirst(int id) {
        if (size < capacidade) {
            // Desloca todos os elementos para a DIREITA
            for (int i = size; i > 0; i--) {
                listmusicas[i] = listmusicas[i - 1];
            }
            listmusicas[0] = id;
            size++;
            display1();
        } else {
            isFull();
        }
    }

    @Override
    public void addLast(int id) {
        if (size < capacidade) {
            listmusicas[size] = id;
            size++;
            display1();
        } else {
            isFull();
        }
    }

    @Override
    public void insertAt(int index, int id) {
        if (index < 0 || index > size) {
            System.out.println("Índice inválido!");
            return;
        }
        if (size < capacidade) {

            for (int i = size; i > index; i--) {
                listmusicas[i] = listmusicas[i - 1];
            }
            listmusicas[index] = id;
            size++;
            display1();
        } else {
            isFull();
        }
    }

    @Override
    public void removeFirst() {
        if (size > 0) {

            for (int i = 0; i < size - 1; i++) {
                listmusicas[i] = listmusicas[i + 1];
            }
            size--;
            display1();
        } else {
            System.out.println("Lista vazia!");
        }
    }

    @Override
    public void removeLast() {
        if (size > 0) {
            size--;
            display1();
        } else {
            System.out.println("Lista vazia!");
        }
    }


    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Índice inválido!");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            listmusicas[i] = listmusicas[i + 1];
        }
        size--;
        display1();
    }

    @Override
    public void remove(int id) {
        boolean achou = false;
        for (int i = 0; i < size; i++) {
            if (listmusicas[i] == id) {
                removeAt(i);
                i--;
                achou = true;
            }
        }
        if (!achou) System.out.println("ID não encontrado.");
    }

    @Override
    public void find(int id) {
        for (int i = 0; i < size; i++) {
            if (listmusicas[i] == id) {
                System.out.println("ID " + id + " encontrado na posição: " + i);
                return;
            }
        }
        System.out.println("Valor não encontrado.");
    }

    @Override
    public void get(int index) {
        if (index >= 0 && index < size) {
            System.out.println("Música no índice " + index + ": ID " + listmusicas[index]);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    @Override
    public void set(int index, int id) {
        if (index >= 0 && index < size) {
            listmusicas[index] = id;
            display1();
        } else {
            System.out.println("Erro: Índice inexistente.");
        }
    }

    public void display1() {
        for (int i = 0; i < size; i++) {
            System.out.print("[" + listmusicas[i] + "] ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void isFull() {
        if (size >= capacidade) {
            System.out.println("Lista cheia!");
        }
    }
}