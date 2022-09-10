package br.com.cronopedia.paginasapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.cronopedia.paginasapi.model.Pagina;

public class PaginaRepository {
    private static PaginaRepository repo;
    private static int paginaDoDia;
    protected static Random random = new Random();
    private ArrayList<Pagina> paginas;

    private PaginaRepository() {
        this.paginas = new ArrayList<>();
    }

    public static void init() {
        if (PaginaRepository.repo == null) {
            PaginaRepository.repo = new PaginaRepository();

            PaginaRepository.add(new Pagina(
                    "Mochizuki Chiyome",
                    "Mariana Teixeira",
                    "A grande história de Mochizuki Chiyome.",
                    "<p>&nbsp;&nbsp;&nbsp; Chiyome, poeta e ensaísta japonesa, é uma das mulheres mais famosas do Japão. Ela também é uma das mais polêmicas. Alguns a elogiam por sua paixão e bravura, enquanto outros a criticam por suas visões sexistas e tratamento das mulheres. Independentemente disso, seu legado como uma devota budista e reformadora social continua a inspirar as pessoas hoje.</p><p>&nbsp;&nbsp;&nbsp; Chiyome nasceu em uma família rica em Kyoto em 1864. Seu pai era um samurai de alto escalão e sua mãe era filha de um prestigiosa família de comerciantes. No entanto, o pai de Chiyome salvou a família da pobreza vendendo espadas cerimoniais para outras famílias de samurais. Isso mostrou integridade em sua vida pessoal e profissional. Como resultado, ele ganhou riqueza e respeito dentro da sociedade. </p><p>&nbsp;&nbsp;&nbsp; Chiyome também recebeu alunos para ensiná-los a escrever e ler japonês. Ela forneceria comida e abrigo para esses alunos, que estavam desabrigados na época. Isso provou o quão altruísta ela era como mulher. Ela priorizou as necessidades dos outros sobre suas próprias necessidades e deu um exemplo para outras mulheres seguirem. Por meio desse serviço, ela demonstrou que as mulheres podem ser tão abnegadas quanto os homens quando necessário. </p><p>&nbsp;&nbsp;&nbsp; Chiyome também demonstrou esse altruísmo quando se casou com Tokugawa Nariyoshi em 1880. Ele era um príncipe de oito anos na época sem poder ou riqueza própria. Embora ele tenha se tornado o imperador Taisho do Japão, este casamento solidificou a reputação de Chiyome como uma esposa e mãe dedicada. Ela inspirou outros através de sua fé, coragem e lealdade. </p><p>&nbsp;&nbsp;&nbsp; Muitas pessoas consideram Chiyome uma das maiores mulheres japonesas de todos os tempos devido à sua paixão e bravura. Ela demonstrou como o altruísmo pode ser masculino e feminino, cuidando dos outros primeiro e por último. Suas ações continuam a inspirar as pessoas hoje.</p>",
                    "Ninjas",
                    "https://www.swordsofnorthshire.com/image/catalog/articles/mochizuki%20chiyome/onna%20bugeisha.jpg"));

            PaginaRepository.add(new Pagina(
                    "Tecnologia assistida",
                    "Júlia das Neves",
                    "Veja como sistemas assistidos podem ajudar as pessoas com deficiências",
                    "<p>&nbsp;&nbsp;&nbsp; A deficiência é uma ausência de condição física, mental ou emocional normal. A deficiência é causada por nascimento, doença ou uma condição congênita ou adquirida. A deficiência pode ser causada por hormônios e nutrição nos estágios iniciais da vida, que afetam o desenvolvimento das habilidades físicas e mentais de uma pessoa. A deficiência afeta negativamente a maneira como as pessoas com deficiência vivem suas vidas; limita suas escolhas e restringe a maneira como interagem com o mundo. </p><p>&nbsp;&nbsp;&nbsp; Por exemplo, existem muitos sistemas para pessoas com deficiência, como rampas para cadeiras de rodas, material literário e educacional em Braille e videogames para deficientes. As rampas para cadeiras de rodas permitem que as pessoas que usam cadeiras de rodas tenham uma casa mais acessível. O material educacional em Braille ajuda as pessoas cegas a aprender por meio de sensações táteis. Jogos para pessoas com deficiência os ajudam a superar seus desafios de uma forma divertida.</p><p>&nbsp;&nbsp;&nbsp; Muitos especialistas acreditam que o desenvolvimento de tecnologia assistiva para pessoas com deficiência é ético. A tecnologia assistiva permite que os indivíduos participem da sociedade de maneira semelhante às pessoas com visão. Permite que eles acessem informações, cuidem de si mesmos e se comuniquem com os outros. Além disso, muitos acreditam que é ético ajudar pessoas com deficiência quando a natureza não lhes deu uma deficiência - como surdez ou cegueira em animais sem visão ou audição. Para ajudar essas pessoas com deficiência, há duas considerações principais que devem ser levadas em conta: acessibilidade e serviços assistivos. Acessibilidade é o projeto de sistemas para que possam ser usados ​​por todos os indivíduos com deficiência. Os serviços assistivos são os recursos disponibilizados pela sociedade para dar suporte às pessoas com deficiência, como centros de reabilitação, serviços médicos e opções de transporte. Sem esses recursos, é difícil para as pessoas com deficiência viver de forma independente; portanto, é necessário disponibilizar esses serviços a todos os indivíduos. </p><p>&nbsp;&nbsp;&nbsp; Embora existam muitos sistemas destinados a ajudar as pessoas com deficiência, muitos têm baixa qualidade e não são usados ​​por pessoas com deficiência. Por exemplo, rampas para cadeiras de rodas são úteis para pessoas com deficiência quando se deslocar de um local para outro não é um problema, mas raramente são usadas quando as escadas são um problema. Há também falta de acessibilidade nas escolas para alunos com deficiência; isso limita as oportunidades de aprendizado para alunos com deficiência e limita a quantidade de assistência que eles podem receber dos professores. Eventualmente, esses problemas afetarão a todos se esses problemas não forem resolvidos. </p><p>&nbsp;&nbsp;&nbsp; Serviços destinados a ajudar pessoas com deficiência precisam incluir várias necessidades, como cegueira ou perda auditiva, entre outras. As pessoas com deficiência devem ser capazes de participar plenamente da sociedade sem enfrentar barreiras que limitam sua independência e qualidade de vida. Além disso, a sociedade precisa fornecer acomodações e suportes adequados para que todos possam funcionar dentro de suas normas de acessibilidade e inclusão sem serem destacados por sua deficiência. </p><p>&nbsp;&nbsp;&nbsp; A deficiência - seja cegueira ou perda auditiva - é uma realidade que afeta parte da humanidade todos os dias. Não há uma resposta fácil para resolver esse problema; no entanto, existem muitos sistemas destinados a ajudar as pessoas com deficiência, se aplicados corretamente, mas poucos foram usados ​​de forma eficaz ainda. Até que a sociedade veja as mudanças na forma como trata os deficientes como desejáveis ​​em vez de debilitantes, nunca haverá verdadeira igualdade entre todos os seus membros, não importa o quanto tente.</p>",
                    "Deficiência",
                    "https://img.freepik.com/vetores-gratis/ilustracao-do-conceito-de-dia-para-deficientes-fisicos_114360-4075.jpg?w=2000"));

            PaginaRepository.add(new Pagina(
                    "Cogumelos e seus beneficios",
                    "Wilson da Silva",
                    "Os cogumelos azuis têm muitos usos; eles são comumente usados ​​na medicina tradicional ou como suplementos esportivos ou aditivos alimentares. No entanto, não há evidências científicas suficientes sobre os efeitos que esses cogumelos têm na saúde e no desempenho humano.",
                    "<p>Os cogumelos azuis são um tipo de cogumelo selvagem que cresce nas florestas da Europa, Ásia e América do Norte. As pessoas usam esses cogumelos para aumentar suas capacidades físicas e mentais. os atletas usam cogumelos azuis para aumentar sua resistência, diminuir o apetite e combater a fadiga. pacientes cardíacos usam cogumelos azuis para aliviar a ansiedade e melhorar a saúde do coração. o cogumelo da sauna é um auxiliar natural do sono usado para a cura física e mental.</p><p>&nbsp;&nbsp;&nbsp; Muitos atletas usam cogumelos azuis para melhorar seu desempenho. Estes cogumelos aceleram o metabolismo e promovem a perda de peso. Eles também fortalecem o sistema cardiovascular e melhoram a digestão. Além disso, aliviam a fadiga excessiva, estimulam o sistema imunológico e combatem distúrbios e doenças. Algumas pessoas também usaram cogumelos azuis como agente antidepressivo e anti-stress. No entanto, não há evidências suficientes para apoiar essas alegações. <br>Pacientes cardíacos usam cogumelos azuis para tratar pressão alta, ansiedade, palpitações e dores no peito. Eles fazem isso reduzindo a frequência cardíaca e a pressão arterial.</p><p>&nbsp;&nbsp;&nbsp; Além disso, esses cogumelos reduzem os espasmos nos músculos do coração, aumentam os níveis de oxigênio no sangue e reduzem a inflamação nas artérias. Muitas pessoas também usam esses cogumelos para diminuir os níveis de açúcar no sangue – o que é útil para pessoas com diabetes tipo 2. Um sedativo natural chamado cogumelo da sauna é usado para relaxamento físico e mental. </p><p>&nbsp;&nbsp;&nbsp; O cogumelo da sauna é um sedativo natural usado para relaxamento físico e mental. As pessoas usam este cogumelo para aliviar o estresse, promover o sono e fortalecer o sistema imunológico. Funciona aumentando o fluxo sanguíneo para certos órgãos enquanto acalma a tensão muscular. Os efeitos do cogumelo da sauna duram vários dias. Pesquisadores encontraram várias espécies do cogumelo da sauna na Europa, Ásia e América do Norte. Estes cogumelos são suportes lenhosos com base bulbosa que crescem em bétulas ou no solo. Suas cores variam do branco ao azul ou roxo. O fungo da salsicha é usado como iguaria alimentar em alguns países europeus.</p>",
                    "Cogumelos azuis",
                    "https://i.pinimg.com/originals/8d/11/c0/8d11c03cf91ee4a77502020c8aa62b6a.jpg"));

            PaginaRepository.add(new Pagina(
                    "Elon Musk",
                    "Juninho Portugal",
                    "Conheça a trajetória do homem mais rico do mundo.",
                    "Elon Musk (1971) é um empreendedor norte-americano de origem sul-africana. É cofundador e CEO da companhia Tesla Motors, pioneira na fabricação de carros elétricos. É o fundador e CEO da SpaceX, a primeira empresa a vender um voo comercial para a Lua. <br/> Elon Musk nasceu em Pretória, África do Sul, no dia 28 de junho de 1971. <br/> Ainda em 1995, Elon Musk fundou a Zip2 Corporation, uma empresa que fornecia conteúdos para jornais online que chegou a ter como clientes o Chicago Tribune e o New York Times. Na ocasião em que criou a empresa, o empreendedor trabalhava todos os dias e dormia no escritório. <br/> Em 1999, a Zip2 foi vendida para a Compaq, fabricante de computadores, por 370 milhões de dólares. Musk, que possuía uma participação de 7% na companhia, recebeu 22 milhões de dólares aos 28 anos. <br/> Logo em seguida, o empresário usou o dinheiro da venda da Zip2 e fundou a X.com, empresa de pagamentos e transferências financeiras. Em 2000, a X.com se fundiu com a Confiniti e deu origem ao PayPal, principal serviço de transferência de dinheiro online. <br/> Em 2002, a eBay comprou a PayPal por 1,5 bilhões de dólares. Com o valor arrecadado, Musk criou três novas empresas: a Tesla, a SpaceX e a Solar City.",
                    "tecnologia",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Elon_Musk_Royal_Society_%28crop2%29.jpg/1200px-Elon_Musk_Royal_Society_%28crop2%29.jpg"));


            paginaDoDia = random.nextInt(PaginaRepository.repo.paginas.size());
            ;
        }
    }

    // Adicionando uma nova página
    public static void add(Pagina pagina) {
        PaginaRepository.repo.paginas.add(pagina);
    }

    // Retornando todas as página
    public static List<Pagina> all() {
        return PaginaRepository.repo.paginas;
    }

    // Retornando a página com o ID solicitado
    public static Pagina getById(int id) {
        return PaginaRepository.repo.paginas.stream().filter((e) -> e.getId() == id).toList().get(0);
    }

    // Retornando as páginas que contém o assunto solicitado
    // Funcionamento: navega pelo array de páginas e adiciona na lista aquelas que
    // foi verificado o relacionamento com o assunto
    public static List<Pagina> getByAssunto(String assunto) {
        return PaginaRepository.repo.paginas.stream().filter((e) -> e.relacionadaRX(assunto)).toList();
    }

    // Alterando uma informação na página
    public static void update(int campo, String conteudo, int id) {
        switch (campo) {
            case 1:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).setTitulo(conteudo);
                break;
            case 2:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).setResumo(conteudo);
                break;
            case 3:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).setConteudo(conteudo);
                break;
            case 4:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).addAssunto(conteudo);
                break;
            case 5:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).removeAssunto(conteudo);
                break;
            case 6:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).addImagem(conteudo);
                break;
            case 7:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).removeImagem(conteudo);
                break;
            default:
                break;
        }
    }

    // Removendo a página com o ID informado
    public static void delete(int id) {
        PaginaRepository.repo.paginas
                .remove(PaginaRepository.repo.paginas.stream().filter((e) -> e.getId() == id).toList().get(0));
    }

    public static int getPaginaDoDia() {
        return paginaDoDia;
    }
}
