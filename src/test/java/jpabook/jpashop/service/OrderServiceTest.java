package jpabook.jpashop.service;

import jpabook.jpashop.MemberRepository;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void 상품주문() throws Exception {
        //given
        Member member = new Member();
        member.setAddress(new Address("이매동", "12345","판교로"));
        member.setUsername("pcs");
        Item item = new Book();
        item.setName("JPA기초");
        item.setPrice(10000);
        /*item.set


        OrderItem.createOrderItem(item,item.getPrice());
        Order order = order.createOrder();*/

        //when

        //then
    }

    @Test
    public void 주문취소() throws Exception {
        //given

        //when

        //then
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //given

        //when

        //then
    }

}