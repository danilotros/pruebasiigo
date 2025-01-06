package org.siigo.task.put;

public class Call {
    private Call(){}
    public static ConsumeServicePut service(){
        return new ConsumeServicePut();
    }
}
