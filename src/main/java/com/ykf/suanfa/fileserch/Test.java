package com.ykf.suanfa.fileserch;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Test {

    private static final String PATH = "D:\\文件下载\\123123\\163com";// 检索目录
    private static final List<String> suffixList = new ArrayList<>();// 需要统计的文件名后缀
    private static final Set<File> fileList = new HashSet<>();// 匹配的文件名
    private static final String content = "312873078";// 需要查找的内容
    private static int fileCount = 0;

    static {
        suffixList.add("txt");// 从后缀为.setting的文件中进行查找
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        File file = new File(PATH);
        getAllFile(file);
        if (fileList != null && fileList.size() > 0) {
            System.out.println("一共查询 "+fileCount+" 个文件");
            System.out.println("含有 " + content + " 内容的文件如下：");
            for (File f : fileList) {
                System.out.println(f.getAbsolutePath());
            }
        } else {
            System.err.println("无文件含有 " + content + " 内容");
        }
        long e = System.currentTimeMillis();
        System.out.println("\n总耗时：" + (e - s));
    }

    public static void getAllFile(File file) {
        BufferedReader br = null;
        String s = null;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                getAllFile(f);
            }
        } else {
            if (file.getName().indexOf(".") != -1) {
                String suffix = file.getName().substring(
                        file.getName().lastIndexOf(".") + 1);
                if (suffixList.contains(suffix)) {
                    fileCount++;
                    try {
                        br = new BufferedReader(new FileReader(file));
                        while ((s = br.readLine()) != null) {
                            if (s.contains(content)) {
                                System.out.println(s);
                                fileList.add(file);
                                break;
                            }
                        }
                        br.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
