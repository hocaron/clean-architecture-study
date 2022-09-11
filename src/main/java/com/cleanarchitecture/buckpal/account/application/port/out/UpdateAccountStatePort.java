package com.cleanarchitecture.buckpal.account.application.port.out;

import com.cleanarchitecture.buckpal.account.domain.Account;

public interface UpdateAccountStatePort {

	void updateActivities(Account account);
}