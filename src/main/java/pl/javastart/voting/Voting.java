package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        VotingResult votingResult = new VotingResult();
        List<Vote> votes = new ArrayList<>();
        votingResult.setVotes(votes);

        String choice = "";
        for (String voter : voters) {
            boolean condition = true;
            System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
            while (condition) {
                choice = scanner.nextLine();
                switch (choice) {
                    case "z" -> {
                        votes.add(new Vote(voter, true));
                        condition = false;
                    }
                    case "p" -> {
                        votes.add(new Vote(voter, false));
                        condition = false;
                    }
                    case "w" -> {
                        votes.add(new Vote(voter, null));
                        condition = false;
                    }
                    default -> System.out.println("Zagłosuj jeszcze raz");
                }
            }
        }
        return votingResult;
    }

}
