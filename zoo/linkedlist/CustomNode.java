package zoo.linkedlist;

public class CustomNode<T> {

    T data;
    CustomNode<T> next;

    public CustomNode(T data, CustomNode<T> next) {

        this.data = data;
        this.next = next;
    }

    public T getData() {

        return this.data;
    }

    public void setData(T data) {

        this.data = data;
    }
}
