import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSC extends JPanel
{
    private int tab;
    private int size=7;
    ArrayList<Semi_Conducteur> semi_conducteurs = new ArrayList<>();

    public PanelSC()
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
                Semi_Conducteur boutonSC= new Semi_Conducteur();
                semi_conducteurs.add(boutonSC);
                this.add(boutonSC);
            }
        }
        revalidate();
        repaint();

    }

}
