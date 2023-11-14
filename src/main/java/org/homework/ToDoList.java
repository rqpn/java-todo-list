package org.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToDoList {
    private Map<Integer, String> todoMap;
    private int currentId;

    public ToDoList() {
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

    public void printTodos() {
        if (todoMap.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
        } else {
            System.out.println("현재 등록된 할 일 목록:");
            for (Map.Entry<Integer, String> entry : todoMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", 내용: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        ToDoList todoManager = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("1. 할 일 추가 | 2. 할 일 삭제 | 3. 할 일 목록 출력 | 4. 종료\n선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("추가할 할 일을 입력하세요: ");
                    String todoContent = scanner.nextLine();
                    todoManager.addTodo(todoContent);
                    break;
                case 2:
                    System.out.print("삭제할 할 일의 ID를 입력하세요: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    todoManager.deleteTodo(deleteId);
                    break;
                case 3:
                    todoManager.printTodos();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}
