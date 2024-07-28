import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Maingame  implements ActionListener{
    Button[] b = new Button[9];
    Panel p = new Panel();
    Frame f = new Frame();
    Label l = new Label("Tic Tac Toe");
    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();
    checkstatus checker = new checkstatus();
    int cnt=0;
    Maingame()
    {
        f.setTitle("this is a example");
        f.setVisible(true);
        p.setLayout(new GridLayout(3,3));
        p.setPreferredSize(new Dimension(300,300));
        f.setLayout(new FlowLayout()); 
        f.add(l);
        for(int i=0;i<9;i++)
        {
            b[i] = new Button(); 
            p.add(b[i]);
            b[i].addActionListener(this);
        }

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.add(p);
    }
    public void endgame()
    {
        ArrayList<Integer> green = new ArrayList<>(checkstatus.trio);
        b[green.get(0)-49].setBackground(Color.GREEN); 
        b[green.get(1)-49].setBackground(Color.GREEN); 
        b[green.get(2)-1].setBackground(Color.GREEN);
        for(int i=0;i<9;i++)
        {
            b[i].removeActionListener(this);
        }
         
    }

    public void actionPerformed(ActionEvent ae)
    {
        tictacfinder obj = new tictacfinder();
        Button button = (Button) ae.getSource();
        
       if(cnt%2==0) {
            button.setLabel("X");
            l.setText("O's turn");
            player1.add(obj.find(button,b));
            if(checker.check(player1))
            {
                l.setText("x won the game");
                button.setBackground(Color.GREEN);
                endgame();
            }
            if (cnt >= 8 && !checker.check(player1) && !checker.check(player2)) {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.white);
                l.setText("Game tied");
                endgame();
            }
        }
        else{
             button.setLabel("O");
             l.setText("X's turn");
             player2.add(obj.find(button,b));
             if(checker.check(player2))
             {
                l.setText("o won the game");
                endgame();
             }
             if (cnt >= 8 && !checker.check(player1) && !checker.check(player2)) {
                button.setBackground(Color.BLACK);
                button.setBackground(Color.white);
                l.setText("Game tied");
                endgame();
            }
        }
        
        
        cnt++;
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.removeActionListener(this);
    }

    public static void main(String[] args) throws Exception {
        new Maingame();
        
    }
   
}
