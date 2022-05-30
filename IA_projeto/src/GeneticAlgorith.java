import luigi.MarioUtils;
import luigi.Request;
import luigi.RunResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorith {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private final int POPULATION_SIZE = 25;
    private final int SELECTION_SIZE = 3;
    private final double MUTATION_RATE = 0.03;
    private int genCount = 0;

    private final MarioUtils marioUtils;

    public GeneticAlgorith() {
        marioUtils = new MarioUtils("192.168.1.77");
    }

    public void run() {
        //Generate first generation with random individuals
        Population population = new Population(POPULATION_SIZE);

        while (true) {
            processPopulation(population);
            population = new Population(population.getIndividuals(), population.getGeneration());
            evolve(population);
        }
    }

    private void evolve(Population population) {
        int current = 0;
        for (int i = SELECTION_SIZE; i < POPULATION_SIZE; i++) {
            Individual individual = new Individual(mutateIndividual(population.getIndividuals().get(current)));
            population.setIndividual(individual, i);
            current++;
            if (current >= SELECTION_SIZE) {
                current = 0;
            }
        }
    }

    private List<Command> mutateIndividual(Individual individual) {
        List<Command> commandList = individual.getGenes();
        Individual newIndividual = new Individual(commandList);
        for (int i = 0; i < commandList.size(); i++) {
            if (Math.random() < MUTATION_RATE) {
                newIndividual.setGene(i, new Command());
            }
        }
        return newIndividual.getGenes();
    }

    private void processPopulation(Population population) {
        int index = 0;
//        population.getIndividuals().forEach(individual -> {
        for (Individual individual : population.getIndividuals()) {
            Integer[] commandList = commandListToArray(individual.getGenes());
            RunResult result = marioUtils.goMarioGo(generateServerRequest(commandList, "false"), 8080);
            individual.setFitness(calculateFitness(result));
            System.out.println("Fitness " + index + ": " + decimalFormat.format(individual.getFitness()));
            System.out.println("Reason: " + result.getReason_finish());
            System.out.println("Position: " + result.getX_pos());
            index++;
        }
        population.sortPopulation();
        System.out.println("Gen " + population.getGeneration() + " fittest fitness: "
                + decimalFormat.format(population.getIndividuals().get(0).getFitness()));
        if (genCount == 2) {
            genCount = 0;
            Integer[] commandList = commandListToArray(population.getIndividuals().get(0).getGenes());
            RunResult result = marioUtils.goMarioGo(generateServerRequest(commandList, "true"), 8080);
            System.out.println(result);
        }
        genCount++;
    }

    private Request generateServerRequest(Integer[] commandList, String render) {
        return new Request(commandList, "SuperMarioBros-1-1-v0", render);
    }

    private Integer[] commandListToArray(List<Command> commands) {
        List<Integer> commandInputs = new ArrayList<>();
        commands.forEach(command -> {
            commandInputs.addAll(command.getInputs());
        });
        Integer[] inputs = new Integer[commandInputs.size()];
        return commandInputs.toArray(inputs);
    }

    public double calculateFitness(RunResult result) {
        double fitness = (double) result.getX_pos() * result.getX_pos() / result.getCommands_used();
//        return fitness;
        return (double) result.getX_pos() / 125 + fitness / 10;

    }
}
