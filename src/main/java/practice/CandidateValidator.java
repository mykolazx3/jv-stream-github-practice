package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int REQUIRED_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String ALLOWABLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return isOldEnough(candidate)
                && candidate.isAllowedToVote()
                && isUkrainian(candidate)
                && isLivedInUkraineEnough(candidate);
    }

    private boolean isOldEnough(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE;
    }

    private boolean isUkrainian(Candidate candidate) {
        return candidate.getNationality().equals(ALLOWABLE_NATIONALITY);
    }

    private boolean isLivedInUkraineEnough(Candidate candidate) {
        String[] periodStringArr = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(periodStringArr[1]) - Integer.parseInt(periodStringArr[0]);
        return period >= MIN_PERIOD_IN_UKRAINE;
    }
}
