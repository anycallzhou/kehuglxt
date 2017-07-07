package CustomerService;
import dao.*;
import domain.Customer;
/**
 * Created by liunian on 2017/7/5.
 */
public class CustomerService {
    private  CustomerDao dao = new CustomerDao();
    public void add(Customer customer){
        dao.add(customer);

    }
}
