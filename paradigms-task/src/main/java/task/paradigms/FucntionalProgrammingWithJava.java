package task.paradigms;

import java.util.function.Consumer;
import java.util.function.Function;

public class FucntionalProgrammingWithJava {
    public static void main(String[] args) {
        toTitleTest();
        greetUser("Youssef", (s)-> System.out.println("We are glad to have you!"));
        
        Function<String, String> formatter = createFormatter("Mr. ");
        System.out.println(formatter.apply("John"));
    }
    
    // Assigning functions to variables
    public static void toTitleTest()
    {
        Function<String, String> toTitle = (s) -> s == null || s.isEmpty() ? s 
        : s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        
        
        System.out.println(toTitle.apply("hello world"));
    }
    
    // Functions as arguments
    public static void greetUser(String name, Consumer<String> callback)
    {
        System.out.println("Welcome " + name + "!");
        callback.accept(name);
    }

    // Functions as return type
    public static Function<String, String> createFormatter(String prefix)
    {
        return (name) -> prefix + name;
    }
}