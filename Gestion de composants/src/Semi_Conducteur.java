import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Semi_Conducteur extends Composants implements ActionListener {

    private String url;
    private boolean end=false;
    Object[] montagePossible = { "THT", "SMD"};
    Object montage;

    public Semi_Conducteur()
    {
        addActionListener(this);
    }

    public Semi_Conducteur(String reference, String typeDeMontage, String url, int quantite, int stockMinimal) {

        super(reference, typeDeMontage, quantite, stockMinimal);

        this.url=url;

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

                try {SetStk(Integer.parseInt(JOptionPane.showInputDialog(null,"Quel est le stock minimal?")));
                }catch (Exception ignored){}

                try {SetUrl(JOptionPane.showInputDialog(null,"Quel est l'url?").toString());
                }catch (Exception ignored){}

                SetTxt();
                break;

            case "Supprimer le composant":

                url="";
                super.DelQtt();
                super.DelRef();
                super.DelStk();
                super.DelType();
                super.SetTxtVide();
                break;

            case "Afficher composant":

                try {JOptionPane.showMessageDialog( null, "ref:"+super.getRef()+"\n\nType de montage:"+super.getType()+"\n\nQuantité:"+super.getQtt()+"\n\nStock minimum:"+super.getStk()+"\n\nUrl="+url,
                        "Données", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ignored){}

                break;

            case "Modifier un composant":
                while (!end)
                {
                    try {Object[] choixPossibles = { "Modifier référence", "Modifier le type de montage", "Modifier la quantité", "Modifier le stock minimum", "Modifier l'url", "Terminer" };
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

                            case "Modifier l'url":

                                try {SetUrl(JOptionPane.showInputDialog(null,"Quel est l'url?",this.url).toString());
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

    private void SetUrl(String url) {this.url=url;}

    private void SetTxt()
    {
        this.setText(super.getRef()+" ["+super.getQtt()+"/"+super.getStk()+"]");
    }


}
