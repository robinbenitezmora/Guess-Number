import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RandomNumber {
 final int min = 1, max = 10;

 public int generateNumber() {
  return (int) Math.floor(Math.random() * (max - min + 1) + min);
 }
}

class Menu extends JPanel {
 final Game game;
 ScoreFiles scoreFiles = new ScoreFiles();

 public Menu(Game game) {
  this.game = game;

  // Layout to be used in this panel
  BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
  this.setLayout(boxlayout);
  createGUI();
 }

 private void createGUI() {
  JLabel logoImage, scoreLabel, scoreText, playButton;

  logoImage = new JLabel("Guess the Number", JLabel.CENTER);
  logoImage.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
  logoImage.setForeground(new java.awt.Color(253, 233, 180));
  logoImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
  logoImage.setBorder(new EmptyBorder(10, 10, 10, 10));
  this.add(logoImage);

  scoreLabel = new JLabel("High Score", JLabel.CENTER);
  scoreLabel.setFont(new java.awt.Font("link Free", java.awt.Font.BOLD, 30));
  scoreLabel.setForeground(new java.awt.Color(253, 233, 180));
  scoreLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
  scoreLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
  this.add(scoreLabel);

  scoreText = new JLabel(
    scoreFiles.showScore("high_score.txt") + " points for" + scoreFiles.showGames("high_score.txt") + "games");
  scoreText.setFont(new java.awt.Font("MV Boli", java.awt.Font.BOLD, 30));
  scoreText.setForeground(new java.awt.Color(253, 233, 180));
  scoreText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
  scoreText.setBorder(new EmptyBorder(10, 10, 10, 10));
  this.add(scoreText);

  playButton = new JLabel("Play", JLabel.CENTER);
  playButton.setFont(new java.awt.Font("link Free", java.awt.Font.BOLD, 30));
  playButton.setForeground(new java.awt.Color(253, 233, 180));
  playButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
  playButton.setBorder(new EmptyBorder(10, 10, 10, 10));
  linkPlay(playButton);
  this.add(playButton);
 }

 public void linkPlay(JLabel jLabel) {
  jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
   @Override
   public void mouseClicked(java.awt.event.MouseEvent evt) {
    scoreFiles.write("current_score.txt", 0);
    scoreFiles.write("num_game.txt", 0);
    game.showView(new Play(game));
   }
  });
 }

 @Override
 protected void paintComponent(Graphics g) {
  g.drawImage(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg")).getImage(), 0, 0,
    getWidth(), getHeight(), this);
 }
}

class Game extends JFrame {
 JPanel viewPanel;

 public Game() {
  this.setTitle("Guess the Number");
  this.setPreferredSize(new Dimension(350, 660));
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.add(viewPanel, BorderLayout.CENTER);
  showView(new Menu(this));
  this.setVisible(true);
  this.pack();
  this.setResizable(false);
  this.setLocationRelativeTo(null);
 }

 public void showView(JPanel jPanel) {
  viewPanel.removeAll();
  viewPanel.add(jPanel, BorderLayout.CENTER);
  viewPanel.revalidate();
  viewPanel.repaint();
 }
}

class Main {
 public static void main(String[] args) {
  new Game();
 }
}