package org.homework;

import java.util.HashMap;
import java.util.Map;

public class ToDoManager {
    private Map<Integer, String> todoMap;
    private int currentId;

    public ToDoManager() {
        todoMap = new HashMap<>();
        currentId = 0;
    }

    public void addTodo(String todoContent) {
        currentId++;
        todoMap.put(currentId, todoContent);
        System.out.println("할 일이 추가되었습니다. ID: " + currentId);
    }

    public void deleteTodo(int todoId) {
        if (todoMap.containsKey(todoId)) {
            todoMap.remove(todoId);
            System.out.println("할 일이 삭제되었습니다. ID: " + todoId);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public void referTodo(int todoId) {
        if (todoMap.containsKey(todoId)) {
            String todoContent = todoMap.get(todoId);
            System.out.println("할 일 내용: " + todoContent);
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }



    /*public void printTodos() {
        if (todoMap.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
        } else {
            System.out.println("현재 등록된 할 일 목록:");
            for (Map.Entry<Integer, String> entry : todoMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", 내용: " + entry.getValue());
            }
        }
    }*/

}
