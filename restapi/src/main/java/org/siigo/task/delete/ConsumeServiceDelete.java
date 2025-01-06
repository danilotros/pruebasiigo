package org.siigo.task.delete;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.siigo.interactions.DeleteRequest;

public class ConsumeServiceDelete {
    public Performable apiDelete(String request,String typeContent){
        return Task.where("{0} call the service at execute DELETE",
                DeleteRequest.params(request, typeContent)
        );
    }
}
