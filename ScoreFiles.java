import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreFiles {

 public String showScore(String filename) {
  String score = "0";
  try {
   File file = new File(filename);
   Scanner scanner = new Scanner(file);
   while (scanner.hasNextLine()) {
    score = scanner.nextLine();
   }
   scanner.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  return score;
 }

 public String showGames(String filename) {
  String attempt = "0";
  try {
   File file = new File(filename);
   Scanner scanner = new Scanner(file);
   while (scanner.hasNextLine()) {
    attempt = scanner.nextLine();
   }
   scanner.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  return attempt;
 }

 public int intScore(String filename) {
  return Integer.parseInt(showScore(filename));
 }

 public int intGames(String filename) {
  return Integer.parseInt(showGames(filename));
 }

 public void write(String filename, int score) {
  try {
   java.io.FileWriter myWriter = new java.io.FileWriter(filename);
   myWriter.write(String.valueOf(score));
   myWriter.close();
  } catch (java.io.IOException e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
  }
 }

 public void writeScoreAttempts(String filename, int score, int attempts) {
  try {
   java.io.FileWriter myWriter = new java.io.FileWriter(filename);
   myWriter.write(String.valueOf(score));
   myWriter.write("\n");
   myWriter.write(String.valueOf(attempts));
   myWriter.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  } catch (java.io.IOException e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
  }
 }

 public void compareScore(String high_score, String current_score, String current_played_games) {
  if (intScore(high_score) < intScore(current_score)) {
   writeScoreAttempts(high_score, intScore(current_score), intScore(current_played_games));
  } else if (intScore(high_score) == intScore(current_score)) {
   // ATTEMPTION
   if (intGames(high_score) > intGames(current_played_games)) {
    writeScoreAttempts(high_score, intScore(current_score), intScore(current_played_games));
   }
  }
 }

}
