package rpg1;

import javax.swing.*;

public class Display {
    //obiekt Jframe
    private JFrame frame;

    private String Title;
    private int Width, Height;

    public Display( String Title, int Width, int Height){
        this.Height = Height;
        this.Width = Width;
        this.Title = Title;

        createDisplay();

    }
    private void createDisplay(){
        frame = new JFrame(Title);
        frame.setSize(Width,Height);
        //umozliwa zamkniecie programu(okna)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);// standardowo ma to na false

    }
}
