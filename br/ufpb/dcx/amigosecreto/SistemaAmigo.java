package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo() {
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                throw new AmigoJaExisteException("Amigo com e-mail " + emailAmigo + " já está cadastrado.");
            }
        }
        amigos.add(new Amigo(nomeAmigo, emailAmigo));
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                return a;
            }
        }
        throw new AmigoInexistenteException("Nenhum amigo encontrado com o e-mail: " + emailAmigo);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        pessoa.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        String sorteado = pessoa.getEmailAmigoSorteado();
        if (sorteado == null || sorteado.trim().isEmpty()) {
            throw new AmigoNaoSorteadoException("O amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
        }
        return sorteado;
    }
}
