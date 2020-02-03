public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        if (bigCount == 0) {
            return smallCount >= goal;
        }

        for (int i = 0; i < bigCount; i++) {
            if (goal >= 5) {
                goal -= 5;
            }
        }

        for (int i = 0; i < smallCount; i++) {
            if (goal > 0) {
                goal--;
            } else {
                break;
            }
        }

        return goal == 0;
    }
}
