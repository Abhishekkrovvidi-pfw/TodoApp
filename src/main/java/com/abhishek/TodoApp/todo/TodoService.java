package com.abhishek.TodoApp.todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1 , "Abhishek" , "Learn SpringBoot" , LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2 , "Abhishek" , "Learn AWS" , LocalDate.now().plusYears(3), false));
        todos.add(new Todo(3 , "Abhishek" , "Learn SkateBoard" , LocalDate.now().plusYears(2), false));
        todos.add(new Todo(4 , "Abhishek" , "Learn Swimming" , LocalDate.now().plusYears(1), false));
    }
    private static int todosCount = todos.size();
    public List<Todo> findByUsername(String username){
        return todos;
    }
    public void addTodo(String username , String description, LocalDate targetData ,Boolean done){
        Todo todo = new Todo(++todosCount , username , description,targetData,done);
        todos.add(todo);
    }
    public void deleteTodoById(int id){
        Predicate<? super Todo> predicate = todo ->todo.getId() == id ;
        todos.removeIf(predicate);
    }
    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo ->todo.getId() == id ;
        Todo todo=todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void updateTodo(@Valid Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}
