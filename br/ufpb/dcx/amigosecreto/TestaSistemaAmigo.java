package br.ufpb.dcx.amigosecreto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        try {
            sistema.cadastraAmigo("José", "jose@email.com");
            sistema.cadastraAmigo("Maria", "maria@email.com");

            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");

            sistema.enviarMensagemParaAlguem("Olá José, adivinhe quem é?", "maria@email.com", "jose@email.com", true);

            sistema.enviarMensagemParaTodos("Oi pessoal, bom amigo secreto!", "maria@email.com", false);

            System.out.println("--- Mensagens Anônimas Encontradas ---");
            List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();
            for (Mensagem m : anonimas) {
                System.out.println(m.getTextoCompletoAExibir());
            }

            String emailSorteado = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if (emailSorteado.equalsIgnoreCase("maria@email.com")) {
                System.out.println("Ok, correspondência correta!");
            } else {
                System.out.println("Erro: A correspondência falhou.");
            }

        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
