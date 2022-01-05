package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;

import javax.annotation.Nullable;

public class Delay implements IKeyword {
    @Override
    public void execute(@Nullable Object param1, @Nullable Object param2) {
        int timeOut = (Integer) param1;
        delay(timeOut);
    }

    public void delay(int timeOut){
        try {
            Thread.sleep(timeOut * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
