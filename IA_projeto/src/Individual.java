import java.util.ArrayList;
import java.util.List;

public class Individual implements Comparable<Individual> {
    private List<Command> genes;
    private double fitness;

    public Individual() {
        this.genes = new ArrayList<>();
        this.fitness = 0;
    }

    public Individual(List<Command> genes) {
        this.genes = cloneGenes(genes);
        this.fitness = 0;
    }

    public Individual(List<Command> genes, double fitness) {
        this.genes = cloneGenes(genes);
        this.fitness = fitness;
    }

    public void addValue(Command value) {
        this.genes.add(value);
    }

    public void setGene(int position, Command value) {
        this.genes.set(position, value);
    }

    public Command getGeneValue(int position) {
        return this.genes.get(position);
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    public void setGenes(List<Command> genes) {
        this.genes = genes;
    }

    public List<Command> getGenes() {
        return this.genes;
    }

    public int getIndividualLength() {
        return this.genes.size();
    }


    private List<Command> cloneGenes(List<Command> genes) {
        List<Command> newGenes = new ArrayList<>();
        genes.forEach(gene -> newGenes.add(new Command(gene)));
        return newGenes;
    }

    @Override
    public int compareTo(Individual individual) {
        return Double.compare(this.fitness, individual.getFitness());
    }
}
