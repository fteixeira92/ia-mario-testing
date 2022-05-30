import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Command {
    private List<Integer> inputs;

    /**
     * Creates random command
     */
    public Command() {
//        Integer input = Utils.getRandomNumberInRange(0, 11);
        Integer input = getNonBRandomInput();
        int repetition = Utils.getRandomNumberInRange(3, 30);
        inputs = Collections.nCopies(repetition, input);
    }

    /**
     * Creates a command with n repetitions of the given input
     *
     * @param input
     * @param repetition
     */
    public Command(Integer input, int repetition) {
        inputs = Collections.nCopies(repetition, input);
    }

    public Command(Command command) {
        this.inputs = new ArrayList<>();
        this.inputs.addAll(command.getInputs());
    }

    public List<Integer> getInputs() {
        return this.inputs;
    }

    private Integer getNonBRandomInput() {
        Integer[] inputs = {1, 2, 5, 6, 7, 10, 11};
        return inputs[Utils.getRandomNumberInRange(0, 6)];
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Command cmd)) {
            return false;
        }
        return cmd.getInputs().get(0).equals(this.inputs.get(0)) &&
                cmd.getInputs().size() == this.inputs.size();
    }
}
