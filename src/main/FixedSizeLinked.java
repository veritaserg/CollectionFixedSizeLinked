package main;

public class FixedSizeLinked<E> {
    private Node<E> frsNode;
    private Node<E> lstNode;
    private int counter;

    public FixedSizeLinked() {
        lstNode = new Node<>(null, null, frsNode);
        frsNode = new Node<>(null, lstNode, null);
        counter = 16;

    }

    public FixedSizeLinked(int size) {
        lstNode = new Node<>(null, null, frsNode);
        frsNode = new Node<>(null, lstNode, null);

        counter = size;
        if (size == 0) {
            throw new IllegalArgumentException("Illegal Size: " +
                    size);
        }
    }

    public void add(E e) {
        Node<E> temp = lstNode;
        temp.setCurrentElement(e);
        lstNode = new Node<>(null, null, temp);
        temp.setNextElement(lstNode);
        if (counter <= 0) {
            Node<E> first = frsNode.getNextElement();
            first.setCurrentElement(null);
            first.setPrevElement(null);
            frsNode = first;
        } else {
            counter--;
        }
    }

    public E getFirst() {
        Node<E> first = frsNode.getNextElement();
        return first.getCurrentElement();
    }

    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }


    }

}
