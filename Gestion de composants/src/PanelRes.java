import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelRes extends JPanel
{
    private int tab;
    private int size=7;
    ArrayList<Resistances> resistances = new ArrayList<>();

    public PanelRes()
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
                Resistances boutonRes= new Resistances();
                resistances.add(boutonRes);
                this.add(boutonRes);
            }
        }
        revalidate();
        repaint();

    }
}
