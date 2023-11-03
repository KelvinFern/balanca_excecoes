package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ITENS {

    public static class Produto {
        String codigoDepartamento;
        char tipoProduto;
        String codigoProduto;
        int precoUnitario;
        String validade;
        String descricao;
        String codigoExtra;
        String codigoImagem;
        String codigoNutricional;
        char impressaoValidade;
        char impressaoEmbalagem;
        String codigoFornecedor;
        String lote;
        String codigoEAN;
        char versaoPreco;
        String codigoSom;
        String codigoTara;
        String codigoFracionador;
        String codigoExtra1;
        String codigoExtra2;
        String codigoConservacao;
        String eanFornecedor;
        String percentualGlaciamento;
        String sequenciaDepartamentos;
        String descritivoLinha3;
        String descritivoLinha4;
        String codigoExtra3;
        String codigoExtra4;
        String codigoMidia;
        String determinacaoFinal;

        public Produto(String linha) throws NumberFormatException, StringIndexOutOfBoundsException {
            this.codigoDepartamento = linha.substring(0, 2);
            this.tipoProduto = linha.charAt(2);
            this.codigoProduto = linha.substring(3, 9);
        try{
            this.precoUnitario = Integer.parseInt(linha.substring(9, 15));
            this.validade = linha.substring(15, 18);
            this.descricao = linha.substring(18, 68).trim();
            this.codigoExtra = linha.substring(68, 74);
            this.codigoImagem = linha.substring(74, 78);
            this.codigoNutricional = linha.substring(78, 84);
            this.impressaoValidade = linha.charAt(84);
            this.impressaoEmbalagem = linha.charAt(85);
            this.codigoFornecedor = linha.substring(86, 90);
            this.lote = linha.substring(90, 102);
            this.codigoEAN = linha.substring(102, 113);
            this.versaoPreco = linha.charAt(113);
            this.codigoSom = linha.substring(114, 118);
            this.codigoTara = linha.substring(118, 122);
            this.codigoFracionador = linha.substring(122, 126);
            this.codigoExtra1 = linha.substring(126, 130);
            this.codigoExtra2 = linha.substring(130, 134);
            this.codigoConservacao = linha.substring(134, 138);
            this.eanFornecedor = linha.substring(138, 150);
            this.percentualGlaciamento = linha.substring(150, 156);
            this.sequenciaDepartamentos = linha.substring(156, 160);
            this.descritivoLinha3 = linha.substring(160, 195).trim();
            this.descritivoLinha4 = linha.substring(195, 230).trim();
            this.codigoExtra3 = linha.substring(230, 236);
            this.codigoExtra4 = linha.substring(236, 242);
            this.codigoMidia = linha.substring(242, 248);
            this.determinacaoFinal = linha.substring(248);

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
            List<Produto> produtos = importarProdutos("C:\\Users\\xurtin\\Desktop\\builde\\Balanca_excecoes\\src\\main\\resources\\ITENSMGV.TXT");

            for (Produto produto : produtos) {
                System.out.println("Código do Departamento: " + produto.codigoDepartamento);
                System.out.println("Tipo do Produto: " + produto.tipoProduto);
                System.out.println("Código do Produto: " + produto.codigoProduto);
                System.out.println("Preço Unitário: " + produto.precoUnitario);
                System.out.println("Validade: " + produto.validade);
                System.out.println("Descrição: " + produto.descricao);
                System.out.println("Código Extra: " + produto.codigoExtra);
                // Adicione aqui os outros campos conforme necessário

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
