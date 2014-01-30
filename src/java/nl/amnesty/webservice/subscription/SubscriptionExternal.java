package nl.amnesty.webservice.subscription;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import nl.amnesty.crm.entity.Channel;
import nl.amnesty.crm.entity.Product;
import nl.amnesty.crm.entity.Role;
import nl.amnesty.crm.entity.Subscription;
import nl.amnesty.crm.persistence.EMRole;
import nl.amnesty.crm.persistence.EMSubscription;

/**
 *
 * @author evelzen
 */
@WebService()
@Stateless()
public class SubscriptionExternal {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public long add(@WebParam(name = "producttype") String producttype,
            @WebParam(name = "productname") String productname,
            @WebParam(name = "sourcecode") String sourcecode,
            @WebParam(name = "roleid") long roleid) {
        Product product = new Product();
        if (producttype==null) {
            producttype="";
        }
        if (productname==null) {
            productname="";
        }
        product.setType(producttype.replace(";", "").replace("&", "").replace("%", ""));
        product.setName(productname.replace(";", "").replace("&", "").replace("%", ""));

        EMSubscription emsubscription = new EMSubscription();
        Subscription subscription = new Subscription(0, "", null, null, 0, Channel.MEDIATYPE_EMAIL, 0, roleid, product.getIdViaName());
        subscription = emsubscription.persist(subscription);
        if (subscription == null) {
            return 0;
        } else {
            return subscription.getSubscriptionid();
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addviaemail")
    public long addviaemail(@WebParam(name = "producttype") String producttype,
            @WebParam(name = "productname") String productname,
            @WebParam(name = "sourcecode") String sourcecode,
            @WebParam(name = "roleemail") String roleemail) {
        EMRole emrole = new EMRole();
        Role rolefound = emrole.roleReadViaEmail(roleemail.replace(";", "").replace("&", "").replace("%", ""));
        if (rolefound == null) {
            return 0;
        }
        Product product = new Product();
        product.setType(producttype.replace(";", "").replace("&", "").replace("%", ""));
        product.setName(productname.replace(";", "").replace("&", "").replace("%", ""));

        EMSubscription emsubscription = new EMSubscription();
        Subscription subscription = new Subscription(0, "", null, null, 0, Channel.MEDIATYPE_EMAIL, 0, rolefound.getRoleid(), product.getIdViaName());
        subscription = emsubscription.persist(subscription);

        if (subscription == null) {
            return 0;
        } else {
            return subscription.getSubscriptionid();
        }
    }
}
