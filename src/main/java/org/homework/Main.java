package org.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public enum ToDoSelect {
        ADD(1),
        DELETE(2),
        REFER(3),
        END(4);

        private int select;

        private ToDoSelect(int select) {
            this.select = select;
        }

        public int getSelect() {
            return select;
        }
    }


    public static void main(String[] args) {
        ToDoManager todoManager = new ToDoManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("1. 할 일 추가 | 2. 할 일 삭제 | 3. 할 일 목록 출력 | 4. 종료\n선택하세요: ");

            try{
                int select = scanner.nextInt();
                scanner.nextLine();

                switch (select) {
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
                        /*todoManager.printTodos();
                        break;*/
                        System.out.print("조회할 할 일의 ID를 입력하세요: ");
                        int referId = scanner.nextInt();
                        scanner.nextLine();
                        todoManager.referTodo(referId);
                        break;
                    case 4:
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    default:
                        System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("문자는 입력할 수 없습니다. 숫자를 입력해주세요.");
                scanner.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("보기에 있는 번호로 다시 선택해주세요.");
            }
        }

    }
}