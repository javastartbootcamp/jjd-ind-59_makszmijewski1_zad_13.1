package pl.javastart.voting;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private List<Vote> votes = new ArrayList<>();

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int forVotesCounter = 0;
        int againstVotesCounter = 0;
        int refrainCounter = 0;
        double allVotesCounter = 0;
        for (Vote vote : votes) {
            if (vote.getVote() == true) {
                forVotesCounter++;
                allVotesCounter++;
            } else if (vote.getVote() == false) {
                againstVotesCounter++;
                allVotesCounter++;
            } else if (vote.getVote() == null) {
                refrainCounter++;
                allVotesCounter++;
            }
            double percentFor = forVotesCounter / allVotesCounter * 100;
            double percentAgainst = againstVotesCounter / allVotesCounter * 100;
            double percentRefrain = refrainCounter / allVotesCounter * 100;
            System.out.println("Głosów za: " + df.format(percentFor) + "%");
            System.out.println("Głosów przeciw: " + df.format(percentAgainst) + "%");
            System.out.println("Wstrzymało się: " + df.format(percentRefrain) + "%");

        }
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {

        for (Vote vote : votes) {
            if (voterName.equals(vote.getVoter())) {
                try {
                    if (vote.getVote() == true) {
                        System.out.println(vote.getVoter() + ": ZA");
                    } else if (vote.getVote() == false) {
                        System.out.println(vote.getVoter() + ": PRZECIW");
                    } else {
                        continue;
                    }
                } catch (NullPointerException e) {
                    System.out.println(vote.getVoter() + ": WSTRZYMAŁ SIĘ");
                }
            }
        }
    }
}
