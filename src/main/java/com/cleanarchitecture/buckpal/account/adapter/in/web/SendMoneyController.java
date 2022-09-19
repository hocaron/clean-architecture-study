package com.cleanarchitecture.buckpal.account.adapter.in.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleanarchitecture.buckpal.account.application.port.in.SendMoneyCommand;
import com.cleanarchitecture.buckpal.account.application.port.in.SendMoneyUseCase;
import com.cleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.cleanarchitecture.buckpal.account.domain.Money;
import com.cleanarchitecture.buckpal.common.WebAdapter;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class SendMoneyController {

	private final SendMoneyUseCase sendMoneyUseCase;

	@PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
	public void sendMoney(
		@PathVariable("sourceAccountId") Long sourceAccountId,
		@PathVariable("targetAccountId") Long targetAccountId,
		@PathVariable("amount") Long amount) {

		SendMoneyCommand command = new SendMoneyCommand(
			new AccountId(sourceAccountId),
			new AccountId(targetAccountId),
			Money.of(amount));

		sendMoneyUseCase.sendMoney(command);
	}
}
