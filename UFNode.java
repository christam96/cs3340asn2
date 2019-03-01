import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class UFNode<T> {
    public UFNode<T> parent;
    public int rank;
    public T element;

    public UFNode(T element) {
        this.element = element;
        this.rank = 0;
    }

}
