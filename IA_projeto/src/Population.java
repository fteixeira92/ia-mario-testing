import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {
    private final int INDIVIDUAL_MIN_SIZE = 500;
    private final int INDIVIDUAL_MAX_SIZE = 1500;
    private final int INDIVIDUAL_SIZE = 175;

    private List<Individual> individuals;
    private int generation;

    public Population() {
        individuals = new ArrayList<>();
        generation = 0;
    }

    /**
     * Generates random population with the given size
     *
     * @param populationSize
     */
    public Population(int populationSize) {
        individuals = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            individuals.add(generateRandomIndividual());
        }
        generation = 0;
    }

    public Population(List<Individual> individuals, int previousGen) {
        this.individuals = cloneIndividuals(individuals);
        this.generation = previousGen + 1;
    }


    public void addIndividual(Individual individual) {
        individuals.add(individual);
    }

    public void setIndividual(Individual individual, int position) {
        this.individuals.set(position, individual);
    }

    public void removeIndividual(int index) {
        individuals.remove(index);
    }

    public int getGeneration() {
        return generation;
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public void sortPopulation() {
        this.individuals.sort(Collections.reverseOrder());
    }

    public Individual generateRandomIndividual() {
        Individual individual = new Individual();
        for (int i = 0; i < INDIVIDUAL_SIZE; i++) {
            individual.addValue(new Command());
        }
        return individual;
    }

    private int getRandomIndividualSize() {
        return Utils.getRandomNumberInRange(INDIVIDUAL_MIN_SIZE, INDIVIDUAL_MAX_SIZE);
    }

    private List<Individual> cloneIndividuals(List<Individual> individuals) {
        List<Individual> newIndividuals = new ArrayList<>();
        individuals.forEach(individual ->
                newIndividuals.add(new Individual(individual.getGenes(), individual.getFitness()))
        );
        return newIndividuals;
    }
}
