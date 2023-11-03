package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CADTXT {

    public static class Produto {
        String codigo;
        char tipo;
        String descricao;
        int precoUnitario;
        String validade;

        public Produto(String codigo, char tipo, String descricao, int precoUnitario, String validade) {
            this.codigo = codigo;
            this.tipo = tipo;
            this.descricao = descricao;
            this.precoUnitario = precoUnitario;
            this.validade = validade;
        }
    }

     public static List<Produto> importarProdutos(String nomeArquivo) throws IOException {
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                try {
                    String codigo = linha.substring(0, 6).trim();
                    char tipo = linha.charAt(6);
                    String descricao = linha.substring(7, 29).trim();
                    int precoUnitario = Integer.parseInt(linha.substring(29, 36));
                    String validade = linha.substring(36);

                    produtos.add(new Produto(codigo, tipo, descricao, precoUnitario, validade));
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.err.println("Erro ao processar linha: " + linha);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
            e.printStackTrace();
        }

        return produtos;
    }

    public static void main(String[] args) {
        try {
            List<Produto> produtos = importarProdutos("C:\\Users\\xurtin\\Desktop\\builde\\Balanca_excecoes\\src\\main\\resources\\CADTXT.TXT");

            for (Produto produto : produtos) {
                System.out.println("Código: " + produto.codigo);
                System.out.println("Tipo: " + produto.tipo);
                System.out.println("Descrição: " + produto.descricao);
                System.out.println("Preço Unitário: " + produto.precoUnitario);
                System.out.println("Validade: " + produto.validade);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}