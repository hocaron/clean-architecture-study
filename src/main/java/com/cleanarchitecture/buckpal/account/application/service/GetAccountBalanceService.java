package com.cleanarchitecture.buckpal.account.application.service;

import java.time.LocalDateTime;

import com.cleanarchitecture.buckpal.account.application.port.in.GetAccountBalanceQuery;
import com.cleanarchitecture.buckpal.account.application.port.out.LoadAccountPort;
import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.cleanarchitecture.buckpal.account.domain.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

	private final LoadAccountPort loadAccountPort;

	@Override
	public Money getAccountBalance(AccountId accountId) {
		return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
			.calculateBalance();
	}
}
