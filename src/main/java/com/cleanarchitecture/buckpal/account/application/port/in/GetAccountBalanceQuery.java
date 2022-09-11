package com.cleanarchitecture.buckpal.account.application.port.in;

import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.cleanarchitecture.buckpal.account.domain.Money;

public interface GetAccountBalanceQuery {

	Money getAccountBalance(AccountId accountId);
}
