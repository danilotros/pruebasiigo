package org.siigo.task.post;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.siigo.interactions.GetRequest;
import org.siigo.interactions.PostRequest;

public class ConsumeServicePost {
    public Performable apiPost(String bodyRequest, String request, String typeContent){
        return Task.where("{0} call the service at execute POST",
                PostRequest.params(bodyRequest,request,typeContent)
        );
    }
}
