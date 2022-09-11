package com.cleanarchitecture.buckpal.account.application.port.in;

import javax.validation.constraints.NotNull;

import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.cleanarchitecture.buckpal.account.domain.Money;
import com.cleanarchitecture.buckpal.common.SelfValidating;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

	@NotNull
	AccountId sourceAccountId;

	@NotNull
	AccountId targetAccountId;

	@NotNull
	Money money;

	public SendMoneyCommand(
		AccountId sourceAccountId,
		AccountId targetAccountId,
		Money money) {
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.money = money;
		this.validateSelf();
	}
}
