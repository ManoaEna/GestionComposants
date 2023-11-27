import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCon extends JPanel
{
    private int tab;
    private int size=7;
    ArrayList<Condensateur> condensateur = new ArrayList<>();

    public PanelCon()
    {
    }

    public void buttonAdd(int tab)
    {
        this.tab=tab;
        this.setLayout(new GridLayout(size,size,5,5));
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                Condensateur boutonCon= new Condensateur();
                condensateur.add(boutonCon);
                this.add(boutonCon);
            }
        }
        revalidate();
        repaint();

    }
}
