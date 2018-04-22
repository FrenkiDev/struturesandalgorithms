package pattertexemple.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> composite = new ArrayList<>();

    public void add(Component locComponent){
        composite.add(locComponent);
    }

    @Override
    public void show() {
        composite.forEach(v -> v.show());
    }
}
