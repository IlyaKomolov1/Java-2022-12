package ru.otus;

import api.AtmCassette;
import model.*;
import model.AtmCassetteImpl;
import model.AtmControllerImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.Denomination.*;

public class AtmDemo {
    public static void main(String[] args) {
        var cassetteFor50s = new AtmCassetteImpl(FIFTY,
                Arrays.asList(new BillImpl(FIFTY), new BillImpl(FIFTY), new BillImpl(FIFTY)));

        var cassetteFor100s = new AtmCassetteImpl(ONE_HUNDRED,
                Arrays.asList(new BillImpl(ONE_HUNDRED), new BillImpl(ONE_HUNDRED),
                        new BillImpl(ONE_HUNDRED)));

        var cassetteFor200s = new AtmCassetteImpl(TWO_HUNDRED,
                Arrays.asList(new BillImpl(TWO_HUNDRED), new BillImpl(TWO_HUNDRED)));

        var cassetteFor500s = new AtmCassetteImpl(FIVE_HUNDRED,
                Arrays.asList(new BillImpl(FIVE_HUNDRED), new BillImpl(FIVE_HUNDRED),
                        new BillImpl(FIVE_HUNDRED)));

        var cassetteFor1000s = new AtmCassetteImpl(ONE_THOUSAND,
                Arrays.asList(new BillImpl(ONE_THOUSAND), new BillImpl(ONE_THOUSAND),
                        new BillImpl(ONE_THOUSAND)));


        List<AtmCassette> cassettesVault = new ArrayList<>(Arrays.asList(cassetteFor50s, cassetteFor100s,
                cassetteFor200s, cassetteFor500s, cassetteFor1000s));

        var atmController = new AtmControllerImpl(cassettesVault);
        atmController.balance();
        System.out.println();

        atmController.deposit(Arrays.asList(new BillImpl(ONE_HUNDRED), new BillImpl(ONE_HUNDRED),
                new BillImpl(FIFTY), new BillImpl(FIFTY), new BillImpl(ONE_THOUSAND)));
        System.out.println();
        atmController.balance();
        System.out.println();

        atmController.deposit(Arrays.asList(new BillImpl(ONE_HUNDRED), new BillImpl(FIFTY)));
        System.out.println();
        atmController.balance();
        System.out.println();

        atmController.withdraw(5300);
        System.out.println();
        atmController.balance();
        System.out.println();

        atmController.withdraw(2000);
    }
}