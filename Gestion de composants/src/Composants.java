import javax.swing.*;

public class Composants extends JButton
{
    private String référence;
    private String montage;
    private int quantité;
    private int stockMin;

    public Composants()
    {
        super();
    }
    public Composants(String référence, String montage, int quantité, int stockMin)
    {
        this.référence=référence;
        this.montage=montage;
        this.quantité=quantité;
        this.stockMin=stockMin;
    }
    protected void SetRef(String ref)
    {
        this.référence=ref;
    }
    protected String getRef() {return référence;}
    protected void DelRef(){this.référence=null;}

    protected void SetType(String type)
    {
        this.montage=type;
    }
    protected String getType(){return montage;}
    protected void DelType(){this.montage=null;}

    protected void SetQtt(int quantite)
    {
        this.quantité=quantite;
    }
    protected int getQtt() {return quantité;}
    protected void DelQtt(){this.quantité=0;}

    protected void SetStk(int stock)
    {
        this.stockMin=stock;
    }
    protected int getStk() {return stockMin;}
    protected void DelStk(){this.stockMin=0;}

    protected void SetTxtVide()
    {
        this.setText(" ");
    }
}
