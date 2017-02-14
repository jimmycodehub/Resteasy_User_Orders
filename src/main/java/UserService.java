import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class UserService {

        private static Map<String, User> users = new HashMap<String, User>();
        private static ArrayList<Order> orders = new ArrayList<Order>();

        static {

            User user1 = new User();
            user1.setUserId("1");
            user1.setAddress("Dublin 8");
            user1.setName("Jimmy");
            user1.setAge(26);
            user1.setMobile("12345678");
            users.put(user1.getUserId(), user1);

            User user2 = new User();
            user2.setUserId("2");
            user2.setAddress("Dublin 15");
            user2.setName("Tommy");
            user2.setAge(30);
            user2.setMobile("87654321");
            users.put(user2.getUserId(), user2);

            User user3 = new User();
            user3.setUserId("3");
            user3.setAddress("Dublin 18");
            user3.setName("Jenny");
            user3.setAge(22);
            user3.setMobile("085124321");
            users.put(user3.getUserId(), user3);

            User user4 = new User();
            user4.setUserId("4");
            user4.setAddress("Dublin 10");
            user4.setName("Bemi");
            user4.setAge(35);
            user4.setMobile("089654321");
            users.put(user4.getUserId(), user4);

            Order order1 = new Order();
            order1.setOrderId("1");
            order1.setSandwichType("Bagel");
            orders.add(order1);

            Order order2 = new Order();
            order2.setOrderId("2");
            order2.setSandwichType("Panini");
            orders.add(order2);

            Order order3 = new Order();
            order3.setOrderId("3");
            order3.setSandwichType("Breakfast Roll");
            orders.add(order3);

            Order order4 = new Order();
            order4.setOrderId("4");
            order4.setSandwichType("Ham and Cheese Crossant");
            orders.add(order4);

            Order order5 = new Order();
            order5.setOrderId("5");
            order5.setSandwichType("Club Sandwich");
            orders.add(order5);

        }

        @GET
        @Path("/hello")
        @Produces("text/plain")
        public String hello(){
            return "Hello World";
        }

        @GET
        @Path("/echo/{message}")
        @Produces("text/plain")
        public String echo(@PathParam("message")String message){
            return message;
        }

        @GET
        @Path("/users")
        @Produces("application/xml")
        public List<User> listUsers(){
            return new ArrayList<User>(users.values());
        }

        @GET
        @Path("/orders")
        @Produces("application/xml")
        public List<Order> listOrders(){
            return new ArrayList<Order>(orders);
        }

        @GET
        @Path("/user/{userId}")
        @Produces("application/xml")
        public User getUser(@PathParam("userId")String userId){
            return users.get(userId);
        }

        @GET
        @Path("/json/users")
        @Produces("application/json")
        public List<User> listUsersJSON(){
            return new ArrayList<User>(users.values());
        }

        @GET
        @Path("/json/user/{userId}")
        @Produces("application/json")
        public User getUserJSON(@PathParam("userId")String userId){
            return users.get(userId);
        }

        @GET
        @Path("/json/userOrder/{userId}/{orderId}")
        @Produces("application/json")
        public User getUserOrderJSON(@PathParam("userId")String userId, @PathParam("orderId")String orderId){

            int correctOrder = Integer.parseInt(orderId);
            Order order = orders.get(correctOrder-1);

            User user = users.get(userId);
            user.setOrder(order);

            users.put(userId, user);

            return users.get(userId);
        }

}