package git;
import java.util.Scanner;

public class EncryptionFunction {
    public static void main(String[] args) {
        int tpm;
        System.out.println("=========================");
        System.out.println("   欢迎使用密码管理系统   ");
        System.out.println("=========================");
        System.out.println("   请选择操作:   ");
        System.out.println("1.加密 2.解密 3.判断密码强度 4. 密码生成 5. 退出");
        System.out.println("   请选择序号:   ");
        Scanner sc = new Scanner(System.in);
        tpm = sc.nextInt();

        if (tpm == 1) {
            Scanner sc1 = new Scanner(System.in);
            System.out.print("请输入要加密的字符串：");
            String input = sc1.nextLine();
            String string = jiami(input);
            System.out.println("加密后的字符串：" + string);
        }

        if (tpm == 2) {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("请输入要解密的字符串：");
            String input = sc2.nextLine();
            String string = jiemi(input);
            System.out.println("解密后的字符串：" + string);
        }

    }

    //加密函数
    public static String jiami(String str1) {
        StringBuilder string = new StringBuilder();
        int offset = 4;
        int length = str1.length();

        // 将每个字符的ASCII码加上它在字符串中的位置和偏移值
        for (int i = 0; i < length; i++) {
            char c = str1.charAt(i);
            int ascii = c + i + offset;
            string.append((char) ascii);
        }

        // 将字符串的第一位和最后一位调换顺序
        if (length >= 2) {
            char firstChar = string.charAt(0);
            char lastChar = string.charAt(length - 1);
            string.setCharAt(0, lastChar);
            string.setCharAt(length - 1, firstChar);

        }

        // 将字符串反转
        string.reverse();

        return string.toString();
    }

    //解密函数
    public static String jiemi(String str2) {
        StringBuilder string = new StringBuilder();
        int offset = 4;
        int length = str2.length();

        // 将字符串反转
        str2 = new StringBuilder(str2).reverse().toString();

        // 将字符串的第一位和最后一位调换顺序
        if (length >= 2) {
            char firstChar = str2.charAt(length - 1);
            char lastChar = str2.charAt(0);
            str2 = str2.substring(1, length - 1);
            str2 = lastChar + str2 + firstChar;
        }

        // 将每个字符的ASCII码减去它在字符串中的位置和偏移值
        for (int i = 0; i < length; i++) {
            char c = str2.charAt(i);
            int ascii = c - i - offset;
            string.append((char) ascii);
        }

        return string.toString();
    }
}