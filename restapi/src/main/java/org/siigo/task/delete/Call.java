package org.siigo.task.delete;

public class Call {
    private Call(){}
    public static ConsumeServiceDelete service(){
        return new ConsumeServiceDelete();
    }
}
