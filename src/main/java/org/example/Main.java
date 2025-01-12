package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversionCurrency conversionCurrency = new ConversionCurrency();
        try {
            while(true){
                System.out.println("**********************************");
                System.out.println("Sea bienvenido/a al Conversor de Monedas :)");
                System.out.println("1) Dólar =>> Peso argentino");
                System.out.println("2) Peso argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real brasileño");
                System.out.println("4) Real brasileño =>> Dólar");
                System.out.println("5) Dólar =>> Peso colombiano");
                System.out.println("6) Peso colombiano =>> Dólar");
                System.out.println("7) Salir");
                System.out.println("Elija una opción válida:");
                System.out.println("**********************************");

                String answer = scanner.nextLine().trim();
                if(answer.equals("7")) {
                    break;
                }

                System.out.println("Ingrese el valor a convertir: ");
                String input = scanner.nextLine().trim();

                double amount;
                try {
                    amount = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un valor numérico válido.");
                    continue;
                }

                switch(answer){
                    case "1":
                        System.out.println(conversionCurrency.exchangeConverter("USD", "ARS", amount));
                        break;
                    case "2":
                        System.out.println(conversionCurrency.exchangeConverter("ARS", "USD", amount));
                        break;
                    case "3":
                        System.out.println(conversionCurrency.exchangeConverter("USD", "BRL", amount));
                        break;
                    case "4":
                        System.out.println(conversionCurrency.exchangeConverter("BRL", "USD", amount));
                        break;
                    case "5":
                        System.out.println(conversionCurrency.exchangeConverter("USD", "COP", amount));
                        break;
                    case "6":
                        System.out.println(conversionCurrency.exchangeConverter("COP", "USD", amount));
                        break;
                    default:
                        System.out.println("Escoja una opción válida.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}