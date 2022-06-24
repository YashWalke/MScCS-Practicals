// Tetris.java

import ch.aplu.jgamegrid.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

public class Tetris extends JFrame
{
  // ------------- Inner class MyActListener
  private class MyActListener implements GGActListener
  {
    public void act()
    {
      removeFilledLine();
  
      switch (gameGrid1.getKeyCode())
      {
        case KeyEvent.VK_UP:
          tetromino.rotate();
          break;
        case KeyEvent.VK_LEFT:
          tetromino.left();
          break;
        case KeyEvent.VK_RIGHT:
          tetromino.right();
          break;
        case KeyEvent.VK_DOWN:
          tetromino.drop();
          break;
        default:
          return;
      }
    }
  }

  public Tetris()
  {
    initComponents();
    gameGrid1.addActListener(new MyActListener());
    gameGrid1.setSimulationPeriod(100);
    tetromino = createRandomTetromino();
    gameGrid1.addActor(tetromino, new Location(3, 0));
    gameGrid1.doRun();
    // Do not lose keyboard focus when clicking this window
    gameGrid2.setFocusable(false);
    setTitle("JGameGrid Tetris V1.0");
    score = 0;
    showScore(score);
    slowDown = 5;
  }

  Tetromino createRandomTetromino()
  {
    if (tPreview !=  null)
      tPreview.removeSelf();

    Tetromino t = null;
    int rnd = (int)(Math.random() * 7);
    switch (rnd)
    {
      case 0:
        t = new I(this);
        tPreview = new I(this);
        break;
      case 1:
        t = new J(this);
        tPreview = new J(this);
        break;
      case 2:
        t = new L(this);
        tPreview = new L(this);
        break;
      case 3:
        t = new O(this);
        tPreview = new O(this);
        break;
      case 4:
        t = new S(this);
        tPreview = new S(this);
        break;
      case 5:
        t = new T(this);
        tPreview = new T(this);
        break;
      case 6:
        t = new Z(this);
        tPreview = new Z(this);
        break;
    }
    // Show preview tetromino
    tPreview.display(gameGrid2, new Location(2, 1));

    t.setSlowDown(slowDown);
    return t;
  }

  void setCurrentTetromino(Tetromino t)
  {
    tetromino = t;
  }


  private void removeFilledLine()
  {
    for (int y = 0; y < gameGrid1.nbVertCells; y++)
    {
      boolean isLineComplete = true;
      TetroBlock[] blocks = new TetroBlock[gameGrid1.nbHorzCells];   // One line
      for (int x = 0; x < gameGrid1.nbHorzCells; x++)
      {
        blocks[x] =
          (TetroBlock)gameGrid1.getOneActorAt(new Location(x, y), TetroBlock.class);
        if (blocks[x] == null)
        {
          isLineComplete = false;
          break;
        }
      }
      if (isLineComplete)
      {
        for (int x = 0; x < gameGrid1.nbHorzCells; x++)
          gameGrid1.removeActor(blocks[x]);
        ArrayList<Actor> allBlocks = gameGrid1.getActors(TetroBlock.class);
        for (Actor a : allBlocks)
        {
          int z = a.getY();
          if (z < y)
            a.setY(z + 1);
        }
        gameGrid1.refresh();
        score++;
        showScore(score);
        // Set speed of tetrominos
        if (score > 10)
          slowDown = 4;
        if (score > 20)
          slowDown = 3;
        if (score > 30)
          slowDown = 2;
        if (score > 40)
          slowDown = 1;
        if (score > 50)
          slowDown = 0;
      }
    }
  }

  private void showScore(final int score)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        scoreText.setText(score + " points");
      }
    });

  }
  
  void gameOver()
  {
     gameGrid1.addActor(new Actor("sprites/gameover.gif"), new Location(5, 5));
     gameGrid1.doPause();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    gameGrid2 = new ch.aplu.jgamegrid.GameGrid();
    startBtn = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    gameGrid1 = new ch.aplu.jgamegrid.GameGrid();
    jPanel3 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jPanel4 = new javax.swing.JPanel();
    scoreText = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Next Tetromino"));

    gameGrid2.setCellSize(28);
    gameGrid2.setNbHorzCells(6);
    gameGrid2.setNbVertCells(4);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addComponent(gameGrid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(28, 28, 28))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(gameGrid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(20, Short.MAX_VALUE))
    );

    startBtn.setText("Start");
    startBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        startBtnActionPerformed(evt);
      }
    });

    jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    gameGrid1.setCellSize(28);
    gameGrid1.setGridColor(new java.awt.Color(255, 3, 0));
    gameGrid1.setNbVertCells(18);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(gameGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(gameGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Instructions"));

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    jTextArea1.setBackground(new java.awt.Color(102, 255, 255));
    jTextArea1.setColumns(20);
    jTextArea1.setEditable(false);
    jTextArea1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
    jTextArea1.setRows(5);
    jTextArea1.setText(" Welcome to the JGameGrid Tetris! \n\n Cursor keys:\n    Left/right:  Move tetromino\n    Up:  Rotate tetromino\n    Down:  Drop tetromino\n  \n When a  line  is complete, it is removed \n and you earn one point, but the speed\n of  the tetrominos  increases  more and\n more...\n       \n       Good luck!");
    jTextArea1.setDisabledTextColor(new java.awt.Color(102, 102, 255));
    jTextArea1.setFocusable(false);
    jTextArea1.setRequestFocusEnabled(false);
    jScrollPane1.setViewportView(jTextArea1);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(12, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Score"));

    scoreText.setBackground(new java.awt.Color(255, 102, 102));
    scoreText.setEditable(false);
    scoreText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    scoreText.setText("0");
    scoreText.setAutoscrolls(false);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addComponent(scoreText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(24, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addComponent(scoreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
              .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(startBtn)
            .addGap(94, 94, 94))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(startBtn)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void startBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startBtnActionPerformed
  {//GEN-HEADEREND:event_startBtnActionPerformed
    gameGrid1.doPause();
    gameGrid1.removeAllActors();
    gameGrid2.removeAllActors();
    gameGrid1.refresh();
    gameGrid2.refresh();
    gameGrid2.delay(2000);
    tetromino = createRandomTetromino();
    gameGrid1.addActor(tetromino, new Location(3, 0));
    gameGrid1.doRun();
    gameGrid1.requestFocus();
    score = 0;
    showScore(score);
    slowDown = 5;
  }//GEN-LAST:event_startBtnActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Tetris().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private ch.aplu.jgamegrid.GameGrid gameGrid1;
  private ch.aplu.jgamegrid.GameGrid gameGrid2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField scoreText;
  private javax.swing.JButton startBtn;
  // End of variables declaration//GEN-END:variables
  private Tetromino tetromino = null;  // Currently active tetromino
  private Tetromino tPreview = null;   // tetromino in preview window
  private int score = 0;
  private int slowDown = 5;
}