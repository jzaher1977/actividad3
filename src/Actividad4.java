package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

//******************************************************************//
//**** Programa Realizado por Juan Antonio Flores Zaher Morales ****//
//******************************************************************//

class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Deck cartas = new Deck();

        System.out.println("\n");
        cartas.suflle();
        System.out.println("\n");
        cartas.head();
        System.out.println("\n");
        cartas.pick();
        System.out.println("\n");
        cartas.hand();
    }
    public static class Card {

        private String palo;
        private String color;
        private String valor;


        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String toString() {
            return "Palo: " + palo + " | " + "Color: " + color +
                    " | " + "Valor: " + valor;
        }

    }
    public static class Deck {
        private final String[] colorDeck = {"rojo", "negro"};
        private final String[] paloDeck = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        private final String[] valorDeck = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        private ArrayList<Card> deck;

        public Deck()
        {
            //****************************************//
            //       Creamos deck como Array          //
            //****************************************//

            deck = new ArrayList<Card>();

            // Agregamos todas las cartas al array de deck
            // Barremos los Deck en dos partes (color negro y rojo) para agregar todas las cartas al arreglo deck

            for (int palo = 0; palo < 2; palo++)
                for (int valor = 0; valor < valorDeck.length; valor++)
                    deck.add(new Card(paloDeck[palo], colorDeck[0], valorDeck[valor]));

            for (int palo = 2; palo < 4; palo++)
                for (int valor = 0; valor < valorDeck.length; valor++)
                    deck.add(new Card(paloDeck[palo], colorDeck[1], valorDeck[valor]));
        }

        //****************************************//
        // Métodos solicitados por la Actividad 4 //
        //****************************************//
        public void suflle() {
            Collections.shuffle(deck);
            System.out.println("Se mezcló todo el Deck.");

        }

        public void head() {
            System.out.println(deck.get(0));
            deck.remove(0);
            System.out.println("Quedan " + deck.size() + " cartas en el deck");
        }


        public void pick() {
            Random random = new Random();
            System.out.println(deck.get(random.nextInt(deck.size())));
            deck.remove(random.nextInt(deck.size()));
            System.out.println("Quedan " + deck.size() + " cartas en el deck");
        }

        public void hand() {
            for (int i = 0; i <= 4; i++) {
                System.out.println(deck.get(i));
            }
            for (int i = 0; i <= 4; i++) {
                deck.remove(i);
            }
            System.out.println("Quedan " + deck.size() + " cartas en el deck");
        }
    }

}