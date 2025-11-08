package br.com.alura.screenmatch.service;

public class CommandExecutor {

    public void executeCommand(Command command){
        command.execute();
    }
}
