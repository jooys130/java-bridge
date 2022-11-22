package bridge;

import static bridge.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String printAndRead(String printMessage) {
        System.out.println(printMessage);
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = printAndRead("다리의 길이를 입력해주세요.");
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public static void validateBridgeSize(String input) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE.toString());
        }
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE.toString());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = printAndRead("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        validateUpOrDown(moving);
        return moving;
    }

    public static void validateUpOrDown(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(MOVING_OUT_OF_RANGE.toString());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = printAndRead(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        validateRetryOrQuit(gameCommand);
        return gameCommand;
    }

    public void validateRetryOrQuit(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException(GAME_COMMAND_OUT_OF_RANGE.toString());
        }
    }
}
