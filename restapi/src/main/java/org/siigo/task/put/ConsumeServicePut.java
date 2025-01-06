package org.siigo.task.put;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.siigo.interactions.GetRequest;
import org.siigo.interactions.PutRequest;

public class ConsumeServicePut {
    public Performable agiPut(String bodyRequest,String request,String typeContent){
        return Task.where("{0} call the service at execute PUT",
                PutRequest.params(bodyRequest,request, typeContent)
        );
    }
}
