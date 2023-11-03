package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PRODUTOS {

    public static class Produto {
        String codigoProduto;
        char flag;
        char tipo;
        String descricao;
        double precoUnitario;
        int validade1;
        char validade2;

        public Produto(String linha) throws NumberFormatException, StringIndexOutOfBoundsException {
            this.codigoProduto = linha.substring(0, 6);
            this.flag = linha.charAt(6);
            this.tipo = linha.charAt(7);
            this.descricao = linha.substring(8, 28).trim();
            
            try {
                this.precoUnitario = Double.parseDouble(linha.substring(28, 37).replace(",", "."));
                this.validade1 = Integer.parseInt(linha.substring(37, 42));
                this.validade2 = linha.charAt(42);
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                throw e; 
            }
        }
    }

    public static List<Produto> importarProdutos(String nomeArquivo) throws IOException {
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                try {
                    produtos.add(new Produto(linha));
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.err.println("Erro ao processar linha: " + linha);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            throw e;
        }

        return produtos;
    }

    public static void main(String[] args) {
        try {
            List<Produto> produtos = importarProdutos("C:\\Users\\xurtin\\Desktop\\builde\\Balanca_excecoes\\src\\main\\resources\\PRODUTOS.TXT");

            for (Produto produto : produtos) {
                System.out.println("Código do Produto: " + produto.codigoProduto);
                System.out.println("Flag: " + produto.flag);
                System.out.println("Tipo do Produto: " + produto.tipo);
                System.out.println("Descrição: " + produto.descricao);
                System.out.println("Preço Unitário: " + produto.precoUnitario);
                System.out.println("Validade 1: " + produto.validade1);
                System.out.println("Validade 2: " + produto.validade2);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
