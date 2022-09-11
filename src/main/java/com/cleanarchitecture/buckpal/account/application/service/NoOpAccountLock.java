package com.cleanarchitecture.buckpal.account.application.service;

import org.springframework.stereotype.Component;

import com.cleanarchitecture.buckpal.account.application.port.out.AccountLock;
import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;

@Component
class NoOpAccountLock implements AccountLock {

	@Override
	public void lockAccount(AccountId accountId) {
		// do nothing
	}

	@Override
	public void releaseAccount(AccountId accountId) {
		// do nothing
	}
}
