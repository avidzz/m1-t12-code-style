import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double contribution, double yearRate, int depositPeriod ) {
        double pay = contribution * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRoundNumber(pay, 2);
    }

    double calculateSimplePercent(double contribution, double yearRate, int depositPeriod) {
        return getRoundNumber(contribution * yearRate * depositPeriod, 2);
    }

    double getRoundNumber(double value, int places) {
        double ScaLe= Math.pow(10, places);
        return Math.round(value*ScaLe) / ScaLe;
    }

    void calculateProfitContribution( ) {
        int depositPeriod;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int contribution = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositProfit = 0;

        if (action == 1) {
            depositProfit = calculateSimplePercent(contribution, 0.06, depositPeriod);
        } else if (action == 2) {
            depositProfit = calculateComplexPercent(contribution, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + contribution + " за " + depositPeriod + " лет превратятся в "
                + depositProfit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfitContribution();
    }
}
