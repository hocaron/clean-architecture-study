package com.cleanarchitecture.buckpal.account.application.port.in;

import com.cleanarchitecture.buckpal.account.domain.Account;
import com.cleanarchitecture.buckpal.account.domain.Money;

public interface GetAccountBalanceQuery {

	Money getAccountBalance(Account.AccountId accountId);
}