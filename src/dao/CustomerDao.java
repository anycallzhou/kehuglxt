package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Customer;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by liunian on 2017/7/5.
 */
public class CustomerDao
{
    private TxQueryRunner query =new TxQueryRunner();


    public void add(Customer customer){
        try {
            String sql = "insert into t_customer values (?,?,?,?,?,?)";
            Object[] params = {customer.getId(),customer.getName(),customer.getGender(),customer.getPhone(),customer.getEmail(),customer.getDescription()};
             query.update(sql,params);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }


    }
}
