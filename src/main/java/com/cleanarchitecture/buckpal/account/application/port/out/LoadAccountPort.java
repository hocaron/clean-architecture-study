package com.cleanarchitecture.buckpal.account.application.port.out;

import java.time.LocalDateTime;

import com.cleanarchitecture.buckpal.account.domain.Account;

public interface LoadAccountPort {

	Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
