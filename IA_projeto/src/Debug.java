import luigi.MarioUtils;
import luigi.Request;
import luigi.RunResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Debug {
    public static void main(String[] args) {
        MarioUtils marioUtils = new MarioUtils("192.168.1.77");
        List<Integer> left = Collections.nCopies(10, 6);
        List<Integer> right = Collections.nCopies(60, 1);
        List<Integer> jump = Collections.nCopies(2, 5);
        List<Integer> noon = Collections.nCopies(400, 0);
        List<Integer> inputs = new ArrayList<>();
        for(int i = 0; i < 1; i++){
            inputs.addAll(right);
            inputs.addAll(jump);
            inputs.addAll(right);
//            inputs.addAll(left);
            inputs.addAll(noon);
        }
        Integer[] commandList = new Integer[inputs.size()];
        commandList = inputs.toArray(commandList);
        Request request = new Request(commandList, "SuperMarioBros-1-1-v1", "true");
        RunResult result = marioUtils.goMarioGo(request, 8080);
        System.out.println(result);
    }
}
