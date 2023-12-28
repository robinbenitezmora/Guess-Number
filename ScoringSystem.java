
public class ScoringSystem {
 int score, attempts;

 public ScoringSystem() {
  this.attempts = 1;
 }

 public void scoreAttempt() {
  if (this.attempts == 1) {
   this.score += 10;
  } else if (this.attempts == 2) {
   this.score += 5;
  } else if (this.attempts == 3) {
   this.score += 2;
  } else if (this.attempts == 4) {
   this.score += 1;
  } else {
   this.score += 0;
  }
 }

 public int getScore() {
  return score;
 }

 public int getAttempts() {
  return attempts;
 }

 public void incrementAttempt() {
  this.attempts++;
  if (this.attempts > 5) {
   this.attempts = 5;
  }
  System.out.println(this.attempts);
  System.out.println(this.score);
  System.out.println(" ");
 }

}
