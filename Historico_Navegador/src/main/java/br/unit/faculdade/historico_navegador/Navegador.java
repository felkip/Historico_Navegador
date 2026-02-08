package br.unit.faculdade.historico_navegador;

public class Navegador {
    private String[] historico;
    private int topo;
    private String[] historicoAvancar;
    private int topoAvancar;

    public Navegador(int capacidade) {
        historico= new String[capacidade];
        topo = -1;
        historicoAvancar = new String[capacidade];
        topoAvancar = -1;
    }
    
    public void visitarPagina(String url) {
        if (isFull()) {
            throw new IllegalStateException("Limite alcançado ! Tem muitas páginas agora");
        }

        topo++;
        historico[topo] = url;
        topoAvancar = -1;
    }
    
    public String voltar() {
        if (isEmpty()) {
            throw new IllegalStateException("Sem páginas para retornar.");
        }
        String pagina_removida = historico[topo];
        historico[topo] = null;
        topo--;
        historicoAvancar[++topoAvancar] = pagina_removida;
        return historico[topo];
    }
    
    public String avancar(){
        if(topoAvancar < 0){
            throw new IllegalStateException("Sem páginas para avançar.");
        }
        
        String pagina_avancada= historicoAvancar[topoAvancar];
        historicoAvancar[topoAvancar--] = null;
        historico[++topo] = pagina_avancada;
        return pagina_avancada;
    }
    
    public String exibirHistorico() {
        if (isEmpty()) {
            throw new IllegalStateException("Sem páginas por enquanto");
        }

        return historico[topo];
    }
    
    public boolean isEmpty() {
        return topo == -1;
    }
    
    public boolean isFull() {
        return topo == historico.length - 1;
    }
}
