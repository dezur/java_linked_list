package com.codecool.linkedlist;

public class SinglyLinkedList<T> {
    private int size = 0;

    private class Link<T> {

        private T value;
        private Link<T> next;


        Link(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Link<T> getNext() {
            return next;
        }

        void setNext(Link<T> next) {
            this.next = next;
        }
    }

    private Link<T> head;

    public SinglyLinkedList() {
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(T value) {
        Link<T> newLink = new Link<>(value);
        if (head == null) {
            head = newLink;
            size++;
        } else {
            Link<T> runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newLink;
            size++;
        }
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public T get(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.getValue();
        }
        Link<T> newLink = head;
        for (int i = 0; i < index; i++) {
            newLink = newLink.getNext();
        }
        return newLink.getValue();
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */

    public int indexOf(T number) {
        Link<T> cica = head;
        int counter = 0;
        while (cica != null) {
            System.out.println(cica.getValue() + " | " + number);
            if(cica.getValue() == number)
                return counter;
            cica = cica.getNext();
            counter++;
        }
        return -1;
    }

    public Link<T> getNode(int pos) {
        if (head == null) {
            throw new IllegalArgumentException("Pocição não existe!");
        }
        Link<T> atual = head;
        for (int i = 0; i < pos; i++) {
            atual = atual.getNext(); // Pega a posição atual (ou seja a posição POS)
        }
        return atual;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, T number) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Link<T> node = new Link<>(number);
        if (head == null) {
            head = node;
        } else {
            Link<T> atual = getNode(index);
            if (atual == head) {
                Link<T> tmp = head;
                head = node;
                head.setNext(tmp);
            } else {
                Link<T> anterior = getNode(index - 1);
                Link<T> proxima = anterior.getNext();
                anterior.setNext(node);
                node.setNext(proxima);
            }
        }
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        Link<T> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
