package InterviewPractice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {

    public List<File> findFiles(String directory){
        File dir = new File(directory);
        List<File> res = new ArrayList<>();
        File[] files = dir.listFiles();
        for(File fileOrDir:files){
//            if()
        }
        return  null;
    }
}
