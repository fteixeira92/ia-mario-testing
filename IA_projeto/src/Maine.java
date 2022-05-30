/*
import luigi.MarioUtils;
import luigi.Request;
import luigi.RunResult;
import java.util.ArrayList;
import java.util.Random;

public class Maine
{
final static int POPULATION_MAX = 1500;
    final static double MUTATION_RATE = 0.01;
    final static double CROSSOVER_RATE = 0.95;
    final static int ELITISM = 3;

    private static Request generateRandomSolution(int size)
    {
        Integer[] buttons = new Integer[]{3,4};

        ArrayList<Integer> commands = new ArrayList<Integer>();
        for(int i=0;i<size;i++)
        {
            int comando = buttons[new Random().nextInt(2)];
            int length = new Random().nextInt(5) + 5;
            for (int j=0;j<length;j++)
            {
                commands.add(comando);
                //System.out.print(","+commands.get(commands.size() - 1));
            }
        }

        Integer[] solution = new Integer[commands.size()];
        for (int i=0;i<commands.size();i++)
            solution[i] = commands.get(i);

        System.out.println("\nSolution lenght: "+commands.size());

        return new Request(solution, "SuperMarioBros-3-2-v0", "true");
    }

    private static Integer[] generateRandomSolutionInteger(int size, int offset, Integer[] goodPath)
    {
        //opçoes todas
        //Integer[] buttons = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11};

        //opçoes sem andar para esquerda
        Integer[] buttons = new Integer[]{0,1,2,3,4,5,10,11};

        ArrayList<Integer> commands = new ArrayList<Integer>();
        for(int i=0;i<size;i++)
        {
            int comando = buttons[new Random().nextInt(8)];

                commands.add(comando);
                System.out.print(","+commands.get(commands.size() - 1));

        }

        Integer[] solution = new Integer[commands.size()+offset];

        if(offset > 0){
            for (int x=0;x<offset;x++)
                solution[x] = goodPath[x];
        }

        for (int i=0;i<commands.size();i++)
            solution[i+offset] = commands.get(i);

        System.out.println("\nSolution lenght: "+commands.size());

        return solution;
    }

    private static Request generateSolution(Integer[] solution )
    {
        return new Request(solution, "SuperMarioBros-3-2-v0", "true");
    }

    public static void main(String[] args) {

        int generation = 0;

        Integer[] solution = generateRandomSolutionInteger(2000,0,null);
        Algoritmo ga = new Algoritmo(solution.length, MUTATION_RATE,
                CROSSOVER_RATE, ELITISM);
        Generation population = ga.initPopulation(10);
        MarioUtils mu = new MarioUtils("192.168.1.76");
        RunResult res =  mu.goMarioGo(generateSolution(solution),8080);
        res.getReason_finish();
        ga.evalPopulation(population, res.getScore(), solution);

        do {
            res = mu.goMarioGo(generateSolution(solution),8080);
            System.out.println(res.getCommands_used()-25);

            population = ga.mutate(population);
            ga.evalPopulation(population, res.getScore(), solution);
            generation++;

            System.out.println("Gen ("+ generation + " best individual "+ population.getFittest(0).toString() + " Population Fitness: "+population.getPopulationFitness());

        } while(!ga.isTerminationConditionMet(population));


        System.out.println("found a solution after "+ generation + " generation");
        System.out.println("Best solution " + population.getFittest(0).toString());
    }

}
*/
