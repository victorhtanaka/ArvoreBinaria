package Queue;

public class CircularQueue<T> extends Queue<T> {
    public CircularQueue(int size) {
        super(size);
    }

    @Override
    public void store(T data) {
        try {
            if (this.top == this.data.length - 1) {
                this.top = -1;
                this.data[++top] = data;
            }
            this.data[++top] = data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T retrieve() {
        try {
            if (this.top == this.base) {
                return this.data[base];
            }
            if (this.base == this.data.length - 1) {
                this.base = -1;

                return this.data[++base];
            }

            return this.data[++base];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}