/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.amnesty.webservice.subscription;

import java.util.Calendar;
import java.util.Date;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import nl.amnesty.crm.entity.Product;
import nl.amnesty.crm.entity.Role;
import nl.amnesty.crm.entity.Subscription;

/**
 *
 * @author ed
 * algemene webservices uitgezet uit beveiligingsoogpunt
 */
@WebService()
@Stateless()
public class SubscriptionCRUD {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dummy")
    public String dummy() {
        //TODO write your implementation code here:
        return null;
    }
    /**
     * Web service operation
     
    @WebMethod(operationName = "create")
    public long create(@WebParam(name = "Role") Role role,
            @WebParam(name = "Product") Product product,
            @WebParam(name = "Startdate") Date startdate,
            @WebParam(name = "Enddate") Date enddate) {
        //TODO write your implementation code here:
        long subscriptionid = 123456789;
        return subscriptionid;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "read")
    public Subscription read(@WebParam(name = "Subscriptionid") long subscriptionid) {
        //TODO write your implementation code here:
        Subscription subscription = new Subscription();
        subscription.setStartdate(Calendar.getInstance().getTime());
        subscription.setEnddate(Calendar.getInstance().getTime());
        return subscription;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "update")
    public long update(long subscriptionid) {
        //TODO write your implementation code here:
        return subscriptionid;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "delete")
    public long delete(long subscriptionid) {
        //TODO write your implementation code here:
        return subscriptionid;
    }
    */

}
