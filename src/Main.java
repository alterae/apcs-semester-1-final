import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// THIS PROJECT PROBABLY NEEDS A RECENT-ISH JAVA VERSION TO WORK.
// I suggest 16 or 17
public class Main {
    public static void main(String[] args) {
        do {
            // If you understand the reference, congrats.
            final Frog[] frogs = {
                    new Frog("Sprig"),
                    new Frog("Hop Pop"),
                    new Frog("Polly")
            };

            // Foreach loop because we don't care about the index.
            for (var frog : frogs) {
                frog.jump(5);
                // Not printing the total here because the jump method does that
                // on its own.
            }

            // Use stream witchcraft to find the frog with the most jumps by
            // comparing their distance (passing the getDistance method itself)
            // and finding the maximum of that.
            // We then call get because that stream operation returns an
            // Optional which we need to unwrap.
            var winner = Arrays
                    .stream(frogs)
                    .max(Comparator.comparing(Frog::getDistance))
                    .get();

            System.out.printf(
                    "The winner is %s with a total distance of %d feet!\n",
                    winner.getName(),
                    winner.getDistance()
            );

        } while (confirm("Play again?", false));
        // Use a do-while to loop if we want to play again.
    }

    // Prompts the user with the given message, falling back to the fallback
    // value if they don't answer yes or no.  Also displays a [Y/n] style prompt
    // that capitalizes the fallback value.
    @SuppressWarnings("SameParameterValue")
    private static boolean confirm(String prompt, boolean fallback) {
        // Tells the user what the default value will be.
        final var yOrN = fallback ? "[Y/n]" : "[y/N]";

        System.out.printf("%s %s ", prompt, yOrN);

        // If the input starts with a y or Y, true.  n or N, false.  Otherwise,
        // use the fallback value.
        return switch (new Scanner(System.in).nextLine().toLowerCase().charAt(0)) {
            case 'y' -> true;
            case 'n' -> false;
            default -> fallback;
        };
    }
}
