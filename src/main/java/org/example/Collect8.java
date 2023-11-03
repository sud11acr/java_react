package org.example;

import org.example.dto.Bill;
import org.example.dto.BillDto;
import org.example.dto.Customer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Collect8 {

    public static void main(String[] args) {
        Customer customer1= Customer.builder().id(1).name1("C1").name2("D1").name3("T1").tall(25.45).build();
        Customer customer2= Customer.builder().id(2).name1("C2").name2("D2").name3("T2").tall(36.0).build();
        Customer customer3= Customer.builder().id(3).name1("C3").name2("D3").name3("T3").tall(54.24).build();

        List<Customer> customers=new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        List<Bill> bills=new LinkedList<>();
        Bill b1=Bill.builder().id(1).document("B-1").customer(customer1).cost(100D).build();
        Bill b2=Bill.builder().id(2).document("B-2").customer(customer2).cost(500D).build();
        Bill b3=Bill.builder().id(3).document("B-3").customer(customer3).cost(300D).build();
        Bill b4=Bill.builder().id(4).document("B-4").customer(customer1).cost(125D).build();
        Bill b5=Bill.builder().id(5).document("B-5").customer(customer2).cost(200D).build();
        Bill b6=Bill.builder().id(6).document("B-6").customer(customer3).cost(275D).build();
        Bill b7=Bill.builder().id(7).document("B-7").customer(customer1).cost(150D).build();
        Bill b8=Bill.builder().id(8).document("B-8").customer(customer2).cost(200D).build();
        Bill b9=Bill.builder().id(9).document("B-9").customer(customer3).cost(150D).build();

        bills.add(b1);
        bills.add(b2);
        bills.add(b3);
        bills.add(b4);
        bills.add(b5);
        bills.add(b6);
        bills.add(b7);
        bills.add(b8);
        bills.add(b9);
        bills.stream().forEach(System.out::println);
        System.out.println("Validate");
        bills.stream().filter(f->f.getCost()<200).forEach(System.out::println);
        System.out.println("Validate 2");
        bills.stream().filter(f->f.getId()==1).filter(f->f.getCost()<220).forEach(System.out::println);

        Comparator<Bill>b45=(b111,b222)->b111.getCost().intValue()-b222.getCost().intValue();
        Optional<Bill> fmax=bills.stream().max(b45);
        //fmax.isPresent()?fmax.get():fmax.orElse(new Bill());

        System.out.println("Customers");
        bills.stream().map(p->p.getCustomer()).distinct().forEach(System.out::println);
        List<BillDto> billDtos=new ArrayList<>();
        bills.stream().map(t->BillDto.builder().id(t.getId()).customer(t.getCustomer()).document(t.getDocument()).cost(t.getCost()).build()).forEach(billDtos::add);
        List<BillDto> billDtos2= bills.stream().map(t->BillDto.builder().id(t.getId()).customer(t.getCustomer()).document(t.getDocument()).cost(t.getCost()).build()).collect(Collectors.toList());
        Map<Integer,Bill>mapa=bills.stream().collect(Collectors.toMap(r->r.getId(),f->f));
        mapa.forEach((k,v)->System.out.println(k+" : "+v));
        String txt=bills.stream().map(t->t.getCost().toString()).collect(Collectors.joining(",","numbers : ","."));
        Map<Customer,List<Bill>> rs=bills.stream().collect(Collectors.groupingBy(fra->fra.getCustomer()));
        rs.forEach((k,v)-> System.out.println(k.getId()+" : "+v));
        Map<Integer,List<Bill>> rs1=bills.stream().collect(Collectors.groupingBy(f->f.getCustomer().getId()));
        rs1.forEach((k,v)-> System.out.println(k+" : "+v));

        AtomicInteger count=new AtomicInteger(1);
        Optional<Customer> averageTall=customers.stream().reduce((p1,p2)->{
           p1.setId(0);
           p1.setName1("Person middle");
           double tallest=p1.getTall()*count.intValue()+p2.getTall();
           count.incrementAndGet();
           p1.setTall(tallest/count.intValue());
           return p1;
        });

        if(averageTall.isPresent()){
            System.out.println("middle "+averageTall.get());
        }
    }

}
