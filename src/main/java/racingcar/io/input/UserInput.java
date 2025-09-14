package racingcar.io.input;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private UserInput() {}

    public static String participants() {
        return inputFrom(GuideMessage.FOR_RACING_CAR_NAMES);
    }

    public static String lapCount() {
        return inputFrom(GuideMessage.FOR_TRYING_COUNT);
    }

    private static String inputFrom(GuideMessage guidemessage) {
        System.out.println(guidemessage.get());
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }

    private enum GuideMessage {
        FOR_RACING_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        FOR_TRYING_COUNT("시도할 횟수는 몇 회인가요?");

        final String message;

        GuideMessage(String message) {
            this.message = message;
        }

        String get() {
            return message;
        }
    }
}
