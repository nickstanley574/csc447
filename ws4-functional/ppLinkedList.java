class ppLinkedList {
    static class Node <X> {
        X item;
        Node <X> next;
    

        public Node (X item, Node<X> next) {
            this.item = item;
            this.next = next;
        }
    }

    static <X> int length (Node<X> node) {
        if (node == null) { return 0;}
        else              { return 1 + length (node.next);}
    }


    public static void main (String[] args) {
        String[] values = {"hello", "world", "!!!!"};
        Node<String> data = null;
        for (String x : values) {
            data = new Node<String> (x, data);
        }
        System.out.println ("length = " + length (data));
    }
}