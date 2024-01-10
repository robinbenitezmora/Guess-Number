import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.awt.event.ActionEvent; // Import the ActionEvent class
import java.awt.Font;

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
    JButton enterButton;
    JButton continueButton;
    JTextField inputText;
    JPanel gridPanel;
    int random = randomNumber.generateNumber();

    playScore = new JLabel(
        "Score: " + scoreFiles.intScore("current_score.txt") + " Games: " + scoreFiles.intScore("num_game.txt"));
    playScore.setFont(new java.awt.Font("link Free", java.awt.Font.BOLD, 30));
    playScore.setForeground(new java.awt.Color(253, 233, 180));
    playScore.setAlignmentX(CENTER_ALIGNMENT);
    playScore.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.add(playScore);

    gameText = new JLabel("Guess the Number");
    gameText.setFont(new java.awt.Font("link Free", java.awt.Font.BOLD, 30));
    gameText.setForeground(new java.awt.Color(253, 233, 180));
    gameText.setAlignmentX(CENTER_ALIGNMENT);
    gameText.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.add(gameText);

    JLabel gameText2 = new JLabel("between 1 and 10");
    gameText2.setFont(new java.awt.Font("link Free", java.awt.Font.BOLD, 30));
    gameText2.setForeground(new java.awt.Color(253, 233, 180));
    gameText2.setAlignmentX(CENTER_ALIGNMENT);
    gameText2.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.add(gameText2);

    mysteryNumber = new JLabel("?");
    mysteryNumber.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 100));
    mysteryNumber.setForeground(new java.awt.Color(0X62355F));
    mysteryNumber.setAlignmentX(CENTER_ALIGNMENT);
    mysteryNumber.setIcon(new ImageIcon("mystery_squeare.png"));
    mysteryNumber.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.add(mysteryNumber);

    statusImage = new JLabel("Input the Number");
    statusImage.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
    statusImage.setForeground(new java.awt.Color(253, 233, 180));
    statusImage.setAlignmentX(CENTER_ALIGNMENT);
    statusImage.setBorder(BorderFactory.createEmptyBorder(-10, 0, 15, 0));
    this.add(statusImage);

    gridPanel.setLayout(new GridLayout(2, 5, 10, 10));
    gridPanel.setMaximumSize(new Dimension(260, 50));
    gridPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    gridPanel.setOpaque(false);
    this.add(gridPanel);

    inputText.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
    inputText.setForeground(new java.awt.Color(0X62355F));
    inputText.setHorizontalAlignment(JTextField.CENTER);
    inputText.setBorder(BorderFactory.createEmptyBorder());
    inputText.setBackground(new java.awt.Color(253, 233, 180));
    gridPanel.add(inputText);

    continueButton = new JButton("Continue Playing?");
    continueButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(125, 95, 123), 3));
    continueButton.setBackground(new java.awt.Color(253, 233, 180));
    continueButton.setForeground(new java.awt.Color(125, 95, 123));
    continueButton.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
    continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    continueButton.setAlignmentX(CENTER_ALIGNMENT);
    continueButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    continueGame(continueButton);
    this.add(continueButton);

    JButton backButton1 = new JButton("Back to Menu");
    backButton1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(125, 95, 123), 3));
    backButton1.setBackground(new java.awt.Color(253, 233, 180));
    backButton1.setForeground(new java.awt.Color(0X62355F));
    backButton1.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
    backButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    backButton1.setAlignmentX(CENTER_ALIGNMENT);
    backButton1.setPreferredSize(new Dimension(200, 50));
    linkMenu(backButton1);
    // When user click enter button
    // Remove the duplicate declaration of inputText
    enterButton = new JButton(); // Initialize enterButton
    enterButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        changeStatus(inputText, mysteryNumber, random, statusImage, gridPanel, continueButton, backButton1);
      }
    });

    // When user hits the button key while inputting in the text field
    // ...

    // Remove the duplicate declaration of inputText
    JTextField inputText = new JTextField(); // Initialize inputText
    inputText.addActionListener(e -> {
      changeStatus(inputText, mysteryNumber, random, statusImage, gridPanel, continueButton, backButton1);
    });
  } // Close the changeStatus method

  // Define the changeStatus method
  private void changeStatus(JTextField inputText, JLabel mysteryNumber, int random, JLabel statusImage,
      JPanel gridPanel, JButton continueButton, JButton backButton1) {
    // Add your code logic here
  }

  public class Game {
    // Define the showView() method
    public void showView(Menu menu) {
      // Add your code logic here
    }
  }

  public void linkMenu(JButton jLabel) {
    jLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Want to stop the game", "Are you Sure?",
            JOptionPane.YES_NO_OPTION);
        if (dialogResult == 0) {
          scoreFiles.compareScore("high_score.txt", "current_score.txt", "num_game.txt");
          game.showView(new Menu()); // Fix: Pass 'Play.this' instead of 'game.game'
        }
      }
    });
  }

  public void continueGame(JButton jLabel) {
    jLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        game.showView(new Menu());
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(new ImageIcon("background.png").getImage(), 0, 0, null);
  }

  void changeStatusGame(JTextField input, JLabel mysterynum, int randnum, JLabel status, JPanel gridJPanel,
      JButton contButton, JButton backButton) {
    if (String.valueOf(randnum).equals(input.getText())) {
      JPanel gridPanel = new JPanel(); // Initialize gridPanel
      gridPanel.setVisible(false);

      status.setText("Correct!!!");
      status.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
      status.setForeground(new java.awt.Color(253, 233, 180));
      status.setPreferredSize(new Dimension(200, 50));

      mysterynum.setText(input.getText());

      contButton.setVisible(true);
      scoringSystem.scoreAttempt(); // Define the scoreAttempt() method in the ScoringSystem class
      scoreFiles.write("current_score.txt", scoreFiles.intScore("current_score.txt") + scoringSystem.getScore());
      scoreFiles.write("num_game.txt", scoreFiles.intScore("num_game.txt") + 1);
    } else {
      try {
        int textToint = Integer.parseInt(input.getText());
        if (textToint > 10 || textToint < 1) {
          status.setText("Please input number between 1 and 10");
          status.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
          status.setForeground(new java.awt.Color(253, 233, 180));
          status.setPreferredSize(new Dimension(200, 50));
        } else if (textToint > randnum) {
          status.setText("Too High");
          status.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
          status.setForeground(new java.awt.Color(253, 233, 180));
          status.setPreferredSize(new Dimension(200, 50));
        } else if (textToint < randnum) {
          status.setText("Too Low");
          status.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
          status.setForeground(new java.awt.Color(253, 233, 180));
          status.setPreferredSize(new Dimension(200, 50));
        }
      } catch (NumberFormatException e) {
        status.setText("Please input number between 1 and 10");
        status.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
        status.setForeground(new java.awt.Color(253, 233, 180));
        status.setPreferredSize(new Dimension(200, 50));
      }
    }
    input.setText("");
    scoringSystem.incrementAttempt();
  }
}

class ScoringSystem {
  int score, attempts;

  public ScoringSystem() {
    this.attempts = 1;
  }

  public void incrementAttempt() {
  }

  public int getScore() {
    return 0;
  }

  public void scoreAttempt() {
  }
}
