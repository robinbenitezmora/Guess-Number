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
    playScore.setFont(new java.awt.Font("link Free", java.awt.Font.BOLD, 30));
    playScore.setForeground(new java.awt.Color(253, 233, 180));
    playScore.setAlignmentX(CENTER_ALIGNMENT);
    playScore.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.add(playScore);
  }

  gameText=new JLabel("Guess the Number");gameText.setFont(new java.awt.Font("link Free",java.awt.Font.BOLD,30));gameText.setForeground(new java.awt.Color(253,233,180));gameText.setAlignmentX(CENTER_ALIGNMENT);gameText.setBorder(new EmptyBorder(10,10,10,10));this.add(gameText);

  JLabel gameText2 = new JLabel(
      "between 1 and 10");gameText2.setFont(new java.awt.Font("link Free",java.awt.Font.BOLD,30));gameText2.setForeground(new java.awt.Color(253,233,180));gameText2.setAlignmentX(CENTER_ALIGNMENT);gameText2.setBorder(new EmptyBorder(10,10,10,10));this.add(gameText2);

  mysteryNumber=new JLabel("?");mysteryNumber.setFont(new java.awt.Font("MV Boli",Font.BOLD,100));mysteryNumber.setForeground(new java.awt.Color(0X62355F));mysteryNumber.setAlignmentX(CENTER_ALIGNMENT);mysteryNumber.setIcon(new ImageIcon("mystery_squeare.png"));mysteryNumber.setBorder(new EmptyBorder(10,10,10,10));this.add(mysteryNumber);

  statusImage=new JLabel("Input the Number");statusImage.setFont(new java.awt.Font("MV Boli",java.awt.Font.BOLD,30));statusImage.setForeground(new java.awt.Color(253,233,180));statusImage.setAlignmentX(CENTER_ALIGNMENT);statusImage.setBorder(BorderFactory.createEmptyBorder(-10,0,15,0));this.add(statusImage);

  gridPanel=new JPanel();gridPanel.setLayout(new GridLayout(2,5,10,10));gridPanel.setMaximumSize(new Dimension(260,50));gridPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));gridPanel.setOpaque(false);this.add(gridPanel);
}}