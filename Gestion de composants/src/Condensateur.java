import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Condensateur extends Composants implements ActionListener {

    private String unité;
    private int valeur;
    private boolean end=false;
    Object[] montagePossible = { "THT", "SMD"};
    Object montage;
    Object[] unitéPossible = {"pF", "µF", "nF", "mF", "F"};
    Object unit;

    public Condensateur()
    {
        addActionListener(this);
    }

    public Condensateur(String référence, String typeDeMontage, String unité, int quantite, int stockMinimal, int valeur) {

        super(référence, typeDeMontage, quantite, stockMinimal);

        this.valeur=valeur;
        this.unité=unité;
    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object boutonSel =this.getSelectedObjects();
        Object[] possibleValues = { "Ajouter un composant", "Modifier un composant","Afficher composant", "Supprimer le composant" };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Que voulez-vous faire?", "Menu",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        if(selectedValue==null){selectedValue=-1;}

        switch (selectedValue.toString())
        {
            case "Ajouter un composant":

                try {
                    SetRef(JOptionPane.showInputDialog(null,"Quel est la référence?",0).toString());
                }catch (Exception ignored){}

                try {montage = JOptionPane.showInputDialog(null,
                        "Quel est le type de montage?", "",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        montagePossible, montagePossible[0]).toString();
                    SetType(montage.toString());
                }catch (Exception ignored){}

                try {SetQtt(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel quantitée?", 0)));
                }catch (Exception ignored){}

                try {SetStk(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel est le stock minimum?")));
                }catch (Exception ignored){}

                try {SetValC(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel est la valeur?")));
                }catch (Exception ignored){}

                try {unit = JOptionPane.showInputDialog(null,
                        "Quel est l'unité?", "",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        unitéPossible, unitéPossible[0]).toString();
                    SetUniC(unit.toString());
                }catch (Exception ignored){}

                SetTxt();
                break;

            case "Supprimer le composant":

                unité="";
                valeur=0;
                super.DelQtt();
                super.DelRef();
                super.DelStk();
                super.DelType();
                super.SetTxtVide();
                break;

            case "Afficher composant":

                try {JOptionPane.showMessageDialog( null, "ref:"+super.getRef()+"\n\nValeur"+valeur+" "+unité+"\n\nType de montage:"+super.getType()+"\n\nQuantité:"+super.getQtt()+"\n\nStock minimum:"+super.getStk(),
                        "Données", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ignored){}

                break;

            case "Modifier un composant":
                while (!end)
                {
                    try {Object[] choixPossibles = { "Modifier référence", "Modifier la valeur","Modifier le type de montage", "Modifier la quantité", "Modifier le stock minimum", "Terminer" };
                        Object choix = JOptionPane.showInputDialog(null,
                                "Que voulez-vous faire?", "",
                                JOptionPane.YES_OPTION, null,
                                choixPossibles, choixPossibles[0]);
                        switch (choix.toString())
                        {
                            case "Modifier référence":

                                try {SetRef(JOptionPane.showInputDialog(null,"Quel est la référence?",super.getRef()).toString());
                                    SetTxt();
                                }catch (Exception ignored){}
                                break;

                            case "Modifier le type de montage":

                                try {montage = JOptionPane.showInputDialog(null,
                                        "Quel est le type de montage?", "",
                                        JOptionPane.INFORMATION_MESSAGE, null,
                                        montagePossible, montagePossible[0]).toString();
                                    SetType(montage.toString());
                                }catch (Exception ignored){}
                                break;

                            case "Modifier la quantité":

                                try {SetQtt(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel quantitée?", super.getQtt())));
                                    SetTxt();
                                }catch (Exception ignored){}
                                break;

                            case "Modifier le stock minimum":

                                try {SetStk(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel est le stock minimal?",super.getStk())));
                                    SetTxt();
                                }catch (Exception ignored){}
                                break;

                            case "Modifier la valeur":

                                try {SetValC(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel est la valeur?",this.valeur)));
                                }catch (Exception ignored){}

                                try {unit = JOptionPane.showInputDialog(null,
                                        "Quel est l'unité?", "",
                                        JOptionPane.INFORMATION_MESSAGE, null,
                                        unitéPossible, unitéPossible[0]).toString();
                                    SetUniC(unit.toString());
                                }catch (Exception ignored){}
                                break;

                            case "Terminer":
                                end=true;
                                break;
                        }
                    }catch (Exception ignored){end=true;}

                }
                end=false;




                break;
            default:
                break;
        }
    }
    private void SetValC(int valeur) {this.valeur=valeur;}

    private void SetUniC(String uni) {this.unité=uni;}

    private void SetTxt()
    {
        this.setText(super.getRef()+" ["+super.getQtt()+"/"+super.getStk()+"]");
    }

}
