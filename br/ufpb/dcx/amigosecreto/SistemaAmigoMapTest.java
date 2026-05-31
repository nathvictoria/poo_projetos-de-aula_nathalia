package br.ufpb.dcx.amigosecreto;

import java.util.List;

public class SistemaAmigoMapTest {
    public static void main(String[] args) {
        SistemaAmigoMap sistemaMap = new SistemaAmigoMap();

        try {
            sistemaMap.cadastraAmigo("Carlos", "carlos@dcx.ufpb.br");
            sistemaMap.cadastraAmigo("Ana", "ana@dcx.ufpb.br");

            sistemaMap.configuraAmigoSecretoDe("carlos@dcx.ufpb.br", "ana@dcx.ufpb.br");
            sistemaMap.configuraAmigoSecretoDe("ana@dcx.ufpb.br", "carlos@dcx.ufpb.br");

            sistemaMap.enviarMensagemParaAlguem("Tirei você!", "carlos@dcx.ufpb.br", "ana@dcx.ufpb.br", true);
            sistemaMap.enviarMensagemParaTodos("Feliz Amigo Secreto a todos!", "ana@dcx.ufpb.br", false);

            System.out.println("--- Teste de Mensagens de SistemaAmigoMap ---");
            List<Mensagem> todas = sistemaMap.pesquisaTodasAsMensagens();
            for (Mensagem m : todas) {
                System.out.println(m.getTextoCompletoAExibir());
            }

            System.out.println("\nAmigo secreto de Carlos: " + sistemaMap.pesquisaAmigoSecretoDe("carlos@dcx.ufpb.br"));

        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println("Erro durante os testes do Map: " + e.getMessage());
        }
    }
}
