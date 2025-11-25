package br.com.henrique.cadastro.repository;

import br.com.henrique.cadastro.model.Cliente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ClienteRepository {

    private Cliente cliente;

    public void cadastrar(){
        // Obter o caminho para o arquivo
        Path arquivo = Path.of("C:\\Users\\25204217\\ds1m\\clientes\\clientes.csv");

        try {
            Files.writeString(arquivo, "Senai Jandira\n" ,StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo");
            System.out.println(e.getMessage());
        }
    }

    public void listar(){
    }

    public void exibir(){

    }

    public void excluir(){


    }

    public void atualizar(){


    }

    public void sair(){


    }

}
