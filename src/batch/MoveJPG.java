package batch;

import java.io.File;

public class MoveJPG {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 63; i < 64; i++) {
            for (int j = 2000 * (i - 1) + 1; j <= 2000 * i; j++) {
                try {
                    File afile = new File("D:\\yazhou\\" + String.valueOf(j) + ".jpg");
                    if (afile.renameTo(new File("D:\\yazhou\\" + String.valueOf(i) + "\\" + afile.getName()))) {
                        System.out.println("File is moved successful!");
                    } else {
                        System.out.println("File is failed to move!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // try {
        // File afile = new File("D:\\0.jpg");
        // if (afile.renameTo(new File("D:\\LY\\" + afile.getName()))) {
        // System.out.println("File is moved successful!");
        // } else {
        // System.out.println("File is failed to move!");
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // String dir = "D:\\yazhou\\3";
        // for (int i = 52; i < 64; i++) {
        // dir = "D:\\yazhou\\" + String.valueOf(i);
        // MoveJPG.createDir(dir);
        // }

    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        // 创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }

}
