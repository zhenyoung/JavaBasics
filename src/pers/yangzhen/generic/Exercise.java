package pers.yangzhen.generic;

import org.junit.Test;

import java.util.*;

/**
 * 完成以下要求：
 * 定义泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型
 * <p>
 * 创建以下方法：
 * public void save(String id,T entity)保存T类型的对象到Map成员变量中
 * public T get(String id)从map中获取id对应的对象
 * public void update(String id,T entity)替换map中key为id的内容，改为entity对象
 * public List<T> list()返回map中存放的所有T对象
 * public void delete(String id)删除指定的id对象
 * <p>
 * 定义一个User类，该类包含private成员变量（int 类型）id,age;（String类型）name
 * <p>
 * 定义一个测试类Exercise：
 * 创建DAO类的对象，分别调用其save、get、update、list、delete方法来操作User对象，使用Junit单元测试进行测试
 *
 * @author yangzhen
 * @create 2021-04-05 21:31
 */
public class Exercise {
    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"张三"));
        dao.save("1002",new User(1002,14,"李四"));
        dao.save("1003",new User(1003,24,"王五"));

        User user = dao.get("1002");
        System.out.println(user);

        dao.update("1003",new User(1003,23,"周杰伦"));
        System.out.println(dao.list());

        List<User> list = dao.list();
        System.out.println(list);

        dao.delete("1003");
        System.out.println(dao.list());

    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        //保存T类型的对象到Map成员变量中
        map.put(id, entity);
    }

    public T get(String id) {
        //从map中获取id对应的对象
        return map.get(id);
    }

    public void update(String id, T entity) {
        //替换map中key为id的内容，改为entity对象
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        //返回map中存放的所有T对象
        //下面的写法是错误的
//        Collection<T> values = map.values();
//        return (List<T>) values;//Collection values()返回类型是Collection，不能强转成其子接口的List，类似父类对象不能直接赋值给子类的引用

        //正确的写法
        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        for (T t : values) {
            list.add(t);
        }
        //也可以使用addAll()
        list.addAll(values);
        return list;
    }

    public void delete(String id) {
        //删除指定的map中id的对象
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
