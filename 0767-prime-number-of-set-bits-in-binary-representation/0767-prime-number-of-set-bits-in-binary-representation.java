class Solution {
    public int countPrimeSetBits(int left, int right) 
    {
        int result = 0;

        while (left <= right)
        {
            int bitCount = 0;
            int tempLeft = left;

            while (tempLeft > 0)
            {
                if (tempLeft % 2 == 1) bitCount++;

                tempLeft /= 2;
            }

            if (bitCount == 2 || bitCount == 3) result++;
            else if (bitCount != 1)
            {
                boolean prime = true;

                for (int i = 2; i <= Math.sqrt(bitCount); i++)
                {
                    if (bitCount % i == 0)
                    {
                        prime = false;
                        break;
                    }
                }

                if (prime) result++;
            } 
            
            left++;
        }

        return result;
    }
}