public class Main {

    // ============================================================
    //  MARKET CONTEXT  (update by hand, or wire to a live feed)
    // ============================================================
    static final double CURRENT_AVG_RATE = 0.066;                 // 6.60%
    static final String MARKET_NOTE = "CRE loans held by banks grew 3.1%";

    // ============================================================
    //  SHARED ASSUMPTIONS  (change these to shop different homes)
    // ============================================================
    static final double   HOME_PRICE    = 150_000;
    static final double[] DOWN_PAYMENTS = { 12_000, 20_000, 30_000 };
    static final double[] TERMS         = { 15, 30 };
    static final double   PMI_RATE      = 0.007;   // 0.7%/yr of loan when < 20% down

    public static void main(String[] args) {
        printMarketBanner();

        // ---- AUTOMATION: every term x every down payment ----
        for (double term : TERMS) {
            System.out.printf("%n%.0f year -- $%,.0fk -- variable down payments%n",
                    term, HOME_PRICE / 1000);
            for (double down : DOWN_PAYMENTS) {
                Mortgage m = new Mortgage(HOME_PRICE, down, CURRENT_AVG_RATE, term);
                m.setPmiAnnualRate(PMI_RATE);          // feature 1
                m.printSummary();
            }
        }

        fullCostDemo();        // feature 3: PITI + HOA
        amortizationDemo();    // feature 4: year-by-year schedule
        extraPaymentDemo();    // feature 2: extra principal
        affordabilityDemo();   // feature 5: 28/36 rule
        stressTestDemo();      // feature 6: rate stress test
    }

    // ---------- market banner ----------
    static void printMarketBanner() {
        System.out.println("====================================");
        System.out.println("        MORTGAGE SCENARIO REPORT");
        System.out.println("====================================");
        System.out.printf ("Current avg rate: %.2f%%%n", CURRENT_AVG_RATE * 100);
        System.out.println("Market note: " + MARKET_NOTE);
        System.out.println("====================================");
    }

    // ---------- feature 3: full monthly cost ----------
    static void fullCostDemo() {
        section("FULL MONTHLY COST (PITI + PMI + HOA) -- $150k, $20k down, 30yr");
        Mortgage m = new Mortgage(150_000, 20_000, CURRENT_AVG_RATE, 30);
        m.setPmiAnnualRate(PMI_RATE);
        m.setPropertyTaxAnnual(2_250);   // ~1.5% of home/yr -- varies a lot by area
        m.setInsuranceAnnual(1_400);
        m.setHoaMonthly(0);
        m.printSummary();
    }

    // ---------- feature 4: amortization ----------
    static void amortizationDemo() {
        section("AMORTIZATION (year by year) -- $150k, $30k down, 15yr");
        Mortgage m = new Mortgage(150_000, 30_000, CURRENT_AVG_RATE, 15);
        m.printYearlySchedule();
    }

    // ---------- feature 2: extra principal ----------
    static void extraPaymentDemo() {
        section("EXTRA PRINCIPAL -- $150k, $30k down, 30yr, +$200/mo");
        Mortgage m = new Mortgage(150_000, 30_000, CURRENT_AVG_RATE, 30);
        double[] base  = m.simulate(0);
        double[] extra = m.simulate(200);
        double monthsSaved   = base[0] - extra[0];
        double interestSaved = base[1] - extra[1];
        System.out.printf("Normal payoff:    %.0f months (%.1f years)%n", base[0], base[0] / 12);
        System.out.printf("With +$200/mo:    %.0f months (%.1f years)%n", extra[0], extra[0] / 12);
        System.out.printf("Time saved:       %.0f months (~%.1f years)%n", monthsSaved, monthsSaved / 12);
        System.out.printf("Interest saved:   $%,.2f%n", interestSaved);
    }

    // ---------- feature 5: affordability ----------
    static void affordabilityDemo() {
        section("AFFORDABILITY (28/36 rule)");
        double income = 6_000;   // gross monthly
        double debts  = 500;     // car, student loans, cards, etc.
        double maxPay = maxAffordablePayment(income, debts);
        double price  = affordableHomePrice(maxPay, CURRENT_AVG_RATE, 30, 0.20);
        System.out.printf("Gross monthly income: $%,.2f%n", income);
        System.out.printf("Other monthly debts:  $%,.2f%n", debts);
        System.out.printf("Max housing payment:  $%,.2f%n", maxPay);
        System.out.printf("~Home price you can target: $%,.2f  (30yr, 20%% down)%n", price);
    }

    // ---------- feature 6: rate stress test ----------
    static void stressTestDemo() {
        section("RATE STRESS TEST -- $150k, $30k down, 30yr");
        double[] shifts = { -0.005, 0.0, 0.005 };
        for (double s : shifts) {
            Mortgage m = new Mortgage(150_000, 30_000, CURRENT_AVG_RATE + s, 30);
            System.out.printf("Rate %.3f%%  ->  $%,.2f / mo%n",
                    m.getAnnualRate() * 100, m.monthlyPayment());
        }
    }

    // ---------- affordability helpers ----------
    static double maxAffordablePayment(double grossMonthlyIncome, double otherMonthlyDebts) {
        double frontEnd = grossMonthlyIncome * 0.28;                    // housing <= 28%
        double backEnd  = grossMonthlyIncome * 0.36 - otherMonthlyDebts; // all debt <= 36%
        return Math.min(frontEnd, backEnd);
    }

    static double affordableHomePrice(double payment, double annualRate,
                                      double termYears, double downPct) {
        double r = annualRate / 12.0;
        int n = (int) Math.round(termYears * 12);
        double g = Math.pow(1 + r, n);
        double loan = payment * (g - 1) / (r * g);
        return loan / (1 - downPct);
    }

    static void section(String title) {
        System.out.println();
        System.out.println("====================================");
        System.out.println(title);
        System.out.println("====================================");
    }
}


class Mortgage {

    // ----- core inputs -----
    private double homePrice;
    private double downPayment;
    private double annualRate;   // 0.066 = 6.6%
    private double termYears;

    // ----- optional carrying costs (default 0 => hidden) -----
    private double propertyTaxAnnual;
    private double insuranceAnnual;
    private double hoaMonthly;
    private double pmiAnnualRate;   // e.g. 0.007, only applied when < 20% down

    public Mortgage(double homePrice, double downPayment, double annualRate, double termYears) {
        this.homePrice = homePrice;
        this.downPayment = downPayment;
        this.annualRate = annualRate;
        this.termYears = termYears;
    }

    // ----- derived values -----
    public double loanAmount()          { return homePrice - downPayment; }
    public int    numPayments()         { return (int) Math.round(termYears * 12); }
    public double monthlyRate()         { return annualRate / 12.0; }
    public double downPaymentPercent()  { return downPayment / homePrice; }

    // ----- core payment: M = P*r*(1+r)^n / ((1+r)^n - 1) -----
    public double monthlyPayment() {
        double r = monthlyRate();
        int n = numPayments();
        double p = loanAmount();
        if (r == 0) return p / n;
        double g = Math.pow(1 + r, n);
        return p * r * g / (g - 1);
    }

    public double totalPaid()     { return monthlyPayment() * numPayments(); }
    public double totalInterest() { return totalPaid() - loanAmount(); }

    // ----- feature 1: PMI -----
    public boolean pmiRequired() { return downPaymentPercent() < 0.20 && pmiAnnualRate > 0; }

    public double monthlyPmi() {
        return pmiRequired() ? loanAmount() * pmiAnnualRate / 12.0 : 0;
    }

    // months of standard payments until balance reaches 80% of home price (PMI can drop)
    public int monthsUntilPmiEnds() {
        double balance = loanAmount();
        double r = monthlyRate();
        double pay = monthlyPayment();
        double target = homePrice * 0.80;
        int month = 0;
        while (balance > target && month < numPayments()) {
            month++;
            double interest = balance * r;
            balance -= (pay - interest);
        }
        return month;
    }

    // ----- feature 3: PITI + HOA -----
    public double monthlyTax()       { return propertyTaxAnnual / 12.0; }
    public double monthlyInsurance() { return insuranceAnnual / 12.0; }
    public double fullMonthlyCost() {
        return monthlyPayment() + monthlyPmi() + monthlyTax() + monthlyInsurance() + hoaMonthly;
    }

    // ----- feature 2 + 4: month-by-month simulation with optional extra principal -----
    // returns { monthsToPayoff, totalInterestPaid }
    public double[] simulate(double extraMonthly) {
        double balance = loanAmount();
        double r = monthlyRate();
        double pay = monthlyPayment();
        double totalInterest = 0;
        int month = 0;
        while (balance > 0.005 && month < 100_000) {
            month++;
            double interest = balance * r;
            double principal = pay - interest + extraMonthly;
            if (principal > balance) principal = balance;
            balance -= principal;
            totalInterest += interest;
        }
        return new double[]{ month, totalInterest };
    }

    public void printYearlySchedule() {
        double balance = loanAmount();
        double r = monthlyRate();
        double pay = monthlyPayment();
        System.out.printf("%-6s %14s %14s %15s%n", "Year", "Principal", "Interest", "Balance");
        int total = numPayments(), month = 0, year = 0;
        while (month < total && balance > 0.005) {
            year++;
            double yearP = 0, yearI = 0;
            for (int i = 0; i < 12 && month < total && balance > 0.005; i++) {
                month++;
                double interest = balance * r;
                double principal = pay - interest;
                if (principal > balance) principal = balance;
                balance -= principal;
                yearP += principal;
                yearI += interest;
            }
            System.out.printf("%-6d $%,12.2f $%,12.2f $%,13.2f%n", year, yearP, yearI, balance);
        }
    }

    // ----- the scenario block (matches your format, plus PMI/PITI when set) -----
    public void printSummary() {
        System.out.println("----------------------------------");
        System.out.printf("Home price:      $%,.2f%n", homePrice);
        System.out.printf("Down payment:    $%,.2f (%.1f%%)%n", downPayment, downPaymentPercent() * 100);
        System.out.printf("Loan amount:     $%,.2f%n", loanAmount());
        System.out.printf("Rate:            %.3f%%%n", annualRate * 100);
        System.out.printf("Term:            %.0f years%n", termYears);
        System.out.println("-----------------------------------");
        System.out.printf("Monthly (P&I):   $%,.2f%n", monthlyPayment());

        boolean extras = pmiRequired() || monthlyTax() > 0 || monthlyInsurance() > 0 || hoaMonthly > 0;
        if (pmiRequired())          System.out.printf("PMI:             $%,.2f%n", monthlyPmi());
        if (monthlyTax() > 0)       System.out.printf("Property tax:    $%,.2f%n", monthlyTax());
        if (monthlyInsurance() > 0) System.out.printf("Insurance:       $%,.2f%n", monthlyInsurance());
        if (hoaMonthly > 0)         System.out.printf("HOA:             $%,.2f%n", hoaMonthly);
        if (extras)                 System.out.printf("Full monthly:    $%,.2f%n", fullMonthlyCost());

        System.out.println("-----------------------------------");
        System.out.printf("Total paid:      $%,.2f%n", totalPaid());
        System.out.printf("Total interest:  $%,.2f%n", totalInterest());
        if (pmiRequired()) {
            int drop = monthsUntilPmiEnds();
            System.out.printf("PMI ends ~month %d  (~$%,.2f paid in PMI)%n", drop, monthlyPmi() * drop);
        }
        System.out.println("-----------------------------------");
    }

    // ----- getters / setters -----
    public double getHomePrice()   { return homePrice; }
    public double getDownPayment() { return downPayment; }
    public double getAnnualRate()  { return annualRate; }
    public double getTermYears()   { return termYears; }

    public void setHomePrice(double v)         { this.homePrice = v; }
    public void setDownPayment(double v)       { this.downPayment = v; }
    public void setAnnualRate(double v)        { this.annualRate = v; }
    public void setTermYears(double v)         { this.termYears = v; }
    public void setPropertyTaxAnnual(double v) { this.propertyTaxAnnual = v; }
    public void setInsuranceAnnual(double v)   { this.insuranceAnnual = v; }
    public void setHoaMonthly(double v)        { this.hoaMonthly = v; }
    public void setPmiAnnualRate(double v)     { this.pmiAnnualRate = v; }
}