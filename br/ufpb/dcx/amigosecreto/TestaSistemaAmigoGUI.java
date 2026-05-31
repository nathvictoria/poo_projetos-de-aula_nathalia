package br.ufpb.dcx.amigosecreto;

import javax.swing.JOptionPane;
import java.util.List;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        int quantMax = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima de amigos no sistema:"));

        for (int i = 0; i < quantMax; i++) {
            String nome = JOptionPane.showInputDialog("Nome do amigo " + (i + 1) + ":");
            String email = JOptionPane.showInputDialog("E-mail do amigo " + (i + 1) + ":");
            try {
                sistema.cadastraAmigo(nome, email);
            } catch (AmigoJaExisteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                i--; 
            }
        }

        for (int i = 0; i < quantMax; i++) {
            String emailDono = JOptionPane.showInputDialog("E-mail do participante:");
            String emailSorteado = JOptionPane.showInputDialog("E-mail do Amigo Secreto Sorteado:");
            try {
                sistema.configuraAmigoSecretoDe(emailDono, emailSorteado);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                i--; 
            }
        }

        String texto = JOptionPane.showInputDialog("Texto da mensagem para todos:");
        String remetente = JOptionPane.showInputDialog("E-mail do remetente:");
        int respAnonima = JOptionPane.showConfirmDialog(null, "Deseja que a mensagem seja anônima?", "Anonimato", JOptionPane.YES_NO_OPTION);
        boolean ehAnonima = (respAnonima == JOptionPane.YES_OPTION);

        sistema.enviarMensagemParaTodos(texto, remetente, ehAnonima);
        
        JOptionPane.showMessageDialog(null, "Configurações concluídas com sucesso!");
    }
}
