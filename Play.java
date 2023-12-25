import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

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
}