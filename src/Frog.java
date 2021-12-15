import java.util.ArrayList;
import java.util.Random;

// Suppress the unused methods warning since we never use our setters.
@SuppressWarnings("unused")
public class Frog {
    // The name of the frog.
    private String name;
    // How far the frog has jumped.
    private int distance;

    public Frog(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void jump(int times) {
        // We're going to need a random number generator, so we just construct it
        // here for easy reuse.
        // Vars are all final because I don't need to change them
        final var rand = new Random();
        final var jumps = new ArrayList<Integer>();
        // Do this the specified number of times.
        for (int i = 0; i < times; i++) {
            // Use 6 as the bound instead of 5 because it's 0-5 INCLUSIVE.
            jumps.add(rand.nextInt(6));
        }
        // Use stream magic to sum the jumps using zero as the accumulator
        // (because summation starts at zero) and the literal Integer::sum
        // method as the operator (because we're adding).
        // Functional programming!
        // This is more or less equivalent to a for loop that just adds each
        // item to an accumulator that starts off as zero, but I prefer the
        // functional style.
        distance = jumps.stream().reduce(0, Integer::sum);
        // Print out both the individual jumps *and* the total here.
        System.out.printf(
                "Frog %s made the following jumps %s, for a total of %d feet jumped.\n",
                this.name,
                jumps,
                this.distance
        );
    }
}