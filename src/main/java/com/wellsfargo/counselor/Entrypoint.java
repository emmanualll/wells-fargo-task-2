package com.wellsfargo.counselor.entity;

import java.util.ArrayList;
import java.util.List;

public class Entrypoint {
    public static void main(String[] args) {
        Advisor advisor = new Advisor(101, "Anagha Clement");
        Client client = new Client(201, "Emmanual Antony", advisor);
        Portfolio portfolio = new Portfolio(301, client);

        Security stock1 = new Security("AAPL", "Stock", 10, 150.0);
        Security stock2 = new Security("GOOGL", "Stock", 5, 2800.0);

        portfolio.addSecurity(stock1);
        portfolio.addSecurity(stock2);

        System.out.println("Advisor: " + advisor.getName());
        System.out.println("Client: " + client.getName());
        System.out.println("Portfolio ID: " + portfolio.getPortfolioId());

        for (Security s : portfolio.getSecurities()) {
            System.out.println(" - " + s.getSymbol() + ": " + s.getQuantity() + " units at $" + s.getPrice() + " each");
        }
    }

    public static class Portfolio {
        private int portfolioId;
        private Client client;
        private List<Security> securities;

        public Portfolio(int portfolioId, Client client) {
            this.portfolioId = portfolioId;
            this.client = client;
            this.securities = new ArrayList<>();
        }

        public void addSecurity(Security security) {
            securities.add(security);
        }

        public List<Security> getSecurities() {
            return securities;
        }

        public int getPortfolioId() {
            return portfolioId;
        }

        public Client getClient() {
            return client;
        }
    }

    public static class Security {
        private String symbol;
        private String type;
        private int quantity;
        private double price;

        public Security(String symbol, String type, int quantity, double price) {
            this.symbol = symbol;
            this.type = type;
            this.quantity = quantity;
            this.price = price;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getType() {
            return type;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public double getTotalValue() {
            return quantity * price;
        }
    }

    public static class Client {
        private int clientId;
        private String name;
        private Advisor advisor;

        public Client(int clientId, String name, Advisor advisor) {
            this.clientId = clientId;
            this.name = name;
            this.advisor = advisor;
        }

        public int getClientId() {
            return clientId;
        }

        public String getName() {
            return name;
        }

        public Advisor getAdvisor() {
            return advisor;
        }
    }

    public static class Advisor {
        private int advisorId;
        private String name;

        public Advisor(int advisorId, String name) {
            this.advisorId = advisorId;
            this.name = name;
        }

        public int getAdvisorId() {
            return advisorId;
        }

        public String getName() {
            return name;
        }
    }
}
