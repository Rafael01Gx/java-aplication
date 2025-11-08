package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.config.ClientHttpConfiguration;


public class ObterCepCommand implements Command {
    @Override
    public void execute() {
        ClientHttpConfiguration clientHttpConfiguration = new ClientHttpConfiguration();
        // Aqui seria a implementação do método a ser executado.
    }
}
