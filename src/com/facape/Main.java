package com.facape;

import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Vertice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Aresta> arestas = new ArrayList<Aresta>();
        HashMap<Aresta, Integer> distancias = new HashMap<Aresta, Integer>();

        System.out.println("Endereco: ");
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String caminho = br.readLine();

        ConstruGraf cg = new ConstruGraf(caminho);

        arestas = cg.getGrafo().getArestas();
        List<Vertice> vertices = cg.getGrafo().getVertices();

        System.out.println(cg.matrizToString());
        for(Aresta a : arestas){
            System.out.println("Aresta " + a.getV1() + " - " + a.getV2() + " -> " + a.getPeso());
        }

        Dijkstra dijkstra = new Dijkstra(cg.getGrafo());

        //vertice fonte
        dijkstra.run(vertices.get(0));

        //coloca o vertice destino como parametro
        LinkedList<Vertice> menorCaminho = dijkstra.getCaminho(vertices.get(3));
        System.out.println();
        System.out.print("Caminho: ");
        for(Vertice vertice : menorCaminho){
            System.out.print("-> " + vertice);
        }
    }
}
