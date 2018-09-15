/**
 * 正整数分解质因数。
 * 12 = 2 * 2 * 3
 */
class PrimeFactor {

    private String resolvePrime(int num) {
        if (num <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= num; i++) {
            while (num != 0 && num % i == 0) {
                sb.append(i);
                num /= i;
            }
        }
        return sb.toString();
    }

    /**
     * 另一种写法。
     * 思路：只要 i <= num，就需要进行循环
     * 如果 i 能整除n，就打印i，然后更新 n = n / i;
     * 如果 i 不能整除n，就 i++
     */
    private String resolvePrime2(int num) {
        int i = 2;
        StringBuilder result = new StringBuilder();
        while (i <= num) {
            if (num % i == 0) {
                result.append(i);
                if (num != i) {
                    result.append("*");
                }
                num /= i;
            } else {
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String s = new PrimeFactor().resolvePrime(i);
            assert s.equals("23");
            System.out.println(s);
        }
    }
}
