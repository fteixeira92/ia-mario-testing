/*
import java.util.Random;

public class Algoritmo {

    private final int populationSize;
    private final double mutationRate; //em media vou mudar 1 = 0.01
    private final double crossoverRate; //se tiver 95 vou manter 95 da 1 implementação
    private final int elitismCount;//top 3 de algoritmos
    private Individual i;
    private int oldScore = 0;

    public Algoritmo(int populationSize, double mutationRate, double crossoverRate
            , int elitismCount){
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    //inicia a população com um numero de posições e um numero max de comandos
    public Generation initPopulation(int chromossomeLength){
        return new Generation(this.populationSize, chromossomeLength);
    }

    //aqui é onde irá calcular o nr de coins apanhadas, o score ou o speedrun, para já esta so com score
    public int calculateFitness(Individual individual){

        if(individual.getFitness() > oldScore){
            oldScore = individual.getFitness();
        }

        return oldScore;
    }

    //é para evoluir a população em si... não é totalmente necessario
    public void evalPopulation(Generation population, int score, Integer[] path){
        int populationFitness = 0;

        for (Individual individual : population.getIndividuals()){
            individual.setFitness(score);
            populationFitness = calculateFitness(individual);
            individual.setGenes(path);
        }
        population.setPopulationFitness(populationFitness);
    }

    //usado no cross ainda nao sei
    public Individual selectParent(Generation population){
        Individual[] individuals = population.getIndividuals();
        double populationFitness = population.getPopulationFitness();
        double rouletteWheelPosition = Math.random() * populationFitness;
        double spinWheel = 0;

        for (Individual individual : individuals){
            spinWheel += individual.getFitness();
            if (spinWheel >= rouletteWheelPosition) {
                return individual;
            }
        }
        return individuals[population.getPopulationSize()-1];
    }

    //este ainda nao estudei
    public Generation crossoverPopulation(Generation population){
        Generation newPopulation = new Generation(population.getPopulationSize());

        for (int populationIndex = 0; populationIndex < population.getPopulationSize(); populationIndex++){
            Individual parentA = population.getFittest(populationIndex);

            if (this.crossoverRate > Math.random()  && populationIndex > this.elitismCount){
                Individual offspring = new Individual(parentA.getIndividualLength());
                Individual parentB = selectParent(population);

                for (int geneIndex = 0; geneIndex < parentA.getIndividualLength(); geneIndex++){
                    if (0.5> Math.random()){
                        offspring.setGene(geneIndex, parentA.getGeneValue(geneIndex));
                    }else {
                        offspring.setGene(geneIndex, parentB.getGeneValue(geneIndex));
                    }
                }
                newPopulation.setIndividual(populationIndex, offspring);
            }else {
                newPopulation.setIndividual(populationIndex, parentA);
            }
        }
        return newPopulation;
    }

    //ele deve mutar através do indivio anterior a lista de comandos de forma a ir mais longe
    public Generation mutate(Generation population) {
            Generation newPopulation = new Generation(this.populationSize);

            for (int populationIndex = 0; populationIndex < population.getPopulationSize();populationIndex++){
                Individual individual = population.getFittest(populationIndex);
                int randomPosition = new Random().nextInt(population.getPopulationSize()); //posição random a alterar

                for (int geneIndex = 0; geneIndex<individual.getIndividualLength(); geneIndex++) {
                    if (this.mutationRate > Math.random()) {
                        individual.setGene(randomPosition, Utils.getRandomCommand());
                    }
                    newPopulation.setIndividual(populationIndex, individual);
                }
            }
            return newPopulation;
        }

    public boolean isTerminationConditionMet(Generation population){
        for (Individual individual : population.getIndividuals()){
            if (individual.getFitness() == 2000){
                return true;
            }
        }
        return false;
    }



}
*/
