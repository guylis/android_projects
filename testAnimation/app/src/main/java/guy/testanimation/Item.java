package guy.testanimation;

import java.io.Serializable;

public class Item implements Serializable {

    String text;

    public Item(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
