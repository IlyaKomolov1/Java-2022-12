package model;

import api.AtmCassette;
import api.AtmController;
import api.Bill;
import command.BalanceCommand;
import command.DepositCommand;
import command.WithdrawCommand;
import exception.NotEnoughMoneyException;

import java.util.List;

public class AtmControllerImpl implements AtmController {
    private final List<AtmCassette> cassettesVault;

    public AtmControllerImpl(List<AtmCassette> cassettesVault) {
        this.cassettesVault = cassettesVault;
    }

    @Override
    public void withdraw(int amount) {
        var withdrawCommand = new WithdrawCommand(amount, cassettesVault);
        try {
            withdrawCommand.execute();
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(List<Bill> bills) {
        var depositCommand = new DepositCommand(bills, cassettesVault);
        depositCommand.execute();
    }

    @Override
    public void balance() {
        var balanceCommand = new BalanceCommand(cassettesVault);
        balanceCommand.execute();
    }
}