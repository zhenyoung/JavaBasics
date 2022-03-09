package pers.yangzhen.io.iostream.bufferedstreamexercise;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 获取文本上字符出现的次数，把数据写入文件
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中，键存字符，值存出现次数
 * 3.把map中的数据写入文件
 */
public class WordCount {
    @Test
    public void test() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            // 键为字符，值为该字符出现次数，
            Map<Character, Integer> map = new HashMap<>();
            bufferedReader = new BufferedReader(
                    new FileReader("./src/pers/yangzhen/io/iostreamfiles/《活着》节选.txt"));
            bufferedWriter = new BufferedWriter(
                    new FileWriter("./src/pers/yangzhen/io/iostreamfiles/《活着》节选WordCount.txt"));
            // 遍历每一个字符,每一个字符出现的次数放到 map 中
            int c;
            while ((c = bufferedReader.read()) != -1) {
                // int 还原 char
                char ch = (char) c;
                // 判断 char 是否在 map 中第 1 次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            // 遍历 map ，再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bufferedWriter.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bufferedWriter.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bufferedWriter.write("回车=" + entry.getValue());
                        break;
                    case '\n':
                        bufferedWriter.write("换行=" + entry.getValue());
                        break;
                    default:
                        // 其他字符直接打印出来
                        bufferedWriter.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
