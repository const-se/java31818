package org.itstep;

public class Main3 {
    static class Item {
        String value;
        Item next;
        Item previous;

        Item(String value) {
            this.value = value;
        }
    }

    static class List {
        Item start;
        Item end;
        int size;

        List(Item item) {
            this.start = item;
            this.end = item;
            this.size = 1;
        }

        void add(Item item) {
            this.end.next = item;
            this.end = item;
            this.size++;
        }

        void add(Item item, int index) {
            if (index > this.size) {
                this.add(item);
            } else {
                if (index == 0) {
                    item.next = this.start;
                    this.start.previous = item;
                    this.start = item;
                } else {
                    Item current = this.start;

                    for (int i = 0; i < index; i++) {
                        current = current.next;
                    }

                    item.previous = current.previous;
                    current.previous = item;
                    item.previous.next = item;
                    item.next = current;
                }

                this.size++;
            }
        }

        void delete(int index) {
        }
    }

    public static void main(String[] args) {
    }
}
