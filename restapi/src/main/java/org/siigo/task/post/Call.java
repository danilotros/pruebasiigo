package org.siigo.task.post;



public class Call {
    private Call(){}
    public static ConsumeServicePost service(){
        return new ConsumeServicePost();
    }
}
