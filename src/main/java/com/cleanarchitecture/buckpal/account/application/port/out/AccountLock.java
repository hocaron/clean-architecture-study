package com.cleanarchitecture.buckpal.account.application.port.out;

import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;

public interface AccountLock {

	void lockAccount(AccountId accountId);

	void releaseAccount(AccountId accountId);
}