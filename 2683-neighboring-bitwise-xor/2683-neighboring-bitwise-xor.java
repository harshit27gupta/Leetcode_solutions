class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int firstOriginalBit = 0, intermediateResult = 0;

        for (int i = 0; i < derived.length; ++i) {
            intermediateResult = firstOriginalBit ^ derived[i];
            firstOriginalBit = intermediateResult;
        }

        boolean checkForZero = (firstOriginalBit == 0);

        firstOriginalBit = 1;
        for (int i = 0; i < derived.length; ++i) {
            intermediateResult = firstOriginalBit ^ derived[i];
            firstOriginalBit = intermediateResult;
        }

        boolean checkForOne = (firstOriginalBit == 1);

        return checkForZero || checkForOne;
    }
}