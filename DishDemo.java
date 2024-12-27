package cn.tx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishDemo {

    //需要先创建菜单集合 范型
    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> personDish = new ArrayList<>();

    public static void main(String[] args) {
        //菜品
        initDish();

        //创造扫描器对象，获取控制台输入的内容
        Scanner s = new Scanner(System.in);

        //需要写一个死循环
        while (true) {
            //给客户展示主菜单
            showMenu();
            //获取内容
            int num = s.nextInt();
            //判断客户输入的数字
            switch (num) {
                case 1:
                    //展示菜单
                    while (true) {
                        showDishMenu();
                        int id = s.nextInt();
                        if (id==0){
                            break;
                        }

                        Dish dish = dishList.get(id-1);
                        System.out.println("亲，您点了："+dish.name+" 菜");
                        personDish.add(dish);
                    }
                case 2:
                    showPersonDish();
                    break;
                case 3:
                    buy();
                    return;
            }
        }
    }

    /**
     * 展示饭店菜单 序号1
     */
    public static void showDishMenu(){
        //客户已点
        System.out.println("-----请您点菜-----");
        for (int i =0; i < dishList.size(); i++){
            Dish dish = dishList.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("-----输入序号点菜，按0返回上一级-----");

    }

    /**
     * 展示已点菜单 序号2
     */
    public static void showPersonDish(){
        System.out.println("-----您已点的菜品-----");
        for (Dish dish : personDish){
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
    }

    /**
     * 展示结账 序号3
     */
    public static void buy(){
        System.out.println("-----请稍等，正在结算-----");
        double total = 0f;
        for (Dish dish : personDish){
            total += dish.price;
        }
        System.out.println("亲，您本次共消费了："+total+"元。");
    }



    /**
     * 展示主菜单
     */
    public static void showMenu(){
        System.out.println("-----主菜单-----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t\t 2");
        System.out.println("结账\t\t\t 3");
        System.out.println("-----根据编号选择服务-----");

    }

    /**
    //初始化菜品
     */
    public static void initDish(){
        dishList.add(new Dish(1,"香辣鸡腿",29.0));
        dishList.add(new Dish(2, "鱼香肉丝", 35.0));
        dishList.add(new Dish(3, "拌黄瓜", 18.0));
        dishList.add(new Dish(4, "油焖大虾", 55.0));
        dishList.add(new Dish(5, "西湖牛肉羹", 25.0));
    }
}
