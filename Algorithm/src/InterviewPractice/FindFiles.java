package InterviewPractice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {

    public List<File> findFiles(String directory){
        List<File> res = new ArrayList<>();
        findFiles(directory, res, 0);
        return res;
    }
    public List<File> findFiles(String directory, List<File> res,int depth){
        File dir = new File(directory);
        File[] files = dir.listFiles();
        for(File fileOrDir:files){
            if(fileOrDir.isFile()){
                res.add(fileOrDir);
                for (int i = 0; i <= depth; i++) {
                    System.out.print("----");
                }
                System.out.println(fileOrDir);
            }else{
                for (int i = 0; i <= depth; i++) {
                    System.out.print("----");
                }
                System.out.println(fileOrDir);
                findFiles(fileOrDir.toString(), res, depth + 1);
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        FindFiles solver = new FindFiles();
        List<File> files = solver.findFiles("G:\\课程\\计算机组成原理");
//        for(File file:files){
//            System.out.println(file.toString());
//        }
    }
}
