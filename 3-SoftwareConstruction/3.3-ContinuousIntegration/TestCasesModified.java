import java.util.Date;
public class TestCases {
    
    public static void main(String[] args) {
        int result_1 = testSendMessage();
        String ispassed = "Passed";
        boolean isAllPassed = true;
        if(result_1 != 1){
        ispassed = "Failed";
        isAllPassed = false;
        }
        System.out.println("TC1: Очікуємий результат = 1, отриманий результат = " + result_1 + " ; " + ispassed);
        ispassed = "Passed";
        int result_2 = testSendMessageMoreThen350();
        if(result_2 != -1){
        ispassed = "Failed";
        isAllPassed = false;
        }
        System.out.println("TC2: Очікуємий результат = -1, отриманий результат = " + result_2 + " ; " + ispassed);
        ispassed = "Passed";
        int result_3 = testSendMessageEmptyText();
        if(result_3 != -1){
        ispassed = "Failed";
        isAllPassed = false;
        }
        System.out.println("TC3: Очікуємий результат = -1, отриманий результат = " + result_3 + " ; " + ispassed);
        int result_4 = testSendMessageInvalidTime();
        ispassed = "Passed";
        if(result_4 != -2){
        ispassed = "Failed";
        isAllPassed = false;
        }
        System.out.println("TC4: Очікуємий результат = -1, отриманий результат = " + result_4 + " ; " + ispassed);
        if(isAllPassed) System.exit(0);
        System.exit(-1);
    }

    public static int testSendMessage() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        int result = testCases.sendMessage("Не можу заснути, просто жесть", "testUser", new Date().getTime());

        // Печатаем результат
        return result;
    }

    public static int testSendMessageMoreThen350() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 360; i++) {
            longText.append("a");
        }
        int result = testCases.sendMessage(longText.toString(), "testUser", new Date().getTime());
        // Печатаем результат
        return result;
    }

    public static int testSendMessageEmptyText() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        int result = testCases.sendMessage("", "testUser", new Date().getTime());

        // Печатаем результат
        return result;
    }

    public static int testSendMessageInvalidTime() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        int result = testCases.sendMessage("Не можу заснути, просто жесть", "testUser", new Date().getTime() - 1);

        // Печатаем результат
        return result;
    }

    public int sendMessage(String textFieldText, String username, long currentTime) {
        // Реализация метода sendMessage без зависимостей от Android
        if (textFieldText.isEmpty() || textFieldText.length() > 350) return -1;

        // Проверка соответствия времени сообщения переданному времени
        if (currentTime != new Date().getTime()) return -2;

        return 1;
    }
}
