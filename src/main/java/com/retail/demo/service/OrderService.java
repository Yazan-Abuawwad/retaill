package com.retail.demo.service;

import com.retail.demo.entity.OrderEntity;
import com.retail.demo.entity.enumeration.User_Type;
import com.retail.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<OrderEntity> getAllOrders() {
        return  orderRepo.findAll();
    }



    public OrderEntity calcBill(OrderEntity order){



        Double amountBill =order.getProductEntitySet().stream().mapToDouble(n->n.getPrice()).sum();
        Double  discountBill   =Double.valueOf((int)(amountBill/100 ) *5);

        switch(order.getUserEntity().getUser_type()) {
            case  EMPLOYEE:
                discountBill+=amountBill*.3;
                break;
            case  CUSTOMER:
                discountBill+=amountBill*.1;
                break;
            default:
                // code block
        }

        Double totalAmountBill=amountBill-discountBill;
        order.setAmountBill(amountBill);
        order.setDiscountBill(discountBill);
        order.setTotalAmountBill(totalAmountBill);

        return order;}



    public OrderEntity create(OrderEntity order) {


        return orderRepo.save(calcBill(order));
    }

}
