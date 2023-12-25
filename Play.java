import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class Play extends JPanel {
 final Game game;

 RandomNumber randomNumber = new RandomNumber();

 ScoringSystem scoringSystem = new ScoringSystem();

 ScoreFiles scoreFiles = new ScoreFiles();

 public Play(Game game) {
  this.game = game;

  // Layout to be used in this panel
  BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
  this.setLayout(boxlayout);
  createGUI();
 }

 private void createGUI() {
  JLabel playScore;
  JLabel gameText;
  JLabel mysteryNumber;
  JLabel statusImage;

  playScore = new JLabel(
    "Score: " + scoreFiles.intScore("current_score.txt") + " Games: " + scoreFiles.intScore("num_game.txt"));
  playScore.setFont(new Font("Arial", Font.PLAIN, 20));
  playScore.setForeground(Color.WHITE);
  playScore.setAlignmentX(CENTER_ALIGNMENT);
  playScore.setBorder(new EmptyBorder(10, 10, 10, 10));
  this.add(playScore);
 }
}