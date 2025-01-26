import java.util.Scanner;

public class CommandLineCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в калькулятор командной строки!");
        System.out.println("Введите выражение в формате: операнд1 оператор операнд2 (например: 5 + 3)");
        System.out.println("Для выхода введите 'exit'.");

        while (true) {
            System.out.print("Введите выражение: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы. До свидания!");
                break;
            }

            try {
                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Неверный формат ввода. Попробуйте снова.");
                }

                double operand1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double operand2 = Double.parseDouble(parts[2]);

                double result = calculate(operand1, operator, operand2);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static double calculate(double operand1, String operator, double operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно.");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Неверный оператор: " + operator);
        };
    }
}
