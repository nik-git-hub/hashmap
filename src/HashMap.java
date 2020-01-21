public class HashMap {

    private static final int HASH_TABLE_CAPACITY = 16;
    private Node[] content;

    public HashMap(){
        content = new Node[HASH_TABLE_CAPACITY];
    }

    public void put(Object key, Object value){

        int hash = createKeyHashCode(key);
        int index = createIndex(hash);
        Node node = new Node(hash, key, value, null);

        if (content[index] == null) {
            content[index] = node;
            return;
        }

        Node current = content[index];
        while (current != null){

            if (current.getHash() == hash){
                if (current.getKey().equals(key)){
                    current.setValue(value);
                    return;
                }
            }
            if (current.getNext() == null) {
                current.setNext(node);
                return;
            }
            current = current.getNext();
        }
    }

    private int createKeyHashCode(Object key){
        if (key == null){ return 0;}
        return key.hashCode();
    }

    private int createIndex(int hash){
        return hash % HASH_TABLE_CAPACITY;
    }

    public boolean containsKey(Object key){
        return searchKey(content[createIndex(createKeyHashCode(key))], key);
    }

    private boolean searchKey(Node list, Object key ){
        Node current = list;
        while (current != null) {

            if (current.getKey() ==  null || key == null) {
                if (current.getKey() == key) {
                    return true;
                }
            } else {
                if (current.getKey().equals(key)) {
                    return true;
                }
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean containsValue(Object value){

        Node current;
        for (int i = 0; i < content.length ; i++) {
            if (content[i] != null) {
                current = content[i];
                while (current != null) {

                    if (current.getValue() == null || value == null) {
                        if (current.getValue() == value) {
                            return true;
                        }
                    } else {
                        if (current.getValue().equals(value)) {
                            return true;
                        }
                    }
                    current = current.getNext();
                }
            }
        }
        return false;
    }

    private class Node {
        private int hash;
        private Object key;
        private Object value;
        private Node next;

        public Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void show(){
        for (int i = 0; i < content.length ; i++) {
            if (content[i] != null) {
               showList(content[i], i);
            }
        }
        System.out.println("\n");
    }

    private void showList(Node list, int index){
        Node current = list;

        System.out.print("index " + index +" {");
        while (current != null) {
            System.out.print("hash:" + current.getHash() + "/K:" + current.getKey() + "/V:" + current.getValue());
            current = current.getNext();

            if (current != null ) {
                System.out.print("; ");
            }
        }
        System.out.println("}");
    }
}
