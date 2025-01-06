package org.siigo.task.get;

public class Call {
    private Call(){}
    public static ConsumeServiceGet service(){
        return new ConsumeServiceGet();
    }
}
