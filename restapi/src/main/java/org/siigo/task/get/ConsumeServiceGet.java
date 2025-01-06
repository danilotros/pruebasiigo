package org.siigo.task.get;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.siigo.interactions.GetRequest;

public class ConsumeServiceGet {
    public Performable agiget(String request,String typeContent){
        return Task.where("{0} call the service at execute GET",
                GetRequest.params(request, typeContent)
        );
    }
}
